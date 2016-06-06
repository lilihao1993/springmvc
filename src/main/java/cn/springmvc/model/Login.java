package cn.springmvc.model;
/**
 * 登陆对象
 * @author 黎力豪
 *
 */
public class Login {
	
	//id 唯一标识
	private String id;

	//用户登陆名
	private String username;
		//用户登陆密码
	private String password;
	
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
	public String getId() {
	return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + "]";
	}
	
	
}
