package Moduls;

public class User {
    private int Id;
    private String UserName;
    private String PassWord;
    private String Type;
    private String Nom;
    private String Prenom;
    private String Tel;


    public User(){}
    public User(int Id){this.Id=Id;}

    public User(int Id,String UserName,String PassWord,String Type,String Nom,String Prenom,String Tel){
        this.Id=Id;
        this.UserName=UserName;
        this.PassWord=PassWord;
        this.Type=Type;
        this.Nom=Nom;
        this.Prenom=Prenom;
        this.Tel=Tel;
    }
    public User(String UserName,String PassWord){

        this.UserName=UserName;
        this.PassWord=PassWord;

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }


}
