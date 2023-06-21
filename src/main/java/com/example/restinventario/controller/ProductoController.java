/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.restinventario.controller;

import com.example.restinventario.entity.Producto;
import com.example.restinventario.service.ProductoService;
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
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/productos")
    public List<Producto>listarProducto(){
        return productoService.listar();
    }
    
    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto>obtenerProductoId(@PathVariable Integer id){
        try {
            Producto producto = productoService.obtenerId(id);
            return new ResponseEntity<Producto>(producto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/productos")
    public void guardarProducto(@RequestBody Producto producto){
        productoService.guardar(producto);
    }
    
    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto>actualizarProducto(@PathVariable Integer id, @RequestBody Producto producto){
        try {
            Producto productoActual = productoService.obtenerId(id);
            productoActual.setNombre(producto.getNombre());
            productoActual.setPrecio(producto.getPrecio());
            productoActual.setStock(producto.getStock());
            productoActual.setId_categoria(producto.getId_categoria());
            productoActual.setId_estado(producto.getId_estado());
            productoService.guardar(productoActual);
            return new ResponseEntity<Producto>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }
    
    
    @DeleteMapping("/productos/{id}")
    public void eliminarProducto(@PathVariable Integer id){
        productoService.eliminar(id);
    }
}
