package lesson2;

import lombok.Data;

@Data
public class Response{
 	
 	private Integer id;
 	private Long uuid;
 	private Double score;
 	private String name;
 	
 	//コンストラクタ
 	public Response(Integer id, Long uuid, Double score, String name) {
 		
 		this.id = id;
 		this.uuid = uuid;
 		this.score = score;
 		this.name = name;
 	}
 	
 	/*
 	//setterとgetterはlombokを使うと以下の記述は自動生成
 	*/
 }