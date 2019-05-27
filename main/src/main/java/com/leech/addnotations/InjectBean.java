package com.leech.addnotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectBean {

	BeanType injectType() default BeanType.SINGLETON;
	
	enum BeanType{
		SINGLETON,UNIQUE;
	}
}