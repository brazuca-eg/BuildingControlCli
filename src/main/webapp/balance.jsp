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
                            <h2>Firm balance info</h2>
                        </div>
                    </div>
                </div>
            </div>
     </section>

     <div align="center">
           <h3>Card info</h3>
           <h3><c:out value="${balance.card}"/></h3>
           <h3>Current balance</h3>
           <h3><c:out value="${balance.balance}"/> UAH</h3>
     </div>

     <section class="about_us padding_top">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-8">
                           <h2 align="center">Payments</h2>
                         <c:forEach items="${payments}" var="element">
                                  <div class="about_us_content">
                                         <h5>Date</h5>
                                         <h3><c:out value="${element.date}"/></h3>
                                  </div>
                                  <div class="about_us_content">
                                         <h5>Money</h5>
                                         <h3><c:out value="${element.money}"/></h3>
                                  </div>
                                  <div class="about_us_content">
                                         <h5>Status</h5>
                                         <h3><c:out value="${element.acceptStatus}"/></h3>
                                  </div>

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
