package SpringBoot.CarWebsite.Model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
public class User{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long userID;
    @OneToMany(targetEntity = Car.class)
    @JoinColumn(name="userID")
    private Set<Car> cars;
    private String name;
    private String username;
    private String password;
    private String role;

    public User() {
    }

    public User(Long userId, String name, String username, String password, String role) {
        this.userID = userId;
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(String name, String username, String password, String role) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Long getUserId() {
        return userID;
    }

    public void setUserId(Long userId) {
        this.userID = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userID +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
