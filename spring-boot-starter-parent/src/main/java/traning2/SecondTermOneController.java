package traning2;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.text.SimpleDateFormat;


@Controller
@EnableAutoConfiguration
public class SecondTermOneController {

    private static final int LocalDateTime = 0;

	@RequestMapping("/")
    @ResponseBody
    String home() {
        return "SecondTermOneController";
    }
    
	
    //java applicationで実行する場合
    public static void sEcho(String str) {
    	System.out.println(str);
    	return;
    }
    public static void iEcho(int num) {
    	System.out.println(num);
    	return;
    }
    
    public static void main(String [] args) {
    	
    	//表示
    	System.out.println("こんにちは");
    	
    	int numA = 100;
    	System.out.println(numA);
    	
    	int numB = 200;
    	boolean resultA =  numA > numB;
    	System.out.println("resultA = " + resultA);
    	
    	String resultC = "";
    	if(numA > numB) {
    		resultC = "大きいよ";
    		}
    	else{
    		resultC = "小さいよ";
    	}
    	System.out.println("resultC = " + resultC);
    	
    	int i = 0;
    	i++;
    	System.out.println(i);
    	i += 100;
    	System.out.println(i);
    	i++;
    	System.out.println(i);
    	i -= 50;
    	System.out.println(i);
    	
    	
    	String strA = "Hello"+ " ";
    	String strB = " " + "World"+ " ";
    	String message = "JAVA"+ " ";
    	int messageNum = 2;
    	System.out.println(strA + message + messageNum + strB);
    	
    	//date
    	Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println("date formtted = " + formatter.format(date));
        
        //time
        System.out.println("time = " + date.getTime());
        
        
        //for
        String str;
        for(i=0;i<3;i++) {
        	
        	switch(i) {
        		case 0:
        			str = "i = " + i + " ダヨン！";
        			sEcho(str);//出力が面倒あのでユーザー関数にしてる
        		break;
        		case 1:
        			str = "i = " + i + " ダヨン！";
        			sEcho(str);//出力が面倒あのでユーザー関数にしてる
        		break;
        		case 2:
        			str = "i = " + i + " ダヨン！";
        			sEcho(str);//出力が面倒あのでユーザー関数にしてる
        		break;
        		default:
        			sEcho("defaultです");
        			break;
        	}
        }
        
        //collection
        int[] nums = {1,2,3,4,5,6,7,8,9};
        for(int v : nums) {
        	iEcho(v);
        }
        
        
        //while / do-whileは割愛
         
    }
    
}
