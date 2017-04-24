package ec.web.controller;


import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ec.util.AuthUtils;
import ec.web.entity.User;
import ec.web.entity.vo.JsonVo;




/** 
* TODO
* 
* @coder ECHEN 
* @date 2016年5月16日 上午10:36:59
*/
@Controller
@RequestMapping("/user")
public class UserC extends BaseC{
	
	@RequestMapping("/login.json")
	@ResponseBody
	public JsonVo<User> login(HttpServletRequest request,String account,String pwd){
		HashMap<String, String> errors = new HashMap<>();
		JsonVo<User> jsonVo = new JsonVo<User>();
		jsonVo.setSuccess(false);
		User user = userService.getByAccount(account);
		if(user!=null){
			if(user.getStatus()==0){
				if(AuthUtils.passwordEquals(pwd, user.getPassword())){
					request.getSession().setAttribute("user", user);
					jsonVo.setT(user);
					
					jsonVo.setSuccess(true);
				}else {
					errors.put("error", "密码错误！");
				}
			}else if(user.getStatus()==1){
				errors.put("error", "用户未经审核！");
			}else if(user.getStatus()==2){
				errors.put("error", "用户审核不通过！");
			}else if(user.getStatus()==3){
				errors.put("error", "用户已经销户！");
			}
		}else {
			errors.put("error", "用户不存在！");
		}
		jsonVo.setErrors(errors);
		return jsonVo;
	}
	
	@RequestMapping("/register.json")
	@ResponseBody
	public JsonVo<User> register(String account,String pwd){
		JsonVo<User> jsonVo = new JsonVo<User>();
		jsonVo.setSuccess(false);
		HashMap<String, String> errors = new HashMap<>();
		if(StringUtils.isNoneBlank(account) && StringUtils.isNoneBlank(pwd)){
			User user = userService.getByAccount(account);
			if(user==null){
				user = new User();
				user.setAccount(account);
				user.setPassword(AuthUtils.MD5(pwd));
				userService.register(user);
				jsonVo.setSuccess(true);
			}else {
				errors.put("error", "用户已存在！");
			}
		}
		jsonVo.setErrors(errors);
		return jsonVo;
	}
}
