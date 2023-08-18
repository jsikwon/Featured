<?php
$fileName= '';
$fileContent = '';
require_once('Directory.php');
$files = new CreateDirectory();
if(!empty($_REQUEST['submitButton'])) {
  $output = $files->addFile();
  $fileList = $files -> scanDirectory();
    if (!empty($_REQUEST['fileName'])) { 
          $fileName = $_REQUEST['fileName'];
      }
    if (!empty($_REQUEST['fileContent'])) { 
        $fileContent = $_REQUEST['fileContent'];
      }
}
$fileList = $files -> scanDirectory();

?>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>File and Directory demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
  </head>
  <body>
    <main class="container">
    <h1>File and Directory Assignment</h1>
    <p>Enter a file name and the contents of a file.<br> File names should contain alpha numeric characters only (No Spaces)</p>
    <form action="index.php" method="post">  
      <div class="form-group">
            <label for="fileName">File Name</label>
            <input type="text" class="form-control" name="fileName" id="fileName" value="<?=$fileName?>">
        </div><br>
        <div class="form-group">
            <label for="FormControlTextarea1" size="5" class="form-label">File Content</label>
            <textarea style="height: 300px;" class="form-control" id="fileContent" name="fileContent"><?=$fileContent?></textarea>
        </div><br>
        <div class="form-group">
          <input type="submit" class="btn btn-primary" name="submitButton" id="submitButton" value="Submit" />
          </form>
        </div>
        <br><h2>Existing Files</h2>
        <p> <? foreach ($fileList as $file) { ?>
           <ul><a target='something' href="files/<?=$file?>"><?=$file?><br></ul>
        <? } ?></p><br>
    </main>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
  </body>
</html>