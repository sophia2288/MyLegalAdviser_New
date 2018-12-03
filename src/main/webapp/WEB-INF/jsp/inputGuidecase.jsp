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

    <script type="text/javascript">
        function doc_AutoComplete() {
            var fileObj = document.getElementById("uploadFile").files[0];
            var formFile = new FormData();
            formFile.append("wordfile", fileObj);

            $.ajax({
                type: "post",
                url: "ajaxTestA",
                data: formFile,
                async: true,
                dataType: "json",
                cache: false,
                processData: false,
                contentType: false,
                success: function (data) {
                    $("#source").val(data.source);
                    $("#caseNo").val(data.caseNo);
                    $("#court").val(data.court);
                    $("#category").val(data.category);
                    $("#litigant").val(data.litigant);
                    $("#litigant").attr("title", "");
                    $("#brief").val(data.brief);
                    $("#title").val(data.title);
                    $("#title").attr("title", "");
                    $("#judge").val(data.judge);
                    $("#judge").attr("title", "");
                    $("#judgeDate").val(data.judgeDate);
                    $("#judgeDate").datepicker("setDate", data.judgeDate);//设置日历控件的日期
                    $("input[name='proceeding']").val([data.proceeding]);
                    $("input[name='docCategory']").val([data.docCategory]);
                },
                error: function () {
                    alert("调用ajax向服务端发送请求出错！");
                }
            });
        }
    </script>
    <script type="text/javascript">
        function showFullText(tag) {
            var width = tag.size;
            var tagValue = tag.value;
            if (tagValue.length > width) {
                tag.title = tag.value;
            }
        }
    </script>
</head>

<body>
    <div class="container">
        <div class="row">
            <div class="col-sm-2"></div>
            <div class="col-sm-8 docInput">
                <form:form commandName="guidecase" action="saveGuidecase" method="post" enctype="multipart/form-data"
                    class="form-horizontal">
                    <div class="row">
                        <div class="col-sm-12">
                            <h5 class="page-header text-center lead">指导性案例录入</h5>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="uploadFile" class="col-sm-3 control-label">选择指导案例</label>
                        <div class="col-sm-6">
                            <input type="file" id="uploadFile" name="file" accept="application/vnd.openxmlformats-officedocument.wordprocessingml.document"
                                onchange="guideCase_AutoComplete()">
                        </div>
                        <div class="col-sm-3"></div>
                    </div>
                    <div class="form-group required">
                        <label for="guideCaseNo" class="col-sm-3 control-label">编号</label>
                        <div class="col-sm-6">
                            <form:input class="form-control" id="guideCaseNo" path="guideCaseNo" placeholder="最高人民法院对指导案例所作的编号"
                                required="required" onmouseover="showFullText(this)" />
                        </div>
                        <div class="col-sm-3"></div>
                    </div>
                    <div class="form-group required">
                        <label for="title" class="col-sm-3 control-label">标题</label>
                        <div class="col-sm-6">
                            <form:input class="form-control" id="title" path="title" placeholder="示例：张三与李四民间借贷纠纷案"
                                required="required" onmouseover="showFullText(this)" />
                        </div>
                        <div class="col-sm-3"></div>
                    </div>
                    <div class="form-group required">
                        <label for="source" class="col-sm-3 control-label">来源</label>
                        <div class="col-sm-6">
                            <form:input class="form-control" id="source" path="source" value="最高人民法院网站" />
                        </div>
                        <div class="col-sm-3"></div>
                    </div>
                    <div class="form-group required">
                        <label for="brief" class="col-sm-3 control-label">案由</label>
                        <div class="col-sm-6">
                            <form:input class="form-control" id="brief" path="brief" placeholder="已启用输入提示功能" required="required"
                                autocomplete="off" />
                        </div>
                        <div class="col-sm-3"></div>
                    </div>
                    <div class="form-group required">
                        <label for="category" class="col-sm-3 control-label">案例类型</label>
                        <div class="col-sm-6">
                            <form:select id="category" path="category" class="form-control" required="required">
                                <form:option value="民商事" selected="selected">民商事</form:option>
                                <form:option value="刑事">刑事</form:option>
                                <form:option value="行政">行政</form:option>
                                <form:option value="执行">执行</form:option>
                            </form:select>
                        </div>
                        <div class="col-sm-3"></div>
                    </div>
                    <div class="form-group required">
                        <label for="judgeDate" class="col-sm-3 control-label">发布日期</label>
                        <div class="col-sm-6">
                            <div class="input-group">
                                <form:input class="form-control" id="pubDate" path="pubDate" aria-describedby="basic-addon2"
                                    required="required" />
                                <span class="input-group-addon" id="basic-addon2"> <i class="glyphicon glyphicon-calendar"></i>
                                </span>
                            </div>
                        </div>
                        <div class="col-sm-3"></div>
                    </div>
                    <div class="form-group">
                        <label for="keywords" class="col-sm-3 control-label">关键字</label>
                        <div class="col-sm-6">
                            <form:textarea class="form-control" id="keywords" path="keywords" placeholder="输入最能体现案例特征的关键字词"
                                rows="5" />
                        </div>
                        <div class="col-sm-3"></div>
                    </div>
                    <div class="form-group required">
                        <label for="abbrevation" class="col-sm-3 control-label">裁判要点</label>
                        <div class="col-sm-6">
                            <form:textarea class="form-control" id="abbrevation" path="abbrevation" rows="5" />
                        </div>
                        <div class="col-sm-3"></div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-4 col-sm-2">
                            <button type="reset" class="btn btn-default">重新填写</button>
                        </div>
                        <div>
                            <button type="submit" class="btn btn-info">保存案例</button>
                        </div>
                    </div>
                </form:form>
            </div>
            <div class="col-sm-2"></div>
        </div>
    </div>
    <script type="text/javascript" src="jquery/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="popper/popper.js"></script>
    <script type="text/javascript" src="bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="bootstrap-3.3.7/js/bootstrap-typeahead.js"></script>
    <script type="text/javascript" src="js/CaseBrief4.js"></script>
    <script type="text/javascript" src="bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
    <script type="text/javascript" src='bootstrap-datepicker/locales/bootstrap-datepicker.zh-CN.min.js'></script>
    <script type="text/javascript">
        $("#pubDate").datepicker({
            language: "zh-CN",
            autoclose: true,//选中之后自动隐藏日期选择框
            clearBtn: true,//清除按钮
            todayBtn: "linked",//今日按钮
            todayHighlight: true,
            format: "yyyy-mm-dd"//日期格式，详见 http://bootstrap-datepicker.readthedocs.org/en/release/options.html#format
        });
    </script>
</body>

</html>