<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.bean.User"%>
<!DOCTYPE html>
<html>
<head>
<link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
<meta charset="UTF-8">
<style><%@include file="/style/sidebar.css"%></style>
<style><%@include file="/style/uploadFile.css"%></style>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Home</title>
</head>
<body>
 <div class="sidebar">
    <div class="logo-details">
      <i class='bx bxl-c-plus-plus icon'></i>
        <div class="logo_name">Converter</div>
        <i class='bx bx-menu' id="btn" ></i>
    </div>
    <ul class="nav-list">
      <li>
        <a href="home.jsp">
          <i class='bx bx-grid-alt'></i>
          <span class="links_name">Home</span>
        </a>
         <span class="tooltip">Home</span>
      </li>
      <li>
       <a href="user.jsp">
         <i class='bx bx-user' ></i>
         <span class="links_name">User</span>
       </a>
       <span class="tooltip">User</span>
     </li>
     <li>
       <a href="#">
         <i class='bx bx-folder' ></i>
         <span class="links_name">File Manager</span>
       </a>
       <span class="tooltip">Files</span>
     </li>
     <li class="profile">
         <div class="profile-details">
           <div class="name_job">
             <div class="name">Le Hai Quy</div>
             <div class="name">VilayDed</div>
           </div>
         </div>
         <button id="log_out" ><i class='bx bx-log-out'></i></button>
     </li>
    </ul>
  </div>
     <div class="wrapper">
   <div class="left_download">
    <header>Convert file MP4 to MP3</header>
    <form action="#">
      <input class="file-input" type="file" name="file" hidden multiple>
      <i class="fas fa-cloud-upload-alt"></i>
      <p style="align-items:center">Browse File to Upload</p>
    </form>
    <button class="download-all">Download All</button>
   </div>
   <div class="right_download">
    <section class="uploaded-area">
    <ul>
    <li class="row">
    <i class="fas fa-file-alt"></i>
    <div class="content">
      <div class="details">
        <span class="name">ABC</span>
        <span class="size">120 KB</span>
      </div>
      <div class="button-download">
        <a class="download" href="#"><i class="fas fa-download"></i></a>
      </div>
    </div>
  </li>
  </ul>
  </section>
   </div>
  </div>
  <script>
  let sidebar = document.querySelector(".sidebar");
  let closeBtn = document.querySelector("#btn");
  let searchBtn = document.querySelector(".bx-search");

  closeBtn.addEventListener("click", ()=>{
    sidebar.classList.toggle("open");
    menuBtnChange();//calling the function(optional)
  });

  // following are the code to change sidebar button(optional)
  function menuBtnChange() {
   if(sidebar.classList.contains("open")){
     closeBtn.classList.replace("bx-menu", "bx-menu-alt-right");
   }else {
     closeBtn.classList.replace("bx-menu-alt-right","bx-menu");
   }
  }
  </script>
  <script><%@include file="/js/uploadFile.js"%></script>
</body>
</html>