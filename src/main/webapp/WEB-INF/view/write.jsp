<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${not empty note}">
			<c:url var="doModify" value="/doModify/${note.notePadId}"/>
			<form:form commandName="notePadVO" method="post" action="${doModify}">
				<label for="content">메모</label><br/>
				<textarea rows="30px" cols="30px" id="content" name="content">${note.content}</textarea><br/>
				<form:errors path="content"/><br/>
				<input type="submit" value="수정">
			</form:form>
		</c:when>
		<c:otherwise>
			<c:url var="doWrite" value="/doWrite"/>
			<form:form commandName="notePadVO" method="post" action="${doWrite}">
				<label for="content">메모</label><br/>
				<textarea rows="30px" cols="30px" id="content" name="content"></textarea><br/>
				<form:errors path="content"/><br/>
				<input type="submit" value="등록">
			</form:form>
		</c:otherwise>
	</c:choose>

</body>
</html>