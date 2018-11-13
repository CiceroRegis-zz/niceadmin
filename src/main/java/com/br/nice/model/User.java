package com.br.nice.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "table_user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private String email;

	@Column(length = 60)
	private String login;

	@Column(length = 60)
	private String password;

	private Date birthday;

	private String mobile;

	private String language;

	private boolean enabled;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<UserRole> userRole = new HashSet<UserRole>(0);

	
	public User(String login, String password, boolean enabled, boolean b, boolean c, boolean d, List<GrantedAuthority> authorities) {
		this.login = login;
		this.password = password;
		this.enabled = enabled;
	}

	
	public User() {
	}
	

	public User(Long id, String name, String email, String login, String password, Date birthday, String mobile,
			String language, boolean enabled) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.login = login;
		this.password = password;
		this.birthday = birthday;
		this.mobile = mobile;
		this.language = language;
		this.enabled = enabled;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public Set<UserRole> getUserRole() {
		return userRole;
	}


	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}


	@Transient
	public String getActiveFormatted() {
		String ActiveFormatted = "Inativo";

		if (enabled) {
			ActiveFormatted = "Ativo";
		}

		return ActiveFormatted;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
