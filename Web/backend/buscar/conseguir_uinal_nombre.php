<?php
$fecha1 = new DateTime("1990-04-03");
$fecha2 = new DateTime($fecha_consultar);
$fecha_actual = strtotime(date("d-m-Y H:i:00", $fecha1->getTimestamp()));
$fecha_entrada = strtotime($fecha_consultar);
$diff = $fecha1->diff($fecha2);
$dias = $diff->days;
$reversa = false;
if ($fecha_actual > $fecha_entrada) {
    $reversa = true;
}
if ($reversa) {
    $dias = $dias % 365;
    if ($dias < 360) {
        $mes = 18-ceil($dias / 20);
        $dia = 20-$dias % 20;
    } else {
        $mes = 0;
        $dia = 365-$dias;
    }
} else {
    if ($dias >= 365) {
        $dias = $dias % 365;
    }
    if ($dias > 5) {
        $dias = $dias - 5;
        $diasmes  = $dias+1;
        $mes = ceil($diasmes / 20);
        $dia = $dias % 20;
    } else {
        $mes = 0;
        $dia = $dias % 20;
    }
}


$Query = $conn->query("SELECT nombre FROM uinal WHERE id=".$mes." ;");
$row = mysqli_fetch_assoc($Query);
$uinal = $row['nombre']." ";
return $uinal.strval($dia);

?>
