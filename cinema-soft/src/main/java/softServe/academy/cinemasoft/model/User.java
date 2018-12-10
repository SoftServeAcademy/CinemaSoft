package softServe.academy.cinemasoft.model;

<<<<<<< HEAD
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

=======
import javax.persistence.*;
>>>>>>> c13ff632571da73d2b96c1d93ecf76f026c56af5
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

	private List<Comment> comments;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Collection<Role> roles;

	public User() {

<<<<<<< HEAD
	}
=======
    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;
>>>>>>> c13ff632571da73d2b96c1d93ecf76f026c56af5

	public User(String lastName, String userName, String email, String password) {
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.comments = new ArrayList();
	}

	public User(String firstName, String lastName, String userName, String email, String password,
			Collection<Role> roles) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

<<<<<<< HEAD
	public Integer getId() {
		return id;
	}
=======
    public User(String lastName, String userName, String email, String password) {
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.comments = new ArrayList<>();
    }
>>>>>>> c13ff632571da73d2b96c1d93ecf76f026c56af5

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

<<<<<<< HEAD
	public Collection<Role> getRoles() {
		return roles;
	}
=======

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Collection<Role> getRoles() {
        return roles;
    }
>>>>>>> c13ff632571da73d2b96c1d93ecf76f026c56af5

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
}
