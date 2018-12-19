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
                width: 130px;
                border : 1px solid black;
                text-align: center;
            }
            td{
               
                border : 1px solid black;
                text-align: center;
            }
            #formo label{
                float: left;
                width: 10em;
                margin-bottom: 0.5em;
            }
            #formo  input[type="text"]{
                width: 15em;
                margin-bottom: 0.5em;
            }
            #formo  input[type="submit"]{
                width: 5em;
                margin-bottom: 0.5em;
                margin-left: 10em;
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
                    <div style="height: 10px;">
                    </div>
                    <div><a style="font-size: 40px; font-weight: bold; color: red">Compare</a></div>
                    <table>
                        <tr style="color:blue">
                            <th>Image</th>
                            <th>Beer Name</th><br>
                            <th>Price</th>
                            <th>You Save</th>
                            <th>Sale</th>
                            <th>Alcohol</th>
                            <th>NSX</th>
                        </tr>
                        <c:forEach var="item" items="${compare.items}">
                            <tr>   
                                <td><image src="${item.beer.image}" width="150"></image></td>
                                <td><a href="detailServlet?beerName=${item.beer.beerName}">${item.beer.beerName}</a></td>
                                <td>${item.beer.formattedPrice}</td>
                                <td>${item.beer.formattedDPrice}</td>
                                <td>${item.beer.formattedSalePrice}</td>
                                <td>${item.beer.detail}</td>
                                <td>${item.beer.brandID}</td>                               
                            </tr>
                        </c:forEach>
                    </table>                    
                    <div style="height: 10px;"></div>
                    <form action="hotBeerServlet" method="post">
                        <input type="hidden" name="action" value="shop">
                        <input type="submit" value="Continue Compare">
                    </form>
                    
                </div>
            </div>
        </div>
        <div style="height: 195px;"></div>
        <c:import url="includes/footer.jsp"/>
    </body>
</html>
