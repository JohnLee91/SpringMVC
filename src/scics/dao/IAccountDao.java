package scics.dao;

import scics.pojo.Account;

/**
 * 转账案例DAO层接口
 * @author lenovo
 *
 */
public interface IAccountDao {
	/**
	 * 根据名称查找账户
	 * @param name
	 * @return
	 */
	public Account selectByName(String name);
	/**
	 * @param account	:转出账号信息
	 */
	public void outMoney(Account account);
	
	/**
	 * @param account	:转入账号信息
	 */
	public void inMoney(Account account);

}
