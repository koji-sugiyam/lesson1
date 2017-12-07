package hello;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;


@Controller
@EnableAutoConfiguration
public class SampleController {

    private static final int LocalDateTime = 0;

	@RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
    
    //springで実行する場合
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }

}