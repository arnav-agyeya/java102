package com.survival.dataTransferObject;

public class RegisterLoginDetails {
	
	private String email_Id;
	private String user_Name;
	private Long phone_Number;
	private String user_Address;
	private String login_Role;
	private String login_Id;
	private String login_Password;
	
	public RegisterLoginDetails() {
		super();
	}

	public RegisterLoginDetails(String email_Id, String user_Name, Long phone_Number, String user_Address,
			String login_Role, String login_Id, String login_Password) {
		super();
		this.email_Id = email_Id;
		this.user_Name = user_Name;
		this.phone_Number = phone_Number;
		this.user_Address = user_Address;
		this.login_Role = login_Role;
		this.login_Id = login_Id;
		this.login_Password = login_Password;
	}

	public String getEmail_Id() {
		return email_Id;
	}

	public void setEmail_Id(String email_Id) {
		this.email_Id = email_Id;
	}

	public String getUser_Name() {
		return user_Name;
	}

	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}

	public Long getPhone_Number() {
		return phone_Number;
	}

	public void setPhone_Number(Long phone_Number) {
		this.phone_Number = phone_Number;
	}

	public String getUser_Address() {
		return user_Address;
	}

	public void setUser_Address(String user_Address) {
		this.user_Address = user_Address;
	}

	public String getLogin_Role() {
		return login_Role;
	}

	public void setLogin_Role(String login_Role) {
		this.login_Role = login_Role;
	}

	public String getLogin_Id() {
		return login_Id;
	}

	public void setLogin_Id(String login_Id) {
		this.login_Id = login_Id;
	}

	public String getLogin_Password() {
		return login_Password;
	}

	public void setLogin_Password(String login_Password) {
		this.login_Password = login_Password;
	}

		
}
