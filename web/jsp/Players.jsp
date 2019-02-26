<%-- 
    Document   : Scores.jsp
    Created on : Feb 21, 2018, 09:14:23 AM
    Author     : Ba Phuc nguyen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Map"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="entity.Username"%>
<%@page import="logic.UsernameLogic"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 
Template Name: Metronic - Responsive Admin Dashboard Template build with Twitter Bootstrap 4
Author: KeenThemes
Website: http://www.keenthemes.com/
Contact: support@keenthemes.com
Follow: www.twitter.com/keenthemes
Dribbble: www.dribbble.com/keenthemes
Like: www.facebook.com/keenthemes
Purchase: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
Renew Support: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
License: You must have a valid license purchased only from themeforest(the above link) in order to legally use the theme for your project.
-->
<html lang="en">
    <!-- begin::Head -->

    <head>
        <meta charset="utf-8" />
        <title>Players Page</title>
        <meta name="description" content="Latest updates and statistic charts">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no">
        <!--begin::Web font -->
        <script src="https://ajax.googleapis.com/ajax/libs/webfont/1.6.16/webfont.js"></script>
        <script>
            WebFont.load({
                google: {"families": ["Poppins:300,400,500,600,700", "Roboto:300,400,500,600,700"]},
                active: function () {
                    sessionStorage.fonts = true;
                }
            });
        </script>
        <!--end::Web font -->
        <!--begin::Global Theme Styles -->
        <link href="style/vendors.bundle.css" rel="stylesheet" type="text/css" />
        <!--RTL version:<link href="assets/vendors/base/vendors.bundle.rtl.css" rel="stylesheet" type="text/css" />-->
        <link href="style/style.bundle.css" rel="stylesheet" type="text/css" />
        <!--RTL version:<link href="assets/demo/default/base/style.bundle.rtl.css" rel="stylesheet" type="text/css" />-->
        <!--end::Global Theme Styles -->
        <!--begin::Page Vendors Styles -->
        <!--RTL version:<link href="assets/vendors/custom/fullcalendar/fullcalendar.bundle.rtl.css" rel="stylesheet" type="text/css" />-->
        <!--end::Page Vendors Styles -->
    </head>
    <!-- end::Head -->
    <!-- begin::Body -->

    <body class="m-page--fluid m--skin- m-content--skin-light2 m-header--fixed m-header--fixed-mobile m-aside-left--enabled m-aside-left--skin-dark m-aside-left--fixed m-aside-left--offcanvas m-footer--push m-aside--offcanvas-default">
        <!-- begin:: Page -->
        <div class="m-grid m-grid--hor m-grid--root m-page">
            <!-- BEGIN: Header -->
            <header id="m_header" class="m-grid__item    m-header " m-minimize-offset="200" m-minimize-mobile-offset="200">
                <div class="m-container m-container--fluid m-container--full-height">
                    <div class="m-stack m-stack--ver m-stack--desktop">
                        <!-- BEGIN: Brand -->
                        <div class="m-stack__item m-brand  m-brand--skin-dark ">
                            <div class="m-stack m-stack--ver m-stack--general">
                                <div class="m-stack__item m-stack__item--middle m-brand__logo">

                                </div>
                                <div class="m-stack__item m-stack__item--middle m-brand__tools">
                                    <!-- BEGIN: Left Aside Minimize Toggle -->
                                    <a href="javascript:;" id="m_aside_left_minimize_toggle" class="m-brand__icon m-brand__toggler m-brand__toggler--left m--visible-desktop-inline-block  ">
                                        <span></span>
                                    </a>
                                    <!-- END -->
                                    <!-- BEGIN: Responsive Aside Left Menu Toggler -->
                                    <a href="javascript:;" id="m_aside_left_offcanvas_toggle" class="m-brand__icon m-brand__toggler m-brand__toggler--left m--visible-tablet-and-mobile-inline-block">
                                        <span></span>
                                    </a>
                                    <!-- END -->
                                    <!-- BEGIN: Responsive Header Menu Toggler -->
                                    <a id="m_aside_header_menu_mobile_toggle" href="javascript:;" class="m-brand__icon m-brand__toggler m--visible-tablet-and-mobile-inline-block">
                                        <span></span>
                                    </a>
                                    <!-- END -->
                                    <!-- BEGIN: Topbar Toggler -->
                                    <a id="m_aside_header_topbar_mobile_toggle" href="javascript:;" class="m-brand__icon m--visible-tablet-and-mobile-inline-block">
                                        <i class="flaticon-more"></i>
                                    </a>
                                    <!-- BEGIN: Topbar Toggler -->
                                </div>
                            </div>
                        </div>
                        <!-- END: Brand -->
                        <div class="m-stack__item m-stack__item--fluid m-header-head" id="m_header_nav">
                        </div>
                    </div>
                </div>
            </header>
            <!-- END: Header -->
            <!-- begin::Body -->
            <div class="m-grid__item m-grid__item--fluid m-grid m-grid--ver-desktop m-grid--desktop m-body">
                <!-- BEGIN: Left Aside -->
                <button class="m-aside-left-close  m-aside-left-close--skin-dark " id="m_aside_left_close_btn"><i class="la la-close"></i></button>
                <div id="m_aside_left" class="m-grid__item  m-aside-left  m-aside-left--skin-dark ">
                    <!-- BEGIN: Aside Menu -->
                    <div id="m_ver_menu" class="m-aside-menu  m-aside-menu--skin-dark m-aside-menu--submenu-skin-dark " m-menu-vertical="1" m-menu-scrollable="1" m-menu-dropdown-timeout="500" style="position: relative;">
                        <ul class="m-menu__nav  m-menu__nav--dropdown-submenu-arrow ">
                            <li class="m-menu__item" aria-haspopup="true"><a href="index" class="m-menu__link "><span class="m-menu__link-title"> <span class="m-menu__link-wrap"> <span class="m-menu__link-text">Home</span>
                                        </span></span></a></li>
                            <li class="m-menu__item " aria-haspopup="true"><a href="Usernames" class="m-menu__link "><span class="m-menu__link-title"> <span class="m-menu__link-wrap"> <span class="m-menu__link-text">Username</span>
                                        </span></span></a></li>
                            <li class="m-menu__item m-menu__item--active" aria-haspopup="true"><a href="Players" class="m-menu__link "><span class="m-menu__link-title"> <span class="m-menu__link-wrap"> <span class="m-menu__link-text">Player</span>
                                        </span></span></a></li>
                            <li class="m-menu__item " aria-haspopup="true"><a href="Scores" class="m-menu__link "><span class="m-menu__link-title"> <span class="m-menu__link-wrap"> <span class="m-menu__link-text">Score</span>
                                        </span></span></a></li>
                        </ul>
                    </div>
                    <!-- END: Aside Menu -->
                </div>
                <!-- END: Left Aside -->
                <div class="m-grid__item m-grid__item--fluid m-wrapper">
                    <!-- BEGIN: Subheader -->
                    <div class="m-subheader ">
                        <div class="d-flex align-items-center">
                            <div class="mr-auto">
                                <h3 class="m-subheader__title ">Players</h3>
                            </div>
                        </div>
                    </div>
                    <!-- END: Subheader -->
                    <div class="m-content">
                        <div class="row">

                            <div class="col-md-5">
                                <div class="m-portlet">
                                    <div class="m-portlet__head">
                                        <div class="m-portlet__head-caption">
                                            <div class="m-portlet__head-title">
                                                <h3 class="m-portlet__head-text">
                                                    Create new Player
                                                </h3>
                                            </div>
                                        </div>
                                    </div>
                                    <!--begin::Form-->
                                    <form class="m-form m-form--fit m-form--label-align-right" action="CreatePlayerServlet">
                                        <div class="m-portlet__body">

                                            <div class="form-group m-form__group ${idError != null ? 'has-danger' : ''} row">
                                                <label class="col-form-label col-lg-3 col-sm-12">Player ID</label>
                                                <div class="col-md-9 col-sm-12">
                                                    <div class="input-group date">
                                                        <input type="text" class="form-control m-input" name="id" placeholder="Enter player id"/>


                                                    </div>
                                                    <div class="form-control-feedback">${idError != null ? idError : ''}</div>

                                                </div>
                                            </div>

                                            <div class="form-group m-form__group ${fNerror != null ? 'has-danger' : ''}  row">
                                                <label class="col-form-label col-lg-3 col-sm-12">First Name</label>
                                                <div class=" col-md-9 col-sm-12">
                                                    <div class="input-group ">
                                                        <input type="text" class="form-control m-input" name="firstName" placeholder="Enter player"/>

                                                    </div>
                                                    <div class="form-control-feedback">${fNerror != null ? fNerror : ''}</div>
                                                </div>
                                            </div>

                                            <div class="form-group m-form__group ${lNerror != null ? 'has-danger' : ''}  row">
                                                <label class="col-form-label col-lg-3 col-sm-12">Last Name</label>
                                                <div class=" col-md-9 col-sm-12">
                                                    <div class="input-group ">
                                                        <input type="text" class="form-control m-input" name="lastName" placeholder="Enter player"/>

                                                    </div>
                                                    <div class="form-control-feedback">${lNerror != null ? lNerror : ''}</div>
                                                </div>
                                            </div>

                                            <div class="form-group m-form__group ${emailError != null ? 'has-danger' : ''}  row">
                                                <label class="col-form-label col-lg-3 col-sm-12">Email</label>
                                                <div class=" col-md-9 col-sm-12">
                                                    <div class="input-group ">
                                                        <input type="text" class="form-control m-input" name="email" placeholder="Enter player"/>

                                                    </div>
                                                    <div class="form-control-feedback">${emailError != null ? emailError : ''}</div>
                                                </div>
                                            </div>

                                            <div class="form-group m-form__group ${usernameError != null ? 'has-danger' : ''}  row">
                                                <label class="col-form-label col-lg-3 col-sm-12">Username</label>
                                                <div class=" col-md-9 col-sm-12">
                                                    <div class="input-group ">
                                                        <input type="text" class="form-control m-input" name="username" placeholder="Enter player"/>

                                                    </div>
                                                    <div class="form-control-feedback">${usernameError != null ? usernameError : ''}</div>
                                                </div>
                                            </div>

                                        </div>
                                        <div class="m-portlet__foot m-portlet__foot--fit">
                                            <div class="m-form__actions m-form__actions">
                                                <div class="row">
                                                    <div class="col-lg-9 ml-lg-auto">
                                                        <button type="submit" class="btn btn-brand">Submit</button>
                                                        <button type="reset" class="btn btn-secondary">Clear</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <c:choose>
                                            <c:when test="${not empty error}">
                                                <div class="alert alert-danger" role="alert">
                                                    <strong> ${error}</strong>  
                                                </div>
                                            </c:when>
                                            <c:when test="${not empty successMessage}">
                                                <div class="alert alert-success" role="alert">
                                                    <strong> ${successMessage}</strong>  
                                                </div>
                                            </c:when>
                                        </c:choose>
                                    </form>
                                    <!--end::Form-->
                                </div>
                            </div>
                            <div class="col-md-7">
                                <div class="m-portlet m-portlet--mobile ">
                                    <div class="m-portlet__head">
                                        <div class="m-portlet__head-caption">
                                            <div class="m-portlet__head-title">
                                                <h3 class="m-portlet__head-text">
                                                    Player's table
                                                </h3>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="m-portlet__body">
                                        <c:choose>
                                            <c:when test="${not empty updateError}">
                                                <div class="alert alert-danger" role="alert">
                                                    <strong> ${updateError}</strong>  
                                                </div>
                                            </c:when>
                                            <c:when test="${not empty updateSuccess}">
                                                <div class="alert alert-success" role="alert">
                                                    <strong> ${updateSuccess}</strong>  
                                                </div>
                                            </c:when>
                                            <c:when test="${not empty deleteError}">
                                                <div class="alert alert-danger" role="alert">
                                                    <strong> ${deleteError}</strong>  
                                                </div>
                                            </c:when>
                                            <c:when test="${not empty deleteSuccess}">
                                                <div class="alert alert-success" role="alert">
                                                    <strong> ${deleteSuccess}</strong>  
                                                </div>
                                            </c:when>
                                            <c:when test="${not empty searchError}">
                                                <div class="alert alert-danger" role="alert">
                                                    <strong> ${searchError}</strong>  
                                                </div>
                                            </c:when>
                                        </c:choose>

                                        <form class="m-form m-form--fit m-form--label-align-right" action="SearchPlayerServlet">
                                            <div class="m-portlet__body">

                                                <div class="form-group m-form__group row">
                                                    <label class="col-form-label col-lg-3 col-sm-12">Keyword</label>
                                                    <div class="col-md-9 col-sm-12">
                                                        <div class="input-group">
                                                            <input type="text" class="form-control m-input" id="keyword" name="keyword" placeholder="Enter to search..."/>
                                                        </div>


                                                    </div>
                                                </div>
                                                <div class="m-form__group form-group row">
                                                    <label class="col-3 col-form-label">Search by</label>
                                                    <div class="col-9">
                                                        <div class="m-radio-inline">
                                                            <label class="m-radio">
                                                                <input type="radio" name="columnToSearch" value="1" checked="checked" onclick="hideDate();"> Player ID
                                                                <span></span>
                                                            </label>
                                                            <label class="m-radio">
                                                                <input type="radio" name="columnToSearch" value="2" onclick="hideDate();"> First Name
                                                                <span></span>
                                                            </label>
                                                             <label class="m-radio">
                                                                <input type="radio" name="columnToSearch" value="3" onclick="hideDate();"> Last Name
                                                                <span></span>
                                                            </label>
                                                             <label class="m-radio">
                                                                <input type="radio" name="columnToSearch" value="4" onclick="hideDate();"> Email
                                                                <span></span>
                                                            </label>
                                                            <label class="m-radio">
                                                                <input type="radio" name="columnToSearch" value="5" onclick="showDate();"> Joined Date
                                                                <span></span>
                                                            </label>

                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group m-form__group row" id="date" style="display: none">
                                                    <label class="col-form-label col-lg-3 col-sm-12">Joined on</label>
                                                    <div class="col-md-9 col-sm-12">
                                                        <input type="date" class="form-control" id="submissionDate" name="date" >
                                                        <label class="m-radio">
                                                            <input type="radio" name="dateType" value="1"  > Before this date
                                                            <span></span>
                                                        </label>
                                                        <label class="m-radio">
                                                            <input type="radio" name="dateType" value="2"> After this date
                                                            <span></span>
                                                        </label>
                                                        <label class="m-radio">
                                                            <input type="radio" name="dateType" value="3" checked="checked"> On this date
                                                            <span></span>
                                                        </label>
                                                    </div>
                                                </div>
                                                <!--                                                <div class="m-form__group form-group row">
                                                                                                    <label class="col-3 col-form-label">Keyword option</label>
                                                                                                    <div class="col-9">
                                                                                                        <div class="m-radio-inline">
                                                                                                            <label class="m-radio">
                                                                                                                <input type="radio" name="type" value="1" > Matching
                                                                                                                <span></span>
                                                                                                            </label>
                                                                                                            <label class="m-radio">
                                                                                                                <input type="radio" name="type" value="2"> Containing
                                                                                                                <span></span>
                                                                                                            </label>
                                                                                                           
                                                                                                        </div>
                                                                                                    </div>
                                                                                                </div>-->

                                            </div>
                                            <div class="m-portlet__foot m-portlet__foot--fit">
                                                <div class="m-form__actions m-form__actions">
                                                    <div class="row">
                                                        <div class="col-lg-9 ml-lg-auto">
                                                            <button type="submit" class="btn btn-brand">Search</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>


                                        </form>

                                        <!--                                          <form class="m-form m-form--fit m-form--label-align-right" action="SearchUsernameServlet">
                                                                                      <div class="m-portlet__body">
                                                                                          <div class="form-group m-form__group">
                                                                                              <div class="input-group">
                                                                                                  <div class="input-group-prepend">
                                                                                                      <button class="btn btn-secondary" type="submit">Search!</button>
                                                                                                  </div>
                                                                                                  <input type="text" class="form-control" name="searchInput">
                                                                                                  <div class="input-group-append">
                                                                                                      <button class="btn btn-secondary" type="submit">Search!</button>
                                                                                                  </div>
                                                                                              </div>
                                                                                          </div>
                                                                                      </div>
                                                                                  </form>-->

                                        <table class="table table-striped- table-bordered table-hover table-checkable" id="m_table_1">
                                            <thead>
                                                <tr>
                                                    <th>Player ID</th>
                                                    <th>First Name</th>
                                                    <th>Last Name</th>
                                                    <th>Joined on</th>
                                                    <th>Email</th>
                                                    <th>Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${players}" var="player" varStatus="usernameIndex">
                                                    <tr>
                                                        <td>${player.id}</td>
                                                        <td>${player.firstName}</td>
                                                        <td>${player.lastName}</td>
                                                        <td>${player.joined}</td>
                                                        <td>${player.email}</td>
                                                        <td>
                                                            <div class="btn-group">


                                                                <button type="button" class="btn btn-outline-info" data-toggle="modal" data-target="#m_modal_update_${player.id}">Update</button>

                                                                <button type="button" class="btn btn-outline-danger" data-toggle="modal" data-target="#m_modal_${player.id}">Delete</button>

                                                            </div>
                                                            <div class="modal fade" id="m_modal_${player.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                                                                <div class="modal-dialog modal-dialog-centered" role="document">
                                                                    <div class="modal-content">
                                                                        <div class="modal-header">
                                                                            <h5 class="modal-title" id="exampleModalLongTitle">Delete a score</h5>
                                                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                                <span aria-hidden="true">&times;</span>
                                                                            </button>
                                                                        </div>
                                                                        <div class="modal-body">
                                                                            <p>Delete this player and their username, scores?</p>
                                                                        </div>
                                                                        <div class="modal-footer">
                                                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                                            <a href="DeletePlayerServlet?id=${player.id}" class="btn btn-danger">Delete</a>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="modal fade" id="m_modal_update_${player.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                                <div class="modal-dialog modal-lg" role="document">
                                                                    <div class="modal-content">
                                                                        <div class="modal-header">
                                                                            <h5 class="modal-title" id="exampleModalLabel">Update Player</h5>
                                                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                                <span aria-hidden="true">&times;</span>
                                                                            </button>
                                                                        </div>
                                                                        <form class="m-form m-form--fit m-form--label-align-right" action="UpdatePlayerServlet">
                                                                            <div class="modal-body">

                                                                                <div class="m-portlet__body">
                                                                                    <div class="form-group m-form__group row">
                                                                                        <label class="col-form-label col-lg-3 col-sm-12">Player ID</label>
                                                                                        <div class="col-lg-4 col-md-9 col-sm-12">
                                                                                            <div class="input-group date">
                                                                                                <input type="text" class="form-control m-input" name="id" value="${player.id}" readonly/>

                                                                                            </div>

                                                                                        </div>
                                                                                    </div>
                                                                                    <div class="form-group m-form__group row">
                                                                                        <label class="col-form-label col-lg-3 col-sm-12">First Name</label>
                                                                                        <div class="col-lg-4 col-md-9 col-sm-12">
                                                                                            <div class="input-group date">
                                                                                                <input type="text" class="form-control m-input" name="firstName" value="${player.firstName}"/>

                                                                                            </div>

                                                                                        </div>
                                                                                    </div>

                                                                                    <div class="form-group m-form__group row">
                                                                                        <label class="col-form-label col-lg-3 col-sm-12">Last Name</label>
                                                                                        <div class="col-lg-4 col-md-9 col-sm-12">
                                                                                            <div class="input-group ">
                                                                                                <input type="text" class="form-control m-input" name="lastName" value="${player.lastName}"/>

                                                                                            </div>
                                                                                        </div>
                                                                                    </div>
                                                                                                  <div class="form-group m-form__group row">
                                                                                        <label class="col-form-label col-lg-3 col-sm-12">Email</label>
                                                                                        <div class="col-lg-4 col-md-9 col-sm-12">
                                                                                            <div class="input-group ">
                                                                                                <input type="text" class="form-control m-input" name="email" value="${player.email}"/>

                                                                                            </div>
                                                                                        </div>
                                                                                    </div>

                                                                                </div>




                                                                            </div>
                                                                            <div class="modal-footer">
                                                                                <button type="reset" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                                                <button type="submit" class="btn btn-info" >Update</button>
                                                                            </div>
                                                                        </form>
                                                                    </div>
                                                                </div>
                                                            </div>


                                                        </td>


                                                    </c:forEach>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>

                        </div>

                    </div>
                </div>
            </div>
            <!-- end:: Body -->
            <!-- begin::Footer -->
            <footer class="m-grid__item     m-footer ">
                <div class="m-container m-container--fluid m-container--full-height m-page__container">
                    <div class="m-stack m-stack--flex-tablet-and-mobile m-stack--ver m-stack--desktop">
                        <div class="m-stack__item m-stack__item--left m-stack__item--middle m-stack__item--last">
                            <span class="m-footer__copyright">
                                2017 &copy; Metronic theme by <a href="https://keenthemes.com" class="m-link">Keenthemes</a>
                            </span>
                        </div>
                    </div>
                </div>
            </footer>
            <!-- end::Footer -->
        </div>
        <!-- end:: Page -->

        <!--begin::Global Theme Bundle -->
        <script src="style/vendors.bundle.js" type="text/javascript"></script>
        <script src="style/scripts.bundle.js" type="text/javascript"></script>
        <script>
                                                                    function showDate() {
                                                                        document.getElementById('date').style.display = '';
                                                                        document.getElementById('keyword').disabled = true;
                                                                    }
                                                                    function hideDate() {
                                                                        document.getElementById('keyword').disabled = false;
                                                                        document.getElementById('date').style.display = 'none';
                                                                    }
        </script>
        <!--end::Global Theme Bundle -->
        <!--begin::Page Vendors -->
        <!--end::Page Vendors -->
        <!--begin::Page Scripts -->
        <!--end::Page Scripts -->
    </body>
    <!-- end::Body -->

</html>