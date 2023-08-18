<?php
//* Final Homework - Routing
require_once('../shared/db.php');

$error = '';
if (session_status() == PHP_SESSION_NONE) {
    session_start();
}
if (!empty($_REQUEST['login'])) {
    
    $sql = "SELECT name, status FROM admin WHERE email = ? and password = ?";
    $args = [];
    $args[] = $_REQUEST['email'];
    $args[] = $_REQUEST['password'];
    $results = execute($sql,$args);
    
    if(empty($results)) {
        $error = "Log in failed. Please enter valid login.";
    } else{
        //$sql = "SELECT name FROM admin"
        $_SESSION['user'] = $results[0]['name'];
        $_SESSION['access'] = $results[0]['status'];
        header("Location: index.php?page=welcome");
    }
}
//     // We are just simulating a valid login here
//     $_SESSION['user']='some name';
//     $_SESSION['access']='admin OR staff';
//     header("Location: index.php?page=welcome");
// } else {
//     $error = "Log in failed. Please enter valid login.";
// }

?>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Final Project</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  </head>
  <body>
    <div class="container">
    <h1>Log In</h1>
    <p><?php echo($error); ?></p>
    <form action="index.php" method="post">
      <div class="row">
        <div class="col-md-6">
          <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" name="email" value="">
          </div>
        </div>
      </div>
      <br>
      <div class="row">
        <div class="col-md-6">
          <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" name="password" value="">
          </div>
        </div>
      </div>
      <br>
      <div class="row">
        <div class="col-md-6">
          <div class="form-group">
            <input type="submit" class="btn btn-primary" name="login" value="Login">
          </div>
        </div>
      </div>
      </form>



    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
  </body>
</html>




<!-- <form method="POST">
    <input type="submit" name="button" value="Log In">
</form> -->

