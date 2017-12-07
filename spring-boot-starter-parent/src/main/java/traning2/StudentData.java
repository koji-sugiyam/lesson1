package traning2;

class Student{
	
	static String name;
	static int score;
	static final int MAX_SCORE = 100;
	
	//コンストラクタ 3パターン
	Student(String name, int score){
		this.name = name;
		this.score = score;
	}
	Student(String name){
		this.name = name;
	}
	Student(int score){
		this.score = score;
	}
	Student(){
	}
	//デストラクタはないのかな？
	
	
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

