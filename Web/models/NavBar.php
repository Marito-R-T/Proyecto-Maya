<?php

$conn = include '../conexion/conexion.php';
$uinalesNav = $conn->query("SELECT nombre FROM tiempomaya.uinal order by nombre;");
$nahualesNav = $conn->query("SELECT nombre FROM tiempomaya.nahual order by nombre;");
$energiasNav = $conn->query("SELECT nombre FROM tiempomaya.energia order by id;");
$periodosNav = $conn->query("SELECT nombre FROM tiempomaya.periodo order by orden ;");

?>
<?php include "../mensaje.php"; ?>


<header id="header" style="padding-left: 600px;">
  <div class="container">
    <nav class="navbar navbar-expand-lg" id="nav-menu-container">
      <div class="container-fluid">
        <a id="title" class="navbar-brand" href="../index.php" style="color: white;font-size: 24px;"><strong>TIEMPO</strong> MAYA</a>
        <button class="navbar-toggler" type="button" onclick="rellenar()" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
          <span><i style="color: white;" class="fas fa-bars"></i></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
          <ul class="navbar-nav nav-menu">
            <li>
              <a class="nav-link" href="paginaModelo.php?pagina=Calendario Haab">Calendario Haab &nbsp;&nbsp;&nbsp;&nbsp; </a>
              <button type="button" style="opacity: 0; height: 0;" class="nav-link" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Calendario Haab
              </button>

              <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <li>
                  <button type="button" style="opacity: 0; height: 0;" class="nav-link" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Uinal
                  </button>
                  <a class="nav-link" href="#" style="font-size: 13px;">Uniales </a>
                  <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <div div style="width: 200px; height: 400px; overflow-y: scroll;">
                      <?php foreach ($uinalesNav as $uinal) {
                        echo "<li class='nav-item'><a class='nav-link' href='paginaModeloElemento.php?elemento=uinal#" . $uinal['nombre'] . "'>" . $uinal['nombre'] . "</a></li>";
                      } ?>
                  </ul>
                </li>
              </ul>
            </li>

            <li>
              <a class="nav-link" href="paginaModelo.php?pagina=Calendario Cholquij">Calendario Cholq'ij &nbsp;&nbsp;&nbsp;&nbsp; </a>
              <button type="button" style="opacity: 0; height: 0;" class="nav-link" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Calendario Cholquij
              </button>

              <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <li>
                  <button type="button" style="opacity: 0; height: 0;" class="nav-link" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Nahual
                  </button>
                  <a class="nav-link" href="#" style="font-size: 13px;">Nahuales </a>
                  <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <div div style="width: 200px; height: 400px; overflow-y: scroll;">
                      <?php foreach ($nahualesNav as $nahual) {
                        echo "<li class='nav-item'><a class='nav-link' href='paginaModeloElemento.php?elemento=nahual#" . $nahual['nombre'] . "'>" . $nahual['nombre'] . "</a></li>";
                      } ?>
                    </div>
                  </ul>
                </li>
                <li>
                  <button type="button" style="opacity: 0; height: 0;" class="nav-link" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Energia
                  </button>
                  <a class="nav-link" href="#" style="font-size: 13px;">Energias </a>
                  <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <div div style="width: 200px; height:400px; overflow-y: scroll;">
                      <?php foreach ($energiasNav as $energia) {
                        echo "<li class='nav-item'><a class='nav-link' href='paginaModeloElemento.php?elemento=energia#" . $energia['nombre'] . "'>" . $energia['nombre'] . "</a></li>";
                      } ?>
                    </div>
                  </ul>
                </li>
              </ul>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="paginaModelo.php?pagina=Rueda Calendarica">Rueda Calendarica</a>
            </li>
            <li>
              <a class="nav-link" href="../linea_tiempo/LineaDeTiempo.php">Linea del Tiempo &nbsp;&nbsp;&nbsp;&nbsp; </a>
              <button type="button" style="opacity: 0; height: 0;" class="nav-link" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Linea del Tiempo
              </button>

              <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <?php if (isset($_SESSION['usuario'])) {
                  echo " <li class='nav-item'><a class='nav-link' href='../linea_tiempo/NuevoAcontecimiento.php'>Agregar Nuevo Acontecimiento</a></li>";

                } ?>
                <li>
                  <button type="button" style="opacity: 0; height: 0;" class="nav-link" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Periodos
                  </button>
                  <a class="nav-link" href="#" style="font-size: 13px;">Periodos </a>
                  <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <?php foreach ($periodosNav as $periodo) {
                      echo "<li class='nav-item'><a class='nav-link' href='paginaModeloPeriodo.php?periodo=" . $periodo['nombre'] . "'>" . $periodo['nombre'] . "</a></li>";
                    } ?>
                  </ul>
                </li>

              </ul>
            </li>
            <?php
            if (isset($_SESSION['usuario'])) {
              if (isset($_SESSION['admin'])) {
                echo '<li class="nav-item"><a class="nav-link" href="../administracion.php">Administrar</a></li>';
              }
              echo '<li class="nav-item"><a class="nav-link" href="../perfil/perfil.php">Tu Perfil</a></li>';
              echo '<li class="nav-item"><a class="nav-link" href="../sesion/cerrarSesion.php">Cerrar Sesion</a></li>';
            } else {
              echo '<li class="nav-item"><a class="nav-link" href="../sesion/iniciarSesion.php">Iniciar Sesion</a></li>
            <li class="nav-item"><a class="nav-link" href="../sesion/registrarSesion.php">Registrarse</a></li>';
            }
            ?>
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