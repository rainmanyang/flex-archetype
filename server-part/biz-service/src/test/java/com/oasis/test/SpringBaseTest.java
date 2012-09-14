package com.oasis.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.security.ClientContextHolder;


@ContextConfiguration(locations={"classpath:serviceContext.xml","classpath:META-INF/spring/mailContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class SpringBaseTest extends AbstractJUnit4SpringContextTests{
	protected final String CODE = "TEST";
	
	public SpringBaseTest(){
		this.initialSecurityContext();
	}
	
	private void initialSecurityContext(){
		ClientContext sc = new ClientContext();
		sc.setAccountId(new Long("60014"));
		ClientContextHolder.setContext(sc);
	}
}
