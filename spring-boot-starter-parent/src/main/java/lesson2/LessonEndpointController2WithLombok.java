package lesson2;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;


//Objective-Cの@Synthesize的なことをしてくれる
import lombok.Data;

@RestController
@EnableAutoConfiguration
public class LessonEndpointController2WithLombok {
	
	//spring
    public static void main(String[] args) throws Exception {
        SpringApplication.run(LessonEndpointController2.class, args);
    }
    
    @RequestMapping(
    		value = "/sugiyama/{id}/{uuid}/",
    		method = RequestMethod.GET
    		)
    
    public Response home(
    		@PathVariable("id") Integer id,
    		@PathVariable("uuid") Long uuid,
    		@RequestParam(name = "score", required = false) Double score,
    		@RequestParam(name = "name", required = false) String name
    		) {
    	
    	return new Response();
    	
    }
   
    


    //Responseクラス
    @Data
    class Response{
     	
     	private Integer id;
     	private Long uuid;
     	private Double score;
     	private String name;
     	
    }
  
}

