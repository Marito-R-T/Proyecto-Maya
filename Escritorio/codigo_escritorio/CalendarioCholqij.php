<?php
  if (isset($_POST['date'])) {
    $nivel;
    $query;
    include_once 'buscar/conseguir_nahual.php';
    include_once 'buscar/conseguir_energia.php';
    header("location: CalendarioCholqij.php"."?nahual=".$query."&nivel=".$nivel."#".$query);
}

?>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Tiempo Maya</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Poppins:300,400,500,700" rel="stylesheet">
  <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://kit.fontawesome.com/e51fb510f5.js" crossorigin="anonymous"></script>
<link href="lib/animate/animate.min.css" rel="stylesheet">
  <link href="css/Calendarios.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">


</head>
<?php include "BarradeNavegacion.php" ?>
<body>
<section id="inicio">
<div class="inicio-container">

  <h1>Calendario Cholqij</h1>
    <a href="#information" class="btn-get-started">Descripcion</a>
    <a href="#sabernahual" class="btn-get-started">¿Que nahual cae en esta fecha?</a>
    <a href="nahuales.php" class="btn-get-started">Nahuales</a>
    <a href="#portafolio" class="btn-get-started">Imagenes</a>

</div>

</section>

<section id="information">
  <div class="container">
    <div class="row about-container">

      <div class="col-lg-6 content order-lg-1 order-2">
      <br>
      <div class="section-header">
        <h3 class="section-title">Calendario Cholq'ij</h3>
      </div>
      <br>
      <h3 class="section-title" style="  color: #2dc997;">Informacion</h3>
        <hr>
        <p>
          El Cholq’ij <strong> término maya kaqchikel </strong> es un calendario sagrado del pueblo Maya, compuesto por 260 días divididos en 13 meses.
          También recibe el nombre de calendario ritual o calendario sagrado o Tzolkin
        </p>
        <p>
          Al Cholq’ij también se le denomina <strong>calendario lunar</strong> y marca nueve lunas llenas,
          período en el que se gesta un ser humano.
        </p>
        <p>
          En maya <strong>k’iche’</strong>, los veinte días del Cholq’ij reciben los siguientes
          nombres: <strong>B’atz’, E, Aj, I’x, Tz’ikin, Ajmaq, No’j, Tijax, Kawoq, Ajpu,
          Imox, Iq’, Aq’ab’al, K’at, Kan, Kame, Kej, Q’anil, Toj, Tz’i’</strong>.
        </p>
      </div>

      <div class="col-lg-6 background order-lg-2 order-1 wow fadeInRight">
          <br>
          <img src="img/Cholquij.png"  width="80%" alt="Imagen del calendario habb" style="margin-left: 150px;">
      </div>
    </div>
    <div class="row about-container">
      <div class="col-lg-12">
        <h3 class="section-title" style="  color: #2dc997;">Forma de contar el Cholq'ij</h3>
        <hr>
        <p>Una manera de contar el Cholq’ij para los maya k’iche’ de la actualidad es iniciar el conteo en Waqxaqib’ B’atz’ (8 B’atz’),
          repitiendo así cada 260 días ese número y fecha (Aj Xol Ch’ok, 2008). Cada día del calendario se combina con un numeral que va del 1 al 13,
          hasta completar 260 días. El mismo día en que inicia la cuenta vuelve a repetirse cada 260 días.
          En la antigüedad se acostumbraba a empezar el calendario en 1 Imox y se seguía el mismo proceso
          de multiplicación de los numerales con los días para alcanzar el total de 260 (Aj Xol Ch’ok, 2008).
          La construcción del ciclo de 260 días del calendario Cholq’ij tiene como base la disciplina vigesimal maya (13X20);
          “esta relación organiza una frecuencia matemática del movimiento natural lunar de 13:20 que se determina en base a las gravitaciones, principalmente de la Luna–Tierra,
          las cualidades del ser en la madre Tierra de acuerdo a su día de engendración, día del nacimiento y su proyección o misión en la vida” (García, Curruchiche & Taquirá, 2009, p. 234).
          Los días de este calendario “son representados también en los 10 dedos superiores de las manos,
          más los 10 dedos inferiores de los pies, lo que suma 20, que representa los días del Cholq’ij”,
          pues la construcción matemática del sistema vigesimal maya “se fundamenta en el Jun Winaq de 20 dedos”
        </p>
      </div>
    </div>
    <div class="wow fadeInLeft" style="text-align:center;" >
        <br>
        <img   src="img/contarCholqij.jpg"  width="40%" alt="Imagen de la interaccion del calendario habb y tzolkin" >
    </div>
    <div >
        <h3 class="section-title" style="  color: #2dc997;">La Ciencias y el Cholq´ij</h3>
        <hr>
        <p>
          El Cholq´ij o calendario sagrado fue configurado a partir de la aplicación e interrelación de diferentes ciencias, es decir,
          se explica y se ejercita en base al uso de elementos científicos, algunos de estos elementos son, por ejemplo:
        </p>
        <p>
          <strong>Astronomía:</strong> se identifican períodos de tiempo favorables o adversos para la naturaleza y los seres humanos.
          El Cholq´ij identifica días propicios para la siembra, la maduración de los frutos y la cosecha. El Cholq´ij en sus nawales representa al sol, la luna y las estrellas.
        </p>
        <p>
          <strong>Matemática:</strong> la cuenta del Cholq´ij durante los 260 días integra veintenas y trecenas, por otra parte, cada persona posee energías según la
          sumatoria de su nawal de nacimiento, engendramiento, destino, auxiliares y cargador.
        </p>
        <p>
          <strong>Física:</strong> la influencia recíproca de los seres y cuerpos que ocupan un lugar en el mundo y el espacio, es aplicada en el ejercicio del Cholq´ij, que orienta el respeto a todas las cosas según enseña el pensamiento maya:
        </p>
        <p>
          <strong>Psicología:</strong> en el ejercicio y entendimiento del Cholq´ij se pueden identificar los rasgos básicos, positivos y negativos
          de la personalidad según el nawal de cada quien, de manera que, no se descalifica a nadie, pues todas las personas tienen capacidades y debilidades.
        </p>
    </div>
    <div >
        <h3 class="section-title" style="  color: #2dc997;">El Cholq´ij en la Numeración y Matemática Maya</h3>
        <hr>
        <p>
          La numeración y la matemática maya es vigesimal y tiene como principio filosófico y material el número 20, es un sistema que acumula veintenas y multiplica veintenas.
          Esto, tiene su origen y explicación en otras ciencias, la lingüística y la etimología, en ellas se explican el número 20 así:
          en varios idiomas de origen maya que se hablan en Guatemala, el k´iche´ por ejemplo, para decir veinte se dice JUN WINAQ,
          jun = uno/a winaq = persona, al traducirse al español se dice una persona completa.
        </p>
        <p>
          Esto también tiene una explicación científica, para el caso, físico-anatómico por lo siguiente: los seres humanos tenemos veinte instrumentos naturales para contar,
          cinco dedos en cada una de nuestras manos y cinco dedos en cada uno de nuestro pies que suman veinte en total,
          de manera que cuando decimos Jun Winaq, estamos diciendo una persona “entera” con los veinte dedos de sus manos y pies llamada “Homogenética Maya”
          como decía el sabio anciano Maya Adrian Inés Chávez. Es por eso que el sistema de numeración y matemática maya acumula y multiplica veintenas.
        </p>
    </div>
    <div >
      <h3 class="section-title" style="  color: #2dc997;">Nahuales</h3>
      <hr>
      <ul>
        <li> B'ATZ'</li>
        <li> E</li>
        <li> AJ</li>
        <li> I'X</li>
        <li> TZ'IKIN</li>
        <li> AJMAQ</li>
        <li> NOJ</li>
        <li> TIJAX</li>
        <li> KAWOQ</li>
        <li> AJPU</li>
        <li> IMOX</li>
        <li> IQ'</li>
        <li> AQ'AB'AL</li>
        <li> K'AT</li>
        <li> KAN</li>
        <li> KAME</li>
        <li> KEJ</li>
        <li> Q'ANIL</li>
        <li> TOJ</li>
        <li> TZ'I'</li>
      </ul>
      <p>Estos nahuales tienen <strong>13</strong> niveles de energía, por las 13 articulaciones que tiene el ser humano: </p>
    </div>
    <div class="wow fadeInLeft" style="text-align:center;" >
        <br>
        <img   src="img/articulacionesCholqij.png"  width="40%" alt="Imagen de la interaccion del calendario habb y tzolkin" >
    </div>
  </div>
</section>
<hr>
<section id="sabernahual">
  <div class="container">
    <div class="row about-container">
      <div class="col-lg-12 ">
        <div class="section-header">
          <h3 class="section-title" style="  color: #2dc997;">¿Que nahual caé en esta fecha?</h3>
        </div>
        <div class="container">
          <form method="POST" action="CalendarioCholqij.php">
            <div class="form-group mb-2">
              <label for="staticEmail2" class="sr-only text-dark">Ingresar fecha</label>
              <input type="date" class="form-control-plaintext text-dark border border-success" id="staticEmail2" name="date" required>
            </div>
            <div class="form-group mb-2">
              <button type="submit" class="btn btn-outline-success btn-lg btn-block mb-2">Buscar</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
  <hr>
  <hr>
</section>
<section id="nahuales">
  <div class="container">
    <div class="row about-container">
      <div class="col-lg-12 ">
        <div class="section-header">
          <h3 class="section-title" style="  color: #2dc997;">NAHUALES</h3>
        </div>
        <?php include_once "nahuales.php" ?>
      </div>
    </div>
  </div>
</section>
<section id="portafolio">
  <div class="container wow fadeInUp">
    <div class="section-header">
      <h3 class="section-title">Imagenes</h3>
      <p class="section-description">Distintas imagenes de la representacion del calendario Haab</p>
    </div>
    <div class="row">

      <div class="col-lg-12">
        <ul id="portafolio-flters">
          <li data-filter=".filter-calendario, .filter-dias, .filter-meses" class="filter-active">Todos</li>
          <li data-filter=".filter-calendario" >Calendario</li>
          <li data-filter=".filter-dias">Dias</li>
          <li data-filter=".filter-meses">Meses</li>
        </ul>
      </div>
    </div>

    <div class="row" id="portafolio-wrapper">
      <div class="col-lg-3 col-md-6 portafolio-item filter-calendario">
        <a href="img/calendarioHaabGrande.jpg" target="_blank">
          <img src="img/calendarioHaabGrande.jpg"  width="100%" alt="">
          <div class="details">
            <h4>Calendario</h4>
            <span>Calendario Haab</span>
          </div>
        </a>
      </div>
        <div class="col-lg-3 col-md-6 portafolio-item filter-calendario">
          <a href="img/calendarioTzolkinHaab.jpg" target="_blank">
            <img src="img/calendarioTzolkinHaab.jpg"  width="100%" height=" 100%"alt="">
            <div class="details">
              <h4>Calendario</h4>
              <span>Interaccion entre el Calendario Tzolkin y Haab</span>
            </div>
          </a>
        </div>
        <div class="col-lg-3 col-md-6 portafolio-item filter-calendario">
            <a href="img/CalendarioHaab1.jpg" target="_blank">
            <img src="img/CalendarioHaab1.jpg"  width="150%" alt="">
            <div class="details">
              <h4>Calendario </h4>
              <span>Representacion del calendario Haab en piedra</span>
            </div>
          </a>
        </div>
        <div class="col-lg-3 col-md-6 portafolio-item filter-dias">
          <a href="img/DiasMayas.png" target="_blank">
            <img src="img/DiasMayas.png"  width="150%" alt="">
            <div class="details">
              <h4>Representacion de los dias mayas</h4>
              <span>Calendario Haab</span>
            </div>
          </a>
        </div>
        <div class="col-lg-3 col-md-6 portafolio-item filter-dias">
          <a href="img/DiasMayas1.png" target="_blank">
            <img src="img/DiasMayas1.png"  width="150%" alt="">
            <div class="details">
              <h4>Representacion de los dias mayas</h4>
              <span>Calendario Haab</span>
            </div>
          </a>
        </div>
        <div class="col-lg-3 col-md-6 portafolio-item filter-meses">
          <a href="img/geroglificosUinal.gif" target="_blank">
            <img src="img/geroglificosUinal.gif"  width="100%" alt="">
            <div class="details">
              <h4>Representacion de los meses mayas</h4>
              <span>Calendario Haab</span>
            </div>
          </a>
        </div>
        <div class="col-lg-3 col-md-6 portafolio-item filter-meses">
          <a href="img/JeroglificosUinal.png" target="_blank">
            <img src="img/JeroglificosUinal.png"  width="150%" alt="">
            <div class="details">
              <h4>Representacion de los meses mayas</h4>
              <span>Calendario Haab</span>
            </div>
          </a>
        </div>

  </div>
</section>

<footer id="footer">

  <div class="container">
    <div class="copyright">
      &copy; Copyright <strong>Teoria de Sistemas</strong>. Derechos Reservados
    </div>
  </div>
</footer>
  <script src="lib/jquery/jquery.min.js"></script>
  <script src="lib/jquery/jquery-migrate.min.js"></script>
  <script src="lib/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="lib/easing/easing.min.js"></script>
  <script src="lib/wow/wow.min.js"></script>
  <script src="lib/waypoints/waypoints.min.js"></script>
  <script src="lib/counterup/counterup.min.js"></script>
  <script src="lib/superfish/hoverIntent.js"></script>
  <script src="lib/superfish/superfish.min.js"></script>
  <script src="js/main.js"></script>




</body>
</html>
