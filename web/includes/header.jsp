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
                        <a style="font-weight: bold" class="nav-link" href="Manager/managerMenu.jsp">Login</a>
                    </li>
                    <li class="nav-item">
                        <a style="font-weight: bold" href="Cart.jsp" class="nav-link"><image style="width: 28px;" src="/Project1/cart.png"></a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>