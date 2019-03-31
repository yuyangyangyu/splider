package splider_java;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Attraction_detail {
	private Document document;
	private Elements elements;
	private Elements elements2;
	/**
	 * 获取具体景点的详情页
	 * @param url
	 */
	public void Search(String url) {
		try {
			document= Jsoup.connect(url)
					.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:49.0) Gecko/20100101 Firefox/49.0")
					.header("Connection", "close")//如果是这种方式，这里务必带上
					.timeout(8000)//超时时间
					.get();
			Elements elements=document.select("div.detailcon").select("ul");
			Element elements2=document.select("div.toggle_s").select("[itemprop=description]").first();
			System.out.println(elements2.text());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	/**
	 * 返回景点的亮点
	 * @return
	 */
public String Highlight() {
	return elements.text();
}
/**
 * 返回景点的详细情况
 * @return
 */
public String detail() {
	return elements2.text();
}

}
