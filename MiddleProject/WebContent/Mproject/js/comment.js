/**
 * 
 */


//전체 목록 출력
$.commentList = function(ntNo, usersNo){
	$.ajax({
		url : `${mypath}/commentList.do`,
		type : 'get',
		data : {"ntNo":ntNo},
		
		dataType : 'json',
		success : function(res){
			code ="";
			$.each(res, function(i,v){
				code +=`<div class="commentOne">
						<div class="list-top">
							<div class="write-info">
								<h1>${v.users_name}</h1>
								<div class="date">${v.cm_date}</div>
							</div>
							<div class="btn-box" style="text-align: right;">
								<input type="hidden" name="txt_Memo_Del_Seq" value="2">`;
								
				if(usersNo==v.users_no){			
					code+=`<div class="comment-delete" id=${v.cm_no}>
								<p>삭제</p>
							</div>`;

				}
				code +=`</div>
						</div>
						</div>
						<div class="comment-contents">${v.cm_con}</div><hr>`;
			}); //반복문 끝
			
			$('.comment-list-box').html(code);
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


