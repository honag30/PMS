<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Trip</title>
    <script src="<%=request.getContextPath() %>/assets/js/validation.js"></script>

</head>
<body>
<jsp:include page="../common-views/_navbar.jsp"/>
<div class="container-fluid mb-4 wrapper">
    <div class="row flex-xl-nowrap ">

        <jsp:include page="../common-views/_sidebar.jsp"/>

        <div class="col col-md-9 border-left" id="main">
            <%if (session.getAttribute("staff") != null) {%>

            <div class="mt-3">
                <c:if test="${existingTrip != null}">
                    <h3 class="font-weight-bold">Edit Trip</h3>
                </c:if>
                <c:if test="${existingTrip == null}">
                    <h3 class="font-weight-bold">Add Trip</h3>
                </c:if>
            </div>
            <hr class="divider"/>

            <!-- Main Page -->
            <main class="col-md-9 ms-sm-auto col-lg-12 px-md-4  mr-5">
                <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                    <h1 class="h5">Trip From Elements</h1>
                </div>
                <c:if test="${existingTrip != null}">
                <form id="myForm"
                      action="${pageContext.request.contextPath}/ServletTripUpdate?id=<c:out value='${existingTrip.tripId}'/>"
                      method="post" name="update" onsubmit=" return checkUpdateTrip()">
                    </c:if>

                    <c:if test="${existingTrip == null}">
                    <form id="myForm"
                          action="${pageContext.request.contextPath}/ServletTripCreate"
                          method="post" name="create" onsubmit="return checkUpdateTrip()">
                        </c:if>

                        <%--Destination--%>
                        <div class="form-group row mt-2">
                            <label class="labels col-sm-2 col-form-label" for="destination">Destination<span
                                    class="required">(*)</span></label>
                            <div class="col-sm-10">
                                <input name="destination" id="destination" type="text" class="form-control"
                                       placeholder="Enter destination" value="${existingTrip.destination}" required>
                                <div class="invalid-feedback" id="invalid-destination">Destination must be
                                    characters and number. Can
                                    not contain special characters (3-50 character).
                                </div>
                            </div>
                        </div>
                        <%--Destination--%>

                        <%--Departure Time--%>
                        <div class="form-group row mt-2">
                            <label class="labels col-sm-2 col-form-label" for="departureTime">Departure Time<span
                                    class="required">(*)</span></label>
                            <div class="col-sm-10">
                                <input name="departureTime" type="time" step="1" id="departureTime" class="form-control"
                                       value="${existingTrip.departureTime}" placeholder="HH:MM:SS" required>
                                <div class="invalid-feedback" id="invalid-departure-time">Time must have form HH:MM:SS and between 00:00:00 and 23:59:59!
                                </div>
                            </div>
                        </div>
                        <%--Departure Time--%>

                        <%--Driver--%>
                        <div class="form-group row mt-2">
                            <label class="labels col-sm-2 col-form-label" for="driverName">Driver<span
                                    class="required">(*)</span></label>
                            <div class="col-sm-10">
                                <input name="driver" type="text" id="driverName" class="form-control"
                                       placeholder="Enter driver" value="${existingTrip.driver}" required>
                                <div class="invalid-feedback" id="invalid-driver">Driver must be
                                    characters and can
                                    not contain special characters or number(3-50 character).
                                </div>
                            </div>
                        </div>
                        <%--Driver--%>

                        <%--Car Type--%>
                        <div class="form-group row mt-2">
                            <label class="labels col-sm-2 col-form-label" for="carType">Car type<span
                                    class="required">(*)</span></label>
                            <div class="col-sm-10">
                                <input name="carType" type="text" id="carType" class="form-control"
                                       value="${existingTrip.carType}"
                                       placeholder="Enter car type" required>
                                <div class="invalid-feedback" id="invalid-car-type">Car type must be
                                    characters and number (3-50 character). Can
                                    not contain special characters.
                                </div>
                            </div>
                        </div>
                        <%--Car Type--%>

                        <%--Maximum online ticket number--%>
                        <div class="form-group row mt-2">
                            <label class="labels col-sm-2 col-form-label" for="maximumTicket">Maximum online ticket<span
                                        class="required">(*)</span></label>
                            <div class="col-sm-10">
                                <input name="maximumOnlineTicketNumber" id="maximumTicket" type="text" class="form-control"
                                       value="${existingTrip.maximumOnlineTicketNumber}"
                                       placeholder="Enter maximum online ticket number" required>
                                <div class="invalid-feedback" id="invalid-maximum-ticket">Must be a number!
                                </div>
                            </div>
                        </div>
                        <%--Maximum online ticket number--%>

                        <%--Departure Date--%>
                        <div class="form-group row mt-2">
                            <label class="labels col-sm-2 col-form-label" for="departureDate">Departure Date<span
                                    class="required">(*)</span></label>
                            <div class="col-sm-10">
                                <input name="departureDate" id="departureDate" type="date" class="form-control"
                                       max="2060-12-12" min="2020-01-01"
                                       value="${existingTrip.departureDate}" placeholder="" required>
                                <div class="invalid-feedback" id="invalid-departure-date">Invalid Date!
                                </div>
                            </div>
                        </div>
                        <%--Departure Date--%>

                        <!--Function--->
                        <div class="form-group row my-5">
                            <div class="col-md-12 d-flex mb-3">
                                <a href="${pageContext.request.contextPath}/ServletTripViewAll"
                                   class="col-md-2 mr-auto">
                                    <button type="button" class="btn btn-primary">
                                        <i class="fas fa-angle-double-left"></i> Back
                                    </button>
                                </a>

                                <button onclick=resetForm("myForm") class="btn btn-secondary col-md-2 ml-2"
                                        type="button">
                                    <i class='fas fa-sync'></i> Reset
                                </button>

                                <c:if test="${existingTrip != null}">
                                    <button type="submit" id="update" class="btn btn-success col-md-2 ml-2">
                                        <i class='far fa-edit'> </i> Update
                                    </button>
                                </c:if>
                                <c:if test="${existingTrip == null}">
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
