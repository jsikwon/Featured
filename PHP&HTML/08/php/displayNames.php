<?php

require_once('../../shared/db.php');

$results = execute('SELECT * FROM names ORDER BY name');

if (empty($results)) {
    $val['masterstatus'] = 'error';
    $val['msg'] = 'No data available';
} else {
    $ar = array_column($results, 'name');
    $nameStr = implode('<br>', $ar);
    

    $val['names'] = $nameStr;

}
echo(json_encode($val));




