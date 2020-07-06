
package com.example.demo.support;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * 条件构造器包装
 *
 * @author ljd
 */
public class Condition {


	/**
	 * 获取mybatis plus中的QueryWrapper
	 *
	 * @param entity 实体
	 * @param <T>    类型
	 * @return QueryWrapper
	 */
	public static <T> QueryWrapper<T> getQueryWrapper(T entity) {
		return new QueryWrapper<>(entity);
	}

	/**
	 * 获取mybatis plus中的QueryWrapper
	 *
	 * @param keywords 排除的查询条件
	 * @param entity   实体类
	 * @param <T>     类型
	 * @return QueryWrapper
	 */
	public static <T> SqlWrapper<T> baseQueryWrapperr(T entity, SqlKeywords keywords,Boolean isMultiple) {
		SqlWrapper<T> qw = new SqlWrapper<>();
		SqlKeyword.buildCondition(BeanUtil.beanToMap(entity), qw,entity.getClass(),keywords,isMultiple);
		return qw;
	}
	public static <T> SqlWrapper<T> gets(T entity) {
		return baseQueryWrapperr(entity,SqlKeywords.EQUAL,true);
	}
	public static <T> SqlWrapper<T> get(T entity) {
		return baseQueryWrapperr(entity,SqlKeywords.EQUAL,false);
	}
	public static <T> SqlWrapper<T> getLike(T entity) {
		return baseQueryWrapperr(entity,SqlKeywords.LIKE,false);
	}
	public static <T> SqlWrapper<T> getsLike(T entity) {
		return baseQueryWrapperr(entity,SqlKeywords.LIKE,true);
	}
	public static <T> SqlWrapper<T> getsLikeRight(T entity) {
		return baseQueryWrapperr(entity,SqlKeywords.LIKE_RIGHT,true);
	}
	public static <T> SqlWrapper<T> getLikeRight(T entity) {
		return baseQueryWrapperr(entity,SqlKeywords.LIKE_RIGHT,false);
	}

}
