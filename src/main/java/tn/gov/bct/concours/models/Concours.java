package tn.gov.bct.concours.models;

import java.sql.Date;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Concours {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;

    
    @NotBlank
    private String titre;

    @Column(nullable = true,updatable = false)
    private Date datedebut;
    
    
    @Column(nullable = true,updatable = false)
    private Date datefin;
    @NotBlank
    private  String description;

    @OneToOne(cascade=CascadeType.ALL)
    private Formulaire formulaire ;
    @OneToMany(cascade=CascadeType.ALL)
	private Set<Poste> postes;
    
    
    public Concours() {
    }

    public Concours(String titre, Date datedebut, Date datefin, String description) {
        this.titre = titre;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String gettitre() {
        return titre;
    }

    public void settitre(String titre) {
        this.titre = titre;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Concour{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", datedebut=" + datedebut + '\'' +
                ", datefin=" + datefin + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
