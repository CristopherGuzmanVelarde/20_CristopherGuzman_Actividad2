<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookHive</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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

				<%-- Agregar registro --%>
				<h2>Registro de personas</h2>
				<form action="AgregarServlet" method="POST">
					<div class="mb-3 row">
						<label for="id" class="form-label col-sm-2">ID</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="id" name="id"
								readonly>
						</div>
					</div>
					<div class="mb-3 row">
						<label for="first_name" class="form-label col-sm-2">Nombre</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="first_name"
								name="first_name" required>
							<div class="invalid-tooltip">Por favor, proporcione un
								nombre válido.</div>
						</div>
					</div>
					<div class="mb-3 row">
						<label for="last_name" class="form-label col-sm-2">Apellido</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="last_name"
								name="last_name" required>
							<div class="invalid-tooltip">Por favor, proporcione un
								apellido válido.</div>
						</div>
					</div>
					<div class="mb-3 row">
						<label for="identity_document" class="form-label col-sm-2">Documento
							de Identidad</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="identity_document"
								name="identity_document" required>
							<div class="invalid-tooltip">Por favor, proporcione un
								documento de identidad válido.</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-5">
							<div class="mb-3">
								<label for="grado" class="form-label">Grado</label> <select
									class="form-select" id="grado" name="grado" required>
									<option value="" disabled selected>Seleccionar Grado</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
								</select>
							</div>
						</div>
						<div class="col-sm-5">
							<div class="mb-3">
								<label for="seccion" class="form-label">Sección</label> <select
									class="form-select" id="seccion" name="seccion" required>
									<option value="" disabled selected>Seleccionar Sección</option>
									<option value="a">A</option>
									<option value="b">B</option>
									<option value="c">C</option>
								</select>
							</div>
						</div>
					</div>


					<div class="row">
						<div class="col-sm-5">
							<div class="mb-3">
								<label for="estado" class="form-label">Estado</label> <select
									class="form-select" id="estado" name="estado"
									required>
									<option value="" disabled selected>Seleccionar Estado</option>
									<option value="activo">Activo</option>
									<option value="inactivo">Inactivo</option>
								</select>
							</div>
						</div>

						<div class="col-sm-5">
							<div class="mb-3">
								<label for="tipoPersona" class="form-label">Tipo de
									Persona</label> <select
									class="form-select custom-select"
									id="tipoPersona" name="tipoPersona" required>
									<option value="" disabled selected>Seleccionar Tipo de
										Persona</option>
									<option value="estudiante">Estudiante</option>
									<option value="docente">Docente</option>
								</select>
							</div>
						</div>
					</div>

					<div class="mb-3 row">
						<label for="cellphone" class="form-label col-sm-2">Celular</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="cellphone"
								name="cellphone" maxlength="9" required>
							<div class="invalid-tooltip">Por favor, proporcione un
								número de celular válido.</div>
						</div>
					</div>
					<div class="mb-3 row">
						<div class="col-sm-12 text-end">
							<button type="submit" class="btn btn-primary">+Nuevo
								Registro</button>
							<a href="#" class="btn btn-danger" title="Descargar PDF"><i
								class="fas fa-download"></i> PDF</a> <a href="#"
								class="btn btn-success" title="Descargar XLS"><i
								class="fas fa-download"></i> XLS</a> <a href="#"
								class="btn btn-warning" title="Descargar CSV"><i
								class="fas fa-download"></i> CSV</a>
						</div>
					</div>
				</form>

				<%-- Leer registros --%>
				<h2>Lista de registros</h2>
				<div class="col-sm-10">
					<table class="table table-striped table-bordered"
						style="width: 100%; margin-top: 10px;">
						<thead class="table-dark">

							<tr>
								<th scope="col" class="text-center">ID</th>
								<th scope="col">Nombre</th>
								<th scope="col">Apellido</th>
								<th scope="col" style="width: 15%" class="text-center">Documento
									de Identidad</th>
								<th scope="col" style="width: 5%">Grado</th>
								<th scope="col" style="width: 5%">Sección</th>
								<th scope="col" style="width: 5%">Estado</th>
								<th scope="col" style="width: 8%">Tipo de Persona</th>
								<th scope="col" style="width: 10%" class="text-center">Celular</th>
								<th scope="col" style="width: 15%" class="text-center">Acciones</th>
							</tr>
						</thead>
						<tbody>
							<%-- Aquí se deben mostrar los registros obtenidos de la base de datos --%>
							<tr>
								<td class="text-center">1</td>
								<td>María</td>
								<td>Pérez</td>
								<td class="text-center">12345678</td>
								<td class="text-center">2</td>
								<td class="text-center">b</td>
								<td class="text-center">A</td>
								<td class="text-center">E</td>
								<td class="text-center">987654321</td>
								<td><a href="#" class="btn btn-sm btn-primary">Editar</a> <a
									href="#" class="btn btn-sm btn-danger">Eliminar</a></td>
							</tr>
							<tr>
								<td class="text-center">2</td>
								<td>Laura</td>
								<td>López</td>
								<td class="text-center">87654321</td>
								<td class="text-center">1</td>
								<td class="text-center">c</td>
								<td class="text-center">I</td>
								<td class="text-center">E</td>
								<td class="text-center">123456789</td>
								<td><a href="#" class="btn btn-sm btn-primary">Editar</a> <a
									href="#" class="btn btn-sm btn-danger">Eliminar</a></td>
							</tr>
							<tr>
								<td class="text-center">3</td>
								<td>Ana</td>
								<td>García</td>
								<td class="text-center">45678912</td>
								<td class="text-center">3</td>
								<td class="text-center">a</td>
								<td class="text-center">A</td>
								<td class="text-center">E</td>
								<td class="text-center">321654987</td>
								<td><a href="#" class="btn btn-sm btn-primary">Editar</a> <a
									href="#" class="btn btn-sm btn-danger">Eliminar</a></td>
							</tr>
							<tr>
								<td class="text-center">4</td>
								<td>Sofía</td>
								<td>Gómez</td>
								<td class="text-center">78912345</td>
								<td class="text-center">5</td>
								<td class="text-center">b</td>
								<td class="text-center">I</td>
								<td class="text-center">E</td>
								<td class="text-center">654987321</td>
								<td><a href="#" class="btn btn-sm btn-primary">Editar</a> <a
									href="#" class="btn btn-sm btn-danger">Eliminar</a></td>
							</tr>
							<tr>
								<td class="text-center">5</td>
								<td>Valentina</td>
								<td>Torres</td>
								<td class="text-center">54321987</td>
								<td class="text-center">4</td>
								<td class="text-center">d</td>
								<td class="text-center">A</td>
								<td class="text-center">E</td>
								<td class="text-center">789123456</td>
								<td><a href="#" class="btn btn-sm btn-primary">Editar</a> <a
									href="#" class="btn btn-sm btn-danger">Eliminar</a></td>
							</tr>
							<tr>
								<td class="text-center">6</td>
								<td>Mariana</td>
								<td>Martínez</td>
								<td class="text-center">32165498</td>
								<td class="text-center">4</td>
								<td class="text-center">a</td>
								<td class="text-center">I</td>
								<td class="text-center">E</td>
								<td class="text-center">456789123</td>
								<td><a href="#" class="btn btn-sm btn-primary">Editar</a> <a
									href="#" class="btn btn-sm btn-danger">Eliminar</a></td>
							</tr>
							<tr>
								<td class="text-center">7</td>
								<td>Carolina</td>
								<td>Hernández</td>
								<td class="text-center">15975385</td>
								<td class="text-center">2</td>
								<td class="text-center">b</td>
								<td class="text-center">A</td>
								<td class="text-center">E</td>
								<td class="text-center">852369741</td>
								<td><a href="#" class="btn btn-sm btn-primary">Editar</a> <a
									href="#" class="btn btn-sm btn-danger">Eliminar</a></td>
							</tr>
							<tr>
								<td class="text-center">8</td>
								<td>Isabella</td>
								<td>Rodríguez</td>
								<td class="text-center">75395182</td>
								<td class="text-center">1</td>
								<td class="text-center">c</td>
								<td class="text-center">I</td>
								<td class="text-center">E</td>
								<td class="text-center">369741852</td>
								<td><a href="#" class="btn btn-sm btn-primary">Editar</a> <a
									href="#" class="btn btn-sm btn-danger">Eliminar</a></td>
							</tr>
							<tr>
								<td class="text-center">9</td>
								<td>Gabriela</td>
								<td>Silva</td>
								<td class="text-center">85275395</td>
								<td class="text-center">3</td>
								<td class="text-center">a</td>
								<td class="text-center">A</td>
								<td class="text-center">E</td>
								<td class="text-center">741852369</td>
								<td><a href="#" class="btn btn-sm btn-primary">Editar</a> <a
									href="#" class="btn btn-sm btn-danger">Eliminar</a></td>
							</tr>
							<tr>
								<td class="text-center">10</td>
								<td>Luisa</td>
								<td>Ramírez</td>
								<td class="text-center">95185275</td>
								<td class="text-center">5</td>
								<td class="text-center">d</td>
								<td class="text-center">I</td>
								<td class="text-center">E</td>
								<td class="text-center">852369741</td>
								<td><a href="#" class="btn btn-sm btn-primary">Editar</a> <a
									href="#" class="btn btn-sm btn-danger">Eliminar</a></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
