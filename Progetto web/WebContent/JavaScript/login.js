

jQuery(document).ready(function ($) {
	$('.login').click(function(){
        $(this).hide();
        $('.signin').hide();
      
    });
	  $(!'.login').click(function(){
          $('.login').show();
          $('.signin').show();
      });
	
});