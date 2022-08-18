<%@ page import="fa.trainning.services.TripService" %>
<%@ page import="fa.trainning.entities.Trip" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.ParseException" %>
<%@ page import="fa.trainning.entities.BookingOffice" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Booking Office</title>
</head>
<body>
<jsp:include page="../common-views/_navbar.jsp"/>
<div class="container-fluid mb-4 wrapper">
    <div class="row flex-xl-nowrap ">

        <jsp:include page="../common-views/_sidebar.jsp"/>

        <div class="col col-md-9 border-left" id="main">
            <%if (session.getAttribute("staff") != null) {%>

            <div class="mt-3">
                <c:if test="${existingBookingOffice != null}">
                    <h3 class="font-weight-bold">Edit Booking Office</h3>
                </c:if>
                <c:if test="${existingBookingOffice == null}">
                    <h3 class="font-weight-bold">Add Booking Office</h3>
                </c:if>
            </div>
            <hr class="divider"/>

            <!-- Main Page -->
            <main class="col-md-9 ms-sm-auto col-lg-12 px-md-4  mr-5">
                <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 ">
                    <h1 class="h5">Booking Office From Elements</h1>
                </div>
                <hr class="divider"/>
                <c:if test="${existingBookingOffice != null}">
                <form id="myForm"
                      action="${pageContext.request.contextPath}/ServletBookingOfficeUpdate?id=<c:out value='${existingBookingOffice.officeId}'/>"
                      method="post" name="update" onsubmit="return checkUpdateOffice()">
                    </c:if>

                    <c:if test="${existingBookingOffice == null}">
                    <form id="myForm"
                          action="${pageContext.request.contextPath}/ServletBookingOfficeCreate"
                          method="post" name="create" onsubmit="return checkUpdateOffice()">
                        </c:if>
                        <%--Booking Office Name--%>
                        <div class="form-group row mt-2">
                            <label class="labels col-sm-2 col-form-label">Booking Office Name<span
                                    class="required">(*)</span></label>
                            <div class="col-sm-10">
                                <input name="officeName" id="officeName" type="text" class="form-control"
                                       placeholder="Enter booking office name"
                                       value="${existingBookingOffice.officeName}" required>

                                <div class="invalid-feedback" id="invalid-office-name">Booking office must be
                                    characters and
                                    not contain number (3-50 character)
                                </div>
                            </div>
                        </div>
                        <%--Booking Office Name--%>

                        <%--Trip Destination--%>
                        <div class="form-group row mt-2">
                            <label class="labels col-sm-2 col-form-label" for="destination">Destination<span
                                    class="required">(*)</span></label>
                            <div class="col-sm-10">
                                <select name="destination" class="form-control" id="destination" required>
                                    <c:if test="${existingBookingOffice != null}">
                                        <%
                                            BookingOffice bookingOffice = (BookingOffice) request.getAttribute("existingBookingOffice");
                                            TripService tripService1 = null;
                                            Trip tripTemp = null;
                                            tripService1 = new TripService();
                                            long id = bookingOffice.getTripId();
                                            System.out.println("Trip ID: " + id);
                                            try {
                                                tripTemp = tripService1.getTripByIdService(id);
                                            } catch (SQLException | ParseException throwables) {
                                                throwables.printStackTrace();
                                            }
                                        %>
                                        <option><% assert tripTemp != null; %><c:out
                                                value="<%=tripTemp.getDestination()%>"/></option>
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
                        <%--Trip Destination--%>

                        <%--Phone Number--%>
                        <div class="form-group row mt-2">
                            <label class="labels labels col-sm-2 col-form-label" for="officePhone">Phone<span
                                    class="required">(*)</span></label>
                            <div class="col-sm-10">
                                <input name="officePhone" type="text" id="officePhone" class="form-control"
                                       value="${existingBookingOffice.officePhone}" placeholder="Enter phone number"
                                       required>
                                <div class="invalid-feedback" id="invalid-phone-number">Must be number (10-11
                                    number)
                                </div>
                            </div>
                        </div>
                        <%--Phone Number--%>

                        <%--Place--%>
                        <div class="form-group row mt-2">
                            <label class="labels col-sm-2 col-form-label" for="officePlace">Place<span
                                    class="required">(*)</span></label>
                            <div class="col-sm-10">
                                <select name="officePlace" class="form-control" id="officePlace" required>
                                    <c:if test="${existingBookingOffice != null}">
                                        <option>${existingBookingOffice.officePlace}</option>
                                    </c:if>
                                    <option>Quay So 1</option>
                                    <option>Quay So 2</option>
                                    <option>Quay So 3</option>
                                </select>
                            </div>
                        </div>
                        <%--Place--%>

                        <%--Price--%>
                        <div class="form-group row mt-2">
                            <label class="labels col-sm-2 col-form-label" for="officePrice">Price<span
                                    class="required">(*)</span></label>
                            <div class="col-sm-10">
                                <input name="officePrice" type="text" id="officePrice" class="form-control"
                                       value="${existingBookingOffice.officePrice}" placeholder="Enter park price (VNĐ)" required>
                                <div class="invalid-feedback" id="invalid-price">Invalid price. Price must be a number!
                                </div>
                            </div>
                        </div>
                        <%--Price--%>

                        <%--Start Contract Deadline--%>
                        <div class="form-group row mt-2">
                            <label class="labels col-sm-2 col-form-label" for="startContractDeadline">Start
                                Contract<span
                                        class="required">(*)</span></label>
                            <div class="col-sm-10">
                                <input name="startContractDeadline" type="date" class="form-control"
                                       id="startContractDeadline" max="2060-12-12" min="2020-01-01"
                                       value="${existingBookingOffice.startContractDeadline}"
                                       placeholder="yyyy-mm-dd"
                                       required>
                                <div class="invalid-feedback" id="invalid-start-deadline">Invalid date! Must
                                    select a
                                    date after the current date.
                                </div>
                            </div>
                        </div>
                        <%--Start Contract Deadline--%>

                        <%--End contract deadline--%>
                        <div class="form-group row mt-2">
                            <label class="labels col-sm-2 col-form-label" for="endContractDeadline">End
                                Contract<span
                                        class="required">(*)</span></label>
                            <div class="col-sm-10">
                                <input name="endContractDeadline" type="date" class="form-control"
                                       id="endContractDeadline" max="2060-12-12" min="2020-01-01"
                                       value="${existingBookingOffice.endContractDeadline}"
                                       placeholder="yyyy-mm-dd"
                                       required>
                                <div class="invalid-feedback" id="invalid-end-deadline">Invalid date! Must
                                    select a date
                                    after start contract date.
                                </div>
                            </div>
                        </div>
                        <%--End contract deadline--%>

                        <!--Function--->
                        <div class="form-group row my-5">
                            <div class="col-md-12 d-flex mb-3">
                                <a href="${pageContext.request.contextPath}/ServletBookingOfficeViewAll"
                                   class="col-md-2 mr-auto">
                                    <button type="button" class="btn btn-primary">
                                        <i class="fas fa-angle-double-left"></i> Back
                                    </button>
                                </a>

                                <button onclick=resetForm("myForm") class="btn btn-secondary col-md-2 ml-2"
                                        type="button">
                                    <i class='fas fa-sync'></i> Reset
                                </button>

                                <c:if test="${existingBookingOffice != null}">
                                    <button type="submit" id="update" class="btn btn-success col-md-2 ml-2">
                                        <i class='far fa-edit'> </i> Update
                                    </button>
                                </c:if>
                                <c:if test="${existingBookingOffice == null}">
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
            <jsp:include page="../common-views/_not-allow.jsp"/>
            <%}%>
        </div>
    </div>
    <div class="push"></div>
</div>
<footer class="footer">
    <jsp:include page="../common-views/_footer.jsp"/>
</footer>
</body>
</html>
