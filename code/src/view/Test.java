package view;

import java.util.Scanner;

import crawling.BungaeCrawling;
import crawling.DanggeunCrawling;
import crawling.JoonggoCrawling;
import dao.TotalDAO;

public class Test {

	public static void main(String[] args) {
		JoonggoCrawling joonggoCrawling = new JoonggoCrawling();
		DanggeunCrawling danggeunCrawling = new DanggeunCrawling();
		BungaeCrawling bungaeCrawling = new BungaeCrawling();

		String search = null;
		Scanner sc = new Scanner(System.in);

		System.out.print("검색어: ");
		search = sc.nextLine();

//		====================크롤링 정보 DB 저장하기====================
		joonggoCrawling.crawling(search);
		danggeunCrawling.crawling(search);
		bungaeCrawling.crawling(search);
		
	}
}
