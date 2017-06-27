package scics.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import scics.pojo.User;
import scics.service.IUserService;
@Service
public class Hahaha implements IUserService{

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return new User("haha","hahaha",12);
	}

	@Override
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

}
