<?php
	$formato = mktime(0, 0, 0, 1, 1, 1720)/(24*60*60);
	$fecha = date("U", strtotime($_POST['date']))/(24*60*60);
	$id = $fecha-$formato;
	$nahual = $id % 20;
  $query = "SELECT * FROM nahual WHERE idNahual = "; // Este $query esta en la pagina anterior, para ser utilizada y ejecutada;
  switch ($nahual){
		case 0:;
      $query = $query . "0"; // suponiendo que el id del IX es 0
			break;
		case 1: case -19:
      $query = $query . "1"; // suponiendo que el id del TZIKIN es 1
			break;
		case 2: case -18:
      $query = $query . "2"; // suponiendo que el id del AJMAQ es 2
			break;
		case 3: case -17:
      $query = $query . "3"; // suponiendo que el id del NOJ es 3
			break;
		case 4: case -16:
      $query = $query . "4"; // suponiendo que el id del TIJAX es 4
			break;
		case 5: case -15:
      $query = $query . "5"; // suponiendo que el id del KAWOK es 5
			break;
		case 6: case -14:
      $query = $query . "6"; // suponiendo que el id del AJPU es 6
			break;
		case 7: case -13:
      $query = $query . "7"; // suponiendo que el id del IMOX es 7
			break;
		case 8: case -12:
      $query = $query . "8"; // suponiendo que el id del IQ es 8
			break;
		case 9: case -11:
      $query = $query . "9"; // suponiendo que el id del AKABAL es 9
			break;
		case 10: case -10:
      $query = $query . "10"; // suponiendo que el id del KAT es 10
			break;
		case 11: case -9:
      $query = $query . "11"; // suponiendo que el id del KAN es 11
			break;
		case 12: case -8:
      $query = $query . "12"; // suponiendo que el id del KEME es 12
			break;
		case 13: case -7:
      $query = $query . "13"; // suponiendo que el id del KIEJ es 13
			break;
		case 14: case -6:
      $query = $query . "14"; // suponiendo que el id del QANIL es 14
			break;
		case 15: case -5:
      $query = $query . "15"; // suponiendo que el id del TOJ es 15
			break;
		case 16: case -4:
      $query = $query . "16"; // suponiendo que el id del TZI es 16
			break;
		case 17: case -3:
      $query = $query . "17"; // suponiendo que el id del BATZ es 17
			break;
		case 18: case -2:
      $query = $query . "18"; // suponiendo que el id del E es 18
			break;
		case 19: case -1:
      $query = $query . "19"; // suponiendo que el id del AJ es 19
			break;
	}
?>
