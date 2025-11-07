package com.pfeproject.InventoryManagement.service;

import com.pfeproject.InventoryManagement.dto.Response;
import com.pfeproject.InventoryManagement.dto.SupplierDTO;

public interface SupplierService {
    Response addSupplier(SupplierDTO supplierDTO);
    Response updateSupplier(Long id, SupplierDTO supplierDTO);
    Response getAllSuppliers();
    Response getSupplierById(Long id);
    Response deleteSupplier(Long id);
}
