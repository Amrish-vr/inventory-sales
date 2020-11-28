$(document).ready(function() {
	$('.nBtn, .table .eBtn').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		var text = $(this).text();

		if (text == 'edit') {
			$.get(href, function(grp, status) {
				$('.myForm #id').val(grp.groupNo);
				$('.myForm #name').val(grp.groupName);
				$('.myForm #Divid').val(grp.divisionNo);
			});
			$('.myForm #exampleModal').modal();

		} else {
			$('.myForm #id').val('');
			$('.myForm #name').val('');
			$('.myForm #Divid').val('');
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
