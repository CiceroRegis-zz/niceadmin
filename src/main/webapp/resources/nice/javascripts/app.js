$(function() {
	$('.js-toggle').bind('click', function(event) {
		$('.js-sidebar, .js-content').toggleClass('is-toggled');
		event.preventDefault();
	});	
});

<<<<<<< HEAD
=======
//Menu
>>>>>>> new updates
$(function(){
    $(".dropdown").hover(            
            function() {
                $('.dropdown-menu', this).stop( true, true ).fadeIn("fast");
                $(this).toggleClass('open');
                $('b', this).toggleClass("caret caret-up");                
            },
            function() {
                $('.dropdown-menu', this).stop( true, true ).fadeOut("fast");
                $(this).toggleClass('open');
                $('b', this).toggleClass("caret caret-up");                
            });
    });
<<<<<<< HEAD
    
=======
    
//message autocloseable

$(document).ready(function () {
	
	$('.alert-autocloseable-success').hide();
	$('.alert-autocloseable-warning').hide();
	$('.alert-autocloseable-danger').hide();
	$('.alert-autocloseable-info').hide();

	$('#autoclosable-btn-success').click(function() {
		$('#autoclosable-btn-success').prop("disabled", true);
		$('.alert-autocloseable-success').show();

		$('.alert-autocloseable-success').delay(5000).fadeOut( "slow", function() {
			// Animation complete.
			$('#autoclosable-btn-success').prop("disabled", false);
		});
	});
}
}
>>>>>>> new updates
