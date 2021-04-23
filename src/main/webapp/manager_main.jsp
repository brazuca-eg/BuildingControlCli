<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<!doctype html>
<html lang="zxx">

<head>
       <jsp:include page="style.jsp" />
</head>

<body>
    <jsp:include page="header.jsp" />

    <section class="breadcrumb_part">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb_iner">
                        <h2>Home page</h2>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <section class="about_us padding_top">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-8">
                    <div class="about_us_content">
                        <h5>My name</h5>
                        <h3><c:out value="${current.name}"/></h3>
                    </div>
                    <div class="about_us_content">
                        <h5>My Surname</h5>
                        <h3><c:out value="${current.surname}"/></h3>
                    </div>
                    <div class="about_us_content">
                        <h5>My role</h5>
                        <h3><c:out value="${current.roleEntity.name}"/></h3>
                    </div>
                    <div class="about_us_content">
                        <h5>My login</h5>
                        <h3><c:out value="${current.login}"/></h3>
                    </div>
                    <div class="about_us_content">
                        <h3><c:out value="${error}"/></h3>
                    </div>
                    <div class="about_us_content">
                        <a href="#" class="btn btn-primary btn-lg disabled" role="button" aria-disabled="true">Change my data</a>
                    </div>
                </div>
            </div>
        </div>
    </section>


    <jsp:include page="footer.jsp" />

    <jsp:include page="links.jsp" />
</body>

</html>