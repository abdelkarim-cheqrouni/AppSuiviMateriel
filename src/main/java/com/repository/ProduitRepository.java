package com.repository;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.entites.*;
public interface ProduitRepository extends JpaRepository<Produit, Long>, PagingAndSortingRepository<Produit, Long>{
    Produit findById(int id);
    
    List<Produit> getProduitById(Integer id);
	
    Produit save(List<Produit> pr);
	 Page<Produit> findAll(Pageable pageable);
	
	/*@Query("select p from Produit p where p.equipement like :x")
	public Page<Produit> chercher(@Param("x")String mc, Pageable pageable);

	List<Produit> findByEquipement(String equipement);
	
	@Query("select p from Produit p where equipement like %?1%")
	public List<Produit> findByEquipementt(String  equipement);*/

}