package ec.web.dao;


import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import ec.web.entity.User;


/** 
* 用户数据操作接口
* 
* @coder ECHEN 
* @date 2016年9月12日 下午4:03:00
*/
@Transactional
public interface UserDao extends CrudRepository<User, Integer> {

	
	User findByAccount(String account);
	
}
