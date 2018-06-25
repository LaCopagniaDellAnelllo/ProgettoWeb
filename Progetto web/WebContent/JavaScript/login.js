

jQuery(document).ready(function ($) {
	$('.login').click(function(){
        $(this).hide();
        $('.signin').hide();
        return false;
    });
	
	$('body *').not('.log, .log *').click(function(){
        $('.login').show();
        $('.signin').show();
        return false;
    });
	
	
});