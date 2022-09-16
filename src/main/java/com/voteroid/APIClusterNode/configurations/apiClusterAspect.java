package com.voteroid.APIClusterNode.configurations;

import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.voteroid.APIClusterNode.dtos.Constants;
import com.voteroid.APIClusterNode.dtos.Reply;

@Aspect
@Component
public class apiClusterAspect {
	
	@Autowired
	HttpServletResponse response;

	@AfterReturning(pointcut="@annotation(org.springframework.web.bind.annotation.PostMapping) || "
			               + "@annotation(org.springframework.web.bind.annotation.GetMapping) ||"
			               + "@annotation(org.springframework.web.bind.annotation.PutMapping) ||"
			               + "@annotation(org.springframework.web.bind.annotation.DeleteMapping)",returning = "reply")
	public void afterReturningAdvice(JoinPoint joinPoint, Reply reply)  
	{  
		response.setHeader(Constants.TOKEN_DATA,reply.getjsonStringFromMap());
	}  
	
}
