package scics.service;

import java.util.List;

import scics.pojo.User;

public interface IUserService {  
    public User getUserById(int userId);  
    public int addUser(User user);
    public List<User> selectAllUser();
}  
