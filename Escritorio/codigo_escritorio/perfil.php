<?php
    //agregamos cabecera
    echo '
    <div>
    <header id="header">';
    include "BarradeNavegacion.php";

        
    $nombreServidor = "localhost";
    $nombreUsuario = "newuser";
    $passwordBaseDeDatos = "password";
    $nombreBaseDeDatos = "calendarioTiempoMaya";
    
    // Crear conexión con la base de datos.
    $conn = new mysqli($nombreServidor, $nombreUsuario, $passwordBaseDeDatos, $nombreBaseDeDatos);
    
    // Validar la conexión de base de datos.
    if ($conn ->connect_error) {
      die("Connection failed: ".$conn->connect_error);
    }
  
    if (isset($_SESSION['nombre'])) { //mostramos el nombre del usuario
        $userNamer1 = $_SESSION['userName'];
        $result = mysqli_query($conn, "SELECT * FROM usuario WHERE username = '".$userNamer1."' ");
      
        // Verificando si el usuario existe en la base de datos.
        if(mysqli_num_rows($result )>0){
          $usuario =  $result->fetch_array(MYSQLI_ASSOC);
         }else{
          // Si no está logueado cerrar sesion por precaucion
          header("Location: ../cerrarSesion.php"); 
          header("Location: ../index.php"); 
        }
    }else{//no mostramos nada
        header("Location: ../index.php"); 

    }
?>


<!DOCTYPE html>
<html lang="es" dir="ltr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Poppins:300,400,500,700" rel="stylesheet">
    <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="lib/animate/animate.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <title>Inicio de Sesion</title>
</head>
<body>
<div class="container">

    <style>
        .main-container{
            width: 35%;
            margin: 100px  auto;
            padding: 20px 20px 60px;
            -webkit-box-shadow: 13px 10px 5px -4px rgba(0,0,0,0.75);
            -moz-box-shadow: 13px 10px 5px -4px rgba(0,0,0,0.75);
            box-shadow: 13px 10px 5px -4px rgba(0,0,0,0.75);
            background: 13px 10px 5px -4px rgba(222, 214, 255, 0.51);
            color:orange;
        }
        body{
        background: url("./img/fondo.png") ;
        background-size: cover;
        }
        .nav-menu > li > a:before {
        background-color: black;
        }
    </style>
    <br></br>
    <br></br>
    <br></br>
      <h1 class="text-center"><strong><font color ="orange"> PERFIL DE : </font></strong></h1>
      <h2 class="text-center"><strong><font color ="orange"> <?php echo $_SESSION['nombre'];?></font></strong></h2>
    	<br></br>
        <table class="table table-striped table-sm table-primary">
        <tr >
          <th>USERNAME: </th>
          <th>CORREO: </th>
          <th>NOMBRE: </th>
          <th>APELLIDO: </th>
          <th>NACIMIENTO: </th>
          <th>TELEFONO: </th>
        </tr>
          <tr>
            <td><?php echo $usuario['username'] ?></td>
            <td><?php echo $usuario['email'] ?></td>
            <td><?php echo $usuario['nombre'] ?></td>
            <td><?php echo $usuario['apellido'] ?></td>
            <td><?php echo $usuario['nacimiento'] ?></td>
            <td><?php echo $usuario['telefono'] ?></td>
          </tr>
        </table>
        <br></br>
        <form action="editarPerfil.php" method="post">
            <input type="submit" value="  Editar Perfil " class="btn btn-sm btn-warning">
        </form>
      <br></br>
    </div>
  <script src="lib/jquery/jquery.min.js"></script>
  <script src="lib/jquery/jquery-migrate.min.js"></script>
  <script src="lib/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="lib/easing/easing.min.js"></script>
  <script src="lib/wow/wow.min.js"></script>
  <script src="lib/waypoints/waypoints.min.js"></script>
  <script src="lib/counterup/counterup.min.js"></script>
  <script src="lib/superfish/hoverIntent.js"></script>
  <script src="lib/superfish/superfish.min.js"></script>
</body>
</html>