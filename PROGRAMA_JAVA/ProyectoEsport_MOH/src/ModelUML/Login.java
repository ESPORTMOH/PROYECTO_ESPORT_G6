package ModelUML;

/**
 * @author MIGUEL
 */
public class Login {

    private Integer codLogin;
    private String user;
    private String password;
    private String tipo;

    public Login() {
    }

    public Login(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public Login(String user, String password, String tipo) {
        this.user = user;
        this.password = password;
        this.tipo = tipo;
    }
    
    public Login(Integer codLogin) {
        this.codLogin = codLogin;
    }

    public Integer getCodLogin() {
        return codLogin;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    

}
