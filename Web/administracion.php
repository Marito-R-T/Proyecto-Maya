<?php session_start(); ?>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Tiempo Maya</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <?php include "blocks/bloquesCss.html" ?>
  <link rel="stylesheet" href="css/estilo.css?v=<?php echo (rand()); ?>" />
  <link rel="stylesheet" href="css/estiloAdmin.css?v=<?php echo (rand()); ?>" />
</head>

<body>
<?php include "backend/verificarSesionAdmin.php"?>
  <?php include "NavBarAdmin.php" ?>
 
  <div>
    <section id="inicio">
      <div id="inicioContainer" class="inicio-container">
        <h1><br><br>Bienvenido al Tiempo Maya</h1>
        <h2><br><br>Administracion</h2>
      </div>
    </section>
  </div>


  <?php include "blocks/bloquesJs.html" ?>

</body>

</html>