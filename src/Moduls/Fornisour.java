package Moduls;

public class Fornisour{
     private int ID;
     private String Nom;
     private String prenom;
     private String tel;
     private String Email;
  public Fornisour(){}
  public Fornisour(int ID,String Nom,String prenom,String tel,String Email){
      this.ID=ID;
      this.Nom=Nom;
      this.prenom=prenom;
      this.tel=tel;
      this.Email=Email;
  }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
