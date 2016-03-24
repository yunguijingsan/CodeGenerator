package cn.lcf.code.test.service.impl;

import cn.lcf.code.test.service.UserService;
import com.shine.model.general.utils.page.Page;
import cn.lcf.code.test.model.User;
import cn.lcf.code.test.dao.UserDao;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;


@Service
public class UserServiceImpl  implements UserService{
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);

	private UserDao userDao;

	public void addUser(User user){ 
		userDao.addUser(user);
	}

	public User findUserById(Integer id){ 
		User user=userDao.findUserById(id);
		return user;
	}

	public void updateUser(User user){ 
		userDao.updateUser(user);
	}

	public Page<User> searchUsers(){ 
		Page<User> users = userDao.searchUsers();
		return users;
	}
}