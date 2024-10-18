package com.upiiz.categorias.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.upiiz.categorias.Models.Categoria;

@Repository
public class CategoriasRepository {
    //almacenar en un listado las categorias: salvar, listar, eliminar, actualizar
    //generar de manera unica el id para cada categoria
    private List<Categoria> categorias = new ArrayList<Categoria>();
    private AtomicLong id = new AtomicLong();

    //agregamos la categoria al listado y la regresamos - POST
    public Categoria guardar(Categoria categoria){
        categoria.setId(id.incrementAndGet());
        categorias.add(categoria);
        return categoria;
    }

    //GET - todas las categorias
    public List<Categoria> obtenerTodas(){
        return categorias;
    }

    //GET - solo una categoria
    public Categoria obtenerPorId(Long id){
        //return null;
        return categorias.stream().filter(categoria -> categoria.getId().equals(id)).findFirst().orElse(null);
    }

    //DELETE
    public void eliminar(Long id){
        categorias.removeIf(categoria -> categoria.getId().equals(id));
    }

    //PUT
    public Categoria actualizar (Categoria categoria){
        eliminar(categoria.getId());
        categorias.add(categoria);
        return categoria;
    }
}
