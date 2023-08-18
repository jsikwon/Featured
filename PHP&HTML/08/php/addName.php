<?php

require_once('../../shared/db.php');

$userInputName = json_decode($_REQUEST['data'],true)['name'];

    $ar = explode(" ", $userInputName);
    $ar = array_reverse($ar);
    $lastNameFirstName = implode(", ", $ar);
    
    if (empty($_REQUEST['data'])) {
        $val['masterstatus'] = 'error';
        $val['msg'] = 'Name must be entered';
    } else {
        $val['masterstatus'] = 'success';
        $val['msg'] = 'Name has been entered into database';
        //$contents = json_decode($_REQUEST['name']);
        
        $sql = "INSERT INTO names (name) Values (?)";
        $args = [];
        $args[] = $lastNameFirstName;
        execute($sql,$args);
    
        $data = json_decode($_REQUEST['data'],true);
        $val['names'] = $data['name'];
    }
    echo(json_encode($val));

   


