<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content=" ">
    <title> Fostac - Login  </title>


</head>
<body>

    <!-- main section -->
    <section class="section-form-margin-top">
        <div class="container">

        
            <!-- login form -->
            <div class="row">
                <div class="col-md-4 hidden-xs"></div>
                <div class="col-md-4  col-xs-12">
                    <form class="registration-box">
                        <div class="form-group">
                            <label for="user id">User Id:</label>
                            <input type="text" class="form-control" id="User" placeholder="Enter Your User ID" required="required">
                        </div>
                        <div class="form-group">
                            <label for="pwd">Password:</label>
                            <input type="password" class="form-control" id="pwd" placeholder="Enter Your Password" required="required">
                        </div>
                        <div class="form-group login-btn-padding-top">
                            <input type="button" class="form-control login-btn" id="button" value="Submit" />
                        </div>
                    </form>    
                    <!-- forgot password -->
                    <div class="text-center forgot-margin-top">
                        <a href="#" target="_blank">Forgot Password ?</a>
                    </div>                
                </div>
                <div class="col-md-4 hidden-xs"></div>
            </div>
        </div>
    </section>
  
   
    <!-- scripts -->

    <script src="website/loginpage/js/jquery-2.1.0.min.js"></script>
    <script src="website/loginpage/js/bootstrap.js"></script>
    <!-- on scroll animation -->
    <script src="website/loginpage/js/aos.js"></script>
    <script>
        AOS.init();
    </script>   

</body>
</html>