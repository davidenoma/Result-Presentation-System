$(document).ready(function(){
    //alert('');
    $('#feedback').hide();
    $('#amount').keyup(function(){
        var deposit = $('#amount').val();
        if(deposit > 200000){
            $('#feedback').slideDown();
           $('#feedback').text('you cant exceed 200,000 Naira');
           $('#send').prop('disabled', true);
        }else if(deposit < 10000){
            $('#feedback').slideDown();
            $('#feedback').text('you cant Invest below 10,000 Naira');
            //alert("you cant Invest Below 10,000 Naira");
           $('#send').prop('disabled', true);
        }else if(deposit == 10000){
            $('#feedback').slideUp(500);
           $('#send').prop('disabled', false); 
        }else if(deposit == 20000){
            $('#feedback').slideUp(500);
           $('#send').prop('disabled', false);
        }
        else if(deposit == 30000){
            $('#feedback').slideUp(500);
           $('#send').prop('disabled', false);
        }
        else if(deposit == 40000){
            $('#feedback').slideUp(500);
           $('#send').prop('disabled', false);
        }else{
            $('#feedback').slideDown();
            $('#feedback').text('It has to be a round figure');
        }
    });
    $('#code').keyup(function(){
        var code = $('#code').val();
        if (parseInt(code) == 12345) {
            $('#send').prop('disabled', false);
            $('#feedback').slideUp(500);
        }else{
             $('#feedback').slideDown();
           $('#feedback').text('Incorrect code Entered');
           $('#send').prop('disabled', true);
        }
    });
});