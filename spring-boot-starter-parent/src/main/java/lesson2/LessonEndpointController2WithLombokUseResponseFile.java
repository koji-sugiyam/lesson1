package lesson2;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

import lesson2.Response;//使う外部ファイル

@RestController
@EnableAutoConfiguration
public class LessonEndpointController2WithLombokUseResponseFile {
	
	//spring
    public static void main(String[] args) throws Exception {
        SpringApplication.run(LessonEndpointController2WithLombokUseResponseFile.class, args);
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
    	
    	Response response = new Response(id,uuid,score,name);//インスタンス化
    	
    	return response;
    	
    }
   

}

