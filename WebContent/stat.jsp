<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
				
				<a href="" class="logo">
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
						<div class="col-md-6">
							<div class="card">
								<div class="card-header">
									<div class="card-title">Pie Chart</div>
								</div>
								<div class="card-body">
									<div class="chart-container">
										<canvas id="pieChart" style="width: 50%; height: 50%"></canvas>
									</div>
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
	
	<script>
		var pieChart = document.getElementById('pieChart').getContext('2d')
		
		var myPieChart = new Chart(pieChart, {
			type: 'pie',
			data: {
				datasets: [{
					data: [50, 35, 15],
					backgroundColor :["#1d7af3","#f3545d","#fdaf4b"],
					borderWidth: 0
				}],
				labels: ['New Visitors', 'Subscribers', 'Active Users'] 
			},
			options : {
				responsive: true, 
				maintainAspectRatio: false,
				legend: {
					position : 'bottom',
					labels : {
						fontColor: 'rgb(154, 154, 154)',
						fontSize: 11,
						usePointStyle : true,
						padding: 20
					}
				},
				pieceLabel: {
					render: 'percentage',
					fontColor: 'white',
					fontSize: 14,
				},
				tooltips: false,
				layout: {
					padding: {
						left: 20,
						right: 20,
						top: 20,
						bottom: 20
					}
				}
			}
		});

		

	</script>
	
	
</body>

<!-- Mirrored from themekita.com/demo-atlantis-lite-bootstrap/livepreview/examples/demo2/forms/forms.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 28 Jun 2019 13:06:38 GMT -->
</html>