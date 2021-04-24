<?php session_start(); ?>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Tiempo Maya - Editar Perfil</title>
  <?php include "../blocks/bloquesCss.html" ?>
  <link rel="stylesheet" href="../css/estilo.css?v=<?php echo (rand()); ?>" />
  <link rel="stylesheet" href="../css/registroSesion.css?v=<?php echo (rand()); ?>" />
  <link rel="stylesheet" href="../css/editarPerfil.css?v=<?php echo (rand()); ?>" />
</head>
<?php include "../NavBar2.php" ?>
<?php include "../backend/verificarSesion.php"?>
<?php include "../backend/obtenerDatosUsuario.php" ?>

<body>
  <div>
    <section id="inicio">
      <div id="inicioContainer" class="inicio-container">
        <div class="inner" style="padding-top: 0px;margin-top: 85px;">
          <div class="row" style="width: 45%;">
            <div class="profile ">
              <form action="../backend/guardarFoto.php" method="POST">
                <div class="avatar-upload">
                  <div class="avatar-edit" style="left: 200px;">
                    <input type='file' id="imageUpload" accept=".png, .jpg, .jpeg ,.jfif" />
                    <label style="background-color: black;" for="imageUpload"><i class="far fa-edit"></i></label>
                    <textarea type="text" name="path" id="path" value="<?php echo $foto ?>" ></textarea>
                    <input hidden name="correo" value="<?php print($user['correo']) ?>">
                    <input hidden name="usuario" value="<?php print($user['usuario']) ?>">
                  </div>
                  <div class="avatar-preview">
                    <div id="previsualizacion" style="background-image: url(<?php echo $foto ?>);">
                    </div>
                  </div>
                  <button class="btn btn-get-started" style="width: 260px;">Guardar Foto
                    <i class="far fa-save"></i>
                  </button>
                </div>
              </form>
            </div>
            <div>
              <label><?php print($user['nombre'] . ' ' . $user['apellido']) ?></label><br>
              <span>
                <a href="#">Nahual <?php print($nahual) ?> <br> Energia <?php print($energia) ?></a>
              </span>
              <hr>
              <div class="profile-stat">
                <span data-toggle="counter-up" style="color: white;"><?php print($number) ?></span><br>
                <span>
                  <a>Mis Aportes</a>
                </span>
              </div>
            </div>
          </div>
          <form action="../backend/actualizarUsuario.php" method="POST" style="margin-top: 60px;">
            <h1>Informacion de Usuario</h1>
            <div class="form-group d-flex justify-content-between">
              <label for="nombre">Nombre</label>
              <label for="apellido">Apellido</label>
            </div>
            <div class="form-group">
              <input type="text" required class="form-control" id="nombre" name="nombre" value="<?php print($user['nombre']); ?>">
              <input type="text" required class="form-control" id="apellido" name="apellido" value="<?php print($user['apellido']); ?>">
            </div>
            <div class="form-group ">
              <label for="usuario">Usuario</label>
            </div>
            <div class="form-wrapper">
              <input type="text" id="usuario" class="form-control" name="usuario"  value="<?php print($user['usuario']) ?>">
              <i class="fas fa-user"></i>
            </div>
            <div class="form-group ">
              <label for="correo">Correo</label>
            </div>
            <div class="form-wrapper">
              <input type="email" required id="correo" class="form-control" name="correo" value="<?php print($user['correo']) ?>">
              <i class="fas fa-at"></i>
            </div>
            <div class="form-group d-flex justify-content-between">
              <label for="celular">Celular</label>
              <label for="fechaNacimiento">Fecha de Nacimiento</label>
            </div>
            <div class="form-group">
              <input type="text" autocomplete="off" pattern="[0-9]{8}" minlength="8" name='celular' maxlength="8" class="form-control" id="celular" value="<?php print($user['telefono']) ?>">
              <input type="date" class="form-control" id="fechaNacimiento" name="fechaNacimiento" value="<?php print($user['fechaNacimiento']) ?>">
            </div>
            <div class="form-group ">
              <label for="password">Nueva Contraseña</label>
            </div>
            <div class="form-wrapper">
              <input type="password" id="password"  class="form-control" name="password">
              <i class="fas fa-lock"></i>
            </div>
            <button class="btn btn-get-started">Guardar
              <i class="far fa-save"></i>
            </button>
          </form>
        </div>
      </div>
    </section>
  </div>
  <script type="text/javascript">
    jQuery(document).ready(function($) {
      function readURL(input) {
        if (input.files && input.files[0]) {
          var reader = new FileReader();
          reader.onload = function(e) {
            $('#previsualizacion').css('background-image', 'url(' + e.target.result + ')');
            $('#previsualizacion').hide();
            $('#previsualizacion').fadeIn(650);
            $('#path').val(e.target.result);
          }
          reader.readAsDataURL(input.files[0]);
        }
      }
      $("#imageUpload").change(function() {
        readURL(this);
      });
    });
  </script>


  <?php include "../blocks/bloquesJs.html" ?>
</body>

</html>