function agregarCliente(){
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
         $("#nombre_cliente").focus();
          $("#nombre_cliente").select();
        },
        error:function(e){
        $("#mensajes").html("No se pudo guardar los datos!!!");
        
        },
        complete: function(objeto, exito, error){
         $("#nombre_cliente").focus();
        }
    });

}
//////////////////////////////////////////////////////////////////
function buscarNombreCliente(){
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
                $("#id_cliente").val(id);
                $("#nombre_cliente").focus();
                buscarIdCliente();
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
function modificarCliente(){
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
         $("#id_cliente").focus();
          $("#id_cliente").select();
            
        },
        error:function(e){
        $("#mensajes").html("No se pudo modificar los datos!!!");
        
        },
        complete: function (objeto, exito, error, json) {
            //limpiarCampos();
            $("#mensaje").html(json.mensaje);
            alert("completo");
            $("#id_cliente").focus();
            $("#id_cliente").select();
           
            if (exito === "success") {
                   
            }
        }
    });
}
////////////////////////////////////////////////
function eliminarCliente() {
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
            $("#mensajes").html("No se pudo eliminar los datos error!!!" );

        },
        complete: function (objeto, exito, error, json) {
            limpiarCampo();
            $("#id_cliente").focus();
            $("#id_cliente").select();
            if (exito === "success") {

                $("#mensajes").html(json.mensaje);
            }
        }
    });
}
///////////////////////////////////////////////////////////////////////////////
function buscarIdCliente(){
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
            $("#id_cliente").val(json.id_cliente);
            $("#nombre_cliente").val(json.nombre_cliente);
            $("#apellido_cliente").val(json.apellido_cliente);
            $("#direccion_cliente").val(json.direccion_cliente);
            $("#telefono_cliente").val(json.telefono_cliente);
            $("#cedula_cliente").val(json.cedula_cliente);
            
     
            
            
            
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
function limpiarCampo() {
   $("#id_cliente").var("0");
    $("#nombre_cliente").val("");
    $("#apellido_cliente").val("");
    $("#direccion_cliente").val("");
    $("#telefono_cliente").val("");
    $("#cedula_cliente").val("");
    $("#id_cliente").focus();

}


// validacion para que los campos no se guarden vacios
function validarFormularioCliente() {
    var valor = true;
    if ($("#nombre_cliente").val().trim() === "") {
        valor = false;
        ($("#mensajes").html("NOMBRE NO PUEDE ESTAR VACIO"));
        $("#nombre_cliente").focus();
            
    
    } else if ($("#apellido_cliente").val().trim() === "") {
        valor = false;
        ($("#mensajes").html("APELLIDO NO PUEDE ESTAR VACIO"));
        $("#apellido_cliente").focus();
    
    //else if (!isNaN($("#apellido_cliente").val())) {
                                                         //   $("#mensajes").html("Solo letras");
                                                         //   $("#apellido_cliente").val(" ");
                                                          //  $("#apellido_cliente").focus();
                                                          //  valor = false;

    } else if ($("#direccion_cliente").val().trim() === "") {
        valor = false;
        ($("#mensajes").html("DIRECCION NO PUEDE ESTAR VACIO"));
        $("#direccion_cliente").focus();

    } else if ($("#telefono_cliente").val().trim() === "") {
        valor = false;
        ($("#mensajes").html("TELEFONO NO PUEDE ESTAR VACIO"));
        $("#telefono_cliente").focus();
    } else if ($("#cedula_cliente").val().trim() === "") {
        valor = false;
        ($("#mensajes").html("CEDULA NO PUEDE ESTAR VACIO"));
        $("#cedula_cliente").focus();

    }
        return valor;
    
}