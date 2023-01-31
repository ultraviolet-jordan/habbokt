<?php
@header ('Content-Type: image/png'); 
echo file_get_contents("http://127.0.0.1:8090/?" . $_SERVER['QUERY_STRING']); 
?>
