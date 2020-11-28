$(document).ready(function() {
	$('.nBtn, .table .eBtn').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		var text = $(this).text();

		if (text == 'edit') {
			$.get(href, function(department, status) {
				$('.myForm #id').val(department.deptNo);
				$('.myForm #name').val(department.deptName);
				$('.myForm #grpid').val(department.groupNo);
			});
			$('.myForm #exampleModal').modal();

		} else {
			$('.myForm #id').val('');
			$('.myForm #name').val('');
			$('.myForm #grpid').val('');
			$('.myForm #exampleModal').modal();
		}

	});

	$('.table .delBtn').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#staticBackdrop #delRef').attr('href', href);
		$('#staticBackdrop').modal();

	});
});
