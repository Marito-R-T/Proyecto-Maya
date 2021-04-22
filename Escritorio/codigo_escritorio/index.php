
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Tiempo Maya</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Poppins:300,400,500,700" rel="stylesheet">
  <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="lib/animate/animate.min.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">
</head>

<body>

<?php include "BarradeNavegacion.php" ?>
  <section id="inicio">
    <div class="inicio-container">
      <h1>Bienvenido al Tiempo Maya</h1>
      <?php 
        if (isset($_SESSION['nombre'])) { //mostramos el nombre del usuario
            echo '<h1>'.$_SESSION['nombre'].'</li>';
        }else{//no mostramos nada
        }
        ?>        
    </div>
  </section>
  <footer id="footer">

    <div class="container">
      <div class="copyright">
        &copy; Copyright <strong>Teoria de Sistemas</strong>. Derechos Reservados
      </div>
    </div>
  </footer>
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
