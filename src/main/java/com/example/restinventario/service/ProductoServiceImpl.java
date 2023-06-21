/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.restinventario.service;

import com.example.restinventario.entity.Producto;
import com.example.restinventario.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jmz
 */
@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository;
    
    @Override
    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    @Override
    public Producto obtenerId(Integer id_producto) {
        return productoRepository.findById(id_producto).get();
    }

    @Override
    public void guardar(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void eliminar(Integer id_producto) {
        productoRepository.deleteById(id_producto);
    }
    
}
