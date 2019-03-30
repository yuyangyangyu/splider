package splider_java;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class splider {
	public static void main(String[] args) {
		Document doc;
		try{
			doc = Jsoup.connect("http://you.ctrip.com/sitelist/china110000.html")
					.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:49.0) Gecko/20100101 Firefox/49.0")
					.header("Connection", "close")//如果是这种方式，这里务必带上
					.timeout(8000)//超时时间
					.get();
			String titleString=doc.title();
			//中国热门城市（旅游）
			Elements element=doc.select("li.w_220").select("dt");//名称
			Elements element_1=doc.select("li.w_220").select("a[target]");//网址
			//System.out.println(element_1.get(1).attr("href").toString());
			for (int i = 0; i < 12; i++) {
				String string_name=element.get(i).text();
				String string_http=element_1.get(i).attr("href").toString();
				if (i>8) {
					System.out.println(string_name.substring(2));
				}else {
					System.out.println(string_name.substring(1));
				}
				System.out.println("https://you.ctrip.com"+string_http);
			}
			} catch (Exception e) {//可以精确处理timeoutException
				//超时处理
			}	
	
	
	}

}


