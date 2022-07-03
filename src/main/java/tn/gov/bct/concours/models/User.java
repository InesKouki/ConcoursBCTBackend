package tn.gov.bct.concours.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

@Entity
@Table(	name = "users", 
uniqueConstraints = { 
	@UniqueConstraint(columnNames = "email") 
})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	@NotBlank
	String nom;
	@NotBlank
	String prenom;
	@NotBlank
	String email;
	@NotBlank
	String password;
	@NotBlank
	String cin;
	byte[] cv;
	@NotBlank
	Date dateNaissance;
	@NotBlank
	String sexe;
	
	
	
	

}
