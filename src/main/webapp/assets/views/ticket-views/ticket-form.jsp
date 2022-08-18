<%@ page import="fa.trainning.services.TripService" %>
<%@ page import="fa.trainning.entities.Trip" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.ParseException" %>
<%@ page import="fa.trainning.entities.Ticket" %>
<%@ page import="fa.trainning.services.CarService" %>
<%@ page import="fa.trainning.entities.Car" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Ticket</title>
</head>
<body>
<jsp:include page="../common-views/_navbar.jsp"/>
<div class="container-fluid mb-4 wrapper">
    <div class="row flex-xl-nowrap ">

        <jsp:include page="../common-views/_sidebar.jsp"/>

        <div class="col col-md-9 border-left" id="main">
            <%if (session.getAttribute("staff") != null) {%>

            <div class="mt-3">
                <c:if test="${existingTicket != null}">
                    <h3 class="font-weight-bold">Edit Ticket</h3>
                </c:if>
                <c:if test="${existingTicket == null}">
                    <h3 class="font-weight-bold">Add Ticket</h3>
                </c:if>
            </div>
            <hr class="divider"/>

            <!-- Main Page -->
            <main class="col-md-9 ms-sm-auto col-lg-12 px-md-4 mr-5">
                <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                    <h1 class="h5">Ticket From Elements</h1>
                </div>
                <c:if test="${existingTicket != null}">
                <form id="myForm"
                      action="${pageContext.request.contextPath}/ServletTicketUpdate?id=<c:out value='${existingTicket.ticketId}'/>"
                      method="post" name="update" onsubmit="return checkUpdateTicket()">
                    </c:if>

                    <c:if test="${existingTicket == null}">
                    <form id="myForm"
                          action="${pageContext.request.contextPath}/ServletTicketCreate"
                          method="post" name="create" onsubmit="return checkUpdateTicket()">
                        </c:if>

                        <%--Customer Name--%>
                        <div class="form-group row mt-2">
                            <label class="labels col-sm-2 col-form-label" for="customerName">Customer<span
                                    class="required">(*)</span></label>
                            <div class="col-sm-10">
                                <input name="customerName" type="text" id="customerName" class="form-control"
                                       placeholder="Enter customer name" value="${existingTicket.customerName}" required>
                                <div class="invalid-feedback" id="invalid-customer-name">Customer name must be
                                    characters and
                                    not contain special characters or numbers (3-50 character).
                                </div>
                            </div>
                        </div>
                        <%--Customer Name--%>

                        <%--Booking Time--%>
                        <div class="form-group row mt-2">
                            <label class="labels col-sm-2 col-form-label" for="bookingTime">Booking Time<span
                                    class="required">(*)</span></label>
                            <div class="col-sm-10">
                                <input name="bookingTime" type="time" step="1" id="bookingTime" class="form-control"
                                       value="${existingTicket.bookingTime}" placeholder="HH:MM:SS" required>
                                <div class="invalid-feedback" id="invalid-departure-time">Time must have form HH:MM:SS and between 00:00:00 and 23:59:59!
                                </div>
                            </div>
                        </div>
                        <%--Booking Time--%>

                        <%--Trip--%>
                        <div class="form-group row mt-2">
                            <label class="labels col-sm-2 col-form-label" for="trip">Trip<span
                                    class="required">(*)</span></label>
                            <div class="col-sm-10">
                                <select name="trip" class="form-control" id="trip" required>
                                    <c:if test="${existingTicket != null}">
                                        <%
                                            Ticket ticket = (Ticket) request.getAttribute("existingTicket");
                                            TripService tripService1 = new TripService();
                                            ;
                                            Trip tripTemp = null;
                                            long tripId = ticket.getTripId();
                                            System.out.println("Trip ID: " + tripId);
                                            try {
                                                tripTemp = tripService1.getTripByIdService(tripId);
                                                if (tripTemp == null) {
                                                    System.out.println("Object empty!!");
                                                    throw new NullPointerException();
                                                }
                                                System.out.println(tripTemp.toString());
                                            } catch (SQLException | ParseException | NullPointerException throwables) {
                                                throwables.printStackTrace();
                                            }
                                        %>
                                        <option><c:out value="<%=tripTemp.getDestination()%>"/></option>
                                        <hr class="divider"/>
                                    </c:if>


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
                                    <option><%=trip.getDestination()%>
                                    </option>
                                    <%
                                            }
                                        }
                                    %>

                                </select>
                            </div>
                        </div>
                        <%--Trip--%>

                        <%--License Plate--%>
                        <div class="form-group row mt-2">
                            <label class="labels col-sm-2 col-form-label" for="licensePlate">License Plate<span
                                    class="required">(*)</span></label>
                            <div class="col-sm-10">
                                <select name="licensePlate" class="form-control" id="licensePlate" required>
                                    <c:if test="${existingTicket != null}">
                                        <%
                                            Ticket ticket = (Ticket) request.getAttribute("existingTicket");
                                            CarService carService1 = null;
                                            Car carTemp = null;
                                            carService1 = new CarService();
                                            String licensePlate = ticket.getLicensePlate();
                                            System.out.println("license plate: " + licensePlate);
                                            try {
                                                carTemp = carService1.getCarByLicensePlateService(licensePlate);
                                            } catch (SQLException | ParseException throwables) {
                                                throwables.printStackTrace();
                                            }
                                        %>
                                        <option><% assert carTemp != null; %><c:out
                                                value="<%=carTemp.getLicensePlate()%>"/></option>
                                        <hr class="divider"/>
                                    </c:if>

                                    <%
                                        CarService carService = null;

                                        carService = new CarService();
                                        List<Car> carList = null;
                                        try {
                                            carList = carService.viewAllCarService();
                                        } catch (SQLException | ParseException e) {
                                            e.printStackTrace();
                                        }
                                        if (carList != null) {
                                            for (Car car : carList) {%>
                                    <option><%=car.getLicensePlate()%>
                                    </option>
                                    <%
                                            }
                                        }
                                    %>
                                </select>
                            </div>
                        </div>
                        <%--BLicense Plate--%>


                        <!--Function--->
                        <div class="form-group row my-5">
                            <div class="col-md-12 d-flex mb-3">
                                <a href="${pageContext.request.contextPath}/ServletParkingLotViewAll"
                                   class="col-md-2 mr-auto">
                                    <button type="button" class="btn btn-primary">
                                        <i class="fas fa-angle-double-left"></i> Back
                                    </button>
                                </a>

                                <button onclick=resetForm("myForm") class="btn btn-secondary col-md-2 ml-2"
                                        type="button">
                                    <i class='fas fa-sync'></i> Reset
                                </button>

                                <c:if test="${existingTicket != null}">
                                    <button type="submit" id="update" class="btn btn-success col-md-2 ml-2">
                                        <i class='far fa-edit'> </i> Update
                                    </button>
                                </c:if>
                                <c:if test="${existingTicket == null}">
                                    <button type="submit" id="create" class="btn btn-success col-md-2 ml-2">
                                        <i class='far fa-edit'> </i> Create
                                    </button>
                                </c:if>
                            </div>
                        </div>
                        <!--Function--->
                    </form>
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
