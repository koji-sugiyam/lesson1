package traning2;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.text.SimpleDateFormat;


@Controller
@EnableAutoConfiguration
public class SecondTermTwoController {

    private static final int LocalDateTime = 0;

	@RequestMapping("/")
    @ResponseBody
    String home() {
        return "SecondTermTwoController";
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
    	//String resultString = nowDate + "の" +  name + "さんの点数は、" + score + "点です。";
    	//resultString = String.format("%sの%sさんの点数は%d点です。", nowDate, name, score);
        ｓｔFormat = "%sの%sさんの点数は%d点です。";
    	resultString = String.format(ｓｔFormat, nowDate, name, score);
    	sEcho(resultString);
    
    	
        //データ 友達
    	Student FRInstance = new Student();
    	FRInstance.setName("友達");
    	FRInstance.setScore(60);
    	
    	name = FRInstance.getName();
    	score = FRInstance.getScore();
        ｓｔFormat = "%sの%sさんの点数は%d点です。";
    	resultString = String.format(ｓｔFormat, nowDate, name, score);
    	sEcho(resultString);
    	
    	
    	//別の構文

        //データ 杉山
    	Student KojiSugiyama = new Student();
    	KojiSugiyama.name = "杉山";
    	KojiSugiyama.score =30;
        ｓｔFormat = "%sの%sさんの点数は%d点です。";
    	resultString = String.format(ｓｔFormat, nowDate, KojiSugiyama.name, KojiSugiyama.score);
    	sEcho(resultString);
    	
    	//コンストラクトしてみる
        //データ 杉山
    	Student CONSTInstance = new Student("杉山",35);
        ｓｔFormat = "%sの%sさんの点数は%d点です。";
    	resultString = String.format(ｓｔFormat, nowDate, CONSTInstance.name, CONSTInstance.score);
    	sEcho(resultString);
    	
    	
    }
}







 