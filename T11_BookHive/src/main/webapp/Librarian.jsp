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
			<div class="container mt-4">
				<!-- Formulario de creación -->
				<h2>Bibliotecario</h2>
				<div id="create-form">
					<form action="AgregarServlet" method="POST">
						<div class="mb-3 row">
							<label for="id" class="form-label col-sm-2">ID</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="id" name="id"
									readonly>
							</div>
						</div>
						<div class="mb-3 row">
							<label for="identity_document_type" class="form-label col-sm-2">Tipo
								de Documento</label>
							<div class="col-sm-6">
								<select class="form-select" id="identity_document_type"
									name="identity_document_type" required>
									<option selected disabled value="">Seleccionar...</option>
									<option value="DNI">DNI</option>
									<option value="CE">CE</option>
								</select>
								<div class="invalid-tooltip">Por favor, seleccione un tipo
									de documento.</div>
							</div>
						</div>
						<div class="mb-3 row">
							<label for="identity_document" class="form-label col-sm-2">Documento
								de Identidad</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="identity_document"
									name="identity_document" required>
								<div class="invalid-tooltip">Por favor, proporcione un
									documento de identidad válido.</div>
							</div>
						</div>
						<div class="mb-3 row">
							<label for="first_name" class="form-label col-sm-2">Nombre</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="first_name"
									name="first_name" required>
								<div class="invalid-tooltip">Por favor, proporcione un
									nombre válido.</div>
							</div>
						</div>
						<div class="mb-3 row">
							<label for="last_name" class="form-label col-sm-2">Apellido</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="last_name"
									name="last_name" required>
								<div class="invalid-tooltip">Por favor, proporcione un
									apellido válido.</div>
							</div>
						</div>
						<div class="mb-3 row">
							<label for="cellphone" class="form-label col-sm-2">Celular</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="cellphone"
									name="cellphone" maxlength="9" required>
								<div class="invalid-tooltip">Por favor, proporcione un
									número de celular válido.</div>
							</div>
						</div>
						<div class="mb-3 row">
							<div class="col-sm-12 text-end">
								<button type="submit" class="btn btn-primary">+Nuevo
									bibliotecario</button>
								<a href="#" class="btn btn-danger" title="Descargar PDF"><i
									class="fas fa-download"></i> PDF</a> <a href="#"
									class="btn btn-success" title="Descargar XLS"><i
									class="fas fa-download"></i> XLS</a> <a href="#"
									class="btn btn-warning" title="Descargar CSV"><i
									class="fas fa-download"></i> CSV</a>
							</div>
						</div>
					</form>
				</div>

				<!-- Tabla de registros existentes -->
				<div id="existing-records">
					<div class="col-sm-8">
						<div class="container-fluid">
							<h3>Bibliotecarios Existentes</h3>
							<form class="d-flex">
								<input class="form-control me-2 search-input" type="search"
									placeholder="Search" aria-label="Search">
								<button class="btn btn-outline-success" type="submit">Search</button>
							</form>

							<table class="table table-striped table-bordered"
								style="width: 100%; margin-top: 10px;">
								<thead class="table-dark">
									<tr>
										<th scope="col">ID</th>
										<th scope="col" style="width: 25%">Documento de Identidad</th>
										<th scope="col">Nombre</th>
										<th scope="col">Apellido</th>
										<th scope="col">Celular</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>1</td>
										<td>12345678</td>
										<td>María</td>
										<td>Pérez</td>
										<td>987654321</td>
									</tr>
									<tr>
										<td>2</td>
										<td>87654321</td>
										<td>Laura</td>
										<td>López</td>
										<td>123456789</td>
									</tr>
									<tr>
										<td>3</td>
										<td>45678912</td>
										<td>Ana</td>
										<td>García</td>
										<td>321654987</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>

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
	<script>
		// Generar automáticamente el campo ID al crear un nuevo registro
		function generateID() {
			var tableRows = document
					.querySelectorAll("#existing-records tbody tr");
			var lastID = 0;

			if (tableRows.length > 0) {
				var lastRow = tableRows[tableRows.length - 1];
				var idCell = lastRow.querySelector("td:first-child");
				lastID = parseInt(idCell.innerText);
			}

			var newID = lastID + 1;
			document.getElementById("id").value = newID.toString();
		}

		// Bloquear ingreso de letras y caracteres especiales en los campos "Documento de Identidad" y "Celular"
		document.getElementById("identity_document").addEventListener("input",
				function() {
					this.value = this.value.replace(/[^0-9]/g, "");
				});

		document.getElementById("cellphone").addEventListener("input",
				function() {
					this.value = this.value.replace(/[^0-9]/g, "");
				});

		// Establecer límite de dígitos en el campo "Documento de Identidad" según el tipo seleccionado
		document.getElementById("identity_document_type").addEventListener(
				"change",
				function() {
					var documentType = this.value;
					var documentInput = document
							.getElementById("identity_document");

					if (documentType === "DNI") {
						documentInput.setAttribute("maxlength", "8");
					} else if (documentType === "CE") {
						documentInput.setAttribute("maxlength", "20");
					} else {
						documentInput.removeAttribute("maxlength");
					}
				});

		// Validar el formulario al enviarlo
		document
				.getElementById("createLibrarianForm")
				.addEventListener(
						"submit",
						function(event) {
							event.preventDefault(); // Evitar envío del formulario

							if (this.checkValidity()) {
								// El formulario es válido, realizar acciones adicionales si es necesario
								console
										.log("Formulario válido. Enviar datos al servidor...");
								// Aquí puedes agregar el código para enviar los datos del formulario al servidor

								// Restablecer el formulario
								this.reset();
								generateID();
							} else {
								// El formulario no es válido, mostrar mensajes de error y resaltar campos inválidos
								console
										.log("Formulario inválido. Verificar campos...");
								this.classList.add("was-validated");
							}
						});

		// Filtrar registros existentes al hacer clic en el botón de búsqueda
		document
				.getElementById("searchButton")
				.addEventListener(
						"click",
						function() {
							var searchInput = document
									.getElementById("searchInput").value
									.toLowerCase();
							var tableRows = document
									.querySelectorAll("#existing-records tbody tr");

							tableRows.forEach(function(row) {
								var rowData = row.textContent.toLowerCase();

								if (rowData.includes(searchInput)) {
									row.style.display = "";
								} else {
									row.style.display = "none";
								}
							});
						});

		// Generar ID al cargar la página
		generateID();
	</script>
</body>
</html>
