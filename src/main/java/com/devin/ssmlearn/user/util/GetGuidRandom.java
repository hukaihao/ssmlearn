package com.devin.ssmlearn.user.util;

import java.util.UUID;

public class GetGuidRandom {
	/**
	 * 产生32为随机数
	 * @return
	 */
	public static final String getGuid() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "");
	}
}
