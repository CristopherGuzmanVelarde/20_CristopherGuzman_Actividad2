<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8">
<title>Book Hive</title>
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
					<a class="d-flex text-decoration-none mt-1 align-items-center text-white">
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

				<div class="container mt-4">
					<h2>Libros</h2>
					<form action="create-book.jsp" method="POST">
						<div class="mb-3 row">
							<label for="id" class="form-label col-sm-2">ID</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="id" name="id" readonly>
							</div>
						</div>
						<div class="mb-3 row">
							<label for="name" class="form-label col-sm-2">Nombre</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="name" name="name" required>
							</div>
						</div>
						<div class="mb-3 row">
							<label for="author" class="form-label col-sm-2">Autor</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="author" name="author" required>
							</div>
						</div>
						<div class="mb-3 row">
							<label for="description" class="form-label col-sm-2">Descripción</label>
							<div class="col-sm-8">
								<textarea class="form-control" id="description" name="description" rows="3" required></textarea>
							</div>
						</div>
						<div class="mb-3 row">
							<label for="quantity" class="form-label col-sm-2">Cantidad</label>
							<div class="col-sm-8">
								<input type="number" class="form-control" id="quantity" name="quantity" min="1" required>
							</div>
						</div>
						<div class="mb-3 row">
							<div class="col-sm-12 text-end">
								<button type="submit" class="btn btn-primary">+Nuevo libro</button>
								<a href="#" class="btn btn-danger" title="Descargar PDF"><i class="fas fa-download"></i> PDF</a>
								<a href="#" class="btn btn-success" title="Descargar XLS"><i class="fas fa-download"></i> XLS</a>
								<a href="#" class="btn btn-warning" title="Descargar CSV"><i class="fas fa-download"></i> CSV</a>
							</div>
						</div>
					</form>
					<h2>Listado de libros</h2>
					<div class="col-sm-10">
						<form class="d-flex" id="search-form">
							<input class="form-control me-2 search-input" type="search" placeholder="Buscar" aria-label="Search" id="search-input">
							<button class="btn btn-outline-success" type="submit">Buscar</button>
						</form>
						<table class="table table-striped table-bordered table-hover" style="margin-top: 10px;">
							<thead class="table-dark">
								<tr>
									<th scope="col">ID</th>
									<th scope="col">Nombre</th>
									<th scope="col">Autor</th>
									<th scope="col">Descripción</th>
									<th scope="col">Cantidad</th>
									<th scope="col">Estado</th>
									<th scope="col">Acciones</th>
								</tr>
							</thead>
							<tbody>
								<!-- Ejemplo de datos de libros (puedes reemplazarlo con tus propios datos) -->
								<%
									String[][] books = {
											{ "1", "1984", "George Orwell", "Una novela distópica sobre el control del Estado y la vigilancia", "2", "A" },
											{ "2", "Cien años de soledad", "Gabriel García Márquez", "Una saga familiar en Macondo", "3", "A" },
											{ "3", "Fahrenheit 451", "Ray Bradbury", "Una obra sobre la censura y la quema de libros", "5", "A" },
											{ "4", "Don Quijote de la Mancha", "Miguel de Cervantes Saavedra", "La obra cumbre de la literatura española", "7", "A" },
											{ "5", "Orgullo y prejuicio", "Jane Austen", "Una novela romántica de la literatura inglesa", "4", "A" },
											{ "6", "Moby-Dick", "Herman Melville", "Una historia épica sobre la obsesión y la caza de ballenas", "2", "A" },
											{ "7", "La Odisea", "Homero", "Un poema épico que narra el regreso de Odiseo a casa", "3", "A" },
											{ "8", "Harry Potter y la piedra filosofal", "J.K. Rowling", "El comienzo de la famosa saga de Harry Potter", "5", "A" },
											{ "9", "Crimen y castigo", "Fiódor Dostoyevski", "Un estudio psicológico sobre culpa y redención", "4", "A" },
											{ "10", "El principito", "Antoine de Saint-Exupéry", "Un cuento filosófico sobre la amistad y el sentido de la vida", "6", "A" }
										};

									for (String[] book : books) {
										String id = book[0];
										String name = book[1];
										String author = book[2];
										String description = book[3];
										String quantity = book[4];
										String state = book[5];
								%>
								<tr>
									<td><%=id%></td>
									<td><%=name%></td>
									<td><%=author%></td>
									<td><%=description%></td>
									<td><%=quantity%></td>
									<td><%=state%></td>
									<td><a href="edit-book.jsp?id=<%=id%>" class="btn btn-primary btn-sm">Editar</a> <a href="delete-book.jsp?id=<%=id%>" class="btn btn-danger btn-sm">Eliminar</a></td>
								</tr>
								<%
									}
								%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>


	<!-- Scripts de Bootstrap 5 y JavaScript -->
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"></script>

	<script>
		$(document).ready(function() {
			// Manejar el evento de envío del formulario de búsqueda
			$("#search-form").submit(function(event) {
				event.preventDefault();
				var searchTerm = $("#search-input").val().toLowerCase();

				// Filtrar las filas de la tabla según el término de búsqueda
				$("table tbody tr").filter(function() {
					$(this).toggle($(this).text().toLowerCase().indexOf(searchTerm) > -1)
				});
			});
		});
	</script>
</body>

</html>
