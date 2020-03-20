<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <%@ page contentType="text/html; charset=UTF-8" %>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>Olskers Cupcakes</title>
    </head>
    <body>
    <div class="container">
        <div class="row">
            <img src="images/olskercupcakes.png" class="img-fluid">

            <div class="col-lg"></div>
            <ul class="nav navbar mt-2 w-100 h-50" style="background-color: #eee;">
                <li class="nav-item mr-lg-5">
                    <a class="nav-link" href="#" style="text-align:right;"> </a>
                </li>
            </ul>

            <div class="col-lg-12 w-100 h-100 p-3 mt-2" style="background-color: #eee;">
        <table>

            <tr><td>Log ind</td>
                <td>
                    <form name="login" action="FrontController" method="post">
                        <input type="hidden" name="target" value="login">
                        Email:<br>
                        <input type="text" name="email" placeholder="Skriv din email her" value="eko@test.dk">
                        <br>
                        Kodeord:<br>
                        <input type="password" name="password" placeholder="Skriv dit kodeord her" value="eko">
                        <br>
                        <input type="submit" value="Log på">

                    </form>
                </td>
                <td>Registrer</td>
                <td>
                    <form name="register" action="FrontController" method="post">
                        <input type="hidden" name="target" value="register">

                        Email:<br>
                        <input type="text" name="email" value="">
                        <br>
                        Kodeord:<br>
                        <input type="password" name="password1" value="">
                        <br>
                        Gentag Kodeord:<br>
                        <input type="password" name="password2" value="">
                        <br>
                        <input type="submit" value="Registrer">

                    </form>
                </td>
            </tr>

        </table>
            </div>
        </div>
    </div>
    </body>
</html>
