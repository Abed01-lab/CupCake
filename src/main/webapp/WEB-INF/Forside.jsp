<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Olsker Cupcakes</title>
</head>
<body>

<div class="container">
    <div class="row">
        <img src="images/olskercupcakes.png" class="img-fluid">

        <div class="col-lg"></div>
        <ul class="nav navbar justify-content-end mt-2 w-100" style="background-color: #eee;">
            <li class="nav-item">
                <a class="nav-link" >${sessionScope.email}</a>
            </li>
            <li class="nav-item mr-lg-5">
                <a class="nav-link" href="#">Kurv</a>
            </li>
        </ul>
        <div class="col-lg-12 w-100 h-100 p-3 mt-2" style="background-color: #eee;">
            <form action="FrontController" method="post">
                <input type="hidden" name="target" value="addCupCake">
                <h4>Velkommen ombord</h4>
                <h4>Øens bedste cupcakes. Vælg Topping og bestil her:</h4>
                ${requestScope.besked}
                <div class="row mt-4">
                    <div class="col-sm">
                        <select class="form-control" name="bottom">
                            <c:forEach var="element" items="${applicationScope.bottomList}">
                                <option value="${element.id -1}">${element.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-sm">
                        <select class="form-control" name="topping">
                            <c:forEach var="element" items="${applicationScope.toppingList}">
                                <option value="${element.id -1}">${element.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-sm">
                        <input class="form-control" name="quantity" placeholder="0">
                    </div>
                    <div class="col-sm">
                        <button type="submit" class="btn btn-primary">Læg i kurv</button>
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