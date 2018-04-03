package com.devin.ssmlearn.user.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.devin.ssmlearn.user.biz.UserInfoService;
import com.devin.ssmlearn.user.dto.UserInfo;
import com.devin.ssmlearn.user.util.GetGuidRandom;

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {
	@Autowired
	private UserInfoService userInfoService;

	private static Logger logger = Logger.getLogger(UserInfoController.class);

	@RequestMapping("/showUserInfoList")
	public String showUserInfoList(Model model) {
		List<UserInfo> userInfoList = userInfoService.listAllUserInfo();

		model.addAttribute("userInfoList", userInfoList);

		return "showUserInfoList";
	}

	@RequestMapping(value = "/addUserInfo", method = RequestMethod.GET)
	public String addUserInfo(@RequestParam("name") String name, Model model) {
		logger.debug("addUserInfo start...");

		UserInfo userInfo = new UserInfo(name);
		userInfoService.addUserInfo(userInfo);

		model.addAttribute("successTip", "success add on userInfo " + userInfo.getName());

		logger.debug("addUserInfo end...");
		return "addUserInfo";
	}

	@RequestMapping(value = "/addUserFormView", method = RequestMethod.GET)
	private String addUserFormView() {
		return "addUserInfoPost";
	}

	@RequestMapping(value = "/addUserInfoPost", method = RequestMethod.POST)
	public String addUserInfoPost(@ModelAttribute UserInfo userInfo, Model model) {
		logger.debug("addUserInfo start...");

		userInfo.setIdLearnUser(GetGuidRandom.getGuid());
		userInfo.setBirthday(new DateTime().toDate());
		userInfo.setPhoneNo("00000000000");
		userInfoService.addUserInfo(userInfo);

		model.addAttribute("successTip", "success add on userInfo " + userInfo.getName());

		logger.debug("addUserInfo end...");
		return "addUserInfo";
	}

	@RequestMapping("/showUserInfo")
	@ResponseBody
	public UserInfo showUserInfo(String idLearnUser) {
		return userInfoService.getUserInfoById(idLearnUser);
	}

}
