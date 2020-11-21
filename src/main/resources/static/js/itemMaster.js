$(document).ready(function() {
	$('.nBtn, .table .eBtn').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		var text = $(this).text();

		if (text == 'edit') {
			$.get(href, function(item, status) {
				$('.myForm #item').val(item.item);
				$('.myForm #itemParent').val(item.itemParent);
				$('.myForm #itemLevel').val(item.itemLevel);
				$('.myForm #itemDesc').val(item.itemDesc);
				$('.myForm #division').val(item.divisionNo);
				$('.myForm #divisionName').val(item.divisionName);
				$('.myForm #group').val(item.groupNo);
				$('.myForm #groupName').val(item.groupName);
				$('.myForm #dept').val(item.deptNo);
				$('.myForm #deptName').val(item.deptName);
			});
			$('.myForm #exampleModal').modal();

		} else {
			$('.myForm #item').val('');
			$('.myForm #itemParent').val('');
			$('.myForm #itemLevel').val('');
			$('.myForm #itemDesc').val('');
			$('.myForm #division').val('');
			$('.myForm #divisionName').val('');
			$('.myForm #group').val('');
			$('.myForm #groupName').val('');
			$('.myForm #dept').val('');
			$('.myForm #deptName').val('');
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
