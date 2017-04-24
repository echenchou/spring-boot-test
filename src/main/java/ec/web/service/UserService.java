package ec.web.service;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.web.dao.UserDao;
import ec.web.entity.User;


/** 
* 用户信息服务
* 
* @coder ECHEN 
* @date 2017年3月28日 下午5:30:34
*/
@Service
public class UserService { 
	@Autowired
	private UserDao userDao;
	
	public User getByAccount(String account){
		return userDao.findByAccount(account);
	}
	
	public User update(User user) {
		// TODO Auto-generated method stub
		Date date = new Date();
		user.setUpdateTime(date);
		return userDao.save(user);
	}
	
	@Transactional
	public User register(User user) {
		// TODO Auto-generated method stub
		Date date = new Date();
		user.setCreateTime(date);
		user.setUpdateTime(date);
		user.setStatus(0);
		User res = userDao.save(user);
		return res;
	}
	
}
