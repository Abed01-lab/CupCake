<%--
  Created by IntelliJ IDEA.
  User: cecilie
  Date: 15/03/2020
  Time: 15.49
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <meta charset="UTF-8">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Log ind</title>
</head>
<body>
<div class="container">
    <div class="row">
        <img src="images/olskercupcakes.png" class="img-fluid">

        <div class="col-lg"></div>
        <ul class="nav navbar justify-content-center mt-2 w-100" style="background-color: #eee;">
            <li class="nav-item mr-auto">
                <form name="logout" action="FrontController" method="post">
                    <input type="hidden" name="target" value="logout">
                    <input type="submit" value="Log ud">

                </form>
            </li>

            <li class="nav-item">
                <form name="GoToOrders" action="FrontController" method="post">
                    <input type="hidden" name="target" value="GoToOrders">
                    <input type="submit" class="btn btn-link" value="Ordrer">
                </form>
            </li>
            <li class="nav-item mr-lg-5">
                <form name="GoToCustomers" action="FrontController" method="post">
                    <input type="hidden" name="target" value="GoToCustomers">
                    <input type="submit" class="btn btn-link" value="Kunder">

                </form>
            </li>
        </ul>
        <div class="col-lg-12 w-100 h-100 p-3 mt-2" style="background-color: #eee;">

            <h4>Adminside</h4>

<c:forEach var="element" items="${sessionScope.listOfOrders}" varStatus="loop">
            <div class="panel-group">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" href="#collapse1">Order ID: ${element.ordersId}</a>
                        </h4>
                    </div>
                    <div id="collapse1" class="panel-collapse collapse">
                        <ul class="list-group">
                        <c:forEach var="element2" items="${sessionScope.listOfOrders.get(loop.index).orderline}" varStatus="loop">

                            <li class="list-group-item">
                                Orderline ID: <td>${element2.orderlineId}</td>
                                <br>
                                <td>${element2.quantity}</td> cupcakes af kombinationen ${element2.topping} og ${element2.bottom} til ${element2.sumNumber}kr.</td>
                            </li>

                        </c:forEach>
                        </ul>
                    </div>
            </div>
</c:forEach>
<br><br>

            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Order ID</th>
                    <th scope="col">Customer ID</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="element" items="${sessionScope.listOfOrders}" varStatus="loop">
                    <tr>
                        <td>${element.ordersId}</td>
                        <td>${element.customerId}</td>

                        <c:forEach var="element2" items="${sessionScope.listOfOrders.get(loop.index).orderline}">
                                   <td>${element2.sumNumber}</td>
                        </c:forEach>

                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</div>
</body>
</html>