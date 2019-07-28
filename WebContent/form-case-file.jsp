<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from themekita.com/demo-atlantis-lite-bootstrap/livepreview/examples/demo2/forms/forms.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 28 Jun 2019 13:06:33 GMT -->
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<title>CRTS</title>
	<meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no' name='viewport' />
	<link rel="icon" href="http://themekita.com/demo-atlantis-lite-bootstrap/livepreview/examples/assets/img/icon.ico" type="image/x-icon"/>
	
	<!-- Fonts and icons -->
	<script src="../resources/js/plugin/webfont/webfont.min.js"></script>
	<script>
		WebFont.load({
			google: {"families":["Lato:300,400,700,900"]},
			custom: {"families":["Flaticon", "Font Awesome 5 Solid", "Font Awesome 5 Regular", "Font Awesome 5 Brands", "simple-line-icons"], urls: ['../resources/css/fonts.min.css']},
			active: function() {
				sessionStorage.fonts = true;
			}
		});
	</script>

	<!-- CSS Files -->
	<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
	<link rel="stylesheet" href="../resources/css/atlantis.min.css">
	<!-- CSS Just for demo purpose, don't include it in your project -->
	<link rel="stylesheet" href="../resources/css/demo.css">
</head>
<body data-background-color="light">
	<div class="wrapper">
		<div class="main-header">
			<!-- Logo Header -->
			<div class="logo-header" data-background-color="dark2">
				
				<a href="" class="logo">
				<img src="../resources/crts.PNG" alt="navbar brand" width="120" class="navbar-brand rounded">
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
							   <span class="user-level">${name}</span><br>
								  <!-- the Name of user form database  -->
							  <span class="user-level">Investigator<!-- Job of the user from database using session--></span></span>
                    </h2>
                </div>
            </div>          
            
            <ul class="nav nav-primary">
                
                <div>  
                    <ul class="nav nav-primary">
                        <li class="nav-item">
                            <a href="../investigator/page">
                                <i class="fas fa-pen-square"></i>
                                <p>Registered crime</p>
                                <!-- <span class="caret"></span>-->
                            </a>
                         </li>
                    </ul>
                    <ul class="nav nav-primary">
                        <li class="nav-item">
                            <a href="#">
                                <i class="fas fa-pen-square"></i>
                                <p>Create case file</p>
                                <!-- <span class="caret"></span>-->
                            </a>
                         </li>
                    </ul>
                </div>
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
									<div class="card-title">Case file </div>
								</div>
								<form action="savecasefile" method="post">
								<div class="card-body">
								  <div class="row">
								  
										<div class="col-md-6 col-lg-4 col-xl-5">
												    <div class="form-group col-md-2 ">
														<label for="email2">Investigator ID</label>
														<input type="text" class="form-control" id="Plaintiff" name="investigator_id" value="${id}">
													</div>
													
													<div class="form-group col-md-2 ">
														<label for="email2">Crime Log ID</label>
														<input type="text" name="log_file_id" class="form-control" value="<c:forEach var="item" items="${log}">${item.idcrime_log}</c:forEach>"/>
													</div>
													
											<div class="form-group">
												<label for="email2">Crime type</label>
												<input type="text" class="form-control" type="text" name="typeof_crime" value="<c:forEach var="item" items="${log}">${item.crime_type}</c:forEach>"/>
												<small id="emailHelp2" class="form-text text-muted"></small>
											</div>
											<div class="form-group col-md-9">
													<label for="email2">Suspect Name</label>
													<input type="text" class="form-control" name="suspect_name" value="<c:forEach var="item" items="${log}">${item.defendant_name}</c:forEach>"/>
												</div>
											<div class="form-group form-show-notify row">
											<div class="col-lg-3 col-md-3 col-sm-4 col-xl-3 offset-xl-0">
											  <label>Prosecutor:</label>
											</div>
											<div class="col-lg-4 col-md-9 col-sm-8 col-xl-8 offset-xl-1">
											  <td><select class="form-control input-fixed" id="prosecutor" name="prosecutor">
													<c:forEach var="item" items="${prosecutor}">
															<option value=${item}>${item}</option>
														</c:forEach></select>
											  </select></td>
											</div>
										</div>
										<div class="form-group form-show-notify row">
												<div class="col-lg-3 col-md-3 col-sm-4 col-xl-3 offset-xl-0">
												  <label>Lawyer:</label>
												</div>
												<div class="col-lg-4 col-md-9 col-sm-8 col-xl-8 offset-xl-1">
												  <td><select class="form-control input-fixed" id="lawyer" name="lawyer">
														<c:forEach var="item" items="${lawyer}">
																<option value=${item}>${item}</option>
															</c:forEach></select>
												  </select></td>
												</div>
											</div>
											<div class="form-group">
											  <label for="comment">Crime description (short summary)</label>
											  <textarea class="form-control" id="crime_description" name = "short_sumary" rows="5"></textarea>
											</div>										
										</div>
								    <div class="col-md-6 col-lg-4 col-xl-5 offset-xl-1">
						<div class="form-group row">
						<div class="form-group row">
												<div class="col-10 offset-xl-0 col-xl-11">
												  <label for="time_date">Crime registered date and time</label>
												  <input class="form-control" readonly="readonly" name = "crime_tip_date" type="text" value="<c:forEach var="item" items="${log}">${item.crime_registered_date}</c:forEach>"/>
												  </div>
											  </div>
						<div class="form-group row">
						  <div class="col-10 offset-xl-0 col-xl-11">
						    <label for="time_date2">Crime Occurred date and time</label>
						    <input class="form-control" name = "dateof_crime" readonly="readonly" type="text" value="<c:forEach var="item" items="${log}">${item.crime_occurred_date}</c:forEach>"/> </div>
					  </div>
											</div>
									  <div class="form-group row">
												<div class="form-group row">
												<div class="col-10 offset-xl-0 col-xl-11">
												  <label for="time_date3">Investigation end date </label>
												  <input class="form-control" name = "investigation_end_date"  type="datetime-local" value="2011-08-19T13:45:00" id="example-datetime-local-input">
												  </div>
											  </div>
										  </div>
										
										  <div class="form-group">
												<label for="email2">Prosecutor Approved</label>
												<input type="text" class="form-control" name="prosecutor_approved" value="not approved" readonly="readonly" >
											</div>
											<div class="form-group">
													<label for="email2">Registrar Approved</label>
													<input type="text" class="form-control" name="registrar_approved" value="not approved" readonly="readonly">
												</div>
										</div>
										
									</div>
								</div>
								<div class="card-action">
									<button class="btn btn-success" onclick="if(!(confirm('Are you sure you want to creat this case file?'))) return false">Create</button>
								</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<footer class="footer"> </footer>
		</div>
		
		<!-- Custom template | don't include it in your project! --><!-- End Custom template -->
	</div>
	<!--   Core JS Files   -->
	<script src="../resources/js/core/jquery.3.2.1.min.js"></script>
	<script src="../resources/js/core/popper.min.js"></script>
	<script src="../resources/js/core/bootstrap.min.js"></script>
	<!-- jQuery UI -->
	<script src="../resources/js/plugin/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
	<script src="../resources/js/plugin/jquery-ui-touch-punch/jquery.ui.touch-punch.min.js"></script>
	
	<!-- jQuery Scrollbar -->
	<script src="../resources/js/plugin/jquery-scrollbar/jquery.scrollbar.min.js"></script>
	<!-- Atlantis JS -->
	<script src="../resources/js/atlantis.min.js"></script>
	<!-- Atlantis DEMO methods, don't include it in your project! -->
	<script src="../resources/js/setting-demo2.js"></script>
</body>

<!-- Mirrored from themekita.com/demo-atlantis-lite-bootstrap/livepreview/examples/demo2/forms/forms.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 28 Jun 2019 13:06:38 GMT -->
</html>