package com.lejingw.apps.myspring3.annotation.bean.qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Qualifier;

/** 表示使用Oracle相关 */
@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface DataSourceType {
	String ip() default "localhost"; // 指定ip,用于多数据源情况

	DataBase database() default DataBase.MYSQL;// 指定数据库类型
}
