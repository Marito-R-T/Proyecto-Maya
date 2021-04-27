<?php 
$url = "../perfil/perfil.php?";
if (!(isset($_POST['path']))) {
    $mensaje = $mensaje . "'No hay cambios que guardar'";
} else {
    $connection = include '../conexion/conexion.php';
    
    $convertir =$_POST['path'];
    $pos = strpos($convertir, "img/perfil");
    if($pos !== false){
        $imgName=$convertir;
    }else{
        $data = mb_split(',', $convertir);
    $type = mb_split(';', mb_split('/', $data[0])[1])[0];
    $imgBinary = base64_decode($data[1]);
    $imgName = 'img' . '/perfil' .$_POST['usuario']  . "." . $type;
    file_put_contents('../perfil/img/perfil' . $_POST['usuario'] . "." . $type, $imgBinary);
        
    }

    
    $sql = "UPDATE tiempomaya.usuario SET imagen='".$imgName."' WHERE correo='".$_POST['correo']."';";
    if ($connection->query($sql)) {
        $mensaje = "mensaje=Foto actualizada con exito";
    } else {
        $mensaje = "mensaje=No se pudo actualizar la foto de perfil";
    }
    $connection->close();
}
header('location: '.$url.$mensaje);
?>