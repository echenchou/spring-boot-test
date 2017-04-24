package ec.web.controller;


import org.springframework.beans.factory.annotation.Autowired;

import ec.web.service.UserService;


/** 
* TODO
* 
* @coder ECHEN 
* @date 2016年5月23日 下午5:04:19
*/
public class BaseC {
	
	@Autowired
	protected UserService userService;
	
	
}
