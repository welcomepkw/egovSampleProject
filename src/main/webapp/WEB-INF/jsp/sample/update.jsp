<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<form id="frm" action="<c:url value="/sample/updatePS.do"/>" method="POST">
		<input type="hidden" name="id" value="${data.id }">
		<div>
			<label>text1:</label>
			<input type="text" name="text1" id="text1" style="width: 100px;" value="${data.text1 }">
		</div>
		<div>
			<label>text2:</label>
			<input type="text" name="text2"  id="text2" style="width: 100px;" value="${data.text2 }">
		</div>
		<div>
			<button type="submit" id="sumbitBtn">submit</button>
		</div>
	</form>
</div>
<script type="text/javascript">
// run after loading all 
$(document).ready(function(){
	submitData();
});

function submitData(){
	$("#frm").validate({
    rules: {
      text1: {
      	required: true,
      	minlength: 2,
      	maxlength: 10
      	// email: true
      },
      text2: {
      	required: true,
      	minlength: 2,
      	maxlength: 10
      	// email: true
      }
      
    },
    // Specify validation error messages
    messages: {
      text1: {
        required: "text1 은 필수입력입니다.",
        minlength: "2자리 이상 입력하세요.",
        maxlength: "10자리 이하로 입력하세요."
      },
      text2: {
        required: "text1 은 필수입력입니다.",
        minlength: "2자리 이상 입력하세요.",
        maxlength: "10자리 이하로 입력하세요."
      }
    },
    submitHandler: function(form) {
      form.submit();
    }
  });
}
</script>