<?php
$fecha1 = new DateTime("01-01-2001");
$fecha2 = new DateTime($_POST['fecha']);
$fecha_actual = strtotime(date("d-m-Y H:i:00", $fecha1->getTimestamp()));
$fecha_entrada = strtotime($_POST['fecha']);
$diff = $fecha1->diff($fecha2);
$dias = $diff->days;
$reversa = false;
if ($fecha_actual > $fecha_entrada) {
    $reversa = true;
}

$number_4 = 0;
if ($dias > 7200) {
    $number_4 = floor($dias / 7200);
    $number_3 = floor(($dias % 7200) / 360);
    $number_2 = floor((($dias % 7200) % 360) / 20);
    $number_1 = (($dias % 7200) % 360) % 20;
} else {
    $number_3 = floor($dias / 360);
    $number_2 = floor(($dias % 360) / 20);
    $number_1 = ($dias % 360) % 20;
}

if ($reversa) {
    $number_1 *= -1;
    $number_2 *= -1;
    $number_3 *= -1;
    $number_4 *= -1;
}

$number1 = 8 + $number_1;
$pivot = 0;
if ($number1 > 19) {
    $number1 = $number1 - 20;
    $pivot = 1;
} elseif ($number1 < 0) {
    $number1 = 20+ $number1;
    $pivot = -1;
}

$number2 = 15 + $number_2 + $pivot; 
$pivot=0;
if ($number2 > 17) {
    $number2 = $number2 - 18;
    $pivot = 1;
} elseif ($number2 < 0) {
    $number2 = 18 + $number2;
    $pivot = -1;
}
$number3 = 7 + $number_3 + $pivot;
$pivot=0;
if ($number3 > 19) {
    $number3 = $number3 - 20;
    $pivot = 1;
} elseif ($number3 < 0) {
    $number3 = 20 + $number3;
    $pivot = -1;
}
$number4 = 19 + $number_4+$pivot;
$pivot=0;
if ($number4 > 19) {
    $number4 = $number4 - 20;
    $pivot = 1;
} elseif ($number4 < 0) {
    $number4 = 20 + $number4;
    $pivot = -1;
}
$number5=12+$pivot;

echo "Fecha Cuenta Larga ".strval($number5).".".strval($number4).".".strval($number3).".".strval($number2).".".strval($number1);

?>