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
                        <h2>Create location</h2>
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
                            <h2>Creating process</h2>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="login_part_form">
                        <div class="login_part_form_iner">
                            <form class="row contact_form"  method="post" >
                                <div class="col-md-12 form-group p_star">
                                     <p><input type="text" id="address" name="address" class="form-control" placeholder="Address"></p>
                                </div>
                                <div class="col-md-12 form-group p_star">
                                           <p><input type="number" id="floor" class="form-control" name="floor" placeholder="Floor"></p>
                                </div>
                                 <div class="col-md-12 form-group p_star">
                                            <p><input type="number" id="room" name="room" placeholder="Room" class="form-control" ></p>
                                </div>
                                 <div class="col-md-12 form-group p_star">
                                        <p><input type="number" id="square" name="square" class="form-control" placeholder="Square"></p>
                                </div>

                                <div class="col-md-12 form-group">
                                    <button type="submit" value="submit"  class="btn_3" name = "butt">Create location</button>
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