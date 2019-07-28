<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from themekita.com/demo-atlantis-lite-bootstrap/livepreview/examples/demo2/forms/forms.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 28 Jun 2019 13:06:33 GMT -->
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title>CRTS</title>
    <meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no' name='viewport' />
    <link rel="icon" href="http://themekita.com/demo-atlantis-lite-bootstrap/livepreview/examples/assets/img/icon.ico" type="image/x-icon"/>

    <!-- Fonts and icons -->
    <script src="resources/js/plugin/webfont/webfont.min.js"></script>
    <script>
        WebFont.load({
            google: {"families":["Lato:300,400,700,900"]},
            custom: {"families":["Flaticon", "Font Awesome 5 Solid", "Font Awesome 5 Regular", "Font Awesome 5 Brands", "simple-line-icons"], urls: ['resources/css/fonts.min.css']},
            active: function() {
                sessionStorage.fonts = true;
            }
        });
    </script>
 
    <!-- CSS Files -->
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/atlantis.min.css">
    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link rel="stylesheet" href="resources/css/demo.css">
</head>
<body data-background-color="light">
<div class="wrapper">
<div class="main-header">
<!-- Logo Header -->
<div class="logo-header" data-background-color="dark2">

    <a href="#" class="logo">
        <img src="resources/crts.PNG" alt="navbar brand" width="120" class="navbar-brand rounded">
    </a>
    <button class="navbar-toggler sidenav-toggler ml-auto" type="button" data-toggle="collapse" data-target="collapse" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon">
						<i class="icon-menu"></i>
					</span>
    </button>
    <button class="topbar-toggler more"><i class="icon-options-vertical"></i></button>
    <div class="nav-toggle">
        <button class="btn btn-toggle toggle-sidebar">
            <i class="icon-menu"></i>
        </button>
    </div>
</div>
<!-- End Logo Header -->

<!-- Navbar Header -->
<nav class="navbar navbar-header navbar-expand-lg" data-background-color="blue">
<div class="container-fluid">

</div>
<a class="btn btn-danger" style="float: right;" href="<c:url value="/logout"/>">Log out</a>
</nav>
<!-- End Navbar -->
</div>
<div class="sidebar sidebar-style-2" data-background-color="dark2">
    <div class="sidebar-wrapper scrollbar scrollbar-inner">
        <div class="sidebar-content">
          <div class="user">
                <div class="info">
                    <h2 data-toggle="collapse" href="#collapseExample" aria-expanded="true">
							  <span>
								  <!-- the Name of user form database  -->
							  <span class="user-level">User Management <!-- Job of the user from database using session--></span></span>
                    </h2>
                </div>
            </div>
            <ul class="nav nav-primary">
                <li class="nav-item">
                            <a href="newUsers">
                                <i class="fas fa-pen-square"></i>
                                <p>Create user</p>
                                <!-- <span class="caret"></span>-->
                            </a>
              </li>

          </ul>
            <ul class="nav nav-primary">
                <li class="nav-item">
                            <a href="manage_users">
                                <i class="fas fa-pen-square"></i>
                                <p>Edit user</p>
                                <!-- <span class="caret"></span>-->
                            </a>
              </li>
          </ul>
                    <ul class="nav nav-primary">
                        <li class="nav-item">
                            <a href="">
                                <i class="fas fa-pen-square"></i>
                                <p>Manage Statistics</p>
							</a>
                        </li>
                    </ul>
            </ul>

        </div>

    </div>

</div>
<div class="main-panel">
    <div class="content">
        <div class="page-inner">
<div class="row">
    <div class="col-md-12">
        <div class="card">
            <div class="card-header">
                <div class="card-title">Create a new user</div>
            </div>
           <form:form action="update" modelAttribute="users" method="post">
             
            <div class="card-body">
            
                <div class="row">
                    <div class="col-md-6 col-lg-4 col-xl-5">
                        <div class="form-group">
                               <label>First name</label>
                            <form:input type="text" class="form-control" id="FirstName" path = "first_name"  name ="firstName" placeholder="First Name"/><br>
                            <form:hidden path="idusers"/>
                            <form:hidden path="idaddres"/>
                            <label>Last Name</label>
                            <form:input type="text" class="form-control" id="LastName" path = "last_name" name = "lastName" placeholder="Last Name"/><br>
                            <label>User Name</label>
                            <form:input type="text" class="form-control" id="UserName" path = "user_name" name = "UserName" placeholder="UserName"/><br>
                            <label>Password</label>
                            <form:input type="text" class="form-control" id="PasswordNewUser" path="password" name = "password" placeholder="Password"/><br>
                            <small id="emailHelp2" class="form-text text-muted"></small>
                            <label>E-Mail</label>
         					<form:input type="email" class="form-control" id="EmailNewUser" path = "email" name = "email" placeholder="E-mail"/><br>
        					<!-- <label>Office</label>
        					<form:input type="text" class="form-control" id="OfficeID" name = "office" path = "email" placeholder="Office"/>
                            <small id="emailHelp2" class="form-text text-muted"></small> -->
                        </div>
</div>
 <div class="col-md-6 col-lg-4 col-xl-5 offset-xl-1">
     <div class="form-group">
         <label >Address</label><br>
         
         <div class="form-group">
			<label for="defendat">House number</label>
			<form:input type="number" class="form-control" id="Defendant" path="home_number" name="home_number"/>
		 </div>
         
         <div class="form-group">
			<label for="defendat">Phone Number</label>
			<form:input type="tel" class="form-control" id="Defendant" path="phon" name="phoneNumber"/>
		 </div>
		 
		 <div class="form-group">
			<label for="defendat">Region</label>
			<form:input type="text" class="form-control" id="Defendant" path="region" name="region"/>
		 </div>
		 
		 <div class="form-group">
			<label for="defendat">woreda</label>
			<form:input type="text" class="form-control" id="Defendant" path="woreda" name="woreda"/>
		 </div>
		 
		 <div class="form-group">
			<label for="defendat">keble</label>
			<form:input type="text" class="form-control" id="Defendant" path="kebele" name="keble"/>
		 </div>
         
     </div>
     

   
 </div>
</div>
</div>
<div class="card-action">
<button class="btn btn-success">Updates</button>
</div>
</form:form>
</div>

</div>
</div>
</div>
</div>
<footer class="footer"> </footer>
</div> -->
</div>
<!-- Custom template | don't include it in your project! --><!-- End Custom template -->

<!--   Core JS Files   -->
<script src="resources/js/core/jquery.3.2.1.min.js"></script>
<script src="resources/js/core/popper.min.js"></script>
<script src="resources/js/core/bootstrap.min.js"></script>
<!-- jQuery UI -->
<script src="resources/js/plugin/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
<script src="resources/js/plugin/jquery-ui-touch-punch/jquery.ui.touch-punch.min.js"></script>

<!-- jQuery Scrollbar -->
<script src="resources/js/plugin/jquery-scrollbar/jquery.scrollbar.min.js"></script>
<!-- Atlantis JS -->
<script src="resources/js/atlantis.min.js"></script>
<!-- Atlantis DEMO methods, don't include it in your project! -->
<script src="resources/js/setting-demo2.js"></script>
</body>

<!-- Mirrored from themekita.com/demo-atlantis-lite-bootstrap/livepreview/examples/demo2/forms/forms.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 28 Jun 2019 13:06:38 GMT -->
</html>