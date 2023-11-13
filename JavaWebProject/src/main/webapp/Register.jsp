<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="fonts/icomoon/style.css">

    <link rel="stylesheet" href="css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="css/style.css">

    <title>Register</title>
  </head>
  <body>
  

  <div class="d-lg-flex half">
    <div class="bg order-1 order-md-2" style="background-image: url('images/bg_1.jpg');"></div>
    <div class="contents order-2 order-md-1">

      <div class="container">
        <div class="row align-items-center justify-content-center">
          <div class="col-md-7">
            <h3 style="margin-bottom: 30px">Register form</h3>
            <form action="register" method="post">
              <div class="form-group first">
                <label style="font-size: 20px; font-weight: bold" for="username">Username</label>
                <input type="text" class="form-control" placeholder="Your-username" autocomplete="off" required="required" name="user" id="username">
              </div>
              <div class="form-group last mb-3">
                <label style="font-size: 20px; font-weight: bold" for="password">Password</label>
                <input name="pass" type="password" class="form-control" placeholder="Your Password" autocomplete="off" required="required" id="password">
              </div>
              <div class="form-group last mb-3">
                <label style="font-size: 20px; font-weight: bold" for="password">Re-password</label>
                <input name="repass" type="password" class="form-control" placeholder="Retype Your Password" autocomplete="off" required="required" id="password">
              </div>
              	
				<p style="margin-top: 10%" class="text-danger">${mess}</p>
              <input type="submit" value="Register" class="btn btn-block btn-primary">

            </form>
          </div>
        </div>
      </div>
    </div>

    
  </div>
    
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
  </body>
</html>