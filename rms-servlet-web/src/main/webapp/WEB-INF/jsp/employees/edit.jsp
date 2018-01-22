<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix = "rms" uri = "/WEB-INF/tags/link.tld"%>
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
    <div class="mdl-layout mdl-js-layout mdl-color--grey-100">
    	<main class="mdl-layout__content">
    		<div class="mdl-card mdl-shadow--6dp">
    			<div class="mdl-card__title mdl-color--primary mdl-color-text--white">
    				<h2 class="mdl-card__title-text">Add Employee</h2>
    			</div>
    			<form action="edit" method="POST">
    	  			<div class="mdl-card__supporting-text">
    					<input name="id" value="${employee.getId()}" hidden="true"/>
    					<div class="mdl-textfield mdl-js-textfield">
    						<input class="mdl-textfield__input" type="text" id="name" name="name" value="${employee.getName()}"/>
    						<label class="mdl-textfield__label" for="username">Name</label>
    					</div>
    					<div class="mdl-textfield mdl-js-textfield">
    						<input class="mdl-textfield__input" type="text" id="position" name="position" value="${employee.getPosition()}"/>
    						<label class="mdl-textfield__label" for="position">Position</label>
    					</div>
    					<div class="mdl-select mdl-js-select mdl-select--floating-label">
	    					<select class="mdl-select__input" name="office" id="office" value="${employee.getOffice()}">
	    						<option value="Bali">Bali</option>
	    						<option value="Bandung">Bandung</option>
	    						<option value="Jakarta">Jakarta</option>
	    						<option value="Jogjakarta">Jogjakarta</option>
	    					</select>
	    					<label class="mdl-select__label" for="office">Office</label>
    					</div>    				
    				</div>
	    			<div class="mdl-card__actions mdl-card--border">
	    				<button type="submit" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">Save</button>
	    			</div>
    			</form>
    		</div>
    	</main>
    </div>
  <script src="js/scripts.js"></script>
</body>
</html>
