/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.restinventario.service;

import com.example.restinventario.entity.Categoria;
import com.example.restinventario.repository.CategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jmz
 */
@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @Override
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria obtenerId(Integer id_categoria) {
        return categoriaRepository.findById(id_categoria).get();
    }

    @Override
    public void guardar(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    @Override
    public void eliminar(Integer id_categoria) {
        categoriaRepository.deleteById(id_categoria);
    }
    
}
