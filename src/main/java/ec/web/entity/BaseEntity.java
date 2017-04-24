package ec.web.entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.springframework.data.domain.Persistable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

//import org.apache.commons.lang.builder.ToStringBuilder;
//import org.apache.commons.lang.builder.ToStringStyle;
//import javax.persistence.GeneratedValue;
//import org.hibernate.annotations.GenericGenerator;

/** 
* TODO 实体公共类，所有的实体都继承该对象
* 
* @coder ECHEN 
* @date 2016年5月9日 上午11:11:45
*/
@MappedSuperclass
public abstract class BaseEntity implements Persistable<Integer>{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(generator = "system-uuid")
//	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	@Override
	public boolean isNew() {
		return this.id == null;
	}


	/**
	 * 覆盖toString方法，目的显示所有JavaBean的属性值
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (obj == null) {
//			return false;
//		}
//
//		if (this == obj) {
//			return true;
//		}
//
//		if (!getClass().equals(obj.getClass())) {
//			return false;
//		}
//
//		BaseEntity rhs = (BaseEntity) obj;
//		return this.id == null ? false : this.id.equals(rhs.id);
//	}
}