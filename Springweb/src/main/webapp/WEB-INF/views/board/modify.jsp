<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../include/header.jsp" %>

<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">Board Modify Page</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="card">
      <div class="card-header bg-primary text-white">수정 페이지</div>
      <div class="card-body">

        <form role="form" action="update" method="post" id="modForm">
          
          <div class="form-group">
            <label>번호</label>
            <input class="form-control" value="${board.num }" name='num' id="num" readonly="readonly">
          </div>
          
          <div class="form-group">
            <label>제목</label>
            <input class="form-control" value="${board.title }" name='title' id="title">
          </div>

          <div class="form-group">
            <label>내용</label>
            <textarea class="form-control" rows="5" name='content' id="content">${board.content }</textarea>
          </div>

          <div class="form-group">
            <label>작성자</label>
            <input class="form-control" value="${board.writer }" name='writer' id="writer" readonly="readonly">
          </div>
          
          
          
          <button type="submit" class="btn btn-primary" >변경</button>
          <button type="button" class="btn btn-secondary" onclick="location.href='delete?num=${board.num}'">삭제</button>
          <button type="button" class="btn btn-dark" onclick="location.href='list'">목록</button>
        </form>



      </div>
      <!--  end card-body -->
    </div>
    <!--  end card-body -->
  </div>
  <!-- end card -->
</div>
<!-- /.row -->

<%@ include file="../include/footer.jsp" %>



</body>
</html>