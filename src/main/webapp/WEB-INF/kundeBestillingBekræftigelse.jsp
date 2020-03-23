<%--
  Created by IntelliJ IDEA.
  User: cecilie
  Date: 15/03/2020
  Time: 15.50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <meta charset="UTF-8">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Ordrebekræftelse </title>
</head>
<body>
<div class="container">
    <div class="row">
        <img src="images/olskercupcakes.png" class="img-fluid">

        <div class="col-lg"></div>
        <ul class="nav navbar justify-content-center mt-2 w-100" style="background-color: #eee;">
            <li class="nav-item mr-auto">
            <form name="goBack" action="FrontController" method="post">
                <input type="hidden" name="target" value="goBack">
                <input type="submit" class="btn btn-link" value="Tilbage til forsiden">

            </form>
            </li>
            <li class="nav-item">
                <a class="nav-link"> ${sessionScope.email}</a>
            </li>
        </ul>
        <div class="col-lg-12 w-100 h-100 p-3 mt-2" style="background-color: #eee;">
            <h3>Din ordre er nu bestilt og kan afhentes hos Olsker Cupcakes på Bornholm.</h3>

        </div>
    </div>
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
