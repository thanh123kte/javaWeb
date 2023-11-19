<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<div class="hero_area">
    <!-- header section strats -->
    <header class="header_section">
      <nav class="navbar navbar-expand-lg custom_nav-container ">
        <a style="font-size: 28px;font-weight: bold;color: #000000;margin: 0;padding: 0;" href="http://localhost:8181/JavaWebProject/home">
          <span>
            DAliennHandmade
          </span>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class=""></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav  ">
            <li class="nav-item active">
              <a class="nav-link" href="http://localhost:8181/JavaWebProject/home">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#shop">
                Shop
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#why">
                Why Us
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#map">Contact Us</a>
            </li>
          </ul>
          <div class="user_option">
          
           
        	<a href="#" onclick="redirectToCart()">	
              <i class="fa fa-shopping-bag" aria-hidden="true"></i>
            </a>
            
            <script>
			    function redirectToCart() {
			        // Kiểm tra xem sessionScope.acc có tồn tại không
			        var isUserLoggedIn = ${not empty sessionScope.acc};
			
			        // Nếu không tồn tại, hiển thị thông báo và không chuyển hướng
			        if (!isUserLoggedIn) {
			            alert("Vui lòng đăng nhập.");
			        } else {
			            // Nếu tồn tại, chuyển hướng đến trang cart
			            window.location.href = "cart?uid=${sessionScope.acc.id}";
			        }
			    }
			</script>
            
            <button id="infoButton" class="btn nav_search-btn" onmouseover="showInfoBox()" onmouseout="hideInfoBox()">
			  <i class="fa fa-search" aria-hidden="true"></i>
			</button>
			
			<!-- Tương tự, sự kiện onmouseover và onmouseout cho box -->
			<div id="infoBox" class="info-box" onmouseover="showInfoBox()" onmouseout="hideInfoBox()">
			  <!-- Nội dung form của bạn ở đây -->
			  <form>
			    <label for="infoInput"></label>
			    <input style="border-radius: 12px; border: none;padding: 8px;" type="text" id="infoInput" placeholder="Searching here" name="infoInput">
			    <button style="border-radius: 12px; border: none;padding: 8px 16px;background-color: #f89cab;color: #fff;" type="button" onclick="submitInfo()">Submit</button>
			  </form>
			</div>
			
			<div style="margin-left: 30px">
				<c:if test="${sessionScope.acc != null}">
	          		<a href="profile?uid=${sessionScope.acc.id}">
		              <i class="fa fa-user" aria-hidden="true"></i>
		              <span>
		              	hi <b> ${sessionScope.acc.account} </b>
		              </span>
		           </a>
          		</c:if>
			</div>
			
			  <c:if test="${sessionScope.acc == null}">
	          <a href="Login.jsp">
	              <span>
	                LogIn
	              </span>
	           </a>
          </c:if>           
            
           <c:if test="${sessionScope.acc != null}">
	          <a href="logout">
	              <span>
	                LogOut
	              </span>
	           </a>
          </c:if>
			
          </div>
        </div>
      </nav>
    </header>