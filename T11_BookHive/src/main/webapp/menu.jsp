<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>BookHive</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
	<div class="container-fluid">
		<div class="row flex-nowrap">
			<div
				class="bg-dark col-auto col-md-4 col-lg-2 min-vh-100 d-flex flex-column justify-content-between">
				<div class="bg-dark p-2">
					<a
						class="d-flex text-decoration-none mt-1 align-items-center text-white">
						<span class="fs-4 d-none d-sm-inline"></span>
					</a>
					<ul class="nav nav-pills flex-column mt-4">
						<li class="nav-item py-2 py-sm-0"><a href="Home.jsp"
							class="nav-link text-white"> <span
								class="fs-5 ms-0 d-none d-sm-inline">Inicio</span>
						</a></li>
						<li class="nav-item py-2 py-sm-0"><a href="Book.jsp"
							class="nav-link text-white"> <i class="fs-5 fa fa-book"></i>
								<span class="fs-4 ms-3 d-none d-sm-inline">Libros</span>
						</a></li>
						<li class="nav-item py-2 py-sm-0"><a href="Librarian.jsp"
							class="nav-link text-white"> <i class="fs-5 fa fa-users"></i>
								<span class="fs-4 ms-3 d-none d-sm-inline">Bibliotecario</span>
						</a></li>
						<li class="nav-item py-2 py-sm-0"><a href="Person.jsp"
							class="nav-link text-white"> <i class="fs-5 fa fa-users"></i>
								<span class="fs-4 ms-3 d-none d-sm-inline">Registros</span>
						</a></li>
						<li class="nav-item py-2 py-sm-0"><a href="Loan.jsp"
							class="nav-link text-white"> <i class="fs-5 fa fa-cube"></i>
								<span class="fs-4 ms-3 d-none d-sm-inline">Prestamo</span>
						</a></li>
						<li class="nav-item py-2 py-sm-0"><a href="Return.jsp"
							class="nav-link text-white"> <i class="fs-5 fa fa-circle"></i>
								<span class="fs-4 ms-3 d-none d-sm-inline">Devolución</span>
						</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<!-- Scripts de Bootstrap 5 y JavaScript -->
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"></script>
</body>
</html>
