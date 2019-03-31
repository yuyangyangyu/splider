package splider_java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class splider {
	public static void main(String[] args) {
		Document document;
		try {
			document= Jsoup.connect("https://you.ctrip.com/sight/chongqing158/10386.html")
					.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:49.0) Gecko/20100101 Firefox/49.0")
					.header("Connection", "close")//如果是这种方式，这里务必带上
					.timeout(8000)//超时时间
					.get();
			//获取亮点
			Elements elements=document.select("div.detailcon").select("ul");
			//System.out.println(elements.text());
			Element elements2=document.select("div.toggle_s").select("[itemprop=description]").first();
			System.out.println(elements2.text());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}


