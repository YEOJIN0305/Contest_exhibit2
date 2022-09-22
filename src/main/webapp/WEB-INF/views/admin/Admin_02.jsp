<%@ page import="java.util.List" %>
<%@ page import="kopo.poly.dto.UserInfoDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<UserInfoDTO> uList = (List<UserInfoDTO>) request.getAttribute("uList");
%>
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
            width: 150px;
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
            width:100%;
            float: left;
        }
        ul > li:first-child {
            margin-bottom: 10px;
        }
        ul > li {
            font-size: 22px;
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

        .user-name {
            margin: 10px;
            font-size: 22px;
        }
        /** media query **/
        @media (min-width: 770px) {
            .pad-style {
                padding : 80px 100px;
            }
            .menu-link {
                justify-content: left;
            }
            .search-btn {
                float : right;
                width: 50%;
            }
            hr {
                clear: both;
            }
        }
        @media (max-width: 769px) {
            .pad-style {
                padding : 80px 30px;
            }
            .search-btn {
                width: 100%;
            }
        }
    </style>
</head>

<body>
<!-- Content -->
<div class="container-xxl">
    <header style="display: block; width: 100%; height: 50px;">
        <div style="margin-top: 20px;">
            <a href="/Admin_01"><img class="logo-side" src="/assets/img/icons/aducator/logo-side.png" alt="arrow-left"/></a>
        </div>
    </header>
    <div class="authentication-wrapper authentication-basic container-p-y">
        <div class="authentication-inner" style="width: 80%; max-width: 1300px;">
            <!-- Register -->
            <div class="card" style=" border-radius: 100px;">
                <div class="card-body pad-style">

                    <a class="menu-link">
                        <div class="wrapper">
                            <div class="circle">
                                <div class="circle2"></div>
                            </div>
                        </div>
                        <div data-i18n="Account Settings"><h3><strong>&nbsp;관리자</strong></h3></div>
                    </a>

                    <!-- search -->
                    <div class="card-body demo-vertical-spacing demo-only-element search-btn">
                        <div class="input-group input-group-merge w-30">
                            <span class="input-group-text" id="basic-addon-search31"><i class="bx bx-search"></i></span>
                            <input
                                    type="text"
                                    class="form-control"
                                    placeholder="회원 검색"
                            />
                        </div>
                    </div>

                    <hr style="border-bottom: 2px solid #d9dee3;">
                    <ul class="p-0 m-0">
                        <% for(int i=0; i < uList.size(); i++){ %>
                        <li class="d-flex mb-4 pb-1" style="border-bottom: 1px solid #d9dee3;">
                            <div class="user-name">
                                <a href="/admin/Admin_03?no=<%=uList.get(i).getUser_seq()%>"><%=uList.get(i).getUser_name()%></a>
                            </div>
                        </li>
                        <% } %>
                    </ul>
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
