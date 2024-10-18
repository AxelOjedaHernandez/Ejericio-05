package com.upiiz.categorias.Controlers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upiiz.categorias.Models.Categoria;
import com.upiiz.categorias.Service.CategoriaService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriasController {
    //requiero inyectar el servicio
    CategoriaService categoriaService;
    public CategoriasController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    //GET - todas las categorias
    @GetMapping
    public ResponseEntity<List<Categoria>> getCategorias() {
        return ResponseEntity.ok(categoriaService.getAllCategorias());
    }
    

    //GET - solo una categoria
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoria(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.getCategoriabyId(id));
    }

    //POST - crear una categoria
    @PostMapping
    public ResponseEntity<Categoria> getMethodName(@RequestBody Categoria categoria) {
        return ResponseEntity.ok(categoriaService.createCategoria(categoria));
    }
    
    //PUT - actualizar una categoria
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> updateCategoria(@RequestBody Categoria categoria, @PathVariable Long id) {
        categoria.setId(id);
        return ResponseEntity.ok(categoriaService.updateCategoria(categoria));
    }
    

    //DELETE - eliminar una categoria
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
        return ResponseEntity.noContent().build();
    }
    
}
