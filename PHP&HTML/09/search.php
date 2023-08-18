<?php
$notes = [];
$beginDate = null;
$endingDate = null;
require_once('../shared/db.php');
date_default_timezone_set('America/Detroit');
if (session_status() == PHP_SESSION_NONE) {
    session_start();
}

if (!empty($_REQUEST['begDate']) && !empty($_REQUEST['endDate'])) {
  
  $beginDate = $_REQUEST['begDate'];
  $endingDate = $_REQUEST['endDate'];

  $sql = "SELECT note,saved FROM a9 WHERE saved >= ? and saved <= ?";
  $args = [];
  $args[] = $beginDate;
  $args[] = $endingDate;
  

  $notes = execute($sql, $args);
  
}

//need prepared statement for notes
?>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Display Notes</title>
  </head>
  <body>
    <p>Logged in as user <?php echo($_SESSION['username'])?><p>
            <hr size="1">
            <form method="post">
            <div class="form-group">
              <label for="dateNote">Beginning Date</label><br><br>
              <input type="datetime-local" class="form-control" id="begDate" name="begDate" value="<?=$beginDate?>"><br><br>
            </div>
              <div class="form-group">
              <label for="dateNote">Ending Date</label><br><br>
              <input type="datetime-local" class="form-control" id="endDate" name="endDate" value="<?=$endingDate?>">
            </div><br>
            <div class="form-group">
                <input type="submit" class="btn btn-primary" name="getDate" value="Get Notes" />
            </div><br>
            </form>
        <table border="1" cellpadding="3" cellspacing="0">
        <? foreach ($notes as $note) {  ?>
            <tr>
                <td><?=$note['note']?></td>
                <td><?=$note['saved']?></td>
            </tr>
        <? } ?>
    </table>
  </body>
</html>