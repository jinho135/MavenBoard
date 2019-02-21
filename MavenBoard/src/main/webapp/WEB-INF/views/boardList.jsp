<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="resources/mystyle.css">
</head>
<body>
	<a href="write">글쓰기</a> | 리스트
	<hr>
	<h2>List</h2>
	<hr>
	<div align="center">
		<table>
			<tr>
				<th width="50">번호</th>
				<th width="500">제목</th>
				<th width="100">작성자</th>
				<th width="150">작성일</th>
				<th width="50">조회수</th>
			</tr>
			<c:forEach items="${lists }" var="lists">
				<tr>
					<td>${lists.seq }</td>
					<td><c:forEach begin="2" end="${lists.levels }" step="1">
							&nbsp;&nbsp;
						</c:forEach> <c:if test="${lists.levels!=0 }">
							<img src="resources/re.gif">
						</c:if><a href="detail?seq=${lists.seq }">${lists.title }</a></td>
					<td>${lists.writer }</td>
					<td>${lists.regdate }</td>
					<td>${lists.hitcount }</td>
				</tr>
			</c:forEach>
		</table>
		<form action="list" method="post">
			<select id="field" name="field">
				<option value="title">제목</option>
				<option value="content">본문</option>
			</select><input type="text" id="word" name="word"> <input
				type="submit" value="검색">
		</form>
	</div>
	<div align="center">
		<!-- 이전 -->
		<c:if test="${startpage>blockpage }">
			<a
				href="list?pageNum=${startpage-blockpage}&field=${field }&word=${word }">[이전]</a>
		</c:if>
		<!-- 페이지출력 -->
		<c:forEach begin="${startpage }" end="${endpage }" var="i">
			<c:if test="${i==currentPage }">
				[${i }]
			</c:if>
			<c:if test="${i!=currentPage }">
				<a href="list?pageNum=${i }&field=${field }&word=${word }">[${i }]</a>
			</c:if>
		</c:forEach>
		<!-- 다음 -->
		<c:if test="${endpage<totpage }">
			<a href="list?pageNum=${endpage+1}&field=${field }&word=${word }">[다음]</a>
		</c:if>
	</div>
</body>
</html>