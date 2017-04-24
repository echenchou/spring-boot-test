
package ec.web.entity.vo;

import java.util.HashMap;

import org.codehaus.jackson.map.annotate.JsonSerialize;


@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class JsonVo<T> {
	/**
	 * 结果
	 */
	private boolean success;
	/**
	 * 成功的消息
	 */
	private String msg;

	/**
	 * 具体每个输入错误的消息
	 */
	private HashMap<String, String> errors = new HashMap<String, String>();

	/**
	 * 返回的数据
	 */
	private T t;


	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public HashMap<String, String> getErrors() {
		return errors;
	}

	public void setErrors(HashMap<String, String> errors) {
		this.errors = errors;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public void check() throws Exception {
		if (this.getErrors().size() > 0) {
			this.setSuccess(false);
			throw new Exception("有错误发生");
		} else {
			this.setSuccess(true);
		}
	}
}
