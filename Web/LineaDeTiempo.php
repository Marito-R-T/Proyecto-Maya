<?php session_start(); ?>
<?php

$conn = include 'conexion/conexion.php';
$periodos = $conn->query("SELECT nombre, concat( concat(fechaInicio,' ',ACInicio) ,' - ',concat(fechaFin,' ',ACFin) ) as fechaTotal,descripcion,orden FROM tiempomaya.periodo order by orden;");
$acontecimientosL = $conn->query("SELECT a.*, concat(a.fechaInicio,' ', a.ACInicio ) as fechaI, concat(a.fechaFin,' ', a.ACFin ) as fechaF, p.orden FROM tiempomaya.acontecimiento as a INNER JOIN tiempomaya.periodo as p WHERE p.nombre = a.Periodo_nombre order by p.orden;");
?>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Tiempo Maya - Linea del Tiempo</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <?php include "blocks/bloquesCss.html" ?>
  <link rel="stylesheet" href="css/estilo.css?v=<?php echo (rand()); ?>" />
  <link rel="stylesheet" href="css/lineaTiempo.css?v=<?php echo (rand()); ?>" />



</head>

<body>
  <?php include "NavBar.php" ?>
  <div>
    <section id="inicio">
      <div id="inicioContainer" class="inicio-container">
        <div class="body-wrap">
          <div class="pres-timeline" id="this-timeline">
            <div class="periods-container">
              <?php
              foreach ($periodos as $periodo) { ?>
                
                  <section class="period-single" period="period<?php echo $periodo['orden']; ?>">
                    <h4 class="year"><?php echo $periodo['fechaTotal'] ?></h4>
                    <h2 class="title"><?php echo $periodo['nombre'] ?></h2>
                    <p><?php echo $periodo['descripcion'] ?></p>
                    <form action="paginaModeloPeriodo.php" method="GET">
                    <input hidden name="periodo" value="<?php echo $periodo['nombre'] ?>">
                    <button class=" btn btn-get-started">Ver
                      <i class="far fa-eye"></i>
                    </button>
                    </form>
                  </section>
               

              <?php
              }
              ?>
              <div class="btn-back"></div>
              <div class="btn-next"></div>
            </div>
            <div class="timeline-container">
              <div class="timeline"></div>
              <div class="btn-back"><svg width="30" height="30" viewBox="0 0 30 30" xmlns="http://www.w3.org/2000/svg">
                  <path fill="none" d="M0 0h30v30H0z" />
                  <path fill="#D8D8D8" fill-rule="evenodd" d="M11.828 15l7.89-7.89-2.83-2.828L6.283 14.89l.11.11-.11.11L16.89 25.72l2.828-2.83" />
                </svg></div>
              <div class="btn-next"><svg width="30" height="30" viewBox="0 0 30 30" xmlns="http://www.w3.org/2000/svg">
                  <path fill="none" d="M0 0h30v30H0z" />
                  <path fill="#D8D8D8" fill-rule="evenodd" d="M18.172 14.718l-7.89-7.89L13.112 4l10.606 10.607-.11.11.11.11-10.608 10.61-2.828-2.83 7.89-7.89" />
                </svg></div>
            </div>
            <div class="cards-container">
              <?php
              $i = 1;
              foreach ($acontecimientosL as $acontecimiento) { ?>
               
                  <?php if ($i == 1) { ?>
                    <section class="card-single active" period="period<?php echo $acontecimiento['orden']; ?>">
                    <?php } else { ?>
                      <section class="card-single" period="period<?php echo $acontecimiento['orden']; ?>">
                      <?php } ?>
                      <h4 class="year"><?php echo $acontecimiento['fechaI'];
                                        if ($acontecimiento['fechaF'] != '  ') {
                                          echo " - " . $acontecimiento['fechaF'];
                                        } ?></h4>
                      <h2 class="title"><?php echo $acontecimiento['titulo']; ?></h2>
                      <form action="acontecimiento.php" method="GET">
                      <input hidden name="categoria" value="<?php echo $acontecimiento['categoria']; ?>">
                      <button class=" btn btn-get-started">Ver
                        <i class="far fa-eye"></i>
                      </button>
                      </form>
                      </section>
              

              <?php $i++;
              }
              ?>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>


  <?php include "blocks/bloquesJs.html" ?>

  <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>

  <script src="js/LineaTiempo.js"></script>
</body>

</html>