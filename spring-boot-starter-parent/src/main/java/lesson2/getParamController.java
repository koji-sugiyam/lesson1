package lesson2;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;



@Controller
@EnableAutoConfiguration
public class getParamController {

    //spring
    public static void main(String[] args) throws Exception {
        SpringApplication.run(getParamController.class, args);
    }

  
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String home(
    		@RequestParam(required = true) int id,
    		@RequestParam(required = true) long uuid,
    		@RequestParam(required = false) double score,
    		@RequestParam(required = false) String name
    		) 
    {
    	String data; 
    	data = "id = " + id +" ";
    	data += "uuid = " + uuid + " ";
    	data += "score = " + score;
    	
    	if(!name.isEmpty()) {
    		data += "name = " + name;
    	}
    	
        return data;
    	
    }



}






