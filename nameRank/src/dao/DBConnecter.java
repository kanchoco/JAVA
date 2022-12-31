package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DBConnecter {
	public static BufferedWriter getWriter(String PATH) throws IOException {
		return new BufferedWriter(new FileWriter(PATH));
	}
	public static BufferedWriter getAppend(String PATH) throws IOException {
		return new BufferedWriter(new FileWriter(PATH, true));
	}
	public static BufferedReader getReader(String PATH) throws IOException {
		return new BufferedReader(new FileReader(PATH));
	}
}
