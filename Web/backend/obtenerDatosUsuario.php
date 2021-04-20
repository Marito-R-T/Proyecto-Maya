<?php
// Obtengo los datos cargados en el formulario de login.
$email = $_SESSION['correo'];
$root = $_SERVER['DOCUMENT_ROOT'] . '/Tiempo_Maya_Web/';
$connection = include $root . 'conexion/conexion.php';
// Consulta segura para evitar inyecciones SQL.
$user_info = $connection->query("SELECT * FROM tiempomaya.usuario WHERE correo='" . $email . "';");
if ($user_info->num_rows == 1) {
  $user = mysqli_fetch_assoc($user_info);
}
$contribution_number = $connection->query("SELECT count(id) as acontecimientos FROM tiempomaya.acontecimiento WHERE autor='" . $_SESSION['usuario'] . "';");
$number_con = mysqli_fetch_assoc($contribution_number);
$number = $number_con['acontecimientos'];
$fecha = $user['fechaNacimiento'];
$nahual = include $root . 'backend/buscar/conseguir_nahual_nombre.php';
$energia = include $root . 'backend/buscar/conseguir_energia_numero.php';
$imagen = $connection->query("SELECT imagen FROM tiempomaya.usuario WHERE correo='" . $email . "' and imagen is not null;");
if ($imagen->num_rows == 1) {
  $img = mysqli_fetch_assoc($imagen);
  $foto = $img['imagen'];
}
$connection->close();
?>