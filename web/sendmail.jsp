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
            th{
                padding-right: 5em;
            }
            #form label{
                float: left;
                width: 5em;
                margin-bottom: 0.5em;
                font-weight: bold;
            }

            #form  input[type="text"]{
                width: 15em;
                margin-bottom: 0.5em;
            }
            #form  textArea{
                width: 15em
            }
            #form #submit{
                width: 4em; 
                margin-left: 11em;
                margin-top: .5em
            }
        </style>
    </head>
    <body>
        <c:import url="includes/header.jsp"/>
        <div class="container">
            <div class="row"> <a style="font-size: 50px;"></a>
                <div class="col-lg-3">
                    <h1 style="color: greenyellow" class="my-4">Category</h1>
                    <div class="list-group">
                        <a href="beerServlet" class="list-group-item">Heineken</a>
                        <a href="tigerServlet" class="list-group-item">Tiger</a>
                        <a href="larueServlet" class="list-group-item">Larue</a>
                        <a href="SaiGonServlet" class="list-group-item">Sài Gòn</a>
                        <a href="hudaServlet" class="list-group-item">Huda</a>
                        <a href="biaKhacServlet" class="list-group-item">Other</a>
                    </div>
                </div>
                <div class="col-lg-9">
                    <div style="height: 20px;"></div>
                    <h1 style="color: red">Send us feedback</h1>
                    <form action="emailServlet" method="post" id="form">
                        <input type="hidden" type="email" name="emailTo" readonly="" value="ductest12@gmail.com"><br>

                        <label>Subject: </label>
                        <input type="text" name="subject" required=""><br>

                        <label>Message: </label>
                        <textarea name="body"></textarea><br>

                        <label>&nbsp;</label>
                        <input type="submit" value="Send" id="submit"><br>
                    </form>
                </div>
            </div>
        </div>
        <div style="height: 195px;"></div>
        <c:import url="includes/footer.jsp"/>
    </body>
</html>






