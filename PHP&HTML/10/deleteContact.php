<?php
//* Final Homework - Routing

require_once('menu.php');

require_once('../shared/db.php');
$results = execute('select * from contact');
if (!empty($_REQUEST['idsToDelete'])) {
    $questionMarks = [];
    $keys = [];
    foreach ($_REQUEST['idsToDelete'] as $key=>$value) {
        $questionMarks[] = '?';
        $keys[] = $key;
    }
    $sql = 'delete from contact where contact_id IN (' . implode(',',$questionMarks) . ')';
    //echo($sql . '<br>');
    //print_r($keys);
    execute($sql,$keys);
    header("Location: index.php?page=delectContact"); 
}


?>



<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Final Project</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  </head>
  <body class = "container">
    <h1>Delete Contact</h1>
    <form method="post">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">NAME</th>
                <th scope="col">ADDRESS</th>
                <th scope="col">CITY</th>
                <th scope="col">PHONE</th>
                <th scope="col">STATE</th>
                <th scope="col">DOB</th>
                <th scope="col">EMAIL</th>
                <th scope="col">CONTACT</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <? foreach ($results as $result) { ?>

                <tr>
                    <td><?=$result['name']?></td>
                    <td><?=$result['address']?></td>
                    <td><?=$result['city']?></td>
                    <td><?=$result['phone']?></td>
                    <td><?=$result['state']?></td>
                    <td><?=$result['dob']?></td>
                    <td><?=$result['email']?></td>
                    <td><?=$result['contact']?></td>
                    <td><input type="checkbox" name="idsToDelete[<?=$result['contact_id']?>]"></td>
                </tr>

            <? } ?>
            </tbody>    
        </table>
        <br>
        <input onclick="return confirm('Are you sure you want to delete?')" type="submit" value="Delete checked items" name="b" class="btn btn-primary">
    </form>
</html>