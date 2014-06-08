function collectFormData(fields) {
	var data = {};
	for (var i = 0; i < fields.length; i++) {
		var $item = $(fields[i]);
		data[$item.attr('name')] = $item.val();
	}
	return data;
}
				
$(document).ready(function() {
	var $form = $('#addCustomer');
	$form.bind('submit', function(e) {
		// Ajax validation
		var $inputs = $form.find('input');
		var data = collectFormData($inputs);
		
		$.post(formJsonUrl, data, function(response) {
			$form.find('.form-group').removeClass('has-error');
			$form.find('.help-block').empty();
			$form.find('.alert').remove();
			
			if (response.status == 'FAIL') {
				for (var i = 0; i < response.errorMessageList.length; i++) {
					var item = response.errorMessageList[i];
					var $formGroup = $('#' + item.fieldName + 'ControlGroup');
					$formGroup.addClass('has-error');
					$formGroup.find('.help-block').html(item.message);
				}
			} else {
				$form.unbind('submit');
				$form.submit();
			}
		}, 'json');
		
		e.preventDefault();
		return false;
	});
});