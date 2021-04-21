<?php 
$codigo=$_POST['codigo'];
$periodo=$_POST['periodo'];
$inicio=$_POST['init'];
$fin=$_POST['end'];
$AC=$_POST['AC'];
$DC=$_POST['DC'];
$ID=$_POST['id'];

$sql="UPDATE acontecimiento SET htmlCodigo='".$codigo."', Periodo_nombre='".$periodo;
$sql.="',fechaInicio=".$inicio.",fechaFin=".$fin.",ACInicio='".$AC."',ACFin='".$DC."' WHERE id=".$ID.";";

$connection = include '../conexion/conexion.php';
$connection->query($sql);

header('location: LineaDeTiempo.php');

?>