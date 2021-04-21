<?php
    session_start();
?>


<header id="header">

    <nav id="nav-menu-container">
      <ul class="nav-menu" >
        <li class="menu-active">  <a href="index.php" style="background:DarkBlue ;font-size: 15px;">TIEMPO  MAYA</a></li>
        <li><a href="nahualesTM.php" style="background:DarkBlue	;font-size: 15px;">Nahuales</a></li>
        <li><a href="calendarioCholqij.php" style="background:DarkBlue;font-size: 15px;">Calendario Cholquij</a></li>
        <li><a href="CalendarioHaab.php" style="background:DarkBlue	;font-size: 15px;">Calendario Haab</a></li>
        <li><a href="#" style="background:DarkBlue	;font-size: 15px;">Rueda Calendarica</a></li>
        <li><a href="LineaDeTiempo.php" style="background:DarkBlue	;font-size: 15px;">Linea del Tiempo</a></li>
        <?php 
        if (isset($_SESSION['nombre'])) {
          echo '<li><a href="perfil.php" style="background:DarkBlue	;font-size: 15px;">Perfil</a></li>';
          echo '<li><a href="cerrarSesion.php" style="background:DarkBlue	;font-size: 15px;">Cerrar Sesion</a></li>';
        }else{
            echo '<li><a href="iniciarSesion.php" style="background:DarkBlue;font-size: 15px;" >Iniciar Sesion</a></li>
            <li><a href="registrarUsuario.php" style="background:DarkBlue	;font-size: 15px;" >Registrarse</a></li>';
          }
        ?>        
      </ul>
    </nav>
</header>
