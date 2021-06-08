package com.fraga.sale.service;

import java.time.LocalDate;

import com.fraga.sale.model.entity.SaleEntity;
import com.fraga.sale.model.entity.VendorEntity;
import com.fraga.sale.model.request.SaleRequest;
import com.fraga.sale.repository.SaleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SaleService {
    
    @Autowired
    SaleRepository saleRepository;
    
    public SaleEntity get(Long id) {
        return saleRepository.getById(id);
    }

    public Page<SaleEntity> list(String nameVendor, Pageable pageable){
        return saleRepository.findByNameVendor(nameVendor, pageable);
    }

    public SaleEntity insert(SaleRequest saleRequest){
        VendorEntity vendorEntity = VendorEntity.builder()
                                                    .id(saleRequest.getIdVendor())
                                                    .build();
        return saleRepository.save(SaleEntity.builder()
                                                .dateInsert(LocalDate.now())
                                                .idVendor(vendorEntity)
                                                .price(saleRequest.getPrice())
                                                .build());
    }
}
