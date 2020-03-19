<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>CupcCake</title>
</head>
<body>

<div class="container">
    <div class="row">
        <img src="images/olskercupcakes.png" class="img-fluid">

        <div class="col-lg-12 w-100 h-100 p-3 mt-2" style="background-color: #eee;">
            <nav class="navbar navbar-default">
                <div class="container-fluid">

                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Orders</a></li>
                        <li><a href="#">Customers</a></li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li>${sessionScope.email}</li>
                        <li><a href="#">Logout</a></li>
                    </ul>

                </div>
            </nav>
        </div>

        <div class="col-lg-12 w-100 h-100 p-3 mt-2" style="background-color: #eee;">
            <form action="FrontController" method="post">
                <input type="hidden" name="target" value="addCupCake">
                <div class="container-fluid">
                    <div class="col-sm">
                        <table class="table">
                            <thead>
                            <tr class="active">
                                <td>Order</td>
                                <td>Bottom</td>
                                <td>Topping</td>
                                <td>Quantity</td>
                            </tr>
                            </thead>

                            <tbody>
                            <tr>
                                <td>#1</td>
                                <td>${sessionScope.bund}</td>
                                <td>${sessionScope.top}</td>
                            </tr>
                            </tbody>

                        </table>

                    </div>
                </div>
            </form>
        </div>
        <div class="col-lg"></div>
    </div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>