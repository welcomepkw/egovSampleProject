<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
	li{
		cursor: pointer;
	}
</style>
<div>
	<ul>
		<c:forEach items="${datas }" var="data">
			<li onclick="moveUpdate(${data.id})">
				<span>
					${data.id }
				</span>
				<span>
					${data.text1 }
				</span>
				<span>
					${data.text2 }
				</span>
				<span>
					<fmt:formatDate value="${data.createDate}" pattern="yyyy.MM.dd HH:mm:ss" />
				</span>
			</li>
		</c:forEach>
	</ul>	
</div>
<script type="text/javascript">
function moveUpdate(id){
	window.location.href = '<c:url value="/sample/update.do"/>?id='+id;
}
</script>