<!DOCTYPE html>
<html lang="en">
<?php

$sql='select * from acontecimiento where id='.$_REQUEST['id'].';';
$connection = include '../conexion/conexion.php';
$acontecimiento_info = $connection->query($sql);
if ($acontecimiento_info->num_rows == 1) {
    $acontecimiento = mysqli_fetch_assoc($acontecimiento_info);
}
?>
<head>
    <meta charset="utf-8">
    <title>Tiempo Maya - Registrarse</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <?php include "../blocks/bloquesCss.html" ?>
    <link rel="stylesheet" href="../css/estilo.css?v=<?php echo (rand()); ?>" />
    <link rel="stylesheet" href="../css/acontecimiento.css?v=<?php echo (rand()); ?>" />

</head>

<body>
    <?php include "NavBar.php" ?>
    <div>
        <section id="inicio">
            <div id="inicioContainer" class="inicio-container">
                <div class="inner">
                <form style="width: 330px;" method="POST" action="./update.php">
                    <input  hidden type="text"  name="id" value="<?php echo $_REQUEST['id'] ?>">
                    <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Descripcion</label>
                    <input type="text" name="codigo" value="<?php echo $acontecimiento['htmlCodigo'] ?>" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                    </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Periodo</label>
                    <select name="periodo" id="">
                        <option selected="selected" value="<?php echo $acontecimiento['Periodo_nombre']?>"></option>
                        <option value="PreClasico">PreClasico</option>
                        <option value="PosClasico">PosClasico</option>
                        <option value="Clasico">Clasico</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Año Inicio</label>
                    <input type="number" name="init" class="form-control" id="exampleInputEmail1" value="<?php echo $acontecimiento['fechaInicio'] ?>" aria-describedby="emailHelp">
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Decada</label>
                    <select name="AC" id="">
                        <option selected="selected" value="<?php echo $acontecimiento['ACInicio']?>"></option>
                        <option value="AC">Antes de cristo</option>
                        <option value="DC">Despues de cristo</option>
                    </select>
                </div>
                <div class="mb-2">
                    <label for="exampleInputEmail1" class="form-label">Año Fin</label>
                    <input name="end" type="number" class="form-control " value="<?php echo $acontecimiento['fechaFin'] ?>" id="exampleInputEmail1" aria-describedby="emailHelp">
                </div>
                <div class="mb-2">
                    <label for="exampleInputPassword1" class="form-label">Decada</label>
                    <select name="DC" id="">
                        <option selected="selected" value="<?php echo $acontecimiento['ACFin']?>"></option>
                        <option value="AC">Antes de cristo</option>
                        <option value="DC">Despues de cristo</option>
                    </select>
                </div>
                
               
                <button type="submit" class="btn btn-primary">Actualizar</button>
                </form>

                </div>
            </div>
        </section>
    </div>
    <?php include "../blocks/bloquesJs.html" ?>
</body>

</html>