<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
</head>
<body id="page-top">
	<!-- Page Wrapper -->
	<%@include file="../include/header.jsp"%>
	<!-- Begin Page Content -->
		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">게시판</h1>
		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">공지사항 샘플 게시판
                    <button type="button" class="btn btn-primary btn-sm float-right" onclick="location.href='register'">글쓰기</button>
                </h6>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" width="100%" cellspacing="0">
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>수정일</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="board" items="${board_list }" varStatus="num" >
							<tr>
								<td>${board.num }</td>             <!-- num.index가능 -->
								<td>
									<a href="content?num=${board.num}"> ${board.title } </a>
								</td>
								<td>${board.writer }</td>
								<td>
									<fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${board.regdate }"/> 
								</td>
								<td>
									<fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${board.updatedate }"/> 
								</td>
							</tr>
						</c:forEach>
						</tbody>
						
					</table>
					<!-- 페이징 처리 부분 부트스트랩 참고 -->
					<ul class="pagination justify-content-center">
                       	 			<li class="page-item">
							<a class="page-link" href="##############">Previous</a>
						</li>
					   
					    <li class="page-item">
					    	<a class="page-link" href="##############">1</a>
					    </li>
					   
					    <li class="page-item">
					      <a class="page-link" href="##############">Next</a>
					    </li>
				    </ul>
					<!-- 페이징 처리 끝 -->
				</div>
			</div>
		</div>
	<!-- End of Main -->

	<%@ include file="../include/footer.jsp"%>
</body>

</html>
