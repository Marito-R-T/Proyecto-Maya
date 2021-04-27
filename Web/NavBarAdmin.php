<?php

$Admin = "1";
$conn = include 'conexion/conexion.php';
$uinalesNav = $conn->query("SELECT nombre FROM tiempomaya.uinal order by nombre;");
$kinesNav = $conn->query("SELECT nombre FROM tiempomaya.kin order by nombre;");
$nahualesNav = $conn->query("SELECT nombre FROM tiempomaya.nahual order by nombre;");
$energiasNav = $conn->query("SELECT nombre FROM tiempomaya.energia order by id;");
$periodosNav = $conn->query("SELECT nombre FROM tiempomaya.periodo order by orden;");

?>
<?php include "mensaje.php"; ?>

<header id="header">
    <div class="container">
        <nav class="navbar navbar-expand-lg" id="nav-menu-container">
            <div class="container-fluid">
                <a id="title" class="navbar-brand" href="index.php" style="color: white;font-size: 24px;"><strong>TIEMPO</strong> MAYA</a>
                <button class="navbar-toggler" type="button" onclick="rellenar()" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                    <span><i style="color: white;" class="fas fa-bars"></i></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <ul class="navbar-nav nav-menu">

                        <li> <a class="nav-link" href="editarInformacion.php?t=pagina&n=Calendario Haab">Calendario Haab </a>
                            <button type="button" style="opacity: 0; height: 0;" class="nav-link" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Calendario Haab &nbsp;
                            </button>

                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                               <li>
                                <button type="button" style="opacity: 0; height: 0;" class="nav-link" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Kin &nbsp;&nbsp;
                                </button>
                                <a class="nav-link" href="editarInformacion.php?t=pagina&n=Kin" style="font-size: 13px;">Kin </a>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <div div style="width: 200px; height: 400px; overflow-y: scroll;">
                                        <?php if (is_array($kinesNav) || is_object($kinesNav)) {
                                            foreach ($kinesNav as $kin) {
                                                echo "<li class='nav-item'><a class='nav-link' href='editarInformacion.php?t=kin&n=" . $kin['nombre'] . "'>" . $kin['nombre'] . "</a></li>";
                                            }
                                        } ?>
                                    </div>
                                </ul>
                        </li>
                        <li>
                            <button type="button" style="opacity: 0; height: 0;" class="nav-link" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Uinal &nbsp;&nbsp;
                            </button>
                            <a class="nav-link" href="editarInformacion.php?t=pagina&n=Uinal" style="font-size: 13px;">Unial </a>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                <div div style="width: 200px; height: 400px; overflow-y: scroll;">
                                    <?php if (is_array($uinalesNav) || is_object($uinalesNav)) {
                                        foreach ($uinalesNav as $uinal) {
                                            echo "<li class='nav-item'><a class='nav-link' href='editarInformacion.php?t=uinal&n=" . $uinal['nombre'] . "'>" . $uinal['nombre'] . "</a></li>";
                                        }
                                    } ?>
                                </div>
                            </ul>
                        </li>
                    </ul>
                    </li>

                    <li>
                        <a class="nav-link" href="editarInformacion.php?t=pagina&n=Calendario Cholquij">Calendario Cholq'ij </a>
                        <button type="button" style="opacity: 0; height: 0;" class="nav-link" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Calendario Cholquij &nbsp;&nbsp;
                        </button>

                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <li>
                                <button type="button" style="opacity: 0; height: 0;" class="nav-link" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Nahual &nbsp;&nbsp;
                                </button>
                                <a class="nav-link" href="editarInformacion.php?t=pagina&n=Nahual" style="font-size: 13px;">Nahual </a>

                                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <div div style="width: 200px; height: 400px; overflow-y: scroll;">
                                        <?php if (is_array($nahualesNav) || is_object($nahualesNav)) {
                                            foreach ($nahualesNav as $nahual) {
                                                echo "<li class='nav-item'><a class='nav-link' href='editarInformacion.php?t=nahual&n=" . $nahual['nombre'] . "'>" . $nahual['nombre'] . "</a></li>";
                                            }
                                        } ?>
                                    </div>
                                </ul>
                            </li>
                            <li>
                                <button type="button" style="opacity: 0; height: 0;" class="nav-link" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Energia &nbsp;&nbsp;
                                </button>
                                <a class="nav-link" href="editarInformacion.php?t=pagina&n=Energia" style="font-size: 13px;">Energia </a>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <div div style="width: 200px; height:400px; overflow-y: scroll;">
                                        <?php if (is_array($energiasNav) || is_object($energiasNav)) {
                                            foreach ($energiasNav as $energia) {
                                                echo "<li class='nav-item'><a class='nav-link' href='editarInformacion.php?t=energia&n=" . $energia['nombre'] . "'>" . $energia['nombre'] . "</a></li>";
                                            }
                                        } ?>
                                    </div>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="editarInformacion.php?t=pagina&n=Rueda Calendarica"> Rueda Calendarica</a>
                    </li>
                    <li>
                        <a class="nav-link" href="editarInformacion.php?t=pagina&n=Periodos">Periodos </a>
                        <button type="button" style="opacity: 0; height: 0;" class="nav-link" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Periodos &nbsp;&nbsp;
                        </button>

                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <li>
                                <button type="button" style="opacity: 0; height: 0;" class="nav-link" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Periodos &nbsp;&nbsp;
                                </button>
                                <a class="nav-link" href="#" style="font-size: 13px;">Periodos </a>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <?php if (is_array($periodosNav) || is_object($periodosNav)) {
                                        foreach ($periodosNav as $periodo) {
                                            echo "<li class='nav-item'><a class='nav-link' href='editarInformacion.php?t=periodo&n=" . $periodo['nombre'] . "'>" . $periodo['nombre'] . "</a></li>";
                                        }
                                    } ?>
                                </ul>
                            </li>

                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Linea del Tiempo</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="index.php">Regresar</a>
                    </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</header>


<script type="text/javascript">
    var relleno = false;

    function rellenar() {
        if (!relleno) {
            $('#header').addClass('header-fixed1');
            $('#inicioContainer').addClass('iniciofixed');
            relleno = true
        } else {
            relleno = false
            $('#header').removeClass('header-fixed1');
            $('#inicioContainer').removeClass('iniciofixed');
        }
    }
</script>