<?php
// Obtengo los datos cargados en el formulario de login.
$conn = include '../conexion/conexion.php';
$password_decoded = hash("sha256", $password);
$url = '../index.php';
$user = $conn->query("SELECT * FROM tiempomaya.admin WHERE correo='" . $_SESSION['admin'] . "';");
if ($user->num_rows == 1) {

  while ($row = mysqli_fetch_assoc($user)) {
    if ($password_decoded == $row['password']) {
        $_SESSION['edit'] = 'true';
      $mensaje = "?mensaje=Inicio de Administracion exitoso";
      $url = '../administracion.php';
    }else{
      $mensaje="?mensaje=Contraseña incorrecta";
    }
  }
}
$conn->close();
$url = $url . $mensaje;
header('location: ' . $url);
?>