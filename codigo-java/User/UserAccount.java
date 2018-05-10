/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;
/**
 *
 * @author 6001016
 */
public class UserAccount {
    private String nomUsu;
    private String password;

    public UserAccount(String nomUsu, String password) {
        this.nomUsu = nomUsu;
        this.password = password;
    }

    public UserAccount() {
    }

    public String getNomUsu() {
        return nomUsu;
    }

    public void setNomUsu(String nomUsu) {
        this.nomUsu = nomUsu;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
