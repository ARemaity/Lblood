<footer class="text-muted" >
      <div class="container">
        <p class="float-right">
          <a href="#">Back to top</a>
        </p>
        <p>Blood donation System </p>
      
      </div>
    </footer>

   
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script>
    
    $( document ).ready(function() {

    var type =  $("#result").attr('blood-type');
    var sign = type.charAt(type.length-1);
    if(sign=='+'){

        type=type.charAt(0)+"%2B";
    }else{

        type=type.charAt(0)+"%2D";

    }

    console.log("type is "+type);
    $("#show-more").click(function(){
        console.log("show more clicked");



        if (window.XMLHttpRequest) {
            // code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        } else {
            // code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("result").innerHTML = this.responseText;
            }
        };
        xmlhttp.open("GET","show-more.php?blood-group="+type,true);
        xmlhttp.send();
   
});

});
    
    </script>
</body>
</html>