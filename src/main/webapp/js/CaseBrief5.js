$(document).ready(function() {
	$('#brief').typeahead({
		source : function(query, process) {
			return $.ajax({
				url : 'json/CaseBrief.json',
				type : 'get',
				dataType : 'json',
				data : {
					name : query
				},
				success : function(result) {
					return process(result);
				},
			});
		},
		items : 10, // 设置展示多少条--默认8条
	})
});