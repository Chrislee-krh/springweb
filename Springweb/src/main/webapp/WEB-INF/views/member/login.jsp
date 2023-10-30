<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SB Admin 2 - Login</title>

  <!-- Custom fonts for this template-->
  <link href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="${pageContext.request.contextPath}/resources/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

  <div class="container">

    <!-- Outer Row -->
    <div class="row justify-content-center">

      <div class="col-xl-10 col-lg-12 col-md-9">

        <div class="card o-hidden border-0 shadow-lg my-5">
          <div class="card-body p-0">

            <div class="row">
              <div class="col-lg-3"></div>
              
              <div class="col-lg-6">
                <div class="p-5">
                 <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-4">로그인</h1>
                  </div>
                  

                  <form class="user" action="loginForm" method="post">
                    <div class="form-group">
                      <input type="text" class="form-control form-control-user" name="id" placeholder="아이디">
                    </div>
                    <div class="form-group">
                      <input type="password" class="form-control form-control-user" name="pw" placeholder="비밀번호">
                    </div>

                    <input type="submit" class="btn btn-primary btn-user btn-user btn-block" value="로그인">
                  	<input type="button" class="btn btn-primary btn-user btn-user btn-block" value="회원가입" onclick="location.href='join' ">
                  </form>
                  
                  
                  <hr>

                  <div class="text-center">
                    <a class="small" href="${pageContext.request.contextPath}">메인화면</a>
                  </div>
                </div>
                <div class="col-lg-3"></div>
              </div>
            </div>
          </div>
        </div>

      </div>

    </div>

  </div>
  

  <!-- Bootstrap core JavaScript-->
  <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
  <%-- 
  <script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="${pageContext.request.contextPath}/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="${pageContext.request.contextPath}/resources/js/sb-admin-2.min.js"></script>
   --%>
  

  <script type="text/javascript">
  	$(document).ready(function(){
  		var msg = '${msg}'; // el표기법
  		if(msg !== ''){
  			alert(msg);
  		}
  	});
  	
  	
  </script>
  
</body>

</html>
