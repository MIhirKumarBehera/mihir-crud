package com.hutech.loginproject.model.user;

import java.util.List;
import java.util.Set;

import com.hutech.loginproject.model.post.Post;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="user_table")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private long id;
	@Column(name ="user_name")
	private String name;
	@Column(name= "email")
	private String email;
	private String password;
	private String about;
	@OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Post> posts;

	 @ManyToMany(cascade =CascadeType.ALL)
	 @JoinTable(name="UserRole",joinColumns = 
	 @JoinColumn(name="user_table",referencedColumnName="user_id"),inverseJoinColumns = @JoinColumn(name="userRole  ",referencedColumnName = "roleid"))
	 private Set<UserRole> role;
	
	
}
