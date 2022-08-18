<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.ParseException" %>
<%@ page import="fa.trainning.entities.Car" %>
<%@ page import="fa.trainning.services.ParkingLotService" %>
<%@ page import="fa.trainning.entities.ParkingLot" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Car</title>
</head>
<body>
<jsp:include page="../common-views/_navbar.jsp"/>
<div class="container-fluid mb-4 wrapper">
    <div class="row flex-xl-nowrap ">

        <jsp:include page="../common-views/_sidebar.jsp"/>

        <div class="col col-md-9 border-left" id="main">
            <%if (session.getAttribute("staff") != null) {%>

            <div class="mt-3">
                <c:if test="${existingCar != null}">
                    <h3 class="font-weight-bold">Edit Car</h3>
                </c:if>
                <c:if test="${existingCar == null}">
                    <h3 class="font-weight-bold">Add Car</h3>
                </c:if>
            </div>
            <hr class="divider"/>

            <!-- Main Page -->
            <main class="col-md-9 ms-sm-auto col-lg-12 px-md-4  mr-5">
                <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                    <h1 class="h5">Content From Elements</h1>
                </div>
                <c:if test="${existingCar != null}">
                <form id="myForm"
                      action="${pageContext.request.contextPath}/ServletCarUpdate?licensePlate=<c:out value='${existingCar.licensePlate}'/>"
                      method="post" name="update" onsubmit="return checkRealUpdateCar()">
                    </c:if>

                    <c:if test="${existingCar == null}">
                    <form id="myForm"
                          action="${pageContext.request.contextPath}/ServletCarCreate"
                          method="post" name="create" onsubmit="return checkUpdateCar()">
                        </c:if>
                        <!--licensePlate--->
                        <div class="form-group row mt-2">
                            <label class="labels col-sm-2 col-form-label" for="licensePlate">License plate<span
                                    class="required">(*)</span></label>

                            <c:if test="${existingCar != null}">
                                <div class="col-sm-10">
                                    <input
                                            name="licensePlate" type="text"
                                            class="form-control" value="${existingCar.licensePlate}"
                                            disabled>
                                </div>
                            </c:if>

                            <c:if test="${existingCar == null}">
                                <div class="col-sm-10">
                                    <input name="licensePlate" id="licensePlate" type="text" class="form-control"
                                           placeholder="Enter license plate" value="${existingCar.licensePlate}"
                                           required>
                                    <div class="invalid-feedback" id="invalid-license-plate">License plate must be
                                        characters and can
                                        not contain special characters (6-20 character and format: ___-__)
                                    </div>
                                    <div>
                                        <p style="color: red; font-size: 80% ">${message}</p>
                                    </div>

                                </div>
                            </c:if>

                        </div>
                        <!--licensePlate--->

                        <!--carType--->
                        <div class="form-group row mt-2">
                            <label class="labels col-sm-2 col-form-label" for="carType">Car type</label>
                            <div class="col-sm-10">
                                <input id="carType" name="carType" type="text" class="form-control"
                                       value="${existingCar.carType}" placeholder="Enter car type">
                                <div class="invalid-feedback" id="invalid-car-type">Car type must be
                                    characters and
                                    not contain special characters (3-20 character)
                                </div>
                            </div>
                        </div>
                        <!--carType--->

                        <!--carColor--->
                        <div class="form-group row mt-2">
                            <label class="labels col-sm-2 col-form-label" for="carColor">Car color</label>
                            <div class="col-sm-10">
                                <input name="carColor" id="carColor" type="text" class="form-control"
                                       value="${existingCar.carColor}" placeholder="Enter car color">
                                <div class="invalid-feedback" id="invalid-car-color">Color must be
                                    characters and
                                    not contain special characters (3-20 character)
                                </div>
                            </div>
                        </div>
                        <!--carColor--->

                        <!--company--->
                        <div class="form-group row mt-2">
                            <label class="labels col-sm-2 col-form-label" for="company">Company<span
                                    class="required">(*)</span></label>
                            <div class="col-sm-10">

                                <select name="company" class="form-control" id="company" required>
                                    <c:if test="${existingCar != null}">
                                        <option>${existingCar.company}</option>
                                    </c:if>
                                    <option>Company 1</option>
                                    <option>Company 2</option>
                                    <option>Company 3</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group row mt-2">
                            <label class="labels col-sm-2 col-form-label" for="parkName">Parking Lot<span
                                    class="required">(*)</span></label>
                            <div class="col-sm-10">
                                <select name="parkName" class="form-control" id="parkName" required>

                                    <c:if test="${existingCar != null}">
                                        <%
                                            Car car = (Car) request.getAttribute("existingCar");
                                            ParkingLotService parkingLotService1 = null;
                                            ParkingLot parkingLotTemp = null;
                                            parkingLotService1 = new ParkingLotService();
                                            int id = (int) car.getParkId();
                                            System.out.println("Trip ID: " + id);
                                            try {
                                                parkingLotTemp = parkingLotService1.getParkingLotByIdService(id);
                                            } catch (SQLException | ParseException throwables) {
                                                throwables.printStackTrace();
                                            }
                                        %>
                                        <option><% assert parkingLotTemp != null; %><c:out
                                                value="<%=parkingLotTemp.getParkName()%>"/></option>
                                        <hr class="divider"/>
                                    </c:if>

                                    <%
                                        ParkingLotService parkingLotService = null;

                                        parkingLotService = new ParkingLotService();
                                        List<ParkingLot> parkingLotList = null;
                                        try {
                                            parkingLotList = parkingLotService.viewAllParkingLotService();
                                        } catch (SQLException | ParseException e) {
                                            e.printStackTrace();
                                        }
                                        if (parkingLotList != null) {
                                            for (ParkingLot parkingLot : parkingLotList) {%>
                                    <option><%=parkingLot.getParkName()%>
                                    </option>
                                    <%
                                            }
                                        }
                                    %>
                                </select>
                            </div>
                        </div>

                        <!--Function--->
                        <div class="form-group row my-5">
                            <div class="col-md-12 d-flex mb-3">
                                <a href="${pageContext.request.contextPath}/ServletCarViewAll"
                                   class="col-md-2 mr-auto">
                                    <button type="button" class="btn btn-primary">
                                        <i class="fas fa-angle-double-left"></i> Back
                                    </button>
                                </a>

                                <button onclick=resetForm("myForm") class="btn btn-secondary col-md-2 ml-2"
                                        type="button">
                                    <i class='fas fa-sync'></i> Reset
                                </button>

                                <c:if test="${existingCar != null}">
                                    <button type="submit" id="update" class="btn btn-success col-md-2 ml-2">
                                        <i class='far fa-edit'> </i> Update
                                    </button>
                                </c:if>
                                <c:if test="${existingCar == null}">
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

<script>

    function checkRealUpdateCar() {
        let checkRealUpdateCar1 = checkName("carType", "invalid-car-type");
        let checkRealUpdateCar2 = checkName("carColor", "invalid-car-color");

        if (checkRealUpdateCar1 && checkRealUpdateCar2) {
            return confirm("Do you want to update car?")
        } else {
            return false;
        }
    }

</script>
</body>
</html>
