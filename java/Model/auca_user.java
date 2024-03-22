package Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name= "auca_user")
public class auca_user {
	
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;
 
 @Column(name = "email")
 private String email;
	    
 @Column(name = "password")
 private String password;
	    
 @Column(name = "role")
 private String role;

public auca_user() {
	
	super();
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

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

}