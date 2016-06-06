package cn.springmvc.model;

/**
 * 
* @ClassName: 员工实体类
* @Description: TODO(这里用一句话描述这个类的作用)
* @author 黎力豪
* @date 2016年4月24日 下午12:51:57
*
 */
public class Staff {
	/**
	 * 唯一标识
	 */
	private int id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 年龄
	 */
	private String age;
	/**
	 * 职业
	 */
	private String job;
	
	
	public Staff() {
		super();
	}
	
	public Staff(int id, String name, String age, String job) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.job = job;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}

}
