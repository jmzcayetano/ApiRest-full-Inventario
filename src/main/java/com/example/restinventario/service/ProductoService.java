/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.restinventario.service;

import com.example.restinventario.entity.Producto;
import java.util.List;

/**
 *
 * @author jmz
 */
public interface ProductoService {
    
    public List<Producto>listar();
    public Producto obtenerId(Integer id_producto);
    public void guardar(Producto producto);
    public void eliminar(Integer id_producto);
}
