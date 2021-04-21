<?php
$servername = "127.0.0.1";
$username_DB = "root";
$password_DB = "password";
$dbname = "tiempomaya";

// Create connection
$conn = new mysqli($servername, $username_DB, $password_DB, $dbname, '3306');
if ($conn->connect_error) {
    echo 'Conexion fallida: ' . $conn->connect_error;
    die("Connection failed: " . $conn->connect_error);
} else {
    return $conn;
}
?>
