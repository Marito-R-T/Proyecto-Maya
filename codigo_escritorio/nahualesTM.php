<?php
  
  // Datos para conectar a la base de datos.
  $nombreServidor = "localhost";
  $nombreUsuario = "newuser";
  $passwordBaseDeDatos = "password";
  $nombreBaseDeDatos = "calendarioTiempoMaya";
  

  // Crear conexión con la base de datos.
  $conn = new mysqli($nombreServidor, $nombreUsuario, $passwordBaseDeDatos, $nombreBaseDeDatos);
  
  // Validar la conexión de base de datos.
  if ($conn ->connect_error) {
    die("Connection failed: ".$conn->connect_error);
  }
  
  $result = mysqli_query($conn, "SELECT * FROM nahual ");

  if(mysqli_num_rows($result )>0){
   }else{
    header("Location: ../index.php"); 
  }
?>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Poppins:300,400,500,700" rel="stylesheet">
    <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="lib/animate/animate.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <title>NAHUALES</title>
</head>
<body>
    <style>
        .main-container{
            width: 35%;
            margin: 100px  auto;
            padding: 20px 20px 60px;
            -webkit-box-shadow: 13px 10px 5px -4px rgba(0,0,0,0.75);
            -moz-box-shadow: 13px 10px 5px -4px rgba(0,0,0,0.75);
            box-shadow: 13px 10px 5px -4px rgba(0,0,0,0.75);
            background: 13px 10px 5px -4px rgba(222, 214, 255, 0.51);
            color:orange;
        }
        body{
        background: url("./img/fondo.png") ;
        background-size: cover;
        }
        .nav-menu > li > a:before {
        background-color: black;
        }
    </style>
    <div>
        <header id="header">
            <?php include 'BarradeNavegacion.php'; ?>
            <br></br>
        </header>
    </div>
    <div class="main-container">
            <div class="form-group">
                <h1 style="text-align: center"><font color ="black"><font size=7>NAHUALES</font></h1>
            </div>
            <?php foreach ($result as $fila) : ?>
            <table class="table table-striped table-sm table-primary">
            <tr >
                <th> NAHUAL : </th>
                <th> VER : </th>
            </tr>
            <tr>
                <td><?php echo $fila['nombre'] ?></td>
                <td> <form action="mostrarNahual.php" method="post">
                    <input type="hidden" name="idN" value="<?php echo $fila['id'] ?>">
                    <input type="submit" value="  VER NAHUAL " class="btn btn-sm btn-warning">
                </form></td>
            </tr>
           </table>
            <?php endforeach; ?>
    </div>
  <script src="lib/jquery/jquery.min.js"></script>
  <script src="lib/jquery/jquery-migrate.min.js"></script>
  <script src="lib/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="lib/easing/easing.min.js"></script>
  <script src="lib/wow/wow.min.js"></script>
  <script src="lib/waypoints/waypoints.min.js"></script>
  <script src="lib/counterup/counterup.min.js"></script>
  <script src="lib/superfish/hoverIntent.js"></script>
  <script src="lib/superfish/superfish.min.js"></script>
</body>
</html>