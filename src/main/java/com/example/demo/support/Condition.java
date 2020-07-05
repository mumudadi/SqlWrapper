/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE 3.0;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
	public static <T> SqlWrapper<T> baseQueryWrapperr(T entity, SqlKeywords keywords) {
		SqlWrapper<T> qw = new SqlWrapper<>();
		SqlKeyword.buildCondition(BeanUtil.beanToMap(entity), qw,entity.getClass(),keywords);
		return qw;
	}
	public static <T> SqlWrapper<T> get(T entity) {
		return baseQueryWrapperr(entity,SqlKeywords.EQUAL);
	}
	public static <T> SqlWrapper<T> getLike(T entity) {
		return baseQueryWrapperr(entity,SqlKeywords.LIKE);
	}
	public static <T> SqlWrapper<T> getLikeRight(T entity) {
		return baseQueryWrapperr(entity,SqlKeywords.LIKE_RIGHT);
	}

}
