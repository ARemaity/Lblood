<?php

 require_once 'php/DBConnect.php';
 $db = new DBConnect();
 session_start();
 if (isset($_GET['id'])) {
    $id = $_GET['id'];
    $data = $db->getDonorProfileById($id);
    
//$db->auth();
include 'header/header.php';
$i=0;

?>



<?php foreach ($data as $d): $i++; ?>
          <div class="col-md-8">
            <div class="profile-head">
              <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item">
                  <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">My profile</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Account Details</a>
                </li>
              </ul>
            </div>
            <div class="tab-content profile-tab" id="myTabContent">
              <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">

                <div class="row">
                  <div class="col-md-6">
                    <label>Name</label>
                  </div>
                  <div class="col-md-6">
                    <p><?php echo  $d["fname"] . " " . $d["lname"]; ?></p>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-6">
                    <label>City</label>
                  </div>
                  <div class="col-md-6">
                    <p><?php echo  $d["address"]; ?></p>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-6">
                    <label>Date of birth</label>
                  </div>
                  <div class="col-md-6">
                    <p><?php echo  $d["DOB"]; ?></p>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-6">
                    <label>phone</label>
                  </div>
                  <div class="col-md-6">
                    <p><button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal" >Click To proceed</button> <?php $db->savenb($d["phone_number"]);$db->saveid($d["DID"]); ?></p>
                  </div>
                </div>
                
              </div>
              <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
              <div class="row">
                  <div class="col-md-6">
                    <label>Blood group </label>
                  </div>
                  <div class="col-md-6">
                    <p><?php echo  $d["blood_group"]; ?></p>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-6">
                    <label>last date of birth </label>
                  </div>
                  <div class="col-md-6">
                    <p><?php echo  $d["Last_Date"]; ?></p>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-6">
                    <label>Health History</label>
                  </div>
                  <div class="col-md-6">
                    <p><?php echo  $d["Health_History"] ?></p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>
      <div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      
      </div>
      <div class="modal-body">
      <form action="show-number.php" method="POST" role="form" class="form-horizontal">

  <div class="form-group">
    <label for="searchterm" class="col-sm-2 control-label">Enter name</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="searchterm" name="name">
    </div>
  </div>
  <div class="form-group">
    <label for="searchterm" class="col-sm-2 control-label">Enter Hospital</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="searchterm" name="hospital">
    </div>
  </div>
  <div class="form-group">
    <label for="example-tel-input" class="col-2 col-form-label">Telephone</label>
    <div class="col-10">
      <input class="form-control" type="tel" value="+961" id="example-tel-input" name="number">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary" value="submit" name="submit">continue</button>
    </div>
  </div>
</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
      <?php endforeach; ?>
<?php  include 'footer/footer.php';} ?>