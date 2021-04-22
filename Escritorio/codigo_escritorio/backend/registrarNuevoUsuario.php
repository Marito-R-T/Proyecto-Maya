<?php 
    session_start();

    $nombreServidor = "localhost";
    $nombreUsuario = "newuser";
    $passwordBaseDeDatos = "password";
    $nombreBaseDeDatos = "calendarioTiempoMaya";
    
    
    // Crear conexión con la base de datos.
    $conexion = new mysqli($nombreServidor, $nombreUsuario, $passwordBaseDeDatos, $nombreBaseDeDatos);
    $nombre = $_POST['nombre'];
    $apellido = $_POST['apellido'];
    $username = $_POST['usuario'];
    $email = $_POST['correo'];
    $password = $_POST['password'];
    $telefono = $_POST['telefono'];
    $nacimiento =  $_POST['nacimiento'];
    $rol =  2;
        $sql = "INSERT INTO usuario VALUES ('".$username."', '".$password."', '".$email."', '".$nombre."', 
        '".$apellido."', '".$nacimiento."', '".$telefono."' , '".$rol."' )";
        if (!$conexion->query($sql)) {
            $ir_a = "./error.php";
            header("location: ".$ir_a);   
            //            echo "Falló CALL: (" . $conexion->errno . ") " . $conexion->error;
        }
        else{
                $ir_a = "../iniciarSesion.php";            
                header("location: ".$ir_a);   
        }

 
?>