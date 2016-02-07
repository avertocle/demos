package springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	@ResponseBody
	public HelloModel hello(){
		HelloModel helloModel = new HelloModel();
		helloModel.setId(1);
		helloModel.setName("Hello, 1");
		return helloModel;
	}

}
