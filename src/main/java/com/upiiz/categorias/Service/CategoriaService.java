package com.upiiz.categorias.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upiiz.categorias.Models.Categoria;
import com.upiiz.categorias.Repository.CategoriasRepository;

//se crea una instancia
@Service
public class CategoriaService {
    //requerimos repo (datos - listado) - categorias
    CategoriasRepository categoriasRepository;

    //constructor - cuando crea la instancia le pasa el repositorio
    public CategoriaService(CategoriasRepository CategoriasRepository){
        this.categoriasRepository = CategoriasRepository;
    }

    //GET - todas las categorias
    public List<Categoria> getAllCategorias(){
        return categoriasRepository.obtenerTodas();
    }

    //Get - categoria por id
    public Categoria getCategoriabyId(Long id){
        return categoriasRepository.obtenerPorId(id);
    }

    //POST - crear categoria
    public Categoria createCategoria(Categoria categoria){
        return categoriasRepository.guardar(categoria);
    }

    //PUT - actualizar categoria
    public Categoria updateCategoria(Categoria categoria){
        return categoriasRepository.actualizar(categoria);
    }

    //DELETE
    public void deleteCategoria(Long id){
        categoriasRepository.eliminar(id);
    }
}
