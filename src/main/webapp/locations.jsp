<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
                        <h2>Locations</h2>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <section class="about_us padding_top">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-8">
                    <c:forEach items="${locations}" var="element">
                        <div class="about_us_content">
                            <h5>Adress</h5>
                            <h3><c:out value="${element.adress}"/></h3>
                        </div>
                        <div class="about_us_content">
                            <h5>Floor</h5>
                            <h3><c:out value="${element.floor}"/></h3>
                        </div>
                        <div class="about_us_content">
                            <h5>Room</h5>
                            <h3><c:out value="${element.room}"/></h3>
                        </div>
                        <div class="about_us_content">
                            <h5>Square</h5>
                            <h3><c:out value="${element.square}"/></h3>
                        </div>
                        <div class="about_us_content">
                            <h3><c:out value="${error}"/></h3>
                        </div>
                        <div class="about_us_content">
                             <input type="hidden" name="id" value="<c:out value = "${element.id}"/>">
                        </div>
                         <form  method="get" >
                             <div>
                                  <button name = "butt"  id="butt" type="submit">Open location</button>
                                  <input id="locId" name="locId" type="hidden" value="<c:out value = "${element.id}"/>">
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
