<?php
require_once('../shared/db.php');

if (!empty($_FILES['myfile']['name'])) {
    if($_FILES['myfile']['type']!='text/plain') {
        echo("Invalid file type");
    }else{
       
        $results = execute('select * from a7 where file_name = ?', [$_FILES['myfile']['name']]);
    
        if(!empty($results)) {
            echo("File already exists, try a different file");
        } else {
            $contents = file_get_contents($_FILES['myfile']['tmp_name']);
        
            $sql = "INSERT INTO a7 (file_name,contents) Values (?,?)";
            $args = [];
            $args[] = $_FILES['myfile']['name'];
            $args[] = $contents;
            execute($sql,$args);
        }
    }
    

}


$sql = "SELECT file_name,contents FROM a7 ORDER BY file_name";

$results = execute($sql);
?>

<html><div>
    <form enctype="multipart/form-data" method="post">
        <input type="submit" value="Upload File" name="upload" />&nbsp;
        <input type="file" name="myfile" accept=".txt" />
        <br><br>
    </form>
</div>
<html>
    <div>
        <table border="1" cellspacing="0" cellpadding="2">
            <tr>
                <td>File Name</td>
                <td>Contents</td>
            </tr>
            <? foreach ($results as $result) { ?>
            <tr>
                <td><? echo($result['file_name']);  ?></td>
                <td><? echo($result['contents']);  ?></td>
            </tr>
            <? } ?>
        </table>
    </div>
</html>
</html>