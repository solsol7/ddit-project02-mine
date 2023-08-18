/**
 * 
 */
// 좋아요 싫어요
$.updateGb = function(gb, rsNo){
	
	$.ajax({
		url : `${mypath}/restaurantGood.do`,
		type : 'get',
		data : {
			"rsNo" : rsNo,
			"gb" : gb
		},
		dataType : 'json',
		success : function(res){
			$('#good_num').text(res.rs_good);
			$('#bad_num').text(res.rs_bad);
		},
		error : function(xhr){
			alert("상태 : "+xhr.status)
		}
	});
	
}

// 맛집 상세 페이지 출력
$.restaurantDetail = function(rsNo){
	
	$.ajax({
		url : `${mypath}/restaurantDetail.do`,
		type : 'get',
		data : {"rsNo" : rsNo},
		
		dataType : 'json',
		success : function(res){
			code = "";
			
		},// success 끝
		error : function(xhr){
			alert("상태 : "+xhr.status)
		}// error 끝
	})// ajax 끝
}


// 맛집 리스트 출력
$.restaurantList = function(cpage){
	sword = $('#sword').val();

	$.ajax({
		url : `${mypath}/restaurant.do`,
		type : 'get',
		data : {"sword":sword,
				"cpage":cpage},
		
		dataType : 'json',
		success : function(res){
			code ="";
			$.each(res.list, function(i,v){
				code +=`<li>
					<a href="#" class="restaurantDetail" id=${v.rs_no}>
							<span class="img"> <i class = "imageDetail" style="background-image: url('${mypath}/imageView.do?saveFileName=${v.save_file_name}');"></i></span>
							<div class="restaurant_tit">${v.rs_name}</div>
							<div class="like_wrap">
								<div class="good_ico"><img src="${mypath}/Mproject/images/good.PNG"><span class="good_num">${v.rs_good}</span> </div>
								<div class="bad_ico"><img src="${mypath}/Mproject/images/bad.PNG"><span class="good_num">${v.rs_bad}</span> </div>
							</div>
						</span>
					</a>
					</li>`;
			}); //반복문 끝
			
			pager = $.pageList(res.sp, res.ep, res.tp, res.size);
			
			$('#result').html(code);
			$('#pageList').html(pager);
		},
		error : function(xhr){
			alert("상태 : "+xhr.status);
		}//error 끝
		
	});	//ajax끝
	
}

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



