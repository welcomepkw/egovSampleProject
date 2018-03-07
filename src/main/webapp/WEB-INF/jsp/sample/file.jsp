<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<form id="frm" action="<c:url value="/file/filePS.do"/>" method="POST" enctype="multipart/form-data">
		<div>
			<label>file</label>
			<input type="file" name="file1">
		</div>
		<div>
			<button type="submit">sumit</button>
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
      file1: {
      	required: true,
      	accept: "image/jpeg, image/pjpeg"
      }
      
    },
    // Specify validation error messages
    messages: {
      file1: {
        required: "파일을 선택해 주세요.",
        accept: "jpg 파일만 가능합니다."
      }
    },
    submitHandler: function(form) {
      form.submit();
    }
  });
}
</script>