<?php
$ID = $_GET['id'];
if ($ID != null) {
    $sql = "SELECT * FROM NAHUAL WHERE nombre='" . $ID . "'";
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
    $statement = $connection->prepare($sql);
    $statement->execute();
    $values = $statement->fetchAll();
    $row = $values[0];
    $fechaInicio = $row['fechaInicio'];
    $fechaFin = $row['fechaFin'];
    $descripcion = $row['descripcion'];
    $significado = $row['significado'];
} else {
    header("location:nahuales.php");
}
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="./TiempoMaya_Web/css/style13.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link href="style.css" rel="stylesheet">
  
    <title>Document</title>
</head>

<body>
    <style>
        body {
            background-color: rgb(238, 234, 234);
        }

        .main-container {
            display: grid;
            grid-template-columns: minmax(200px, 500px) 1fr;
            grid-gap: 20px;
            grid-template-rows: 1fr 50px auto;
            grid-template-areas: "date descrip"
                "none none"
                "mean image";
            height: 100%;

        }

        .description {
            grid-column-start: descrip;
            grid-column-end: descrip;
            grid-row-start: descrip;
            grid-row-end: descrip;
            align-self: center;
            justify-self: center;
        }

        .form-content {
            height: 100%;
            display: block;
        }

        .mean {
            grid-column-start: mean;
            grid-column-end: mean;
            grid-row-start: mean;
            grid-row-end: mean;
            align-self: center;
            justify-self: center;
        }

        .addImage {
            grid-column-start: image;
            grid-column-end: image;
            grid-row-start: image;
            grid-row-end: image;
            align-self: center;
            justify-self: center;

        }

        .dates-na {
            grid-column-start: date;
            grid-column-end: date;
            grid-row-start: date;
            grid-row-end: date;
            align-self: center;
            justify-self: center;

            display: block;
        }

        .date-item {
            margin: 40px 0;
        }

        #dd1 {
            padding-right: 13px;
        }

        #d1,
        #d2 {
            padding: 5px;
            width: 200px;
            border-radius: 10px;
            border: 1px solid rgb(199, 177, 177);
        }

        #dd2 {
            padding-right: 30px;


        }

        label {
            font-weight: bold;
            font-size: 18px;
        }

        textarea {
            background-color: rgb(255, 245, 245);
            border: 1px solid rgb(199, 177, 177);
            border-radius: 10px;
        }
        a{
            color: black !important;
        }
       
    </style>
    <div class="header">
        <header id="header">
            <div class="container">
                <nav id="nav-menu-container">
                    <ul class="nav-menu">
                        <li class="menu-active"> <a href="#hero" style="color: gray;font-size: 23px;"><strong>TIEMPO</strong> MAYA</a></li>
                        <li><a href="#">Linea del Tiempo</a></li>
                        <li><a href="#">Calendario Haab</a></li>
                        <li><a href="#">Calendario Cholquij</a></li>
                        <li><a href="ruedaCalendarica.php">Rueda calendarica</a></li>
                        <li><a href="nahuales.php">Nahuales</a></li>
            
                        <li><a href="#">Cerrar Sesion</a></li>
                    </ul>
                </nav>
            </div>
        </header>
    </div>
    <br><br><br><br>
    <form enctype="multipart/form-data" action="editNa.php" class="form-content" method="post">
        <input type="hidden" name="MAX_FILE_SIZE" value="1000000">
        <div class="main-container">

            <div class="dates-na">
                <div class="date-item">
                    <label id="dd1" for="d1">Fecha Inicio</label>
                    <input type="date" name="fecha1" value='<?php echo $fechaInicio ?>' id="d1">
                </div>
                <div class="date-item">
                    <label id="dd2" for="d2">Fecha Fin</label>
                    <input type="date" name="fecha2" value='<?php echo $fechaFin ?>' id="d2">
                </div>
                <input type="text" name="name" hidden value="<?php echo $ID ?>" id="">
            </div>
            <div class="description">
                <label for="">Descripcion</label>
                <br>
                <textarea name="description" id="descrip" cols="30" rows="5">
                    <?php echo $descripcion ?>
                </textarea>
            </div>
            <div class="mean">
                <label for="">Significado</label><br>
                <textarea name="mean" id="" cols="30" rows="5">
                <?php echo $significado ?>
                </textarea>
            </div>
            <div class="addImage">
                <label for="img">Agregar Imagen</label>
                <br>
                <input type="file" accept="image/*" name="image" id="img">
                <br><br>
                <input type="submit" value="Modificar">
            </div>
        </div>
    </form>
</body>
<script>
</script>

</html>