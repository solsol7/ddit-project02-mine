/**
 * 
 */
//관광지 정보
$.tourismInfo = function(trNo){
	
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
			
		}// error 끝
	})// ajax끝
}

//관광지 추가
$.tourismChoice = function(trNo, trName){
	
	num = $('.content_wrap div[style="display:block"]').attr('data-no');
	
	$('.content_wrap div[style="display:block"] #schedule_list')
			.append('<input type="hidden" name="scDtTour" value="'+num+'-'+trNo+'">'+
					'<li class="selectedSchedule">'+trName+
					'<button type="button" class="trRemoveBtn" id="remove_schedule_list">삭제</button>'+
					'</li>');
}


// 검색
$.search = function(cpage){
	$.ajax({
		url : `${mypath}/searchSchedule.do`,
		data : {
			"sword" : sword,
			"cpage" : cpage
			},
		type : 'get',
		
		success : function(res){
			code = "<ul>";
			
			$.each(res.list, function(i,v){
				code += `<li class="tourismChoice">
							<div class="search_tr_name" id="${v.tr_no}">${v.tr_name}</div>
							<button type="button" class="trChoiceBtn">추가</button>
						</li>`;
			});//반복문 끝
			code += "</ul>";
			
			$.pageList(res.sp, res.ep, res.tp, res.size)
			
			$('.sch_list').html(code);
			$('#pager').html(pager);
			
		},//success 끝
		error : function(xhr){
			
			
			
			
			
			
			
			
		}//error 끝
	})//ajax 끝
}//$.search 끝

// DAY버튼
$.dayChoice = function(target){
	id = $('#tab_day_list .on').attr('id');
	$('#tab_day_list .on').removeClass('on');
	
	$('#'+target).addClass('on');
	
	$('.content_wrap .'+id).attr('style','display:none');
	$('.content_wrap .'+target).attr('style','display:block');
}

//초기페이지
$.startPage = function(sc_no, scSdate, scEdate){
	scNo = sc_no;
	
	alert(scNo);
	
	sdate = new Date(scSdate).getTime()
	edate = new Date(scEdate).getTime()

	tdate = (edate-sdate)/(1000*60*60*24)+1;
	dayList = "";
	content=`<input type="hidden" name="scNo" value=${scNo}>`;
	for(i=1; i<=tdate; i++){
		dayList += `<li class="dayInfo" id="dayInfo${i}">DAY${i}</li>`;
		content += `<div class ="tabcontent dayInfo${i}" data-no="${i}" style="display:none">
						<ul id="schedule_list"></ul>
					</div>`;
	}
	
	$('#tab_day_list').html(dayList);
	
	$('.dayInfo').first().addClass('on');

	$('.content_wrap').html(content);
	
	$('.content_wrap .dayInfo1').attr('style','display:block');
	
	
}

// 초기 페이지
/*$.startPage = function(){
	
	$.ajax({
		url : `${mypath}/scheduleTest.do`,
//		선영언니 서블릿이름으로 바꿔야함!!
		type : 'get',
		
		dateType : 'json',
		success : function(res){
			alert(res.sc_edate);
			scNo = res.sc_no;
			sdate = new Date(res.sc_sdate).getTime();
			edate = new Date(res.sc_edate).getTime();
	
			tdate = (edate-sdate)/(1000*60*60*24)+1;
		
			dayList = "";
			content='<input type="hidden" name="scNo" value=${scNo}>';
			for(i=1; i<=tdate; i++){
				dayList += `<li class="dayInfo" id="dayInfo${i}">DAY${i}</li>`;
				content += `<div class ="tabcontent dayInfo${i}" style="display:none">
							<ul id="schedule_list">
								<input type="hidden" name="dayInfo" value=${i}>
							</ul>
							</div>`;
			}
			
			pager = $.pageList(res.sp, res.ep, res.tp, res.size);
			
			$('#tab_day_list').html(dayList);
			
			$('.dayInfo').first().addClass('on');
		
			$('.content_wrap').html(content);
			$('.content_wrap .dayInfo1').attr('style','display:block');
			
			$('#pager').html(pager);
			
			
		},
		error : function(xhr){
			alert("상태 : "+xhr.status);
		}
		
		
	})// ajax끝
	
}*/

// 페이지 출력
$.pageList = function(sp, ep, tp, size){
	pager = `<div class="pagination">`;
	
	if(sp>size) pager +=`<div class="page_control_prev">
       						 <a href="#" class="btn_end first" id="prevBtn"></a>
   						 </div>`;
	
	pager += `<ol>`;
	for(i=sp; i<=ep; i++){
		if(i==currentPage){
			pager += ` <li class="on">
            			<a href="#" class="pageno">${i}</a>
      					  </li>`;
		}else{
			pager += `<li>
            			<a href="#" class="pageno">${i}</a>
      				  </li>`;
		}
	}
	pager += `</ol>`;
	
	if(ep<tp) pager += `<div class="page_control_next">
     					   <a href="#" class="btn_end last" id="nextBtn"></a>
  						  </div>`;
	pager += `</div>`;
	
	return pager;
}