<?php session_start(); ?>
<?php

$conn = include '../conexion/conexion.php';
$pagina = $_GET['pagina'];
$informacion = $conn->query("SELECT htmlCodigo,seccion,nombre FROM tiempomaya.pagina WHERE categoria='" . $pagina . "' order by orden;");
$secciones = $conn->query("SELECT seccion FROM tiempomaya.pagina WHERE categoria='" . $pagina . "' group by seccion  order by orden;");
$elementos = $conn->query("SELECT nombre FROM tiempomaya.pagina WHERE categoria='" . $pagina . "' AND nombre!='Informacion' order by orden;");



?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Tiempo Maya - <?php echo $pagina ?></title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <?php include "../blocks/bloquesCss.html" ?>
    <link rel="stylesheet" href="../css/estilo.css?v=<?php echo (rand()); ?>" />
    <link rel="stylesheet" href="../css/paginaModelo.css?v=<?php echo (rand()); ?>" />


</head>
<?php include "NavBar.php" ?>

<body>
    <section id="inicio">
        <div id="inicioContainer" class="inicio-container">

            <?php echo "<h1>" . $pagina . " </h1>";
            foreach ($secciones as $seccion) {
                echo " <a href='#" . $seccion['seccion'] . "' class='btn-get-started'>" . $seccion['seccion'] . "</a>";
            }
            echo " <a href='#portafolio' class='btn-get-started'>Imagenes</a>";
            ?>
        </div>
    </section>

    <?php


    foreach ($secciones as $seccion) {
        $stringPrint = "<section id='" . $seccion['seccion'] . "'> <div class='container'> <div class='section-header'><h3 class='section-title'>" . $seccion['seccion'] . " </h3> </div>";
        foreach ($informacion as $info) {
            if ($seccion['seccion'] == $info['seccion']) {
                if ($info['seccion'] != "Informacion") {

                    $stringPrint .= "<a href='paginaModeloElemento.php?elemento=" . $info['nombre'] . "'/>" . $info['nombre'] . " </a>";
                }
                $stringPrint .= "<hr>";
                $stringPrint .= $info['htmlCodigo'];
                foreach ($elementos as $elemento) {
                    if ($elemento['nombre'] != 'Uayeb' && $elemento['nombre'] == $info['nombre']) {
                        $tabla = strtolower($elemento['nombre']);
                        $elementosEl = $conn->query("SELECT nombre FROM tiempomaya." . $tabla . ";");
                        $stringPrint .= "<ul>";
                        foreach ($elementosEl as $el) {
                            if ($el['nombre'] == "Informacion") {
                                $stringPrint .= "<li> <a href='#'>" . $el['nombre'] . " </a> </li>";
                            } else {
                                $stringPrint .= "<li> <a href='paginaModeloElemento.php?elemento=" . $info['nombre'] . "#" . $el['nombre'] . "'>" . $el['nombre'] . " </a> </li>";
                            }
                        }
                        $stringPrint .= "</ul>";
                    }
                }
            }
        }
        $stringPrint .= "</div> </section> <hr>";
        echo $stringPrint;
    }

    ?>



    <section id="portafolio">
        <div class="container wow fadeInUp">
            <div class="section-header">
                <h3 class="section-title">Imagenes</h3>
                <p class="section-description">Galeria de Imagenes - <?php echo $pagina ?></p>
            </div>
            <div class="row">

                <div class="col-lg-12">
                    <ul id="portafolio-flters">
                        <?php
                        $filtro = str_replace(' ', '', $pagina);
                        $stringPrint = "<li data-filter='.filter-" . $filtro . ", ";
                        foreach ($elementos as $elemento) {
                            if ($elemento['nombre'] != 'Kin' && $elemento['nombre'] != 'Uayeb') {
                                $stringPrint .= ".filter-" . $elemento['nombre'] . ",";
                            }
                        }
                        $stringPrint = substr($stringPrint, 0, -1);
                        $stringPrint .= "' class='filter-active'>Todos</li> ";
                        $stringPrint .= "<li data-filter='.filter-" . $filtro . "'>" . $pagina . "</li>";
                        foreach ($elementos as $elemento) {
                            if ($elemento['nombre'] != 'Kin' && $elemento['nombre'] != 'Uayeb') {
                                $stringPrint .= "<li data-filter='.filter-" . $elemento['nombre'] . "'>" . $elemento['nombre'] . "</li>";
                            }
                        }
                        echo $stringPrint;
                        ?>
                    </ul>
                </div>
            </div>
            <?php
            $stringPrint = " <div class='row' id='portafolio-wrapper'>";
            $filtro = str_replace(' ', '', $pagina);
            $imgs = $conn->query("SELECT * FROM tiempomaya.imagen WHERE categoria like '" . $pagina . "%';");
            $stringPrint .= "<div class='col-lg-3 col-md-6 portafolio-item filter-" . $filtro . "'>";
            foreach ($imgs as $img) {

                $stringPrint .= "<a href=\"" . $img['data'] . "\"><img src=\"" . $img['data'] . "\" width=\"150%\" target='_blank'/>";
                $stringPrint .= "<div class='details'>";
                $stringPrint .= "<h4>" . $img['descripcion'] . "</h4>";
                $stringPrint .= "<span>" . $pagina . "</span>";
                $stringPrint .= "</div>";
                $stringPrint .= "</a>";
            }
            $stringPrint .= "</div>";

            foreach ($elementos as $elemento) {
                if ($elemento['nombre'] != 'Kin' && $elemento['nombre'] != 'Uayeb') {
                    $categoria = $elemento['nombre'];
                    $imgs = $conn->query("SELECT * FROM tiempomaya.imagen WHERE categoria like '" . $categoria . "%';");
                    $stringPrint .= "<div class='col-lg-3 col-md-6 portafolio-item filter-" . $elemento['nombre'] . "'>";
                    foreach ($imgs as $img) {
                        $stringPrint .= "<a href=\"" . $img['data'] . "\" target='_blank' ><img src=\"" . $img['data'] . "\" width=\"150%\"/>";
                        $stringPrint .= "<div class='details'>";
                        $stringPrint .= "<h4>" . $img['descripcion'] . "</h4>";
                        $stringPrint .= "<span>" . $categoria . "</span>";
                        $stringPrint .= "</div>";
                        $stringPrint .= "</a>";
                    }
                    $stringPrint .= "</div>";
                }
            }
            $stringPrint .= "</div>";
            echo $stringPrint;

            ?>


        </div>
    </section>

    <?php include "../blocks/bloquesJs.html" ?>




</body>

</html>