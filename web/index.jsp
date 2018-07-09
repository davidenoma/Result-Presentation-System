
<!DOCTYPE HTML>
<html>
    <head>
        <title>Web Based Result Presentation System</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />
        <meta name="keywords" content="Web Based Result Presentation Sysytem" />
        <link href='http://fonts.googleapis.com/css?family=Ropa+Sans' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="css/responsiveslides.css">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <script src="js/responsiveslides.min.js"></script>
        <script>
            // You can also use "$(window).load(function() {"
            $(function () {

                // Slideshow 1
                $("#slider1").responsiveSlides({
                    maxwidth: 1600,
                    speed: 600
                });
            });
        </script>
        <style>
            body{
                background-color: #fff;
            }
            .wrap .contact-form input{
                width:80%;
                margin:auto;
            }
            .wrap .contact-form H1{
                text-align: center;
                padding: 10px;
                margin:10px;
            }
            .wrap .contact-form .btn-submit{
                width:85%;
                margin-left:6%;
            }
            .contact-form{
                margin-top:100px;
                margin-bottom: 50px;
            }
            .footer{
                margin-top:80px;
            }
            .image-slider{
                margin-top:50px;
            }
            .wrap .left-nav a{
                font-size: 19px;
            }
        </style>
    </head>
    <body>
        <!---start-wrap---->

        <!---start-header---->
        <div class="header">
            <div class="wrap">
                <!---start-logo---->
                <div class="logo">
                    <a href="index.jsp"><img src="images/logo.png" title="logo" /></a>
                </div>
                <!---end-logo---->
                <!---start-search---->
                <div class="top-search-bar">
                    <div class="header-top-nav">
                        <ul>
                            <%-- <li><a href="lecturer.jsp"><img src="images/marker1.png" title="livehelp" />Lecturer Login</a></li>
                            <li><a href="hods.jsp"><img src="images/marker1.png" title="Blog" />HODs Login</a></li>
                            <li><a href="dean.jsp"><img src="images/marker1.png" title="customer report" />Dean Login</a></li>
                            --
                            --%>
                        </ul>
                    </div>
                </div>
                <div class="clear"> </div>
            </div>
        </div>
        <div class="clear"> </div>
        <div class="header-nav">
            <div class="wrap">
                <div class="left-nav">
                    <ul>
                                  
                        <li ><a  href="#">Web Based Result Presentation System</a></li>
                    </ul>
                </div>
                <div class="right-social-icons">
                    <ul>
                        <li><a class="icon1" href="#"> </a></li>
                        <li><a class="icon2" href="#"> </a></li>
                        <li><a class="icon3" href="#"> </a></li>
                        <li><a class="icon4" href="#"> </a></li>
                    </ul>
                </div>
                <div class="clear"> </div>
            </div>
            <!---start-search---->
        </div>
        <!---end-header---->
        <!--start-image-slider---->
        <div class="wrap wrap2">
            <div class="contact-form" style="width:30%; float:left">
                                <h1 >SYSTEM LOGIN </h1>
                                <form action="/ResultPresentationSystem/Validation" method="POST">
                                    <div>
<!--                                        <span><label>USERNAME</label></span>-->
                                        <span><input type="text" value="" name="username" placeholder="ENTER YOUR USERNAME "></span>
                                    </div>
                                    <div>
<!--                                        <span><label>PASSWORD</label></span>-->
                                        <span><input type="password" value="" name="password" placeholder="ENTER YOUR PASSWORD"></span>
                                        
                                    </div>
                                    <div>
                                        <span><input type="submit" value="Submit" class="btn-submit"></span>
                                    </div>
                                </form>
                            </div>
            <div class="image-slider" style="width:65%; float:left">
                <!-- Slideshow 1 -->
                <ul class="rslides" id="slider1">
                    <li><img src="images/Journals-Recovered.jpg" alt=""></li>
                    <li><img src="images/images-15.jpeg" alt=""></li>
                    <li><img src="images/images-10.jpeg" alt=""></li>
                    <li><img src="images/vc.jpg" alt=""></li>
                </ul>
                <!-- Slideshow 2 -->
            </div>
            <!--End-image-slider---->
            <!---start-content---->

   

                           
            <!---End-content---->
            <div class="clear"> </div>
        </div>
        <div class="footer"> 
            <div class="wrap"> 
                <div class="footer-left">
                    <ul>

                    </ul>
                </div>
                <div class="footer-right">
                    <p>Ugoji Catherinemary .N-U13/NAS/COM/036</p>
                </div>
                <div class="clear"> </div>
            </div>
            <div class="clear"> </div>
            <!---end-wrap---->
        </div>
    </body>
</html>

