package traning2;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;


@Controller
@EnableAutoConfiguration
public class SecondTermTwoController {

    private static final int LocalDateTime = 0;

	@RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
    
	//string echo
    public static void sEcho(String str) {
    	System.out.println(str);
    	return;
    }
    //int echo
    public static void iEcho(int num) {
    	System.out.println(num);
    	return;
    }
    
    public static void main(String [] args) {

    	Student STinstance = new Student();
    	STinstance.setName("杉山");
    	STinstance.setScore(10);
    	
    	String name = STinstance.getName();
    	int score = STinstance.getScore();
    	String resultString = name + "さんの点数は、" + score + "点です。";
    	sEcho(resultString);
    }
}






 class Student{
	
	static String name;
	static int score;
	static final int MAX_SCORE = 100;
	
	static void setName(String newName) {
		name = newName;
	}
	static void setScore(int newScore) {
		score = newScore;
	}

	static String getName() {
		return name;
	}
	static int getScore() {
		return score;
	}
	
	static void printScore(int maxScore) {
		System.out.println(name + "さんは"+ score + "点です");
	}
	//オーバーロード
	static void printScore() {
		printScore(MAX_SCORE);
	}
	
	

}
