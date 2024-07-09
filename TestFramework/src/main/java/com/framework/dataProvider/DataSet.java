package com.framework.dataProvider;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @author Globant MTA Test Automation team [sagar.shinde,neha.batham,sparsh.gupta]
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSet {
	
	String NO_PARAMETER = "NO_PARAMETER";
	
	/**
	 * Parameter for data provider 
	 */
	String value() default DataSet.NO_PARAMETER;

}