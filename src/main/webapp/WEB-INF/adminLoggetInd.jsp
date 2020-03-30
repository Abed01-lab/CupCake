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
    <title>Admin</title>
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

    <h4>Adminside</h4>
    <div class="row">
        <div class="col-sm">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Customer ID</th>
                    <th scope="col">Email</th>
                    <th scope="col">Balance</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="element" items="${sessionScope.customerList}">
                    <tr>
                        <th scope="row"></th>
                        <td>${element.id}</td>
                        <td>${element.email}</td>
                        <td>${element.balance}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <form action="FrontController" method="post">
                <input type="hidden" name="target" value="addBalance">
                ${requestScope.besked}
            <div class="row mt-4">
            <div class="col-sm">
                <select class="form-control" name="returnEmail">
                    <c:forEach var="element" items="${sessionScope.customerList}">
                        <option value="${element.email}">${element.email}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-sm">
                <input class="form-control" name="balanceAmount" placeholder="0">
            </div>
            <div class="col-sm">
                <button type="submit" class="btn btn-primary">Indsæt penge</button>
            </div></div></form>
            </div></div>
    </div></div>
</div></div>
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
