package splider_java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class splider {
	public static void main(String[] args) {
		Document document;
		List<String> httpList=new ArrayList<String>();
		List<String> imgList=new ArrayList<String>();
		List<String> nameList=new ArrayList<String>();
		List<String> detaillList=new ArrayList<String>();
		try {
			document= Jsoup.connect("https://you.ctrip.com/sight/yangshuo702.html")
					.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:49.0) Gecko/20100101 Firefox/49.0")
					.header("Connection", "close")//如果是这种方式，这里务必带上
					.timeout(8000)//超时时间
					.get();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


