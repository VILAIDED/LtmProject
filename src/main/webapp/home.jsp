<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.bean.User"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.io.File" %>
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
        <a href="<%=request.getContextPath()%>/home">
          <i class='bx bx-grid-alt'></i>
          <span class="links_name">Home</span>
        </a>
         <span class="tooltip">Home</span>
      </li>
      <li>
       <a href="<%=request.getContextPath()%>/reset_password">
         <i class='bx bx-user' ></i>
         <span class="links_name">User</span>
       </a>
       <span class="tooltip">User</span>
     </li>
     <li>
       <a href="<%=request.getContextPath()%>/filemanage">
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
         <a id="log_out" href="/login" ><i class='bx bx-log-out'></i></a>
     </li>
    </ul>
  </div>
     <div class="wrapper">
   <div class="left_download">
    <header>Convert file MP4 to MP3</header>
    <form action="uploadfile" method="post" enctype="multipart/form-data">
      <input class="file-input" type="file" name="file" hidden multiple>
      <i class="fas fa-cloud-upload-alt"></i>
      <p style="align-items:center">Browse File to Upload</p>
       <input class="test" type="submit" name="file" value="submit" hidden/>
    </form>
    <h4 class="warning">Please reload page when in processing converter</h4>
   </div>
   <div class="right_download">
    <section class="uploaded-area">
    <%
    ArrayList<String> fileStatus  = (ArrayList<String>)request.getAttribute("fileT");
    if(fileStatus != null){
    	for(int i = 0 ; i < fileStatus.size() ; i++){
    		File f = new File(fileStatus.get(i));
    	 %>
    <ul>
    <li class="row">
    <i class="fas fa-file-alt"></i>
    <div class="content">
      
      <%
      if(f.exists()){
    	 Double size = (double)f.length() / 1024 / 1024; 
      %>
       <div class="details">
       <span class="name"><%= f.getName() %></span>
    	 <span class="size"><%= String.format("%.2f", size) %> MB</span> 
           </div>
           <div class="button-download">
        <a class="download" href="<%=request.getContextPath()%>/download?pathfile=<%=f.getName()%>"><i class="fas fa-download"></i></a>
        </div>
        <% 
      }
      else{
      %>
          <div class="details">
    	  <span class="name"><%= fileStatus.get(i) %></span>
    	  </div>
    	  <div class="loader" ></div>
  
      <%	  
      }
      %>
    </div>
  </li>
  </ul>
  <%
    }
    }
  %>
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