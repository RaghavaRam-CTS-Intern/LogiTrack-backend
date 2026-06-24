package com.cognizant.logitrack.repository;

import com.cognizant.logitrack.entity.Supplier;
import com.cognizant.logitrack.enums.SupplierStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
	
	@Query("select s from Supplier s where status=:status")
    List<Supplier> findByStatus(SupplierStatus status);
	@Query("select s from Supplier s where category=:category")
    List<Supplier> findByCategory(String category);
}
