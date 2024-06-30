

public class user {
    public String username;
    public String passhash;
    public boolean access = false;
    public String number;
    hashing console = new hashing();

    public user(String username, String pass, String number){
        this.username = username;
        this.number = number;
        this.passhash = pass;
    }

    public boolean check_access(String pass){
        if(console.hash(pass) == passhash) access = true;
        return access;
    }
    
}
