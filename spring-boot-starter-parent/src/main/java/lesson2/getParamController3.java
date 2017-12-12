package lesson2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;



@RestController
@EnableAutoConfiguration
public class getParamController3 {

    //spring
    public static void main(String[] args) throws Exception {
        SpringApplication.run(getParamController3.class, args);
    }

  
    @RequestMapping(
    		value = "/sugiyama/{id}/{uuid}/", 
    		method = RequestMethod.GET
    )
    @ResponseBody
    public HashMap home(
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
    	
    	
    	/****************************/
    	//ループで回してみる
    	
    	//配列で必要なkey/valueを設定
    	HashMap<String,String> resultMap = new HashMap<String,String>();
    	
    	//id
    	resultMap.put("id",id.toString());
    	
    	//uuid
    	resultMap.put("uuid",uuid.toString());

    	//score
    	//Stringは引数がないとnullになり
    	//nullにtoString()するとエラーになるので、判定すること
    	if(score != null) {//任意なのでnullでなければ
    		resultMap.put("score",score.toString());
    	}
    	
    	//name
    		resultMap.put("name",name);
    	
    	//type
    	if(type != null) {//任意なのでnullでなければ
    		resultMap.put("type",type);
    	}
    	
    	System.out.println(resultMap);

    	
    	


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
        	data +=  String.format(format, keyString, resultMap.get(keyString));
	    }
	    System.out.println("resultMap = " + data);
	    
	    
	    
	    

    	/****************************/
	    //keyArrayとresultMapを多次元配列にしてみる

    	HashMap dataMap = new HashMap<Object, Object>();
    	
    	dataMap.put("keys",new ArrayList());
    	dataMap.put("requests",new HashMap());
    	
    	dataMap.put("keys",keyArray);
    	dataMap.put("results",resultMap);
    	
	    System.out.println("dataMap = " + dataMap);
	    
	    

	    

    	/****************************/
	    //dataMapのkeysを使って、resultsMapの値を、keys配列の値の順に出してみる
	    
	    //ArrayListにdataMap["keys"]を
    	ArrayList<String> dataMapKeyArray = new ArrayList<String>();
    	dataMapKeyArray = (ArrayList<String>)dataMap.get("keys");
    	
    	//HashMapにdataMap["results"]を
    	HashMap<String,String> dataMapResultMap = new HashMap<String,String>();
    	dataMapResultMap = (HashMap<String,String>)dataMap.get("results");

    	format = "%s = %s / ";
    	data = "";
	    for( String keyString : dataMapKeyArray) {

	    	String resultstring = dataMapResultMap.get(keyString);
		    System.out.println(String.format("dataMapresultMap / k = %s : v = %s",keyString,resultstring));

	        data +=  String.format(format, keyString, resultstring);
		    
	    }

	    
	    
	    
	    
	    


    	/****************************/
	    /*
	     　	アノテーションでJSONを返したい場合は、
	    @Controller → @RestControllerにして
	     　　返り値の型をHashMapにして、HashMapをreturnすると、
	    JSONで返してくれる。
		＝自分で変換コードを書かないことで、バグが減らせる。
	    */
	    
	    
	    
    	
        return dataMap;
    	
    }
    



}






