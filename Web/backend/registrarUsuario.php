<?php

$url = "../sesion/registrarSesion.php";
$mensaje = "?mensaje=";
if (!(isset($_POST['usuario']) || isset($_POST['password']) //Verificacion de los campos
    || isset($_POST['nombre'])
    || isset($_POST['correo'])
    || isset($_POST['apellido'])
    || isset($_POST['passwordConfirm']))) {
    $mensaje = $mensaje . "'Los campos no estan llenos revisar'";
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
         $path = '../img/perfil.jpg';
        $type = pathinfo($path, PATHINFO_EXTENSION);
        $data = file_get_contents($path);
        $base64 = 'data:image/' . $type . ';base64,' . base64_encode($data);
        $password_decoded = hash("sha256", $password);
        $connection = include '../conexion/conexion.php';
        $sql = "INSERT INTO tiempomaya.usuario (usuario,nombre, apellido,celular,password,fechaNacimiento,correo,imagen) VALUES('" . $user . "','" . $username . "','" . $lastname . "','" . $phone_number . "','" . $password_decoded . "','" . $birthday . "','" . $email . "','".$base64."');";
        if ($connection->query($sql)) {
            $url = "../index.php?";
            $mensaje = "mensaje='Usuario creado con exito'";
        } else {
            $mensaje = $mensaje . "'No se pudo crear al usuario  Usuario o Correo repetidos'";
        }
        $connection->close();
    }
}
$url = $url . $mensaje;
header('location: ' . $url);
?>