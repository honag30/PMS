<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Login </title></head>
<body>
<jsp:include page="../common-views/_navbar.jsp"/>
<section class="login-page">
    <div class="container my-5 ">
        <div class="row justify-content-center align-self-center">
            <div class="col-md-6 mb-4">
                <section>
                    <form id="loginForm" class="text-center border p-5" autocomplete="off"
                          action="${pageContext.request.contextPath}/ServletEmployeeLogin" method="post" name="login">
                        <p class="h4 mb-4">Sign in</p>
                        <label for="defaultLoginFormAccount"></label>
                        <input type="email" name="email" id="defaultLoginFormAccount" class="form-control mb-4"
                               placeholder="Email" required>
                        <label for="defaultLoginFormPassword"></label>
                        <input type="password" name="password" id="defaultLoginFormPassword" class="form-control mb-4"
                               placeholder="Password" required>
                        <div class="text-center " style="color: #00cc00">
                            <p style="color: red">${message}</p>
                        </div>
                        <div class="d-flex justify-content-around">
                            <div>
                                <div class="custom-control custom-checkbox">
                                    <input type="checkbox" value="lsRememberMe" id="rememberMe"
                                           class="custom-control-input">
                                    <label class="custom-control-label" for="rememberMe">Remember me</label>
                                </div>
                            </div>
                            <div>
                                <a href="#">Forgot password?</a>
                            </div>
                        </div>
                        <button class="btn btn-info btn-block my-4 waves-effect waves-light" type="submit">Sign
                            in
                        </button>
                        <p>Not a member?
                            <a href="${pageContext.request.contextPath}/assets/views/authentication/register.jsp">Register</a>
                        </p>
                        <p>or sign in with:</p>
                        <a type="button" class="light-blue-text mx-2">
                            <i class="fa fa-facebook-f"></i>
                        </a>
                        <a type="button" class="light-blue-text mx-2">
                            <i class="fa fa-twitter"></i>
                        </a>
                        <a type="button" class="light-blue-text mx-2">
                            <i class="fa fa-linkedin"></i>
                        </a>
                        <a type="button" class="light-blue-text mx-2">
                            <i class="fa fa-github"></i>
                        </a>
                    </form>
                </section>
            </div>
        </div>
    </div>
</section>
<jsp:include page="../common-views/_footer.jsp"/>
</body>
</html>
