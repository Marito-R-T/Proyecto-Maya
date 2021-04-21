
<?php


$conexion = new mysqli("localhost","newuser","password","calendarioTiempoMaya");
$sql = "SELECT * FROM usuario ";
$sql .= " ORDER BY username";
$resultado = $conexion->query($sql);
$cont = 1;
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
</head>
<body>
    <style>
        .main-container{
            width: 50%;
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
    <div class="main-container" >
        <form method="POST" action="./backend/registrarNuevoUsuario.php">
            <div class="form-group">
                <h1 id="titulo" align="center"><strong><font color= "Chocolate">CREA TU CUENTA</font></strong></h1>
                <h3 id="titulo2" align = "center"><font color= "SandyBrown"><strong>Completamente Gratis!!!</strong></font></h3>
            </div>
            <div class="form-group">
              <label for="InputUser"><strong><font color ="orange"><font size=6>Nombre</font></strong></label>
              <input type="text" name="nombre" class="form-control" id="InputUser" required aria-describedby="emailHelp">
            </div>
            <div class="form-group">
              <label for="InputUser"><strong><font color ="orange"><font size=6>Apellido</font></strong></label>
              <input type="text" name="apellido" class="form-control" id="InputUser" required aria-describedby="emailHelp">
            </div>
            <div class="form-group">
              <label for="InputUser"><strong><font color ="orange"><font size=6>Usuario</font></strong></label>
              <input type="text" name="usuario" class="form-control" id="InputUser" required aria-describedby="emailHelp">
            </div>
            <div class="form-group">
              <label for="InputUser"><strong><font color ="orange"><font size=6>Correo</font></strong></label>
              <input type="text" name="correo" class="form-control" id="InputUser" required aria-describedby="emailHelp">
            </div>
            <div class="form-group">
              <label for="InputPass"><b><font size=6>Contraseña</font></b></label>
              <input type="password" name="password" class="form-control" required id="InputPass">
            </div>
            <div class="form-group">
              <label for="InputPass"><b><font size=6>Fecha nacimiento</font></b></label>
              <input type="date" name="nacimiento" class="form-control" required id="InputPass">
            </div>
            <div class="form-group">
              <label for="InputPass"><b><font size=6>Telefono</font></b></label>
              <input type="number" name="telefono" class="form-control" required id="InputPass">
            </div>
            <button type="submit" class="btn btn-primary">Registrarse</button>
          </form>
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




