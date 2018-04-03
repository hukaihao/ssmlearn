package com.devin.ssmlearn.user.dto;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import com.alibaba.fastjson.JSON;
import com.devin.ssmlearn.user.util.GetGuidRandom;

/**
 * 
 * @author outlo
 *
 */
public class UserInfo {
	private String idLearnUser;

	private String name;

	private char sex;

	private String idType;

	private String idNo;

	private Date birthday;

	private int age;

	private String phoneNo;

	public UserInfo() {
	}

	public UserInfo(String name) {
		this.idLearnUser = GetGuidRandom.getGuid();
		this.name = name + StringUtils.substring(idLearnUser, 0, 2);
		this.sex = 'M';
		this.idType = "01";
		this.idNo = StringUtils.substring(idLearnUser, 0, 18);
		this.birthday = new DateTime().toDate();
		this.age = 18;
		this.phoneNo = StringUtils.substring(idLearnUser, 0, 11);
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this, true);
	}

	public String getIdLearnUser() {
		return idLearnUser;
	}

	public void setIdLearnUser(String idLearnUser) {
		this.idLearnUser = idLearnUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
}
