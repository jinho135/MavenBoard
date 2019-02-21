<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="resources/mystyle.css">
</head>
<body>
	<a href="write">글쓰기</a> |
	<a href="list">리스트</a>
	<hr>
	<h2>Reply</h2>
	<hr>
	<div align="center">
		<form action="reply" name="frm" method="post">
			<input type="hidden" name="groups" value="${groups }"> <input
				type="hidden" name="levels" value="${levels }"> <input
				type="hidden" name="steps" value="${steps }">
			<table>
				<tr>
					<td>작성자</td>
					<td><input type="text" name="writer"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea name="content" rows="20" cols="50"></textarea>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="등록"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>