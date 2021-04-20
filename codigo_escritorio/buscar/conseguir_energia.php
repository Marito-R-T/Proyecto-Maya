<?php
	$for = mktime(0, 0, 0, 1, 1, 1720)/(24*60*60);
	$fech = date("U", strtotime($_POST['date']))/(24*60*60);
	$idd = $fech-$for;
	$nn = $idd % 13;
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
