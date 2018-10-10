import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainClass {
	public static void main(String[] args) {
		method1();
		method2();
		method3();
	}
	private static void method1(){
		Pattern pattern = Pattern.compile("H[abce]");
		Matcher matcher = pattern.matcher("Hello World How Are You");
		System.out.println("Method1");
		while (matcher.find())
			System.out.println(matcher.start() + " " + matcher.end() + " " + matcher.group());
	}
	private static void method2(){
		Pattern pattern = Pattern.compile("\\s");
		Matcher matcher = pattern.matcher("Hello World How Are You");
		System.out.println("Method2");
		while (matcher.find())
			System.out.println(matcher.start() + " " + matcher.end() + " " + matcher.group());
	}
	private static void method3(){
		Pattern pattern = Pattern.compile("\\d");
		Matcher matcher = pattern.matcher("Hello8 World How Are You");
		System.out.println("Method3");
		while (matcher.find())
			System.out.println(matcher.start() + " " + matcher.end() + " " + matcher.group());
	}
}
