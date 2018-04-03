package com.devin.ssmlearn.user.biz;

import java.util.List;

import com.devin.ssmlearn.user.dto.UserInfo;

/**
 * 
 * @author outlo
 *
 */
public interface UserInfoService {
	/**
	 * 查詢所有的user
	 * 
	 * @return
	 */
	List<UserInfo> listAllUserInfo();

	/**
	 * 根据id查找某个具体的user
	 * 
	 * @param idLearnUser
	 * @return
	 */
	UserInfo getUserInfoById(String idLearnUser);

	/**
	 * 新增user
	 * 
	 * @param userInfo
	 */
	void addUserInfo(UserInfo userInfo);

}
