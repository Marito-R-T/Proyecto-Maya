<?php session_start(); ?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Tiempo Maya - Perfil</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <?php include "../blocks/bloquesCss.html" ?>
    <link rel="stylesheet" href="../css/estilo.css?v=<?php echo (rand()); ?>" />
    <link rel="stylesheet" href="../css/Perfil.css?v=<?php echo (rand()); ?>" />
</head>

<body>
    <?php include "NavBar.php" ?>
    <?php include "../backend/verificarSesion.php"?>   
     <?php include '../backend/obtenerDatosUsuario.php' ?>
    <section id="inicio">
        <div id="inicioContainer" class="inicio-container">
            <div class="container">
                <div class="profile-env" style="background: rgba(0, 0, 0, 0.3);">
                    <header class="row">
                        <div class="col-sm-2">
                            <a class="profile-picture">
                                <img src=<?php echo $foto?> class="img-responsive img-circle" height="150px"> </a>
                        </div>
                        <div class="col-sm-7">
                            <ul class="profile-info-sections">
                                <li>
                                    <div class="profile-name">
                                        <strong>
                                            <a style=" color: #2dc997;">  <?php print($user['nombre'] . ' ' . $user['apellido']) ?></a>
                                            <a href="#" class="user-status is-online tooltip-primary" data-toggle="tooltip" data-placement="top" data-original-title="Online"></a>
                                        </strong>
                                        <span>
                                            <a href="">Nahual <?php print($nahual) ?> <br> Energia <?php print($energia) ?></a>
                                        </span>
                                    </div>
                                </li>
                                <li>
                                    <div class="profile-stat">
                                        <span data-toggle="counter-up" style="color: white;"><?php print($number) ?></span><br>
                                        <span>
                                            Aportes
                                        </span>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </header>
                    <section class="profile-info-tabs">
                        <div class="row">
                            <div class="col-sm-offset-2 col-sm-10">
                                <ul class="user-details">
                                    <li>
                                        <i class="entypo-location"></i>
                                        <i class="fas fa-at"></i>  <strong> <?php print($user['correo']) ?> </strong>
                                    </li>
                                    <li>
                                        <i class="entypo-location"></i>
                                         <?php print($user['celular']) ?> <strong> <i class="fas fa-phone"></i></strong>
                                    </li>
                                    <li>
                                        <i class="entypo-location"></i>
                                        <?php print($user['usuario']) ?>  <strong><i class="fas fa-user"></i> </strong>
                                    </li>
                                </ul>
                                <ul class="nav nav-tabs">
                                    <li>
                                        <a href="editarPerfil.php" style="font-weight: bold; color:#2dc997">Editar Perfil</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
        </div>
    </section>
    <?php include "../blocks/bloquesJs.html" ?>
</body>
</html>