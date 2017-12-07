package traning2;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import traning2.SecondTermTwoForSpringController;

import java.util.Date;
import java.text.SimpleDateFormat;


@Controller
@EnableAutoConfiguration
public class SecondTermTwoForSpringController {

    //spring
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SecondTermTwoForSpringController.class, args);
    }

    
    private static final int LocalDateTime = 0;

	@RequestMapping("/sugiyama/")
    @ResponseBody
    String home() {

		//date
    	Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
        String nowDate = formatter.format(date);

        
        //初期化
        String name;
        int score;
        String resultString;
        String ｓｔFormat;
        
        //データ 杉山
    	Student KSInstance = new Student();
    	KSInstance.setName("杉山");
    	KSInstance.setScore(10);
    	
    	name = KSInstance.getName();
    	score = KSInstance.getScore();
        ｓｔFormat = "%sの%sさんの点数は%d点です。";
    	resultString = String.format(ｓｔFormat, nowDate, name, score);
    	
    	//return resultString;
    
    	
    	//試しにでJSON出してみる。
    	String json = "{\"result\":[{\"name\":\"杉山\",\"score\":30},{\"name\":\"弘二\",\"score\":40}]}";
    	return json;
    	
    
    }
    

    
}





