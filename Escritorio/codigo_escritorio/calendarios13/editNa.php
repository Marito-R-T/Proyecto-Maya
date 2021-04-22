<?php 

$name = $_POST['name'];
$mean = $_POST['mean'];
$decription = $_POST['description'];
$start = $_POST['fecha1'];
$end = $_POST['fecha2'];
$sql = "UPDATE NAHUAL SET significado='".$mean."'";
$sql.= ", descripcion='".$decription."'";
$sql.= ", fechaInicio='".$start."'";
$sql.= ", fechaFin='".$end."' WHERE nombre='".$name."';";
require('./cofigDB.php');
define('USER', $user);
define('PASSWORD', $password);
define('HOST', 'localhost');
define('DATABASE', $db);
try {
    $connection = new PDO("mysql:host=" . HOST . ";dbname=" . DATABASE, USER, PASSWORD);
  } catch (PDOException $e) {
    exit("Error: " . $e->getMessage());
}
$statement = $connection->prepare($sql);
$statement->execute();

if ($_FILES['image']['name']!=null){
    $image_path = "./resources/" . $name . "/";
    $temp = $_FILES['image']['tmp_name'];
    $archivo = $_FILES['image']['name'];
    $path = getPath_($name).$archivo;
    (move_uploaded_file($temp,$path));
}
header("location:editarNahual.php");


function getPath_($name)
{
  return getcwd()."/resources/".$name."/";
}

?>
