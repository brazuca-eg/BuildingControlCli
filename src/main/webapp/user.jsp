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
                        <h2>User's details</h2>
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
                            <h5>Name</h5>
                            <h3><c:out value="${us.name}"/></h3>
                        </div>
                        <div class="about_us_content">
                            <h5>Surname</h5>
                            <h3><c:out value="${us.surname}"/></h3>
                        </div>
                        <div class="about_us_content">
                            <h5>Login</h5>
                            <h3><c:out value="${us.login}"/></h3>
                        </div>
                        <div class="about_us_content">
                            <h5>Card</h5>
                            <h3><c:out value="${us.balance.card}"/></h3>
                        </div>
                        <div class="about_us_content">
                            <h5>Money request</h5>
                            <h3><c:out value="${us.balance.request}"/></h3>
                        </div>
                        <div class="about_us_content">
                            <form method="post" >
                                <p><button type="submit"  class="btn btn-success">Accept request</button></p>
                                <br>
                                <p><button type="submit" class="btn btn-danger">Decline request</button></p>
                            </form>
                        </div>
                        <div class="about_us_content">
                            <c:choose>
                                <c:when test="${loc==null}">
                                     <p>There is no location</p>
                                </c:when>
                                <c:when test="${loc!=null}">
                                       <h2>Info about location</h2>
                                       <p>Address: <c:out value="${loc.adress}"/></p>
                                       <p>Floor: <c:out value="${loc.floor}"/></p>
                                       <p>Room: <c:out value="${loc.room}"/></p>
                                       <p>Square: <c:out value="${loc.square}"/></p>
                                       <form method="get" >
                                            <p><button type="submit" value="submit" class="btn btn-secondary" name = "open_loc">Open location</button></p>
                                       </form>
                                </c:when>
                            </c:choose>
                        </div>
                        <div class="about_us_content">
                            <h3><c:out value="${error}"/></h3>
                        </div>
                </div>
            </div>
        </div>
    </section>


   <jsp:include page="footer.jsp" />


    <jsp:include page="links.jsp" />
</body>

</html>