<?php


 if (isset($_GET['ids'])) {
    $code = $_GET['code'];
   
    if($code=='j32fncf44g'){
include 'header/header.php';





$servernamess = "localhost";
$usernamess = "root";
$passwordss = "";
$dbss = "donor";


$connect=mysqli_connect($servernamess,$usernamess,$passwordss,$dbss);
if(mysqli_connect_error()){
die("cannot connect to database".mysql_connect_error())	;	
}

$insert = mysqli_query($connect, "UPDATE doner SET Last_Date = CURDATE()  WHERE doner.DID =".$_GET['ids']."") or die(mysqli_error($connect));

if($insert)
{
        
    echo " <p class='h1'>Success verfied </p>";

}else{

    echo "<p class='h1'>Error</p>";
   
}

include 'footer/footer.php';
}} ?>

