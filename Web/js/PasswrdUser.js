function mostrarPassword(){
    var cambio = document.getElementById("password");
    if(cambio.type == "password"){
      cambio.type = "text";
      $('.icon').removeClass('fa fa-eye-slash').addClass('fa fa-eye');
    }else{
      cambio.type = "password";
      $('.icon').removeClass('fa fa-eye').addClass('fa fa-eye-slash');
    }
  } 
  
  $(document).ready(function () {
  //CheckBox mostrar contraseña
  $('#ShowPassword').click(function () {
    $('#Password').attr('type', $(this).is(':checked') ? 'text' : 'password');
  });
});


function mostrarPasswordRegistro(nombre){
  var cambio = document.getElementById(nombre);
  if(cambio.type == "password"){
    cambio.type = "text";
    if(nombre=="password"){
      $('.icon1').removeClass('fa fa-eye-slash').addClass('fa fa-eye');
    }else{
      $('.icon2').removeClass('fa fa-eye-slash').addClass('fa fa-eye');
    }
    
  }else{
    cambio.type = "password";
    if(nombre=="password"){
      $('.icon1').removeClass('fa fa-eye').addClass('fa fa-eye-slash');
    }else{
      $('.icon2').removeClass('fa fa-eye').addClass('fa fa-eye-slash');
    }
    
  }
} 

$(document).ready(function () {
//CheckBox mostrar contraseña
$('#ShowPassword').click(function () {
  $('#Password').attr('type', $(this).is(':checked') ? 'text' : nombre  );
});
});