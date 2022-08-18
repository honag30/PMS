<%@ page import="fa.trainning.entities.Ticket" %>
<%@ page import="fa.trainning.services.TicketService" %>
<%@ page import="fa.trainning.entities.Trip" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.text.ParseException" %>
<%@ page import="fa.trainning.services.TripService" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>View All Trip</title>
</head>
<body>
<jsp:include page="../common-views/_navbar.jsp"/>
<div class="container-fluid">
    <div class="row flex-xl-nowrap">

        <jsp:include page="../common-views/_sidebar.jsp"/>

        <div class="col col-md-9 border-left " id="main">
            <%if (session.getAttribute("staff") != null) {%>
            <div class="mt-3">
                <h3 class="font-weight-bold">View All Trip</h3>
            </div>
            <hr class="divider" />

            <!-- Main Page -->
            <main class="col-md-9 ms-sm-auto col-lg-12 px-md-4 mr-5">
                <c:if test="${fn:length(listTrip) > 0}">
                    <div class="container mt-4">
                        <div class="filterable">
                            <div class="col-md-12 d-flex ">
                                <div  class="mr-auto"></div>

                                <button  type="button" id="myFilter" class="btn btn-xs btn-filter">
                                    <span class="fas fa-filter"></span> Filter: <span id="on">ON</span><span id="off">OFF</span>
                                </button>
                            </div>
                    <table class="table styled-table table-sortable" id="tripTable">
                        <thead>
                        <tr class="filters">
                            <th scope="col">
                                <input type="text" class="form-control" placeholder="ID" disabled>
                            </th>
                            <th scope="col">
                                <input type="text" class="form-control" placeholder="Destination" disabled>
                            </th>
                            <th scope="col">
                                <input type="text" class="form-control" placeholder="Departure Time" disabled>
                            </th>
                            <th scope="col">
                                <input type="text" class="form-control" placeholder="Driver" disabled>
                            </th>
                            <th scope="col">
                                <input type="text" class="form-control" placeholder="Car Type" disabled>
                            </th>
                            <th scope="col">
                                <input type="text" class="form-control" placeholder="Booked Ticket" disabled>
                            </th>
                            <th scope="col">Action</th>
                        </tr>
                        </thead>
                        <tbody id="myTable">

                            <%
                                List<Trip> listTripList = (ArrayList<Trip>)request.getAttribute("listTrip");
                                for(Trip listTrip:listTripList){
                            %>
                        <tr>
                            <td scope="row"><c:out value="<%=listTrip.getTripId()%>" /></td scope="row">
                            <td>
                                <a class="text-dark" href="${pageContext.request.contextPath}/ServletTripEdit?id=<c:out value="<%=listTrip.getTripId()%>" />">
                                    <c:out value="<%=listTrip.getDestination()%>" />
                                </a>
                            </td>

                            <td><c:out value="<%=listTrip.getDepartureTime()%>" /></td>
                            <td><c:out value="<%=listTrip.getDriver()%>" /></td>
                            <td><c:out value="<%=listTrip.getCarType()%>" /></td>

                            <%
                                Trip trip = (Trip) request.getAttribute("existingTicket");

                                TicketService ticketService = new TicketService();
                                long numberOfBooked = 0;
                                try {
                                    numberOfBooked = ticketService.getNumberOfBookedTicketService(listTrip.getTripId());
                                } catch (SQLException | ParseException | ClassNotFoundException throwables) {
                                    throwables.printStackTrace();
                                }

                            %>
                            <td><c:out value="<%=numberOfBooked%>" /></td>
                            <td>
                                <%if (session.getAttribute("staff") != null){%>
                                <a  href="${pageContext.request.contextPath}/ServletTripEdit?id=<c:out value="<%=listTrip.getTripId()%>" />"><i class="fa fa-pencil mr-3"></i></a>
                                <a onclick="return confirm('Are you sure you want to delete this item?');"
                                   href="${pageContext.request.contextPath}/ServletTripDelete?id=<c:out value="<%=listTrip.getTripId()%>" />" >
                                    <i class="fa fa-trash text-danger"></i>
                                </a>
                                <%}%>
                            </td>

                        </tr>
                    <%}%>

                    </tbody>
                    </table>
                            <div class="d-flex justify-content-end">
                                <p>Rows : <span id="rowcount"></span></p>
                            </div>

                        </div>
                    </div>

                    <div class="d-flex justify-content-start">
                        <ul class="pagination pager" id="myPager">
                                <%--all pager go here--%>
                        </ul>
                    </div>
                </c:if>
                <c:if test="${fn:length(listTrip) == 0}">
                    <div class="alert alert-warning text-center" role="alert">
                        There is no Trip!
                    </div>
                </c:if>
            </main>
            <%} else {%>
            <jsp:include page="../common-views/_not-allow.jsp"/>
            <%}%>
        </div>
    </div>
</div>
<footer class="footer">
    <jsp:include page="../common-views/_footer.jsp"/>
</footer>
</body>
</html>

<script>
        <%
            TripService tripService = null;

            tripService = new TripService();
            List<Trip> tripList = null;
            try {
                tripList = tripService.viewAllTripService();
            } catch (SQLException | ParseException e) {
                e.printStackTrace();
            }
            if (tripList != null) {
                for (Trip trip : tripList) {%>
        <%

                                TicketService ticketService = new TicketService();
                                long numberOfBooked = 0;
                                try {
                                    numberOfBooked = ticketService.getNumberOfBookedTicketService(trip.getTripId());
                                } catch (SQLException | ParseException | ClassNotFoundException throwables) {
                                    throwables.printStackTrace();
                                }

                            %>

                    var ctxP = document.getElementById("pieChart").getContext('2d');
                    var myPieChart = new Chart(ctxP, {
                        type: 'pie',
                        data: {
                            labels: [ "Booked","Maximum"],
                            datasets: [{
                                data: [
                                    <%=numberOfBooked%>,
                                    <%=trip.getMaximumOnlineTicketNumber()%>,
                                    console.log(<%=numberOfBooked%>)
                                ],
                                backgroundColor: ["#F7464A", "#46BFBD"],
                                hoverBackgroundColor: ["#FF5A5E", "#5AD3D1"]
                            }]
                        },
                        options: {
                            responsive: true
                        }
                    });

        <%
                }
            }
        %>
</script>

