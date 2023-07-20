
function agregarProveedor(){
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
         $("#nombre_prov").focus();
          $("#nombre_prov").select();
        },
        error:function(e){
        $("#mensajes").html("No se pudo guardar los datos!!!");
        
        },
        complete: function(objeto, exito, error){
         $("#nombre_prov").focus();
        }
    });

}

//////////////////////////////////////////////////////////////////
function modificarProveedor(){
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
         $("#nombre_prov").focus();
          $("#nombre_prov").select();
        },
        error:function(e){
        $("#mensajes").html("No se pudo modificar los datos!!!");
        
        },
        complete: function (objeto, exito, error, json) {
            //limpiarCampos();
            $("#mensaje").html(json.mensaje);
            alert("completo");
            $("#nombre_prov").focus();
            $("#nombre_prov").select();
            if (exito === "success") {
                
            }
        }
    });
}
////////////////////////////////////////////////
function eliminarProveedor() {
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
            $("#nombre_prov").focus();
            $("#nombre_prov").select();
            if (exito === "success") {

                $("#mensajes").html(json.mensaje);
            }
        }
    });
}
///////////////////////////////////////////////////////////////////////////////
function buscarIdProveedor(){
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
            $("#id_prov").val(json.id_prov);
            $("#nombre_prov").val(json.nombre_prov);
            $("#ruc_prov").val(json.ruc_prov);
            $("#descrip_prov").val(json.descrip_prov);
            $("#direccion_prov").val(json.direccion_prov);
            $("#telefono_prov").val(json.telefono_prov);
            $("#correo_prov").val(json.correo_prov);
            
     
            
            
            
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
////////////////////////////////////////////////////////////////////////////
function buscarNombreProveedor(){
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
                $("#id_prov").val(id);
                $("#nombre_prov").focus();
                buscarIdProveedor();
                $("#botonBuscarIdProveedor").prop('disabled',true);
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
//function limpiarCampo() {
//    $("#id_prov").var("0");
//    $("#nombre_cliente").val("");
//    $("#apellido_cliente").val("");
//    $("#direccion_cliente").val("");
//    $("#telefono_cliente").val("");
//    $("#cedula_cliente").val("");
//    $("#id_prov").focus();

//}


// validacion para que los campos no se guarden vacios
function validarFormulario() {
    var valor = true;
    if ($("#nombre_prov").val().trim() === "") {
        valor = false;
        ($("#mensajes").html("NOMBRE NO PUEDE ESTAR VACIO!!!"));
        $("#nombre_prov").focus();
    } else if ($("#ruc_prov").val().trim() === "") {
        valor = false;
        ($("#mensajes").html("RUC NO PUEDE ESTAR VACIO!!!"));
        $("#ruc_prov").focus();
    } else if ($("#descrip_prov").val().trim() === "") {
        valor = false;
        ($("#mensajes").html("DESCRIPCION NO PUEDE ESTAR VACIO!!!"));
        $("#direccion_prov").focus();

    
    } else if ($("#direccion_prov").val().trim() === "") {
        valor = false;
        ($("#mensajes").html("DIRECCION NO PUEDE ESTAR VACIO!!!"));
        $("#direccion_prov").focus();

    } else if ($("#telefono_prov").val().trim() === "") {
        valor = false;
        ($("#mensajes").html("TELEFONO NO PUEDE ESTAR VACIO!!!"));
        $("#telefono_prov").focus();
    } else if ($("#correo_prov").val().trim() === "") {
        valor = false;
        ($("#mensajes").html("CORREO NO PUEDE ESTAR VACIO!!!"));
        $("#correo_prov").focus();

    }
    return valor;
}
