package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;

import vo.BoyVO;
import vo.GirlVO;
import vo.NameDTO;

public class NameDAO {
	ArrayList<GirlVO> girls;
	ArrayList<BoyVO> boys;
	
	public void merge(String PATH1, String PATH2, String PATH3) throws IOException	{
		String line = "", temp = "";
		
		boys = new ArrayList<BoyVO>();
		girls = new ArrayList<GirlVO>();
		
		BoyDAO boyDAO = new BoyDAO();
		GirlDAO girlDAO = new GirlDAO();
		
		BufferedReader boyReader = DBConnecter.getReader(PATH1);
		
		while((line = boyReader.readLine()) != null)	{
			temp += line + "\n";
			boys.add(boyDAO.setObject(line));
		}
		boyReader.close();
		
		BufferedReader girlReader = DBConnecter.getReader(PATH2);
		
		while( (line = girlReader.readLine()) != null )	{
			temp += line + "\n";
			girls.add(girlDAO.setObject(line));
		}
		girlReader.close();
		
		BufferedWriter nameWriter = DBConnecter.getWriter(PATH3);
		
		nameWriter.write(temp);
		nameWriter.close();
	}
	
//	랭킹이랑 젠더를 수정하는, 추가하는 메소드라고 생각하면 됨, --> 다시쓰는
	public void updateRanking(String PATH) throws IOException{
		BufferedWriter nameWrite = new DBConnecter().getWriter(PATH);
		ArrayList<Object> datas = new ArrayList<Object>();
		ArrayList<Integer> populations = new ArrayList<>();
		HashSet<Integer> populationSet = null;
		int ranking =1, count =0;
		String temp = "";
	
		datas.addAll(boys);
		datas.addAll(girls);
		
//		각 인구수를 전부 populations에 담기
		boys.stream().map(v -> v.getPopulation()).forEach(populations::add);
		girls.stream().map(v -> v.getPopulation()).forEach(populations::add);
		
		populationSet = new HashSet<Integer>(populations);
		
		populations = new ArrayList<Integer>(populationSet);
		
		populations = (ArrayList<Integer>)populations.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		
		
		for (Integer population : populations) {
			count = 0;
			for (Object vo : datas) {
				if(vo instanceof BoyVO)	{
					BoyVO boy = (BoyVO)vo;
					
					if(boy.getPopulation() == population)	{
						NameDTO result = new NameDTO();
						result.setName(boy.getName());
						result.setRanking(ranking);
						result.setPopulation(boy.getPopulation());
						result.setGender("남자");
						
						temp += result + "\n";
						
						count++;
					}
				}
				if(vo instanceof GirlVO)	{
					GirlVO girl = (GirlVO)vo;
					
					if(girl.getPopulation() == population)	{
						NameDTO result = new NameDTO();
						result.setName(girl.getName());
						result.setRanking(ranking);
						result.setPopulation(girl.getPopulation());
						result.setGender("여자");
						
						temp += result + "\n";
						
						count++;
					}
				}
			}
				if(count > 1) {ranking += count -1;}
				ranking++;
		}
		
		nameWrite.write(temp);
		nameWrite.close();
	}
	
}
