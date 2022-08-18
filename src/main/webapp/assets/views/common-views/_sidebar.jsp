<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Side Bar</title>
</head>
<body>

<div class="col-md-3 col-xl-2 bd-sidebar mt-3 " id="sticky-sidebar">
    <div class="sticky-top">


        <%if (session.getAttribute("admin") != null) {%>
        <h6> Dashboard </h6>
        <%} else if (session.getAttribute("staff") != null) { %>
        <h6> Car Park Manager</h6>
        <%}%>
        <hr class="divider"/>

        <div class="collapse navbar-collapse navbar-expand-lg d-md-block ml-2 text-secondary " id="navbarSupportedContent-4">

            <nav class="bd-links  navbar-nav ml-auto" aria-label="Main navigation">
                <div class="bd-toc-item active">
                    <div class="panel-group">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <div class="panel-title">
                                    <%if (session.getAttribute("staff") != null) {%>
                                    <a class="text-secondary" data-toggle="collapse" href="#collapse3"><i
                                            class="fas fa-car-side pr-2"></i>
                                        Car Manager
                                    </a>
                                    <%}%>

                                </div>
                            </div>
                            <div id="collapse3" class="panel-collapse collapse">
                                <%if (session.getAttribute("staff") != null) {%>
                                <div class="panel-body ml-3 my-4">
                                    <a href="${pageContext.request.contextPath}/ServletCarViewAll"
                                       class=" text-secondary">
                                        <i class="fas fa-list-ul"></i> Car List</a>
                                </div>
                                <div class="panel-footer ml-3 mb-1">
                                    <a href="${pageContext.request.contextPath}/assets/views/car-views/car-form.jsp"
                                       class=" text-secondary">
                                        <i class=" fa fa-edit "></i> Add Car</a>
                                </div>
                                <%}%>
                            </div>
                        </div>
                    </div>
                </div>
            </nav>
            <%if (session.getAttribute("staff") != null) {%>
            <hr class="divider"/>
            <%}%>
        </div>



        <div class="collapse d-md-block ml-2 text-secondary" id="navbarSupportedContent-4" >
            <nav class="bd-links" aria-label="Main navigation">
                <div class="bd-toc-item active">
                    <div class="panel-group">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <div class="panel-title">

                                    <%if (session.getAttribute("admin") != null) {%>
                                    <a class="text-secondary" data-toggle="collapse" href="#collapse1"><i
                                            class="far fa-user-circle pr-2"></i>
                                        Employee Manager
                                    </a>
                                    <%}%>
                                    <%if (session.getAttribute("staff") != null) {%>
                                    <a class="text-secondary" data-toggle="collapse" href="#collapse1"><i
                                            class="fas fa-cart-plus pr-2"></i>
                                        Booking Office Manager
                                    </a>
                                    <%}%>

                                </div>
                            </div>
                            <div id="collapse1" class="panel-collapse collapse">

                                <%if (session.getAttribute("admin") != null) {%>
                                <div class="panel-body ml-3  my-4">
                                    <a href="${pageContext.request.contextPath}/ServletEmployeeViewAll"
                                       class=" text-secondary">
                                        <i class="fas fa-list-ul"></i> Employee List</a>
                                </div>
                                <div class="panel-footer ml-3 mb-1">
                                    <a href="${pageContext.request.contextPath}/assets/views/employee-views/employee-form.jsp"
                                       class=" text-secondary">
                                        <i class=" fa fa-edit "></i> Add Employee</a>
                                </div>
                                <%}%>

                                <%if (session.getAttribute("staff") != null) {%>
                                <div class="panel-body ml-3  my-4">
                                    <a href="${pageContext.request.contextPath}/ServletBookingOfficeViewAll"
                                       class=" text-secondary">
                                        <i class="fas fa-list-ul"></i> Booking Office List</a>
                                </div>
                                <div class="panel-footer ml-3 mb-1">
                                    <a href="${pageContext.request.contextPath}/assets/views/booking-office-views/booking-office-form.jsp"
                                       class=" text-secondary">
                                        <i class=" fa fa-edit "></i> Add Booking Office</a>
                                </div>
                                <%}%>

                            </div>
                        </div>
                    </div>
                </div>
            </nav>
            <%if (session.getAttribute("staff") != null || session.getAttribute("admin") != null) {%>
            <hr class="divider"/>
            <%}%>
        </div>


        <div class="collapse d-md-block ml-2 text-secondary" id="navbarSupportedContent-4">
            <nav class="bd-links" aria-label="Main navigation">
                <div class="bd-toc-item active">
                    <div class="panel-group">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <div class="panel-title">
                                    <%if (session.getAttribute("staff") != null) {%>
                                    <a class="text-secondary" data-toggle="collapse" href="#collapse2"><i
                                            class="fas fa-parking pr-2"></i>
                                        Parking Lot Manager
                                    </a>
                                    <%}%>

                                </div>
                            </div>
                            <div id="collapse2" class="panel-collapse collapse">
                                <%if (session.getAttribute("staff") != null) {%>
                                <div class="panel-body ml-3  my-4">
                                    <a href="${pageContext.request.contextPath}/ServletParkingLotViewAll"
                                       class=" text-secondary">
                                        <i class="fas fa-list-ul"></i> Parking Lot List</a>
                                </div>
                                <div class="panel-footer ml-3 mb-1">
                                    <a href="${pageContext.request.contextPath}/assets/views/parking-lot-views/parking-lot-form.jsp"
                                       class=" text-secondary">
                                        <i class=" fa fa-edit "></i> Add Parking Lot</a>
                                </div>
                                <%}%>
                            </div>
                        </div>
                    </div>
                </div>
            </nav>
            <%if (session.getAttribute("staff") != null) {%>
            <hr class="divider"/>
            <%}%>
        </div>



        <%if (session.getAttribute("staff") != null) {%>
        <h6> Ticket</h6>
        <%}%>

        <div class="collapse d-md-block ml-2 text-secondary" id="navbarSupportedContent-4">
            <%if (session.getAttribute("staff") != null) {%>
            <hr class="divider"/>
            <%}%>

            <nav class="bd-links" aria-label="Main navigation">
                <div class="bd-toc-item active">
                    <div class="panel-group">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <div class="panel-title">
                                    <%if (session.getAttribute("staff") != null) {%>
                                    <a class="text-secondary" data-toggle="collapse" href="#collapse4"><i
                                            class="fas fa-plane pr-2"></i>
                                        Trip Manager
                                    </a>
                                    <%}%>
                                </div>
                            </div>
                            <div id="collapse4" class="panel-collapse collapse">

                                <%if (session.getAttribute("staff") != null) {%>
                                <div class="panel-body ml-3  my-4">
                                    <a href="${pageContext.request.contextPath}/ServletTripViewAll"
                                       class=" text-secondary">
                                        <i class="fas fa-list-ul"></i> Trip List</a>
                                </div>
                                <div class="panel-footer ml-3 mb-1">
                                    <a href="${pageContext.request.contextPath}/assets/views/trip-views/trip-form.jsp"
                                       class=" text-secondary">
                                        <i class=" fa fa-edit "></i> Add Trip</a>
                                </div>
                                <%}%>

                            </div>
                        </div>
                    </div>
                </div>
            </nav>
            <%if (session.getAttribute("staff") != null) {%>
            <hr class="divider"/>
            <%}%>
        </div>

        <div class="collapse d-md-block ml-2 text-secondary" id="navbarSupportedContent-4">
            <nav class="bd-links" aria-label="Main navigation">
                <div class="bd-toc-item active">
                    <div class="panel-group">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <div class="panel-title">
                                    <%if (session.getAttribute("staff") != null) {%>
                                    <a class="text-secondary" data-toggle="collapse" href="#collapse5"><i
                                            class="fas fa-ticket-alt pr-2"></i>
                                        Ticket Manager
                                    </a>
                                    <%}%>
                                </div>
                            </div>
                            <div id="collapse5" class="panel-collapse collapse">

                                <%if (session.getAttribute("staff") != null) {%>
                                <div class="panel-body ml-3  my-4">
                                    <a href="${pageContext.request.contextPath}/ServletTicketViewAll"
                                       class=" text-secondary">
                                        <i class="fas fa-list-ul"></i> Ticket List</a>
                                </div>
                                <div class="panel-footer ml-3 mb-1">
                                    <a href="${pageContext.request.contextPath}/assets/views/ticket-views/ticket-form.jsp"
                                       class=" text-secondary">
                                        <i class="fa fa-edit "></i> Add Ticket</a>
                                </div>
                                <%}%>
                            </div>
                        </div>
                    </div>
                </div>
            </nav>

        </div>

        <%if (session.getAttribute("staff") != null) {%>
        <hr class="divider"/>

        <%}%>
        <c:if test="${successMessage != null}">
            <div class="alert alert-success" id="successMessage" role="alert">
                    ${successMessage}
            </div>
        </c:if>
        <c:if test="${warningMessage != null}">
            <div class="alert alert-danger" id="successMessage" role="alert">
                    ${warningMessage}
            </div>
        </c:if>


        </div>

</div>

<script>
    setTimeout(fade_out, 4000);

    function fade_out() {
        $("#successMessage").hide().empty();
    }
</script>
</body>
</html>
