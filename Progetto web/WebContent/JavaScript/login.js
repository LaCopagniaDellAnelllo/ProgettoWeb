

jQuery(document).ready(function ($) {
	$('.login').click(function(){
        $(this).hide();
        $('.signin').hide();
        $('.accesso').show();
        return false;
    })
	
	$('.back').click(function(){
		$('.login').show();
		$('.signin').show();
		$('.accesso').hide();
		
		
	})
	
});