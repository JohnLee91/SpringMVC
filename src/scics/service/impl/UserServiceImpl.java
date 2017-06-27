package scics.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import scics.dao.IUserDao;
import scics.pojo.User;
import scics.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService { 
    @Resource
    private IUserDao userDao;  
    @Override  
    public User getUserById(int userId) {  
        // TODO Auto-generated method stub
        return this.userDao.selectByPrimaryKey(userId);  
    }
    
    @Override  
    public int addUser(User user) {  
        // TODO Auto-generated method stub
        return this.userDao.insert(user);  
    }

	@Override
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		return this.userDao.selectAllUser();
	}
}  