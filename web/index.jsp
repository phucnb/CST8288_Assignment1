<%-- 
    Document   : index
    Created on : 22-Feb-2019, 3:29:37 PM
    Author     : baphucnguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>



<%@page import="java.util.Map"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="entity.Username"%>
<%@page import="logic.UsernameLogic"%>
<!DOCTYPE html>
<%-- 
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
--%>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <title>Ba Phuc Nguyen | CST8288 - Assignment 1</title>
        <meta name="description" content="Latest updates and statistic charts">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no">
        <script src="https://ajax.googleapis.com/ajax/libs/webfont/1.6.16/webfont.js"></script>
        <script>
            WebFont.load({
                google: {"families": ["Poppins:300,400,500,600,700", "Roboto:300,400,500,600,700"]},
                active: function () {
                    sessionStorage.fonts = true;
                }
            });
        </script>
        <link href="style/vendors.bundle.css" rel="stylesheet" type="text/css" />
        <link href="style/style.bundle.css" rel="stylesheet" type="text/css" />
    </head>

    <body class="m-page--fluid m--skin- m-content--skin-light2 m-header--fixed m-header--fixed-mobile m-aside-left--enabled m-aside-left--skin-dark m-aside-left--fixed m-aside-left--offcanvas m-footer--push m-aside--offcanvas-default">
        <div class="m-grid m-grid--hor m-grid--root m-page">
            <header id="m_header" class="m-grid__item    m-header " m-minimize-offset="200" m-minimize-mobile-offset="200">
                <div class="m-container m-container--fluid m-container--full-height">
                    <div class="m-stack m-stack--ver m-stack--desktop">
                        <div class="m-stack__item m-brand  m-brand--skin-dark ">
                            <div class="m-stack m-stack--ver m-stack--general">
                                <div class="m-stack__item m-stack__item--middle m-brand__logo">
                                    <a href="index.html" class="m-brand__logo-wrapper">
                                        <img alt="" src="assets/demo/default/media/img/logo/logo_default_dark.png" />
                                    </a>
                                </div>
                                <div class="m-stack__item m-stack__item--middle m-brand__tools">
                                    <a href="javascript:;" id="m_aside_left_minimize_toggle" class="m-brand__icon m-brand__toggler m-brand__toggler--left m--visible-desktop-inline-block  ">
                                        <span></span>
                                    </a>
                                    <a href="javascript:;" id="m_aside_left_offcanvas_toggle" class="m-brand__icon m-brand__toggler m-brand__toggler--left m--visible-tablet-and-mobile-inline-block">
                                        <span></span>
                                    </a>
                                    <a id="m_aside_header_menu_mobile_toggle" href="javascript:;" class="m-brand__icon m-brand__toggler m--visible-tablet-and-mobile-inline-block">
                                        <span></span>
                                    </a>
                                    <a id="m_aside_header_topbar_mobile_toggle" href="javascript:;" class="m-brand__icon m--visible-tablet-and-mobile-inline-block">
                                        <i class="flaticon-more"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="m-stack__item m-stack__item--fluid m-header-head" id="m_header_nav">
                        </div>
                    </div>
                </div>
            </header>
            <div class="m-grid__item m-grid__item--fluid m-grid m-grid--ver-desktop m-grid--desktop m-body">
                <button class="m-aside-left-close  m-aside-left-close--skin-dark " id="m_aside_left_close_btn"><i class="la la-close"></i></button>
                <div id="m_aside_left" class="m-grid__item  m-aside-left  m-aside-left--skin-dark ">
                    <div id="m_ver_menu" class="m-aside-menu  m-aside-menu--skin-dark m-aside-menu--submenu-skin-dark " m-menu-vertical="1" m-menu-scrollable="1" m-menu-dropdown-timeout="500" style="position: relative;">
                        <ul class="m-menu__nav  m-menu__nav--dropdown-submenu-arrow ">
                            <li class="m-menu__item m-menu__item--active" aria-haspopup="true"><a href="index" class="m-menu__link "><span class="m-menu__link-title"> <span class="m-menu__link-wrap"> <span class="m-menu__link-text">Home</span>
                                        </span></span></a></li>
                            <li class="m-menu__item " aria-haspopup="true"><a href="Usernames" class="m-menu__link "><span class="m-menu__link-title"> <span class="m-menu__link-wrap"> <span class="m-menu__link-text">Username</span>
                                        </span></span></a></li>
                            <li class="m-menu__item" aria-haspopup="true"><a href="Players" class="m-menu__link "><span class="m-menu__link-title"> <span class="m-menu__link-wrap"> <span class="m-menu__link-text">Player</span>
                                        </span></span></a></li>
                            <li class="m-menu__item" aria-haspopup="true"><a href="Scores" class="m-menu__link "><span class="m-menu__link-title"> <span class="m-menu__link-wrap"> <span class="m-menu__link-text">Score</span>
                                        </span></span></a></li>
                        </ul>
                    </div>
                </div>
                <div class="m-grid__item m-grid__item--fluid m-wrapper">
                    <div class="m-subheader ">
                        <div class="d-flex align-items-center">
                            <div class="mr-auto">
                                <h3 class="m-subheader__title ">Username</h3>
                            </div>
                        </div>
                    </div>
                    <div class="m-content">
                        <div class="m-portlet m-portlet--mobile">

                            <div class="m-portlet__body">
                                <h3>Homepage</h3>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
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
        </div>
        <div id="m_scroll_top" class="m-scroll-top">
            <i class="la la-arrow-up"></i>
        </div>
        <script src="style/vendors.bundle.js" type="text/javascript"></script>
        <script src="style/scripts.bundle.js" type="text/javascript"></script>
    </body>
</html>