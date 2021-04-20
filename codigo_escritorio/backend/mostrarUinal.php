<?php
$fecha1= "2001-01-01";
//	$fecha = date("U", strtotime($_POST['date']))/(24*60*60);
    $fecha2=$_POST['date'];

    $diff = (strtotime($fecha1) - strtotime($fecha2));

/*    echo $diff;
    echo "</br> dias ";*/
    $diasTranscurridos = floor($diff / (60*60*24));

    $numHaab=0;
    $iteracion=13;

    $numeroTotalHaab=0;
    $numeroTotalIteracion=0;

    if($diasTranscurridos<0){
        $diasTranscurridos= $diasTranscurridos  *-1;
        $opc2 = floor($diasTranscurridos % 365);

/*        echo " </br>";
        echo $opc2;
        echo "</br>";
        echo "entro como menor </br>";
        */

        $numHaab = $opc2 - 9;
        if ($numHaab < 0) {
            //entonces  acoplamos
            $auxHaab = 20 - $numHaab;

            $numeroTotalHaab=$auxHaab;
            $numeroTotalIteracion= $iteracion;
/*
            echo "</br> acoplamos es menor a 0";
            echo "</br> numero ";
            echo $auxHaab;
            echo "</br> nahual";
            echo $iteracion;*/

        } else {
  /*          echo "</br> no es menor que 0 empieza while";*/

            while ($numHaab >= 0 && $numHaab >= 20) { // para restar debe ser mayor  a 0 y 20  
                //restaremos 20 o 5 depende si la iteracion == 18
                $iteracion++;
                if ($iteracion == 18) {
                    //restamos 5 y comienza la iteracion en 0 porque termina el ciclo tzolquin el 18
                    $iteracion = 0;
                    $numHaab = $numHaab - 5;

                } else {
                    //restamos 20
                    $numHaab = $numHaab - 20;
                }
            }
            //verificar si se puede restar 5 en caso la iteracion haya quedado en 18 y el numero sea mayor a 5
                if ($iteracion == 18 && $numHaab >= 5) {
                    //se hace una iteracion mas
                    $iteracion = 0;
                    $numHaab = $numHaab - 5;
                    /*
                    echo "</br> restamos 5 en el while";
                    echo "</br>";
                    echo $numHaab;
                    echo "</br>";
                    echo $iteracion;
                    */
                    $numeroTotalHaab=$numHaab;
                    $numeroTotalIteracion= $iteracion;
        

                } else {
/*
                    echo "</br> no restamos nada en el while";
                    echo "</br>";
                    echo $numHaab;
                    echo "</br>";
                    echo $iteracion;
*/
                    $numeroTotalHaab=$numHaab;
                    $numeroTotalIteracion= $iteracion;
        
        
                }


        }
    }else{
  /*      echo "entro como mayor </br>";*/

        $opc2 = floor($diasTranscurridos % 365);

            //en caso que no sobrepasa la iteracion va disminuyendo 
            $numHaab = 11-$opc2 ;
            if ($numHaab >= 0) {
                //buscamos en base de datos el nahual haab
 /*               echo "</br>";
                echo $numHaab;
                echo "</br>";
                echo $iteracion;*/

                $numeroTotalHaab=$numHaab;
            $numeroTotalIteracion= $iteracion;

            } else {
                while ($numHaab < 0) { // para restar debe ser mayor  a 0 y 20  
                    //restaremos 20 o 5 depende si la iteracion == 18
                    $iteracion--;
                    if ($iteracion == -1) {
                        //restamos 5 y comienza la iteracion en 0 porque termina el ciclo tzolquin el 18
                        $iteracion = 18;
                        $numHaab = $numHaab + 5;
                    } else {
                        //restamos 20
                        $numHaab = $numHaab + 20;
                    }
                }
                //buscamos en la base de datos el nahual haab
   /*            echo "</br>";
                echo $numHaab;
                echo "</br>";
                echo $iteracion; */

                $numeroTotalHaab=$numHaab;
                $numeroTotalIteracion= $iteracion;
    
    
            }

    }

    $numeroTotalIteracion= $numeroTotalIteracion+1;

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
      
      $result = mysqli_query($conn, "SELECT * FROM winal WHERE id = '".$numeroTotalIteracion."' ");
      // Verificando si el usuario existe en la base de datos.
      if(mysqli_num_rows($result )>0){
        $fila =  $result->fetch_array(MYSQLI_ASSOC);
        $val="../imagenesWinales/".$numeroTotalIteracion.".png";
        
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
            <h3 class="section-title" style="background:white" >Dia y Nombre Winal</h3>
         </div>
         <p style="background:LemonChiffon" ><?php echo $numeroTotalHaab ?></p>
          <p style="background:LemonChiffon" ><?php echo $fila['nombre'] ?></p>
          <hr>
         <br>
      
      
      <div class="section-header">
        <h3 class="section-title" style="background:white">Imagen WINAL </h3>
      </div>
          <br>
          <img src="<?php echo $val ?>"  width="20%" alt="Imagen del nahual" style="margin-left: 10px;">
<br>
<br>
<form action="../CalendarioHaab.php" method="post">
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