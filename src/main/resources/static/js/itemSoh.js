$(document).ready(function() {
	$('.nBtn, .table .eBtn').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		var text = $(this).text();

		if (text == 'edit') {
			$.get(href, function(item, status) {
				$('.myForm #item').val(item.item);
				$('.myForm #itemParent').val(item.itemParent);
				$('.myForm #stockOnHand').val(item.stockOnHand);
				$('.myForm #sohUpdateDatetime').val(item.sohUpdateDatetime);
			});
			$('.myForm #exampleModal').modal();

		} else {
			$('.myForm #item').val('');
			$('.myForm #itemParent').val('');
			$('.myForm #stockOnHand').val('');
			$('.myForm #sohUpdateDatetime').val('');
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
