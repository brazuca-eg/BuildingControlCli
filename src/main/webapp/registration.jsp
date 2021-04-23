<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<!doctype html>
<html lang="zxx">

<head>
  <jsp:include page="style.jsp" />
</head>

<body>
    <section class="breadcrumb_part">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb_iner">
                        <h2>Registration</h2>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <section class="login_part section_padding ">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-6 col-md-6">
                    <div class="login_part_text text-center">
                        <div class="login_part_text_iner">
                            <h2>Registration process</h2>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="login_part_form">
                        <div class="login_part_form_iner">
                            <h3>Welcome ! <br>
                                Please register now</h3>
                            <form class="row contact_form" action="#" method="post" novalidate="novalidate">
                                <div class="col-md-12 form-group p_star">
                                     <p><input type="text" class="form-control" id="login" name="login" placeholder="Email"></p>
                                </div>
                                <div class="col-md-12 form-group p_star">
                                           <p><input type="password" class="form-control" id="password" name="password" placeholder="Password"></p>
                                </div>
                                 <div class="col-md-12 form-group p_star">
                                            <p><input type="password" class="form-control" id="password2" name="password2" placeholder="Repeat password"></p>
                                </div>
                                 <div class="col-md-12 form-group p_star">
                                        <p><input type="text" class="form-control" id="name" name="name" placeholder="Name"></p>
                                </div>
                                 <div class="col-md-12 form-group p_star">
                                        <p><input type="text" class="form-control" id="surname" name="surname" placeholder="Surname"></p>
                                </div>
                                <div class="col-md-12 form-group">
                                    <button type="submit" value="submit"  class="btn_3" name = "butt">Register</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>


    <jsp:include page="footer.jsp" />

    <jsp:include page="links.jsp" />
</body>

</html>