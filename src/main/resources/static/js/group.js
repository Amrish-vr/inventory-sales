$(document).ready(function() {
	$('.nBtn, .table .eBtn').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		var text = $(this).text();

		if (text == 'edit') {
			$.get(href, function(group, status) {
				$('.myForm #id').val(group.groupNo);
				$('.myForm #name').val(group.groupName);
			});
			$('.myForm #exampleModal').modal();

		} else {
			$('.myForm #id').val('');
			$('.myForm #name').val('');
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
