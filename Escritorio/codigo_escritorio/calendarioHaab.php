<?php

        //conexion a cholqij
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
          
          $result = mysqli_query($conn, "SELECT * FROM datosCalendarioCholqij ");
          // Verificando si el usuario existe en la base de datos.
          if(mysqli_num_rows($result )>0){
            $fila =  $result->fetch_array(MYSQLI_ASSOC);       
             }else{
                header("Location: ../index.php"); 

          }
    
?>



<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Tiempo Maya</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Poppins:300,400,500,700" rel="stylesheet">
  <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://kit.fontawesome.com/e51fb510f5.js" crossorigin="anonymous"></script>
<link href="lib/animate/animate.min.css" rel="stylesheet">
  <link href="css/Calendarios.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">


</head>
<?php include "BarradeNavegacion.php" ?>
<body>

<section id="inicio">
<div class="inicio-container">

  <h1>Calendario Cholqij</h1>
    <a href="#information" class="btn-get-started">Informacion Calendario Cholqij</a>
    <a href="#sabernahual" class="btn-get-started">¿Que nahual cae en esta fecha?</a>
    <a href="./nahualesTM.php" class="btn-get-started">Nahuales</a>
    <a href="#portafolio" class="btn-get-started">Imagenes</a>
</div>
</section>

<div class="container">

<section id="information">
  <div class="container" >

      <br>
      <div class="section-header">
        <h3 class="section-title" font color= "orange" >Calendario Cholq'ij</font></h3>
      </div>
      <br>
      <h3 class="section-title" style="  color: #2dc997;">Informacion</h3>
        <hr>
        <?php foreach ($result as $fila) : ?>
            <p style="background:LemonChiffon">
            <?php echo $fila['titulo'] ?>
        </p>

            <p style="background:LemonChiffon">
            <?php echo $fila['concepto'] ?>

        </p>

            <?php endforeach; ?>


</div>
</section>


<section id="sabernahual">
  <div class="container">
          <h3 class="section-title" style="  color: #2dc997;">¿Que nahual caé en esta fecha?</h3>
          <form method="POST" action="./backend/mostrarNahualEnergia.php">
            <div class="form-group mb-2">
              <label for="staticEmail2" class="sr-only text-dark" style="background:Orange" >Ingresar fecha</label>
              <input type="date" class="form-control-plaintext text-dark border border-success" id="staticEmail2" name="date" required>
            </div>
            <div class="form-group mb-2">
              <button type="submit" class="btn btn-outline-success btn-lg btn-block mb-2">Buscar</button>
            </div>
          </form>
  </div>
</section>



<section id="portafolio" >
  <div class="container">
      <br>
      <div class="section-header">
        <h3 class="section-title">IMAGENES</h3>
      </div>
      <br>
      <br>
            <h5>Calendario Cholqij </h5>
          <img src="./imagenesCholqij/300px-Cholq'ij.jpg"  width="25%" alt="Imagen del Cholqij" style="margin-left: 150px;">
          <br>
          <img src="./imagenesCholqij/Cholqij.jpg"  width="25%" alt="Imagen del Cholqij" style="margin-left: 150px;">

          <br>
            <h5>Calendario Lunar </h5>
          <img src="./imagenesCholqij/calendario-maya-lunar.png"  width="25%" alt="Imagen del Cholqij" style="margin-left: 150px;">

          <br>
            <h5>Dias Cholqij </h5>
          <img src="./imagenesCholqij/dias.jpg"  width="25%" alt="Imagen del Cholqij" style="margin-left: 150px;">

</div>
</section>


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
  <script src="js/main.js"></script>
</body>
</html>


