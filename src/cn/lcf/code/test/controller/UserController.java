package cn.lcf.code.test.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.lcf.code.test.service.UserService;
import com.shine.core.exception.ResponseResult;
import org.springframework.stereotype.Controller;
import com.shine.model.general.utils.page.Page;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.lcf.code.test.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@RequestMapping("eihView/resources/eih/useruser")
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public ResponseResult addUser(User user){ 
		userService.addUser(user);
		return ResponseResult.createSuccess(user);
	}

	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public ResponseResult findUserById(Integer id){ 
		User user=userService.findUserById(id);
		return ResponseResult.createSuccess(user);
	}

	@ResponseBody
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseResult updateUser(User user){ 
		userService.updateUser(user);
		return ResponseResult.createSuccess(user);
	}


	@ResponseBody
	@RequestMapping(value="search",method=RequestMethod.GET)
	public ResponseResult searchUsers(){ 
		Page<User> users = userService.searchUsers();
		return ResponseResult.createSuccess(users);
	}
}