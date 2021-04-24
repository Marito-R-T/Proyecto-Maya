<?php
$url = "../administracion.php?";
$categoria = $_POST['categoria'];
$connection = include '../conexion/conexion.php';
$sql = "DELETE FROM  tiempomaya.imagen WHERE categoria='" . $categoria . "';";


if ($connection->query($sql)) {
    
    $texto = $_POST['imgs'];
    try{
        $imagenes = explode(",", $texto);
    }catch(Exception $ex){
        $imagenes = mb_split(",", $texto);
    }
    $i = 0;
    $stringInsert = "INSERT INTO tiempomaya.imagen (nombre , categoria,descripcion, data) VALUES ";
    while ($i < sizeof($imagenes)) {
        $stringInsert .= "('". $imagenes[$i+2] . "','" . $categoria . "','" . $imagenes[$i] ."','". $imagenes[$i + 1] . "'),";
        $i += 3;
    }
    
    $stringInsert = substr($stringInsert, 0, -1);
    $stringInsert .= ";";
   
    if($connection->query($stringInsert)){
        $mensaje = "mensaje=Informacion actualizada con exito";

    }else{
        $mensaje = "mensaje='No se pudo actualizar las fotos'";
    }
    
} else {
    $mensaje = "mensaje='No se pudo actualizar la informacion'";
}

$connection->close();
header('location: ' . $url . $mensaje);
?>