<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>创建用户</title>
    <!-- Bootstrap -->
    <link href="bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
    <div class="container">
        <div class="row">
        	<div class="col-md-2">
            </div>
            <div class="col-md-8">
				<div class="row">
					<div class="col-md-12">
						<h4  class="text-center lead">用户注册</h4>
					</div>
				</div>
				<div class="row">
                    <div class="col-md-2">
                    </div>
                    <div class="col-md-8">
                        <form:form commandName="user" action="saveUser" method="post" class="form-horizontal">
                            <div class="form-group required">
                                <label for="account" class="col-sm-2 control-label">用户名</label>
                                <div class="col-sm-10">
                                	<form:input class="form-control" id="account" path="account" required="required" placeholder="用户名" autocomplete="off"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password" class="col-sm-2 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;码</label>
                                <div class="col-sm-10">
                                	<form:password class="form-control" id="password" path="password" placeholder="密码" autocomplete="off"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="category" class="col-sm-2 control-label">用户类别</label>
                                <div class="col-sm-10">
									<form:select id="category" path="category" class="form-control">
										<form:option value="普通用户" selected="selected">普通用户</form:option>
										<form:option value="律师">律师</form:option>
										<form:option value="公检法工作人员">公检法工作人员</form:option>
										<form:option value="高校教师">高校教师</form:option>
										<form:option value="其他">其他</form:option>
									</form:select>
								</div>
                            </div>
                            <div class="form-group">
                                <label for="phone" class="col-sm-2 control-label">联系电话</label>
                                <div class="col-sm-10">
                                	<form:input class="form-control" id="phone" path="phone" placeholder="联系电话"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="email" class="col-sm-2 control-label">Email</label>
                                <div class="col-sm-10">
                                	<form:input class="form-control" id="email" path="email" placeholder="someone@example.com"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="concerns" class="col-sm-2 control-label">兴趣项目</label>
                                <div class="col-sm-10">
                                	<form:textarea class="form-control" id="concerns" path="concerns" rows="5" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox">我已阅读并遵守服务条款
                                        </label>
                                    </div>
                                </div>
                            </div>
							<div class="form-group">
								<div class="col-sm-offset-4 col-sm-4">
                                    <button type="reset" class="btn btn-secondary">重新填写</button>
                                </div>
                                <div>
                                    <button type="submit" class="btn btn-success">注册用户</button>
                                </div>
                            </div>
                        </form:form>
                    </div>
                    <div class="col-md-2">
                    </div>
                </div>
            </div>
            <div class="col-md-2">
            </div>
        </div>
        <footer>
            <div class="row">
            </div>
            <div class="Copyright text-center">
                Copyright &copy; 2009-2018 Wuhongxing, all rights reserved.
            </div>
        </footer>
    </div>
    <script type="text/javascript" src="jquery/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="popper/popper.js"></script>
    <script type="text/javascript" src="bootstrap-3.3.7/js/bootstrap.min.js"></script>
</body>

</html>