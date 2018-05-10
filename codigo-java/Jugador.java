/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 6001016
 */
public class Jugador {
    private int codJug;
    private String nomJug;
    private String rol;
    private int telefono;
    private int anoNac;
    private Equipo equipo;
    private String FotoJug;

    public String getFotoJug() {
        return FotoJug;
    }

    public void setFotoJug(String FotoJug) {
        this.FotoJug = FotoJug;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public int getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(int codEquipo) {
        this.codEquipo = codEquipo;
    }
    private  int codEquipo;

    public Jugador(int codJug, String nomJug, String rol, int telefono, int anoNac, int codEquipo) {
        this.codJug = codJug;
        this.nomJug = nomJug;
        this.rol = rol;
        this.telefono = telefono;
        this.anoNac = anoNac;
        this.codEquipo = codEquipo;
    }

    public Jugador(int codJug, String nomJug, String rol, int telefono, int anoNac, Equipo equipo, int codEquipo) {
        this.codJug = codJug;
        this.nomJug = nomJug;
        this.rol = rol;
        this.telefono = telefono;
        this.anoNac = anoNac;
        this.equipo = equipo;
        this.codEquipo = codEquipo;
    }
    

    public Jugador(int codJug, String nomJug, String rol, int telefono, int anoNac, Equipo  equipo, int codEquipo, String FotoJug) {
        this.codJug = codJug;
        this.nomJug = nomJug;
        this.rol = rol;
        this.telefono = telefono;
        this.anoNac = anoNac;
        this.equipo = equipo;
        this.codEquipo = codEquipo;
        this.FotoJug = FotoJug;
    }

    public Jugador() {
}

    public Jugador(int codJug, String nomJug, int codEquipo) {
        this.codJug = codJug;
        this.nomJug = nomJug;
        this.codEquipo = codEquipo;
    }

   

    public int getCodJug() {
        return codJug;
    }

    public void setCodJug(int codJug) {
        this.codJug = codJug;
    }

    public String getNomJug() {
        return nomJug;
    }

    public void setNomJug(String nomJug) {
        this.nomJug = nomJug;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getAnoNac() {
        return anoNac;
    }

    public void setAnoNac(int anoNac) {
        this.anoNac = anoNac;
    }

    public int getcodEquipo() {
        return codEquipo;
    }

    public void setcodEquipo(int codEquipo) {
        this.codEquipo = codEquipo;
    }

    @Override
    public String toString() {
        return "Jugador{" + "codJug=" + codJug + ", nomJug=" + nomJug + ", rol=" + rol + ", telefono=" + telefono + ", anoNac=" + anoNac + ", codEquipo=" + codEquipo + '}';
    }


    
    
}