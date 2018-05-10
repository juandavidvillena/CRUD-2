/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 6001016
 */
public class Equipo {
    private String comunidad;
    private String nomEquipo;
    private String eSport;
    private int anoCreacion;
    private int codEquipo;

    public Equipo() {
    }

    public Equipo(String Comunidad, String nomEquipo, String eSport, int anoCreacion, int codEquipo) {
        this.comunidad = Comunidad;
        this.nomEquipo = nomEquipo;
        this.eSport = eSport;
        this.anoCreacion = anoCreacion;
        this.codEquipo = codEquipo;
    }

    public Equipo(String nomEquipo, String eSport, int codEquipo) {
        this.nomEquipo = nomEquipo;
        this.eSport = eSport;
        this.codEquipo = codEquipo;
    }

    public String getComunidad() {
        return comunidad;
    }

    public void setComunidad(String Comunidad) {
        this.comunidad = Comunidad;
    }

    public String getNomEquipo() {
        return nomEquipo;
    }

    public void setNomEquipo(String nomEquipo) {
        this.nomEquipo = nomEquipo;
    }

    public String geteSport() {
        return eSport;
    }

    public void seteSport(String eSport) {
        this.eSport = eSport;
    }

    public int getAnoCreacion() {
        return anoCreacion;
    }

    public void setAnoCreacion(int anoCreacion) {
        this.anoCreacion = anoCreacion;
    }

    public int getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(int codEquipo) {
        this.codEquipo = codEquipo;
    }

    @Override
    public String toString() {
        return "Equipo{" + "comunidad=" + comunidad + ", nomEquipo=" + nomEquipo + ", eSport=" + eSport + ", anoCreacion=" + anoCreacion + ", codEquipo=" + codEquipo + '}';
    }

    
    
}
