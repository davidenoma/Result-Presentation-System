<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Web Based Result Presentation System</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      
    <![endif]-->
  </head>
  <body>
    <div class="container">
      <div class="info">
         <h2 class="bg-primary">Web Based Result Presentation System</h2>
         <div class="bg-info">
          <p class="text-danger">Please login Below</p>
          
         </div>
       
          <div class="col-md-6 col-md-offset-3">
                    <h4></span>Log in with your credentials<span class="glyphicon glyphicon-user"></h4><br/>
                            <div class="block-margin-top">
                              

                              <form action="authenticate.jsp" method="POST" class="form-signin col-md-8 col-md-offset-2" role="form">  
                                  <input type="text" name="username" class="form-control" placeholder="Username" required autofocus><br/>
                                  <input type="password" name="password" class="form-control" placeholder="Password" required><br/>
                                  <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                             </form>
                           </div>
            </div>

      </div>
      
     
    </div>
  

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>