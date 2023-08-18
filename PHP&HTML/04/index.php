<?php
$textarea = "";

if(!empty($_REQUEST['submitButton'])){
 require_once('Helper.php');
 $helper = new Helper();
 $reversedName = $helper->reverseName($_REQUEST['name']);
 $textarea = $helper->addName($reversedName, $_REQUEST['namelist'] );
}
?>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Add Name Demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  </head>
  <body>
    <main class="container">
      <h1>Add Names</h1><br>
      <form action="index.php" method="POST">
      <div class="form-group"> 
          <input type="submit" class="btn btn-primary" name="submitButton" id="submitButton" value="Add Names" />
          <input type="submit" class="btn btn-primary" name="clearButton" id="clearButton" value="Clear Names" />
        </div>

        <div class="form-group">
          <label for="name">Enter Name</label>
          <input type="text" class="form-control" name="name" id="name" value="">
        </div>

          <div class="form-group">
              <label for="FormControlTextarea1" size="5" class="form-label">List of Names</label>
              <textarea style="height: 500px;" class="form-control" id="namelist" name="namelist" readonly="true"><?php echo ($textarea); ?></textarea>
          </div>
          </form> 
    </main>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
  </body>
</html>
