<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" 	uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" 	uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" 		uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<title>sample project</title>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/style.css"/>'>
<script type="text/javascript" src='<c:url value="/resources/vender/jquery/jquery-1.12.5.min.js"/>'></script>
</head>
<body>
<tiles:insertAttribute name="menu"/>
<div class="contentWrapper">
	<tiles:insertAttribute name="body"/>
</div>
<tiles:insertAttribute name="footer"/>
<script type="text/javascript" src='<c:url value="/resources/vender/jquery_validate/jquery.validate-1.17.0.min.js"/>'></script>
</body>
</html>



