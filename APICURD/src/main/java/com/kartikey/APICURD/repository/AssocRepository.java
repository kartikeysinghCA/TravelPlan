package com.kartikey.APICURD.repository;

import com.kartikey.APICURD.model.Assoc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssocRepository extends JpaRepository<Assoc, Long> {
    List<Assoc> findByEmpid(Long empid);
    List<Assoc> findByTrid(Long empid);
}
