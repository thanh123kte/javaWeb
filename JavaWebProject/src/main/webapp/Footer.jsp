<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<footer class=" footer_section">
      <div class="container">
        <p>
          &copy; <span id="displayYear"></span> All Rights Reserved By
          <a href="https://html.design/">Free Html Templates</a>
        </p>
      </div>
    </footer>
    <!-- footer section -->
    
<!-- JavaScript -->
<script>
  function showInfoBox() {
    var infoBox = document.getElementById("infoBox");
    infoBox.style.display = "block";
  }

  function hideInfoBox() {
    var infoBox = document.getElementById("infoBox");
    infoBox.style.display = "none";
  }

  // Close the info box when clicking outside of it
  window.onclick = function (event) {
    var infoBox = document.getElementById("infoBox");
    var infoButton = document.getElementById("infoButton");
    
    if (event.target !== infoButton && !infoButton.contains(event.target) && event.target !== infoBox && !infoBox.contains(event.target)) {
      infoBox.style.display = "none";
    }
  };

  // Add your logic to handle form submission (e.g., submitInfo function)
  function submitInfo() {
	  
	  var name = document.getElementById("infoInput").value;
	  
	  var addToCartURL = "search?name="+name;
      window.location.href = addToCartURL;
  }
</script>    