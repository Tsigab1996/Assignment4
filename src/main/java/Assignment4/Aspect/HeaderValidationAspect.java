package Assignment4.Aspect;

import Assignment4.Exception.AopIsAwesomeHeaderException;
import lombok.AllArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@AllArgsConstructor
public class HeaderValidationAspect {

    @Pointcut("@annotation(Assignment4.Annotation.ValidatePostMethod)")
    public void pointCutValidateHeader(){}

    @Pointcut("within(Assignment4.Service..*)")
    public void pointCutWithIn() {
    }

    @Before("pointCutValidateHeader() && pointCutWithIn()")
    public void validateIncomingRequestHeader(JoinPoint joinPoint) {
        HttpServletRequest request = (HttpServletRequest) joinPoint.getArgs()[0];
        if(request.getHeader("AOP-IS-AWESOME") == null) {
            throw new AopIsAwesomeHeaderException("Awesome header not found!");
        }
    }
}
