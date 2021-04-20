<?php session_start(); ?>
<?php

$conn = include 'conexion/conexion.php';
$periodoP = $_GET['n'];
$infos = $conn->query("SELECT * FROM tiempomaya.periodo WHERE nombre = '".$periodoP."';");
$info = mysqli_fetch_assoc($infos);



?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Tiempo Maya - <?php echo $periodoP; ?></title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <?php include "blocks/bloquesCss.html" ?>
    <link rel="stylesheet" href="css/estilo.css?v=<?php echo (rand()); ?>" />
    <link rel="stylesheet" href="css/paginaModelo.css?v=<?php echo (rand()); ?>" />


</head>
<?php include "NavBar.php" ?>

<body>
    <section id="inicio">
        <div id="inicioContainer" class="inicio-container">

            <?php echo "<h1>" . $periodoP . " </h1>";
            ?>
            <a href='#informacion' class='btn-get-started'>Informacion</a>
            <a href='#portafolio' class='btn-get-started'>Imagenes</a>
        </div>
    </section>
    <section id="information">
        <div class="container">
            <div class="row about-container">
                <div class="section-header">
                    <h3 class="section-title">INFORMACION</h3>
                </div>
                <?php 
                    echo $info['htmlCodigo'];
                ?>
            </div>

        </div>
    </section>
    <hr>
    
    <section id="portafolio">
        <div class="container wow fadeInUp">
            <div class="section-header">
                <h3 class="section-title">Imagenes</h3>
                <p class="section-description">Galeria de Imagenes - <?php echo $periodoP ?></p>
            </div>
            <?php
            $stringPrint = " <div class='row' id='portafolio-wrapper'>";
            $imgs = $conn->query("SELECT i.*,a.titulo,concat(a.fechaInicio,' ', a.ACInicio ) as fechaI, concat(a.fechaFin,' ', a.ACFin ) as fechaF FROM tiempomaya.imagen as i INNER join tiempomaya.acontecimiento as a ON a.Periodo_nombre='".$periodoP."' WHERE i.categoria=a.categoria;");
           
            foreach ($imgs as $img) {
                $stringPrint .= "<div class='col-lg-3 col-md-6 portafolio-item '>";
                $stringPrint .= "<a href=\"" . $img['data'] . "\"><img src=\"" . $img['data'] . "\" width=\"150%\" target='_blank'/>";
                $stringPrint .= "<div class='details'>";
                $stringPrint .= "<h4>" . $img['titulo'] ." ".$img['fechaI']." - ".$img['fechaF']. "</h4>";
                $stringPrint .= "<span>" . $periodoP . "</span>";
                $stringPrint .= "</div>";
                $stringPrint .= "</a>";
                $stringPrint .= "</div>";
            }
            
            echo $stringPrint;

            ?>


        </div>
    </section>

    <?php include "blocks/bloquesJs.html" ?>




</body>

</html>