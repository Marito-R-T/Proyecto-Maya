<?php
	$formato = mktime(0, 0, 0, 1, 1, 1720)/(24*60*60);
	$fecha = date("U", strtotime($_POST['date']))/(24*60*60);
	$id = $fecha-$formato;

	$nahual = $id % 20;
	$nn = $id % 13;


  switch ($nahual){
		case 19:;
      $query = 4; // suponiendo que el id del IX es 0
			break;
		case 0: case -19:
      $query = 5; // suponiendo que el id del TZIKIN es 1
			break;
		case 1: case -18:
      $query = 6; // suponiendo que el id del AJMAQ es 2
			break;
		case 2: case -17:
      $query = 7; // suponiendo que el id del NOJ es 3
			break;
		case 3: case -16:
      $query = 8; // suponiendo que el id del TIJAX es 4
			break;
		case 4: case -15:
      $query = 9; // suponiendo que el id del KAWOK es 5
			break;
		case 5: case -14:
      $query = 10; // suponiendo que el id del AJPU es 6
			break;
		case 6: case -13:
      $query = 11; // suponiendo que el id del IMOX es 7
			break;
		case 7: case -12:
      $query = 12; // suponiendo que el id del IQ es 8
			break;
		case 8: case -11:
      $query = 13; // suponiendo que el id del AKABAL es 9
			break;
		case 9: case -10:
      $query = 14; // suponiendo que el id del KAT es 10
			break;
		case 10: case -9:
      $query = 15; // suponiendo que el id del KAN es 11
			break;
		case 11: case -8:
      $query = 16; // suponiendo que el id del KEME es 12
			break;
		case 12: case -7:
      $query = 17; // suponiendo que el id del KIEJ es 13
			break;
		case 13: case -6:
      $query = 18; // suponiendo que el id del QANIL es 14
			break;
		case 14: case -5:
      $query = 19; // suponiendo que el id del TOJ es 15
			break;
		case 15: case -4:
      $query = 20; // suponiendo que el id del TZI es 16
			break;
		case 16: case -3:
      $query = 1; // suponiendo que el id del BATZ es 17
			break;
		case 17: case -2:
      $query = 2; // suponiendo que el id del E es 18
			break;
		case 18: case -1:
      $query = 3; // suponiendo que el id del AJ es 19
			break;
	}

    switch ($nn){
		case 12:
      $nivel = 1; // la variable $nivel ya esta declarada en la pagina anterior para usarlo
			break;
		case 0: case -12:
      $nivel = 2; // la variable $nivel ya esta declarada en la pagina anterior para usarlo
			break;
		case 1: case -11:
      $nivel = 3; // la variable $nivel ya esta declarada en la pagina anterior para usarlo
			break;
		case 2: case -10:
      $nivel = 4; // la variable $nivel ya esta declarada en la pagina anterior para usarlo
			break;
		case 3: case -9:
      $nivel = 5; // la variable $nivel ya esta declarada en la pagina anterior para usarlo
			break;
		case 4: case -8:
      $nivel = 6; // la variable $nivel ya esta declarada en la pagina anterior para usarlo
			break;
		case 5: case -7:
      $nivel = 7; // la variable $nivel ya esta declarada en la pagina anterior para usarlo
			break;
		case 6: case -6:
      $nivel = 8; // la variable $nivel ya esta declarada en la pagina anterior para usarlo
			break;
		case 7: case -5:
      $nivel = 9; // la variable $nivel ya esta declarada en la pagina anterior para usarlo
			break;
		case 8: case -4:
      $nivel = 10; // la variable $nivel ya esta declarada en la pagina anterior para usarlo
			break;
		case 9: case -3:
      $nivel = 11; // la variable $nivel ya esta declarada en la pagina anterior para usarlo
			break;
		case 10: case -2:
      $nivel = 12; // la variable $nivel ya esta declarada en la pagina anterior para usarlo
			break;
		case 11: case -1:
      $nivel = 13; // la variable $nivel ya esta declarada en la pagina anterior para usarlo
			break;
	}

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
      
      $result = mysqli_query($conn, "SELECT * FROM nahual WHERE id = '".$query."' ");
      // Verificando si el usuario existe en la base de datos.
      if(mysqli_num_rows($result )>0){
        $fila =  $result->fetch_array(MYSQLI_ASSOC);
        $valId=$fila['id'];
        if($valId>10){
            $valId=$valId -10;    
            $val="../imagenesNahuales/Nahual".$valId.".jpg";

        }else{
            $valId=$valId  +10;    
            $val="../imagenesNahuales/Nahual".$valId.".jpg";
        }
        
      }  else{
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
    <title>NAHUAL Y ENERGIA</title>
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
            color:blue;
        }
        body{
        background: url("../img/fondo.png") ;
        background-size: cover;
        }
        .nav-menu > li > a:before {
        background-color: black;
        }
      </style>
  
    <div class="main-container">
         <br>
          <div class="section-header">
            <h3 class="section-title" style="background:white" >Nombre</h3>
         </div>
          <p style="background:LemonChiffon" ><?php echo $fila['nombre'] ?></p>
          <hr>
         <br>
      
       <div class="section-header">
        <h3 class="section-title" style="background:white" >Nivel Energia</h3>
         </div>
          <p style="background:LemonChiffon" ><?php echo $nivel ?>
          </p>
        <hr>
         <br>
      
      <div class="section-header">
        <h3 class="section-title" style="background:white">Imagen Nahual </h3>
      </div>
          <br>
          <img src="<?php echo $val ?>"  width="20%" alt="Imagen del nahual" style="margin-left: 10px;">
<br>
<br>
<form action="../calendarioCholqij.php" method="post">
                    <input type="submit" value="  REGRESAR " class="btn btn-sm btn-warning" style="background:orange">
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