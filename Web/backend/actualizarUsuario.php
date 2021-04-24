<?php
session_start();
$url = "../perfil/editarPerfil.php";
$mensaje = "?mensaje=";
if (!(isset($_POST['usuario']) //Verificacion de los campos
    || isset($_POST['nombre'])
    || isset($_POST['correo'])
    || isset($_POST['apellido']))) {
    $mensaje = $mensaje . "'Los campos no estan llenos revisar'";
} else {
    $connection = include '../conexion/conexion.php';
   
    $user_info = $connection->query("SELECT * FROM tiempomaya.usuario WHERE correo='" . $_SESSION['correo'] . "';");
    if ($user_info->num_rows == 1) {
        $user_ = mysqli_fetch_assoc($user_info);
        $phone_number = $user_['celular'];
        $birthday = $user_['fechaNacimiento'];
    }
    $username = $_POST['nombre'];
    $lastname = $_POST['apellido'];
    $email = $_POST['correo'];
    $user = $_POST['usuario'];
    if (isset($_POST['celular'])) {
        $phone_number = $_POST['celular'];
    }
    if (isset($_POST['fechaNacimiento'])) {
        $birthday = $_POST['fechaNacimiento'];
    }
    $sql = "UPDATE tiempomaya.usuario SET nombre='".$username. "' , apellido='".$lastname."', correo='".$email."', usuario='".$user."'";
    $sql = $sql.", telefono='".$phone_number."', fechaNacimiento='".$birthday."'";
    if (isset($_POST['password'])) {
        $password_decoded = hash("sha256", $_POST['password']);
        $sql = $sql.", password='".$password_decoded."'";
    }
    $sql= $sql." WHERE (correo='".$_SESSION['correo']."');";
    if ($connection->query($sql)) {
        $url = "../perfil/editarPerfil.php?";
        $mensaje = "mensaje='Informacion modificada con exito'";
    } else {
        $mensaje = $mensaje . "'No se pudo modificar la informacion'";
    }
    $connection->close();
}

$url = $url . $mensaje;
header('location: ' . $url);
