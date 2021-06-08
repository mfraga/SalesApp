package com.fraga.sale.controller;

import com.fraga.sale.model.entity.SaleEntity;
import com.fraga.sale.model.request.SaleRequest;
import com.fraga.sale.service.SaleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@RequestMapping("/v1/sale")

public class SaleController {
    @Autowired
    SaleService service;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SaleEntity get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<SaleEntity> list(@RequestParam String nameVendor, 
                                    @RequestParam(defaultValue = "0") int page, 
                                    @RequestParam(defaultValue = "10") int size) {
        return service.list(nameVendor, PageRequest.of(page, size));
    }

    @PostMapping
    public SaleEntity insert(@RequestBody SaleRequest saleRequest) {
        return service.insert(saleRequest);
    }
}