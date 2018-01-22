<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">

  <title>RMS</title>
  <meta name="description" content="Index">
  <meta name="author" content="Mitrais">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
  <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
  <link rel="stylesheet" href="css/styles.css?v=1.0">

  <!--[if lt IE 9]>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.js"></script>
  <![endif]-->
</head>

<body>
    <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
      <header class="mdl-layout__header">
        <div class="mdl-layout__header-row">
          <!-- Title -->
          <a href="/rms-servlet-web/home" class="mdl-layout-title mdl-navigation__link">RMS</a>
          <!-- Add spacer, to align navigation to the right -->
          <div class="mdl-layout-spacer"></div>
          <!-- Navigation -->
          <nav class="mdl-navigation">
           <a class="mdl-navigation__link" href="/rms-servlet-web/users/list">Users</a>
            <a class="mdl-navigation__link" href="/rms-servlet-web/employees/list">Employees</a>
            <a class="mdl-navigation__link" href="/rms-servlet-web/logout">Logout</a>
          </nav>
        </div>
      </header>
      <div class="mdl-layout__drawer">
        <span class="mdl-layout-title">RMS</span>
        <nav class="mdl-navigation">
          <a class="mdl-navigation__link" href="/rms-servlet-web/users/list">Users</a>
            <a class="mdl-navigation__link" href="/rms-servlet-web/employees/list">Employees</a>
            <a class="mdl-navigation__link" href="/rms-servlet-web/logout">Logout</a>
        </nav>
      </div>
      <main class="mdl-layout__content">
      	<span class="mdl-layout-title">Welcome <%= session.getAttribute( "username" ) %></span>
      </main>
    </div>
  <script src="js/scripts.js"></script>
</body>
</html>
