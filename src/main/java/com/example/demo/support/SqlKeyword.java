package com.example.demo.support;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ClassUtil;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.example.demo.util.Func;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 定义常用的 sql关键字
 *
 * @author ljd
 */
public class SqlKeyword {
	private final static String SQL_REGEX = "'|%|--|insert|delete|select|count|group|union|drop|truncate|alter|grant|execute|exec|xp_cmdshell|call|declare|sql";
	private static final String DTO = "DTO";

	/**
	 * 条件构造器
	 *
	 * @param query 查询字段
	 * @param qw    查询包装类
	 */
	public static <T> void buildCondition(Map<String, Object> query, SqlWrapper<T> qw, Class<?> clazz, SqlKeywords keywords,Boolean isMultiple) {
		if (Func.isEmpty(query)) {
			return;
		}
		query.forEach((k, v) -> {
			Field field = ClassUtil.getDeclaredField(clazz,k);
			Object sqlKey = null;
			Object alias = null;
			if(Func.isNotEmpty(field)) {
				sqlKey = AnnotationUtil.getAnnotationValue(field, Conditions.class);
				alias = AnnotationUtil.getAnnotationValue(field, TableField.class);
			}
			if(Func.isNotEmpty(alias)){
				k = Convert.toStr(alias);
			}else {
				k = Func.humpToUnderline(Func.removeSuffix(k,DTO));
			}
			if(Func.isNotEmpty(v) && Func.isNotEmpty(sqlKey)) {
				SqlKeywords.valueOf(Convert.toStr(sqlKey)).approve(qw,k,v);
			}else if(Func.isNotEmpty(v)){
				SqlKeywords.valueOf(Convert.toStr(keywords)).approve(qw,k,v);
			}
			if(!k.endsWith(DTO) && isMultiple) {
				qw.getSqlSelected().append(" ").append(k).append(",");
			}
		});
		qw.selected(isMultiple,qw.getSqlSelected().subString(0,qw.getSqlSelected().length()-1));
	}

	/**
	 * 获取数据库字段
	 *
	 * @param column  字段名
	 * @param keyword 关键字
	 * @return String
	 */
	private static String getColumn(String column, String keyword) {
		return Func.humpToUnderline(Func.removeSuffix(column, keyword));
	}

	/**
	 * 把SQL关键字替换为空字符串
	 *
	 * @param param 关键字
	 * @return string
	 */
	public static String filter(String param) {
		if (param == null) {
			return null;
		}
		return param.replaceAll("(?i)" + SQL_REGEX, StringPool.EMPTY);
	}

}
