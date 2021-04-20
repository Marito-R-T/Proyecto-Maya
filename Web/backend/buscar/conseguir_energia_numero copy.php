<?php
$for = mktime(0, 0, 0, 1, 1, 1720) / (24 * 60 * 60);
$fech = date("U", strtotime($fecha)) / (24 * 60 * 60);
$idd = $fech - $for;
$nn = $idd % 13;
if($nn<0){
	$nn=12+$nn;
}
if($nn==12){
	echo "Energia ".strval(1);
}else{
	echo "Energia ".strval ($nn+2);
}?>
