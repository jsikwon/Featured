<?php
function myTable(){
  for ($i = 1; $i < 16; $i++){
    echo "<tr>";
    for ($j = 1; $j < 6; $j++){
        echo "<td>"."Row {$i} "."Cell {$j}"."</td>";
      }
    if($i%5==0) {
    echo "</tr>";
    }
  }
}
?>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Exercise 3</title>
  </head>
  <body>
    <table border ="1">
      <?php echo myTable(); ?>
    </table>
    
  </body>
</html>