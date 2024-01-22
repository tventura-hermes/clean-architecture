package users.domain;

public class user implements userInterface{
    private String user;
    private String password;
    
    public user() {
    }

    public user(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

}
