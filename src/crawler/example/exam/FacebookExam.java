package crawler.example.exam;

import com.github.abola.crawler.CrawlerPack;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * 練習：取得任一篇或多篇文章的 Reactions 總數
 *
 *
 * 重點
 * 1. 先利用Graph Api調整出需要的資料
 * 2. 修改程式，使用爬蟲包取得資料
 * 3. 上傳至GitHub
 * 
 * @author Abola Lee
 *
 */
public class FacebookExam {
	
	public static void main(String[] args) {
		
		// 遠端資料路徑

		String uri = 
				"https://graph.facebook.com/v2.6"
				+ "/judgead/posts?fields=id,link,message,created_time,likes.limit(0).summary(total_count),reactions.limit(0).summary(total_count)"
				+ "&access_token=EAACEdEose0cBAN5NKpPrQB8dOV8y7PBh1T1AEB5u0I9yaR2WfJMzchahf09V6kJnADZBjRJiUjkbaAFpLOJGTwALD2yZCDl7ItBiMnBD0lMBZB6jfH5osCFHJiZBZBsPrIrbRMg5z47irfZBJ5ApzSAP2jl1ZCkj8yGNYiuyNabZC0HrjFOay7ppMYBeTEtjJtNwWroXjerrQVO3zUSL9Dxx";


		Elements elems =
				CrawlerPack.start()
				.getFromJson(uri)
				.select("data");
		
		String output = "id,reactions";

		// 遂筆處理
		for( Element data: elems ){
			String id = data.select("id").text();

			// FIXIT
			String reactions = data.select("reactions summary total_count").text();


			output += id + "," + reactions + "\n";
		}

		System.out.println( output );
	} 
}
