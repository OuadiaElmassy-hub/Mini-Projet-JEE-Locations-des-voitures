package metier;

import java.io.Serializable;

public class Client implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int idClient;
	private String nPermis;
	private String name;
	private String email;
	private String pwd;
	
	public Client() {
		super();
	}
	
	public Client(String nPermis, String name, String email, String pwd) {
		super();
		this.nPermis = nPermis;
		this.name = name;
		this.email = email;
		this.pwd = pwd;
	}
	
	public int getIdClient() {
		return idClient;
	}
	
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	
	public String getNPermis() {
		return nPermis;
	}

	public void setNPermis(String nPermis) {
		this.nPermis = nPermis;
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
	
	public String getPassWord() {
		return pwd;
	}
	
	public void setPassWord(String pwd) {
		this.pwd = pwd;
	}
}
