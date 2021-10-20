package com.example.metrodemo.Emp_Repo;

import com.example.metrodemo.Emp_Entity.EmployeData;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepo extends JpaRepository<EmployeData,Long>{
}

