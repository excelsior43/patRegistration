/**
 * all the validations required for registration are added here.
 * 
 * @param value
 * @param element
 * @returns
 */

/**
 * checks for letter only strings
 */
jQuery.validator.addMethod("lettersonly", function(value, element) 
{
return this.optional(element) || /^[a-z]+$/i.test(value);
}, "Letters only please");

/**
 * Validation rules and messages
 * @returns
 */
$(function() {
  $("#register-form").validate({
    rules: {
      "user": {
        required: true,
        lettersonly: true
      },
      "password": {
        required: true,
        minlength: 5
      },
      "email": {
        required: true, 
        email: true
      },
      "address": {
        required: true
      }
    },
    messages: {
      "user": {
        required: "Please, enter a user name",
        lettersonly : "Please enter letters only"
      },
      "password": {
        required: "Please provide a password",
        minlength: "Your password must be at least 5 characters long"
      },
      "email": {
        required: "Please, enter an email",
        email: "Email is invalid"
      },
      "address": {
        required: "Please provide a address"
      }
    },
    submitHandler: function(form) { 
     var formData=$(form).serializeObject(); 
     $.ajax({
    	  type: "POST",
    	  url: "/rest/registration",
    	  data: JSON.stringify(formData),
    	  success: function(data) {
    		  console.log("Ureka Success!! "+data);
    		  $("#register-form").hide();
    		  $("#result-form").show();
    	  },
    	  error: function (request, status) {
    		    validator=$( form ).validate();
    	        validator.showErrors({
    	        	  "user": request.responseText
    	        	});

    	  },
    	  dataType: "json",
    	  contentType: "application/json"
    	});
     return false;
    }
  });
});
/**
 * Confirmation screen hidden.
 * @returns
 */
$(function() {
  $("#result-form").hide();
});
/**
 * values from input fields are converted into a JSON object
 * for the consumption by the back-end registration service 
 */
$.fn.serializeObject = function() {
  var o = {};
  var a = this.serializeArray();
  $.each(a, function() {
    if (o[this.name]) {
      if (!o[this.name].push) {
        o[this.name] = [o[this.name]];
      }
      o[this.name].push(this.value || '');
    } else {
      o[this.name] = this.value || '';
    }
  });
  return o;
};

