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
    <title>裁判文书录入</title>
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
    
    <script type="text/javascript">
		function doc_AutoComplete() {
			var fileObj = document.getElementById("uploadFile").files[0];
			var formFile = new FormData();
			formFile.append("wordfile", fileObj);

			$.ajax({
				type : "post",
				url : "ajaxTestA",
				data : formFile,
				async : true,
				dataType : "json",
				cache : false,
				processData : false,
				contentType : false,
				success : function(data) {
					$("#source").val(data.source);
					$("#caseNo").val(data.caseNo);
					$("#court").val(data.court);
					$("#category").val(data.category);
					$("#litigant").val(data.litigant);
					$("#brief").val(data.brief);
					$("#title").val(data.title);
				},
				error : function() {
					alert("调用ajax向服务端发送请求出错啦！");
				}
			});
		}
	</script>
</head>

<body>
	<div class="container">
        <div class="row">
        	<div class="col-md-2">
            </div>
            <div class="col-md-8">
				<div class="row">
                    <div class="col-md-2">
                    </div>
                    <div class="col-md-8">
                    	<div class="row">
                    		<div class="col-sm-12">
                    			<h3 class="page-header text-right lead">裁判文书录入</h3>
                    		</div>
                    	</div>
                        <form:form commandName="doc" action="saveDoc" method="post" enctype="multipart/form-data" class="form-horizontal">
                            <div class="form-group">
                            	<label for="uploadFile" class="col-sm-3 control-label">选裁判文书</label>
                                <div class="col-sm-9">
                                	<input type="file" id="uploadFile" name="file" accept="application/vnd.openxmlformats-officedocument.wordprocessingml.document" onchange="doc_AutoComplete()">
                                </div>
                            </div>
                            <div class="form-group required">
                                <label for="title" class="col-sm-3 control-label">案件名称</label>
                                <div class="col-sm-9">
                                	<form:input class="form-control" id="title" path="title" placeholder="示例：张三与李四民间借贷纠纷" required="required"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="source" class="col-sm-3 control-label">文书来源</label>
                                <div class="col-sm-9">
                                	<form:input class="form-control" id="source" path="source" value="中国裁判文书网"/>
                                </div>
                            </div>
                            <div class="form-group required">
                                <label for="caseNo" class="col-sm-3 control-label">案号</label>
                                <div class="col-sm-9">
                                	<form:input class="form-control" id="caseNo" path="caseNo" required="required"/>
                                </div>
                            </div>
                            <div class="form-group required">
                                <label for="brief" class="col-sm-3 control-label">案由</label>
                                <div class="col-sm-9">
                                	<form:input class="form-control" id="brief" path="brief" placeholder="已启用输入提示功能" required="required" autocomplete="off"/>
                                </div>
                            </div>
                            <div class="form-group required">
                                <label for="category" class="col-sm-3 control-label">案件类型</label>
                                <div class="col-sm-9">
									<form:select id="category" path="category" class="form-control" required="required">
										<form:option value="民商事" selected="selected">民商事</form:option>
										<form:option value="刑事">刑事</form:option>
										<form:option value="行政">行政</form:option>
										<form:option value="执行">执行</form:option>
									</form:select>
								</div>
                            </div>
                            <div class="form-group">
                                <label for="caseclass" class="col-sm-3 control-label">案件子类型</label>
                                <div class="col-sm-9">
                                	<form:input class="form-control" id="caseclass" path="caseclass.classId"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-9">
                                    <div class="checkbox">
                                        <label>
                                        	<form:checkbox id="isImportant" path="isImportant"/>重要裁判文书
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group required">
                                <label for="docCategory" class="col-sm-3 control-label">文书类型</label>
                                <div class="col-sm-9">
									<label class="radio-inline">
										<form:radiobutton path="docCategory" value="判决" checked="checked"/>判决
									</label>
									<label class="radio-inline">
										<form:radiobutton path="docCategory" value="裁定"/>裁定
									</label>
                                </div>
                            </div>
                            <div class="form-group required">
                                <label for="proceeding" class="col-sm-3 control-label">诉讼程序</label>
                                <div class="col-sm-9">
									<label class="radio-inline">
										<form:radiobutton path="proceeding" value="一审" checked="checked"/>一审
									</label>
									<label class="radio-inline">
										<form:radiobutton path="proceeding" value="二审"/>二审
									</label>
									<label class="radio-inline">
										<form:radiobutton path="proceeding" value="再审"/>再审
									</label>
									<label class="radio-inline">
										<form:radiobutton path="proceeding" value="特别程序"/>特别程序
									</label>
									<label class="radio-inline">
										<form:radiobutton path="proceeding" value="执行"/>执行
									</label>
                                </div>
                            </div>
                            <div class="form-group required">
                                <label for="court" class="col-sm-3 control-label">审理法院</label>
                                <div class="col-sm-9">
                                	<form:input class="form-control" id="court" path="court.courtCode" required="required"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="judge" class="col-sm-3 control-label">审判员</label>
                                <div class="col-sm-9">
                                	<form:input class="form-control" id="judge" path="judge" placeholder="审判员之间用逗号隔开"/>
                                </div>
                            </div>
                            <div class="form-group required">
                                <label for="judgeDate" class="col-sm-3 control-label">裁判日期</label>
                                <div class="col-sm-9">
									<div class="input-group">
										<form:input class="form-control" id="judgeDate" path="judgeDate" aria-describedby="basic-addon2" required="required"/> 
										<span class="input-group-addon" id="basic-addon2">
											<i class="glyphicon glyphicon-th"></i>
										</span>
									</div>
								</div>
                            </div>
							<div class="form-group">
                                <label for="litigant" class="col-sm-3 control-label">当事人</label>
                                <div class="col-sm-9">
                                	<form:input class="form-control" id="litigant" path="litigant"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="attorney" class="col-sm-3 control-label">诉讼代理人</label>
                                <div class="col-sm-9">
                                	<form:input class="form-control" id="attorney" path="attorney"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="keywords" class="col-sm-3 control-label">关键字</label>
                                <div class="col-sm-9">
                                	<form:textarea class="form-control" id="keywords" path="keywords" placeholder="输入最能体现案件特征的关键字词" rows="5" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="abbrevation" class="col-sm-3 control-label">裁判要点</label>
                                <div class="col-sm-9">
                                	<form:textarea class="form-control" id="abbrevation" path="abbrevation" rows="5" />
                                </div>
                            </div>
                            
                            <div class="form-group required">
                                <label for="fullPathName" class="col-sm-3 control-label">保存路径</label>
                                <div class="col-sm-9">
                                	<form:input class="form-control" id="fullPathName" path="fullPathName" readonly="true"/>
                                </div>
                            </div>
                            
							<div class="form-group">
								<div class="col-sm-offset-5 col-sm-3">
                                    <button type="reset" class="btn btn-default">重新填写</button>
                                </div>
                                <div>
                                    <button type="submit" class="btn btn-info">保存文书</button>
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
    <script type="text/javascript" src="bootstrap-3.3.7/js/bootstrap-typeahead.js"></script>
    <script type="text/javascript" src="js/CaseBrief4.js"></script>
    <script type="text/javascript" src="bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript" src='bootstrap-datepicker/locales/bootstrap-datepicker.zh-CN.min.js'></script>
	<script type="text/javascript">
		$("#judgeDate").datepicker({
			language : "zh-CN",
			autoclose : true,//选中之后自动隐藏日期选择框
			clearBtn : true,//清除按钮
			todayBtn : "linked",//今日按钮
			todayHighlight : true,
			format : "yyyy-MM-dd"//日期格式，详见 http://bootstrap-datepicker.readthedocs.org/en/release/options.html#format
		});
	</script>
</body>
</html>