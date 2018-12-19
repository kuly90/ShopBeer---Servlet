<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User List</title>
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
                            <a style="font-weight: bold" class="nav-link" href="Admin/adminMenu.jsp">Login</a>
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
                    <h1>User List</h1>

                    <h3><a href="Admin/addNewUser.jsp">Add New User</a></h3>
                    <table>
                        <tr>
                            <th>User Name</th>
                            <th>Role Name</th>
                            <th>Status</th>
                            <th>Active</th>
                            <th>DeActive</th>
                            <th>Delete</th>
                        </tr>

                        <c:forEach var="user" items="${users}">
                            <tr>
                                <td>${user.userName}</td>
                                <td>${user.roleName}</td>
                                <td>${user.status}</td>                                
                                <td><a href="userServlet?action=active&amp;userName=${user.userName}">Active</a></td>
                                <td><a href="userServlet?action=deactive&amp;userName=${user.userName}">DeActive</a></td>
                                <td><a href="userServlet?action=delete&amp;userName=${user.userName}">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </table>                  
                </div>
                <form action="Admin/adminMenu.jsp" method="get" name="beerList" class="form1">
                    <label>&nbsp;</label>                    
                    <input style="margin-left: 471px; margin-top: 10px" type="submit" value="Back To Menu" >
                </form>
            </div>
        </div>
        <div style="width: 100%; height: 331px;">

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
