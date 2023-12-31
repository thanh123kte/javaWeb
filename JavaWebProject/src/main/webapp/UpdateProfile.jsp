<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>

<head>
  <!-- Basic -->
  <meta charset="utf-8" />
  
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <!-- Mobile Metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <!-- Site Metas -->
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">

  <title>
    Giftos
  </title>

	

  <!-- slider stylesheet -->
  
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />
 
  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />  
   <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="css/responsive.css" rel="stylesheet" />
    <link href="css/font-awesome.min.css" rel="stylesheet" />
    
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/MaterialDesign-Webfont/5.3.45/css/materialdesignicons.css" integrity="sha256-NAxhqDvtY0l4xn+YVa6WjAcmd94NNfttjNsDmNatFVc=" crossorigin="anonymous" />
	<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>  
	<style type="text/css">
	
        section {
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        row {
            background-color: #eee;
            margin-top: 30px;
            width: 60%;
            text-align: center;
        }
	
	</style>
    
</head>

<body>
  <jsp:include page="Menu.jsp"></jsp:include>
	
	
	<section style="background-color: #eee; margin-top: 30px; width: 60%;margin-left:20%; text-align: center">
	
	<form action="update?id=${sessionScope.acc.id}" method="post">
	
		<div class="row">
	      <div class="col-lg-4">
	        <div class="card mb-4">
	          <div class="card-body text-center">
	            <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp" alt="avatar"
	              class="rounded-circle img-fluid" style="width: 150px;">
	            <h5 class="my-3">${sessionScope.acc.name}</h5>
	            <div class="d-flex justify-content-center mb-2">
	              <a><button type="button" class="btn btn-primary">Edit profile</button></a>
	              <a href="ChangePass.jsp"><button type="button" class="btn btn-outline-primary ms-1">Change pass</button></a>
	            </div>
	          </div>
	        </div>
	      </div>
	      <div class="col-lg-8">
	        <div class="card mb-4">
	          <div class="card-body">
	            <div class="row">
	              <div class="col-sm-3">
	                <p class="mb-0">Full Name</p>
	              </div>
	              <div class="col-sm-9">
	              	<input name="fullname" type="text" class="form-control" value="${sessionScope.acc.name}" autocomplete="off" required="required" >
	              </div>
	            </div>
	            <hr>
	            <div class="row">
	              <div class="col-sm-3">
	                <p class="mb-0">Email</p>
	              </div>
	              <div class="col-sm-9">
	                <input name="email" type="text" class="form-control" value="${sessionScope.acc.email}" autocomplete="off" required="required" >
	              </div>
	            </div>
	            <hr>
	            <div class="row">
	              <div class="col-sm-3">
	                <p class="mb-0">Phone</p>
	              </div>
	              <div class="col-sm-9">
	                <input name="phone" type="text" class="form-control" value="${sessionScope.acc.phone}" autocomplete="off" required="required" >
	              </div>
	            </div>
	            <hr>
	            <div class="row">
	              <div class="col-sm-3">
	                <p class="mb-0">Address</p>
	              </div>
	              <div class="col-sm-9">
	                <input name="address" type="text" class="form-control" value="${sessionScope.acc.address}" autocomplete="off" required="required" >
	              </div>
	            </div>
	          </div>
	        </div>
	        <div class="row">
	              <div class="col-sm-9">
	              	<input type="submit" value="Save" class="btn btn-block btn-primary">
	              </div>
	            </div>
	        <hr>
            
	</form>
    
 
  <jsp:include page="Footer.jsp"></jsp:include>
  
  <!-- custom script -->
  
 
  <!-- end info section -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
  <script src="js/jquery-3.4.1.min.js"></script>
  <script src="js/bootstrap.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js">
  </script>
  <script src="js/custom.js"></script>

</body>

</html>
  