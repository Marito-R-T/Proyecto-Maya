<?php
//Obtener valores de los datos enviados en post
$name = $_POST['nameNahual'];
$mean = $_POST['meaning'];
$decription = $_POST['description'];
$start = $_POST['startDate'];
$end = $_POST['EndDate'];
//configurar el directorio para la imagen
$image_path = "./resources/" . $name . "/";
$sql = "INSERT INTO NAHUAL (nombre,significado,descripcion,fechaInicio,fechaFin,rutaImagen) VALUES('" . $name . "','" . $mean . "','" . $decription . "','" . $start . "','" . $end . "','" . $image_path . "');";
require('./cofigDB.php');
//configurar base de datos
define('USER', $user);
define('PASSWORD', $password);
define('HOST', 'localhost');
define('DATABASE', $db);
try {
  $connection = new PDO("mysql:host=" . HOST . ";dbname=" . DATABASE, USER, PASSWORD);
} catch (PDOException $e) {
  exit("Error: " . $e->getMessage());
}
//preparar consulta
$statement = $connection->prepare($sql);
$statement->execute();
//obtener el error de codigo 00000=exito
$code=$statement->errorCode();
  if($code==00000 ){
    //crear directorio
    mkdir(("resources/".$name), 0777);
    //añadir imagen
    addImage($name);
}


header("location:agregarNahual.php");
?>


<?php
function addImage($codName)
{
  $temp = $_FILES['image']['tmp_name'];
  $archivo = $_FILES['image']['name'];
  $path = getPath_($codName).$archivo;
  (move_uploaded_file($temp,$path));
}

function getPath_($name)
{
  //obtener ruta absoluta
  return getcwd()."/resources/".$name."/";
}
?>