$(document).ready(
		function() {
			var wrapper = $('#wrapper');
			$('#employeeDiv').hide();
			$('#companyDiv').hide();
			$('#saveButton').hide();
			$('#cancelEdit').hide();

			$('#showEmployee').on('click', function() {
				$('#companyDiv').hide();
				$('#employeeDiv').fadeIn(900);
			});

			$('#showCompany').on('click', function() {
				$('#employeeDiv').hide().fadeOut(900);
				;
				$('#companyDiv').fadeIn(900);
			});
			
			
			

			function getEmployee() {
				$.ajax({
					type : 'GET',
					url : 'getEmployee',
					success : function(employees) {
						$.each(employees, function(i, employees) {
							wrapper.append("<div id='novi'> <table> <tr>"
									+ "<td>" + employees.firstName + "</td>"
									+ "<td>" + employees.lastName + "</td>"
									+ "<td>" + employees.salary + " $"
									+ "</td>" + "<td>" + employees.company
									+ "</td>"
									+ "<td> <button id='editEntry' data-id="
									+ employees.employeeId
									+ ">Edit</button> </td>"
									+ "<td> <button id='removeEntry' data-id="
									+ employees.employeeId
									+ ">Remove</button> </td>"
									+ "</tr> </table></div>");
						});
					}
				});
			}
			;

			function getLatestEmployee() {
				$.ajax({
					type : 'GET',
					url : 'getLatestEmployee',
					success : function(employees) {
						wrapper.append("<div id='novi'> <table> <tr>"
								+ "<td id='fN'>" + employees.firstName
								+ "</td>" + "<td id='lN'>" + employees.lastName
								+ "</td>" + "<td id='sa'>" + employees.salary
								+ " $" + "</td>" + "<td id='co'>"
								+ employees.company + "</td>"
								+ "<td> <button id='editEntry' data-id="
								+ employees.employeeId + ">Edit</button> </td>"
								+ "<td> <button id='removeEntry' data-id="
								+ employees.employeeId
								+ ">Remove</button> </td>"
								+ "</tr> </table></div>");
					}
				});
			}
			;

			function getLatestCompany() {
				var company = $('#company');
				$.ajax({
					type : 'GET',
					url : 'getLatestCompany',
					success : function(companies) {
						company.append('<option>' + companies.name
								+ '</option>');
					}
				});
			}
			;

			function getCompany() {
				$.ajax({
					url : 'getCompany',
					success : function(companies) {
						var company = $('#company');
						$.each(companies, function(i, companies) {
							company.append('<option>' + companies.name+ '</option>');
						});
					}
				});
			}
			;

			$('#addButton').off().on('click', function(e) {
				e.preventDefault();
				var firstName = $('#firstName');
				var lastName = $('#lastName');
				var salary = $('#salary');
				var company = $('#company');

				var employeeInfo = {
					firstName : firstName.val(),
					lastName : lastName.val(),
					salary : salary.val(),
					company : company.val(),
				};

				$.ajax({
					type : 'POST',
					url : 'addEmployee',
					data : employeeInfo,
					success : function(employeeInfo) {
						$('#firstName').val("");
						$('#lastName').val("");
						$('#salary').val("");
						getLatestEmployee();
					}
				});

			});

			wrapper.delegate('#editEntry', 'click', function(e) {
				e.preventDefault();
				var dir = $(this).attr('data-id');
				$.ajax({
					type : 'Get',
					url : 'getSingleEmployee' + dir,
					success : function(e) {
						$('#firstName').val(e.firstName);
						$('#lastName').val(e.lastName);
						$('#salary').val(e.salary);
						$('#company').val(e.company);
						$('#emId').val(dir);
						$('#addButton').hide();
						$('#employeeDiv').fadeIn(1000);
						$('#cancelEdit').fadeIn(1000);
						$('#saveButton').fadeIn(1000);
					}
				});

			});
			$('#saveButton').on('click', function(e) {
				e.preventDefault();
				var tr = $(this).closest('#fN');

				var dir = $(this).attr('data-id');
				var firstName = $('#firstName');
				var lastName = $('#lastName');
				var salary = $('#salary');
				var company = $('#company');
				var id = $('#emId');

				var employeeInfo = {
					employeeId : id.val(),
					firstName : firstName.val(),
					lastName : lastName.val(),
					salary : salary.val(),
					company : company.val(),
				};

				$.ajax({
					type : 'POST',
					url : 'editEmployee',
					data : employeeInfo,
					success : function(employeeInfo) {
						$('#firstName').val("");
						$('#lastName').val("");
						$('#salary').val("");
						$('#cancelEdit').hide();
						$('#saveButton').hide();
						$('#addButton').fadeIn(1500);
						location.reload();
					}
				});

			});

			$('#cancelEdit').on('click', function() {
				$('#firstName').val("");
				$('#lastName').val("");
				$('#salary').val("");
				$('#cancelEdit').hide();
				$('#saveButton').hide();
				$('#addButton').fadeIn(1500);
			});

			getCompany();
			getEmployee();

			wrapper.delegate('#removeEntry', 'click', function() {
				var div = $(this).closest('#novi');

				$.ajax({
					type : 'POST',
					url : 'deleteEmployee' + $(this).attr('data-id'),
					success : function() {
						div.fadeOut(300, function() {
							$(this).remove();
						});
					}
				});
			});

			$('#addCompany').on('click', function(e) {
				e.preventDefault();
				var name = $('#companyName');
				var country = $('#companyCountry');

				var companyInfo = {
					name : name.val(),
					country : country.val(),

				};

				$.ajax({
					type : 'POST',
					url : 'addCompany',
					data : companyInfo,
					success : function(userInfo) {
						$('#companyName').val("");
						getLatestCompany();

					}
				});

			});
		});