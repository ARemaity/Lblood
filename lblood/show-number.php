<?php
include_once('src/PHPMailer.php');
include_once('src/SMTP.php');
include_once('src/Exception.php');
 require_once 'php/DBConnect.php';
 $db = new DBConnect();
 session_start();
 $numberDoner=$_SESSION["NUMBER"]; 
 $did= $_SESSION["DID"];

 if (isset($_POST['submit'])) {
$name=$_POST['name'];
  $number=$_POST['number'];
  $hospital=$_POST['hospital'];
    $data = $db->addrec($name,$hospital,$number,$did);
    
$email=$db->getemail($did);
include 'header/header.php';


?>

<p class="h1"><?=$numberDoner;?> <?php //savemail($email); ?></p>


<?php
$base_url = "http://localhost/lblood/verfiy-donation.php";
   $mail_body = "
  
   <p>".$name." Need your Help ,please after completing your donation verfiy it Using the below link</p>
   <p>Please Open this link to verified your Donation - ".$base_url."?ids=". $did."&code=j32fncf44g&id
   <p>Best Regards,<br />LBlood</p>
   ";





   ///////////////////////////
   $mail = new PHPMailer\PHPMailer\PHPMailer();
  // $mail = new PHPMailer(true);

   $mail->IsSMTP(); // enable SMTP
  //$mail->SMTPDebug = 1; // debugging: 1 = errors and messages, 2 = messages only
   //authentication SMTP enabled
   $mail->SMTPAuth = true; 
   $mail->SMTPSecure = 'ssl'; // secure transfer enabled REQUIRED for Gmail
   $mail->Host = "smtp.gmail.com";
   $mail->Port = 465; 
   
   $mail->Username = "lbloodonation@gmail.com";
   $mail->Password = "kHthw4zd123";
   $mail->SetFrom("lbloodonation@gmail.com","LBlood Verfiy");  //Sets the From email address for the message
      //Sets the From name of the message
   $mail->AddAddress($email);
  //Adds a "To" address   
   $mail->WordWrap = 50;       //Sets word wrapping on the body of the message to a given number of characters
   $mail->IsHTML(true);       //Sets message type to HTML    
   $mail->Subject = 'Donation Verification';   //Sets the Subject of the message
   $mail->Body = $mail_body; 
   
   
   
// } catch (phpmailerException $e) {
//   echo $e->errorMessage(); //Pretty error messages from PHPMailer
// } catch (Exception $e) {
//   echo $e->getMessage(); //Boring error messages from anything else!
// }
   
 
   if($mail->Send())        //Send an Email. Return true on success or false on error
   {
    $message = '<label class="text-success">Email send to the doner to verfiy the Process Good luck &#10084; </label>';
   }
  else{


    echo '<script> window.alert("there is error try again");</script>';
  }

?>
<?php  




include 'footer/footer.php';}




else{

echo "there is error";
} ?>