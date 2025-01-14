package fr.uge.jee.aop.students;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
@Component
@Aspect
public class Config {

    @Before("execution(* fr.uge.jee.aop.students.RegistrationService.create*(..))")
    public void printBefore(JoinPoint joinPoint){
        System.out.println("Before create");
    }

    @AfterReturning(value="execution(* fr.uge.jee.aop.students.RegistrationService.create*(..))", returning = "returnValue")
    public void printBefore(JoinPoint joinPoint, Object returnValue){
        System.out.println("After create");
    }
}
