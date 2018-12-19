<%-- 
    Document   : Cart
    Created on : Oct 16, 2017, 9:32:45 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/shop-homepage.css" rel="stylesheet">
        <style>
            h1{
                font-size: 30px;
            }
        </style>
    </head>
    <body>
        <c:import url="includes/header.jsp"/>
        <div class="container">
            <div class="row"> <a style="font-size: 50px;"></a>
                <div class="col-lg-3">
                    <h1 class="my-4"></h1>
                    <h1 style="color: greenyellow" class="my-4">Category</h1>
                    <div class="list-group">
                        <a href="beerServlet" class="list-group-item">Heineken</a>
                        <a href="heineken.jsp" class="list-group-item">Tiger</a>
                        <a href="heineken.jsp" class="list-group-item">Larue</a>
                        <a href="heineken.jsp" class="list-group-item">Sài Gòn</a>
                        <a href="heineken.jsp" class="list-group-item">Huda</a>
                        <a href="heineken.jsp" class="list-group-item">Other</a>
                    </div>
                </div>
                <div class="col-lg-9">
                    <div style="height: 40px;">
                    </div>
                    <h1 style="color: red;">${message}</h1>
                </div>
            </div>
        </div>
        <div style="height: 210px;"></div>
        <c:import url="includes/footer.jsp"/>
    </body>
</html>

