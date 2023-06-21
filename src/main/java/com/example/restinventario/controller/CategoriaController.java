/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.restinventario.controller;

import com.example.restinventario.entity.Categoria;
import com.example.restinventario.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jmz
 */
@RestController
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;
    
    
    @GetMapping("/categorias")
    public List<Categoria>listarCategoria(){
        return categoriaService.listar();
    }
    
    @GetMapping("/categorias/{id}")
    public ResponseEntity<Categoria>obtenerCategoriaId(@PathVariable Integer id){
        try {
            Categoria categoria = categoriaService.obtenerId(id);
            return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Categoria>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/categorias")
    public void guardarCategoria(@RequestBody Categoria categoria){
        categoriaService.guardar(categoria);
    }
    
    @PutMapping("/categorias/{id}")
    public ResponseEntity<Categoria>actualizarCategoria(@PathVariable Integer id, @RequestBody Categoria categoria){
        try {
            Categoria categoriaActual = categoriaService.obtenerId(id);
            categoriaActual.setDescripcion(categoria.getDescripcion());
            categoriaService.guardar(categoriaActual);
            return new ResponseEntity<Categoria>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Categoria>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/categorias/{id}")
    public void eliminarCategoria(@PathVariable Integer id){
        categoriaService.eliminar(id);
    }
}
