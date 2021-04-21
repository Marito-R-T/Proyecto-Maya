<?php session_start(); ?>
<?php
if (isset($_GET['t']) && isset($_GET['n'])) {
    $table = $_GET['t'];
    $nombre = $_GET['n'];
    $conn = include 'conexion/conexion.php';
    if($nombre=='Calendario Haab' || $nombre=='Calendario Cholquij' || $nombre=='Rueda Calendarica'){
        $sql = $conn->query("SELECT htmlCodigo,categoria  FROM tiempomaya." . $table . " WHERE nombre='Informacion' AND categoria='" . $nombre . "' ;");
    }else{
    $sql = $conn->query("SELECT htmlCodigo,categoria FROM tiempomaya." . $table . " WHERE nombre='" . $nombre . "';");
    }
    if ($sql->num_rows == 1) {
        while ($row = mysqli_fetch_assoc($sql)) {
            $htmlCode = $row['htmlCodigo'];
        }
    }
    $conn->close();
} else {
    header('location: administracion.php');
}

?>


<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Editor</title>
    <script src="ckeditor/ckeditor.js"></script>
    <script src="ckeditor/samples/js/sample.js"></script>
    <link rel="stylesheet" href="ckeditor/samples/css/samples.css">
    <link rel="stylesheet" href="ckeditor/samples/toolbarconfigurator/lib/codemirror/neo.css">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <?php include "blocks/bloquesCss.html" ?>

    <script src="node_modules/file-system/file-system.js"></script>
    <link rel="stylesheet" href="css/estilo.css?v=<?php echo (rand()); ?>" />
</head>

<body id="main" onload="fill();">

    <?php include "NavBarAdmin.php" ?>
    <?php include "backend/verificarSesionAdmin.php"?>

    <section id="inicio">
        <div id="inicioContainer" class="inicio-container">
            <main>
                <div class="adjoined-bottom">
                    <div class="grid-container">
                    <h3><?php echo isset($nombre) ? $nombre : ''; ?> </h3>
                        <div class="">
                            <div id="editor">
                            </div>
                            <form action="backend/editarInformacion.php" method="POST"> 
                                <textarea hidden id="auxiliarData" name="text"><?php echo isset($htmlCode) ? $htmlCode : ''; ?></textarea>
                                <button class="btn btn-get-started" type="submit" onclick="save()">Guardar Cambios <i class="far fa-save"></i></button>
                                <input hidden type="text" name="tabla" value="<?php echo isset($table) ? $table : ''; ?>">
                                <input hidden type="text" name="nombre" value="<?php echo isset($nombre) ? $nombre : ''; ?>">
                                <input hidden type="text" name="categoria" value="<?php echo isset($categoria) ? $categoria : ''; ?>">
                            </form>
                            <input type="text" hidden id='pivot'>
                            <form action="editarFotos.php" method="POST"> 
                                <button class="btn btn-get-started" type="submit" >Subir Fotos <i class="far fa-save"></i></button>
                                <input hidden type="text" name="nombre" value="<?php echo isset($nombre) ? $nombre : ''; ?>">
                                <input hidden type="text" name="admin" value="1">
                            </form>
                        </div>
                    </div>
                </div>
            </main>
        </div>
    </section>

    <script>
        initSample();
    </script>

    <script>

        var array;

        function fill(){
            var htmlObject = document.createElement('body');
            htmlObject.innerHTML = document.getElementById('auxiliarData').value;
            CKEDITOR.instances.editor.setData(htmlObject.innerHTML); 
            document.getElementById('auxiliarData').val = "";
        }

        function save() {
            var data = CKEDITOR.instances.editor.getData();
            $('#auxiliarData').val(data);
        }

        function verify(data, name) {
            var dataCK = CKEDITOR.instances.editor.getData();
            var htmlObject = document.createElement('body');
            htmlObject.innerHTML = dataCK;
            var img = htmlObject.getElementsByTagName('img');
            array = img;
            for (var i = 0; i < img.length; i++) {
                if (img[i].src.charAt(0) == "b") {
                    img[i].src = data;
                    img[i].width = "300";
                }
            }
            CKEDITOR.instances.editor.setData(htmlObject.innerHTML);

        }
    </script>
    <?php include 'blocks/bloquesJs.html' ?>

    <!--
Copyright (c) 2003-2021, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.md or https://ckeditor.com/legal/ckeditor-oss-license
-->
</body>

</html>