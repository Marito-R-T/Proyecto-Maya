<?php session_start(); ?>

<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Tiempo Maya - Acontecimiento</title>
    <?php include "../blocks/bloquesCss.html" ?>
    <link rel="stylesheet" href="../css/estilo.css?v=<?php echo (rand()); ?>" />
    <link rel="stylesheet" href="../css/registroSesion.css?v=<?php echo (rand()); ?>" />
    <link rel="stylesheet" href="../css/editarPerfil.css?v=<?php echo (rand()); ?>" />

</head>
<?php include "NavBar.php" ?>
<?php include "../backend/verificarSesion.php"?>

<body>
    <div>
        <section id="inicio">
            <div id="inicioContainer" class="inicio-container">
                <div class="inner" style="margin-top: 120px;">
                    <div class="row" style="width: 45%;">
                        <div class="profile">
                            <img src="img/icono.jpg" style="padding-top: 30px;" class="rounded-circle" alt="tikal en animacion">
                        </div>
                    </div>
                    <form action="../backend/guardarAcontecimiento.php" method="POST">
                        <h1>Acontecimiento</h1>
                        <div class="form-group">
                            <label for="nombre">Titulo</label>
                        </div>
                        <div class="form-group">
                            <input type="text" required class="form-control" id="titulo" name="titulo">
                        </div>
                        <div class="form-group ">
                            <label for="descripcion">Descripcion</label>
                        </div>
                        <div class="form-wrapper">
                            <textarea type="text" id="descripcion" required style="height: 120px;" rows="5" name="descripcion" class="form-control"></textarea>
                            <i class="fas fa-edit"></i>
                        </div>
                        <div class="form-group d-flex justify-content">
                            <div>
                                <div class="form-group d-flex justify-content">
                                    <label for="fecha">Fecha Inicio</label> &nbsp&nbsp <i class="far fa-calendar-alt"></i>
                                </div>

                                <div class="form-group d-flex justify-content-between">
                                    <label for="year">Año</label>
                                </div>
                                <div class="form-group d-flex justify-content-between">
                                    <input type="text" autocomplete="off" pattern="[0-9]+" required minlength="1" maxlength="4" name="yearI" class="form-control" id="year">
                                </div>
                                <div class="form-group" style="height: 40px;">
                                    <input type="checkbox" class="btn-check" id="btn-check-2-outlined" name="ACI" autocomplete="off">
                                    <label class="btn btn-outline-secondary" for="btn-check-2-outlined" style="font-size: 10px;">A. C.</label><br>
                                </div>
                            </div>
                            <div>
                                <div class="form-group d-flex justify-content">
                                    <label for="fecha">Fecha Fin</label> &nbsp&nbsp <i class="far fa-calendar-alt"></i>
                                </div>

                                <div class="form-group d-flex justify-content-between">
                                    <label for="year">Año</label>
                                </div>
                                <div class="form-group d-flex justify-content-between">
                                    <input type="text" autocomplete="off" pattern="[0-9]+" minlength="1" maxlength="4" name="yearF" class="form-control" id="year">
                                </div>
                                <div class="form-group" style="height: 40px;">
                                    <input type="checkbox" class="btn-check" id="btn-check-2-outlined" name="ACF" autocomplete="off">
                                    <label class="btn btn-outline-secondary" for="btn-check-2-outlined" style="font-size: 10px;">A. C.</label><br>
                                </div>
                            </div>
                        </div>
                        <button class="btn btn-get-started">Siguiente
                            <i class="fas fa-arrow-right"></i>
                        </button>
                    </form>
                </div>
            </div>
        </section>
    </div>

    <?php include "../blocks/bloquesJs.html" ?>


</body>

</html>