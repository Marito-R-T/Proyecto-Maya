<?php session_start(); ?>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Tiempo Maya - Inicio de Sesion</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <?php include "../blocks/bloquesCss.html" ?>
  <link rel="stylesheet" href="../css/estilo.css?v=<?php echo (rand()); ?>" />
  <link rel="stylesheet" href="../css/inicioSesion.css?v=<?php echo (rand()); ?>" />

</head>

<body>

  <?php include "../NavBar2.php" ?>
  <div>
    <section id="inicio">
      <div id="inicioContainer" class="inicio-container">

        <div id='formulario'>
          <form action="../backend/inicioSesion.php" method="POST">
            <h1>Inicio de Sesion</h1>
            <div class="mb-1">
              <label for="email" class="form-label ">Correo Electronico</label>
              <input type="email" class="form-control" name="email" id="email" aria-describedby="emailHelp">
            </div>
            <div class="mb-1">
              <label for="password" class="form-label ">Contraseña</label>
              <div class="input-group">
                <input type="password" class="form-control" id="password" name="password">
                <div class="input-group-append">
                  <button id="show_password" class="btn btn-primary" type="button" onclick="mostrarPassword()"> <span class="fa fa-eye-slash icon"></span> </button>
                </div>
              </div>
            </div>
            <button type="submit" class="btn btn-get-started">Login</button>
          </form>
        </div>

      </div>
  </div>
  </section>
  </div>


  <?php include "../blocks/bloquesJs.html" ?>

  <script type="text/javascript">
    <?php include "../js/PasswrdUser.js" ?>
  </script>

</body>

</html>