<?php session_start(); ?>
<?php
$conn = include 'conexion/conexion.php';

if (isset($_POST['categoria'])) {
    $nombre = $_POST['categoria'];
} elseif (isset($_GET['nombre'])) {
    $nombre = $_GET['nombre'];
}
$imagenes = $conn->query("SELECT * FROM tiempomaya.imagen WHERE categoria='" . $nombre . "';");
$conn->close();

$array = "";
?>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Tiempo Maya - Editar Perfil</title>
    <?php include "blocks/bloquesCss.html" ?>
    <link rel="stylesheet" href="css/estilo.css?v=<?php echo (rand()); ?>" />
    <link rel="stylesheet" href="css/registroSesion.css?v=<?php echo (rand()); ?>" />
    <link rel="stylesheet" href="css/editarPerfil.css?v=<?php echo (rand()); ?>" />
</head>
<?php if (isset($_POST['admin'])){include "NavBarAdmin.php";}else{ include "NavBar.php"; }?>
<?php include "backend/verificarSesion.php"?>

<body onload="updateArray()">
    <section id="inicio">
        <div id="inicioContainer" class="inicio-container">
            <div class="inner">
                <div class="profile " style="width:500px;">
                    <form action="backend/guardarFotos.php" method="POST" style="width: auto;">
                        <div class="avatar-upload" style="max-width: max-content;">
                            <div class="avatar-edit" style="left: 200px;">
                                <input type='file' id="imageUpload" accept=".png, .jpg, .jpeg ,.jfif" />
                            </div>
                            <label class=" btn btn-get-started" for="imageUpload">Subir foto <i class="fas fa-upload"></i></label>
                            <div id='pictures-visualization' style="height: 120px; overflow-y: scroll; float:inline-start;">
                                <?php $i = 0;
                               if (is_array($imagenes) || is_object($imagenes))
                               {
                                foreach ($imagenes as $img) {
                                    $imgString = "<img src=\"" . $img['data'] . "\";  width=\"100\"; height=\"100\";>" .
                                        "<label style=\"color:aliceblue; font-size: 10px;\"> " . $img['nombre'] . "</label>" .
                                        "<button class=\"btn btn-get-started\" onclick=borrar(" . $i . ")>" .
                                        "<i class=\"far fa-trash-alt\"></i> </button> <hr>";
                                    $i++;
                                    $array .= $img['data'] . "," . $img['nombre'] . ",";
                                    echo $imgString;
                                }
                               }
                                ?>
                            </div>
                            <textarea name="imgs" id="imgs" hidden></textarea>
                            <button type="submit" class="btn btn-get-started" onclick="send()" style="width: 260px;">Guardar Fotos
                                <i class="far fa-save"></i>
                            </button>
                            <div>
                                <input type="text" name="auxArray" id="auxArray" hidden value="<?php echo isset($array) ? $array : ''; ?>">
                                <input type="text" name="categoria" hidden value="<?php echo isset($nombre) ? $nombre : ''; ?>">                                                                                         
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>

    <script type="text/javascript">
        var array = [];

        function updateArray() {
            var aux = document.getElementById("auxArray").value;
            let arr = aux.split(',');
            var i = 0;
            while (i < arr.length - 1) {
                array.push([arr[i]+","+arr[i+1], arr[i + 2]]);
                i += 3;
            }
        }

        jQuery(document).ready(function($) {
            function readURL(input) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();
                    var name = input.files[0].name;
                    reader.onload = function(e) {
                        $('#imagePreview').css('background-image', 'url(' + e.target.result + ')');
                        $('#imagePreview').hide();
                        $('#imagePreview').fadeIn(650);
                        array.push([e.target.result, name]);
                        var lista = document.getElementById("pictures-visualization");
                        var text = "";
                        for (var i = 0; i < array.length; i++) {
                            text += "<img src=\"" + array[i][0] + "\"; alt=\"" + array[i][1] + "\"; width=\"100\"; height=\"100\";>" +
                                "<label style=\"color:aliceblue; font-size: 10px;\"> " + array[i][1] + "</label>" +
                                "<button class=\"btn btn-get-started\" onclick=borrar(" + i + ")>" +
                                "<i class=\"far fa-trash-alt\"></i> </button> <hr>";
                        }
                        lista.innerHTML = text;

                    }
                    reader.readAsDataURL(input.files[0]);
                }
            }
            $("#imageUpload").change(function() {
                readURL(this);
            });
        });

        function borrar(i) {
            array.splice(i, 1);
            var lista = document.getElementById("pictures-visualization");
            var text = "";
            for (var i = 0; i < array.length; i++) {
                text += "<img src=\"" + array[i][0] + "\"; alt=\"" + array[i][1] + "\"; width=\"100\"; height=\"100\";>" +
                    "<label style=\"color:aliceblue; font-size: 10px;\"> " + array[i][1] + "</label>" +
                    "<button class=\"btn btn-get-started\" onclick=borrar(" + i + ")>" +
                    "<i class=\"far fa-trash-alt\"></i> </button> <hr>";
            }
            lista.innerHTML = text;
        }

        function send() {
            var arv = array.toString();
            $("#imgs").val(arv);
        }
    </script>
    <?php include "blocks/bloquesJs1.html" ?>
</body>

</html>