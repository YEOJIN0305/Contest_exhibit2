<%@ page import="kopo.poly.dto.CmuDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kopo.poly.util.CmmUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<CmuDTO> cList = (List<CmuDTO>) request.getAttribute("cList");
    if (cList == null) {
        cList = new ArrayList<>();
    }
    CmuDTO rDTO = (CmuDTO) request.getAttribute("rDTO");
%>
<!DOCTYPE html>

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

    <title>게시판 상세정보</title>

    <meta name="description" content=""/>

    <!-- Favicon -->
    <link rel="icon" type="image/x-icon" href="/assets/img/icons/aducator/logo-main"/>

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
        h1 {
            margin: 0;
            padding: 0;
        }

        h1 > strong {
            padding-top: 10px;
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

        .btncmu {
            border: 2px solid gray;
            background-color: #ffffff;
            color: black;
        }

        h3 {
            margin: 0;
            padding: 0;
        }

        h3 > strong {
            padding-top: 10px;
        }

        .btnwr {
            border: 2px solid #407EC1;
            background-color: #ffffff;
            color: black;
        }

        .btncancle {
            background-color: #E73B67;
            color: black;
        }

        .btnok {
            background-color: #407EC1;
            color: black;
        }

        .btnback {
            background-color: gray;
            color: black;
        }



    </style>
</head>

<body style="background-color: #ffffff">
<!-- Layout wrapper -->
<div class="layout-wrapper layout-content-navbar"
     style="justify-content: center; align-items: center; align-content: center; text-align: center; align-self: center">
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
                    <a href="/mypage/myInfo" class="menu-link">
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
            <!-- Navbar -->

            <nav
                    class="layout-navbar container-xxl navbar navbar-expand-xl navbar-detached align-items-center bg-navbar-theme"
                    id="layout-navbar" style="height: 100px"
            >

                <div><h1><strong>게시글 상세정보</strong></h1></div>


                <div class="layout-menu-toggle navbar-nav align-items-xl-center me-3 me-xl-0 d-xl-none">
                    <a class="nav-item nav-link px-0 me-xl-4" href="javascript:void(0)">
                        <i class="bx bx-menu bx-sm"></i>
                    </a>
                </div>
            </nav>
            <br>
            <br>

            <div style="margin: 0 auto; max-width: calc(1440px - calc(1.625rem * 2)); width: calc(100% - (1.625rem * 2)); text-align: left">
                <h4><%=CmmUtil.nvl(rDTO.getTitle())%></h4>

                <div style="">작성자 : <%=CmmUtil.nvl(rDTO.getId())%></div>
                <hr>
                <div style="height: 200%">
                    <p>
                        <%=CmmUtil.nvl(rDTO.getContents())%>
                    </p>
                </div>
                <hr>
                <div style="float: left;">
                    <button class="btn btnback" onclick="location.href='Cmu_01'">뒤로</button>
                </div>
                <div style="float: right;">
                    <%=session.getAttribute("sessionNo")%>
                    <% if(rDTO.getUser_seq() == session.getId()) {%>
                    <button class="btn btnok" onclick="location.href='Cmu_04?no=<%=rDTO.getNotice_seq()%>'" style="margin-right: 15px">수정</button>
                    <% } %>
                    <button class="btn btncancle" onclick="location.href='CmuDelete?no=<%=rDTO.getNotice_seq()%>'">삭제</button>
                </div>
            </div>

</body>
</html>