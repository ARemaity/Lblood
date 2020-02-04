<?php

class DBConnect {
    public $db = NULL;

    const DB_SERVER = "localhost";
    const DB_USER = "root";
    const DB_PASSWORD = "";
    const DB_NAME = "donor";

    public function __construct() {
        $dsn = 'mysql:dbname=' . self::DB_NAME . ';host=' . self::DB_SERVER;
        try {
            $this->db = new PDO($dsn, self::DB_USER, self::DB_PASSWORD);
        } catch (PDOException $e) {
            throw new Exception('Connection failed: ' .
            $e->getMessage());
        }
        return $this->db;
    }
    public function getdb(){


        return $this;
    }
    public function auth(){
        session_start();
        if(! isset($_SESSION['username'])){
            header("Location: ");
        }       
    }

    public function savenb($nb){
        
        $_SESSION["NUMBER"] = $nb;   
    }
    public function saveid($id){
        
        $_SESSION["DID"] = $id;   
    }
    public function savemail($email){
        
        $_SESSION["EMAIL"] = $email;   
    }
    public function authLogin(){
        session_start();
        if(isset($_SESSION['username'])){
            header("Location: ");
        }
    }
    



    public function addDonor($fname,$lname,$address,$phone,$bloodGroup,$dob,$donationDate,$health){
        $stmt = $this->db->prepare("INSERT INTO `doner` (`DID`, `fname`, `lname`, `address`, `phone_number`, `blood_group`, `DOB`, `Last_Date`, `Health_History`, `SID`) 
        VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, '2');");
        $stmt->execute([$fname,$lname,$address,$phone,$bloodGroup,$dob,$donationDate,$health]);
        return true;
        
    }

    public function getemail($did){
        $stmt = $this->db->prepare("SELECT  email from pass,doner where doner.SID=pass.SID AND doner.SID=?");
        $stmt->execute([$did]);
        $email = $stmt->fetchColumn();

        return $email;
    }        
    public function addrec($name,$hospital,$phone,$did){
$stmt = $this->db->prepare("INSERT INTO `reciever` (`RID`, `name`, `hospital_name`, `phone_number`, `DID`) VALUES (NULL, ?, ?, ?,?)");
$stmt->execute([$name,$hospital,$phone,$did]);
return true;

}
    
    public function searchDonorWithBloodGroup($bloodGroup){
        $stmt = $this->db->prepare("SELECT  doner.DID,doner.fname,doner.lname,doner.address,doner.phone_number,doner.blood_group,doner.DOB,`doner`.`Last_Date`,doner.Health_History FROM doner WHERE  (blood_group=? AND Last_Date  IS NULL) OR (blood_group=?   AND DATEDIFF( CURDATE(), doner.Last_Date)>=60) LIMIT 2");
        $stmt->execute([$bloodGroup,$bloodGroup]);
        return $stmt->fetchAll();
    }
    public function showmore($bloodGroup){
        $stmt = $this->db->prepare("SELECT  doner.DID,doner.fname,doner.lname,doner.address,doner.phone_number,doner.blood_group,doner.DOB,`doner`.`Last_Date`,doner.Health_History FROM doner WHERE  (blood_group=? AND Last_Date  IS NULL) OR (blood_group=?   AND DATEDIFF( CURDATE(), doner.Last_Date)>=60)");
       
        $stmt->execute([$bloodGroup,$bloodGroup]);
        return $stmt->fetchAll();
    }
    
 
    
    public function logout(){
        session_start();
        session_destroy();
        header("Location: ");
    }
    
    public function getDonorProfileById($id){
        $stmt = $this->db->prepare("SELECT * FROM doner WHERE DID=?");
        $stmt->execute([$id]);
        return $stmt->fetchAll();
    }
    
}
