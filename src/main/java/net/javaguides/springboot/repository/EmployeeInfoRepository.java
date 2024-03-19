package net.javaguides.springboot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.EmployeeInfo;

public interface EmployeeInfoRepository extends JpaRepository <EmployeeInfo, Long> {

}
