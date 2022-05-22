package com.qyys.quickapp.intergration.auth;
import com.qyys.quickapp.application.UserAppService;
import com.qyys.quickapp.common.constant.BizConstant;
import com.qyys.quickapp.common.constant.UserContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;

/**
 * @author : Yuan.Pan 2022/4/17 12:06 PM
 */
@Aspect
@Component
public class LoginAuthAspect {

    @Autowired
    private UserAppService userAppService;

    @Pointcut("@annotation(com.qyys.quickapp.intergration.auth.LoginAuth)")
    public void pointCut() {}

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();

            // get annotation
            LoginAuth annotation = ((MethodSignature) point.getSignature()).getMethod().getAnnotation(LoginAuth.class);

            String xToken = request.getHeader(BizConstant.LOGIN_TOKEN);
            UserContext.init(userAppService.authLogin(xToken, annotation.required()));

            Object[] params = point.getArgs();
            return point.proceed(params);
        } finally {
            UserContext.destroy();
        }
    }
}
