<?php
	$formato = mktime(0, 0, 0, 1, 1, 1720)/(24*60*60);
	$fecha = date("U", strtotime($_POST['date']))/(24*60*60);
	$id = $fecha-$formato;
	$nahual = $id % 20;
	$nn = $id % 13;


  switch ($nahual){
		case 19:;
      $query = "ix"; // suponiendo que el id del IX es 0
			break;
		case 0: case -19:
      $query = "tzikin"; // suponiendo que el id del TZIKIN es 1
			break;
		case 1: case -18:
      $query = "ajmaq"; // suponiendo que el id del AJMAQ es 2
			break;
		case 2: case -17:
      $query = "noj"; // suponiendo que el id del NOJ es 3
			break;
		case 3: case -16:
      $query = "tijax"; // suponiendo que el id del TIJAX es 4
			break;
		case 4: case -15:
      $query = "kawoq"; // suponiendo que el id del KAWOK es 5
			break;
		case 5: case -14:
      $query = "ajpu"; // suponiendo que el id del AJPU es 6
			break;
		case 6: case -13:
      $query = "imox"; // suponiendo que el id del IMOX es 7
			break;
		case 7: case -12:
      $query = "iq"; // suponiendo que el id del IQ es 8
			break;
		case 8: case -11:
      $query = "aqabal"; // suponiendo que el id del AKABAL es 9
			break;
		case 9: case -10:
      $query = "kat"; // suponiendo que el id del KAT es 10
			break;
		case 10: case -9:
      $query = "kan"; // suponiendo que el id del KAN es 11
			break;
		case 11: case -8:
      $query = "kame"; // suponiendo que el id del KEME es 12
			break;
		case 12: case -7:
      $query = "kej"; // suponiendo que el id del KIEJ es 13
			break;
		case 13: case -6:
      $query = "qanil"; // suponiendo que el id del QANIL es 14
			break;
		case 14: case -5:
      $query = "toj"; // suponiendo que el id del TOJ es 15
			break;
		case 15: case -4:
      $query = "tzi"; // suponiendo que el id del TZI es 16
			break;
		case 16: case -3:
      $query = "batz"; // suponiendo que el id del BATZ es 17
			break;
		case 17: case -2:
      $query = "e"; // suponiendo que el id del E es 18
			break;
		case 18: case -1:
      $query = "aj"; // suponiendo que el id del AJ es 19
			break;
	}


  switch ($nn){
		case 12:
      $nivel = 1; // la variable $nivel ya esta declarada en la pagina anterior para usarlo
			break;
		case 0: case -12:
      $nivel = 2; // la variable $nivel ya esta declarada en la pagina anterior para usarlo
			break;
		case 1: case -11:
      $nivel = 3; // la variable $nivel ya esta declarada en la pagina anterior para usarlo
			break;
		case 2: case -10:
      $nivel = 4; // la variable $nivel ya esta declarada en la pagina anterior para usarlo
			break;
		case 3: case -9:
      $nivel = 5; // la variable $nivel ya esta declarada en la pagina anterior para usarlo
			break;
		case 4: case -8:
      $nivel = 6; // la variable $nivel ya esta declarada en la pagina anterior para usarlo
			break;
		case 5: case -7:
      $nivel = 7; // la variable $nivel ya esta declarada en la pagina anterior para usarlo
			break;
		case 6: case -6:
      $nivel = 8; // la variable $nivel ya esta declarada en la pagina anterior para usarlo
			break;
		case 7: case -5:
      $nivel = 9; // la variable $nivel ya esta declarada en la pagina anterior para usarlo
			break;
		case 8: case -4:
      $nivel = 10; // la variable $nivel ya esta declarada en la pagina anterior para usarlo
			break;
		case 9: case -3:
      $nivel = 11; // la variable $nivel ya esta declarada en la pagina anterior para usarlo
			break;
		case 10: case -2:
      $nivel = 12; // la variable $nivel ya esta declarada en la pagina anterior para usarlo
			break;
		case 11: case -1:
      $nivel = 13; // la variable $nivel ya esta declarada en la pagina anterior para usarlo
			break;
	}

?>


