<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="resources/mystyle.css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
$(document).ready(function() {
	$("#btnUpdate").click(function() {
		$.ajax({
			url : "passcheck",
			type : "post",
			data : {
				"seq" : "${dto.seq }",
				"password" : $("#password").val(),
			},
			success : function(data) {
				if(data=="1"){
					location.href="update?seq=${dto.seq }";
				}else{
					alert("비밀번호가 틀렸습니다.");
				}
			}
		});
	})
	$("#btnDelete").click(function() {
		$.ajax({
			url : "passcheck",
			type : "post",
			data : {
				"seq" : "${dto.seq }",
				"password" : $("#password").val(),
			},
			success : function(data) {
				if(data=="1"){
					location.href="delete?seq=${dto.seq }";
				}else{
					alert("비밀번호가 틀렸습니다.");
				}
			}
		});
	})
})
function btnReply(groups,levels,steps){
	location.href="reply?groups="+groups+"&levels="+levels+"&steps="+steps;
}	
</script>
</head>
<body>
	<a href="write">글쓰기</a> |
	<a href="list">리스트</a>
	<hr>
	<h2>View</h2>
	<hr>
	<div align="center">
		<table>
			<tr>
				<th>작성자</th>
				<td width="600">${dto.writer }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${dto.writer }</td>
			</tr>
			<tr>
				<th height="200">내용</th>
				<td valign="top">${dto.content }</td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="password"
					name="password" id="password" placeholder="비밀번호"> <input
					type="button" id="btnUpdate" name="btnUpdate" value="수정"> <input
					type="button" id="btnDelete" name="btnDelete" value="삭제"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button"
					onclick="btnReply(${dto.groups },${dto.levels },${dto.steps })"
					value="답글쓰기"></td>
			</tr>
		</table>
	</div>
	<br>
	<br>
	<br>
	<div align="center">
		<c:if test="${fn:length(cmt)!=0 }">
			<table>
				<tr>
					<th width="100">이름</th>
					<th width="500">내용</th>
					<th width="100">작성일</th>
				</tr>
				<c:forEach items="${cmt }" var="cmt">
					<tr>
						<td>${cmt.name }</td>
						<td>${cmt.msg }</td>
						<td>${cmt.created }</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
	<br>
	<div align="center">
		<form action="insertcmt">
			<input type="hidden" id="bnum" name="bnum" value="${dto.seq }">
			<table>
				<tr>
					<td rowspan="2"><textarea rows="5" cols="50" id="msg"
							name="msg"></textarea>
					<td><input type="text" id="name" name="name" placeholder="이름">
				</tr>
				<tr>
					<td align="center"><input type="submit" value="댓글쓰기"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>