<?php
 class Helper {

   public function reverseName($name) {
        $name = $_POST['name'];
        $ar = explode(" ", $name);
        $ar = array_reverse($ar);
        $lastNameFirstName = implode(", ", $ar);
        
        return $lastNameFirstName;

    }
    public function addName($lastNameFirstName, $existingNames) {
        $nameAr =explode("\n", $existingNames);
        $nameAr[] = $lastNameFirstName;
        sort($nameAr);
        
        return implode("\n", $nameAr);
        
    }
   
    }

?>


