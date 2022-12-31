package dao;

import vo.BoyVO;

public class BoyDAO {
	public BoyVO setObject(String line)	{
		BoyVO boyVO = new BoyVO();
		String data[] = line.split("\t");
		int i = 0;
		
		boyVO.setName(data[i++]);
		boyVO.setRanking(Integer.valueOf(data[i++]));
		boyVO.setPopulation(Integer.valueOf(removeComma(data[i++])));
		
		return boyVO;
	}
	
	public String removeComma(String number)	{
		return number.replaceAll(",", "");
	}
}
