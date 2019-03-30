package splider_java;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
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
			Elements element=doc.select("li.w_220").select("dt");
			for (int i = 0; i < 12; i++) {
				String string=element.get(i).text();
				if (i>8) {
					System.out.println(string.substring(2));
				}else {
					System.out.println(string.substring(1));
				}
				
			}
			} catch (Exception e) {//可以精确处理timeoutException
				//超时处理
			}	
	
	
 }

}


