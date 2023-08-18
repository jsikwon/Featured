<?php
//* Final Homework - Routing

require_once('menu.php');
$welcomePageTop=<<<html1
            <!doctype html>
            <html lang="en">
            <head>
                <meta charset="utf-8">
                <meta name="viewport" content="width=device-width, initial-scale=1">
                <title>Final Project</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
            </head>
            <body class = "container">
html1;

$welcomPageBottom = "</body>";
$welcomPageBottom .="</html>";


echo($welcomePageTop);
echo ("<h1>Welcome</h1>");
echo($_SESSION['user']);
echo($welcomPageBottom);
?>
