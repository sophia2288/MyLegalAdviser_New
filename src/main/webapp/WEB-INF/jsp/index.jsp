<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>指导性案例录入</title>

    <!-- Bootstrap -->
    <link href="bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="bootstrap-datepicker/css/bootstrap-datepicker.css" rel="stylesheet">
    <link href="css/main2.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
    <div class="navbar container topbox">
        <div class="navbar-inner">
            <div class="page-head">
                <div id="page-head-right">
                    <div id="main-login" class="pull-right"> <a id="" class="twi-btn-left" name="login" href="#"><span>登录</span></a><a
                            id="" class="twi-btn-right" name="register" href="#"><span>注册</span></a> </div>
                </div>
            </div>
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span>
                <span class="icon-bar"></span> <span class="icon-bar"></span> </a> <a class="brand" href="#"><img src="images/logo2.png" /></a>
            <div class="nav-collapse">
                <ul class="nav">
                    <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown"> 背单词 <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#">单词书</a></li>
                            <li><a href="#">单词量测试</a></li>
                        </ul>
                    </li>
                    <li class="dropdown"> <a class="main-menu dropdown-toggle" href="#" data-toggle="dropdown"> 炼句 <b
                                class="caret"></b> </a>
                        <ul class="dropdown-menu">
                            <li><a href="#">课程</a></li>
                            <li><a href="#">设置</a></li>
                            <li><a href="#">炼句计划</a></li>
                        </ul>
                    </li>
                    <li> <a class="main-menu" href="#">阅读</a> </li>
                    <li> <a class="main-menu" href="#">市场</a> </li>
                    <li class="dropdown"> <a class="dropdown-toggle" data-toggle="dropdown" href="#" url="/forum/">社区
                            <b class="caret"></b> </a>
                        <ul class="dropdown-menu">
                            <li><a href="#">小组</a></li>
                            <li><a href="#">论坛</a></li>
                            <li><a href="#">周刊</a></li>
                        </ul>
                    </li>
                </ul>
                <form class="navbar-search pull-left" action="">
                    <input type="text" class="search-query span2" placeholder="查词">
                    <span class="search-icon"></span>
                </form>
            </div>
        </div>
    </div>
</body>

</html>