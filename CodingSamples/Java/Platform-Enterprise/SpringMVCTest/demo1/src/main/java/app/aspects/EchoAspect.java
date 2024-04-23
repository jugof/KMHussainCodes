package app.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EchoAspect {
    
    @Before("within(app.controllers.*)")
    public void onBeginControllerCall(JoinPoint point) {
        var method = point.getSignature();
        System.out.printf(">> Invoking %s::%s%n", method.getDeclaringTypeName(), method.getName());
    }

    @After("execution(public * app.components.*.*(..))")
    public void onEndComponentCall(JoinPoint point) {
        var method = point.getSignature();
        System.out.printf(">> Invoked %s::%s%n", method.getDeclaringTypeName(), method.getName());
    }
}
