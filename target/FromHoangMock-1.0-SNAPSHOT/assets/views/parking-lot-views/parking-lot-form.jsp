<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Parking Lot</title>

</head>
<body>
<jsp:include page="../common-views/_navbar.jsp"/>
<div class="container-fluid mb-4 wrapper">
    <div class="row flex-xl-nowrap ">

        <jsp:include page="../common-views/_sidebar.jsp"/>

        <div class="col col-md-9 border-left" id="main">
            <%if (session.getAttribute("staff") != null) {%>

            <div class="mt-3">
                <c:if test="${existingParkingLot != null}">
                    <h3 class="font-weight-bold">Edit Parking Lot</h3>
                </c:if>
                <c:if test="${existingParkingLot == null}">
                    <h3 class="font-weight-bold">Add Parking Lot</h3>
                </c:if>
            </div>
            <hr class="divider"/>

            <!-- Main Page -->
            <main class="col-md-9 ms-sm-auto col-lg-12 px-md-4  mr-5">
                <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                    <h1 class="h5">Parking Lot From Elements</h1>
                </div>
                <c:if test="${existingParkingLot != null}">
                <form id="myForm"
                      action="${pageContext.request.contextPath}/ServletParkingLotUpdate?id=<c:out value='${existingParkingLot.parkId}'/>"
                      method="post" name="update" onsubmit="return checkUpdateParkingLot()">
                    </c:if>

                    <c:if test="${existingParkingLot == null}">
                    <form id="myForm"
                          action="${pageContext.request.contextPath}/ServletParkingLotCreate"
                          method="post" name="create" onsubmit="return checkUpdateParkingLot()">
                        </c:if>

                        <div class="form-group row mt-2">
                            <label class="labels col-sm-2 col-form-label" for="parkName">Parking lot name<span
                                    class="required">(*)</span></label>
                            <div class="col-sm-10">
                                <input name="parkName" id="parkName" type="text" class="form-control"
                                       placeholder="Enter parking Lot name" value="${existingParkingLot.parkName}" required>
                                <div class="invalid-feedback" id="invalid-parking-lot-name">Parking lot name must be
                                    characters and can not contain special characters! (3 - 50 characters)
                                </div>
                            </div>
                        </div>

                        <div class="form-group row mt-2">
                            <label class="labels col-sm-2 col-form-label" for="parkPlace">Place<span
                                    class="required">(*)</span></label>
                            <div class="col-sm-10">
                                <select name="parkPlace" class="form-control" id="parkPlace" required>
                                    <c:if test="${existingParkingLot != null}">
                                        <option>${existingParkingLot.parkPlace}</option>
                                    </c:if>
                                    <option>Ha Dong</option>
                                    <option>Ha Noi</option>
                                    <option>Thanh Xuan</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group row mt-2">
                            <label class="labels col-sm-2 col-form-label" for="parkArea">Area<span
                                    class="required">(*)</span></label>
                            <div class="col-sm-10">
                                <input name="parkArea" id="parkArea" type="text" class="form-control"
                                       value="${existingParkingLot.parkArea}" placeholder="Enter park area (m²)" required>
                                <div class="invalid-feedback" id="invalid-parking-lot-area">Must contain number and characters are not allow!
                                </div>
                            </div>
                        </div>

                        <div class="form-group row mt-2">
                            <label class="labels col-sm-2 col-form-label" for="parkPrice">Price<span
                                    class="required">(*)</span></label>
                            <div class="col-sm-10">
                                <input name="parkPrice" id="parkPrice" type="text" class="form-control"
                                       value="${existingParkingLot.parkPrice}" placeholder="Enter park price (VNĐ)" required>
                                <div class="invalid-feedback" id="invalid-parking-lot-price">Must contain number and characters are not allow!
                                </div>
                            </div>
                        </div>

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

                                <c:if test="${existingParkingLot != null}">
                                    <button type="submit" id="update" class="btn btn-success col-md-2 ml-2">
                                        <i class='far fa-edit'> </i> Update
                                    </button>
                                </c:if>
                                <c:if test="${existingParkingLot == null}">
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
