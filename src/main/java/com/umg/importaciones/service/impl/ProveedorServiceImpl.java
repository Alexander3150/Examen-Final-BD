package com.umg.importaciones.service.impl;

import com.umg.importaciones.entity.Proveedor;
import com.umg.importaciones.repository.ProveedorRepository;
import com.umg.importaciones.service.ProveedorService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProveedorServiceImpl implements ProveedorService {

    private final ProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> findAll() {
        return proveedorRepository.findAll();
    }

    @Override
    public Proveedor findById(Integer id) {
        return proveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
    }

    @Override
    public Proveedor save(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public void delete(Integer id) {
        Proveedor proveedor = findById(id);
        proveedorRepository.delete(proveedor);
    }
}
