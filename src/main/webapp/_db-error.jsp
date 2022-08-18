<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>404</title>
</head>
<body>
<jsp:include page="assets/views/common-views/_navbar.jsp"/>
<div class="container-fluid mb-4 wrapper">
<div class="page-wrap d-flex flex-row align-items-center">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-12 text-center">
                <span class="display-1 d-block text-danger">Database Error</span>
                <div class="mb-4 lead">There is problem with database.</div>
            </div>
        </div>
    </div>
</div>
</div>
<jsp:include page="assets/views/common-views/_footer.jsp"/>

</body>
</html>

