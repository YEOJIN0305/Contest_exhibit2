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
        class="light-style customizer-hide"
        dir="ltr"
        data-theme="theme-default"
        data-assets-path="/assets/"
        data-template="vertical-menu-template-free"
>
<head>
    <meta charset="utf-8" />
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"
    />
    <!-- sns login api -->
    <meta name ="google-signin-client_id" content="634799830035-gkuumq759jsmpt7uam3e1pdseqt4l5p6.apps.googleusercontent.com">

    <title>Login Basic - Pages | Sneat - Bootstrap 5 HTML Admin Template - Pro</title>

    <meta name="description" content="" />

    <!-- Favicon -->
    <link rel="icon" type="image/x-icon" href="/assets/img/favicon/favicon.ico" />

    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
            href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
            rel="stylesheet"
    />

    <!-- Icons. Uncomment required icon fonts -->
    <link rel="stylesheet" href="/assets/vendor/fonts/boxicons.css" />

    <!-- Core CSS -->
    <link rel="stylesheet" href="/assets/vendor/css/core.css" class="template-customizer-core-css" />
    <link rel="stylesheet" href="/assets/vendor/css/theme-default.css" class="template-customizer-theme-css" />
    <link rel="stylesheet" href="/assets/css/demo.css" />

    <!-- Vendors CSS -->
    <link rel="stylesheet" href="/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css" />

    <!-- Page CSS -->
    <link rel="stylesheet" href="/assets/css/quiz.css" />
    <!-- Page -->
    <link rel="stylesheet" href="/assets/vendor/css/pages/page-auth.css" />
    <!-- Helpers -->
    <script src="/assets/vendor/js/helpers.js"></script>

    <style>
        input[type="checkbox"] {
            display: none;
        }
        input[type="checkbox"]:checked + label {
            border-color: #34b93d;
        }
        .quiz-type {
            border-radius: 20px;
            box-shadow: 5px 5px 5px 5px lightgray;
            max-width: 500px;
            margin-bottom: 50px;
        }
        img.logo-side {
            width: 50px;
        }
        .re-bookmark {
            width: 250px;
        }
        .jb-wrap {
            position: relative;
        }
        .jb-wrap img {
            vertical-align: middle;
        }
        .jb-text {
            text-align: center;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate( -50%, -50% );
        }
        ul {
            margin: 0;
            padding: 0;
            display: inline-block;
            list-style: none;
            width:50%;
            float: left;
        }
        ul > li:first-child {
            margin-bottom: 10px;
        }
        ul > li {
            font-size: 20px;
        }
        ul > li > input {
            margin-right: 10px;
        }
        .q-textbold {
            font-weight: 700;
            font-size: 20px;
            margin-bottom: 10px;
        }
        .q-count {
            font-weight: 500;
            text-align: center;
            font-size: 20px;
        }
        .q-textline {
            text-decoration-line: underline;
            text-decoration-color : blue;
            text-decoration-thickness : 3px;
        }
        .clear::after {
            content : '';
            display: block;
            clear: both;
        }
        .submit-btn {
            border: 0;
            border-radius: 5px;
            padding: 10px;
            width: 100%;
            font-size: 22px;
            color: white;
            background: linear-gradient(to right, #62a6d3 0%, #8083b6 50%, #905a9e 100%);
        }
    </style>
</head>

<body>
<!-- Content -->
<div style="position: fixed; top: 10px; left: 20px;">
    <a href="javascript:history.back();"><img class="logo-side" src="/assets/img/icons/aducator/arrow-left.png" alt="arrow-left"/></a>
</div>
<div style="position: fixed; top: 10px; right: 20px;">
    <div class="jb-wrap">
        <div class="jb-image"><img class="re-bookmark" src="/assets/img/icons/aducator/replay-bookmark.png" alt="북마크 다시보기"/></div>
        <div class="jb-text" style="padding-top: 20px; font-size: 18px;">
            <a href="/quiz/quiz-replay-bookmark"><p style="width: 200px;">북마크 다시보기</p></a>
        </div>
    </div>
</div>
<div class="container-xxl">
    <div class="authentication-wrapper authentication-basic container-p-y">
        <div class="authentication-inner" style="max-width: 550px;">
            <!-- Register -->
            <div class="card" style=" border-radius: 30px;">
                <div class="card-body" style="padding : 50px 30px;">
                    <div class="jb-wrap">
                        <div class="jb-image" style="margin-bottom: 30px;">
                            <img src="/assets/img/icons/aducator/folder-yellow.png" style="width:100%; height: 80px; justify-content: center;">
                        </div>
                        <div class="jb-text" >
                            <p style="font-size: 22px; padding-top: 27px; width:500px;">문제를 제출 할 단어장 선택</p>
                        </div>
                    </div>
                    <form method="post" action="/quiz/quiz-workbook">
                        <div class="card-body quiz-type">
                            <div class="clear" style="margin-bottom: 100px;">
                                <ul>
                                    <li><span class="q-textbold">문제 유형</span></li>
                                    <li>
                                        <input type='checkbox' name='type' id="type01" value='1' />
                                        <label for="type01" class="cb"></label> 객관식</li>
                                    <li><input type='checkbox' name='type' id="type02" value='2' />
                                        <label for="type02" class="cb"></label> 주관식</li>
                                    <li><input type='checkbox' name='type' id="type03" value='3' />
                                        <label for="type03" class="cb"></label> 단답형</li>
                                </ul>
                                <ul>
                                    <li><span class="q-textbold">답변</span></li>
                                    <li><input type='checkbox' name='subject' value='eng' id="sub01" />
                                        <label for="sub01" class="cb"></label> 영어</li>
                                    <li><input type='checkbox' name='subject' value='kor' id="sub02" />
                                        <label for="sub02" class="cb"></label> 한국어</li>
                                </ul>
                            </div>
                            <div>
                                <span class="q-textbold">문제수 제한</span>
                                <div class="q-count">
                                    <span class="q-textline">50</span>문제 (전체 <span>200</span> 문제)
                                </div>
                            </div>
                        </div>
                        <input type='submit' class="submit-btn" value="테스트 만들기">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- / Content -->
<!--
    <div class="buy-now">
      <a
        href="https://themeselection.com/products/sneat-bootstrap-html-admin-template/"
        target="_blank"
        class="btn btn-danger btn-buy-now"
        >Upgrade to Pro</a
      >
    </div>
-->
<!-- Core JS -->
<!-- build:js assets/vendor/js/core.js -->
<script src="/assets/vendor/libs/jquery/jquery.js"></script>
<script src="/assets/vendor/libs/popper/popper.js"></script>
<script src="/assets/vendor/js/bootstrap.js"></script>
<script src="/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>

<script src="/assets/vendor/js/menu.js"></script>
<!-- endbuild -->

<!-- Vendors JS -->

<!-- Main JS -->
<script src="/assets/js/main.js"></script>

<!-- Page JS -->
<script>
    $(document).ready( function() {
        $( 'label.cb' ).click( function() {
            $(this).toggleClass( 'chked' );
        });
    });
</script>


<!-- Place this tag in your head or just before your close body tag. -->
<script async defer src="https://buttons.github.io/buttons.js"></script>
</body>
</html>
