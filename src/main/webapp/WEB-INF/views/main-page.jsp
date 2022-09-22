<%@ page import="kopo.poly.dto.UserInfoDTO" %>
<%@ page import="kopo.poly.dto.NoticeDTO" %>
<%@ page import="kopo.poly.util.CmmUtil" %>
<%@ page import="kopo.poly.util.EncryptUtil" %>
<%@ page import="java.util.List" %>
<%@ page import="kopo.poly.dto.MemoDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  //UserInfoDTO uDTO = (UserInfoDTO) request.getAttribute("rDTO");
  List<NoticeDTO> rList = (List<NoticeDTO>)request.getAttribute("rList");
  List<MemoDTO> memoList = (List<MemoDTO>)request.getAttribute("memoList");
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
  class="light-style layout-menu-fixed"
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

    <title>Dashboard - Analytics | Sneat - Bootstrap 5 HTML Admin Template - Pro</title>

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

    <link rel="stylesheet" href="/assets/vendor/libs/apex-charts/apex-charts.css" />

    <!-- Page CSS -->

    <!-- Helpers -->
    <script src="/assets/vendor/js/helpers.js"></script>

    <!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
    <!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
    <script src="/assets/js/config.js"></script>

    <style>
      h3 {
        margin: 0;
        color: black !important;
      }
      img.logo-side {
        width: 150px;
        justify-content: center;
      }
      .category-icons {
        width : 30px;
        height: 30px;
        margin-right: 5px;
      }
      #layout-navbar {
        background: linear-gradient(to right, #62a6d3 0%, #8083b6 50%, #905a9e 100%);
      }
      .menu-link {
        justify-content: center;
        font-weight: 700;
      }
      ul.menu-inner li.menu-item  a div {
        line-height: 30px;
        font-size:20px;
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
          <!-- Navbar -->

          <nav
            class="layout-navbar container-xxl navbar navbar-expand-xl navbar-detached align-items-center bg-navbar-theme"
            id="layout-navbar"
          >
            <div class="layout-menu-toggle navbar-nav align-items-xl-center me-3 me-xl-0 d-xl-none">
              <a class="nav-item nav-link px-0 me-xl-4" href="javascript:void(0)">
                <i class="bx bx-menu bx-sm"></i>
              </a>
            </div>

            <div class="navbar-nav-right d-flex align-items-center" id="navbar-collapse">
              <ul class="navbar-nav flex-row align-items-center ms-auto">
                <!-- Place this tag where you want the button to render. -->
                <li class="nav-item lh-1 me-3">
                  <a>
                    <img class="category-icons" src="/assets/img/icons/aducator/picture.png" alt="picture">
                  </a>
                </li>
                <li class="nav-item navbar-dropdown dropdown-user dropdown">
                  <a class="nav-link dropdown-toggle hide-arrow" href="javascript:void(0);" data-bs-toggle="dropdown">
                    <div class="">
                      <img class="category-icons" src="/assets/img/icons/aducator/file.png" alt="file">
                    </div>
                  </a>
                </li>
                <!--/ User -->
              </ul>
            </div>
          </nav>

          <!-- / Navbar -->

          <!-- Content wrapper -->
          <div class="content-wrapper">
            <!-- Content -->

            <div class="container-xxl flex-grow-1 container-p-y">
              <div class="row">
                <div class="col-lg-8 mb-4 order-0" style="width: 50%;">
                  <div class="card">
                    <div class="d-flex align-items-end row">
                      <div class="col-sm-7" style="width: 100%;">
                        <div class="card-body">
                          <h5 class="card-title text-primary">커뮤니티/게시판</h5>
                          <hr style="border-bottom: 2px solid #d9dee3;">
                          <ul class="p-0 m-0">
                            <% for(int i=0; i < rList.size(); i++){ %>
                            <li class="d-flex mb-4 pb-1" style="border-bottom: 1px solid #d9dee3;">
                              <div class="d-flex w-100 flex-wrap align-items-center justify-content-between gap-2">
                                <div class="me-2">
                                  <h6 class="mb-0"><a href="/cmu/Cmu_03?no=<%=rList.get(i).getNotice_seq()%>"><%=rList.get(i).getTitle()%></a></h6>
                                  <small class="text-muted"><%=rList.get(i).getNotice_date().substring(0,19)%></small>
                                </div>
                                <div class="user-progress">
                                  <small class="fw-semibold"><%= rList.get(i).getUser_name()%></small>
                                </div>
                              </div>
                            </li>
                            <% } %>
                          </ul>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-lg-8 mb-4 order-0" style="width: 50%;">
                  <div class="card" style="min-height: 100%;">
                    <div class="d-flex align-items-end row">
                      <div class="col-sm-7" style="width: 100%;">
                        <div class="card-body">
                          <h5 class="card-title text-primary">오늘의 단어</h5>
                          <hr style="border-bottom: 2px solid #d9dee3;">
                          <ul class="p-0 m-0">
                            <% for(int i=0; i < memoList.size(); i++){ %>
                            <li class="d-flex mb-4 pb-1" style="border-bottom: 1px solid #d9dee3;">
                              <div class="d-flex w-100 flex-wrap align-items-center justify-content-between gap-2"
                              style="margin: 7px 0 10px;">
                                <div class="me-2">
                                  <h6 class="mb-0"><%= memoList.get(i).getTitle()%></h6>
                                </div>
                                <div class="user-progress">
                                  <small class="fw-semibold"><%= memoList.get(i).getContents()%></small>
                                </div>
                              </div>
                            </li>
                            <% } %>
                          </ul>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <!-- Total Revenue -->
                <div class="col-12 col-lg-8 order-2 order-md-3 order-lg-2 mb-4" style="width: 100%;">
                  <div class="card">
                    <div class="row row-bordered g-0">
                      <div class="col-md-8">
                        <h5 class="card-header m-0 me-2 pb-3">주간 공부량</h5>
                        <div id="totalRevenueChart" class="px-2"></div>
                      </div>
                      <div class="col-md-4">
                        <div class="card-body">
                          <div class="text-center">

                          </div>
                        </div>
                        <div id="growthChart"></div>
                        <div class="text-center fw-semibold pt-3 mb-2">
                          이번주는
                          <span>'Unit 1'</span>
                          위주로 공부했어요!
                        </div>

                        <div class="d-flex px-xxl-4 px-lg-2 p-4 gap-xxl-3 gap-lg-1 gap-3 justify-content-between">

                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <!--/ Total Revenue -->
                </div>
            </div>
            <!-- / Content -->



            <div class="content-backdrop fade"></div>
          </div>
          <!-- Content wrapper -->
        </div>
        <!-- / Layout page -->
      </div>

      <!-- Overlay -->
      <div class="layout-overlay layout-menu-toggle"></div>
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

    <!-- Place this tag in your head or just before your close body tag. -->
    <script async defer src="https://buttons.github.io/buttons.js"></script>
  </body>
</html>
