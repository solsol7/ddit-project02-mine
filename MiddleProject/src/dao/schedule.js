$.scheduleList = function(){
	
	$.ajax({
		url : `${mypath}/scheduleList.do`,
		type : 'get',
		data : {"usersNo" : usersNo},
		dataType : 'json',
		success : function(res){
			code = `<ul class="bbsList">`;
			
			$.each(res, function(i, v){
				code += `<li><span class="date">${v.sc_sdate}<br>~<br>${v.sc_edate}</span> 
						<a href="#" id="${v.sc_no}" class="subject checkMySchedule">${v.sc_title}</a></li>`;
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
			"usersNo" : usersNo
			},
		dataType : 'json',
		success : function(res){
			alert(usersNo);
			location.href = `${mypath}/Mproject/jsp/insertSchedule.jsp`;
			
		},
		error : function(xhr){
			alert("나거든 상태 : " + xhr.status);
		}
	});
}

//----------------------------------------------------------------------------------------------------

$.detailScheduleList = function(){
	
	$.ajax({
		url : `${mypath}/checkMySchedule.do`,
		type : 'get',
		dataType : 'json',
		data : {"scNo" : scNo},
		success : function(res){
			
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);
		}		
		
	});
}

//----------------------------------------------------------------------------------------------------
//초기페이지
$.startPage = function(sc_no, maxDay){
	scNo = sc_no;
	dayList = ``;
	
	content='<input type="hidden" name="scNo" value=${scNo}>';
	for(i=1; i<=maxDay; i++){
		dayList += `<li class="dayInfo" id="dayInfo${i}">DAY${i}</li>`;
		content += `<div class ="tabcontent" style="display:none">
					<ul id="schedule_list">`;

					
		content += `</ul>
					</div>`;
	}
	
	$('#tab_day_list').html(dayList);
	
	$('.dayInfo').first().addClass('on');

	$('.content_wrap').html(content);
	$('.content_wrap .dayInfo1').attr('style','display:block');
		
}

//----------------------------------------------------------------------------------------------------
// DAY버튼
$.dayChoice = function(target){
	id = $('#tab_day_list .on').attr('id');
	$('#tab_day_list .on').removeClass('on');
	
	$('#'+target).addClass('on');
	
	$('.content_wrap .'+id).attr('style','display:none');
	$('.content_wrap .'+target).attr('style','display:block');
}


//관광지 정보 클릭 >> 지도
$.tourismInfoMap = function(trNo){
	
	$.ajax({
		url : `${mypath}/scheduleTourismInfo.do`,
		data : "trNo="+trNo,
		type : 'get',
		
		dataType : 'json',
		success : function(res){
			var container =document.getElementById('map');
			var options ={
				center : new kakao.maps.LatLng(res.tr_lat,res.tr_long),
				level :3
			};
		
			var map = new kakao.maps.Map(container ,options);
			
			// 마커가 표시될 위치입니다 
			var markerPosition  = new kakao.maps.LatLng(res.tr_lat,res.tr_long); 

			// 마커를 생성합니다
			var marker = new kakao.maps.Marker({
			    position: markerPosition
			});
		
			// 마커가 지도 위에 표시되도록 설정합니다
			marker.setMap(map);
		
			// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
			// marker.setMap(null);    
			
//			$(document).on('click',marker,function(){
//				alert('마커');
//			})
			
		},// success 끝
		error : function(xhr){
			alert("상태 : "+xhr.status)
		}// error 끝
	})// ajax끝
}