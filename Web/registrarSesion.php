<?php session_start(); ?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Tiempo Maya - Registrarse</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <?php include "blocks/bloquesCss.html" ?>
    <link rel="stylesheet" href="css/estilo.css?v=<?php echo (rand()); ?>" />
    <link rel="stylesheet" href="css/registroSesion.css?v=<?php echo (rand()); ?>" />

</head>

<body>
    <?php include "NavBar.php" ?>
    <div>
        <section id="inicio">
            <div id="inicioContainer" class="inicio-container">
                <div class="inner">
                    <div class="image-holder">
                        <img src="img/icono.jpg" alt="">
                    </div>
                    <form action="backend/registrarUsuario.php" method="POST">
                        <h1>Registrarse</h1>
                        <div class="form-group d-flex justify-content-between">
                            <label for="nombre">Nombre</label>
                            <label for="apellido">Apellido</label>
                        </div>
                        <div class="form-group">
                            <input type="text" required class="form-control" id="nombre" name="nombre"> 
                            <input type="text" required class="form-control" id="apellido" name="apellido">
                        </div>
                        <div class="form-group ">
                            <label for="usuario">Usuario</label>
                        </div>
                        <div class="form-wrapper">
                            <input type="text" id="usuario" class="form-control" name="usuario">
                            <i class="fas fa-user"></i>
                        </div>
                        <div class="form-group ">
                            <label for="correo">Correo</label>
                        </div>
                        <div class="form-wrapper">
                            <input type="email" required id="correo" class="form-control" name="correo">
                            <i class="fas fa-at"></i>
                        </div>
                        <div class="form-group d-flex justify-content-between">
                            <label for="celular">Celular</label>
                            <label for="apellido">Fecha de Nacimiento</label>
                        </div>
                        <div class="form-group">
                            <input type="text" autocomplete="off"  pattern="[0-9]{8}" minlength="8" maxlength="8" class="form-control" id="celular" name="celular">
                            <input type="date" class="form-control" require id="fechaNacimiento" name="fechaNacimiento">
                        </div>
                        <div class="form-group ">
                            <label for="password">Contraseña</label>
                        </div>
                        <div class="form-wrapper">
                            <input type="password" id="password" required class="form-control" name="password">
                            <i class="fas fa-lock"></i>
                        </div>
                        <div class="form-group">
                            <label for="passwordConfirm">Confirmar Contraseña</label><br>
                        </div>
                        <div class="form-wrapper">
                            <input type="password" id="passwordConfirm" required class="form-control" name="passwordConfirm">
                            <i class="fas fa-lock"></i>
                        </div>

                        <button class="btn btn-get-started">Registrar
                            <i class="fas fa-sign-in-alt"></i>
                        </button>
                    </form>
                </div>
            </div>
        </section>
    </div>
    <?php include "blocks/bloquesJs.html" ?>
</body>

</html>