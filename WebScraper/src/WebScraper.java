import java.awt.*;
import java.awt.image.MemoryImageSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScraper {
	public static String getData(String c) throws Exception {
		StringBuffer br = new StringBuffer();
		br.append("<html>" + "<body style='text-align: center; color: red;'>");
		br.append(c.toUpperCase() + "<br>");
		
		String url = "https://www.worldometers.info/coronavirus/country/"+ c +"/";
		Document doc = Jsoup.connect(url).get();
		
		// #maincounter-wrap
		Elements elements = doc.select("#maincounter-wrap");
		elements.forEach((e) -> {
			String text = e.select("h1").text();
			String count = e.select(".maincounter-number>span").text();
			br.append(text).append(count).append("<br>");
		});
		
		br.append("</body>" + "</html>");
		return br.toString();
	}
	
	public static void main(String[] args) throws Exception {
		/*
		 * try (Scanner sc = new Scanner(System.in)) {
		 * System.out.println("Enter Country Name: "); String co = sc.nextLine();
		 * getData(co); }
		 */
		
//		Creating a GUI
		JFrame root = new JFrame("Details of Country");
		root.setSize(500,500);
		Font f = new Font("Poppins",Font.BOLD,30);
		
		// textfield
		JTextField field = new JTextField();
		
		// label
		JLabel dataL = new JLabel();
		field.setFont(f);
		dataL.setFont(f);
		field.setHorizontalAlignment(SwingConstants.CENTER);
		dataL.setHorizontalAlignment(SwingConstants.CENTER);
	
		// button
		JButton button = new JButton("Get");
		
		button.addActionListener(event -> {
			//click:
			try {
				String maindata = field.getText();
				String result = getData(maindata);
				dataL.setText(result);
			} catch(Exception e) {
				e.printStackTrace();
			}
		});
	
		button.setFont(f);
		root.setLayout(new BorderLayout());
		root.add(field,BorderLayout.NORTH);
		root.add(dataL,BorderLayout.CENTER);
		root.add(button,BorderLayout.SOUTH);
		root.setVisible(true);
	}
}
