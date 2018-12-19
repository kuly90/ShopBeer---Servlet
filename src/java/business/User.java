
package business;


public class User {
    private String userName;
    private String roleName;
    private String password;
    private int status;

    public User() {
    }

    public User(String userName, String roleName, String password, int status) {
        this.userName = userName;
        this.roleName = roleName;
        this.password = password;
        this.status = status;
    } 

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
