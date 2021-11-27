<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.bean.User"%>
<!DOCTYPE html>
<html>
<head>
<link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
<meta charset="UTF-8">
<style><%@include file="/style/sidebar.css"%></style>
<style><%@include file="/style/fileManage.css"%></style>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>File Manage</title>
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
  <section class="home-section">
      
   <table class="table">
     <thead>
     	<tr>
     	 <th>ID</th>
     	 <th>Name</th>
     	 <th>Size</th>
     	 <th>Date</th>
     	 <th>Download</th>
     	</tr>
     </thead>
     <tbody>
     	  <tr>
     	  	  <td data-label="ID">1</td>
     	  	  <td data-label="Name">Dinesh</td>
     	  	  <td data-label="Size">34 KB</td>
     	  	  <td data-label="Date">2021-09-08</td>
     	  	  <td data-label="Download"><a href="#">Download</a></td>
     	  </tr>

     	  <tr>
     	  	  <td data-label="ID">2</td>
     	  	  <td data-label="Name">VilayDed</td>
     	  	  <td data-label="Size">44 KB</td>
     	  	  <td data-label="Date">2021-09-08</td>
     	  	  <td data-label="Download"><a href="#">Download</a></td>
     	  </tr>

     	  <tr>
     	  	  <td data-label="ID">3</td>
     	  	  <td data-label="Name">Dinesh</td>
     	  	  <td data-label="Size">34 KB</td>
     	  	  <td data-label="Date">2021-09-08</td>
     	  	  <td data-label="Download"><a href="#">Download</a></td>
     	  </tr>

     	  <tr>
     	  	  <td data-label="ID">4</td>
     	  	  <td data-label="Name">Dinesh</td>
     	  	  <td data-label="Size">34 KB</td>
     	  	  <td data-label="Date">2021-09-08</td>
     	  	  <td data-label="Download"><a href="#">Download</a></td>
     	  </tr>
     </tbody>
   </table>
  </section>
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
</body>
</html>