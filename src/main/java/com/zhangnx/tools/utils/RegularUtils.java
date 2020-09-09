package com.zhangnx.tools.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularUtils {


	/**
	 * 是否包含中文
	 *
	 * @param str
	 * @return
	 */
	public static boolean isContainChinese(String str) {
		String reg = "[\u4e00-\u9fa5]";
		Pattern compile = Pattern.compile(reg);
		Matcher m = compile.matcher(str);
		if (m.find()) {
			return true;
		}
		return false;
	}


	/**
	 * 统计中文字符
	 *
	 * @param text
	 * @return
	 */
	public static int countChinese(String text) {
		int amount = 0;
		for (int i = 0; i < text.length(); i++) {
			boolean matches = Pattern.matches("^[\u4E00-\u9Fa5]{0,}$", text.charAt(i) + "");
			if (matches) {
				amount++;
			}
		}
		return amount;
	}
}
