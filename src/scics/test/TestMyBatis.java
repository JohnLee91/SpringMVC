package scics.test;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import scics.pojo.User;
import scics.service.IAccountService;
import scics.service.IUserService;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
  
public class TestMyBatis {  
    private static Logger logger = Logger.getLogger(TestMyBatis.class);  
    private ApplicationContext ac = null;  
    @Resource  
    private IUserService userService = null;
    @Resource  
    private IAccountService accountService = null;
  
    @Before  
    public void before() {  
        ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");  
        userService = (IUserService) ac.getBean("userService");  
        accountService = (IAccountService) ac.getBean("accountService");
    }  
  
    @Test  
    public void test1() {  
        User user = userService.getUserById(1);  
        System.out.println(user.getUserName());  
        logger.info("值："+user.getUserName());
        logger.info(JSON.toJSONString(user));  
    }
    
    /**
     * Spring的编程式事务管理测试
     */
    @Test
    public void accountTest(){
    	accountService.transfer("aaa", "bbb", 200d);
    }
    
    /**
     * Spring的声明式事务管理方式二：基于AspectJ的XML方式的配置。
     */
    @Test
    public void accountTest1(){
    	accountService.transfer("aaa", "bbb", 200d);
    }
}
