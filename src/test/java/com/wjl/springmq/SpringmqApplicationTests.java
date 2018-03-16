package com.wjl.springmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringmqApplicationTests {

	@Test
	public void contextLoads() {
	}


	@Autowired
	private Send sender;

	@Test
	public void sendTest() throws Exception {
		while(true){
			String msg = new Date().toString();
			sender.send(msg);
			Thread.sleep(1000);
		}
	}

}
