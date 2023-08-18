<?php
$outer = 5;
$inner = 6;

function makeList() {
  global $outer, $inner; 
for ($i = 1; $i < $outer; $i++){
    echo "<li>$i</li>"; 
    for ($j = 1; $j < $inner; $j++){

        $output ="<ul><li>$j</li></ul>";
                echo $output;
    }
  
  }
}

?>


<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Exercise 1</title>
  </head>
  <body>
    <ul><?php echo makeList(); ?></ul>
  </body>
</html>