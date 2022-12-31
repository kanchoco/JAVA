package dao;

import vo.GirlVO;

public class GirlDAO {
	public GirlVO setObject(String line)	{
		GirlVO girlVO = new GirlVO();
		String data[] = line.split("\t");
		int i = 0;
		
		girlVO.setName(data[i++]);
		girlVO.setRanking(Integer.valueOf(data[i++]));
		girlVO.setPopulation(Integer.valueOf(removeComma(data[i++])));
		
		return girlVO;
	}
	
	public String removeComma(String number)	{
		return number.replaceAll(",", "");
	}
}
