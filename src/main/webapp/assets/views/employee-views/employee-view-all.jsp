<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>View All Employee</title>
    <jsp:include page="../common-views/_navbar.jsp"/>



</head>

<body>
<div class="container-fluid wrapper" id="mainPage">
    <div class="row flex-xl-nowrap">
        <jsp:include page="../common-views/_sidebar.jsp"/>

        <div class="col col-md-9 border-left " id="main">
            <%if (session.getAttribute("admin") != null) {%>
            <div class="mt-3">
                <h3 class="h3">View All Employee</h3>
            </div>
            <hr class="divider"/>
            <!-- Main Page -->
            <main class="col-md-9 ms-sm-auto col-lg-12 px-md-4  mr-5">
                <c:if test="${fn:length(listEmployee) > 0}">
                        <div class="row  mt-4">
                            <div class="filterable">
                                <div class="col-md-12 d-flex ">
                                    <div  class="mr-auto">
                                    </div>
                                    <button  type="button" id="myFilter" class="btn btn-xs btn-filter">
                                        <span class="fas fa-filter"></span> Filter: <span id="on">ON</span><span id="off">OFF</span>
                                    </button>
                                </div>
                                <table class="table styled-table table-sortable" id="employeeTable">
                                    <thead>
                                    <tr class="filters">
                                        <th scope="col"  class="id"><input type="text" class="form-control" placeholder="ID" disabled></th>
                                        <th scope="col"><input type="text" class="form-control" placeholder="Name" disabled></th>
                                        <th scope="col"><input type="text" class="form-control" placeholder="Date of Birth" disabled></th>
                                        <th scope="col"><input type="text" class="form-control" placeholder="Address" disabled></th>
                                        <th scope="col"><input type="text" class="form-control" placeholder="Phone Number" disabled></th>
                                        <th scope="col"><input type="text" class="form-control" placeholder="Department" disabled></th>
                                        <th scope="col">Action</th>
                                    </tr>

                                    </thead>
                                    <tbody id="myTable">
                                    <jsp:useBean id="listEmployee" scope="request" type="java.util.List"/>
                                    <c:forEach items="${listEmployee}" var="employee">
                                        <tr>
                                            <td scope="row"><c:out value="${employee.employeeId}"/></td>
                                            <td>
                                                <a class="text-dark"
                                                   href="${pageContext.request.contextPath}/ServletEmployeeEdit?id=<c:out value='${employee.employeeId}'/>">
                                                    <c:out value="${employee.employeeName}"/>
                                                </a>
                                            </td>
                                            <td><c:out value="${employee.employeeBirthDate}"/></td>
                                            <td><c:out value="${employee.employeeAddress}"/></td>
                                            <td><c:out value="${employee.employeePhone}"/></td>
                                            <td><c:out value="${employee.department}"/></td>
                                            <td>
                                                <%if (session.getAttribute("admin") != null) {%>
                                                <a href="${pageContext.request.contextPath}/ServletEmployeeEdit?id=<c:out value='${employee.employeeId}'/>"><i
                                                        class="fa fa-pencil mr-3"></i></a>
                                                <a onclick="return confirm('Are you sure you want to delete this item?');"
                                                   href="${pageContext.request.contextPath}/ServletEmployeeDelete?id=<c:out value='${employee.employeeId}'/>">
                                                    <i class="fa fa-trash text-danger"></i>
                                                </a>
                                                <%}%>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <div class="d-flex justify-content-end">
                                    <p>Rows : <span id="rowcount"></span></p>
                                </div>
                            </div>
                            <div class="d-flex justify-content-start">
                                <ul class="pagination pager" id="myPager">
                                    <%--all pager go here--%>
                                </ul>
                            </div>

                        </div>
                </c:if>
                <c:if test="${fn:length(listEmployee) == 0}">
                    <div class="alert alert-warning text-center" role="alert">
                        There is no employee!
                    </div>
                </c:if>
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

