package com.smca.Company2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smca.Company2.Models.Ipo;

@Repository
public interface IpoRepository extends JpaRepository<Ipo, Long> {
	
}
