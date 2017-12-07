package traning3;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import traning3.ThirdTermTwoController;



@Controller
@EnableAutoConfiguration
public class ThirdTermTwoController {

    //spring
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ThirdTermTwoController.class, args);
    }

  

	@RequestMapping("/")
    @ResponseBody
    String home() {
		
		return "ThirdTermTwoController";

    }
    
	public static String superFunc() {
		
		String string = "superだよん";
		
		return string;
	}
	
	

    
}






