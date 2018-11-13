package com.br.nice.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.br.nice.model.User;
import com.br.nice.service.UserService;
import com.br.nice.util.MsgFeedBackUser;

@ManagedBean
@RequestScoped
public class UserController implements Serializable {
	private static final long serialVersionUID = 1L;

	private User user = new User();
	UserService userService = new UserService();
	private String userSuccess;
	private List<User> users;
	

	private String confirmPassword;

	public String newCad() {
		this.userSuccess = "userSuccess";

		this.user = new User();
		this.confirmPassword = new String();
		this.user.setEnabled(true);
		return "/public/newCad?faces-redirect=true";
	}

	
public String update() {
		Long userID = user.getId();
		user = userService.charge(userID);
		this.confirmPassword = this.user.getPassword();
		return "/public/newCad";
	}

	public String save() {

		String password = this.user.getPassword();
		if (!password.equals(confirmPassword)) {
			MsgFeedBackUser.AddmessageAtention("A senha não foi confirmada corretamente");
			return null;
		}
		UserService service = new UserService();
		service.save(this.user);
		this.user = new User();
		return this.userSuccess;
	}

	public String delete() {
		UserService userService = new UserService();
		userService.delete(user);
		this.users = null;
		MsgFeedBackUser.AddmessageSuccess("O usuario\b " + user.getName() + " foi excluido com sucesso!");
		return null;
	}

	public String status() {
		if (this.user.isEnabled())
			this.user.setEnabled(false);
		else
			this.user.setEnabled(true);

		UserService userService = new UserService();
		userService.save(user);
		return null;
	}

	public List<User> getUsers() {
		if (this.users == null) {
			UserService userService = new UserService();
			this.users = userService.list();
		}
		return this.users;
	}

	
	
	public User getUser() {
		return user;
	}

	public String getUserSuccess() {
		return userSuccess;
	}

	public void setUserSuccess(String userSuccess) {
		this.userSuccess = userSuccess;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
