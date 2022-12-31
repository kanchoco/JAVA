package view;

import java.io.IOException;

import dao.NameDAO;

public class Test {
	public static void main(String[] args) throws IOException{
		NameDAO name = new NameDAO();
		
		name.merge("boyNames.txt", "girlNames.txt", "names.txt");
		name.updateRanking("names.txt");
	}
}
