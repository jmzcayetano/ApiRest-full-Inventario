/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.restinventario.service;

import com.example.restinventario.entity.Categoria;
import java.util.List;

/**
 *
 * @author jmz
 */
public interface CategoriaService {
    
    public List<Categoria>listar();
    public Categoria obtenerId(Integer id_categoria);
    public void guardar(Categoria categoria);
    public void eliminar(Integer id_categoria);
}
