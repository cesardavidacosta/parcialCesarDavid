package com.example.primer_parcial;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CONSULTA implements Serializable {
    List<PRODUCTO> listaProductos = new ArrayList<>();
    List<String> listaCategoria = new ArrayList<>();

    public CONSULTA(List<PRODUCTO> listaUsuario, List<String> listaCategoria) {
        this.listaProductos = listaProductos;
        this.listaCategoria = listaCategoria;
    }

    public List<PRODUCTO> getlistaProductos() {
        return listaProductos;
    }

    public void setlistaProductos(List<PRODUCTO> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public List<String> getListaCategoria() {
        return listaCategoria;
    }

    public void setListaCategoria(List<String> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }

}
