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
        <title>Admin Menu</title>
        <link href="/Project1/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="/Project1/css/shop-homepage.css" rel="stylesheet">
        <style>
            .form1 input[type="text"],.form1 input[type="password"]{
                width: 12em;
                margin-left: 0.5em;
                margin-bottom: 0.5em;
            }
            #form input{margin-top: .3em}
        </style>
    </head>
    <body>

        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
            <div class="container">
                <a style="font-weight: bold; color: yellowgreen" class="navbar-brand" href="../hotBeerServlet">BEER SHOP</a>

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
                            <a style="font-weight: bold" class="nav-link" href="../hotBeerServlet">Home
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a style="font-weight: bold" class="nav-link" href="../sendmail.jsp">Feedback</a>
                        </li>
                        <li class="nav-item">
                            <a style="font-weight: bold" class="nav-link" href="Admin/adminMenu.jsp">Login</a>
                        </li>
                        <li class="nav-item">
                            <a style="font-weight: bold" href="../Cart.jsp" class="nav-link"><image style="width: 28px;" src="/Project1/cart.png"></a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <h1 style="color: yellowgreen" class="my-4">Admin Menu</h1>
                    <div class="list-group">
                        <a href="userServlet" class="list-group-item">Process User</a>
                    </div>
                </div>

                <div class="col-lg-9">
                    <h1 style="height: 20px;"></h1>

                </div>
            </div>
        </div>
        <div style="width: 100%; height: 455px;">

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

