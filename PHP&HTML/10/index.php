<?php
//* Final Homework - Routing

if (session_status() == PHP_SESSION_NONE) {
    session_start();
}
$_SESSION['index']=true;
$validPages = ['addAdmin','addContact','deleteAdmin','deleteContact','welcome'];
$page = empty($_REQUEST['page']) ? '' : $_REQUEST['page'];
$page = in_array($page, $validPages) ? $page : '';
if (empty($page)) {
    unset($_SESSION['index']);
    unset($_SESSION['user']);
    $page='login';
}
$page = "$page.php";
require_once($page);
?>