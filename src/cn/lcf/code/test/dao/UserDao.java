package cn.lcf.code.test.dao;

import com.shine.model.general.utils.page.Page;
import cn.lcf.code.test.model.User;

public interface UserDao {

	public void addUser(User user);

	public User findUserById(Integer id);

	public void updateUser(User user);

	public Page<User> searchUsers();
}