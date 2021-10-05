<?php
if (isset($_POST['tabla']) && isset($_POST['nombre']) && isset($_POST['text'])
    && $_POST['text']!='') {
    include('../lib/simple_html_dom.php');
    $table = $_POST['tabla'];
    $nombre = $_POST['nombre'];
    $htmlText = $_POST['text'];
    $nameDir = "../imgs/" . $_POST['nombre'];
    $html = str_get_html($htmlText);
    $i = 0;
    if (file_exists($nameDir)) {
        deleteDirectory($nameDir);
        mkdir($nameDir);
    }else{
        mkdir($nameDir);
    }
    foreach ($html->find('img') as $element) {
        
        $convertir = $element->src;
        $data = mb_split(',', $convertir);
        $type = mb_split(';', mb_split('/', $data[0])[1])[0];
        $imgBinary = base64_decode($data[1]);
        $imgName = str_replace("../",'',$nameDir) . '/' . $i . "." . $type;
        
        file_put_contents($nameDir. '/' . $i . "." . $type, $imgBinary);
        $element->src = $imgName;
        $i++;
    }
    $html = str_replace("\"","\\\"",$html);

    $conn = include '../conexion/conexion.php';
    if ($_POST['categoria'] == 'Calendario Haab' && $_POST['categoria'] == 'Calendario Cholquij' && $_POST['categoria'] == 'Rueda Calendarica'  ) {
        $sql = "UPDATE tiempomaya." . $table . " SET htmlCodigo=\"" . $html . "\" WHERE nombre='Informacion' and categoria='" . $_POST['categoria'] . "';";
    } else {
        $sql = "UPDATE tiempomaya." . $table . " SET htmlCodigo=\"" . $html . "\" WHERE nombre='" . $nombre . "';";
    }
    if ($conn->query($sql)) {
        $mensaje = "mensaje=Pagina Actualizada correctamente";
    } else {
        $mensaje = "mensaje=La informacion no se pudo actualizar";
    }
    $conn->close();
 header('location: ../administracion.php?'.$mensaje);
} else {
header('location: ../administracion.php?mensaje=Error en actualizar informacion');
}

function deleteDirectory($dir)
{
    if (!$dh = @opendir($dir)) return;
    while (false !== ($current = readdir($dh))) {
        if ($current != '.' && $current != '..') {

            if (!@unlink($dir . '/' . $current))
                deleteDirectory($dir . '/' . $current);
        }
    }
    closedir($dh);
    @rmdir($dir);
}
