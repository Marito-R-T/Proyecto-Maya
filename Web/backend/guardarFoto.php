<?php 
$url = "../perfil.php?";
if (!(isset($_POST['path']))) {
    $mensaje = $mensaje . "'No hay cambios que guardar'";
} else {
    $connection = include '../conexion/conexion.php';
    $sql = "UPDATE tiempomaya.usuario SET imagen='".$_POST['path']."' WHERE correo='".$_POST['correo']."';";
    if ($connection->query($sql)) {
        $mensaje = "mensaje='Foto actualizada con exito'";
    } else {
        $mensaje = "mensaje='No se pudieron actualizar la fotos'";
    }
    $connection->close();
}
header('location: '.$url.$mensaje);
?>