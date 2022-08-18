<%@ page import="fa.trainning.entities.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Navigation Bar</title>
    <jsp:include page="_initial-load.jsp"/>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light border border-bottom " id="navBar" >
    <%if (session.getAttribute("admin") != null) {%>
    <a class="navbar-brand" href="${pageContext.request.contextPath}/ServletEmployeeViewAll" style="font-size:1.4rem"> Employee </a>
    <%} else if (session.getAttribute("staff") != null) {%>
    <a class="navbar-brand" href="${pageContext.request.contextPath}/ServletBookingOfficeViewAll" style="font-size:1.4rem"> Booking Office </a>
    <%} else {%>
    <a class="navbar-brand" href="${pageContext.request.contextPath}/assets/views/authentication/login.jsp" style="font-size:1.4rem">PMS</a>
    <%}%>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-4"
            aria-controls="navbarSupportedContent-4" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <%if (session.getAttribute("staff") != null || session.getAttribute("admin") != null) {%>
    <div class="collapse navbar-collapse" id="navbarSupportedContent-4">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item dropdown">
                <%if (session.getAttribute("admin") != null) {%>
                <%Employee admin = (Employee) session.getAttribute("admin");%>
                Welcome <strong><%=admin.getAccount()%>
            </strong>
                <%}%>

                <%if (session.getAttribute("staff") != null) {%>
                <%Employee staff = (Employee) session.getAttribute("staff");%>
                Welcome <strong><%=staff.getAccount()%>
            </strong>
                <%}%>
                <a class="ml-3" href="${pageContext.request.contextPath}/ServletEmployeeLogout"><span><i
                        class="fa fa-sign-out mr-2"></i></span>Log out</a>
            </li>
        </ul>
    </div>
    <%}%>
</nav>
</body>
</html>
