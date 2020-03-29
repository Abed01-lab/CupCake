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
    <title>Ordrer</title>
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

            <li class="nav-item mr-lg-5">
                <form name="GoToAddBalance" action="FrontController" method="post">
                    <input type="hidden" name="target" value="GoToAddBalance">
                    <input type="submit" class="btn btn-link" value="Opdater saldo">
                </form>
            </li>
            <li class="nav-item mr-lg-5">
                <form name="GoToOrdersTwo" action="FrontController" method="post">
                    <input type="hidden" name="target" value="GoToOrdersTwo">
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


            <ul class="list-group">
            <c:forEach var="element" items="${sessionScope.listOfOrders}" varStatus="loop">
                <li class="list-group-item">Order ID: ${element.ordersId}
                    <form action="FrontController" method="post">
                    <input type="hidden" name="target" value="deleteOrder">
                    <input type="hidden" name="rowId" value="${sessionScope.listOfOrders.get(loop.index).ordersId}">
                    <button type="submit" class="btn btn-outline-danger">Fjern</button>
                    </form>
                    <span class="badge">${sessionScope.listOfOrders.get(loop.index).orderline.size()}</span></li>
                <ul class="list-group">
                    <li class="list-group-item">
                        <table class="table">
                            <thead>
                            <tr>

                                <th scope="col">Orderline ID</th>
                                <th scope="col">Antal</th>
                                <th scope="col">Pris</th>
                                <th scope="col">Topping</th>
                                <th scope="col">Bottom</th>
                                <th scope="col"></th>

                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="element2" items="${sessionScope.listOfOrders.get(loop.index).orderline}" varStatus="loop">
                                <tr>

                                    <td>${element2.orderlineId}</td>
                                    <td>${element2.quantity}</td>
                                    <td>${element2.sumNumber}</td>
                                    <td>${element2.topping}</td>
                                    <td>${element2.bottom}</td>

                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </li>
                </ul>
            </c:forEach>
            </ul>

</div></div></div>
</body>
</html>
