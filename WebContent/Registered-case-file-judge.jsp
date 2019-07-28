<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from themekita.com/demo-atlantis-lite-bootstrap/livepreview/examples/demo2/tables/datatables.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 28 Jun 2019 13:06:39 GMT -->
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
			<div class="logo-header" data-background-color="dark">
				
				<a href="#" class="logo">
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
					<div class="collapse" id="search-nav">
						<form class="navbar-left navbar-form nav-search mr-md-3">
							
						</form>
					</div>
				</div>
				<a class="btn btn-danger" style="float: right;" href="<c:url value="/logout"/>">Log out</a>
			</nav>
			<!-- End Navbar -->
		</div>
		<!-- Sidebar -->
		
		
		
<div class="sidebar sidebar-style-2" data-background-color="dark2">
    <div class="sidebar-wrapper scrollbar scrollbar-inner">
        <div class="sidebar-content">
            <div class="user">
                <div class="info">
                    <h2 data-toggle="collapse" href="#collapseExample" aria-expanded="true">
							  <span>
							   <span class="user-level">${name}</span><br>
								  <!-- the Name of user form database  -->
							  <span class="user-level">Judge <!-- Job of the user from database using session--></span></span>
                    </h2>
                </div>
            </div>
            
            <ul class="nav nav-primary">
                        <li class="nav-item">
                            <a href="listallcrfile">
                                <i class="fas fa-pen-square"></i>
                                <p>View CR file </p>
                                <!-- <span class="caret"></span>-->
                            </a>
                        </li>
                    </ul>
            
            
            <ul class="nav nav-primary">
                <li class="nav-item">
                    <a href="listcasefile">
                        <i class="fas fa-pen-square"></i>
                        <p>Create CR</p>
                        <!-- <span class="caret"></span>-->
                    </a>
                    <!-- <div class="collapse" id="forms">
                         <ul class="nav nav-collapse">
                             <li>
                                 <a href="form-new-crime.html">
                                     <span class="sub-item">New crime</span>
                                 </a>
                             </li>

                             <ul class="nav nav-collapse">
                                 <li>
                                     <a href="List-criminal.html">
                                         <span class="sub-item">Registered crime</span>
                                     </a>
                                 </li>
                             </ul>
                         </ul>
                     </div>-->
                </li>
                <div>
                    
                    
                    
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
									<h4 class="card-title">Registered case files</h4>
								</div>
								<div class="card-body">
									<div class="table-responsive">
									<form action="judgelistcrfile" method="post">
										<table id="basic-datatables" class="display table table-striped table-hover" >
											<thead>
												<tr>
													 <th>Suspect Name</th>
										                <th>Crime Type</th>
										                <th>Crime Occurred Date</th>
										                <th>Crime registered Date</th>
										                <th>Date of imprisonment</th>
										                <th>Sentence</th>
										                <th>Create C.R. File</th>
									         	</tr>
											</thead>
											<tfoot>
												
											</tfoot>
											<tbody>
											 <c:forEach var="log" items="${casefile}">
								                <tr>
					                             <td><input type="text" class="form-control" name="defendant_name" value="${log.suspect_name}" readonly="readonly"/></td>
								                  <td><input type="text" class="form-control" name="crime_name"  value="${log.typeof_crime}" readonly="readonly"/></td>
								                 <td><input type="text" class="form-control" name="dateof_crime" value="${log.dateof_crime}" readonly="readonly"/></td>
								                 <td><input type="text" class="form-control" name="date_filed_on" value="${log.crime_tip_date}" readonly="readonly"/></td>
								                 <td><input type="text" class="form-control" name="dateof_imprisonment" /></td>
								                 <td> <textarea class="form-control" name="sentence"  rows="5" cols = "50"></textarea></td>
								                  <td>
								                  <button class="btn btn-success" onclick="if(!(confirm('Are you sure you want to creat this CR file?'))) return false">Create</button>
								                  </td>
								                    <td><input type="hidden" name="investigator_id" value="${log.investigator_id}"/></td>
                                                    <td><input type="hidden" name="casefile_id" value="${log.idcase_file}"/></td>
								                </tr>
								            </c:forEach>
											</tbody>
										</table>
										</form>
									</div>
									
								</div>
							</div>
						</div>
</div>
				</div>
			</div>
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
	<!-- Datatables -->
	<script src="../resources/js/plugin/datatables/datatables.min.js"></script>
	<!-- Atlantis JS -->
	<script src="../resources/js/atlantis.min.js"></script>
	<!-- Atlantis DEMO methods, don't include it in your project! -->
	<script src="../resources/js/setting-demo2.js"></script>
	<script >
		$(document).ready(function() {
			$('#basic-datatables').DataTable({
			});

			$('#multi-filter-select').DataTable( {
				"pageLength": 5,
				initComplete: function () {
					this.api().columns().every( function () {
						var column = this;
						var select = $('<select class="form-control"><option value=""></option></select>')
						.appendTo( $(column.footer()).empty() )
						.on( 'change', function () {
							var val = $.fn.dataTable.util.escapeRegex(
								$(this).val()
								);

							column
							.search( val ? '^'+val+'$' : '', true, false )
							.draw();
						} );

						column.data().unique().sort().each( function ( d, j ) {
							select.append( '<option value="'+d+'">'+d+'</option>' )
						} );
					} );
				}
			});

			// Add Row
			$('#add-row').DataTable({
				"pageLength": 5,
			});

			var action = '<td> <div class="form-button-action"> <button type="button" data-toggle="tooltip" title="" class="btn btn-link btn-primary btn-lg" data-original-title="Edit Task"> <i class="fa fa-edit"></i> </button> <button type="button" data-toggle="tooltip" title="" class="btn btn-link btn-danger" data-original-title="Remove"> <i class="fa fa-times"></i> </button> </div> </td>';

			$('#addRowButton').click(function() {
				$('#add-row').dataTable().fnAddData([
					$("#addName").val(),
					$("#addPosition").val(),
					$("#addOffice").val(),
					action
					]);
				$('#addRowModal').modal('hide');

			});
		});
	</script>
</body>

<!-- Mirrored from themekita.com/demo-atlantis-lite-bootstrap/livepreview/examples/demo2/tables/datatables.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 28 Jun 2019 13:06:39 GMT -->
</html>