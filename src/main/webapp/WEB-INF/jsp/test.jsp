<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page session="false" %>
<html>
	<head>
		<title>Test Tiles </title>
		
	</head>
	<body>
		<div id="header">
			<h1><a href="<c:url value="/"/>">Test Tiles Showcase</a></h1>
		</div>
		
		<div id="content">
			<tiles:insertAttribute name="content" />
		</div>		
	</body>
</html>
