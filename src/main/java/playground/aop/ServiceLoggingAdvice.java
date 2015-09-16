package playground.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class ServiceLoggingAdvice implements Ordered {

    public static final Logger LOGGER = LoggerFactory.getLogger(ServiceLoggingAdvice.class);

    @Pointcut("execution(public * playground.service.impl.*.*(..))")
    public void pc() {}

    @Around("pc()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        final Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        long start = System.currentTimeMillis();
        final Object obj = joinPoint.proceed();
        long end = System.currentTimeMillis();
        LOGGER.info("{} - ({} millis)", method, end - start);
        return obj;
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
