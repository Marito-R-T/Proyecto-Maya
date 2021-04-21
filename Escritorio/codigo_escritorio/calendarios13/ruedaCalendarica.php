<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Poppins:300,400,500,700" rel="stylesheet">
    <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="lib/animate/animate.min.css" rel="stylesheet">
    <link href="style.css" rel="stylesheet">
    <title>Rueda calendarica</title>
</head>

<body>
    <style>
        .content-wheel {
            display: grid;
            grid-template-columns: 1fr 1fr 1fr;
            grid-template-rows: 120px 1fr auto;
            grid-gap: 20px;
            grid-template-areas: "navbar navbar navbar"
                "mainText mainText image"
                "textExtra textExtra textExtra ";
            background-color: rgb(42, 42, 99);
            height: 100%;
            width: 100%;
            margin: auto;

        }

        .image-container {
            grid-column-start: image;
            grid-column-end: image;
            border: 1px solid gray;
            margin-right: 10px;
            background-color: rgb(219, 219, 224);
        }

        .image-container img {
            width: 100%;
            height: 100%;
        }

        .main-container {
            padding: 10px 20px;
            grid-column-start: mainText;
            grid-column-end: mainText;
            grid-row-start: mainText;
            grid-row-end: mainText;
            text-align: justify;
        }

        .tst {

            grid-column-start: textExtra;
            grid-column-end: textExtra;
            text-align: justify;
            padding: 15px 35px;

        }

        .header {
            grid-column-start: navbar;
            grid-column-end: navbar;
            grid-row-start: navbar;
            grid-row-end: navbar;
        }

        .nav-menu>li>a {
            color: rgb(196, 196, 199);
        }

        body {
            background-color: rgb(42, 42, 99);
        }

        @media screen and (max-width: 700px) {
            .content-wheel {
                grid-template-areas:
                    "navbar navbar navbar"
                    "image image image"
                    "mainText mainText mainText"
                    "textExtra textExtra textExtra";
            }
        }
    </style>

    <div class="content-wheel">
        <div class="header">
            <header id="header">
                <div class="container">
                    <nav id="nav-menu-container">
                        <ul class="nav-menu">
                            <li class="menu-active"> <a href="#hero" style="color: gray;font-size: 23px;"><strong>TIEMPO</strong> MAYA</a></li>
                            <li><a href="#">Linea del Tiempo</a></li>
                            <li><a href="#">Calendario Haab</a></li>
                            <li><a href="#">Calendario Cholquij</a></li>
                            <li><a href="#">Rueda Calendarica</a></li>
                            <li><a href="nahuales.php">Nahuales</a></li>
                            <li><a href="#">Cerrar Sesion</a></li>
                        </ul>
                    </nav>
                </div>
            </header>
        </div>
        <div class="main-container">
            <p style="color: white;">
            Aunque el tzolk’in ritual y el haab profano eran calendarios independientes 
            entre sí, los mayas los fundieron en un ciclo superior que se conoce 
            técnicamente con el nombre de “rueda calendárica”. Entonces, sólo 
            cada 18.980 días coincide uno de los 260 días del tzolk’in con otro 
            de los 365 días del haab. 
            <br>
            La razón aritmética está en el mínimo común múltiplo de ambos ciclos, para cuyo cálculo 
            sólo se tienen en cuenta una sola vez todos los factores de los dos números: 
            260, se resuelve en 13x5x4 y 365 en 73x5 días.
            <br>
            Este ciclo de la rueda calendárica estaba extendido en toda el área centroamericana y constituía una nueva base 
            para los pronósticos del calendario. Según los mayas, el día de la 
            creación del mundo coincidía con la combinación de la rueda calendárica 4 ajaw 8 kumk’u.
            <br>
            El diagrama de la derecha refleja el acoplamiento del calendario ritual tzolk’in con el año ordinario haab, de 365 días. El primero 
            consta de los números del 1 al 13 (rueda A) y de los 20 signos del día (rueda B); el segundo tiene 18 meses de 20 días 
            y un apéndice de 5 días al final del año. Para mayor claridad, 
            no se reproduce la rueda completa, sino sólo el mes keh, de 20 días de duración 
            (rueda C). La conjunción de las tres ruedas indica la fecha. En total, para que 
            una fecha concreta se repita han de pasar 18.980 días o 52 años haab.
            </p>

        </div>
        <div class="image-container">
            <img src="https://mayanpeninsula.com/wp-content/uploads/2019/09/Rueda-calendario-Maya-1024x741.png" alt="No image" srcset="">
        </div>
        <div class="tst">
                <div class="content-date">
                     <label style="color:white">Fecha</label>
                    <input type="date" name="" id="">
                </div>
                <br>
                <div class="ruedas">
                    <label style="color:white">Haab</label>
                    <input type="text" name="" id="">
                    <br><br>
                    <label style="color:white">Tzolkin</label>
                    <input type="text" name="" id="">
                </div>
           </div>
        </div>


    </div>
    <script src="lib/jquery/jquery.min.js"></script>
    <script src="lib/jquery/jquery-migrate.min.js"></script>
    <script src="lib/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/wow/wow.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/counterup/counterup.min.js"></script>
    <script src="lib/superfish/hoverIntent.js"></script>
    <script src="lib/superfish/superfish.min.js"></script>


</body>

</html>