
package com.example.demo.util;


import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import org.springframework.lang.Nullable;

import java.util.Arrays;

/**
 *
 *
 * @author ljd
 */
public class Func {

	/**
	 * 对象组中是否存在 Empty Object
	 *
	 * @param os 对象组
	 * @return boolean
	 */
	public static boolean hasEmpty(Object... os) {
		for (Object o : os) {
			if (isEmpty(o)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Determine whether the given object is empty:
	 * i.e. {@code null} or of zero length.
	 *
	 * @param obj the object to check
	 * @return 数组是否为空
	 */
	public static boolean isEmpty(@Nullable Object obj) {
		return ObjectUtil.isEmpty(obj);
	}
	public static boolean isNotEmpty(@Nullable Object obj) {
		return !isEmpty(obj);
	}
	/**
	 * 驼峰转下划线
	 *
	 * @param para 字符串
	 * @return String
	 */
	public static String humpToUnderline(String para) {
		para = lowerFirst(para);
		StringBuilder sb = new StringBuilder(para);
		int temp = 0;
		for (int i = 0; i < para.length(); i++) {
			if (Character.isUpperCase(para.charAt(i))) {
				sb.insert(i + temp, "_");
				temp += 1;
			}
		}
		return sb.toString().toLowerCase();
	}
	/**
	 * 首字母变小写
	 *
	 * @param str 字符串
	 * @return {String}
	 */
	public static String lowerFirst(String str) {
		char firstChar = str.charAt(0);
		if (firstChar >= 'A' && firstChar <= 'Z') {
			char[] arr = str.toCharArray();
			arr[0] += ('a' - 'A');
			return new String(arr);
		}
		return str;
	}
	/**
	 * 去掉指定后缀
	 *
	 * @param str    字符串
	 * @param suffix 后缀
	 * @return 切掉后的字符串，若后缀不是 suffix， 返回原字符串
	 */
	public static String removeSuffix(CharSequence str, CharSequence suffix) {
		if (isEmpty(str) || isEmpty(suffix)) {
			return StringPool.EMPTY;
		}

		final String str2 = str.toString();
		if (str2.endsWith(suffix.toString())) {
			return subPre(str2, str2.length() - suffix.length());
		}
		return str2;
	}
	/**
	 * 切割指定位置之前部分的字符串
	 *
	 * @param string  字符串
	 * @param toIndex 切割到的位置（不包括）
	 * @return 切割后的剩余的前半部分字符串
	 */
	public static String subPre(CharSequence string, int toIndex) {
		return sub(string, 0, toIndex);
	}

	public static String sub(CharSequence str, int fromIndex, int toIndex) {
		if (isEmpty(str)) {
			return StringPool.EMPTY;
		}
		int len = str.length();

		if (fromIndex < 0) {
			fromIndex = len + fromIndex;
			if (fromIndex < 0) {
				fromIndex = 0;
			}
		} else if (fromIndex > len) {
			fromIndex = len;
		}

		if (toIndex < 0) {
			toIndex = len + toIndex;
			if (toIndex < 0) {
				toIndex = len;
			}
		} else if (toIndex > len) {
			toIndex = len;
		}

		if (toIndex < fromIndex) {
			int tmp = fromIndex;
			fromIndex = toIndex;
			toIndex = tmp;
		}

		if (fromIndex == toIndex) {
			return StringPool.EMPTY;
		}

		return str.toString().substring(fromIndex, toIndex);
	}

	public static int toInt(@Nullable final String str, final int defaultValue) {
		if (str == null) {
			return defaultValue;
		}
		try {
			return Integer.valueOf(str);
		} catch (final NumberFormatException nfe) {
			return defaultValue;
		}
	}
	public static String[] toStrArray(String split, String str) {
		if (StrUtil.isBlank(str)) {
			return new String[]{};
		}
		return str.split(split);
	}
	public static String[] toStrArray(String str) {
		return toStrArray(",", str);
	}

	public static boolean nullSafeEquals(@Nullable Object o1, @Nullable Object o2) {
		if (o1 == o2) {
			return true;
		} else if (o1 != null && o2 != null) {
			if (o1.equals(o2)) {
				return true;
			} else {
				return o1.getClass().isArray() && o2.getClass().isArray() ? arrayEquals(o1, o2) : false;
			}
		} else {
			return false;
		}
	}

	private static boolean arrayEquals(Object o1, Object o2) {
		if (o1 instanceof Object[] && o2 instanceof Object[]) {
			return Arrays.equals((Object[])((Object[])o1), (Object[])((Object[])o2));
		} else if (o1 instanceof boolean[] && o2 instanceof boolean[]) {
			return Arrays.equals((boolean[])((boolean[])o1), (boolean[])((boolean[])o2));
		} else if (o1 instanceof byte[] && o2 instanceof byte[]) {
			return Arrays.equals((byte[])((byte[])o1), (byte[])((byte[])o2));
		} else if (o1 instanceof char[] && o2 instanceof char[]) {
			return Arrays.equals((char[])((char[])o1), (char[])((char[])o2));
		} else if (o1 instanceof double[] && o2 instanceof double[]) {
			return Arrays.equals((double[])((double[])o1), (double[])((double[])o2));
		} else if (o1 instanceof float[] && o2 instanceof float[]) {
			return Arrays.equals((float[])((float[])o1), (float[])((float[])o2));
		} else if (o1 instanceof int[] && o2 instanceof int[]) {
			return Arrays.equals((int[])((int[])o1), (int[])((int[])o2));
		} else if (o1 instanceof long[] && o2 instanceof long[]) {
			return Arrays.equals((long[])((long[])o1), (long[])((long[])o2));
		} else {
			return o1 instanceof short[] && o2 instanceof short[] ? Arrays.equals((short[])((short[])o1), (short[])((short[])o2)) : false;
		}
	}
}
