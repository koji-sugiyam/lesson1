package lesson2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;



@Controller
@EnableAutoConfiguration
public class getParamController2 {

    //spring
    public static void main(String[] args) throws Exception {
        SpringApplication.run(getParamController2.class, args);
    }

  
    @RequestMapping(
    		//value = "/sugiyama/{id}/{uuid}/{score}/{name}/", 
    		value = "/sugiyama/{id}/{uuid}/", 
    		method = RequestMethod.GET
    )
    @ResponseBody
    public String home(
    		@PathVariable("id") Integer id, //必須
    		@PathVariable("uuid") Long uuid, //必須
    		@RequestParam(name = "score", required = false) Double score,
    		@RequestParam(name = "name", required = true) String name,
    		@RequestParam(name = "type", required = false) String type
    		) 
    		/*
    		//memo
    		@PathVariableは必須項目になる
    		@RequestParamはrequiredで制御できる
    		必須の制御はあくまで引数名で、引数の値ではないことに注意
    		*/
    {
    	
    	

    	/****************************/
    	//変数初期化
    	String data = ""; 
    	String format = "";
    	/*
    	//フォーマットして出力
    	format = "id = %s / uuid = %s / score = %s / name = %s / type = %s /";
    	data =  String.format(format, id.toString(), uuid.toString(), score.toString(), name, type);
    	*/
    	
    	
    	
    	
    	/****************************/
    	//ループで回してみる
    	
    	//配列で必要なkey/valueを設定
    	HashMap<String,String> requestMap = new HashMap<String,String>();
    	
    	//id
    	requestMap.put("id",id.toString());
    	
    	//uuid
    	requestMap.put("uuid",uuid.toString());

    	//score
    	//Stringは引数がないとnullになり
    	//nullにtoString()するとエラーになるので、判定すること
    	if(score != null) {//任意なのでnullでなければ
    		requestMap.put("score",score.toString());
    	}
    	
    	//name
    		requestMap.put("name",name);
    	
    	//type
    	if(type != null) {//任意なのでnullでなければ
    		requestMap.put("type",type);
    	}
    	
    	System.out.println(requestMap);

    	
    	
    	
    	//セットしたデータをためしにkey指定で出力してみる
    	if(requestMap.containsKey("name")) {
    		System.out.println("name = " + requestMap.get("name"));
    	}
    	else {
    		System.out.println("指定したキーはありません。");
    	}
    	
    	

    	//requestMapを回してみる
    	format = "%s = %s / ";
    	data = "";
    	for(Map.Entry<String, String> element : requestMap.entrySet()) {
        	data +=  String.format(format, element.getKey(), element.getValue());
    	}
    	//順番が変わっちゃう
	    System.out.println("requestMap = " + data);
    	
	    
	    


    	/****************************/
    	//keyの配列
    	ArrayList<String> keyArray = new ArrayList<String>();
    	keyArray.add("id");
    	keyArray.add("uuid");
    	keyArray.add("score");
    	keyArray.add("name");
    	keyArray.add("type");
    	System.out.println(keyArray);
    	
	    //key配列を使って、任意の順の出るようにしてみる
    	format = "%s = %s / ";
    	data = "";
	    for(String keyString : keyArray) {
        	data +=  String.format(format, keyString, requestMap.get(keyString));
	    }
	    System.out.println("requestMap = " + data);
	    
	    
	    
	    

    	/****************************/
	    //keyArrayとrequestMapを多次元配列にしてみる

    	HashMap<Object, Object> dataMap = new HashMap<Object,Object>();
    	
    	dataMap.put("keys",new ArrayList<Object>());
    	dataMap.put("requests",new HashMap<Object, Object>());
    	
    	dataMap.put("keys",keyArray);
    	dataMap.put("requests",requestMap);
    	
	    System.out.println("dataMap = " + dataMap);
	    
	    

	    

    	/****************************/
	    //dataMapのkeysを使って、requestsMapの値を、keys配列の値の順に出してみる
	    
	    //ArrayListにdataMap["keys"]を
    	ArrayList<String> dataMapKeyArray = new ArrayList<String>();
    	dataMapKeyArray = (ArrayList<String>)dataMap.get("keys");
    	
    	//HashMapにdataMap["requests"]を
    	HashMap<String,String> dataMapRequestMap = new HashMap<String,String>();
    	dataMapRequestMap = (HashMap<String,String>)dataMap.get("requests");

    	format = "%s = %s / ";
    	data = "";
	    for( String keyString : dataMapKeyArray) {

	    	String requestString = dataMapRequestMap.get(keyString);
		    System.out.println(String.format("dataMapRequestMap / k = %s : v = %s",keyString,requestString));

	        data +=  String.format(format, keyString, requestString);
		    
	    }

	    
	    
	    
	    
	    

    	/****************************/
	    //dataMapをJSONにしてみる
	    //ついでにtry-catchで
	    
	    String json = "";
	    ObjectMapper mapper = new ObjectMapper();

	    try {
			json = mapper.writeValueAsString(dataMap);
			System.out.println("json = " + json);
		} 
	    catch (Exception e) {
			e.printStackTrace();
		}


	    
	    

    	/****************************/
	    /*
	     　	アノテーションでJSONを返したい場合は、
	    @Controller → @RestControllerにして
	     　　返り値の型をHashMapにして、HashMapをreturnすると、
	    JSONで返してくれる。
		＝自分で変換コードを書かないことで、バグが減らせる。
	    */
	    
	    
	    
    	
        return data;
    	
    }
    



}






