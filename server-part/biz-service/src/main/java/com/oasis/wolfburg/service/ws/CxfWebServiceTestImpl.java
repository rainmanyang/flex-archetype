package com.oasis.wolfburg.service.ws;

import javax.annotation.PostConstruct;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

@WebService(endpointInterface = "com.oasis.wolfburg.service.ws.CxfWebServiceTest")
@Service
public class CxfWebServiceTestImpl implements CxfWebServiceTest{

//	@Override
	public String sayHello() {
		return "hahahah";
	}
	
	@PostConstruct
	public void test(){
		System.out.println("+++++++++++++++++++++++++++++++++++++++++" +
				"+++++++++++++++++++++++++++++++++++" +
				"+++++++++++++++++++++++++++++++++++" +
				"++++++++++++++++++++++++++++++++++++" 
				);
	}

}
