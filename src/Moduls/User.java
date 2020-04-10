package Moduls;

public class User {
    private int Id;
    private String UserName;
    private String PassWord;
    private String Type;

    public User(){}

    public User(int Id,String UserName,String PassWord,String Type){
        this.Id=Id;
        this.UserName=UserName;
        this.PassWord=PassWord;
        this.Type=Type;
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

}
