package scics.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import scics.dao.IAccountDao;
import scics.pojo.Account;
import scics.service.IAccountService;

/**
 * 转账案例的业务层实现类
 * @author lenovo
 *
 */

/**
 * @Transactional注解中的属性：
 * propagation	:事务的传播行为
 * isolation	:事务的隔离级别
 * readOnly		:只读
 * rollbackFor	:发生哪些异常回滚
 * noRollbackFor:发生哪些异常不回滚
 */
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,readOnly=false)
@Service("accountService")
public class AccountServiceImpl implements IAccountService {
	
	@Resource
	private IAccountDao accountDao;
	//注入事务管理的模板，编程式事务管理
//	@Resource
//	private TransactionTemplate transactionTemplate;

	/**
	 * @param out	:转出账号
	 * @param in	:转入账号
	 * @param money	:转账金额
	 */
/*	@Override
	public void transfer(final String out, final String in, final Double money) {
		//编程式的事务管理，不常用
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				Account outAccount = accountDao.selectByName(out);
				outAccount.setMoney(money);
				accountDao.outMoney(outAccount);
				Account inAccount = accountDao.selectByName(in);
				//int i=1/0;//异常
				inAccount.setMoney(money);
				accountDao.inMoney(inAccount);
			}
		});
	}*/
	
	/**
	 * 声明式事务管理
	 */
	@Override
	public void transfer(final String out, final String in, final Double money) {
		Account outAccount = accountDao.selectByName(out);
		outAccount.setMoney(money);
		accountDao.outMoney(outAccount);
		Account inAccount = accountDao.selectByName(in);
		//int i=1/0;//异常
		inAccount.setMoney(money);
		accountDao.inMoney(inAccount);
	}

}
