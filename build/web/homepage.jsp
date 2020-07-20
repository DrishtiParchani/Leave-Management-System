<%@include file="header.jsp" %>
<%@include file="flash.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style.css">
<style>
               
                  body {
    background-color: black;
  
}
            

        </style>
</head>
<body >

<div class="mySlides fade">
  
  <img src="img/swami-vivekananda-education-society-polytechnic-ves-polytechnic-mumbai.jpg" style="width:1350px;height:550px;">
  

  
</div>

<div class="mySlides fade">
  
  <img src="img/home2.jpg" style="width:1350px;height:550px;">
  
  
  
</div>

<div class="mySlides fade">
  
  <img src="img/home4.png" style="width:1350px;height:550px;">
 
  
</div>


<br>

<div style="text-align:center">
  <span class="dot"></span> 
  <span class="dot"></span> 
  <span class="dot"></span> 
</div>

</body>

<script>
var slideIndex = 0;
showSlides();

function showSlides() {
    var i;
    var slides = document.getElementsByClassName("mySlides");
    var dots = document.getElementsByClassName("dot");
    for (i = 0; i < slides.length; i++) {
       slides[i].style.display = "none";  
    }
    slideIndex++;
    if (slideIndex > slides.length) {slideIndex = 1}    
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    slides[slideIndex-1].style.display = "block";  
    dots[slideIndex-1].className += " active";
    setTimeout(showSlides, 6000); // Change image every 6 seconds
}
</script>
</html>
<%@include file="footer.jsp" %>
