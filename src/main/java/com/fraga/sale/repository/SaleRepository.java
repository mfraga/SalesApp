package com.fraga.sale.repository;

import com.fraga.sale.model.entity.SaleEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<SaleEntity, Long> {
    public SaleEntity getById(Long id);

    @Query(value = "SELECT s.* FROM tbsale s INNER JOIN tbvendor v ON s.ID_VENDOR = v.ID WHERE v.name like concat('%', :nameVendor, '%')", 
    countQuery = "SELECT count(s.id) FROM tbsale s INNER JOIN tbvendor v ON s.ID_VENDOR = v.ID WHERE v.name like concat('%', :nameVendor, '%')",
    nativeQuery = true)
    public Page<SaleEntity> findByNameVendor(@Param("nameVendor") String nameVendor, Pageable pageable);
}