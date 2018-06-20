/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author thesecond
 */
public class Filtro {

    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre ;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director=director;
    }

    public String getPais() {
        return pais;
    }

    public void setStock(String pais) {
        this.pais = pais;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    public boolean getProyeccion(){
        return proyeccion;
    }
    
    public void setProyeccion(boolean proyeccion){
        this.proyeccion=proyeccion;
    }
    private int id;
    private String nombre;
    private String clasificacion;
    private String pais;
    private String director;
    private int anio;
    private boolean proyeccion;
    
    public Filtro() {
    }
    
    
    public Filtro(int id, int anio, String nombre, String clasificacion, String pais, String director, boolean proyeccion) {
        this.id=id;
        this.anio=anio;
        this.nombre=nombre;
        this.clasificacion=clasificacion;
        this.pais=pais;
        this.director=director;
        this.proyeccion=proyeccion;
    }

    public Filtro( int anio, String nombre, String clasificacion, String pais, String director, boolean proyeccion) {
        this.anio=anio;
        this.nombre=nombre;
        this.clasificacion=clasificacion;
        this.pais=pais;
        this.director=director;
        this.proyeccion=proyeccion;
    }

    /*public Filtro(String marca, int stock, boolean existencia) {
        this.marca = marca;
        this.stock = stock;
        this.existencia = existencia;
    }*/
    
    
}
