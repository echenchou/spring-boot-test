package ec.web.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


/** 
* 用户信息表
* 
* @coder ECHEN 
* @date 2017年3月28日 下午5:24:22
*/
@Entity
@Table(name="t_user")
public class User extends BaseEntity{

	/** */
	private static final long serialVersionUID = 9055391269646668181L;
	/**
	 * 唯一字段，根据规律生成，用来识别用户
	 */
	@Column(name="account")
 	@NotNull
	private String account;
	/**
	 * 名称
	 */
	@Column(name="name")
	private String name;
	/**
	 * 密文密码
	 */
	@Column(name="password")
	@NotNull
	private String password;
	/**
	 * 状态
	 */
	@Column(name="status")
	private Integer status;
	/**
	 * 创建时间（注册时间）
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
 	@NotNull
	private Date createTime;
	/**
	 * 最近修改时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_time")
 	@NotNull
	private Date updateTime;
	
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
	
}