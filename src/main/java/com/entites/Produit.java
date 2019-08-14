package com.entites;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
 
@Entity
@Table(name = "produit")
public class Produit implements Serializable {
 
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
 
  private String equipement;
 
  private String marque;
  private String type;
  
  @Column(nullable = false, updatable = false)

  @CreationTimestamp
  private LocalDateTime  date_livraison;
  
  
  @Column(nullable = false)
  @Temporal(TemporalType.DATE)
  @LastModifiedDate
  
  private Date date_garantie;
public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}
public String getEquipement() {
	return equipement;
}
public void setEquipement(String equipement) {
	this.equipement = equipement;
}
public String getMarque() {
	return marque;
}
public void setMarque(String marque) {
	this.marque = marque;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}

public LocalDateTime getDate_livraison() {
	return date_livraison;
}

public void setDate_livraison(LocalDateTime date_livraison) {
	this.date_livraison = date_livraison;
}

public Date getDate_garantie() {
	return date_garantie;
}
public void setDate_garantie(Date date_garantie) {
	this.date_garantie = date_garantie;
}
public Produit() {
	super();
	// TODO Auto-generated constructor stub
}
public Produit(String equipement, String marque, String type, LocalDateTime date_livraison, Date date_garantie) {
	super();
	this.equipement = equipement;
	this.marque = marque;
	this.type = type;
	this.date_livraison = date_livraison;
	this.date_garantie = date_garantie;
}
  

  


}