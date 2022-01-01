import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScraper {
	public static void main(String [] args) throws IOException {
//		Create a scanner object
		Scanner scanObj = new Scanner(System.in);
		System.out.println("What do you want to search for?:");
//		Take input from user
		String searchQuery = scanObj.nextLine();
		searchQuery = searchQuery.replace(" ", "+");
//JSOUp initialization
		Document google = Jsoup.connect("https://www.google.com/search?q=" + searchQuery).get();
		Elements label = google.select(".kno-rdesc span");
		Elements label2 = google.select("#rso link");
		
		System.out.println(label2);
//		Elements data = google.select("td.infobox-data");
		
//		ArrayList<String> hyperlinks = new ArrayList<String>();
		
//		System.out.println(label);
		
		for (Element eachSpan: label) {
			System.out.println(eachSpan.text());	
		}
		
//		for (Element e:pageElements) {
//			hyperlinks.add("Text: " + e.text());
//			hyperlinks.add("Link: " + e.attr("href"));
//		}
		
//		for (String s : hyperlinks) {
//			System.out.println(s);
//		}
	}
}
