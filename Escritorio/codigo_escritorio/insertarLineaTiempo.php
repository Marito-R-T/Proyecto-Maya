<?php
session_start();
//$conexion = new mysqli("servidor","usuario","clave","bd")
$conexion = new mysqli("localhost", "administrador", "Admin.123321", "LineaTiempo");
$sql = "SELECT * FROM Categoria ";
//$sql .= " ORDER BY nombre";
$categorias = $conexion->query($sql);
$cont = 1;
?>

<!DOCTYPE html>
<html lang="es" dir="ltr">

<head>
    <title>Linea de Tiempo</title>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link href="css/style.css" rel="stylesheet">
    <link href="css/estiloLineaTiempo.css" rel="stylesheet">
</head>

<body style="background: url(./img/fondo.png) top center;color:black">
    <div>
        <header id="header" style="background-color: #1C1C1C;">
            <?php include 'BarradeNavegacion.html'; ?>>
        </header>
    </div>

    <div style="padding-top:200px;">
        <h1 style="text-align: center; color: white;">INSERTAR NUEVO HECHO</h1>
        <div style="margin-left: 20%; margin-right: 20%; margin-top:50px; background-color: rgba(255, 255, 255,0.5); ">
            <div style="padding: 40px; color:black; font-size:20px;">
                <form action="./backend/insertrarHecho.php" method="post">
                    <div class="form-group row">
                        <label for="inputEmail3" class="col-sm-2 col-form-label">Titulo</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="titulo" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="inputEmail3" class="col-sm-2 col-form-label">Fecha Del </label>
                        <div class="col-sm-10">
                            <input type="date" name="fechaInicio" id="FInicio" class="form-control" value="<?php echo date("Y-m-d"); ?>">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="inputEmail3" class="col-sm-2 col-form-label">Al </label>
                        <div class="col-sm-10">
                            <input type="date" name="fechaFin" id="fechaFin" class="form-control" value="<?php echo date("Y-m-d"); ?>">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlTextarea1">Descripcion:</label>
                        <textarea class="form-control" name="decripcion" rows="3" required></textarea>
                    </div>

                    <div class="input-group is-invalid">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="validatedInputGroupSelect" style="color: black;">CATEGORIA: </label>
                        </div>
                        <select class="custom-select" id="validatedInputGroupSelect" required name="categoria">
                            <?php foreach ($categorias as $area) : ?>
                                <option value="<?php echo $area['idCategoria']; ?>"> <?php echo $area['nombre']; ?> </option>
                            <?php endforeach; ?>
                        </select>
                    </div>
                    <!----><div class="input-group" style="padding-top: 40px;">

                        <div class="custom-file">
                            <input type="file" accept=".jpg,.png" class="custom-file-input" id="inputGroupFile04" aria-describedby="inputGroupFileAddon04" name="imagen">
                            <label class="custom-file-label" id="path" for="inputGroupFile04">Elegir Archivo</label>
                        </div>
                    </div> 
                    <button type="submit" class="btn btn-primary mb-2" style="margin-left: 45%; margin-top:30px;">Publicar</button>
                </form>
            </div>
        </div>
    </div>
</body>

</html>

<script>
    document.getElementById('inputGroupFile04').onchange = function() {
        console.log($('#inputGroupFile04').val());
        document.getElementById('path').innerHTML = document.getElementById('inputGroupFile04').files[0].name;

    }
</script>