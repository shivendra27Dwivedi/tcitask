package com.tcilab.tci.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcilab.tci.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{
	List<EmployeeEntity> findByJoiningDateBeforeAndExitDateAfter(Date joinDate, Date exitDate);
}
