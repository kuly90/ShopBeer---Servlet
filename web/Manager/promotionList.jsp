<%-- 
    Document   : login
    Created on : Oct 25, 2017, 5:22:27 PM
    Author     : PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Promotion List</title>
        <link href="/Project1/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="/Project1/css/shop-homepage.css" rel="stylesheet">
        <style>
            th{padding-right: 2em;color: red;border: 1px solid black}
            td{border: 1px solid black; text-align: center}
        </style>
    </head>
    <body>

        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
            <div class="container">
                <a style="font-weight: bold; color: yellowgreen" class="navbar-brand" href="hotBeerServlet">BEER SHOP</a>

                <form action="searchServlet" method="post" id="search">
                    <input type="hidden" name="action" value="search">
                    <input style="" type="text" name="textsearch" required="" id="search1">
                    <label>&nbsp;</label>
                    <input style="font-weight: bold" type="submit" value="Search">  
                </form>

                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active">
                            <a style="font-weight: bold" class="nav-link" href="hotBeerServlet">Home
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a style="font-weight: bold" class="nav-link" href="sendmail.jsp">Feedback</a>
                        </li>
                        <li class="nav-item">
                            <a style="font-weight: bold" class="nav-link" href="hotBeerServlet">Log out</a>
                        </li>
                        <li class="nav-item">
                            <a style="font-weight: bold" href="Cart.jsp" class="nav-link"><image style="width: 28px;" src="/Project1/cart.png"></a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="row">
                <div class="col-lg-9">
                    <h1 style="height: 20px;"></h1>
                    <h1>Promotion</h1>
                    <form action="Manager/addNewPromotion.jsp">
                        <input type="submit" value="Add New Promotion" style="margin-bottom: .5em">
                    </form>

                    <form style="margin-left: 300px;" action="promotionServlet" method="post" id="search">
                        <input type="hidden" name="action" value="search">
                        <input style="width: 300px; height: 30px;" type="text" name="textsearch" required="" id="search1">
                        <label>&nbsp;</label>
                        <input style="font-weight: bold; height: 30px" type="submit" value="Search">  
                    </form>
                    <table>
                        <tr>
                            <th>Beer ID</th>
                            <th>Promotion ID</th>
                            <th>Discount</th>
                            <th>Date Start</th>
                            <th>Date End</th>
                            <th>Edit</th>
                            <th>Delete</th>                        

                        </tr>
                        <c:forEach var="promotion" items="${promotions}">
                            <tr>
                                <td>${promotion.beerID}</td>
                                <td>${promotion.promotionID}</td>
                                <td>${promotion.discount}</td>
                                <td>${promotion.dateStart}</td>
                                <td>${promotion.dateEnd}</td>
                                <td><a href="promotionServlet?action=edit&amp;beerID=${promotion.beerID}">Edit</a></td>
                                <td><a href="promotionServlet?action=delete&amp;beerID=${promotion.beerID}">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </table>                
                </div>          
            </div>
            <form style="margin-left: 563px;" action="Manager/managerMenu.jsp"  id="form">
                <label>&nbsp;</label>
                <input type="submit" value="Back to Menu" style="margin-top: .5em">
            </form>
        </div>
        <div style="width: 100%; height: 195px;">

        </div>

        <footer class="py-5 bg-dark">
            <div class="container">
                <p class="m-0 text-center text-white">Copyright &copy; Beer Shop</p>
                <p class="m-0 text-center text-white">Hot Line: 0905439692</p>
            </div>
            <!-- /.container -->
        </footer>

        <!-- Bootstrap core JavaScript -->
        <script src="/Project1/vendor/jquery/jquery.min.js"></script>
        <script src="/Project1/vendor/popper/popper.min.js"></script>
        <script src="/Project1/vendor/bootstrap/js/bootstrap.min.js"></script>

    </body>
</html>
                