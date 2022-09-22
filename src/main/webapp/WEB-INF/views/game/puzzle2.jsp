<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>

<!-- =========================================================
* Sneat - Bootstrap 5 HTML Admin Template - Pro | v1.0.0
==============================================================

* Product Page: https://themeselection.com/products/sneat-bootstrap-html-admin-template/
* Created by: ThemeSelection
* License: You must have a valid license purchased in order to legally use the theme for your project.
* Copyright ThemeSelection (https://themeselection.com)

=========================================================
-->
<!-- beautify ignore:start -->
<html
        lang="en"
        class="light-style layout-menu-fixed"
        dir="ltr"
        data-theme="theme-default"
        data-assets-path="/assets/"
        data-template="vertical-menu-template-free"
>
<head>
    <meta charset="utf-8"/>
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"
    />

    <title>Dashboard - Analytics | Sneat - Bootstrap 5 HTML Admin Template - Pro</title>

    <meta name="description" content=""/>

    <!-- Favicon -->
    <link rel="icon" type="image/x-icon" href="/assets/img/favicon/favicon.ico"/>

    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin/>
    <link
            href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
            rel="stylesheet"
    />

    <!-- Icons. Uncomment required icon fonts -->
    <link rel="stylesheet" href="/assets/vendor/fonts/boxicons.css"/>

    <!-- Core CSS -->
    <link rel="stylesheet" href="/assets/vendor/css/core.css" class="template-customizer-core-css"/>
    <link rel="stylesheet" href="/assets/vendor/css/theme-default.css" class="template-customizer-theme-css"/>
    <link rel="stylesheet" href="/assets/css/demo.css"/>

    <!-- Vendors CSS -->
    <link rel="stylesheet" href="/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css"/>

    <link rel="stylesheet" href="/assets/vendor/libs/apex-charts/apex-charts.css"/>

    <!-- Page CSS -->

    <!-- Helpers -->
    <script src="/assets/vendor/js/helpers.js"></script>

    <!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
    <!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
    <script src="/assets/js/config.js"></script>

    <style>
        .submit-btn {
            border: 0;
            border-radius: 5px;
            padding: 10px;
            width: 80%;
            font-size: 22px;
            color: white;
            background: linear-gradient(to right, #62a6d3 0%, #8083b6 50%, #905a9e 100%);
        }

        .btn-result1 {
            border: 2px solid #d3d3d3;
            border-radius: 30px;
            background-color: white;
            height: 18%;
            width: 100%;
        }

        .r-ans {
            border: 2px solid #8bc34a;
        }

        .w-ans {
            border: 2px solid #c34a4e;
        }

        .q-count {
            margin-left: 30px;
            font-size: 20px;
            font-weight: 700;
            color: #4e6472;
        }

        .q-text {
            font-size: 30px;
            font-weight: 700;
            padding: 0 0 20px;
            margin: 0;
        }

        .btn-half li {
            width: 50%;
            float: left;
            display: inline-block;
        }

        .ul-half {
            margin: 0;
            padding: 0;
            display: inline-block;
            list-style: none;
        }

        .ul-half li {
            width: 50%;
            float: left;
        }

        .clear::after {
            content: '';
            display: block;
            clear: both;
        }

        img.logo-side {
            width: 150px;
            justify-content: center;
        }

        .category-icons {
            width: 30px;
            height: 30px;
            margin-right: 5px;
        }

        #layout-navbar {
            background: linear-gradient(to right, #62a6d3 0%, #8083b6 50%, #905a9e 100%);
        }

        .menu-link {
            justify-content: center;
        }

        ul.menu-inner li.menu-item a div {
            line-height: 30px;
            font-size: 20px;
        }

        .choice-ans {
            border: 2px solid #ffc000;
            background-color: ivory;
        }

        .square {
            width: 50%;
        }

        .square:after {
            content: "";
            display: block;
            padding-bottom: 100%;
        }

        textarea::placeholder {
            font-size: 1em;
        }

        textarea {
            width: 90%;
            height: 20%;
            resize: none;
            border: none;
         }

    </style>
</head>

<body>
<!-- Layout wrapper -->
<div class="layout-wrapper layout-content-navbar">
    <div class="layout-container">
        <!-- Menu -->
        <aside id="layout-menu" class="layout-menu menu-vertical menu bg-menu-theme" style="text-align: center;">
            <div class="app-brand demo" style="justify-content: center;">
                <a href="/main-page">
                    <img class="logo-side" src="/assets/img/icons/aducator/logo-side.png" alt="logo side"/>
                </a>
            </div>

            <div class="menu-inner-shadow"></div>

            <ul class="menu-inner py-1">
                <li class="menu-header small text-uppercase"></li>
                <li class="menu-item">
                    <a class="menu-link">
                        <div class="wrapper">
                            <div class="circle">
                                <div class="circle2"></div>
                            </div>
                        </div>
                        <div data-i18n="Account Settings"><h3><strong>&nbsp;User</strong></h3></div>
                    </a>
                </li>
                <li class="menu-header small text-uppercase" style="text-align: center;">
              <span class="menu-header-text">
                <img style="width: 150px; text-align: center" src="/assets/img/icons/aducator/dot.png" alt="dot line">
              </span>
                </li>
                <br>
                <li class="menu-item">
                    <a href="/quiz/quiz-make" class="menu-link">
                        <img class="category-icons" src="/assets/img/icons/aducator/quiz-icon.png" alt="quiz icon">
                        <div data-i18n="Account Settings"><h3><strong>Quiz</strong></h3></div>
                    </a>
                </li>
                <!-- Components -->
                <li class="menu-header small text-uppercase"><span class="menu-header-text"><hr/></span></li>
                <!-- Cards -->
                <li class="menu-item">
                    <a href="/cmu/Cmu_01" class="menu-link">
                        <img class="category-icons" src="/assets/img/icons/aducator/community-icon.png"
                             alt="community icon">
                        <div data-i18n="Basic"><h3><strong>Community</strong></h3></div>
                    </a>
                </li>
                <!-- User interface -->
                <li class="menu-header small text-uppercase"><span class="menu-header-text"><hr/></span></li>
                <li class="menu-item">
                    <a href="/game/game-choice" class="menu-link">
                        <img class="category-icons" src="/assets/img/icons/aducator/game-icon.png" alt="game icon">
                        <div data-i18n="Basic"><h3><strong>Game</strong></h3></div>
                    </a>
                </li>
                <!-- Forms & Tables -->
                <li class="menu-header small text-uppercase"><span class="menu-header-text"><hr/></span></li>
                <!-- Forms -->
                <li class="menu-item">
                    <a href="/mypage/user-info" class="menu-link">
                        <img class="category-icons" src="/assets/img/icons/aducator/star-icon.png" alt="star icon">
                        <div data-i18n="Basic"><h3><strong>My page</strong></h3></div>
                    </a>
                </li>
                <li class="menu-header small text-uppercase">
                </li>
                <li class="menu-item">
                    <a href="/logoutSession" class="menu-link">
                        <div data-i18n="Basic" style="color: red;"><strong>Logout</strong></div>
                    </a>
                </li>
            </ul>
        </aside>
        <!-- / Menu -->

        <!-- Layout container -->
        <div class="layout-page">

            <!-- Content wrapper -->
            <div class="content-wrapper">
                <div><a href="/game/puzzle1"><img class="logo-side sqare" src="/assets/img/icons/aducator/arrow-left.png" alt="arrow-left" style="width: 3%; float: left; margin-left: 1%; margin-top: 1%"/></a></div>
                <!-- Content -->

                <div class="container-xxl flex-grow-1 container-p-y">
                    <form action="/quiz/quiz-result" method="post">
                        <div class="row">
                            <div class="col" style="width: 60%; height: 80%;">
                                    <div class="mb-4" style="float: center; margin-left: 10%">
                                        <div style="margin-top: 10%; text-decoration: #BBBBBC underline; "><h1 style="font-size: 3.5rem !important;"><strong>난간에 기대어 있다</strong></h1></div>
                                        <input type="button" class="btn btn-result1 d-grid ClkBtn" value="be leaning against a railing" style="margin-top: 15%; font-size: 1.5rem !important;" />
                                        <input type="button" class="btn btn-result1 d-grid ClkBtn" value="be leaning against a railing" style="margin-top: 7%; font-size: 1.5rem !important;" />
                                        <input type="button" class="btn btn-result1 d-grid ClkBtn" value="be leaning against a railing" style="margin-top: 7%; font-size: 1.5rem !important;" />
                                        <input type="button" class="btn btn-result1 d-grid ClkBtn" value="be leaning against a railing" style="margin-top: 7%; font-size: 1.5rem !important;" />
                                    </div>
                            </div>
                            <br>


                            <div class="col" style="width: 40%; height: 80%; margin-right: 10%">
                                <div class="col-lg-8 mb-4 square"
                                     style="margin-top: 10%; width: 75%; border: 3px solid #BBBBBC; border-radius: 5px 5px 5px 2px; box-shadow: 5px 5px 5px 5px #BBBBBC; float:right;"></div>
                                <div style="width: 70%; float:right; text-align: right;"><h5><strong>퍼즐은 랜덤한 이미지로 랜덤한 위치에 생성됩니다.</strong></h5></div>
                                <div style="width: 70%; float:right; text-align: right; "><h5><strong>3/20</strong></h5></div>
                            </div>

                            <br>


                            <textarea style="font-size: 3.5em; width: 90%; background: linear-gradient( to right,#F9D021, #F6F072 ); margin: 0 auto; border-radius: 80px; height: 2em; maxlength: 30;" placeholder="  답을 입력하세요"></textarea>

                        </div>




                        <!-- / Content -->
                        <div class="content-backdrop fade"></div>
                    </form>
                </div>
                <!-- Content wrapper -->
            </div>
            <!-- / Layout page -->
        </div>

        <!-- Overlay -->
        <div class="layout-overlay layout-menu-toggle"></div>
    </div>
</div>
<!-- / Layout wrapper -->

<!-- Core JS -->
<!-- build:js assets/vendor/js/core.js -->
<script src="/assets/vendor/libs/jquery/jquery.js"></script>
<script src="/assets/vendor/libs/popper/popper.js"></script>
<script src="/assets/vendor/js/bootstrap.js"></script>
<script src="/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>

<script src="/assets/vendor/js/menu.js"></script>
<!-- endbuild -->

<!-- Vendors JS -->
<script src="/assets/vendor/libs/apex-charts/apexcharts.js"></script>

<!-- Main JS -->
<script src="/assets/js/main.js"></script>

<!-- Page JS -->
<script src="/assets/js/dashboards-analytics.js"></script>

<script type="text/javascript">
    $(document).ready(function () {
        $('input.ClkBtn').click(function () {
            $(this).toggleClass('choice-ans');
        });
    });
</script>

<!-- Place this tag in your head or just before your close body tag. -->
<script async defer src="https://buttons.github.io/buttons.js"></script>
</body>
</html>
