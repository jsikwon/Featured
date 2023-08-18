<?php

require_once('../shared/db.php');
date_default_timezone_set('America/Detroit');
if (session_status() == PHP_SESSION_NONE) {
    session_start();
}

$myusername=null;
if (!empty($_REQUEST['username'])) {
    $myusername=$_REQUEST['username'];
}

if(!empty($_REQUEST['login'])){ 
        
        $sql = "SELECT user_name, password_hash FROM login WHERE user_name = ? and password_hash = ?";
        $args = [];
        $args[] = $_REQUEST['username'];
        $args[] = md5($_REQUEST['password']);
        $results = execute($sql,$args);
        
        if(empty($results)) {
            echo("You are not logged in");
        } else{
            $_SESSION['username'] = $_REQUEST['username'];
            header('Location: search.php');
        }

}


?>


<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login Page</title>
  </head>
  <body>
    <h3>Please Log In</h3>
    <form method="post">
        <div class="form-input">       
            <input type="text" id="username" class="form-input" name="username" placeholder="User Name" value="<? echo($myusername); ?>">
        </div>
        <br>   
        <div class="form-input">
            <input type="password" id="inputPassword" class="form-input" name="password" placeholder="Password">
        </div>
        <br>    
            <input type="submit" class="btn btn-primary" name="login" value="Log In" />
        </form>
  </body>
</html>