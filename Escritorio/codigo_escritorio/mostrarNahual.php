
<?php

  if (isset($_POST['idN'])) {
    $nombreServidor = "localhost";
    $nombreUsuario = "newuser";
    $passwordBaseDeDatos = "password";
    $nombreBaseDeDatos = "calendarioTiempoMaya";
    $idNahualBuscar = $_POST['idN'];
    
      // Crear conexión con la base de datos.
      $conn = new mysqli($nombreServidor, $nombreUsuario, $passwordBaseDeDatos, $nombreBaseDeDatos);
      
      // Validar la conexión de base de datos.
      if ($conn ->connect_error) {
        die("Connection failed: ".$conn->connect_error);
      }
      
      $result = mysqli_query($conn, "SELECT * FROM nahual WHERE id = '".$idNahualBuscar."' ");
      // Verificando si el usuario existe en la base de datos.
      if(mysqli_num_rows($result )>0){
        $fila =  $result->fetch_array(MYSQLI_ASSOC);
        $valId=$fila['id'];
        if($valId>10){
            $valId=$valId -10;    
            $val="./imagenesNahuales/Nahual".$valId.".jpg";

        }else{
            $valId=$valId  +10;    
            $val="./imagenesNahuales/Nahual".$valId.".jpg";
        }
        
      }
  }else{
        header("Location: ../index.php"); 
  }
?>



<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Tiempo Maya</title>
  <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Poppins:300,400,500,700" rel="stylesheet">
    <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="lib/animate/animate.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">


</head>
<?php include "BarradeNavegacion.php" ?>
<body>

<section id="information">
<div class="container" >
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

    <div class="row about-container">

      <div class="col-lg-6 content order-lg-1 order-2">
      <br>
      
      <div class="section-header">
        <h3 class="section-title" style="background:white" >Nombre</h3>
      </div>
      <br>
        <hr>
        <p style="background:LemonChiffon" ><?php echo $fila['nombre'] ?>
        </p>
      </div>

      <div class="col-lg-6 background order-lg-2 order-1 wow fadeInRight">
      <div class="section-header">
        <h3 class="section-title" style="background:white">Imagen Nahual </h3>
      </div>
          <br>
          <img src="<?php echo $val ?>"  width="20%" alt="Imagen del nahual" style="margin-left: 150px;">
     </div>


    <div class="col-lg-6 content order-lg-1 order-2">
      <br>
      <div class="section-header">
        <h3 class="section-title" style="background:white">Fecha Inicio</h3>
      </div>
      <br>
        <hr>
        <p style="background:LemonChiffon"><?php echo $fila['fechaInicio'] ?>
        </p>
        <div class="section-header">
        <h3 class="section-title" style="background:white">Fecha Finalizacion</h3>
      </div>
      <br>
        <hr>
        <p style="background:LemonChiffon"><?php echo $fila['fechaFinalizacion'] ?>
        </p>
      </div>

      <div class="col-lg-6 content order-lg-1 order-2">
      <br>
      <div class="section-header">
        <h3 class="section-title" style="background:white">Significado</h3>
      </div>
      <br>
        <hr>
        <p style="background:LemonChiffon"><?php echo $fila['significado'] ?>
        </p>
      </div>

      <div class="col-lg-6 content order-lg-1 order-2">
      <br>
      <div class="section-header">
        <h3 class="section-title" style="background:white">Descripcion</h3>
      </div>
      <br>
        <hr>
        <p style="background:LemonChiffon"><?php echo $fila['descripcion'] ?>
        </p>
      </div>

      <div class="col-lg-6 content order-lg-1 order-2">
      <br>
      <div class="section-header">
        <h3 class="section-title" style="background:white">Representacion</h3>
      </div>
      <br>
        <hr>
        <p style="background:LemonChiffon"><?php echo $fila['nombreSp'] ?>
        </p>
        <div class="section-header">
        <h3 class="section-title" style="background:white" >Nombre Yucateco</h3>
      </div>
      <br>
        <hr>
        <p style="background:LemonChiffon"><?php echo $fila['nombreYucateco'] ?>
        </p>
      </div>

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
 </head>