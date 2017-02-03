package com.valdiviezo.anahi.tangomio;

/**
 * Created by Aniss on 02/02/2017.
 */
public class Usuario {
    
    private String email;
    private String pass;
    
    public Usuario(String user, String pass) {
        this.email = user;
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String user) {
        this.email = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
