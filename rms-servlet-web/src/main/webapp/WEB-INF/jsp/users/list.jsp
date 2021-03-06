<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix = "rms" uri = "/WEB-INF/tags/link.tld"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


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
  <rms:link type="stylesheet" href="css/styles.css?v=1.0"/>

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
      <div class="box-center">
      	<main class="mdl-layout__content" >
      		<div class="main-center">
	      	<table class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp">
	              <thead>
	                <tr>
	                  <th class="mdl-data-table__cell--non-numeric">User Name</th>
	                  <th>Password</th>
	                </tr>
	              </thead>
	              <tbody>
	              <c:forEach items = "${users}" var="user">
	                  <tr>
	                    <td class="mdl-data-table__cell--non-numeric"><c:out value = "${user.userName}"/></td>
	                    <td><c:out value = "${user.password}"/></td>
	                    <td>
						<a href="edit?id=${user.id}">
							<button class="mdl-button mdl-js-button mdl-button--fab mdl-button--mini-fab">
						  		<i class="material-icons">edit</i>
							</button>
						</a>
						<a href="delete?id=${user.id}">
							<button class="mdl-button mdl-js-button mdl-button--fab mdl-button--mini-fab">
						  		<i class="material-icons">delete</i>
							</button>
						</a>
	                    </td>
	                  </tr>
	              </c:forEach>
					<tr><a href="form">
							<button class="mdl-button mdl-js-button mdl-button--fab mdl-button--mini-fab">
						  		<i class="material-icons">add</i>
							</button>
						</a>
					</tr>
	              </tbody>              
	            </table>
	            </div>    
      	</main>
      </div>
    </div>



    <!-- <div class="mdl-layout mdl-js-layout mdl-color--grey-100 box-center">
    	<main class="mdl-layout__content">
    		
    	</main>
    </div> -->
  <script src="js/scripts.js"></script>
</body>
</html>
