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


    <!-- breadcrumb part start-->
    <section class="breadcrumb_part">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb_iner">
                        <h2>Workers</h2>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <section class="about_us padding_top">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-8">
                    <c:forEach items="${users}" var="element">
                        <div class="about_us_content">
                            <h5>Name</h5>
                            <h3><c:out value="${element.name}"/></h3>
                        </div>
                        <div class="about_us_content">
                            <h5>Surname</h5>
                            <h3><c:out value="${element.surname}"/></h3>
                        </div>
                        <div class="about_us_content">
                            <h5>Login</h5>
                            <h3><c:out value="${element.login}"/></h3>
                        </div>
                        <div class="about_us_content">
                            <h5>Location</h5>
                            <h3><c:out value="${element.location.adress}"/></h3>
                        </div>
                        <div class="about_us_content">
                            <h5>Balance</h5>
                            <h3><c:out value="${element.balance.card}"/></h3>
                        </div>
                        <div class="about_us_content">
                            <h3><c:out value="${error}"/></h3>
                        </div>
                        <div class="about_us_content">
                             <input type="hidden" name="id" value="<c:out value = "${element.id}"/>">
                        </div>
                         <form  method="get" >
                             <div>
                                  <button name = "butt"  id="butt" type="submit">Show user</button>
                                  <input id="userId" name="userId" type="hidden" value="<c:out value = "${element.id}"/>">
                             </div>
                         </form>
                         <hr>
                    </c:forEach>
                </div>
            </div>
        </div>
    </section>

    <jsp:include page="footer.jsp" />

    <jsp:include page="links.jsp" />

</body>

</html>

