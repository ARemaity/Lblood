<?php

 require_once 'php/DBConnect.php';
 $db = new DBConnect();
 $message="";


include 'header/header.php';

 if(isset($_POST['submit'])){
    $fname = $_POST['fname'];
    $lname = $_POST['lname'];
    $address = $_POST['city'];
    $phone = $_POST['number'];
    $bloodGroup = $_POST['x'];
    $dob = $_POST['dob'];
    $donationDate = $_POST['ldate'];
    $health = $_POST['history'];
    $flag=$db->addDonor($fname,$lname,$address,$phone,$bloodGroup,$dob,$donationDate,$health);

    
    if ($flag) {
        $message = "Successfully Added :)";
    } else {
        $message = "there is an error ";
    }
}

$i=0;

  ?>














<div class="section full-height height-auto-lg hide-over background-light-blue">
    <div class="hero-center-wrap relative-on-lg" style="margin-top:20px;">
        <form method="post" action="fillform.php">
            <?php echo $message; 
           
            ?>
            <div class="container">

                <div class="row">
                    <div class="col-sm-6 form-group">
                        <label>First Name</label>

                        <input name="fname" type="text" placeholder="Enter First Name Here.." class="form-control"
                            required="required">
                        <div class="help-block with-errors"></div>
                    </div>

                    <div class="col-sm-6 form-group">
                        <label>Last Name</label>

                        <input name="lname" type="text" placeholder="Enter Last Name Here.." class="form-control"
                            required="required">
                        <div class="help-block with-errors"></div>
                    </div>

                </div>
            </div>
            <div class="container">
                <div class="row">
                    

                    <div class="col-sm-12 form-group">
                        <label>date of birth</label>

                        <input type="date" name="dob">
                        <div class="help-block with-errors"></div>
                    </div>
                </div>

            </div>
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 form-group">
                        <label>city</label>

                        <select name="city" class="form-control">

                            <option value="Aakkar">Aakkar</option>
                            <option value="Baalbek-Hermel">Baalbek-Hermel</option>
                            <option value="Beirut">Beirut</option>
                            <option value="Beqaa">Beqaa</option>
                            <option value="Mount Lebanon">Mount Lebanon</option>
                            <option value="Nabatiyeh">Nabatiyeh</option>
                            <option value="North Lebanon">North Lebanon</option>
                            <option value="South Lebanon">South Lebanon</option>
                        </select>
                        <div class="help-block with-errors"></div>
                    </div>

                    <div class="col-sm-6 form-group">
                        <label>blood group</label>

                        <select name="x" class="form-control">
                            <option value="O+">O+</option>
                            <option value="O-">O-</option>
                            <option value="A+">A+</option>
                            <option value="A-">A-</option>
                            <option value="B+">B+</option>
                            <option value="B-">B-</option>
                            <option value="AB+">AB+</option>
                            <option value="AB-">AB-</option>
                        </select>
                        <div class="help-block with-errors"></div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 form-group">
                        <label> last donation</label>
                        <input type="date" name="ldate">

                        <!-- <div class="help-block with-errors"></div> -->

                    </div>
                    <div class="col-sm-6 form-group">
                        <label>Phone</label>

                        <input id="phone" type="tel" name="number" class="form-control" required="required"
                            data-error="Valid phone is required." placeholder="Enter your phone">

                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-sm-12 form-group">
                        <label> Health history</label>
                        <input class="form-control input-lg" id="inputlg" type="text" name="history">

                    

                    </div>

                </div>
                <div class="col-md-12 text-center" style="margin-top:50px;">
                    <input type="submit" name="submit" class="btn btn-primary btn-send text-center" value="Register">
                </div>


        </form>
    </div>

</div>


<?php include 'footer/footer.php'; ?>