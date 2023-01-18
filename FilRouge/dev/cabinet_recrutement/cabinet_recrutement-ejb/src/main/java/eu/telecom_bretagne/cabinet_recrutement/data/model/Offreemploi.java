package eu.telecom_bretagne.cabinet_recrutement.data.model;
// Generated Jan 16, 2023, 3:11:20 PM by Hibernate Tools 5.4.20.Final


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
/**
 * Offreemploi generated by hbm2java
 */
@Entity
@Table(name="offreemploi"
    ,schema="public"
)


public class Offreemploi  implements java.io.Serializable {
@Id @SequenceGenerator(name="offreemploi_ID_GENERATOR", sequenceName="offreemploi_ID_SEQ", allocationSize=1) @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="offreemploi_ID_GENERATOR")
 private Integer id;
     private Niveauqualification niveauqualification;
     private String titre;
     private String profileRecherche;
     private String descriptifMission;
     private Date datedepot;
     private Integer idEntreprise;
     private Set<Messageoffreemploi> messageoffreemplois = new HashSet<Messageoffreemploi>(0);
     private Set<Messagecandidature> messagecandidatures = new HashSet<Messagecandidature>(0);
     private Set<Secteuractivite> secteuractivites = new HashSet<Secteuractivite>(0);

    public Offreemploi() {
    }

	
    public Offreemploi(int id, String titre, String profileRecherche) {
        this.id = id;
        this.titre = titre;
        this.profileRecherche = profileRecherche;
    }
    public Offreemploi(int id, Niveauqualification niveauqualification, String titre, String profileRecherche, String descriptifMission, Date datedepot, Integer idEntreprise, Set<Messageoffreemploi> messageoffreemplois, Set<Messagecandidature> messagecandidatures, Set<Secteuractivite> secteuractivites) {
       this.id = id;
       this.niveauqualification = niveauqualification;
       this.titre = titre;
       this.profileRecherche = profileRecherche;
       this.descriptifMission = descriptifMission;
       this.datedepot = datedepot;
       this.idEntreprise = idEntreprise;
       this.messageoffreemplois = messageoffreemplois;
       this.messagecandidatures = messagecandidatures;
       this.secteuractivites = secteuractivites;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_qualification")
    public Niveauqualification getNiveauqualification() {
        return this.niveauqualification;
    }
    
    public void setNiveauqualification(Niveauqualification niveauqualification) {
        this.niveauqualification = niveauqualification;
    }

    
    @Column(name="titre", nullable=false, length=50)
    public String getTitre() {
        return this.titre;
    }
    
    public void setTitre(String titre) {
        this.titre = titre;
    }

    
    @Column(name="profile_recherche", nullable=false, length=50)
    public String getProfileRecherche() {
        return this.profileRecherche;
    }
    
    public void setProfileRecherche(String profileRecherche) {
        this.profileRecherche = profileRecherche;
    }

    
    @Column(name="descriptif_mission")
    public String getDescriptifMission() {
        return this.descriptifMission;
    }
    
    public void setDescriptifMission(String descriptifMission) {
        this.descriptifMission = descriptifMission;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="datedepot", length=13)
    public Date getDatedepot() {
        return this.datedepot;
    }
    
    public void setDatedepot(Date datedepot) {
        this.datedepot = datedepot;
    }

    
    @Column(name="id_entreprise")
    public Integer getIdEntreprise() {
        return this.idEntreprise;
    }
    
    public void setIdEntreprise(Integer idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="offreemploi")
    public Set<Messageoffreemploi> getMessageoffreemplois() {
        return this.messageoffreemplois;
    }
    
    public void setMessageoffreemplois(Set<Messageoffreemploi> messageoffreemplois) {
        this.messageoffreemplois = messageoffreemplois;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="offreemploi")
    public Set<Messagecandidature> getMessagecandidatures() {
        return this.messagecandidatures;
    }
    
    public void setMessagecandidatures(Set<Messagecandidature> messagecandidatures) {
        this.messagecandidatures = messagecandidatures;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="index_secteuractivite", schema="public", joinColumns = { 
        @JoinColumn(name="idoffre", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="idsecteur", nullable=false, updatable=false) })
    public Set<Secteuractivite> getSecteuractivites() {
        return this.secteuractivites;
    }
    
    public void setSecteuractivites(Set<Secteuractivite> secteuractivites) {
        this.secteuractivites = secteuractivites;
    }




}

