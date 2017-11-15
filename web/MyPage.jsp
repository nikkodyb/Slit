<!--
*Author: Nicolay Leknes
*Sist Oppdatert 11.10.2017
--->

<%@ page import="users.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% User user = (User) session.getAttribute("user");%>
<!-- Hentet fra https://www.w3schools.com/bootstrap/tryit.asp?filename=trybs_temp_webpage&stacked=h -->
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Slit</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/Slit/MyPage.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/Slit/welcome.jsp">Slit</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/Slit/welcome.jsp">Home</a></li>
                <li><a href="/Slit/Admin/opprettAdmin.jsp">Admin</a></li>
                <li><a href="/Slit/MyPage">MyPage</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="/Slit/Logout"><span class="glyphicon glyphicon-log-in"></span> Logg ut</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-2 sidenav">
            <p><a href="#">Link</a></p>
        </div>

        <div class="col-sm-8 text-left" id="mamma">
            <h1>Velkommen til Min Side</h1>
            <form class="knappstil" action="/Slit/MyPage" method="post">
                <h5><input type="submit" name="Varslinger" value="Varslinger"></h5>
                <h5><input type="submit" name="Filer" value="Filer"></h5>
            </form>

            <form class="knappstil" action="/Slit/MyPage" method="post">
                <input type ="submit" name="Innstillinger" value="Innstillinger">

            </form>
        </div>

        <div class="col-sm-2 sidenav">
        </div>
    </div>
</div>
</body>
</html>






