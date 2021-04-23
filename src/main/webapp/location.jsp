<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<!DOCTYPE html>
<html>
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
                            <h2>Location details</h2>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <div align="center">
        <h2>General info about location</h2>
        <p>Address: <c:out value="${current_location.adress}"/></p>
        <p>Floor: <c:out value="${current_location.floor}"/></p>
        <p>Room: <c:out value="${current_location.room}"/></p>
        <p>Square: <c:out value="${current_location.square}"/></p>
        <p>Amount of workers: <c:out value="${amount}"/></p>

        <h2>Daily statistic of the location</h2>
        <p>Date: <c:out value="${daily_statistic.date}"/></p>
        <p>Mark average: <c:out value="${daily_statistic.markAverage}"/></p>
        <p>Parameters average: <c:out value="${daily_statistic.parametersAverage}"/></p>


        <h2>Adding free workers to the location</h2>
        <form method="post">
           <select name = "chosen_user">
               <c:forEach items="${free}" var="element">
                    <option value="<c:out value = "${element.id}"/>" name="ch" ><c:out value="${element.login}"/> : <c:out value="${element.name}"/>  <c:out value="${element.surname}"/></option>
               </c:forEach>
           </select>
            <input  type="submit" name = "add"  id="add" value="Add worker"/>
        </form>

       <h2>Workers in location</h2>
       <c:forEach items="${workers}" var="element">
            <p>Login: <c:out value="${element.login}"/></p>
            <p>Name: <c:out value="${element.name}"/></p>
            <p>Surname: <c:out value="${element.surname}"/></p>
            <hr>
       </c:forEach>



        <h2>All details in location</h2>
        <c:forEach items="${details}" var="element">
                   <p>Date and time: <c:out value="${element.datetime}"/></p>
                   <p>Parameter: <c:out value="${element.parameter}"/></p>
                   <p>Mark: <c:out value="${element.mark}"/></p>
                   <hr>
        </c:forEach>

       <p align = "center"><c:out value="${error}"/></p>
       <p align = "center"><c:out value="${info}"/></p>
       </div>

       <jsp:include page="footer.jsp" />
</body>

</html>