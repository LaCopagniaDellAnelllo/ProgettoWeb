

jQuery(document).ready(function ($) {
	$('.login').click(function(){
        $(this).hide();
        $('.signin').hide();
        $('.accesso').show();
        return false;
    })
	
});