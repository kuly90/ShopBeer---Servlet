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
        <title>Bia Heineken</title>
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/shop-homepage.css" rel="stylesheet">
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
                    <input type="submit" value="Search">  
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
                            <a style="font-weight: bold" class="nav-link" href="login.jsp">Login</a>
                        </li>
                        <li class="nav-item">
                            <a style="font-weight: bold" href="Cart.jsp" class="nav-link"><image style="width: 28px;" src="cart.png"></a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container">
            <div class="row"> <a style="font-size: 50px;"></a>
                <div class="col-lg-3">
                    <h1 class="my-4"></h1>
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
                    <div><a style="font-size: 30px; color: red; font-weight: bold;">Beer ${beer.beerName}</a></div>
                    <div style="height: 30px;"></div>                    
                    <div class="row">
                        <div class="col-lg-4 col-md-6 mb-4">
                            <div style="border: none" class="card h-100">
                                <a style="border: 1px solid blue"><img class="card-img-top" src="${beer.image}" alt=""></a>
                                <div>
                                    <form style="padding-left: 160px; padding-top: 10px;" action="cartServlet" method="post">
                                        <input type="hidden" name="beerName" value="${beer.beerName}">
                                        <input type="submit" value="Add to cart">
                                    </form>
                                </div>

                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6 mb-4">
                            <div style="border: none" class="card h-100">
                                <h5><a style="color: blue">Beer Name:</a> ${beer.beerName}</h5>
                                <h5><a style="color: blue">Alcohol:</a> ${beer.detail}</h5>
                                <h5><a style="color: blue">Brand:</a> ${beer.brandID}</h5>
                                <h5><a style="color: blue">Price:</a> ${beer.formattedPrice}</h5>
                                <h5><a style="color: blue">You save:</a> ${beer.formattedDPrice}</h5>
                                <h5><a style="color: blue">New Price:</a> ${beer.formattedSalePrice}</h5>
                                <h5><a style="color: blue">Information:</a> ${beer.information}</h5>
                            </div>
                        </div>
                    </div>                    
                </div>
            </div>
        </div>

        <div style="width: 100%; height: 195px;">

        </div>

        <c:import url="includes/footer.jsp"/>
