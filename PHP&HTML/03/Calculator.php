<?php
    class calculator {
        public function calc($operator, $f_num = '', $s_num = ''){
            if ($f_num == '' || $s_num == '') {
                return "You must enter a string and two numbers<br>";
            }
            elseif ($operator == '/' && $s_num == 0) {
                return "Cannot divide by zero<br>";
            }
                switch ($operator) {
                    case "+":
                        echo "The sum of the numbers is ";
                        return ($f_num + $s_num)."<br>";
                        break;
                    case "-":
                        echo "The difference of the numbers is ";
                        return ($f_num - $s_num)."<br>";
                        break;
                    case "*":
                        echo "The product of the numbers is ";
                        return ($f_num * $s_num)."<br>";
                        break;
                    case "/":
                        echo "The division of the numbers is ";
                        return ($f_num / $s_num)."<br>";
                    default:
                        return "You must enter a string and two numbers<br>";
                        break; 
            }        
        
        }
    }
    
?>