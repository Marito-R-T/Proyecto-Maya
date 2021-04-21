<?php session_start(); ?>
<?php

$conn = include '../conexion/conexion.php';
$tabla = $_GET['elemento'];
$table =strtolower($tabla);
$datos = $conn->query("SELECT nombre,significado,htmlCodigo FROM tiempomaya." . $table . ";");
$elementos = $datos;
$informacion = $conn->query("SELECT htmlCodigo FROM tiempomaya.pagina WHERE nombre='" . $tabla . "';");



?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Tiempo Maya - <?php echo $tabla; ?></title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <?php include "../blocks/bloquesCss.html" ?>
    <link rel="stylesheet" href="../css/estilo.css?v=<?php echo (rand()); ?>" />
    <link rel="stylesheet" href="../css/paginaModelo.css?v=<?php echo (rand()); ?>" />


</head>
<?php include "NavBar.php" ?>

<body>
    <section id="inicio">
        <div id="inicioContainer" class="inicio-container">

            <?php echo "<h1>" . $tabla . " </h1>";
            ?>
            <a href='#informacion' class='btn-get-started'>Informacion</a>
            <a href='#elementos' class='btn-get-started'>Elementos</a>
            <a href='#portafolio' class='btn-get-started'>Imagenes</a>
        </div>
    </section>
    <section id="information">
        <div class="container">
            <div class="row about-container">
                <div class="section-header">
                    <h3 class="section-title">INFORMACION</h3>
                </div>
                <?php foreach($informacion as $info){
                    echo $info['htmlCodigo'];
                }?>
            </div>

        </div>
    </section>
    <hr>
    
    <section id="elementos">
        <div class="container">
            <div class="row about-container">
                <div class="section-header">
                    <h3 class="section-title">Elementos</h3>
                </div>
                <?php foreach($datos as $dato){
                   $stringPrint = "<h4 id='".$dato['nombre']."'>".$dato['nombre']."</h4>";
                   $stringPrint.="<h5>Significado</h5> <p>".$dato['significado']."</p>";
                   $stringPrint.="<p>".$dato['htmlCodigo']."</p> <hr>";
                   echo $stringPrint;
                }?>
            </div>

        </div>
    </section>
<hr>
    <section id="portafolio">
        <div class="container wow fadeInUp">
            <div class="section-header">
                <h3 class="section-title">Imagenes</h3>
                <p class="section-description">Galeria de Imagenes - <?php echo $tabla ?></p>
            </div>
            <?php
            $stringPrint = " <div class='row' id='portafolio-wrapper'>";
            $filtro = str_replace(' ', '', $tabla);
            $imgs = $conn->query("SELECT * FROM tiempomaya.imagen WHERE categoria like '" . $tabla . "%';");
            $stringPrint .= "<div class='col-lg-3 col-md-6 portafolio-item '>";
            foreach ($imgs as $img) {

                $stringPrint .= "<a href=\"" . $img['data'] . "\"><img src=\"" . $img['data'] . "\" width=\"150%\" target='_blank'/>";
                $stringPrint .= "<div class='details'>";
                $stringPrint .= "<h4>" . $img['descripcion'] . "</h4>";
                $stringPrint .= "<span>" . $pagina . "</span>";
                $stringPrint .= "</div>";
                $stringPrint .= "</a>";
            }
            $stringPrint .= "</div>";
            echo $stringPrint;

            ?>


        </div>
    </section>

    <?php include "../blocks/bloquesJs.html" ?>




</body>

</html>