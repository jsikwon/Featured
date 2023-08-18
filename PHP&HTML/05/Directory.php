<?php
class CreateDirectory {
    public function addFile() { 
        if(isset($_POST['submitButton'])) {
            $fileName = $_POST['fileName'];
            $fileContent = $_POST['fileContent'];

            if (file_exists('/home/j/w/jwon1/public_html/CPS276/05/files/'.$fileName.'.txt')) {
                echo('file exists, go back and try again');
                exit;
            } else {
                file_put_contents('/home/j/w/jwon1/public_html/CPS276/05/files/'.$fileName.'.txt', $fileContent);
            }     
        }
    }
    public function scanDirectory() {
        $files = scandir('/home/j/w/jwon1/public_html/CPS276/05/files');
        $files = array_diff($files, ['..', '.']);

        return $files;

        }
    }
?>