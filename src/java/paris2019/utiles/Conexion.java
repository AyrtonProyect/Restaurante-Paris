/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paris2019.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author HP
 */
public class Conexion {
    private static String driver="org.postgresql.Driver";
    private static String servidor="localhost";
    private static String puerto="5432";
    private static String baseDato="paris2019";
    private static String usuario="postgres";
    private static String clave="root";
    private static Connection conn;
    private static Statement st;
     
     
     public static boolean conectar(){
         boolean valor=false;

         try{/*Try es un bloque para detectar excepcionesLa palabra reservada try designa un bloque con el mismo nombre que es un área del
programa que detecta excepciones; en el interior de dichos bloques, por lo general se
llaman a métodos que pueden levantar o lanzar excepciones.*/
             Class.forName(driver);
             String url="jdbc:postgresql://"+servidor+":"+puerto+"/"+baseDato;//Lugar u origen de datos
              conn=DriverManager.getConnection(url,usuario,clave);
              st=conn.createStatement();
              valor=true;               
         }catch(ClassNotFoundException ex){/*La palabra reservada
catch designa un manejador de capturas con una signatura que representa un tipo
de excepción; dichos manejadores siguen inmediatamente a bloques try o a otro manejador
catch con un argumento diferente.Catch es un manejador para capturar excepciones de los bloques try*/
             System.err.println("error: "+ex);/*System.err; de salida estándar de errores; permite al programa imprimir errores
por pantalla.*/
         }catch(SQLException ex){
             System.err.println("Error: "+ex);
         }
         return valor;
       }
     public static boolean cerrar(){
         boolean valor=false;
         try{
             st.close();
             conn.close();
         }catch(SQLException ex){
             System.out.println("error: +"+ex);/*System.out; de salida estándar; permite al programa imprimir datos por pantalla.*/
         }
         return valor;
    }
     public static Connection getConn(){
         return conn;
     }
     public static Statement getSt(){
         return st;
        }
     public static void main (String[] args){//Punto inicial de entrada al programa
         conectar();
     }

}

    

