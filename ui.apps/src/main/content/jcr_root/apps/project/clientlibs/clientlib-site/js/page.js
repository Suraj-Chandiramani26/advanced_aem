
function loadDoc(){
var num1 = $('#num1').val();
var num2 = $('#num2').val();
$.ajax({
url     : '/bin/pages',
method     : 'GET',
data     : {num1 : num1,num2 : num2},
success    : function(resultText){
$('#answer').text(resultText);
}
});
} 