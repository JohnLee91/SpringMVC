package scics.test;

import java.lang.annotation.Documented;  
import java.lang.annotation.ElementType;  
import java.lang.annotation.Retention;  
import java.lang.annotation.RetentionPolicy;  
import java.lang.annotation.Target;  
/** 
 * 系统级别的service层自定义注解 
 * <br>拦截Controller 
 * @author ct 
 * 
 */  
@Target({ElementType.PARAMETER, ElementType.METHOD})//作用于参数或方法上  
@Retention(RetentionPolicy.RUNTIME)  
@Documented  
public @interface SystemServiceLog {  
    //模块名  
    String moduleName() default "";  
    //操作内容  
    String option() default "";  
}  