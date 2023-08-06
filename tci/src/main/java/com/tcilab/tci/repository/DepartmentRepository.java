package com.tcilab.tci.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcilab.tci.entity.DepartmentEntity;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long>{
	DepartmentEntity findByName(String name);

}
