<?php session_start(); ?>
<?php

if(isset($_GET['categoria'])){
    $categoria = $_GET['categoria'];
    $connection = include '../conexion/conexion.php';
    $acontecimiento_info = $connection->query("SELECT a.* , u.nombre , u.apellido, concat(a.fechaInicio,' ', a.ACInicio ) as fechaI, concat(a.fechaFin,' ', a.ACFin ) as fechaF FROM tiempomaya.acontecimiento as a INNER JOIN tiempomaya.usuario as u ON u.usuario=a.autor WHERE a.categoria='" . $categoria . "';");
    if ($acontecimiento_info->num_rows == 1) {
      $acontecimiento = mysqli_fetch_assoc($acontecimiento_info);
    }
    
    $imagens = $connection->query("SELECT * FROM tiempomaya.imagen WHERE categoria='" . $categoria . "' ;");
    
    
    $connection->close();
}else{
    header('location: ../index.php');
}

?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Tiempo Maya - Registrarse</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <?php include "../blocks/bloquesCss.html" ?>
    <link rel="stylesheet" href="../css/estilo.css?v=<?php echo (rand()); ?>" />
    <link rel="stylesheet" href="../css/acontecimiento.css?v=<?php echo (rand()); ?>" />

</head>

<body>
    <?php include "NavBar.php" ?>
    <div>
        <section id="inicio">
            <div id="inicioContainer" class="inicio-container">
                <div class="inner">
                    <div class="image-holder">
                        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators" style="top: 320px;">
                                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                                <?php $i=1;foreach($imagens as $img){?>
                                    <li data-target="#carouselExampleIndicators"  data-slide-to="<?php echo $i ?>"></li>
                                    <?php $i++;}?>
                               
                            </ol>
                            <div class="carousel-inner">
                                <div class="carousel-item active">
                                    <img class="d-block" src="../img/icono.jpg" width="300" height="300" alt="Imagen 1">
                                </div>
                                <?php foreach($imagens as $img){?>
                                    <div class="carousel-item">
                                    <img class="d-block w-100" src="<?php echo $img['data'] ?>" width="300" height="300" alt="<?php echo $img['nombre'] ?>">
                                </div>
                                 <?php }?>
                               
                            </div>
                            
                            
                        </div>
                    </div>
                    <div class="informacion" style="text-align: start; padding-left:50px;">
                        <h1><?php echo $acontecimiento['titulo'];?></h1> <br>
                        <label>Periodo: <?php echo $acontecimiento['Periodo_nombre'];?> </label> <br>
                        <label>Fecha: <?php echo $acontecimiento['fechaI']; if($acontecimiento['fechaF']!='  '){echo " - ".$acontecimiento['fechaF'];}?> </label> <br>
                        <label>Descripcion: </label> <br>
                        <p><?php echo $acontecimiento['htmlCodigo'];?></p> <br>
                        <div> <label style="font-size: 10px;">Autor:  <?php echo $acontecimiento['nombre']." ".$acontecimiento['apellido'];?></label></div>
                    </div>
                </div>
            </div>
        </section>
    </div>

    <?php include "../blocks/bloquesJs.html" ?>

</body>

</html>