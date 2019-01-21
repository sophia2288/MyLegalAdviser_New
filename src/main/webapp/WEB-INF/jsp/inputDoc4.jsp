<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Bootstrap -->
    <link rel="stylesheet" href="bootstrap-4.2.1-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="bootstrap-datepicker/css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="css/main2.css">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <title>裁判文书录入</title>

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
                <form:form commandName="doc" action="saveDoc" method="post" enctype="multipart/form-data" class="form-horizontal">
                    <div class="row">
                        <div class="col-sm-12">
                            <h5 class="page-header text-center lead">裁判文书录入</h5>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="uploadFile" class="col-sm-3 control-label">选择裁判文书</label>
                        <div class="col-sm-6">
                            <input type="file" id="uploadFile" name="file" accept="application/vnd.openxmlformats-officedocument.wordprocessingml.document"
                                onchange="doc_AutoComplete()">
                        </div>
                        <div class="col-sm-3"></div>
                    </div>
                    <div class="form-group required">
                        <label for="title" class="col-sm-3 control-label">案件名称</label>
                        <div class="col-sm-6">
                            <form:input class="form-control" id="title" path="title" placeholder="示例：张三与李四民间借贷纠纷"
                                required="required" onmouseover="showFullText(this)" />
                        </div>
                        <div class="col-sm-3"></div>
                    </div>
                    <div class="form-group">
                        <label for="source" class="col-sm-3 control-label">文书来源</label>
                        <div class="col-sm-6">
                            <form:input class="form-control" id="source" path="source" value="中国裁判文书网" />
                        </div>
                        <div class="col-sm-3"></div>
                    </div>
                    <div class="form-group required">
                        <label for="caseNo" class="col-sm-3 control-label">案号</label>
                        <div class="col-sm-6">
                            <form:input class="form-control" id="caseNo" path="caseNo" required="required" />
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
                        <label for="category" class="col-sm-3 control-label">案件类型</label>
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

                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-9">
                            <div class="checkbox">
                                <label>
                                    <form:checkbox id="isImportant" path="isImportant" />重要裁判文书
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group required">
                        <label for="docCategory" class="col-sm-3 control-label">文书类型</label>
                        <div class="col-sm-6">
                            <label class="radio-inline">
                                <form:radiobutton path="docCategory" value="判决书" checked="checked" />判决
                            </label> <label class="radio-inline">
                                <form:radiobutton path="docCategory" value="裁定书" />裁定
                            </label>
                        </div>
                        <div class="col-sm-3"></div>
                    </div>
                    <div class="form-group required">
                        <label for="proceeding" class="col-sm-3 control-label">诉讼程序</label>
                        <div class="col-sm-6">
                            <label class="radio-inline">
                                <form:radiobutton path="proceeding" value="一审" checked="checked" />一审
                            </label> <label class="radio-inline">
                                <form:radiobutton path="proceeding" value="二审" />二审
                            </label> <label class="radio-inline">
                                <form:radiobutton path="proceeding" value="再审" />再审
                            </label> <label class="radio-inline">
                                <form:radiobutton path="proceeding" value="特别程序" />特别程序
                            </label> <label class="radio-inline">
                                <form:radiobutton path="proceeding" value="执行" />执行
                            </label>
                        </div>
                        <div class="col-sm-3"></div>
                    </div>
                    <div class="form-group required">
                        <label for="court" class="col-sm-3 control-label">审理法院</label>
                        <div class="col-sm-6">
                            <form:input class="form-control" id="court" path="court.name" placeholder="法院名称" required="required" />
                        </div>
                        <%-- <div class="col-sm-2">
							<form:input class="form-control" id="court_C"
								path="court.courtCode" placeholder="法院代字" disabled="true" />
						</div> --%>
                        <div class="col-sm-3"></div>
                    </div>
                    <div class="form-group">
                        <label for="judge" class="col-sm-3 control-label">审判员</label>
                        <div class="col-sm-6">
                            <form:input class="form-control" id="judge" path="judge" placeholder="审判员之间用逗号隔开"
                                onmouseover="showFullText(this)" />
                        </div>
                        <div class="col-sm-3"></div>
                    </div>
                    <div class="form-group required">
                        <label for="judgeDate" class="col-sm-3 control-label">裁判日期</label>
                        <div class="col-sm-6">
                            <div class="input-group">
                                <form:input class="form-control" id="judgeDate" path="judgeDate" aria-describedby="basic-addon2"
                                    required="required" />
                                <span class="input-group-addon" id="basic-addon2"> <i class="glyphicon glyphicon-calendar"></i>
                                </span>
                            </div>
                        </div>
                        <div class="col-sm-3"></div>
                    </div>
                    <div class="form-group">
                        <label for="litigant" class="col-sm-3 control-label">当事人</label>
                        <div class="col-sm-6">
                            <form:input class="form-control" id="litigant" path="litigant" onmouseover="showFullText(this)" />
                        </div>
                        <div class="col-sm-3"></div>
                    </div>
                    <div class="form-group">
                        <label for="attorney" class="col-sm-3 control-label">诉讼代理人</label>
                        <div class="col-sm-6">
                            <form:input class="form-control" id="attorney" path="attorney" />
                        </div>
                        <div class="col-sm-3"></div>
                    </div>
                    <div class="form-group">
                        <label for="keywords" class="col-sm-3 control-label">关键字</label>
                        <div class="col-sm-6">
                            <form:textarea class="form-control" id="keywords" path="keywords" placeholder="输入最能体现案件特征的关键字词"
                                rows="5" />
                        </div>
                        <div class="col-sm-3"></div>
                    </div>
                    <div class="form-group">
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
                            <button type="submit" class="btn btn-info">保存文书</button>
                        </div>
                    </div>
                </form:form>
            </div>
            <div class="col-sm-2"></div>
        </div>
    </div>
    <script type="text/javascript" src="jquery/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="popper/popper.min.js"></script>
    <script type="text/javascript" src="bootstrap-4.2.1-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="bootstrap-4.2.1-dist/js/bootstrap-typeahead.js"></script>
    <script type="text/javascript" src="js/CaseBrief4.js"></script>
    <script type="text/javascript" src="bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
    <script type="text/javascript" src='bootstrap-datepicker/locales/bootstrap-datepicker.zh-CN.min.js'></script>
    <script type="text/javascript">
        $("#judgeDate").datepicker({
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