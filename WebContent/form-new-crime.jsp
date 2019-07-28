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
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	
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
							   <span class="user-level">${name }</span><br>
								  <!-- the Name of user form database  -->
							  <span class="user-level">Officer <!-- Job of the user from database using session--></span></span>
                    </h2>
                </div>
            </div>
            
            <ul class="nav nav-primary">
                        <li class="nav-item">
                            <a href="page">
                                <i class="fas fa-pen-square"></i>
                                <p>Register Suspect</p>
                                <!-- <span class="caret"></span>-->
                            </a>
                        </li>
                    </ul>
                    
            <ul class="nav nav-primary">
                <li class="nav-item">
                    <a href="registerd_suspect">
                        <i class="fas fa-pen-square"></i>
                        <p>View suspect</p>
                        <!-- <span class="caret"></span>-->
                    </a>
                </li>
                <div>
                    <ul class="nav nav-primary">
                        <li class="nav-item">
                            <a href="listallcrfiles">
                                <i class="fas fa-pen-square"></i>
                                <p>View CR files</p>
                                <!-- <span class="caret"></span>-->
                            </a>
                        </li>

                    </ul>
                    
                    <ul class="nav nav-primary">
                        <li class="nav-item">
                            <a href="#">
                                <i class="fas fa-pen-square"></i>
                                <p>Register crime</p>
                                <!-- <span class="caret"></span>-->
                            </a>
                         </li>
                    </ul>
                    <ul class="nav nav-primary">
                        <li class="nav-item">
                            <a href="registerd">
                                <i class="fas fa-pen-square"></i>
                                <p>View crime</p>
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
									<div class="card-title">Register new crime</div>
								</div>
								<form action="savecrimelog" method="post" onsubmit="SweetAlert2Demo ">
								<div class="card-body">
								  <div class="row">
										<div class="col-md-6 col-lg-4 col-xl-5">
											<div class="form-group">
												<label for="defendat">Crime number</label>
												<input type="number" class="form-control" id="Defendant" name="crimeid">
											</div>
											<div class="form-group">
												<label for="defendat">Defendant name </label>
												<input type="text" class="form-control" id="Defendant"name="defendantname">
											</div>
											<div class="form-group">
												<label for="email2">Crime type</label>
												<input type="text" class="form-control" id="Plaintiff" name="crimetype">
	 										</div>
											<div class="form-group form-show-notify row">
											<div class="col-lg-3 col-md-3 col-sm-4 col-xl-3 offset-xl-0">
											  <label>Assign case to:</label>
											</div>
											<div class="col-lg-4 col-md-9 col-sm-8 offset-xl-0 col-xl-9">
											  <select class="form-control input-fixed" id="assignedofficer" name="assignedofficer" >
											  	 <c:forEach var="item" items="${offlist}">
											    <option value="${item}">${item}</option>
											    </c:forEach>
											  </select>
											</div>
										</div>
											<div class="form-group">
												<label for="comment">Crime description </label>
											  <textarea class="form-control" name="crimedescription" rows="5"></textarea>
											</div>
										</div>
								    <div class="col-md-6 col-lg-4 col-xl-5 offset-xl-1">				
											<div class="form-group">
												<label for="Plaintiff">Plaintiff name</label>
											  <input type="text" class="form-control" id="Plaintiff" name="plaintiffname">
												
											</div>
										<!--<div class="form-group">
												<label for="Plaintiff">Crime occurred place</label>
										  <input type="text" class="form-control" id="Plaintiff" placeholder="">
												<small id="emailHelp2" class="form-text text-muted"></small>
									  </div>-->
											<div class="form-group row">
												<div class="form-group row">
												<div class="col-10 offset-xl-0 col-xl-11">
												  <label for="time_date">Crime registered date and time</label>
												  <input class="form-control" type="datetime-local" value="2011-08-19T13:45:00" id="example-datetime-local-input" name="crimeregistereddate">
												  </div>
											  </div>
											</div>
									  <div class="form-group row">
												<div class="form-group row">
												<div class="col-10 offset-xl-0 col-xl-11">
												  <label for="time_date">Crime occured date and time</label>
												  <input class="form-control" type="datetime-local" value="2011-08-19T13:45:00" id="example-datetime-local-input" name="crimeoccuredDate">
												  </div>
											  </div>
										  </div>
									</div>
								</div>
								</div>
								
								<div class="card-action">
									<button type="submit" class="btn btn-success" id = "alert_demo_8" 
									>Submit</button>
								</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		
			
		</div>
		
	  Custom template | don't include it in your project! --><!-- End Custom template -->
	</div>
	

	
	<!--   Core JS Files   -->
	<script src="../resources/js/core/jquery.3.2.1.min.js"></script>
	<script src="../resources/js/core/popper.min.js"></script>
	<script src="../resources/js/core/bootstrap.min.js"></script>
	<!-- jQuery UI -->
	<script src="../resources/js/plugin/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
	<script src="../resources/js/plugin/jquery-ui-touch-punch/jquery.ui.touch-punch.min.js"></script>
	
	<!-- Sweet Alert -->
	<script src="../resources/js/plugin/sweetalert/sweetalert.min.js"></script>
	
	<!-- jQuery Scrollbar -->
	<script src="../resources/js/plugin/jquery-scrollbar/jquery.scrollbar.min.js"></script>
	<!-- Atlantis JS -->
	<script src="../resources/js/atlantis.min.js"></script>
	<!-- Atlantis DEMO methods, don't include it in your project! -->
	<script src="../resources/js/setting-demo2.js"></script>
	
	
		<script type="text/javascript">
	
	$('#alert_demo_8').click(function(){
		
		var name = $("#Defendant").val();
		
		if(name == ""){
			swal("Red Stapler", "ya")
		});
		}
		
		
	
	</script>
	
	
	
	<script>
		//== Class definition
		
		
		
		
		var SweetAlert2Demo = function() {

			//== Demos
			var initDemos = function() {
				//== Sweetalert Demo 1
				$('#alert_demo_1').click(function(e) {
					swal('Good job!', {
						buttons: {        			
							confirm: {
								className : 'btn btn-success'
							}
						},
					});
				});

				//== Sweetalert Demo 2
				$('#alert_demo_2').click(function(e) {
					swal("Here's the title!", "...and here's the text!", {
						buttons: {        			
							confirm: {
								className : 'btn btn-success'
							}
						},
					});
				});

				//== Sweetalert Demo 3
				$('#alert_demo_3_1').click(function(e) {
					swal("Good job!", "You clicked the button!", {
						icon : "warning",
						buttons: {        			
							confirm: {
								className : 'btn btn-warning'
							}
						},
					});
				});

				$('#alert_demo_3_2').click(function(e) {
					swal("Good job!", "You clicked the button!", {
						icon : "error",
						buttons: {        			
							confirm: {
								className : 'btn btn-danger'
							}
						},
					});
				});

				$('#alert_demo_3_3').click(function(e) {
					swal("Good job!", "You clicked the button!", {
						icon : "success",
						buttons: {        			
							confirm: {
								className : 'btn btn-success'
							}
						},
					});
				});

				$('#alert_demo_3_4').click(function(e) {
					swal("Good job!", "You clicked the button!", {
						icon : "info",
						buttons: {        			
							confirm: {
								className : 'btn btn-info'
							}
						},
					});
				});

				//== Sweetalert Demo 4
				$('#alert_demo_4').click(function(e) {
					swal({
						title: "Good job!",
						text: "You clicked the button!",
						icon: "success",
						buttons: {
							confirm: {
								text: "Confirm Me",
								value: true,
								visible: true,
								className: "btn btn-success",
								closeModal: true
							}
						}
					});
				});

				$('#alert_demo_5').click(function(e){
					swal({
						title: 'Input Something',
						html: '<br><input class="form-control" placeholder="Input Something" id="input-field">',
						content: {
							element: "input",
							attributes: {
								placeholder: "Input Something",
								type: "text",
								id: "input-field",
								className: "form-control"
							},
						},
						buttons: {
							cancel: {
								visible: true,
								className: 'btn btn-danger'
							},        			
							confirm: {
								className : 'btn btn-success'
							}
						},
					}).then(
					function() {
						swal("", "You entered : " + $('#input-field').val(), "success");
					}
					);
				});

				$('#alert_demo_6').click(function(e) {
					swal("This modal will disappear soon!", {
						buttons: false,
						timer: 3000,
					});
				});

				$('#alert_demo_7').click(function(e) {
					swal({
						title: 'Are you sure?',
						text: "You won't be able to revert this!",
						type: 'warning',
						buttons:{
							confirm: {
								text : 'Yes, delete it!',
								className : 'btn btn-success'
							},
							cancel: {
								visible: true,
								className: 'btn btn-danger'
							}
						}
					}).then((Delete) => {
						if (Delete) {
							swal({
								title: 'Deleted!',
								text: 'Your file has been deleted.',
								type: 'success',
								buttons : {
									confirm: {
										className : 'btn btn-success'
									}
								}
							});
						} else {
							swal.close();
						}
					});
				});

				$('#alert_demo_8').click(function(e) {
					swal({
						title: 'Are you sure?',
						text: "You won't be able to revert this!",
						type: 'warning',
						buttons:{
							cancel: {
								visible: true,
								text : 'No, cancel!',
								className: 'btn btn-danger'
							},        			
							confirm: {
								text : 'Yes, delete it!',
								className : 'btn btn-success'
							}
						}
					}).then((willDelete) => {
						if (willDelete) {
							swal("Poof! Your imaginary file has been deleted!", {
								icon: "success",
								buttons : {
									confirm : {
										className: 'btn btn-success'
									}
								}
							});
						} else {
							swal("Your imaginary file is safe!", {
								buttons : {
									confirm : {
										className: 'btn btn-success'
									}
								}
							});
						}
					});
				})

			};

			return {
				//== Init
				init: function() {
					initDemos();
				},
			};
		}();

		//== Class Initialization
		jQuery(document).ready(function() {
			SweetAlert2Demo.init();
		});
		
		
		
		function validateaForm(){
			if(document.form.)
		}
		
		
		
	</script>
</body>

<!-- Mirrored from themekita.com/demo-atlantis-lite-bootstrap/livepreview/examples/demo2/forms/forms.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 28 Jun 2019 13:06:38 GMT -->
</html>