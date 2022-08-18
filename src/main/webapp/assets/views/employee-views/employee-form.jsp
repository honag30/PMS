<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <title>Employee Form</title>
</head>
<body>
<jsp:include page="../common-views/_navbar.jsp"/>
<div class="container-fluid mb-4 wrapper">
    <div class="row flex-xl-nowrap ">

        <jsp:include page="../common-views/_sidebar.jsp"/>
        <div class="col col-md-9 border-left" id="main">
            <%if (session.getAttribute("admin") != null) {%>

            <div class="mt-3">
                <c:if test="${existingEmployee != null}">
                    <h3 >Edit Employee</h3>
                </c:if>
                <c:if test="${existingEmployee == null}">
                    <h3 >Add Employee</h3>
                </c:if>
            </div>
            <hr class="divider"/>

            <!-- Main Page -->
            <main class="col-md-9 ms-sm-auto col-lg-12 px-md-4 border border-start mr-5">
                <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                    <h1 class="h5">Content From Elements</h1>
                </div>
                <c:if test="${existingEmployee != null}">
                <form id="myForm"
                      action="${pageContext.request.contextPath}/ServletEmployeeUpdate?id=<c:out value='${existingEmployee.employeeId}'/>"
                      method="post" name="update" onsubmit="return checkUpdateEmployee()">
                    </c:if>

                    <c:if test="${existingEmployee == null}">
                    <form id="myForm" action="${pageContext.request.contextPath}/ServletEmployeeCreate"
                          method="post" name="create" onsubmit="return checkUpdateEmployee()">
                        </c:if>

                        <!--Full name--->
                        <div class="form-group row mt-2">
                            <label class="labels col-sm-2 col-form-label" for="employeeName">Full Name <span
                                    class="required">(*)</span></label>
                            <div class="col-sm-10">
                                <input name="employeeName" id="employeeName" type="text" class="form-control"
                                       placeholder="Enter the first name" value="${existingEmployee.employeeName}"
                                       required>
                                <div class="invalid-feedback" id="invalid-name">Full name must be
                                    characters and
                                    not contain number (3-50 character)
                                </div>
                            </div>
                        </div>
                        <!--Full name--->

                        <!--Phone number--->
                        <div class="form-group row mt-2">
                            <label class="labels col-sm-2 col-form-label" for="employeePhone"> Phone Number <span
                                    class="required">(*)</span></label>
                            <div class="col-sm-10">
                                <input name="employeePhone" id="employeePhone" type="text" class="form-control"
                                       placeholder="Enter phone number" value="${existingEmployee.employeePhone}"
                                       required>
                                <div class="invalid-feedback" id="invalid-phone">Must be number (10-11
                                    number)
                                </div>
                            </div>

                        </div>
                        <!--Phone number--->

                        <!--Birth of date--->
                        <div class="form-group row mt-2">
                            <label class="labels col-sm-2 col-form-label" for="employeeBirthDate">Birth of Date <span
                                    class="required">(*)</span></label>
                            <div class="col-sm-10">
                                <input name="employeeBirthDate" id="employeeBirthDate" type="date" class="form-control"
                                       max="2030-12-12" min="1920-01-01"
                                       value="${existingEmployee.employeeBirthDate}" placeholder="YYYY-MM-DD" required>
                                <div class="invalid-feedback" id="invalid-dob">Invalid Birth of Date! Must select a
                                    date before the current date.
                                </div>
                            </div>

                        </div>
                        <!--Birth of date--->


                        <!--Gender--->
                        <div class="form-group row mt-2">
                            <label class="labels col-sm-2 col-form-label">Sex <span class="required">(*)</span></label>
                            <div class="col-sm-10 inline-block">
                                <c:if test="${existingEmployee != null}">
                                    <c:if test="${existingEmployee.sex == 'F'}">
                                        <label>
                                            <input type="radio" name="gender" value="M">
                                        </label> Male
                                        <label>
                                            <input type="radio" name="gender" value="F" checked>
                                        </label> Female
                                    </c:if>

                                    <c:if test="${existingEmployee.sex == 'M'}">
                                        <label>
                                            <input type="radio" name="gender" value="M" checked>
                                        </label> Male
                                        <label>
                                            <input type="radio" name="gender" value="F">
                                        </label> Female
                                    </c:if>
                                </c:if>

                                <c:if test="${existingEmployee == null}">
                                    <label>
                                        <input type="radio" name="gender" value="M" checked>
                                    </label> Male
                                    <label>
                                        <input type="radio" name="gender" value="F">
                                    </label> Female
                                </c:if>
                            </div>
                        </div>
                        <!--Gender--->

                        <!--Address--->
                        <div class="form-group row mt-2">
                            <label class="labels col-sm-2 col-form-label" for="employeeAddress">
                                Address
                            </label>
                            <div class="col-sm-10">
                                <input id="employeeAddress" name="employeeAddress" type="text" class="form-control"
                                       value="${existingEmployee.employeeAddress}" placeholder="Enter address">
                                <div class="invalid-feedback" id="invalid-address">
                                    Address must be characters and number (3-50 character)
                                </div>
                            </div>

                        </div>
                        <!--Address--->

                        <!--Email--->
                        <div class="form-group row mt-2">

                            <label class="labels col-sm-2 col-form-label" for="employeeEmail">Email</label>
                            <div class="col-sm-10">
                                <input id="employeeEmail" name="employeeEmail" type="text" class="form-control"
                                       value="${existingEmployee.employeeEmail}" placeholder="Enter Email">
                                <div class="invalid-feedback" id="invalid-email">
                                    Invalid email!
                                </div>
                                <div>
                                    <p style="color: red; font-size: 80%">${message}</p>
                                </div>
                            </div>

                        </div>
                        <!--Email--->

                        <!--Account--->
                        <div class="form-group row mt-2">
                            <label class="labels col-sm-2 col-form-label" for="account">Account <span class="required">(*)</span></label>
                            <div class="col-sm-10">
                                <input id="account" name="account" type="text" class="form-control"
                                       value="${existingEmployee.account}" placeholder="Enter account" required>
                                <div class="invalid-feedback" id="invalid-account">
                                    Account must be characters and number (3-50 character)
                                </div>
                            </div>

                        </div>
                        <!--Account--->

                        <!--Password--->
                        <div class="form-group row mt-2">
                            <label class="labels col-sm-2 col-form-label" for="password">Password <span
                                    class="required">(*)</span></label>
                            <div class="col-sm-10">
                                <input name="password" type="password" id="password" class="form-control"
                                       placeholder="Enter Password"
                                       value="${existingEmployee.password}" required>
                                <div class="invalid-feedback" id="invalid-password">
                                    Password must include 7 to 14 characters!
                                </div>
                            </div>

                        </div>
                        <!--Password--->

                        <!--Department--->
                        <div class="form-group row mt-2">
                            <label class="labels col-sm-2 col-form-label" for="department"> Department <span
                                    class="required">(*)</span></label>
                            <div class="col-sm-10">
                                <select name="department" class="form-control" id="department" required>
                                    <option>Manager</option>
                                    <option>Employee</option>
                                    <option>Service</option>
                                    <option>Parking</option>
                                </select>
                            </div>
                        </div>
                        <!--Department--->

                        <!--Function--->
                        <div class="form-group row my-5">
                            <div class="col-md-12 d-flex mb-3">
                                <a href="${pageContext.request.contextPath}/ServletEmployeeViewAll"
                                   class="col-md-2 mr-auto">
                                    <button type="button" class="btn btn-primary">
                                        <i class="fas fa-angle-double-left"></i> Back
                                    </button>
                                </a>

                                <button onclick=resetForm("myForm") class="btn btn-secondary col-md-2 ml-2"
                                        type="button">
                                    <i class='fa fa-sync'></i> Reset
                                </button>

                                <c:if test="${existingEmployee != null}">
                                    <button type="submit" id="update" class="btn btn-success col-md-2 ml-2">
                                        <i class='fa fa-edit'> </i> Update
                                    </button>
                                </c:if>
                                <c:if test="${existingEmployee == null}">
                                    <button type="submit" id="create" class="btn btn-success col-md-2 ml-2">
                                        <i class='fa fa-edit'> </i> Create
                                    </button>
                                </c:if>
                            </div>
                        </div>
                        <!--Function--->
                    </form>
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
