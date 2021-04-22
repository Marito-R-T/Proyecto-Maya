<?php
require('./cofigDB.php');
define('USER', $user);
define('PASSWORD', $password);
define('HOST', 'localhost');
define('DATABASE', $db);
try {
  $connection = new PDO("mysql:host=" . HOST . ";dbname=" . DATABASE, USER, PASSWORD);
} catch (PDOException $e) {
  exit("Error: " . $e->getMessage());
}
$sql = "";
$nahualID = $_GET['nahual'];

if ($nahualID != null) {
  $sql = "SELECT * FROM NAHUAL WHERE nombre LIKE '%" . $nahualID . "%'";
} else {
  $sql = "SELECT * FROM NAHUAL";
}
$statement = $connection->prepare($sql);
$statement->execute();
$values = $statement->fetchAll();
$rows = count($values) - 1;
$posNahual = rand(0, $rows);
$nahualDia = $values[$posNahual];



?>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <link href="style.css" rel="stylesheet">
  <title>Nahuales</title>
</head>

<body>


  <style>
    body {
      background-color: rgb(179, 176, 176);
    }

    .containerNoNav {
      display: grid;
      grid-template-columns: 1fr 1fr;
      grid-template-rows: 1fr;
      grid-gap: 35px;
      align-items: center;
      justify-content: center;
      border: 1px solid #c3c7c4;
      padding: 10px 10px;
    }
    a{
      color: black !important;
      font-size: 15px !important;
    }
  </style>
  <div class="headerContainer">
  <div class="header" >
    <header id="header">
      <div class="container">
        <nav id="nav-menu-container">
          <ul class="nav-menu">
            <li class="menu-active"> <a href="#hero" style="color: gray;font-size: 23px;"><strong>TIEMPO</strong> MAYA</a></li>
            <li><a href="#">Linea del Tiempo</a></li>
            <li><a href="#">Calendario Haab</a></li>
            <li><a href="#">Calendario Cholquij</a></li>
            <li><a href="ruedaCalendarica.php">Rueda calendarica</a></li>
            <li><a href="#">Cerrar Sesion</a></li>
          </ul>
        </nav>
      </div>
    </header>
  </div>
  <br><br><br><br>
   
  <form action="#" method="get" style="margin-left: 100px;">
    <div class="form-group" style="">
      <input type="text" class="from-control" name="nahual" aria-describedby="emailHelp" required>
      <button type="submit" class="btn btn-primary">Buscar</button>
    </div>
  </form>

  </div>
  <div class="containerNoNav">

    <div class="slider-content">
      <div id="carouselExampleInterval" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
          <?php
          $path = $nahualDia['rutaImagen'];
          $archivos = opendir($path);
          $contador = 0;
          while ($file = readdir($archivos)) {
            $ruta = $path . $file;
            if (!is_dir($file) && $contador == 0) {
          ?>
              <div class="carousel-item active" data-interval="10000">
                <img id="img-slider" src="<?php echo $ruta ?>" style="max-height: 350px; min-height: 350px;" class="d-block w-100" alt="">
              </div>
            <?php
              $contador = 1;
            } else if (!is_dir($file) && $contador != 0) {
            ?>
              <div class="carousel-item" data-interval="2000">
                <img id="img-slider" src="<?php echo $ruta ?>" style="max-height: 350px; min-height: 350px;" class="d-block w-100" alt="">
              </div>
          <?php
            }
          }
          ?>


        </div>
        <a class="carousel-control-prev" href="#carouselExampleInterval" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleInterval" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>
    </div>
    <div class="main-container">
      <br>
      <div class="card" style="width: 100%;">
        <div class="card-header">
          <h1>
            <?php echo $nahualDia['nombre'];  ?>
          </h1>
        </div>
        <ul class="list-group list-group-flush">
          <li class="list-group-item">
            <?php echo $nahualDia['significado']; ?>
          </li>
          <li class="list-group-item">
            <?php echo $nahualDia['fechaInicio']; ?>
          </li>
          <li class="list-group-item">
            <?php echo $nahualDia['fechaFin'];  ?>
          </li>

        </ul>
        <div class="card-body">
          <p>
            <?php echo $nahualDia['descripcion'];  ?>
          </p>
        </div>
        <div class="card-footer">
          <a href="editarNahual.php?id=<?php echo $nahualDia['nombre']; ?>">
            Editar Nahual
          </a>
        </div>
      </div>
    </div>
  </div>
  <br>

  <?php
  if ($_GET['nahuales'] != null || $_GET['nahual'] != null) {
    foreach ($values as $nahual) {
      if ($nahual['nombre'] == $nahualDia['nombre']) {
        continue;
      }
  ?>
      <div class="containerNoNav">
        <div class="slider-content">
          <div id="carouselExampleInterval" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
              <?php
              $path = $nahual['rutaImagen'];
              $archivos = opendir($path);
              $contador = 0;
              while ($file = readdir($archivos)) {
                $ruta = $path . $file;
                if (!is_dir($file) && $contador == 0) {
              ?>
                  <div class="carousel-item active" data-interval="2000">
                    <img id="img-slider" src="<?php echo $ruta ?>" class="d-block w-100" style="max-height: 350px; min-height: 350px;" alt="">
                  </div>
                <?php
                  $contador = 1;
                } else if (!is_dir($file) && $contador != 0) {
                ?>
                  <div class="carousel-item" data-interval="2000">
                    <img id="img-slider" src="<?php echo $ruta ?>" class="d-block w-100" style="max-height: 350px; min-height: 350px;" alt="">
                  </div>
              <?php
                }
              }
              ?>


            </div>
          </div>
        </div>
        <div class="main-container">
          <br>
          <div class="card" style="width: 100%;">
            <div class="card-header">
              <h1>
                <?php echo $nahual['nombre'];  ?>
              </h1>
            </div>
            <ul class="list-group list-group-flush">
              <li class="list-group-item">
                <?php echo $nahual['significado']; ?>
              </li>
              <li class="list-group-item">
                <?php echo $nahual['fechaInicio']; ?>
              </li>
              <li class="list-group-item">
                <?php echo $nahual['fechaFin'];  ?>
              </li>

            </ul>
            <div class="card-body">
              <p>
                <?php echo $nahual['descripcion'];  ?>
              </p>
            </div>
            <div class="card-footer">
              <a href="editarNahual.php?id=<?php echo $nahual['nombre']; ?>">
                Editar Nahual
              </a>
            </div>
          </div>
        </div>
      </div>
      <br>
    <?php
    }
  } else {
    ?>
    <form action="#" method="get">
      <input type="text" name="nahuales" value="all" hidden id="">
      <button type="submit" style="margin-left: 100px;" class="btn btn-primary">Ver mas nahuales</button>
    </form>
    <br>
  <?php
  }
  ?>
  <?php
  $connection = null;
  $statement = null;
  ?>
</body>

</html>