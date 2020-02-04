<?php


 require_once 'php/dbconnect.php';
 $db = new DBConnect();
if(isset($_GET['blood-group'])){
    $i=0;
    $bloodGroup=$_GET['blood-group'];

    // if(substr( $bloodGroup, -1) 
    $donors = $db->showmore($bloodGroup);
    
    if (isset($donors)): 
      echo" <table class='table table-condensed'>
           <tr>
               <th>Index</th>
               <th>Profile</th>
               <th>Name</th>
               <th>Address</th>
              
               <th>Blood Group</th>
               <th>Age</th>
               <th>Last date donation</th>
               <th>Health History</th>
              
           <tr>";
              foreach ($donors as $d): $i++; 
             echo "  <tr>
                   <td>".$i."</td>
                   <td><a href='profile.php?id=". $d['DID']."'>View</a></td>
                   <td>".$d['fname'] .  " " . $d['lname']."</a></td>
                   <td>". $d['address']."</td>
                   <td>". $d['blood_group']."</td>
                   <td>"; $from = new DateTime($d['DOB']);
                     $to   = new DateTime('today');
                   echo $from->diff($to)->y."</td>
                   <td>";if ($d['Last_Date']===null){
                    echo "<p class='text-success'>Its New</p>";
                }else{
                    echo $d['Last_Date'];
                } echo "</td>
                   <td>". $d['Health_History']."</td>
               </tr>";
          endforeach;
      echo" </table>";
    endif;

}
 
?>