package com.devin.ssmlearn.user.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.devin.ssmlearn.user.biz.UserInfoService;
import com.devin.ssmlearn.user.dto.UserInfo;
import com.devin.ssmlearn.user.integration.UserInfoDAO;
import com.devin.ssmlearn.user.web.controller.UserInfoController;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoDAO userInfoDAO;
	@Autowired
	private PlatformTransactionManager ptm;
	@Autowired
	private TransactionTemplate transactionTemplate;

	private static Logger logger = Logger.getLogger(UserInfoController.class);

	@Override
	public List<UserInfo> listAllUserInfo() {
		return userInfoDAO.listAllUserInfo();
	}

	@Override
	public UserInfo getUserInfoById(String idLearnUser) {
		return userInfoDAO.getUserInfoById(idLearnUser);
	}

	@Override
	public void addUserInfo(UserInfo userInfo) {
		// 1、基于底层 API 的编程式事务管理
		// progromTx01AddUserInfo(userInfo);
		// 2、基于TransactionTemplate 的编程式事务管理
		// progromTx02AddUserInfo(userInfo);
		// 3、基于 @Transactional 的声明式事务管理<最常用>
		// declarativeTx01AddUserInfo(userInfo);
		// 4、基于 <tx> 命名空间的声明式事务管理
		declarativeTx01AddUserInfo(userInfo);
	}

	/**
	 * 基于底层 API 的编程式事务管理
	 * 
	 * @param userInfo
	 */
	public void progromTx01AddUserInfo(UserInfo userInfo) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = ptm.getTransaction(def);
		try {
			userInfoDAO.addUserInfo(userInfo);
		} catch (Exception e) {
			logger.error(e);
			ptm.rollback(status);
			logger.debug("HKH rollBack");
		}
		ptm.commit(status);
		logger.debug("HKH commit");

	}

	/**
	 * 基于TransactionTemplate 的编程式事务管理 第一种事务管理的代码散落在业务逻辑代码中，破坏了原有代码的条理性; Spring
	 * 提供了简化的方法，这就是 Spring 在数据访问层非常常见的 模板回调模式
	 * 
	 * @param userInfo
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void progromTx02AddUserInfo(UserInfo userInfo) {
		transactionTemplate.execute(new TransactionCallback() {
			public Object doInTransaction(TransactionStatus status) {
				Object result = null;
				try {
					userInfoDAO.addUserInfo(userInfo);
				} catch (Exception e) {
					status.setRollbackOnly();
					result = false;
					System.out.println("Transfer Error!");
				}
				return result;
			}
		});

	}

	/**
	 * 基于 @Transactional 的声明式事务管理 <最常用>
	 * 
	 * @Transactional 可以作用于接口、接口方法、类以及类方法上; 当作用于类上时，该类的所有 public 方法将都具有该类型的事务属性;
	 *                当作用于方法上时，该标注来覆盖类级别的定义
	 * @param userInfo
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void declarativeTx01AddUserInfo(UserInfo userInfo) {
		userInfoDAO.addUserInfo(userInfo);
	}

	/**
	 * 基于 <tx> 命名空间的声明式事务管理 Spring 2.x 引入了 <tx> 命名空间，结合使用 <aop>
	 * 命名空间，带给开发人员配置声明式事务的全新体验，
	 * 配置变得更加简单和灵活。总的来说，开发者只需基于<tx>和<aop>命名空间在XML中进行简答配置便可实现声明式事务管理
	 * 
	 * @param userInfo
	 */
	public void declarativeTx02AddUserInfo(UserInfo userInfo) {
		userInfoDAO.addUserInfo(userInfo);
	}

	public UserInfoDAO getUserInfoDAO() {
		return userInfoDAO;
	}

	public void setUserInfoDAO(UserInfoDAO userInfoDAO) {
		this.userInfoDAO = userInfoDAO;
	}
}
