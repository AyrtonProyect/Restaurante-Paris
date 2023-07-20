function agregarUsuario(){
    var datosFormulario=$("#formPrograma").serialize();
    $.ajax({
        type:'POST',
        url:'jsp/agregar.jsp',
        data: datosFormulario,
        dataType:'json',
        beforeSend:function (objeto){
            $("#mensajes").html("Enviando datos al servidor...");
            
        },
        success: function (json){
         $("#mensajes").html(json.mensaje);
         //limpiarFormulario();
         $("#nombre_usuario").focus();
          $("#nombre_usuario").select();
        },
        error:function(e){
         //modal({
				//type: 'error',
				//title: 'Registro de Usuario',
				//text: 'No se pudo agregar el registro'
		//	});
            $("#mensajes").html("No se pudo modificar los datos.");
        
        },
        complete: function(objeto, exito, error){
         $("#nombre_usuario").focus();
        }
    });

}
/////////////////////////////////////////////////////////////////////////
function buscarNombreUsuario(){
        var datosFormulario = $("#formBuscar").serialize();
        alert(datosFormulario);
        $.ajax({
        type: 'POST',
        url: 'jsp/buscarNombre.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto){
         $("#mensajes").html("Enviando datos al Servidor ...");
         $("#contenidoBusqueda").css("display", "none");
        },
        success: function (json){
            $("#mensajes").html(json.mensaje);  
            $("#contenidoBusqueda").html(json.contenido);
            $("#contenidoBusqueda").fadeIn("slow");
            $("tbody tr").on("click", function(){
                var id = $ (this).find("td:first").html();
                $("#panelBuscar").html("");
                $("#id_usuario").val(id);
                $("#nombre_usuario").focus();
                buscarIdUsuario();
                $("#buscar").fadeOut("slow");
                $("#panelPrograma").fadeIn("slow");
           });           
       },
       error: function (e){
           $("#mensajes").html("No se pudo buscar registros.");
       },
        complete: function (objeto, exito, error){
            if (exito === "success"){
        }
    }
        });
    }
//////////////////////////////////////////////////////////////////////////
function buscarIdUsuario(){
    var datosFormulario =$("#formPrograma").serialize();

    $.ajax({
        type: 'POST',
        url:'jsp/buscarId.jsp',
        data:datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("ENVIANDO DATOS AL SERVIDOR...!!!");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            $("#id_usuario").val(json.id_usuario);
            $("#nombre_usuario").val(json.nombre_usuario);
            $("#password_usuario").val(json.password_usuario);
            $("#login_usuario").val(json.login_usuario);
//            if(json.nuevo==="true"){
//                $("#botonAgregar").prop('disabled',false);
//                $("#botonModoficar").prop('disabled',true);
//                $("#botonEliminar").prop('disabled',true);
//               
//              
//            //iguenteCampo("#nombre_usuario","#botonModificar",true);
//            }
        },
        error: function(e){
            $("#mensajes").html("NO SE PUDO RECUPERAR LOS DATOS...");
            
        },
        complete: function(objeto, exito, error){
            if (exito==="success"){
                
            }
        }
    });
}

////////////////////////////////////////////////////////////////////////////////
function modificarUsuario(){
    var datosFormulario=$("#formPrograma").serialize();
   
    $.ajax({
        type:'POST',
        url:'jsp/modificar.jsp',
        data: datosFormulario,
        dataType:'json',
        beforeSend:function(objeto){
            $("#mensaje").html("Enviando datos al servidor...");
        }, 
         success: function (json) {
             $("#mensajes").html(json.mensaje);
         
        },
        error: function(e){
            alert("error");
            $("#mensaje").html("NO SE PUDO MODIFICAR LOS DATOS ERROR");

        },
        complete: function (objeto, exito, error, json) {
            //limpiarCampos();
            $("#mensaje").html(json.mensaje);
            alert("completo");
            $("#id_usuario").focus();
            $("#id_usuario").select();
            if (exito === "success") {
                
            }
        }
    });
}
////////////////////////////////////////////////
function eliminarUsuario() {
    var datosFormulario = $("#formPrograma").serialize();
    $.ajax({
        type: 'POST',
        url: 'jsp/eliminar.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensaje").html("Enviando datos al servidor...");

        },
        success: function (json) {
            $("#mensaje").html(json.mensaje);
        },
        error: function (e) {
            $("#mensaje").html("No se pudo modificar los datos error" + e.status);

        },
        complete: function (objeto, exito, error, json) {
            //limpiarCampo();
            $("#id_usuario").focus();
            $("#id_usuario").select();
            if (exito === "success") {

                $("#mensaje").html(json.mensaje);
            }
        }
    });
}


function validarFormulario() {
    var valor = true;
    if ($("#nombre_usuario").val().trim() === "") {
        valor = false;
        ($("#mensajes").html("EL NOMBRE DE USUARIO NO PUEDE ESTAR VACIO"));
        $("#nombre_usuario").focus();
        
    }else if ($("#password_usuario").val().trim() === "") {
       valor = false;
       ($("#mensajes").html("EL PASSWORD DE USUARIO NO PUEDE ESTAR VACIO"));
      $("#password_usuario").focus();
       
   }
    return valor;
    }   
    
function limpiarCampoUsu() {
    $("#id_usuario").var("0");
    $("#nombre_usuario").val("");
   $("#id_usuario").focus();

}
