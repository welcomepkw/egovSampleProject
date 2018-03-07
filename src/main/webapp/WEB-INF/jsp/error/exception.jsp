<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<c:out value="${requestScope['javax.servlet.error.status_code'] }"></c:out>
	<c:out value="${requestScope['javax.servlet.error.exception_type'] }"></c:out>
	<c:out value="${requestScope['javax.servlet.error.message'] }"></c:out>
	<c:out value="${requestScope['javax.servlet.error.request_uri'] }"></c:out>
	<c:out value="${requestScope['javax.servlet.error.exception'] }"></c:out>
	<c:out value="${requestScope['javax.servlet.error.servlet_name'] }"></c:out>
</div>