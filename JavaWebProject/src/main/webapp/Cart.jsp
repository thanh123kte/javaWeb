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
    
	    body{
	    margin-top:20px;
	    background-color: #f1f3f7;
		}
		
		.avatar-lg {
		    height: 5rem;
		    width: 5rem;
		}
		
		.font-size-18 {
		    font-size: 18px!important;
		}
		
		.text-truncate {
		    overflow: hidden;
		    text-overflow: ellipsis;
		    white-space: nowrap;
		}
		
		a {
		    text-decoration: none!important;
		}
		
		.w-xl {
		    min-width: 160px;
		}
		
		.card {
		    margin-bottom: 24px;
		    -webkit-box-shadow: 0 2px 3px #e4e8f0;
		    box-shadow: 0 2px 3px #e4e8f0;
		}
		
		.card {
		    position: relative;
		    display: -webkit-box;
		    display: -ms-flexbox;
		    display: flex;
		    -webkit-box-orient: vertical;
		    -webkit-box-direction: normal;
		    -ms-flex-direction: column;
		    flex-direction: column;
		    min-width: 0;
		    word-wrap: break-word;
		    background-color: #fff;
		    background-clip: border-box;
		    border: 1px solid #eff0f2;
		    border-radius: 1rem;
		}
    
    </style>
    
    
    <script>
    function addToCart() {
        // Kiểm tra xem sessionScope.acc có tồn tại không
        var isUserLoggedIn = ${not empty sessionScope.acc};

        // Nếu không tồn tại, hiển thị thông báo và không thực hiện thêm vào giỏ hàng
        if (!isUserLoggedIn) {
            alert("Vui lòng đăng nhập.");
        } else {
            // Lấy giá trị quantity từ ô nhập số
            var quantity = document.getElementById("quantity").value;

            // Lấy giá trị pid và uid từ biến của bạn (thay thế bằng giá trị thực tế)
            var pid = "${detail.id}";
            var uid = "${sessionScope.acc.id}";

            // Tạo URL với các tham số
            var addToCartURL = "addtocart?pid=" + pid + "&uid=" + uid + "&quantity=" + quantity;

            // Chuyển hướng đến URL
            window.location.href = addToCartURL;
        }
    }
</script>
    
</head>

<body>
  <jsp:include page="Menu.jsp"></jsp:include>

<div style="margin-top: 30px; background-color: #eee;" class="container">
    <div class="row">
        <div class="col-xl-8">
        	<c:forEach items="${listC}" var="product">
        		<div class="card border shadow-none">
	                <div class="card-body">
	
	                    <div class="d-flex align-items-start border-bottom pb-3">
	                        <div class="me-4">
	                            <img src="${product.image }" alt="" class="avatar-lg rounded">
	                        </div>
	                        <div class="flex-grow-1 align-self-center overflow-hidden">
	                            <div >
	                                <h5 class="text-truncate font-size-18"><a style="margin-left: 20px" href="#" class="text-dark">${product.name }</a></h5>
	                            </div>
	                        </div>
	                        <div class="flex-shrink-0 ms-2">
	                            <ul class="list-inline mb-0 font-size-16">
	                                <li class="list-inline-item">
	                                    <a href="delete?pid=${product.id}&uid=${sessionScope.acc.id}" class="text-muted px-1">
	                                        <i class="mdi mdi-trash-can-outline"></i>
	                                    </a>
	                                </li>
	                               
	                            </ul>
	                        </div>
	                    </div>
	
	                    <div>
	                        <div class="row">
	                            <div class="col-md-4">
	                                <div class="mt-3">
	                                    <p class="text-muted mb-2">Price</p>
	                                    <h5 class="mb-0 mt-2"><span class="text-muted me-2"></span>${product.price }$</h5>
	                                </div>
	                            </div>
	                            <div class="col-md-5">
	                                <div class="mt-3">
	                                    <p class="text-muted mb-2">Quantity</p>
	                                    <div class="d-inline-flex">
	                                        ${product.quantity }
	                                    </div>
	                                </div>
	                            </div>
	                            <div class="col-md-3">
	                                <div class="mt-3">
	                                    <p class="text-muted mb-2">Total</p>
	                                    <h5>${product.quantity*product.price }</h5>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	
	                </div>
	            </div>
        	</c:forEach>
            
            <!-- end card -->


        </div>

        <div class="col-xl-4">
            <div class="mt-5 mt-lg-0">
                <div class="card border shadow-none">
                    <div class="card-header bg-transparent border-bottom py-3 px-4">
                        <h5 class="font-size-16 mb-0">Order Summary <span class="float-end"></span></h5>
                    </div>
                    <div class="card-body p-4 pt-2">

                        <div class="table-responsive">
                            <table class="table mb-0">
                                <tbody>
                                    
                                    <tr>
                                        <td>Discount : </td>
                                        <td class="text-end">- 0$</td>
                                    </tr>
                                    <tr>
                                        <td>Shipping Charge :</td>
                                        <td class="text-end">1$</td>
                                    </tr>
                                    <tr>
                                        <td>VAT(10%) : </td>
                                        <td class="text-end">${total*10/100}$</td>
                                    </tr>
                                    <tr>
                                        <td>Sub Total :</td>
                                        <td class="text-end">${total}$</td>
                                    </tr>
                                    <tr class="bg-light">
                                        <th>Total :</th>
                                        <td class="text-end">
                                            <span class="fw-bold">
                                                ${1+total+total*10/100} $
                                            </span>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <!-- end table-responsive -->
                    </div>
                </div>
            </div>
             <div class="row my-4">
               
                <div class="col-sm-6">
                    <div class="text-sm-end mt-2 mt-sm-0">
                        <a href="checkout?uid=${sessionScope.acc.id }" class="btn btn-success">
                            <i class="mdi mdi-cart-outline me-1"></i> Checkout </a>
                    </div>
                </div> <!-- end col -->
            </div> <!-- end row-->
        </div>
    </div>
    <!-- end row -->
    
</div>
  
 
  <jsp:include page="Footer.jsp"></jsp:include>
  
  <!-- custom script -->
  <script>
	document.addEventListener("DOMContentLoaded", function() {
	  // Get the "Shop" link element
	  var mapLink = document.querySelector('a[href="#map"]');
	
	  // Add a click event listener to the "Shop" link
	  mapLink.addEventListener("click", function(event) {
	    event.preventDefault(); // Prevent the default link behavior
	
	    // Get the target element (the product page)

	    var targetElement = document.getElementById("map");
	    // Scroll smoothly to the target element
	    targetElement.scrollIntoView({
	      behavior: "smooth"
	    });
	  });
	});
  </script>
  <script>
	document.addEventListener("DOMContentLoaded", function() {
	  // Get the "Shop" link element
	  var shopLink = document.querySelector('a[href="#shop"]');
	
	  // Add a click event listener to the "Shop" link
	  shopLink.addEventListener("click", function(event) {
	    event.preventDefault(); // Prevent the default link behavior
	
	    // Get the target element (the product page)
	    var targetElement = document.getElementById("shop");
	    // Scroll smoothly to the target element
	    targetElement.scrollIntoView({
	      behavior: "smooth"
	    });
	  });
	});
  </script>
  <script>
	document.addEventListener("DOMContentLoaded", function() {
	  // Get the "Shop" link element
	  var whyLink = document.querySelector('a[href="#why"]');
	
	  // Add a click event listener to the "Shop" link
	  whyLink.addEventListener("click", function(event) {
	    event.preventDefault(); // Prevent the default link behavior
	
	    // Get the target element (the product page)
	    var targetElement = document.getElementById("why");
	    // Scroll smoothly to the target element
	    targetElement.scrollIntoView({
	      behavior: "smooth"
	    });
	  });
	});
  </script>
  
 
  <!-- end info section -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
  <script src="js/jquery-3.4.1.min.js"></script>
  <script src="js/bootstrap.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js">
  </script>
  <script src="js/custom.js"></script>

</body>

</html>
  