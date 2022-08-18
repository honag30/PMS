<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>foot</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <style>
        .page-footer{
            background-color: rgb(248, 249, 250) !important;
        }
        a{
            color: #007791;
        }
    </style>
</head>
<body>
    <footer class="page-footer font-small mt-5" id="myFooter">
        <nav class="nav mt-3 justify-content-center py-2 ">
            <a class="nav-link" href="">Home</a>
            <a class="nav-link" href=""> History </a>
            <a class="nav-link" href=""> Blog </a>
            <a class="nav-link" href=""> FAQs </a>
            <a class="nav-link" href=""> About Us </a>
            <a class="nav-link" href=""> Privacy </a>
        </nav>
        <div class="footer-copyright text-center py-1 pt-3 text-secondary">
            Copyright © 2021:
            <p>Group 5</p>
        </div>
        <script src="<%=request.getContextPath() %>/assets/js/customScripts.js"></script>
        <script src="<%=request.getContextPath() %>/assets/js/validation.js"></script>
        <script src="<%=request.getContextPath() %>/assets/js/chart.js"></script>
        <script>
            function resetForm(tag){
                document.getElementById(tag).reset();
            }
        </script>
    </footer>
</body>
</html>
