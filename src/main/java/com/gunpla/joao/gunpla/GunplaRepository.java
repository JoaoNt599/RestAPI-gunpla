package com.gunpla.joao.gunpla;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface GunplaRepository extends JpaRepository<Gunpla, Long> {

	List<Gunpla> findAllByExistirTrue();

}
