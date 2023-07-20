function agregarPlato(){
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
         $("#descripcion").focus();
          $("#descripcion").select();
        },
        error:function(e){
        $("#mensajes").html("No se pudo guardar los datos!!!");
        
        },
        complete: function(objeto, exito, error){
         $("#descripcion").focus();
        }
    });

}
//////////////////////////////////////////////////////////////////
function buscarClasificacion(){
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
                $("#id_plato").val(id);
                $("#clasificacion").focus();
                buscarIdPlatos();
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
//////////////////////////////////////////////////////////////////
function modificarPlato(){
    var datosFormulario=$("#formPrograma").serialize();
   
    $.ajax({
        type:'POST',
        url:'jsp/modificar.jsp',
        data: datosFormulario,
        dataType:'json',
              beforeSend:function (objeto){
            $("#mensajes").html("Enviando datos al servidor...");
            
        },
        success: function (json){
         $("#mensajes").html(json.mensaje);
         //limpiarFormulario();
        // $("#id_plato").focus();
        //  $("#id_plato").select();
            
        },
        error:function(e){
        $("#mensajes").html("No se pudo modificar los datos!!!");
        
        },
        complete: function (objeto, exito, error, json) {
            //limpiarCampos();
            $("#mensaje").html(json.mensaje);
            alert("completo");
            $("#id_plato").focus();
            $("#id_plato").select();
           
            if (exito === "success") {
                   
            }
        }
    });
}
////////////////////////////////////////////////
function eliminarPlato() {
    var datosFormulario = $("#formPrograma").serialize();
    $.ajax({
        type: 'POST',
        url: 'jsp/eliminar.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al servidor...");

        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
        },
        error: function (e) {
            $("#mensajes").html("No se pudo eliminar los datos error!!!");

        },
        complete: function (objeto, exito, error, json) {
            //limpiarCampo();
            $("#id_plato").focus();
            $("#id_plato").select();
            if (exito === "success") {

                $("#mensajes").html(json.mensaje);
            }
        }
    });
}
///////////////////////////////////////////////////////////////////////////////
function buscarIdPlatos(){
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
            $("#id_plato").val(json.id_plato);
            $("#clasificacion").val(json.clasificacion);
            $("#descripcion").val(json.descripcion);
            $("#precio").val(json.precio);
  
            
     
            
            
            
//            if(json.nuevo==="true"){
//                $("#botonAgregar").prop('disabled',false);
//                $("#botonModoficar").prop('disabled',true);
//                $("#botonEliminar").prop('disabled',true);
//               
//              
//            //iguenteCampo("#nombre_cliente","#botonModificar",true);
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
//function limpiarCampo() {
//    $("#id_cliente").var("0");
//    $("#nombre_cliente").val("");
//    $("#apellido_cliente").val("");
//    $("#direccion_cliente").val("");
//    $("#telefono_cliente").val("");
//    $("#cedula_cliente").val("");
//    $("#id_cliente").focus();

//}


// validacion para que los campos no se guarden vacios
function validarFormulario() {
    var valor = true;
    if ($("#clasificacion").val().trim() === "") {
        valor = false;
        ($("#mensajes").html("CLASIFICACION NO PUEDE ESTAR VACIO!!!"));
        $("#clasificacion").focus();
    } else if ($("#descripcion").val().trim() === "") {
        valor = false;
        ($("#mensajes").html("DESCRIPCION NO PUEDE ESTAR VACIO!!!"));
        $("#descripcion").focus();

    } else if ($("#precio").val().trim() === "") {
        valor = false;
        ($("#mensajes").html("PRECIO NO PUEDE ESTAR VACIO!!!"));
        $("#precio").focus();

 
    }
    return valor;
}
