package com.devin.ssmlearn.user.integration;

import java.util.List;

import com.devin.ssmlearn.user.dto.UserInfo;

/**
 * 
 * @author outlo
 *
 */
public interface UserInfoDAO {

	/**
	 * 查詢所有的user
	 * 
	 * @return
	 */
	List<UserInfo> listAllUserInfo();

	/**
	 * ͨ根据idLearn查找user
	 * 
	 * @param idLearnUser
	 * @return
	 */
	public UserInfo getUserInfoById(String idLearnUser);
	/**
	 * 新增userInfo
	 * @param userInfo
	 */
	public void addUserInfo(UserInfo userInfo);
	
}
