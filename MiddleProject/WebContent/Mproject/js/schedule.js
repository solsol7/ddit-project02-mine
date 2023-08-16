$.scheduleList = function(){
	
	$.ajax({
		url : `${mypath}/scheduleList.do`,
		type : 'get',
		dataType : 'json',
		success : function(res){
			code = `<ul class="bbsList">`;
			
			$.each(res, function(i, v){
				code += `<li><span class="date">${v.sc_sdate}<br>~<br>${v.sc_edate}</span> 
						<a href="#" class="subject">${v.sc_title}</a></li>`;
			});
			
			code += `</ul>`;
			
			$('#showList').html(code);

		},
		error : function(xhr){
			alert("상태 : " + xhr.status);
		}		
		
	});
}

//----------------------------------------------------------------------------------------------------

$.scheduleWrite = function(){
	
	$.ajax({
		url : `${mypath}/schedultWrite.do`,
		type : 'post',
		data : {
			"scName" : scName,
			"sDate" : sDate,
			"eDate" : eDate,
			},
		dataType : 'json',
		success : function(res){
			
			location.href = `${mypath}/Mproject/jsp/insertSchedule.jsp`;
			
		},
		error : function(xhr){
			alert("나거든 상태 : " + xhr.status);
		}
	});
}