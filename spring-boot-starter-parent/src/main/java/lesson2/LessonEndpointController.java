package lesson2;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;




@RestController
@EnableAutoConfiguration
public class LessonEndpointController {


	//spring
    public static void main(String[] args) throws Exception {
        SpringApplication.run(LessonEndpointController.class, args);
    }

  
    @RequestMapping(
    		value = "/sugiyama/{id}/{uuid}/", 
    		method = RequestMethod.GET
    )
    
    public HashMap<Object, Object> home(
    		
    		@PathVariable("id") Integer id,
    		@PathVariable("uuid") Long uuid,
    		@RequestParam(name = "score", required = false) Double score,
    		@RequestParam(name = "name", required = false) String name
    		) 
    		
    		/* memo
    		@PathVariableは必須項目になる
    		@RequestParamはrequiredで制御できる
    		必須の制御はあくまで引数名で、引数の値ではないことに注意    		
    		*/
    {
    	
    	

    	/****************************/
    	//変数初期化
    	String data = ""; 
    	String format = "";
    	
    	
    	/****************************/
    	//ループで回してみる
    	
    	//配列で必要なkey/valueを設定
    	HashMap<String,Object> resultMap = new HashMap<String,Object>();
    	
    	//id
    	resultMap.put("id",id);
    	
    	//uuid
    	resultMap.put("uuid",uuid);

    	//score
    	//任意なのでnullでなければ
        if(score != null) {
    		resultMap.put("score",score);
    	}else {
    		resultMap.put("score","");
    	}
    	
    	//name
        //任意なのでnullでなければ
    	if(name != null) {
	    	resultMap.put("name",name);
    	}else {
    		resultMap.put("name","");
    	}
    	
    	System.out.println(resultMap);

    	
    	


    	/****************************/
    	//keyの配列
    	ArrayList<String> keyArray = new ArrayList<String>();
    	keyArray.add("id");
    	keyArray.add("uuid");
    	keyArray.add("score");
    	keyArray.add("name");
    	System.out.println(keyArray);
    	
	    //key配列を使って、任意の順の出るようにしてみる
    	format = "%s = %s / ";
    	data = "";
	    for(String keyString : keyArray) {
        	data +=  String.format(format, keyString, resultMap.get(keyString));
	    }
	    System.out.println("resultMap = " + data);
	    
	    
	    
	    

    	/****************************/
	    //keyArrayとresultMapを多次元配列にしてみる

    	HashMap<Object, Object> dataMap = new HashMap<Object, Object>();
    	
    	dataMap.put("keys",new ArrayList<Object>());
    	dataMap.put("requests",new HashMap<Object, Object>());
    	
    	dataMap.put("keys",keyArray);
    	dataMap.put("results",resultMap);
    	
	    System.out.println("dataMap = " + dataMap);
	    
	    

	    

    	/****************************/
	    //dataMapのkeysを使って、resultsMapの値を、keys配列の値の順に出してみる
	    
	    //ArrayListにdataMap["keys"]を
    	ArrayList<String> dataMapKeyArray = new ArrayList<String>();
    	dataMapKeyArray = (ArrayList<String>)dataMap.get("keys");
    	
    	//HashMapにdataMap["results"]を
    	HashMap<String,Object> dataMapResultMap = new HashMap<String,Object>();
    	dataMapResultMap = (HashMap<String, Object>)dataMap.get("results");

    	format = "%s = %s / ";
    	data = "";
	    for( String keyString : dataMapKeyArray) {

	    	String resultstring = dataMapResultMap.get(keyString).toString();
		    System.out.println(String.format("dataMapresultMap / k = %s : v = %s",keyString,resultstring));

	        data +=  String.format(format, keyString, resultstring);
		    
	    }

	    
	    
	    
	    
	    


    	/****************************/

	    //dataMapをJSONにしてみる
	    //ついでにtry-catchで
	    /*
	    String json = "";
	    ObjectMapper mapper = new ObjectMapper();

	    try {
			json = mapper.writeValueAsString(dataMap);
			System.out.println("json = " + json);
		} 
	    catch (Exception e) {
			e.printStackTrace();
		}
		*/


	    /*
	     　	アノテーションでJSONを返したい場合は、
	    @Controller / @ResponseBody → @RestControllerにし
	     　　home()の返り値の型をHashMapにして、HashMapをreturnすると、
	    JSONで返してくれる。
		＝自分で変換コードを書かないことで、バグが減らせる。
	    */
	    
	    
	    
    	
        return dataMap;
    	
    }
    



}






