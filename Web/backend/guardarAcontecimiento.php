<?php
session_start();
$url = "../index.php";
$mensaje = "?mensaje=";
if (!(isset($_POST['titulo']) || isset($_POST['descripcion']) //Verificacion de los campos
    || isset($_POST['yearI']))) {
    $mensaje = $mensaje . "'Los campos no estan llenos favor de revisar'";
} else {
    $title = $_POST['titulo'];
    $description = $_POST['descripcion'];
    $yearI = $_POST['yearI'];
    if(isset($POST['ACI'])){
        $ACI = "A.C";
    }else{
        $ACI ="D.C";
    }
   
    $yearF = null;
    $ACF = null;
    if ($_POST['yearF'] != '') {
        $yearF = $_POST['yearF'];
        if(isset($POST['ACF'])){
            $ACF = "A.C";
        }else{
            $ACF ="D.C";
        }
    }
    
    $connection = include '../conexion/conexion.php';
    $contribution_number = $connection->query("SELECT count(*) as total  FROM tiempomaya.acontecimiento ;");
    $number_con = mysqli_fetch_assoc($contribution_number);
    $categoria = $title. strval($number_con['total']+1);
    $categorySql = "INSERT INTO tiempomaya.categoria (nombre) VALUES ('".$categoria."');";
    $periodo =calcularPeriodo($yearI,$ACI);
    if ($connection->query($categorySql)) {
        $sql = "INSERT INTO tiempomaya.acontecimiento (autor,titulo, Periodo_nombre,htmlCodigo,categoria,fechaInicio,ACInicio, fechaFin, ACFin) ";
        $sql .= "VALUES('" . $_SESSION['usuario'] . "','" . $title . "','" . $periodo. "','" . $description . "','" . $categoria . "','" . $yearI . "','" . $ACI . "','" . $yearF . "' , ' " . $ACF . "');";
        if ($connection->query($sql)) {
            $url = "../editarFotos.php?nombre=".$categoria;
            $mensaje = "&mensaje=Acontecimiento creado con exito";
        } else {
            $mensaje = $mensaje . "No se pudo crear el acontecimiento";
        }
    } else {
        $mensaje = $mensaje . "Error en crear el acontecimiento";
    }
   
}
$url = $url . $mensaje;
header('location: ' . $url);


function calcularPeriodo($date,$ac){
    if($ac == 'A.C' && intval($date)<= 1500){
        return 'PreClasico';
    }elseif($ac == 'D.C' && intval($date)<= 292){
        return 'PreClasico';
    }elseif($ac == 'D.C' && intval($date)>292 && intval($date) <=900){
        return 'Clasico ';
    }elseif($ac == 'D.C' && intval($date)>900 && intval($date) <=1541){
        return 'PosClasico';
    }
}
?>
