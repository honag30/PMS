<%@ page import="java.sql.SQLException" %>
<%@ page import="fa.trainning.entities.Trip" %>
<%@ page import="fa.trainning.services.TripService" %>
<%@ page import="java.text.ParseException" %>
<%@ page import="fa.trainning.entities.BookingOffice" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>View All Booking Office</title>
    <style>
        .table{
            width: 100%;
        }
        th.id {
            width: 12%;
        }
    </style>
</head>
<body>
<jsp:include page="../common-views/_navbar.jsp"/>
<div class="container-fluid">
    <div class="row flex-xl-nowrap">
        <jsp:include page="../common-views/_sidebar.jsp"/>
        <div class="col col-md-9 border-left " id="main">
            <%if (session.getAttribute("staff") != null) {%>
            <div class="mt-3">
                <h3 class="font-weight-bold">View All Booking Office</h3>
            </div>
            <hr class="divider" />

            <!-- Main Page -->
            <main class="col-md-9 ms-sm-auto col-lg-12 px-md-4 mr-5">

                <c:if test="${fn:length(listBookingOffice) > 0}">
                <div class="container mt-4">
                    <div class="filterable">
                            <div class="col-md-12 d-flex ">
                                <div  class="mr-auto"></div>
                                <button  type="button" id="myFilter" class="btn btn-xs btn-filter">
                                    <span class="fas fa-filter"></span> Filter: <span id="on">ON</span><span id="off">OFF</span>
                                </button>
                            </div>
                        <table class="table styled-table table-sortable" id="bookingOfficeTable">
                                <thead >
                                <tr class="filters">
                                    <th scope="col" class="id">
                                        <input type="text" class="form-control" placeholder="ID" disabled>
                                    </th>
                                    <th scope="col">
                                        <input type="text" class="form-control" placeholder="Booking Office" disabled></th>
                                    <th scope="col"> <input type="text" class="form-control" placeholder="Trip" disabled></th>
                                    <th scope="col">Actions</th>
                                </tr>
                                </thead>
                                <tbody id="myTable">
                                <jsp:useBean id="listBookingOffice" scope="request" type="java.util.List"/>

                                <%
                                    List<BookingOffice> bookingOfficeList = (ArrayList<BookingOffice>)request.getAttribute("listBookingOffice");
                                    for(BookingOffice bookingOffice:bookingOfficeList){
                                %>

                                <tr>
                                    <td scope="row" ><c:out value="<%=bookingOffice.getOfficeId()%>" /></td>
                                    <td>
                                        <a class="text-dark" href="${pageContext.request.contextPath}/ServletBookingOfficeEdit?id=<%=bookingOffice.getOfficeId()%>">
                                            <c:out value="<%=bookingOffice.getOfficeName()%>" />
                                        </a>
                                    </td>

                                    <%
                                        TripService tripService;
                                        Trip trip = null;
                                        tripService = new TripService();
                                        long id = bookingOffice.getTripId();

                                        try {
                                            trip = tripService.getTripByIdService(id);
                                        } catch (SQLException | ParseException throwables) {
                                            throwables.printStackTrace();
                                        }
                                    %>

                                    <td><% assert trip != null; %><c:out value="<%=trip.getDestination()%>" /></td>

                                    <td>
                                        <%if (session.getAttribute("staff") != null){%>
                                        <a  href="${pageContext.request.contextPath}/ServletBookingOfficeEdit?id=<%=bookingOffice.getOfficeId()%>"><i class="fa fa-pencil mr-3"></i></a>
                                        <a onclick="return confirm('Are you sure you want to delete this item?');"
                                           href="${pageContext.request.contextPath}/ServletBookingOfficeDelete?id=<%=bookingOffice.getOfficeId()%>" >
                                            <i class="fa fa-trash text-danger"></i>
                                        </a>
                                        <%}%>
                                    </td>
                                </tr>
                                <%}%>
                                </tbody>
                            </table>
                        <div class="d-flex justify-content-end">
                            <p>Total : <span id="rowcount"></span></p>
                        </div>

                        </div>
                </div>

                    <div class="d-flex justify-content-start">
                        <ul class="pagination pager" id="myPager">
                                <%--all pager go here--%>
                        </ul>
                    </div>

                </c:if>
                <c:if test="${fn:length(listBookingOffice) == 0}">
                    <div class="alert alert-warning text-center" role="alert">
                        There is no bookingOffice!
                    </div>
                </c:if>
            </main>
            <%} else {%>
            <jsp:include page="../common-views/_404.jsp"/>
            <%}%>
    </div>
    </div>
</div>

<footer class="footer">
    <jsp:include page="../common-views/_footer.jsp"/>
</footer>

</body>
</html>
