$(document).ready(function() {
	
	$('#register').hide();
	
	$('#createNew').on('click', function() {
		$('#login').hide();
		$('#register').fadeIn(1300);
	});

	$('#backToLogin').on('click', function() {
		$('#register').hide();
		$('#success').hide();
		$('#login').fadeIn(1300);

	});

	$('#success').hide();

	$('#registerButton').on('click', function(e) {
		e.preventDefault();
		var error = $('#error');
		var username = $('#username');
		var password = $('#password');

		var userInfo = {
			username : username.val(),
			password : password.val(),
		}

		$.ajax({
			type : 'POST',
			url : 'addUser',
			data : userInfo,
			success : function(userInfo) {
				$('#username').val("");
				$('#password').val("");
				$('#success').fadeIn(1000);
			},
		});
	});
});