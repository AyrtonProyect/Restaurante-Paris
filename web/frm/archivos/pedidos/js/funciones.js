function cargar_id(){
  var datosFormulario=$("#formPrograma").serialize();
    $.ajax({
        type:'POST',
        url:'jsp/id.jsp',
        data: datosFormulario,
        dataType:'json',
        beforeSend:function (objeto){
            $("#mensajes").html("Enviando datos al servidor...");
            
        },
        success: function (json){
         $("#mensajes").html(json.mensaje);
         //limpiarFormulario();
          $("#nombre_cliente").val(json.nropedido);
          
        },
        error:function(e){
        $("#mensajes").html("No se pudo guardar los datos!!!");
        
        },
        complete: function(objeto, exito, error){
      
     
        }
    });

  }
function agregarPedido(){
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
          $("#nropedido").focus();
          $("#nropedido").select();
        },
        error:function(e){
        $("#mensajes").html("No se pudo guardar los datos!!!");
        
        },
        complete: function(objeto, exito, error){
        $("#nropedido").focus();
     
        }
    });

}
//////////////////////////////////////////////////////////////////
function buscarNombreCliente1(){
        var datosFormulario = $("#formBuscar").serialize();
        alert(datosFormulario);
        $.ajax({
        type: 'POST',
        url: 'jsp/buscarNombreCliente.jsp',
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
                buscarIdCliente1();
                $("#buscar").fadeOut("slow");
                $("#panelPrograma").fadeIn("slow");
           });           
       },
       error: function (e){
           $("#mensajes").html("No se pudo buscar registros.");
       },
        complete: function (objeto, exito, error){
          
    }
        });
    }


function buscarIdCliente1(){
    var datosFormulario =$("#formPrograma").serialize();

    $.ajax({
        type: 'POST',
        url:'jsp/buscarIdCliente.jsp',
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
            
        }
    });
}
//////////////////////////////////////////////////////////////////////////////
function buscarIdPlatos(){
    var datosFormulario =$("#formPrograma").serialize();

    $.ajax({
        type: 'POST',
        url:'jsp/buscarIdPlato.jsp',
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
           
        }
    });
}
function buscarClasificacionPlato(){
        var datosFormulario = $("#formBuscar").serialize();
        alert(datosFormulario);
        $.ajax({
        type: 'POST',
        url: 'jsp/buscarNombrePlato.jsp',
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
       
    }
        });
    }
  //////////////////////////////////////////////////////////////////////////////
function buscarClasificacionPostre(){
        var datosFormulario = $("#formBuscar").serialize();
        alert(datosFormulario);
        $.ajax({
        type: 'POST',
        url: 'jsp/buscarNombrePostre.jsp',
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
                $("#id_postre").val(id);
                $("#clasificacion3").focus();
                buscarIdPostres();
                $("#buscar").fadeOut("slow");
                $("#panelPrograma").fadeIn("slow");
           });           
       },
       error: function (e){
           $("#mensajes").html("No se pudo buscar registros.");
       },
        complete: function (objeto, exito, error){
       
    }
        });
    }
    function buscarIdPostres(){
    var datosFormulario =$("#formPrograma").serialize();

    $.ajax({
        type: 'POST',
        url:'jsp/buscarIdPostre.jsp',
        data:datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("ENVIANDO DATOS AL SERVIDOR...!!!");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            $("#id_postre").val(json.id_postre);
            $("#clasificacion3").val(json.clasificacion);
            $("#descripcion3").val(json.descripcion);
            $("#precio3").val(json.precio);
  
            
     
            
            
            
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
            
        }
    });
}
////////////////////////////////////////////////////////////////////////////////
function buscarClasificacionBebida(){
        var datosFormulario = $("#formBuscar").serialize();
        alert(datosFormulario);
        $.ajax({
        type: 'POST',
        url: 'jsp/buscarNombreBebida.jsp',
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
                $("#id_bebida").val(id);
                $("#clasificacion2").focus();
                buscarIdBebida();
                $("#buscar").fadeOut("slow");
                $("#panelPrograma").fadeIn("slow");
           });           
       },
       error: function (e){
           $("#mensajes").html("No se pudo buscar registros.");
       },
        complete: function (objeto, exito, error){
        
    }
        });
    }
    function buscarIdBebida(){
    var datosFormulario =$("#formPrograma").serialize();

    $.ajax({
        type: 'POST',
        url:'jsp/buscarIdBebida.jsp',
        data:datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("ENVIANDO DATOS AL SERVIDOR...!!!");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            $("#id_bebida").val(json.id_bebida);
            $("#clasificacion2").val(json.clasificacion);
            $("#descripcion2").val(json.descripcion);
            $("#precio2").val(json.precio);
  
            
     
            
            
            
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
           
        }
    });
}
////////////////////////////////////////////////////////////////////////////////
function sumar(){
   /* var total=0;
    valor=parseInt(valor);
    total=document.getElementById('Total').innerHTML;
    total=(total==null || total==undefined || total=="")? 0 : total;
    total=(parseInt(total)+ parseInt(valor));
    document.getElementById('Total').innerHTML=total;
    $("#Total").val(total);*/
  
    total=document.getElementById('total').innerHTML;
    var a1=(document.getElementById("precio").value)||0; 
    var a2=(document.getElementById("cant").value)||0; 
    var result1=parseInt(a1)*parseInt(a2);
    
    var b1=(document.getElementById("precio2").value)||0;
    var b2=(document.getElementById("cant2").value)||0; 
    var result2=parseInt(b1)*parseInt(b2);
    
    var c1=(document.getElementById("precio3").value)||0;
    var c2=(document.getElementById("cant3").value)||0; 
    var result3=parseInt(c1)*parseInt(c2);
    
    var total= parseInt(result1)+parseInt(result2)+parseInt(result3);
    var iva=parseInt(total*10/100);
    var subtotal=total-iva;
    
    $("#total").val(total);
    $("#subtotal").val(subtotal);
    $("#iva").val(iva);
  document.getElementById('total').value=total;
}
function limpiarBebida() {
   document.getElementById("id_bebida").value="";
   document.getElementById("clasificacion2").value="";
   document.getElementById("descripcion2").value="";
   document.getElementById("precio2").value="";
   document.getElementById("cant2").value="";
  }

function limpiarPostre() {
   document.getElementById("id_postre").value="";
   document.getElementById("clasificacion3").value="";
   document.getElementById("descripcion3").value="";
   document.getElementById("precio3").value="";
   document.getElementById("cant3").value="";
  }
function limpiarPlato() {
   document.getElementById("id_plato").value="";
   document.getElementById("clasificacion").value="";
   document.getElementById("descripcion").value="";
   document.getElementById("precio").value="";
   document.getElementById("cant").value="";
  }
function buscarPedido(){
        var datosFormulario = $("#formBuscar").serialize();
        alert(datosFormulario);
        $.ajax({
        type: 'POST',
        url: 'jsp/buscarNombrePedido.jsp',
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
                $("#nro_pedido").val(id);
                $("#clasificacion").focus();
                agregarPedido();
                $("#buscar").fadeOut("slow");
                $("#panelPrograma").fadeIn("slow");
           });           
       },
       error: function (e){
           $("#mensajes").html("No se pudo buscar registros.");
       },
        complete: function (objeto, exito, error){
       
    }
        });
    }

  
  function fecha(){
      var hoy=new Date();
      var dd=hoy.getDate();
      var mm=hoy.getMonth()+1;
      var yyyy=hoy.getFullYear();
      
   
      hoy=dd+'/'+mm+'/'+yyyy;
    $("#fecha").val(hoy);
  }
  