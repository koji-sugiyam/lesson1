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

  
    @RequestMapping(value = "/sugiyama", method = RequestMethod.GET)
    @ResponseBody
    public String home(
    		@RequestParam(name = "id", required = true) Integer id,
    		@RequestParam(name = "uuid", required = true) Long uuid,
    		@RequestParam(name = "score", required = false, defaultValue = "") Double score,
    		@RequestParam(name = "name", required = false, defaultValue = "") String name
    		) 
    {
    	String data = ""; 

    	/*
		data += "id = " + id.toString();
		data += "uuid = " + uuid.toString();
		data += "score = " + score.toString();
		data += "name = " + name;
    	*/
    	
    	if (id != null) {
    		data += " id = " + id.toString();
    	}
    	if (uuid != null) {
    		data += " uuid = " + uuid.toString();
    	}
    	if (score != null) {
    		data += " score = " + score.toString();
    	}
    	if(name != null) {
    		data += " name = " + name;
    	}
    	
        return data;
    	
    }



}






