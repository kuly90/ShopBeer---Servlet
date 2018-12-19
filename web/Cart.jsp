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
                border: 1px solid blue;
                color: black;
            }
            td{
                border: 1px solid blue;
            }
            #formo label{
                float: left;
                width: 6em;
                margin-bottom: 0.5em;
                font-weight: bold;
            }
            #formo input[type="text"]{
                width: 17em;
                margin-bottom: 0.5em;
            }
            #formo input[type="submit"]{
                width: 5em;
                margin-bottom: 0.5em;
                margin-left: 12em;
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
                    <div style="height: 48px;">
                    </div>
                    <div><a style="font-size: 30px; font-weight: bold; color: red;">Your Shopping Cart</a></div>
                    <table>
                        <tr>
                            <th>Quantity</th>
                            <th>Beer Name</th>
                            <th>Price</th>
                            <th>Total</th>
                        </tr>
                        <c:forEach var="item" items="${cart.items}">
                            <tr>
                                <td>
                                    <form action="" method="post">
                                        <input type="hidden" name="beerName" value="${item.beer.beerName}">
                                        <input type="hidden" name="action" value="update">
                                        <input type="number" min="0" max="1000" step="1" name="quantity" value="${item.quantity}">                                                                            
                                        <input type="submit" value="Update">         
                                    </form>
                                </td>
                                <td><a href="detailServlet?beerName=${item.beer.beerName}">${item.beer.beerName}</a></td>
                                <td>${item.beer.formattedSalePrice}</td>
                                <td>${item.totalFormatted}</td>
                                <td style="">
                                    <form action="" method="post">
                                        <input type="hidden" name="beerName" value="${item.beer.beerName}">
                                        <input type="hidden" name="action" value="update">

                                        <input type="hidden" name="quantity" value="0">  
                                        <input type="submit" value="Remove Item">
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <div style="height: 15px;"></div>
                    <form style="padding-left:410px;" action="hotBeerServlet" method="post">
                        <input type="hidden" name="action" value="shop">
                        <input type="submit" value="Continue Shopping">
                    </form>
                    <h4 style="color: red; font-size: 20px;">Total payment: ${cart.totalAmountFormatted}</h4>
                    <div style="height: 30px;"></div>
                    <h2 style="color: red;">Order information </h2>
                    <form action="" method="post" id="formo">
                        <input type="hidden" name="action" value="confirm">
                        <label>Full Name: </label>
                        <input type="text" name="name" required=""><br>
                        <label>Address: </label>
                        <input type="text" name="address" required=""><br>
                        <label>Phone: </label>
                        <input type="text" name="phone" required=""><br>
                        <label>Email: </label>
                        <input type="text" name="email" required=""><br>                      

                        <label>&nbsp;</label>
                        <input type="submit" value="Confirm"><br>
                    </form>
                </div>
            </div>
        </div>
        <div style="height: 195px;"></div>
        <c:import url="includes/footer.jsp"/>
    </body>
</html>
