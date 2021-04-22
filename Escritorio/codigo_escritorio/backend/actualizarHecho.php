<?php
session_start();
$ir_a = "../LineaDeTiempo.php"; 
//$conexion = new mysqli("servidor","usuario","clave","bd")
$conexion = new mysqli("localhost", "administrador", "Admin.123321", "LineaTiempo");
$miImagen = base64_encode(file_get_contents($_FILES['imagen']['tmp_name']));
if ($conexion->connect_error) {
    die("Connection failed: " . $conexion->connect_error);
}

//guarda hecho historico
$sql1 = "UPDATE HechoHistorico SET fechaInicio = '".$_POST['fechaInicio'] ."', fechaFinal= '". $_POST['fechaFin']."', titulo= '".$_POST['titulo'] ."', descripcion= '" . $_POST['decripcion'] . "'" ;
    if (!$conexion->query($sql1)) {
        echo "Falló 2: (" . $conexion->errno . ") " . $conexion->error;
    }

$id = $_POST['idHecho'];

//guarda la edicion del hecho historico
$sql3 = "INSERT INTO Edicion (username, idHechoHistorico, fecha, creacion) VALUES ('" .$_SESSION['nombre']. "' , " . $id['id'] . ",
'". date("Y-m-d"). "', '1')";
if (!$conexion->query($sql3)) {
    $ir_a = "../error.php";
    echo "Falló 3: (" . $conexion->errno . ") " . $conexion->error;
}else{
    header("location: ".$ir_a);
}




?>