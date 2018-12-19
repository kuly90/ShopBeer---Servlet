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
        <title>Beer List</title>
        <link href="/Project1/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="/Project1/css/shop-homepage.css" rel="stylesheet">
        <style>
            th{
                width: 200px; 
                color: red; 
                border: 1px solid black
            }
            td{
                border: 1px solid black; 
                text-align: center
            }
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
                <div class="col-lg-3">
                    <h1 style="height: 20px;"></h1>
                    <h1>Beer List</h1>
                    <form action="Manager/addNewBeer.jsp">
                        <input style="margin-bottom: 5px;" type="submit" value="Add New Beer">
                    </form>
                    <form style="margin-left: 745px;" action="managerServlet" method="post" id="search">
                        <input type="hidden" name="action" value="search">
                        <input style="width: 300px; height: 30px;" type="text" name="textsearch" required="" id="search1">
                        <label>&nbsp;</label>
                        <input style="font-weight: bold; height: 30px" type="submit" value="Search">  
                    </form>
                </div>
                <table style="margin-left: 14px;">
                    <tr>
                        <th>Beer ID</th>
                        <th>Beer Name</th>
                        <th>Detail</th>
                        <th>Quantity in store</th>
                        <th>Price</th>
                        <th>Brand ID</th>
                        <th>Image</th>
                        <th>Date Join</th>
                        <th>Edit</th>
                        <th>Delete</th>                        
                    </tr>
                    <c:forEach var="beer" items="${beers}">
                        <tr>
                            <td>${beer.beerID}</td>
                            <td>${beer.beerName}</td>
                            <td>${beer.detail}</td>
                            <td>${beer.quantityInS}</td>
                            <td>${beer.price}</td>
                            <td>${beer.brandID}</td>
                            <td><image src="${beer.image}" width="100"></image></td>
                            <td>${beer.dateJoin}</td>
                            <td><a href="managerServlet?action=edit&amp;beerName=${beer.beerName}">Edit</a></td>
                            <td><a href="managerServlet?action=delete&amp;beerName=${beer.beerName}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
                <div class="col-lg-9">
                </div>
                <form action="Manager/managerMenu.jsp" method="get" name="beerList" class="form1">
                    <label>&nbsp;</label>                    
                    <input style="margin-left: 1025px" type="submit" value="Back To Menu" >
                </form>
            </div>
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
