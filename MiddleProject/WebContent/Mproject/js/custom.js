
$(window).load(function(){
	browserCheck();
    lnbSetControl
});
$(document).ready(function() {
    Menu();
    skinNavi();
	responsive();
	slideVisual();
	smoothScroll();	
	//Fullpage();
	FullpagePop();
	defaultJs();
});

//browser check
function browserCheck(){
	var agent = navigator.userAgent.toLowerCase();

	if (agent.indexOf("msie") > -1 || agent.indexOf("trident") > -1) {
		$('body').addClass('ie');
	} else if ( agent.search( "edge/" ) > -1 ){
		$('body').addClass('ie_edge');
	} else {

	}
}

function skinNavi(){

	$("#skip_navi a").on('click', function() {
		var activeTab = $(this).attr("href");
		$(activeTab).attr('tabindex','-1').focus();
	});
}

function Menu(){

	$(".gnb").each(function(){
		$("> li", this).on("mouseenter focusin",function(){
			$(this).addClass("hv active");
		}).on("mouseleave focusout",function(){
			$(this).removeClass("hv active");
		});
		
	});
}

//lnb load
function lnbSetControl(){
	if(!($('.lnb').length > 0))	return;	
	//gnb 1depth on check
	if($('#header nav .gnb > li').children('a').hasClass('on')){
		//1depth on true 2depth save
		var gnbHtml = $('#header nav .gnb > li > a.on').next('ul').html();
		//lnb add Html
		$('.lnb div').append(gnbHtml);
		//nav.lnb ul add html
		$('.lnb li').wrapAll('<ul></ul>');
		//lnb link #container add
		/*
		$('.lnb ul > li').each(function(){
			var lnbLink = $(this).find('a').attr('href');
			$(this).find('a').attr('href',lnbLink + '#container');
		});	
		*/

		//gnb menu on text
		var gnbTitle = $('.gnb > li > a.on').text();
		$('.area_subVisual .txt h3').text(gnbTitle);
			//sub navigation
		var pageNavigation = $('#header nav .gnb > li > .sub_menu > li > a.on').html();
		var naviTitle = $('#header .gnb > li > a.on').text();
		$('.area_navigation ul li:nth-child(3)').html(pageNavigation);
		$('.area_navigation ul li:nth-child(2)').text(naviTitle);


	}else{
		
		$('.lnb').hide();
	}
}

//scroll add class
$(window).on('DOMContentLoaded load scroll resize', function(){
	//privacy header
	if(($('.area_policy').length > 0)) {
		if ($(window).scrollTop() >= 10) {
			$('#header').addClass('on');
		}
		else {
			$('#header').addClass('on');
		}
	}else{
		if ($(window).scrollTop() >= 10) {
			$('#header').addClass('on');
		}
		else {
			$('#header').removeClass('on');
		}
	}
});

function slideVisual(){
    var interleaveOffset = 0.5;
    var swiperOptions = {
        loop: true,
        speed: 1000,
        parallax: true,
		// autoplay: {
		// 	delay: 10000,
		// 	disableOnInteraction: false,
		//   },
        watchSlidesProgress: true,
        pagination: {
            el: '.swiper-pagination',
            clickable: true,
        },
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },
		keyboard: {
			enabled: true,
		},
        on: {
            progress: function() {
                var swiper = this;
                for (var i = 0; i < swiper.slides.length; i++) {
                    var slideProgress = swiper.slides[i].progress;
                    var innerOffset = swiper.width * interleaveOffset;
                    var innerTranslate = slideProgress * innerOffset;
                    swiper.slides[i].querySelector(".slide-inner").style.transform =
                    "translate3d(" + innerTranslate + "px, 0, 0)";
                }      
            },

            touchStart: function() {
              var swiper = this;
              for (var i = 0; i < swiper.slides.length; i++) {
                swiper.slides[i].style.transition = "";
              }
            },

            setTransition: function(speed) {
                var swiper = this;
                for (var i = 0; i < swiper.slides.length; i++) {
                    swiper.slides[i].style.transition = speed + "ms";
                    swiper.slides[i].querySelector(".slide-inner").style.transition =
                    speed + "ms";
                }
            }
        }
    };

    var swiper = new Swiper(".swiper-container", swiperOptions);

    // DATA BACKGROUND IMAGE
    var sliderBgSetting = $(".slide-bg-image");
    sliderBgSetting.each(function(indx){
        if ($(this).attr("data-background")){
            $(this).css("background-image", "url(" + $(this).data("background") + ")");
        }
    });
	//E. main_visual
	
	var swiper = new Swiper('.area_notice .mySwiper', {
	loop: false,
	autoplay: {
		delay: 2500,
		disableOnInteraction: false,
	},
	navigation: {
		nextEl: '.swiper-button-next',
		prevEl: '.swiper-button-prev',
	},
	pagination: {
            el: '.swiper-pagination',
            clickable: true,
        },
	breakpoints: {
		1023: {
	        slidesPerView: 2.6,
			spaceBetween: 60,
	    },
		541: {
			slidesPerView: 2,
			spaceBetween: 25,
		},
		240: {
			slidesPerView: 1,
			spaceBetween: 0,
		},
	}

	});//area_notice
}

function FullpagePop(){
	$('.area_calendar .calendar table td > div > a').click(function(){
		$("body").addClass("ac");
		$( '.popcont_inn' ).scrollTop( 0 );
		$('body').on('scroll touchmove mousewheel', function(event) {
			event.preventDefault();
			event.stopPropagation();					
			return false;
		});
	});		
	$('.btn_close').click(function(){
		$( '.popcont_inn' ).scrollTop( 0 );
		$("body").removeClass("ac");
		$('body').off('scroll touchmove mousewheel');
		return false;
	});
}
function Fullpage(){
	var headerMenu = $('#header');
	var myFullpage = new fullpage('#fullpage', {
		licenseKey:'OPEN-SOURCE-GPLV3-LICENSE',
		anchors: ['1Page', '2Page', '3Page', '4Page', '5Page'],
		navigationTooltips: ['�낅룄�� �뚭컻', '�낅룄�� ��궗', '�낅룄�꾩떆愿� 泥댄뿕議�', '�낅룄�꾩떆愿� �곸긽愿�'],
		navigation: true,
		navigationPosition: 'left',
        normalScrollElements: '.f_select',
		responsiveWidth: 1240,
		scrollingSpeed: 1240,
		keyboardScrolling: true,
		animateAnchor: true,
		recordHistory: true,
		responsiveHeight: 800,
        slidesNavigation:true,
		onLeave: function(origin, destination, direction){
			if(origin.index == 1&& direction =='down'){				 
				FullpagePop();
			}		
			if(origin.index == 3 && direction =='up'){				
				FullpagePop();		
			}
		}
	});	
}

function defaultJs(){
	//sitemap button
	$('.btn_sitemap').append("<span></span><span></span><span></span>");
	
	//tab_menu
	if ($(".tabs").length > 0) {
		$(".tab_cnt").hide();
		$(".tab_cnt:first").show();
		
		$("ul.tabs li").click(function () {
			$("ul.tabs li button").attr('aria-selected','false');
			$("ul.tabs li").removeClass("active").css("color", "#333");

			$(this).addClass("active").css("color", "##099784");
			$(this).find('button').attr('aria-selected','true');
			
			$(".tab_cnt").hide()
			var activeTab = $(this).attr("rel");
			$("#" + activeTab).fadeIn()
		});	
	}	

	//calender
	$(".area_calendar .calendar table td > a").click(function () {
		$(".area_calendar .calendar table td > a").removeClass('on');
		$(this).addClass('on');
    });	

	//place list
	$(".placelist a").click(function () {
		$(".placelist a").removeClass('on');
		$(this).addClass('on');
    });	
}

//full menu
var navArea = $("#header nav").html();
$(".menu_full").children("div").html(navArea);	

var langBox = $(".select_basic").html();				
$("#header .menu_full > div").prepend('<div class="mob_lang">' + langBox + '</div>');

//responsive style
function responsive(){
	var res = ""
	var param = $("#header");
	var gnbArea = $(".gnb > li");
	var gnbLink = gnbArea.children("a");
	$('#header nav .gnb > li ul').addClass('active');
	$('#header').append('<a href="#" class="btn_close">硫붾돱�リ린</a>');
	$('#header .btn_menu').append('<span></span><span></span><span></span>');	

	//lng + sub title
	var pageTitle = $('#header .gnb > li a.on').next('ul').find(".on").html();
	var lnbTitle = $('#header .gnb > li a.on h3').html();
	var lnbHtml = $('#header .gnb > li > a.on').next('ul').html();

	$('.area_subVisual h2, .title_wrap h2').html(pageTitle);
	$('.lnb ul').append(lnbHtml);
	$('.lnb').prepend("<div><h3>" + lnbTitle + "</h3></div>");

	$('.lnb ul > li').each(function(){
		var lnbLink = $(this).find('a').attr('href');
		$(this).find('a').attr('href',lnbLink + '#lnb');
	});

	$('.area_history .wrap > .tabs li').on('click',function(){
		$('html,body').animate({scrollTop:$(".tabs").offset().top}, 700);
		return false;
	});

	$('.txt').each(function(){
		 if($(".txt").hasClass("test")){
			$(".text_cont_02").css("border-color", "red");
		  }
	});

	//sub navigation
	var pageNavigation = $('#header .gnb > li li.active a').html();
	var naviTitle = $('#header .gnb > li a.on').html();
	$('.area_navigation ul li:nth-child(3)').html(pageNavigation);
	$('.area_navigation ul li:nth-child(2)').html(naviTitle);
	
	//default 
	if(!$(".btn_menu").is(":hidden")) res = "mob";
	else res = "web";  
	param.attr("class",res);
	def(param);

	$(window).resize(function(){
		if(!$(".btn_menu").is(":hidden")) res2 = "mob";
		else res2 = "web"; 
		param.attr("class",res2);
		if(res != res2){
			res = res2;  
			def(param);
		}
	}); 

	//mobile
	$('.btn_menu').on('click',function(){
		if($(this).hasClass('active')){
			$('.btn_menu').removeClass('active');
			$('body').removeClass('active');
			param.find('nav').removeClass('active');
			gnbLink.removeClass('active');	
			gnbLink.parent().find('ul').slideUp();			
			
			posY = $('body').attr('data-scroll');
			$(window).scrollTop(posY);
		}else{
			posY = window.scrollY || document.documentElement.scrollTop;
			$(this).toggleClass('active');		
			setTimeout(function() {
				 $('body').toggleClass('active');
			}, 400);			
			param.find('nav').toggleClass('active');
			gnbLink.removeClass('active');	
			gnbLink.parent().find('ul').slideUp();	
			$('body').attr('data-scroll',posY);
		}
		return false;
	});	

	function def(param){
		if(param.attr("class") == "web" ){			
			$('#header .gnb > li > a').unbind('click');
			$('#header .gnb > li > ul').removeAttr('style');
			$('.btn_menu, body, #header nav').removeClass('active');
			gnbLink.removeClass('active');
			
			gnbLink.hover(function() {
				if(param.attr("class") == "web" || param.attr("class") && "web"){
					$(this).addClass("active").parent().addClass("active"); 
					$(this).parent().hover(function() {
					}, function(){     
					   $(this).removeClass("active", function(){
							$(this).parent().find("a").removeClass("active");
					   });    
					}); 
					 
					if(!($(this).parent().find("ul").length > 0)) {
					   $(this).parent().removeClass("active").find("a").removeClass("active");
					}
				}
			});
			
		} else if (param.attr("class") == "mob"){ 
			$('#header .gnb li').off('mouseenter mouseleave');
			$('#header.mob .gnb > li').each(function(){
				var gnbLink = $(this).children('a');
				if($(this).children('ul').length > 0){
					gnbLink.on('click',function(e){
						e.preventDefault();
						$('#header .gnb a').removeClass('active');
						gnbArea.children('ul').stop().slideUp();
						$(this).addClass('active');
						$(this).siblings('a').addClass('active');
						$(this).parent().children('ul').stop().slideDown();
						return false;
					});
				}
			});
		}
	}
}

// aos
$(function(){
	const aniPosition = window.innerHeight / 5,
			aosList = $('[data-aos]');
	$(window).on('load scroll', function(){
		for (const el of aosList ) {
			if (!$(el).hasClass('aos-animate')) {
				if ( window.innerHeight > el.getBoundingClientRect().top + aniPosition ) {
					$(el).addClass('aos-animate');
				}
			}
		}
	});
	AOS.init({
		duration: 1200,
	});
})

function is_mob(){
	return (/Android|iPhone|iPad|iPod|BlackBerry|Windows Phone/i).test(navigator.userAgent || navigator.vendor || window.opera);
}

function is_mac(){
	return navigator.platform.indexOf('Mac') > -1;
}

function is_chrome(){
	return /Chrome/.test(navigator.userAgent);
}

function is_firefox(){
	return /Firefox/.test(navigator.userAgent);
}

function smoothScroll(){
	if(is_mob() || is_mac() || is_firefox()) return;
	var $window = $(window);
	if(smoothScroll_passive()){
		window.addEventListener("wheel",smoothScroll_scrolling,{passive: false});
	}else{
		$window.on("mousewheel DOMMouseScroll", smoothScroll_scrolling);
	}				
}

function smoothScroll_passive(){
	var supportsPassive = false;
	try {document.addEventListener("test", null, { get passive() { supportsPassive = true }});
	} catch(e) {}
	return supportsPassive;
}

function smoothScroll_scrolling(event){
	if(!event.path){
		event.path = new Array();
		function callParentNode(child){
			if(child.parentNode){
				event.path.push(child.parentNode);
				callParentNode(child.parentNode);
			}
			return;
		}
		event.path.push(event.target);
		callParentNode(event.target);
	}

	var impossibility = new Array("membershipTerms", "privacyStatement");
	for(var i=0; event.path.length > i; i++){
		for(var j=0; impossibility.length > j; j++){
			if(event.path[i].getAttribute && event.path[i].getAttribute("id") ==impossibility[j])return;
		}
	}

	event.preventDefault();
	var $window = $(window);
	var scrollTime = 1;
	var distance_offset = 3;
	var scrollDistance = $window.height() / distance_offset;
	var delta = 0;
	if(smoothScroll_passive()){
		delta = event.wheelDelta/120 || -event.originalEvent.detail/3;
	}else{
		if(typeof event.originalEvent.deltaY != "undefined"){
			delta = -event.originalEvent.deltaY/120;
		}else{
			delta = event.originalEvent.wheelDelta/120 || -event.originalEvent.detail/3;
		}
	}

	var scrollTop = $window.scrollTop();
	var finalScroll = scrollTop - parseInt(delta*scrollDistance);
	TweenMax.to($window, scrollTime, {
		scrollTo : { y: finalScroll, autoKill:true },
		ease: Power3.easeOut,
		overwrite: 5
	});		
	
}

$(function(){
	if( $('.preview_swiper').length < 1 ) return;
	const previewSwiper = new Swiper('.preview_swiper', {
		loop: true,
		autoplay: {
			delay: 3000,
			disableOnInteraction: false,
			pauseOnMouseEnter: true,
		},
		effect: 'fade',
	})
})