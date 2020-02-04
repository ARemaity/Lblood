<?php
 require_once 'php/DBConnect.php';
 $db = new DBConnect();
 if (isset($_POST['searchBtn'])) {
    $bloodGroup = $_POST['x'];
    $donors = $db->searchDonorWithBloodGroup($bloodGroup);
}

include 'header/header.php';
$i=0;

?>

<div class="container">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <div class="form-group col-md-12">
                <form class="form-horizontal" method="post" action="search.php">
                    <div class="form-group">
                        <label class="col-sm-6">Search for donor by city  </label>
                        <div class="col-sm-4">
                            <select name="city" class="form-control">

                                <option value="O+">Aakkar</option>
                                <option value="O-">Baalbek-Hermel</option>
                                <option value="A+">Beirut</option>
                                <option value="A-">Beqaa</option>
                                <option value="B+">Mount Lebanon</option>
                                <option value="B-">Nabatiyeh</option>
                                <option value="AB+">North Lebanon</option>
                                <option value="AB-">South Lebanon</option>
                            </select>
                        </div>
                        <div class="col-sm-2" style="margin-top: 20px;">
                            <button class="btn btn-info btn-sm" name="searchByCityBtn" >Search</button>
                        </div>
                    </div>

                </form>
                <form class="form-horizontal" method="post" action="search.php">
                    <div class="form-group">
                        <label class="col-sm-6">Search for donor  with blood group</label>
                        <div class="col-sm-4">
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
                        </div>
                        <div class="col-sm-2" style="margin-top: 20px;">
                            <button class="btn btn-info btn-sm" name="searchBtn" >Search</button>
                        </div>
                    </div>

                </form>
            </div>
        </div>
        <div class="col-md-3"></div>
    </div>
    <div class="row">
        <div class="col-md-1">         
        </div>
        <div class="col-md-10" id="result" blood-type="<?= $bloodGroup?>">
            <!-- If the donor is searched by a particular blood group -->
            <?php if(isset($_POST['searchBtn'])): ?>
                <?php if(isset($donors[0])): ?>
                    <label>Total Blood Units Available for <?php echo $_POST['x']; ?>:</label> <span class="emphasize"><?= count($donors); ?> Unit</span>
                <?php endif; ?>
            <?php endif; ?>
            
            <!-- If the donor is search by a particular City -->
            <?php if(isset($_POST['searchByCityBtn'])): ?>
                <?php if(isset($donors[0])): ?>
                    <label>Total Number of Donors in this City:</label> <span class="emphasize"><PHP echo count($donors ); ?></span>
                <?php endif; ?>
            <?php endif; ?>
            
            <!-- if result has been fetched succesffully -->
            <?php if (isset($donors)): ?>
               
                <table class="table table-condensed">
                    <tr>
                        <th>Index</th>
                        <th>Profile</th>
                        <th>Name</th>
                        <th>Address</th>
                       
                        <th>Blood Group</th>
                        <th>Age</th>
                        <th>Last date donation</th>
                        <th>Health History</th>
                       
                    <tr>
                        <?php foreach ($donors as $d): $i++; ?>
                        <tr>
                            <td><?= $i; ?></td>
                            <td><a href="profile.php?id=<?= $d['DID']; ?>">View</a></td>
                            <td><?= $d['fname'] .  " " . $d['lname']; ?></a></td>
                            <td><?= $d['address']; ?></td>
            
                           
                            <td><?= $d['blood_group']; ?></td>
                            <td><?php $from = new DateTime($d['DOB']);
                              $to   = new DateTime('today');
                            echo $from->diff($to)->y; ?></td>
                            <td><?php if ($d['Last_Date']===null){
                                echo "<p class='text-success'>Its New</p>";
                            }else{
                                echo $d['Last_Date'];
                            }
                                ?></td>
                            <td><?= $d['Health_History']; ?></td>
                        </tr>
                    <?php endforeach; ?>
                </table>
                <div style=" margin-left: 400px;"><button type="button" id="show-more" class="btn btn-primary">Show More</button></div> 
            <?php endif; ?>
        </div>
        <div class="col-md-1">
           
        </div>
    </div>

</div>
<?php include 'footer/footer.php'; ?>
