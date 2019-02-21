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
	글쓰기 |
	<a href="list">리스트</a>
	<hr>
	<h2>Update</h2>
	<hr>
	<div align="center">
		<form action="update?seq=${dto.seq }" name="frm" method="post">
			<table>
				<tr>
					<td>작성자</td>
					<td><input type="text" name="writer" value="${dto.writer }"></td>
				</tr>
				<tr>
					<td>비밀번호변경</td>
					<td><input type="password" name="password"
						value="${dto.password }"></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="title" value="${dto.title }"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea name="content" rows="20" cols="50">${dto.content }</textarea>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="수정"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>