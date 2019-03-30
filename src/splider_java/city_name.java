package splider_java;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class city_name {
	private Document doc;
	private List<String> mlist_name=new ArrayList<>();//名称
	private List<String> mlist_http=new ArrayList<>();//网页
	/**
	 * 读取中国城市名称和网页链接
	 */
	public void Search_city() {
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
			//其他城市
			Elements elements_other=doc.select("ul.c_city_nlist").select("a");
			//System.out.println(elements_other);
			for (int i = 0; i < element.size(); i++) {
				String string_name=element.get(i).text();
				String string_http=element_1.get(i).attr("href").toString();
				if (i>8) {
						mlist_name.add(string_name.substring(2));
				}else {
					mlist_name.add(string_name.substring(1));
				}
				mlist_http.add("https://you.ctrip.com"+string_http);
			}
			//对其他城市的处理
			for (int j = 0; j < elements_other.size(); j++) {
				mlist_name.add(elements_other.get(j).text());
				mlist_http.add("https://you.ctrip.com"+elements_other.get(j).attr("href"));
			}
			} catch (Exception e) {//可以精确处理timeoutException
				//超时处理
			}

	}
	//返回城市名称
	public List<String> Name(){
		return mlist_name;
	}
	//返回城市网页链接
	public List<String> http(){
		return mlist_http;
	}
}