<?php
//* Final Homework - Routing

require_once('menu.php');
require_once('../shared/db.php');
//$options = ["mi"=>"Michigan","oh"=>"Ohio","pa"=>"Pennslyvania","tx"=>"Texas", "ny"=>"New York"];

$phone = $message = '';
if (!empty($_REQUEST['button'])) {
    $phone = empty($_REQUEST['phone']) ? '' : $_REQUEST['phone'];
    $phonePattern = '/^\d{3}\.\d{3}\.\d{4}$/';
    if (preg_match($phonePattern,$phone) === 1) {
        $message = "The phone number is valid and has been submitted. (php message)";
    } else {
        $message = "Invalid phone number. (php message)";
    }

    $sql = "INSERT INTO contact (name,address,city,phone,state,dob,email,contact) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    $args = [];
    $args[] = $_REQUEST['name'];
    $args[] = $_REQUEST['address'];
    $args[] = $_REQUEST['city'];
    $args[] = $_REQUEST['phone'];
    $args[] = $_REQUEST['state'];
    $args[] = $_REQUEST['dob'];
    $args[] = $_REQUEST['email'];
    $args[] = $_REQUEST['contact[]'];
    execute($sql,$args);

    $submitMsg = "<br>Record Entered";
    //echo("<br>Record Entered");
}

//if(!empty($_REQUEST['button'])){
    
    // $sql = "INSERT INTO contact (name,address,city,phone,state,dob,email,contact) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    // $args = [];
    // $args[] = $_REQUEST['name'];
    // $args[] = $_REQUEST['address'];
    // $args[] = $_REQUEST['city'];
    // $args[] = $_REQUEST['phone'];
    // $args[] = $_REQUEST['state'];
    // $args[] = $_REQUEST['dob'];
    // $args[] = $_REQUEST['email'];
    // $args[] = $_REQUEST['contacts[]'];
    // execute($sql,$args);

    // echo("<br>Record Entered"); 
        
//}

?>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Final Project</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  </head>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script>
        function validatePhone() {
            var myElement =  $("#phone");
            var phonePattern = /^\d{3}\.\d{3}\.\d{4}$/;
            phone = myElement.val(); 
            var isValid = phonePattern.test(phone);
            if (isValid) {
                return true;
            }
            var myElement =  $("#messageDiv");
            myElement.html('Invalid phone number. (js message)');
            return false;
        }
    </script>
<body class="container">

<h1>Add Contact</h1>
<form method="post">
    <div class="form-group">
      <label for="name">Name (letters only)</label>
      <input type="text" class="form-control" id="name" name="name" value="" >
    </div><br>

    <div class="form-group">
      <label for="address">Address (just number and street)</label>
      <input type="text" class="form-control" id="address" name="address" value="" >
    </div><br>

    <div class="form-group">
      <label for="city">City </label>
      <input type="text" class="form-control" id="city" name="city" value="" >
    </div><br>

    <div class="form-group">
      <label for="state">State</label>
      <select class="form-control" id="state" name="state">
        <option value="mi">Michigan</option>
        <option value="oh">Ohio</option>
        <option value="tx">Texas</option>
      </select>
    </div><br>

    <div class="form-group">
      <label for="phone">Phone (format 999.999.9999)</label>
      <input type="text" placeholder="Enter valid phone" class="form-control" name="phone" id="phone" value="<?=$phone?>">
        <div id="messageDiv"><?=$message?></div>
    </div><br>

    <div class="form-group">
      <label for="email">Email </label>
      <input type="text" class="form-control" id="email" name="email" value="" >
    </div><br>
    
    <div class="form-group">
      <label for="dob">Date of Birth </label>
      <input type="text" class="form-control" id="dob" name="dob" value="" >
    </div><br>

    <p>Please check all contact options you'd like (optional):</p>
    <div class="form-check form-check-inline">
      <input class="form-check-input" type="checkbox" name="contacts[]" id="contacts1" value="Newsletter">
      <label class="form-check-label" for="contacts1">Newsletter</label>
    </div>
    <div class="form-check form-check-inline">
      <input class="form-check-input" type="checkbox" name="contacts[]" id="contacts2" value="Email Updates">
      <label class="form-check-label" for="contacts2">Email Updates</label>
    </div>
    <div class="form-check form-check-inline">
      <input class="form-check-input" type="checkbox" name="contacts[]" id="contacts3" value="Text Updates">
      <label class="form-check-label" for="contacts3">Text Updates</label>
    </div>

    <div>
      <button onclick="return validatePhone();" type="submit" name="button" class="btn btn-primary">Submit</button>
    </div>
  </form>
</body>
</html>


