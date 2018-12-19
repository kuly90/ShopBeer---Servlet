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
    <c:import url="includes/header.jsp"/>

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
                <div style="height: 40px;">

                </div>
                <div><a style="font-size: 35px; font-weight: bold; color: red;">Result</a></div>
                <div class="row">
                    <c:forEach var="b" items="${beers}">
                        <div class="col-lg-4 col-md-6 mb-4">
                            <div style="border-color: greenyellow" class="card h-100">
                                <a href="#"><img class="card-img-top" src="${b.image}" alt=""></a>
                                <div class="card-body">
                                    <h4 class="card-title">
                                        <a href="detailServlet?beerName=${b.beerName}">${b.beerName}</a>
                                    </h4>
                                    <h5>${b.formattedSalePrice}
                                        <form style="float: right; padding-right: 21px; font-size: 15px" action="compareServlet" method="post">
                                            <input type="hidden" name="beerName" value="${b.beerName}">
                                            <input type="submit" value="Compare">
                                        </form>
                                    </h5>
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
        </div>
    </div>
    <div style="width: 100%; height: 195px;">

    </div>

    <c:import url="includes/footer.jsp"/>
