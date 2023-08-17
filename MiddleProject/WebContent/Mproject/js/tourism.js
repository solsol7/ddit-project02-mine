/**
 * 
 */

//좋아요 싫어요 클릭
$.updateGB = function(gb, trNo){

	$.ajax({
		url : `${mypath}/tourismGood.do`,
		type : 'get',
		data : {
			"trNo" : trNo,
			"gb" : gb
		},
		dataType : 'json',
		success : function(res){
			$('#good_num').text(res.tr_good);
			$('#bad_num').text(res.tr_bad);
			
//			location.reload();
		},// succes 끝
		error : function(xhr){
			alert("상태 : "+xhr.status)
		}// error끝
	})//ajax끝
	
}


//전체 목록 출력
$.tourismList = function(cpage){
	sword = $('#sword').val();
	$.ajax({
		url : `${mypath}/tourism.do`,
		type : 'get',
		data : {"sword":sword,
				"cpage":cpage},
		
		dataType : 'json',
		success : function(res){
			code ="";
			$.each(res.list, function(i,v){
				code +=`<li>
					<a href="#" class="tourDetail" id=${v.tr_no}>
							<span class="img"> <i class = "imageDetail" style="background-image: url('${mypath}/imageView.do?saveFileName=${v.save_file_name}');"></i></span>
							<div class="tour_tit">${v.tr_name}</div>
							<div class="like_wrap">
								<div class="good_ico gbBtn"><img src="${mypath}/Mproject/images/good.PNG"><span class="good_num">${v.tr_good}</span> </div>
								<div class="bad_ico gbBtn"><img src="${mypath}/Mproject/images/bad.PNG"><span class="good_num">${v.tr_bad}</span> </div>
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


//페이지 출력
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



