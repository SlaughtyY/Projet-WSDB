package models;

import io.ebean.*;
import java.util.*;
import javax.persistence.*;
import play.data.validation.Constraints.* ;

@Entity
public class User extends Model{
    
    private static final long serialVersionUID= 1L;
    private ArrayList<Integer> points = new ArrayList<Integer>(); // Permetrait de stocker temporairement les points/score pendant un match
	
    @Id
    public long id;
    
    public static Finder<Long, User> find = new Finder<Long,User>(User.class);


    private boolean status;//True = Admin False = normal



    //Définition des pré-requis
    @Required
    @Pattern(value = "^[A-Za-z0-9 ]{1,24}$",    message = "Pseudo non valable")
	private String pseudo;

    //Vérification si pas existant dans la bd  ?
    @Required
    @Pattern(value = "^(?=.{8,})(?=.*[A-Z]+)(?=.*[0-9]+).*",    message = "Mot de passe pas assez fort")//Au moins un chiffre, une majuscule et qui va entre 8 et 32 caractères
    private String password;

    //Grade de l'utilisateur
    @Required
    private String grade;

    //Constructeur par défaut où chaque nouvelle personne inscrite aura le grade joueur
    public User(){
            this.grade = "Joueur";
        }



    //Liste des getters et setters

    //Liste des getters et setters pour l'ID
    public long getId() {
        return id;
    }

    public void setId(long iden) {
        this.id = iden;
    }
	
    //Liste des getters et setters pour le grade
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    //Liste des getters et setters pour le statut    
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    //Liste des getters et setters pour le mot de passe    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    //Liste des getters et setters pour le pseudo    
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPseudo() {
        return pseudo;
    }
    
    //Méthode toString   
    public String toString() {
        return "pseudo: " + pseudo+ "identifiant: "+id;
    }
    
    //Réinitilise les points
	public void setPointZero(){
		points.clear();
	}
	
    //Ajoute des points
	public void setPoint(int n){
		points.add(n);
	}
    
    //Méthode calcule de points
	public int sommePoints(){
		int pts = 0;
		for ( int p: points ) {
		   pts += p;
		}
		return pts;
	  }
}
