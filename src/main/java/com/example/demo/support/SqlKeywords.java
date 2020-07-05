package com.example.demo.support;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;

public enum SqlKeywords implements ConditionService {
    EQUAL(){
        @Override
        public void approve(SqlWrapper<?> qw, String k, Object v) {
            qw.eq(k,v);
        }
    },
    NOT_EQUAL(){
        @Override
        public void approve(SqlWrapper<?> qw, String k, Object v) {
            qw.ne(k,v);
        }
    },
    LIKE(){
        @Override
        public void approve(SqlWrapper<?> qw, String k, Object v) {
            qw.like(k,v);
        }
    },
    NOT_LIKE(){
        @Override
        public void approve(SqlWrapper<?> qw, String k, Object v) {
            qw.notLike(k,v);
        }
    },
    LIKE_RIGHT(){
        @Override
        public void approve(SqlWrapper<?> qw, String k, Object v) {
            qw.likeRight(k,v);
        }
    },
    LIKE_LEFT(){
        @Override
        public void approve(SqlWrapper<?> qw, String k, Object v) {
            qw.likeLeft(k,v);
        }
    },
    GT(){
        @Override
        public void approve(SqlWrapper<?> qw, String k, Object v) {
            qw.gt(k,v);
        }
    },
    LT(){
        @Override
        public void approve(SqlWrapper<?> qw, String k, Object v) {
            qw.lt(k,v);
        }
    },
    GE(){
        @Override
        public void approve(SqlWrapper<?> qw, String k, Object v) {
            qw.ge(k,v);
        }
    },
    LE(){
        @Override
        public void approve(SqlWrapper<?> qw, String k, Object v) {
            qw.le(k,v);
        }
    },
    IS_NULL(){
        @Override
        public void approve(SqlWrapper<?> qw, String k, Object v) {
            qw.isNull(k);
        }
    },
    NOT_NULL(){
        @Override
        public void approve(SqlWrapper<?> qw, String k, Object v) {
            qw.isNotNull(k);
        }
    },
    IGNORE(){
        @Override
        public void approve(SqlWrapper<?> qw, String k, Object v) {
            return;
        }
    },
    LIKE_DATE(){
        @Override
        public void approve(SqlWrapper<?> qw, String k, Object v) {
            qw.likeRight(k, DateUtil.formatDate(Convert.toDate(v)));
        }
    },
    BETWEEN(){
        @Override
        public void approve(SqlWrapper<?> qw, String k, Object v) {
            String[] doubleStr = Convert.toStr(v).split(",");
            qw.between(k,doubleStr[0],doubleStr[1]);
        }
    },
    ;


}
