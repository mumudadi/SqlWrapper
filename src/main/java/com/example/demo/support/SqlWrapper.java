package com.example.demo.support;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.text.StrBuilder;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ArrayUtils;
import com.baomidou.mybatisplus.core.toolkit.StringPool;

public class SqlWrapper<T> extends QueryWrapper<T> {
    private StrBuilder sqlSelect = StrBuilder.create("select");
    private StrBuilder sqlFrom = StrBuilder.create();

    public SqlWrapper<T> from(Class<?> po, String as,String tableName) {
        if(StrUtil.isEmpty(tableName)){
            tableName = AnnotationUtil.getAnnotation(po, TableName.class).value();
        }
        this.sqlFrom = sqlFrom.append(" from ").append(tableName).append(" ").append(as);
        this.select(sqlSelect.toString()+sqlFrom.toString());
        return this;
    }
    public SqlWrapper<T> from(Class<?> po) {
        return from(po,"","");
    }
    public SqlWrapper<T> from(Class<?> po,String as) {
        return from(po,as,"");
    }
    public SqlWrapper<T> from(String tableName,String as) {
        return from(null,as,tableName);
    }

    public SqlWrapper<T> join(Class<?> po,String as, String on,String join,String tableName) {
        if(StrUtil.isEmpty(tableName)){
            tableName = AnnotationUtil.getAnnotation(po, TableName.class).value();
        }
        this.sqlFrom.append(" ").append(join).append(" ").append(tableName)
                .append(" ").append(as).append(" on ").append(on);
        this.select(sqlSelect.toString()+sqlFrom.toString());
        return this;
    }
    public SqlWrapper<T> leftJoin(Class<?> po,String as, String on) {
        join(po,as,on,"left join","");
        return this;
    }
    public SqlWrapper<T> leftJoin(String tableName,String as, String on) {
        join(null,as,on,"left join",tableName);
        return this;
    }
    public SqlWrapper<T> leftJoin(Class<?> po, String on) {
        return leftJoin(po,"",on);
    }
    public SqlWrapper<T> rightJoin(Class<?> po,String as, String on) {
        join(po,as,on,"right join","");
        return this;
    }
    public SqlWrapper<T> rightJoin(String tableName,String as, String on) {
        join(null,as,on,"right join",tableName);
        return this;
    }
    public SqlWrapper<T> rightJoin(Class<?> po, String on) {
        return rightJoin(po,"",on);
    }
    public SqlWrapper<T> innerJoin(Class<?> po,String as, String on) {
        join(po,as,on,"inner join","");
        return this;
    }
    public SqlWrapper<T> innerJoin(String tableName,String as, String on) {
        join(null,as,on,"inner join",tableName);
        return this;
    }
    public SqlWrapper<T> innerJoin(Class<?> po, String on) {
        return innerJoin(po,"",on);
    }

    public StrBuilder getSqlFrom() {
        return this.sqlFrom;
    }

    public StrBuilder getSqlSelected(){
        return this.sqlSelect;
    }
    public SqlWrapper<T> selected(Boolean isMultiple,String... columns) {
        if (ArrayUtils.isNotEmpty(columns) && isMultiple) {
            sqlSelect.clear().append(String.join(StringPool.COMMA, columns));
            this.select(sqlSelect.toString()+sqlFrom.toString());
        }
        return this;
    }
}
