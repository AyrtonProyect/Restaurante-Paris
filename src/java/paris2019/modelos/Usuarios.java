/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paris2019.modelos;

/**
 *
 * @author Antony_99
 */

public class Usuarios {
    private int id_usuario;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getPassword_usuario() {
        return password_usuario;
    }

    public void setPassword_usuario(String password_usuario) {
        this.password_usuario = password_usuario;
    }

    public String getLogin_usuario() {
        return login_usuario;
    }

    public void setLogin_usuario(String login_usuario) {
        this.login_usuario = login_usuario;
    }

    public Usuarios(int id_usuario, String nombre_usuario, String password_usuario, String login_usuario) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.password_usuario = password_usuario;
        this.login_usuario = login_usuario;
    }
    private String nombre_usuario;
    private String password_usuario;
    private String login_usuario;

    public Usuarios() {
    }
}