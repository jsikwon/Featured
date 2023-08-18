<?php

require_once('../../shared/db.php');

$val['msg'] = 'All names cleared';

$sql = "DELETE FROM names WHERE 1=1";
$results = execute($sql); 

echo(json_encode($val));

