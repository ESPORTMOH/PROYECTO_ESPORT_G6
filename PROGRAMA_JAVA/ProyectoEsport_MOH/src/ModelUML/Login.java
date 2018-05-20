package ModelUML;

/**
 * @author MIGUEL OLMO HERNANDO
 */
public class Login {

    private Integer codLogin;
    private String user;
    private String password;
    private String tipo;

    public Login() {
    }

    /**
     *
     * @param codLogin
     * @param user
     * @param password
     * @param tipo
     */
    public Login(Integer codLogin, String user, String password, String tipo) {
        this.codLogin = codLogin;
        this.user = user;
        this.password = password;
        this.tipo = tipo;
    }

    /**
     *
     * @param user
     * @param password
     */
    public Login(String user, String password) {
        this.user = user;
        this.password = password;
    }

    /**
     *
     * @param user
     * @param password
     * @param tipo
     */
    public Login(String user, String password, String tipo) {
        this.user = user;
        this.password = password;
        this.tipo = tipo;
    }

    /**
     *
     * @param codLogin
     */
    public Login(Integer codLogin) {
        this.codLogin = codLogin;
    }

    /**
     *
     * @return codLogin
     */
    public Integer getCodLogin() {
        return codLogin;
    }

    /**
     *
     * @return usew
     */
    public String getUser() {
        return user;
    }

    /**
     *
     * @param user 
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * 
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 
     * @return tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * 
     * @param tipo 
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * 
     * @param codLogin 
     */
    public void setCodLogin(Integer codLogin) {
        this.codLogin = codLogin;
    }

}
