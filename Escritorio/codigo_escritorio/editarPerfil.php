<?php
    session_start();        
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
    if (isset($_SESSION['userName'])) { //mostramos el nombre del usuario
        $userNamer1 = $_SESSION['userName'];
        $result = mysqli_query($conn, "SELECT * FROM usuario WHERE username = '".$userNamer1."' ");
      
        // Verificando si el usuario existe en la base de datos.
        if(mysqli_num_rows($result )>0){
          $usuario =  $result->fetch_array(MYSQLI_ASSOC);
         }else{
          // Si no está logueado cerrar sesion por precaucion
          header("Location: ../cerrarSesion.php"); 
          header("Location: ../index.php"); 
        }
    }else{//no mostramos nada
        header("Location: ../index.php"); 
    }

?>

<!DOCTYPE html>
<html lang="es" dir="ltr">
  <head>
    <title>Editar Perfil </title>
    <meta charset="UTF-8">
    <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Poppins:300,400,500,700" rel="stylesheet">
    <script src="./archivoJS/mostrarPass.js"></script>

  </head>
  <body style="  background: url('./img/fondo.png');">

    <div class="container" >
    <div style="overflow : auto; ">
                <br></br>
      <h1><font color="white"><p align="center"><strong><a style="background:DarkBlue">Actualizar Datos : <?php echo $usuario['nombre'] ?> <?php echo $usuario['apellido'] ?></a></strong></p></font> </h1>
      <br></br>
      <form action="./backend/actualizarPerfil.php" method="post" >
        <input type="hidden" name="oldUserName"  value="<?php echo $usuario['username'] ?>">
        <b> <font color ="gold"><p align="center">USERNAME : </p></font></b>
        <input class="form-control" type="text" name="user" value="<?php echo $usuario['username'] ?>" required>

        <b> <font color ="gold"><p align="center">CORREO: </p></font></b>
        <input class="form-control" type="email" name="correo" value="<?php echo $usuario['email'] ?>" required>

        <b> <font color ="gold"><p align="center">PASSWORD: </p></font></b>
        <input class="form-control" type="password" name="pass1" id="pass" value="<?php echo $usuario['password'] ?>" required>
        <input href="#" type="button" id="passB" onclick="mostrarPass()" value="Pass" required>

        <b> <font color ="gold"><p align="center">NOMBRE:</p> </font></b>
        <input class="form-control" type="text" name="nombre" value="<?php echo $usuario['nombre'] ?>" required>

        <b> <font color ="gold"><p align="center">APELLIDO:</p> </font></b>
        <input class="form-control" type="text" name="apellido" value="<?php echo $usuario['apellido'] ?>" required>

        <b>  <font color ="gold"> <p align="center"> FECHA NACIMIENTO  : </p></font></b>
        <input class="form-control" type="date" name="nacimiento" value="<?php echo $usuario['nacimiento'] ?>" required>

        <b> <font color ="gold"> <p align="center"> TELEFONO : </p></font></b>
        <input class="form-control" type="number" name="telefono" value="<?php echo $usuario['telefono'] ?>" required>

        <br></br>
        <input type="submit" value="ACTUALIZAR DATOS" style="background-color:orange;">
        <br></br>
        </form>

        <form action="./perfil.php" >
        <input type="submit" value="  REGRESAR  " class="btn btn-sm btn-warning">
        </form>
        <br></br>

    </div>
    </div>
  </body>
</html>
