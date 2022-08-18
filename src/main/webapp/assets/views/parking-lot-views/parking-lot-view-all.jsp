<%@ page import="fa.trainning.entities.ParkingLot" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>View All Parking Lot</title>
</head>
<body>
<jsp:include page="../common-views/_navbar.jsp"/>
<div class="container-fluid">
    <div class="row flex-xl-nowrap">
        <jsp:include page="../common-views/_sidebar.jsp"/>
        <div class="col col-md-9 border-left " id="main">
            <%if (session.getAttribute("staff") != null) {%>
            <div class="mt-3">
                <h3 class="font-weight-bold">View All Parking Lot</h3>
            </div>
            <hr class="divider" />

            <!-- Main Page -->
            <main class="col-md-9 ms-sm-auto col-lg-12 px-md-4 mr-5">

                <c:if test="${fn:length(listParkingLot) > 0}">

                    <div class="container mt-4">
                        <div class="filterable">
                            <div class="col-md-12 d-flex ">
                                <div  class="mr-auto"></div>
                                <button  type="button" id="myFilter" class="btn btn-xs btn-filter">
                                    <span class="fas fa-filter"></span> Filter: <span id="on">ON</span><span id="off">OFF</span>
                                </button>
                            </div>
                    <table class="table styled-table table-sortable" id="parkingLotTable">
                        <thead >
                        <tr class="filters">
                            <th scope="col"><input type="text" class="form-control" placeholder="ID" disabled></th>
                            <th scope="col">
                                <input type="text" class="form-control" placeholder="Parking Lot" disabled>
                            </th>
                            <th scope="col">
                                <input type="text" class="form-control" placeholder="Place" disabled>
                            </th>
                            <th scope="col">
                                <input type="text" class="form-control" placeholder="Area" disabled>
                            </th>
                            <th scope="col">
                                <input type="text" class="form-control" placeholder="Price" disabled>
                            </th>
                            <th scope="col">
                                <input type="text" class="form-control" placeholder="Status" disabled>
                            </th>
                            <th scope="col">Action</th>
                        </tr>
                        </thead>
                        <tbody id="myTable">
                        <jsp:useBean id="listParkingLot" scope="request" type="java.util.List"/>

                        <%
                            List<ParkingLot> parkingLotList = (ArrayList<ParkingLot>)request.getAttribute("listParkingLot");
                            for(ParkingLot parkingLot:parkingLotList){
                        %>

                        <tr>
                            <td scope="row" ><c:out value="<%=parkingLot.getParkId()%>" /></td>
                            <td>
                                <a class="text-dark" href="${pageContext.request.contextPath}/ServletParkingLotEdit?id=<%=parkingLot.getParkId()%>">
                                    <c:out value="<%=parkingLot.getParkName()%>" />
                                </a>
                            </td>

                            <td><%=parkingLot.getParkPlace()%></td>
                            <td><%=parkingLot.getParkArea()%> m²</td>
                            <td>
                                <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "<%=parkingLot.getParkPrice()%>" />₫
                            </td>
                            <td><%=parkingLot.getParkStatus()%></td>

                            <td>
                                <%if (session.getAttribute("staff") != null){%>
                                <a  href="${pageContext.request.contextPath}/ServletParkingLotEdit?id=<%=parkingLot.getParkId()%>"><i class="fa fa-pencil mr-3"></i></a>
                                <a onclick="return confirm('Are you sure you want to delete this item?');"
                                   href="${pageContext.request.contextPath}/ServletParkingLotDelete?id=<%=parkingLot.getParkId()%>" >
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
                <c:if test="${fn:length(listParkingLot) == 0}">
                    <div class="alert alert-warning text-center" role="alert">
                        There is no parkingLot!
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
