<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<head>
<title>Admin</title>
 <meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Visitors Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap-css -->
<link rel="stylesheet" href="./template/css/bootstrap.min.css" >
<!-- //bootstrap-css -->
<!-- Custom CSS -->
<link href="./template/css/style.css" rel='stylesheet' type='text/css' />
<link href="./template/css/style-responsive.css" rel="stylesheet"/>
<!-- font CSS -->
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<!-- font-awesome icons -->
<link rel="stylesheet" href="./template/css/font.css" type="text/css"/>
<link href="./template/css/font-awesome.css" rel="stylesheet"> 
<link rel="stylesheet" href="./template/css/morris.css" type="text/css"/>
<!-- calendar -->
<link rel="stylesheet" href="./template/css/monthly.css">
<!-- //calendar -->
<!-- //font-awesome icons -->
<script src="./template/js/jquery2.0.3.min.js"></script>
<script src="./template/js/raphael-min.js"></script>
<script src="./template/js/morris.js"></script>

<style>
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }

        td form {
            margin: 0;
        }

        td form input {
            margin-right: 5px;
        }
    </style>

	<script>
    function handleKeyPress(event) {
        // Kiểm tra xem phím Enter đã được nhấn
        if (event.keyCode === 13) {
            // Ngăn chặn sự kiện mặc định của trình duyệt (tránh việc gửi form theo cách thông thường)
            event.preventDefault();
            
            // Gọi hàm để submit form
            submitForm();
        }
    }

    function submitForm() {
        // Lấy đối tượng form theo id và gửi form
        document.getElementById("searchForm").submit();
    }
</script>
	
	
</head>
<body>
<section id="container">
<!--header start-->
<header class="header fixed-top clearfix">
<!--logo start-->
<div class="brand">
    <a href="index.html" class="logo">
        VISITORS
    </a>
    <div class="sidebar-toggle-box">
        <div class="fa fa-bars"></div>
    </div>
</div>


<div class="top-nav clearfix">
    <!--search & user info start-->
    <ul style="display: flex;" class="nav pull-right top-menu">
       <form id="searchForm" action="searchadmin" method="post">
        		<input type="text" name="name" class="form-control search"  placeholder="Search" onkeypress="handleKeyPress(event)">
        	</form>
        <!-- user login dropdown start-->
        <li class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                <img alt="" src="images/2.png">
                <span class="username">${sessionScope.acc.account}</span>
                <b class="caret"></b>
            </a>
            <ul class="dropdown-menu extended logout">
                <li><a href="#"><i class=" fa fa-suitcase"></i>Profile</a></li>
                <li><a href="#"><i class="fa fa-cog"></i> Settings</a></li>
                <li><a href="logout"><i class="fa fa-key"></i> Log Out</a></li>
            </ul>
        </li>
        <!-- user login dropdown end -->
       
    </ul>
    <!--search & user info end-->
</div>
</header>
<!--header end-->
<!--sidebar start-->
<aside>
    <div id="sidebar" class="nav-collapse">
        <!-- sidebar menu start-->
        <div class="leftside-navigation">
            <ul class="sidebar-menu" id="nav-accordion">
                <li>
                    <a class="active" href="dashboard">
                        <i class="fa fa-dashboard"></i>
                        <span>Dashboard</span>
                    </a>
                </li>
                
                <li class="">
                    <a href="admin/addProduct.jsp">
                        <i class="fa fa-book"></i>
                        <span>Add product</span>
                    </a>
                </li>
                <li>
                    <a href="listordercontrol">
                        <i class="fa fa-bullhorn"></i>
                        <span>List order </span>
                    </a>
                </li>
                
                
            </ul>     
        </div>
        <!-- sidebar menu end-->
    </div>
</aside>
<!--sidebar end-->
<!--main content start-->
<section id="main-content">
	<section class="wrapper">

		<!-- //market-->
		<div class="row">
			<div class="panel-body">
				<div class="col-md-12 w3ls-graph">
					<!--agileinfo-grap-->
						<div class="agileinfo-grap">
							<div class="agileits-box">
								<header class="agileits-box-header clearfix">
									<h3>List Product</h3>
										<div class="toolbar">
											
											
										</div>
								</header>
								<div class="agileits-box-body clearfix">
								
									<table>
								        <tr>
								            <th>Order ID</th>
								            <th>Order code</th>
								            <th>Date</th>
								            <th>Status</th>
								            <th>Option</th>
								        </tr>
								        
								        <c:forEach items="${listo}" var="order">
								        	<a href="">
									        	<tr>
										            <td>${order.id }</td>
										            <td>${order.code }</td>
										            <td>${order.date }</td>
										            <td>${order.status }</td>
										            <td style="display: flex;">
										                <form action="acceptorder" method="post">
										                	<input type="hidden" name="id" value="${order.id}">
										                	<input type="hidden" name="check" value="1">
										                    <input type="submit" value="Duyệt">
										                </form>
										                <form action="acceptorder" method="post">
										                	<input type="hidden" name="id" value="${order.id}">
										                	<input type="hidden" name="check" value="2">
										                    <input type="submit" value="Huỷ">
										                </form>
										                <form action="acceptorder" method="post">
										                	<input type="hidden" name="id" value="${order.id}">
										                	<input type="hidden" name="code" value="${order.code}">
										                	<input type="hidden" name="check" value="3">
										                    <input type="submit" value="Chi tiết">
										                </form>
										            </td>
										        </tr>
								        	</a>
									          
								        </c:forEach>
								      	
								    </table>
									
								</div>
							</div>
						</div>
	<!--//agileinfo-grap-->

				</div>
			</div>
		</div>
		
</section>


    <div class="clear-both"></div>
    </div>
    </div>
    <div id="admin-footer" style="margin-top: 40%">
        <div class="container">
            <div style="margin-left:30%;font-size: 25px" class="left-panel">
                 Copyright 2022 - Design by <a  href="fb.com/DtrThanh19"> Thanh Dao & <a href="fb.com/capznecacban"> Ngoc Lien
            </div>
            <div class="clear-both"></div>
        </div>
    </div>
</body>
    <script src="https://cdn.ckeditor.com/4.20.0/standard/ckeditor.js"></script>
    <script type="text/javascript">
        CKEDITOR.replace( 'editor' );
    </script>
</html>

<script src="./template/js/bootstrap.js"></script>
<script src="./template/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="./template/js/scripts.js"></script>
<script src="./template/js/jquery.slimscroll.js"></script>
<script src="./template/js/jquery.nicescroll.js"></script>
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
<script src="./template/js/jquery.scrollTo.js"></script>

</body>
</html>
