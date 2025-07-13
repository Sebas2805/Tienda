package com.tienda.service.impl;

import com.tienda.dao.ProductoDao;
import com.tienda.domain.Producto;
import com.tienda.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService{

    
    // Inyección del objeto Dao que nos permite interactuar con la DB
    @Autowired
    private ProductoDao productoDao;
    
    @Override
    @Transactional (readOnly = true)
    public List<Producto> getProductos(boolean activos) {
        List<Producto> lista = productoDao.findAll();
        
        //Filtrar solo los activos
        
        if (activos) {
            lista.removeIf(cat -> !cat.isActivo());
        }
        
        return lista;
    }

    @Override
    @Transactional (readOnly = true)
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto categoria) {
        productoDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.deleteById(producto.getIdProducto());
    }

    @Override
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup) {
        return productoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }
    
    @Override
    @Transactional(readOnly=true)    
    public List<Producto> metodoJPQL(double precioInf, double precioSup) {
        return productoDao.metodoJPQL(precioInf, precioSup);
    }
    

    @Override
    @Transactional(readOnly=true)    
    public List<Producto> metodoNativo(double precioInf, double precioSup) {
        return productoDao.metodoNativo(precioInf, precioSup);
    }
}