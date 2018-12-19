<%-- 
    Document   : index
    Created on : Oct 25, 2017, 1:34:48 PM
    Author     : PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>The world of beer</title>
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/shop-homepage.css" rel="stylesheet">
    </head>

    <c:import url="includes/header.jsp"/>


    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <h1 style="color: greenyellow" class="my-4">Category
                </h1>
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
                
                <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner" role="listbox">
                        <div class="carousel-item active">
                            <img class="d-block img-fluid" src="images/1.jpg" alt="First slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block img-fluid" src="images/2.jpg" alt="Second slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block img-fluid" src="images/3.jpg" alt="Third slide">
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>


                <div style="font-size: 20px; color: green; font-weight: bold" id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
                    HOT BEER
                </div>

                <div class="row">
                    <c:forEach var="b" items="${beers1}">
                        <div class="col-lg-4 col-md-6 mb-4">
                            <div style="border-color: greenyellow" class="card h-100">
                                <a><img class="card-img-top" src="${b.image}" alt=""></a>
                                <div class="card-body">
                                    <h4 class="card-title">
                                        <a href="detailServlet?beerName=${b.beerName}">${b.beerName}</a>
                                    </h4>
                                    <div>
                                        <h5 style="color: red;">${b.formattedSalePrice}
                                            <form style="float: right; padding-right: 21px; font-size: 15px" action="compareServlet" method="post">
                                                <input type="hidden" name="beerName" value="${b.beerName}">
                                                <input type="submit" value="Compare">
                                            </form>
                                        </h5>
                                    </div>
                                    <div style="float : left;">
                                        <form style="float: right;" action="cartServlet" method="post">
                                            <input type="hidden" name="beerName" value="${b.beerName}">
                                            <input type="submit" value="Add to cart">
                                        </form>
                                        <form style="float: right; padding-left: 1px;" action="detailServlet" method="post">
                                            <input type="hidden" name="beerName" value="${b.beerName}">
                                            <input type="submit" value="View Detail">
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <!-- /.row -->
                <div style="font-size: 20px; color: green; font-weight: bold" id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
                    SALE BEER
                </div>
                <div class="row">

                    <c:forEach var="b" items="${beers3}">
                        <div class="col-lg-4 col-md-6 mb-4">
                            <div style="border-color: greenyellow" class="card h-100">
                                <a><img class="card-img-top" src="${b.image}" alt=""></a>
                                <div class="card-body">
                                    <h4 class="card-title">
                                        <a href="detailServlet?beerName=${b.beerName}">${b.beerName}</a>
                                    </h4>
                                    <div>
                                        <h5><del>${b.formattedPrice}</del>
                                            <form style="float: right; padding-right: 21px; font-size: 15px" action="compareServlet" method="post">
                                                <input type="hidden" name="beerName" value="${b.beerName}">
                                                <input type="submit" value="Compare">
                                            </form>
                                        </h5>
                                    </div>
                                    <h5 style="color: red; font-weight: inherit">Sale: ${b.formattedSalePrice}</h5>
                                    <div style="float : left;">
                                        <form style="float: right;" action="cartServlet" method="post">
                                            <input type="hidden" name="beerName" value="${b.beerName}">
                                            <input type="submit" value="Add to cart">
                                        </form>
                                        <form style="float: right; padding-left: 1px;" action="detailServlet" method="post">
                                            <input type="hidden" name="beerName" value="${b.beerName}">
                                            <input type="submit" value="View Detail">
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>

                <div style="font-size: 20px; color: green; font-weight: bold" id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
                    NEW BEER
                </div>
                <div class="row">

                    <c:forEach var="b" items="${beers2}">
                        <div class="col-lg-4 col-md-6 mb-4">
                            <div style="border-color: greenyellow" class="card h-100">
                                <a><img class="card-img-top" src="${b.image}" alt=""></a>
                                <div class="card-body">
                                    <h4 class="card-title">
                                        <a href="detailServlet?beerName=${b.beerName}">${b.beerName}</a>
                                    </h4>
                                    <div>
                                        <h5 style="color: red;">${b.formattedSalePrice}
                                            <form style="float: right; padding-right: 21px; font-size: 15px" action="compareServlet" method="post">
                                                <input type="hidden" name="beerName" value="${b.beerName}">
                                                <input type="submit" value="Compare">
                                            </form>
                                        </h5>
                                    </div>
                                    <div style="float : left;">
                                        <form style="float: right;" action="cartServlet" method="post">
                                            <input type="hidden" name="beerName" value="${b.beerName}">
                                            <input type="submit" value="Add to cart">
                                        </form>
                                        <form style="float: right; padding-left: 1px;" action="detailServlet" method="post">
                                            <input type="hidden" name="beerName" value="${b.beerName}">
                                            <input type="submit" value="View Detail">
                                        </form>  
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>
            </div>
            <!-- /.col-lg-9 -->

        </div>
        <!-- /.row -->

    </div>
    <!-- /.container -->

    <!-- Footer -->
    <c:import url="includes/footer.jsp"/>

