package FunctionLayer;

public class ReturnedUseres {

    public ReturnedUseres(int id, String email, String password, String role, int balance) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.balance = balance;
    }

    private int id;
    private String email;
    private String password;
    private String role;
    int balance;

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole( String role ) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance( int id ) {
        this.id = balance;
    }

    @Override
    public String toString() {
        return "Useres{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
