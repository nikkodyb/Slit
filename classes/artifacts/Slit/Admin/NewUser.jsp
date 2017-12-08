<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Slit</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/Slit/Templates/CSS/MainPageTemplate.css">
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
            <a class="navbar-brand" href="/Slit/App/welcome.jsp">Slit</a>
        </div>

        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/Slit/App/welcome.jsp">Home</a></li>
                <li><a href="/Slit/Admin/NewUser.jsp">Admin</a></li>

            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href=#>Min Side</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Logg ut</a></li>
            </ul>
        </div>
    </div>
</nav>
<h1>Vennligst oppgi din brukerinformasjon</h1>
<form action="/Slit/NewUser" method="post">
    E-post: <input name="email" type="text"><br>
    Passord: <input name="passWord" type="password"><br>
    Fornavn: <input name="firstName" type="text"><br>
    Etternavn: <input name="lastName" type="text"><br>
    Brukertype: <select name = "userType">
    <option value="Admin">Administrator</option>
    <option value="Teacher">Lærer</option>
    <option value="AssistantTeacher">Hjelpelærer</option>
</select> <br>
    <input type="submit" value="Lagre"> <br>
</form>
</body>
</html>
