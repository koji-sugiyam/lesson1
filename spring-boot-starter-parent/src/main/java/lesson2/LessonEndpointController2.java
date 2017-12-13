package lesson2;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;


@RestController
@EnableAutoConfiguration
public class LessonEndpointController2 {
	
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
    	
    	return new Response(id, uuid, score, name);
    	
    }
   
    


    //Responseクラス
    class Response{
     	
     	private Integer id;
     	private Long uuid;
     	private Double score;
     	private String name;
     	
    
     	//コンストラクタ
     	public Response(Integer id, Long uuid, Double score, String name) {
     		
     		super();
     		this.id = id;
     		this.uuid = uuid;
     		this.score = score;
     		this.name = name;
     	}
     	
     	//setterとgetter
     	//id
     	public void setId(Integer id) {
     		this.id = id;
     	}
     	public Integer getId() {
     		return this.id;
     	}
     	
     	//uuid
     	public void setUuid(Long uuid) {
     		this.uuid = uuid;
     	}
     	public Long getUuid() {
     		return this.uuid;
     	}
     	
     	//score
     	public void setScore(Double score) {
     		this.score = score;
     	}
     	public Double getScore() {
     		return this.score;
     	}
     	
     	//name
     	public void setName(String name) {
     		this.name = name;
     	}
     	public String getName() {
     		return this.name;
     	}
     	
     	
     }
  
}

