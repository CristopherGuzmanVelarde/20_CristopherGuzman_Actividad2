<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
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
<style>
/* Estilos personalizados */
body 
.jumbotron {
	background-color: #343a40;
	color: #fff;
	padding: 40px;
	margin-bottom: 0;
}

.jumbotron h1 {
	font-size: 48px;
	font-weight: bold;
	margin-bottom: 20px;
}

.jumbotron p {
	font-size: 20px;
	margin-bottom: 30px;
}

.btn-primary {
	background-color: #007bff;
	border-color: #007bff;
}

.btn-primary:hover {
	background-color: #0069d9;
	border-color: #0062cc;
}

.features {
	margin-top: 40px;
}

.feature-item {
	text-align: center;
	padding: 20px;
	border-radius: 5px;
	background-color: #fff;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
	margin-bottom: 20px;
}

.feature-item i {
	font-size: 36px;
	color: #007bff;
	margin-bottom: 10px;
}

.feature-item h3 {
	font-size: 20px;
	margin-bottom: 10px;
}

.feature-item p {
	font-size: 16px;
	color: #555;
}

.card {
	margin-bottom: 20px;
}

.card-header {
	background-color: #007bff;
	color: #fff;
}

.card-body {
	background-color: #f8f9fa;
}

/* Estilos para dispositivos móviles */
@media ( max-width : 576px) {
	.jumbotron h1 {
		font-size: 36px;
	}
	.jumbotron p {
		font-size: 16px;
	}
}
</style>
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
						<li class="nav-item py-2 py-sm-0"><a href="#"
							class="nav-link text-white"> <i class="fs-5 fa fa-cube"></i>
								<span class="fs-4 ms-3 d-none d-sm-inline">Prestamo</span>
						</a></li>
						<li class="nav-item py-2 py-sm-0"><a href="#"
							class="nav-link text-white"> <i class="fs-5 fa fa-circle"></i>
								<span class="fs-4 ms-3 d-none d-sm-inline">Devolución</span>
						</a></li>
					</ul>
				</div>
			</div>
<div class="container mt-4">
  <div class="jumbotron p-3 m-0">
    <h1>Bienvenido a BookHive</h1>
    <p>La biblioteca virtual para los amantes de la lectura</p>
  </div>
  <div class="features">
    <div class="card-container row row-cols-2">
      <div class="col">
        <div class="card mb-4">
          <div class="card-header">
            Frase de libro 4
          </div>
          <div class="card-body">
            <p>Contenido de la frase del libro 4</p>
            <p>Autor: Nombre del autor 4</p>
          </div>
        </div>
      </div>
      <div class="col">
        <div class="card mb-4">
          <div class="card-header">
            Frase de libro 1
          </div>
          <div class="card-body">
            <p>Contenido de la frase del libro 1</p>
            <p>Autor: Nombre del autor 1</p>
          </div>
        </div>
      </div>
      <div class="col">
        <div class="card mb-4">
          <div class="card-header">
            Frase de libro 2
          </div>
          <div class="card-body">
            <p>Contenido de la frase del libro 2</p>
            <p>Autor: Nombre del autor 2</p>
          </div>
        </div>
      </div>
      <div class="col">
        <div class="card mb-4">
          <div class="card-header">
            Frase de libro 3
          </div>
          <div class="card-body">
            <p>Contenido de la frase del libro 3</p>
            <p>Autor: Nombre del autor 3</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</div>
</div>
</body>
</html>
