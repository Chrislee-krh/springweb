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
    <h1 class="page-header">Board Register</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="card">
      <div class="card-header bg-primary text-white">게시글 등록</div>
      <div class="card-body">
        <form role="form" action="register" method="post" id="regForm">
          <div class="form-group">
            <label>Title</label>
            <input class="form-control" name='title' id="title">
          </div>

          <div class="form-group">
            <label>Contents</label>
            <textarea class="form-control" rows="5" name='content' id="content"></textarea>
          </div>

          <div class="form-group">
            <label>Writer</label>
            <input class="form-control" name='writer' id="writer">
          </div>
          <button type="button" class="btn btn-primary" onclick="register()">등록</button>
          <button type="button" class="btn btn-primary" onclick="location.href='list'">취소</button>
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
<script type="text/javascript">
	function register(){
		//$("#아이디")는 HTML 아이디 속성에 한 번에 접근..
		//val() 함수를 사용하면 해당 값에 접근이 가능함
		if($("#title").val() == ""){
			alert("Title should be typed in!")
		} else if($("#writer").val() == ""){
			alert("Writer section cannot be empty!")
		} else if(confirm("Register?")){
			$("#regForm").submit();
		}
		
	}	
</script>
</body>
</html>