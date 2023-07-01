<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookHive</title>
<!-- Enlace a Bootstrap 5 -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css">
<!-- Enlace a Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<!-- Enlace a tu archivo de estilos CSS -->
<link rel="stylesheet" href="style.css">
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
							class="nav-link text-white"> <i class="fs-5 fa fa-list"></i>
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
    <div class="container">
        <h1>CRUD Frontend</h1>
        
        <!-- Formulario para crear un nuevo registro -->
        <form id="create-form" class="mb-3">
            <h2>Crear Registro</h2>
            <div class="mb-3">
                <label for="state-loan">Estado del Préstamo:</label>
                <input type="text" id="state-loan" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="start-loan">Fecha de Inicio:</label>
                <input type="date" id="start-loan" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="final-loan">Fecha de Fin:</label>
                <input type="date" id="final-loan" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="librarian-id">ID Bibliotecario:</label>
                <input type="number" id="librarian-id" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="person-id">ID Persona:</label>
                <input type="number" id="person-id" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-primary">Crear</button>
        </form>
        
        <!-- Tabla para mostrar los registros existentes -->
        <h2>Registros</h2>
        <table id="records-table" class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Estado del Préstamo</th>
                    <th>Fecha de Inicio</th>
                    <th>Fecha de Fin</th>
                    <th>ID Bibliotecario</th>
                    <th>ID Persona</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody></tbody>
        </table>
    </div>
	</div>
	</div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/js/bootstrap.min.js"></script>
    <script src="script.js"></script>
</body>
</html>
