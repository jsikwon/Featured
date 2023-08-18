<?php
//* Final Homework - Routing

require_once('menu.php');
require_once('../shared/db.php');

$myname=null;
$myemail=null;
$mypassword=null;
if (!empty($_REQUEST['name'])) {
    $myname=$_REQUEST['name'];
}
if (!empty($_REQUEST['email'])) {
    $myemail=$_REQUEST['email'];
}
if (!empty($_REQUEST['password'])) {
    $mypassword=$_REQUEST['password'];
}
$status='';
if (!empty($_REQUEST['status'])) {
    $status = $_REQUEST['status'];
}


if(!empty($_REQUEST['button'])){
    
    $sql = "INSERT INTO admin (name,email,password,status) VALUES (?, ?, ?, ?)";
    $args = [];
    $args[] = $_REQUEST['name'];
    $args[] = $_REQUEST['email'];
    $args[] = $_REQUEST['password'];
    $args[] = $_REQUEST['status'];
    execute($sql,$args);

    echo("<br>Record Entered"); 
        
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
<body class="container">
   
  <h1>Add Admin</h1>    
  <form method="post">
  <div class="form-group">
    <label for="name">Name (letters only)</label>
    <input type="text" class="form-control" id="name" name="name" value="<? echo($myname); ?>" >
  </div><br>
  <div class="form-group">
    <label for="email">Email </label>
    <input type="text" class="form-control" id="email" name="email" value="<? echo($myemail); ?>" >
  </div><br>
  <div class="form-group">
    <label for="password">Password </label>
    <input type="password" class="form-control" id="password" name="password" value="<? echo($mypassword); ?>" >
  </div><br>
  <div class="form-group">
    <label for="status">Status</label>
    <select class="form-control" id="status" name="status">
      <option value=staff <? echo($status=='staff' ? 'selected' : ''); ?> >Staff</option>
      <option value=admin <? echo($status=='admin' ? 'selected' : ''); ?> >Admin</option>
    </select>
  </div><br>
  <div>
  <button value="add" type="submit" name="button" class="btn btn-primary">Submit</button>
  </div>
    </form>
</body>
</html>
