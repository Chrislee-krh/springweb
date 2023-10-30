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
								<!-- 7. 조회 페이지 이동 -->
								<!-- 상세 페이지 이동 후 목록 화면 이동시, 기존 페이지를 유지 못함.
									유지하려면, 페이지 이동시 pageNum 값을 가지고 다녀야 한다.
									content로 -->
								
									<a href="content?num=${board.num}&pageNum=${pageMaker.cri.pageNum}"> ${board.title } </a>
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
                       	<!-- 1. 이전 버튼 -->
                       	<c:if test="${pageMaker.prev }">
	                       	<li class="page-item">
								<a class="page-link" href="list?pageNum=${pageMaker.startPage-1 }">Previous</a>
							</li>
						</c:if>
					   <!-- 3. 페이지 번호 -->
					   <c:forEach var="page" begin="${pageMaker.startPage }" end="${pageMaker.endPage }">
					   <!-- 페이지별 나오게 값을 전달하면서 동시에 어떤 페이지인지 표시할 수 있게 active 활성 -->
					    
					    <li class="page-item ${pageMaker.cri.pageNum == page?'active':'' }">
					   		<a class="page-link" href="list?pageNum=${page }">${page }</a>
					    	<%-- <a class="page-link" href="list?pageNum=${page }">${page }</a> --%>
					    </li>
					    </c:forEach>
					   <!-- 2. 다음 버튼 활성화 여부 -->
					   <c:if test="${pageMaker.next }">
					    <li class="page-item">
					      <a class="page-link" href="list?pageNum=${pageMaker.endPage+1 }">Next</a>
					    </li>
					   </c:if>
				    </ul>
					<!-- 페이징 처리 끝 -->
				</div>
			</div>
		</div>
	<!-- End of Main -->

	<%@ include file="../include/footer.jsp"%>
</body>

</html>
