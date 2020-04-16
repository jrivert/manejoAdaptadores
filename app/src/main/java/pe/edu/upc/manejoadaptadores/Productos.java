package pe.edu.upc.manejoadaptadores;

import java.io.Serializable;

public class Productos implements Serializable {
    //Enviar, guardar y traer información
    //Atributos
    private Integer idProducto;
    private String nombre;
    private String descripcion;
        public Productos(Integer idProducto,String nombre, String descripcion) {
            //Con parametros
            this.idProducto = idProducto;
            this.nombre = nombre;
            this.descripcion = descripcion;

        }
        public Productos () {
            //Sin Parametros
        }
        //IdProducto
        public Integer getIdProducto() {
            return idProducto;
        }

    public void setId(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

 }
