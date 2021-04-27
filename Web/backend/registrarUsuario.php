<?php

$url = "../sesion/registrarSesion.php";
$mensaje = "";
if (!(isset($_POST['usuario']) || isset($_POST['password']) //Verificacion de los campos
    || isset($_POST['nombre'])
    || isset($_POST['correo'])
    || isset($_POST['apellido'])
    || isset($_POST['passwordConfirm']))) {
    $mensaje = "?mensaje=Los campos no estan llenos revisar";
} else {
    $password = $_POST['password'];
    $passwordConfirm = $_POST['passwordConfirm'];
    if ($password == $passwordConfirm) {
        $username = $_POST['nombre'];
        $lastname = $_POST['apellido'];
        $email = $_POST['correo'];
        $user = $_POST['usuario'];
        $phone_number=NULL;
        $birthday='';
        if (isset($_POST['celular'])) {
            $phone_number = $_POST['celular'];
        }
        if (isset($_POST['fechaNacimiento'])) {
            $birthday = $_POST['fechaNacimiento'];
        }
        $base64 = 'img/perfil.jpg';
        $password_decoded = hash("sha256", $password);
        $connection = include '../conexion/conexion.php';
        $sql = "INSERT INTO tiempomaya.usuario (usuario,nombre, apellido,telefono,password,fechaNacimiento,correo,imagen,id_rol) VALUES('" . $user . "','" . $username . "','" . $lastname . "','" . $phone_number . "','" . $password_decoded . "','" . $birthday . "','" . $email . "','".$base64."',1);";
        if ($connection->query($sql)) {
            $url = "../index.php";
            $mensaje = "?mensaje=Usuario creado con exito";
        } else {
            $sql="SELECT 1 FROM tiempomaya.usuario WHERE correo='".$email."';";
            $mensaje = "?mensaje=No se pudo crear al usuario ";
            if($connection->query($sql)){
                $mensaje.=" correo repetido ";

            }
            $sql="SELECT 1 FROM tiempomaya.usuario WHERE usuario='".$user."';";
            if($connection->query($sql)){
                $mensaje.=" usuario repetido ";
            }
            
        }
        $connection->close();
    }else{
        $mensaje = "?mensaje=Las contraseñas no coinciden";
    }
}
$url = $url . $mensaje;
header('location: ' . $url);
?>