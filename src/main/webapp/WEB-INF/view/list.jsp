<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list</title>
</head>
<body>
	<a href="<c:url value="/write"/>">글작성</a>
	<c:choose>
		<c:when test="${not empty notePadList.notePadList}">
			<c:forEach items="${notePadList.notePadList}" var="notePad">
				<div>${notePad.notePadId} /
				<c:choose>
					<c:when test="${fn:length(notePad.content)>10}">
					<a href="<c:url value="/detail/${notePad.notePadId}"/>">
				 	${fn:substring(notePad.content, 0, 10)}...</a>
					</c:when>
					<c:otherwise>
					<a href="<c:url value="/detail/${notePad.notePadId}"/>">${notePad.content}</a>
					</c:otherwise>
				</c:choose>
				<%-- <c:if test="${fn:length(notePad.content)>10}">
				 	<a href="<c:url value="/detail/${notePad.notePadId}"/>">
				 	${fn:substring(notePad.content, 0, 10)}...</a>
				</c:if>  --%>
				${notePad.createdDate}</div> 
				
			</c:forEach>
		</c:when>
		<c:when test="${not empty noteVO}">
			<div>${noteVO.notePadId}</div>
			<div>${noteVO.createdDate}</div>
			<div style="width:300px; height:300px;">${noteVO.content}</div>
			<div><a href="<c:url value="/modify/${noteVO.notePadId}"/>">수정</a>
			<a style="margin-left:50px" href="<c:url value="/delete/${noteVO.notePadId}"/>">삭제</a>
			<a style="margin-left:50px" href="<c:url value="/list"/>">목록으로</a></div>
		</c:when>
		<c:otherwise>
			<div>작성된 메모가 없습니다.</div>
		</c:otherwise>
	</c:choose>
</body>
</html>