<?php
session_start();

$conexion = new mysqli("localhost", "newuser", "password", "calendarioTiempoMaya");

$sql = "CALL mostrarHechos";
$resultado = $conexion->query($sql);
$numfilas = $resultado->num_rows;
echo $numfilas;
$idhecho = -1;
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

<body>
    <div>
        <header id="header" style="background-color: #1C1C1C;">
            <?php include 'BarradeNavegacion.php'; ?>
        </header>
    </div>

    <section>
        <div class="container" style="padding-top: 120px; height:100px">
            <div id="myCarousel" class="carousel" data-ride="carousel">
                <div class="carousel-inner" style="height: 600px; background: url(img/fondo.png);">
                    <?php
                    $num = 0;
                    foreach ($resultado as $hecho) : ?>
                        <?php
                        $sqlCat = "SELECT idHechoHistorico, nombre FROM Categorizar 
                            inner JOIN Categoria ON Categorizar.idCategoria = Categoria.idCategoria
                             WHERE Categorizar.idHechoHistorico= " . $hecho['id'];
                        $cat = $conexion->query($sqlCat);
                        $cat1;
                        foreach ($cat as $categoria1) :
                            $cat1 = $categoria1['nombre'];
                        endforeach;
                        if ($num == 0) {
                            echo '<div class="item active" style="height: 600px;">';
                            $num =  $num + 1;
                        } else {
                            $num = $num + 1;
                            echo '<div class="item " style="height: 600px;">';
                        }

                        ?>
                        <div class="carousel-caption" style=" padding-top: 20px;">
                            <div style="height: 360px;">
                                <img id="imagen<?php echo $num ?>" src="https://img.vixdata.io/pd/jpg-large/es/sites/default/files/imj/7-misterios-de-la-cultura-maya-que-despertaran-tu-curiosidad.jpg" alt="Paisaje-02" class="imagen">
                                <div id="desc<?php echo $num ?>" style="display: none;">
                                    <div class="card" id="transparencia" style=" padding-top: 25%;">
                                        <div class="card-body" style="padding-left: 5%;padding-right:5%">
                                            <h5 class="card-title">Descripcion</h5>
                                            <p class="card-text" style="text-align: justify; "><?php echo $hecho['descripcion'] ?></p>
                                            <form action="editarLineaTiempo.php" method="post">
                                                <input  type="hidden"  name="idHecho" value="<?php echo $hecho['id'] ?>" >
                                                <button type="submit" class="btn btn-primary">Editar</button>
                                            </form>

                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="transparencia">
                                <h1 class='titulo' style="margin-bottom: 10px; color:black"> <?php echo $hecho['titulo']; ?></h1>
                                <p class='fecha' style=""> Fecha: <?php echo date("d/m/Y", strtotime($hecho['fechaInicio'])) ?></p>
                                <button class="btn btn-primary owl-slide-animated owl-slide-cta" style="margin-bottom: 20px; ">
                                    <a class="scrollNavigation" onclick="MostrarDetalles('desc<?php echo $num ?>', 'imagen<?php echo $num ?>');" href="#detalles">Leer Mas</a>
                                </button>
                            </div>
                        </div>
                </div>
            <?php endforeach; ?>
            </div>

            <!-- Controles izquierda-derecha -->
            <a class="left carousel-control" onclick="ocultarDetalles();" href="#myCarousel" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
                <span class="sr-only">Anterior</span>
            </a>
            <a class="right carousel-control" onclick="ocultarDetalles();" href="#myCarousel" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
                <span class="sr-only">Siguiente</span>
            </a>
        </div>

        </div>
    </section>

    <section style="padding-top: 700px;">


    </section>


    <footer id="footer">
        <?php
        if (isset($_SESSION['nombre'])) {
            echo '<div class="container">
            <div class="padre">
                <div style="color: black; padding-left: 5%;">
                    <div class="card-header">
                        Falta un hecho importante?
                    </div>
                    <div>
                        <h5 class="card-title" style="color:black">AGREGA NUEVOS HECHOS HISTORICOS</h5>
                        <button class="btn btn-primary owl-slide-animated owl-slide-cta" style="margin-bottom: 20px; ">
                            <a style="color: black; " class="scrollNavigation" href="insertarLineaTiempo.php">AGREGAR</a>
                        </button>
                    </div>
                </div>
            </div>
        </div>';
        }
        ?>


        <div class="container">
            <div class="copyright">
                &copy; Copyright <strong>Teoria de Sistemas</strong>. Derechos Reservados
            </div>
        </div>
    </footer>

    <script type=" text/javascript">
        var id1;
        var im;

        function MostrarDetalles(id, imag) {
            var desc = document.getElementById(id);
            desc.style.display = "block";
            id1 = id;
            im = imag;
            var imagen = document.getElementById(imag);
            imagen.style.display = "none";
            return true;
        }

        function ocultarDetalles() {
            var desc = document.getElementById(id1);
            desc.style.display = "none";
            var imagen = document.getElementById(im);
            imagen.style.display = "block";
            return true;
        }
    </script>
</body>
</html>
