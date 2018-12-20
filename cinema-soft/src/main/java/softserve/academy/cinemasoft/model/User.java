package softserve.academy.cinemasoft.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String userName;

    @Column(unique = true)
    private String email;

    private String password;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

    public User() {

    }

    public User(String lastName, String userName, String email, String password) {
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.comments = new ArrayList<>();
    }

    public User(String firstName, String lastName, String userName, String email, String password, Collection<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

}
