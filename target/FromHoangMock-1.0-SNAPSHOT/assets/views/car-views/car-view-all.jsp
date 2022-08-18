<%@ page import="java.sql.SQLException" %>
<%@ page import="java.text.ParseException" %>
<%@ page import="fa.trainning.entities.Car" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="fa.trainning.services.ParkingLotService" %>
<%@ page import="fa.trainning.entities.ParkingLot" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>View All Car</title>
</head>
<body>
<jsp:include page="../common-views/_navbar.jsp"/>
<div class="container-fluid">
    <div class="row flex-xl-nowrap">
        <jsp:include page="../common-views/_sidebar.jsp"/>
        <div class="col col-md-9 border-left " id="main">
            <%if (session.getAttribute("staff") != null) {%>
            <div class="mt-3">
                <h3 class="font-weight-bold">View All Car</h3>
            </div>
            <hr class="divider"/>

            <!-- Main Page -->
            <main class="col-md-9 ms-sm-auto col-lg-12 px-md-4 mr-5">

                <c:if test="${fn:length(listCar) > 0}">
                <div class="container mt-4">
                    <div class="filterable">
                            <div class="col-md-12 d-flex ">
                                <div  class="mr-auto"></div>
                                <button  type="button" id="myFilter" class="btn btn-xs btn-filter">
                                    <span class="fas fa-filter"></span> Filter: <span id="on">ON</span><span id="off">OFF</span>
                                </button>
                            </div>
                    <table class="table styled-table table-sortable " id="carTable">
                        <thead >
                        <tr class="filters">
                            <th scope="col">
                                <input type="text" class="form-control" placeholder="License Plate" disabled>
                            </th>
                            <th scope="col">
                                <input type="text" class="form-control" placeholder="Car Type" disabled>
                            </th>
                            <th scope="col">
                                <input type="text" class="form-control" placeholder="Car Color" disabled>
                            </th>
                            <th scope="col">
                                <input type="text" class="form-control" placeholder="Company" disabled>
                            </th>
                            <th scope="col">
                                <input type="text" class="form-control" placeholder="Parking Lot" disabled>
                            </th>
                            <th scope="col">Action</th>
                        </tr>
                        </thead>
                        <tbody id="myTable">
                        <jsp:useBean id="listCar" scope="request" type="java.util.List"/>

                        <%
                            List<Car> carList = (ArrayList<Car>) request.getAttribute("listCar");
                            for (Car car : carList) {
                        %>

                        <tr>
                            <td scope="row">
                                <c:out value="<%=car.getLicensePlate()%>"/>
                            </td>
                            <td>
                                <c:out value="<%=car.getCarType()%>"/>
                            </td>
                            <td>
                                <c:out value="<%=car.getCarColor()%>"/>
                            </td>
                            <td>
                                <c:out value="<%=car.getCompany()%>"/>
                            </td>
                            <%
                                ParkingLotService parkingLotService;
                                ParkingLot parkingLot = null;
                                parkingLotService = new ParkingLotService();
                                int id = (int) car.getParkId();

                                try {
                                    parkingLot = parkingLotService.getParkingLotByIdService(id);
                                } catch (SQLException | ParseException throwables) {
                                    throwables.printStackTrace();
                                }
                            %>

                            <td>
                                <% assert parkingLot != null; %>
                                <a href="${pageContext.request.contextPath}/ServletParkingLotEdit?id=<%=parkingLot.getParkId()%>">
                                    <c:out value="<%=parkingLot.getParkName()%>"/>
                                </a>
                            </td>

                            <td>
                                <%if (session.getAttribute("staff") != null) {%>
                                <a href="${pageContext.request.contextPath}/ServletCarEdit?licencePlate=<%=car.getLicensePlate()%>"><i
                                        class="fa fa-pencil mr-3"></i></a>
                                <a onclick="return confirm('Are you sure you want to delete this item?');"
                                   href="${pageContext.request.contextPath}/ServletCarDelete?id=<%=car.getLicensePlate()%>">
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
                <c:if test="${fn:length(listCar) == 0}">
                    <div class="alert alert-warning text-center" role="alert">
                        There is no car!
                    </div>
                </c:if>
            </main>
            <%} else {%>
            <jsp:include page="../common-views/_not-allow.jsp"/>
            <%}%>
        </div>
    </div>
</div>
<jsp:include page="../common-views/_footer.jsp"/>
</body>
</html>
