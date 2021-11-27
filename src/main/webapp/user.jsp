<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.bean.User"%>
<!DOCTYPE html>
<html>
<head>
<link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
<meta charset="UTF-8">
<style><%@include file="/style/sidebar.css"%></style>
<style><%@include file="/style/user.css"%></style>
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
       <a href="fileManage.jsp">
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
          <a id="log_out" href="login.jsp" ><i class='bx bx-log-out'></i></a>
     </li>
    </ul>
  </div>
     <div class="wrapper">
<header>Profile</header>
<form action="#">
<div class="dbl-field">
<div class="field">
<input type="text" name="name" value="HaiQuy" disabled="disabled">
<i class='fas fa-user'></i>
</div>
<div class="field">
<input type="text" name="realname" value="LHQ" disabled="disabled">
<i class="fas fa-file-signature"></i>
</div>
<div class="field">
<input id="password" type="password" name="password" placeholder="Enter your password">
<i class='fas fa-lock'></i>
<button class="btn-view" type="button" onclick="togglePassword()"><i class="fas fa-eye password"></i></button>
</div>
<div class="field">
<input id="newPassword" type="password" name="newPassword" placeholder="Enter new password">
<i class='fas fa-lock'></i>
<button class="btn-view" type="button" onclick="toggleNewPassword()"><i class="fas fa-eye password"></i></button>
</div>
<div class="field">
<input id="confirmNewPassword" type="password" name="confirmNewPassword" placeholder="Enter confirm password">
<i class='fas fa-lock'></i>
<button class="btn-view" type="button" onclick="toggleConfirmNewPassword()"><i class="fas fa-eye password"></i></button>
</div>
</div>
<div class="button-area">
<button type="submit">Update</button>
<span></span>
</div>
</form>
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
  
  
  var state = false;
  function toggleNewPassword() {
      if(state){
          document.querySelector('#newPassword').setAttribute("type", "password");
          state = false;
      }
      else{
          document.querySelector('#newPassword').setAttribute("type", "text");
          state = true;
      }
  }
  
  function togglePassword() {
      if(state){
          document.querySelector('#password').setAttribute("type", "password");
          state = false;
      }
      else{
          document.querySelector('#password').setAttribute("type", "text");
          state = true;
      }
  }
  function toggleConfirmNewPassword() {
      if(state){
          document.querySelector('#confirmNewPassword').setAttribute("type", "password");
          state = false;
      }
      else{
          document.querySelector('#confirmNewPassword').setAttribute("type", "text");
          state = true;
      }
  }
  </script>
</body>
</html>