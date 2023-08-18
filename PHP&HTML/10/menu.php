<?php
//* Final Homework - Routing

if (session_status() == PHP_SESSION_NONE) {
    session_start();
}
if (empty($_SESSION['user']) || empty($_SESSION['index'])) {
    header("Location: index.php?page=logout");
}
unset($_SESSION['index']);
// check $_SESSION['access'] to see which menu items should be displayed.  
// I am displaying them all in this example

// if($_SESSION['access'] = 'admin') {
    
//     $nav=<<<HTML
//     <nav>
//         <ul class = "nav">
//             <li class="nav-item"><a class="nav_link" href="index.php?page=addContact">Add Contact </a></li>
//             <li class="nav-item"><a class="nav_link" href="index.php?page=deleteContacts">Delete contact(s) </a></li>
//             <li class="nav-item"><a class="nav_link" href="index.php?page=addAdmin">Add Admin </a></li>
//             <li class="nav-item"><a class="nav_link" href="index.php?page=deleteAdmins">Delete Admin(s) </a></li>
//             <li class="nav-item"><a class="nav_link" href="logout.php">logout </a></li>
//         </ul>
//     </nav>
// HTML;

// } else if($_SESSION['access'] = 'staff'){
//     $nav=<<<HTML
//     <nav>
//         <ul class="nav">
//             <li class="nav-item"><a class="nav_link" href="index.php?page=addContact">Add Contact</a></li>
//             <li class="nav-item"><a class="nav_link" href="index.php?page=deleteContacts">Delete contact(s)</a></li>
//             <li class="nav-item"><a class="nav_link" href="logout.php">logout</a></li>
//         </ul>
//     </nav>
// HTML;

// }

//echo $page->nav($nav); as needed



?>
<?php if($_SESSION['access'] == 'Admin'){ ?>
<a href='index.php?page=addAdmin'>Add Admin</a>&nbsp;&nbsp;&nbsp;
<a href='index.php?page=deleteAdmin'>Delete Admin</a>&nbsp;&nbsp;&nbsp;
<?php } ?>
<a href='index.php?page=addContact'>Add Contact</a>&nbsp;&nbsp;&nbsp;
<a href='index.php?page=deleteContact'>Delete Contact</a>&nbsp;&nbsp;&nbsp;
<a href='index.php?page=logout'>Log Out</a>