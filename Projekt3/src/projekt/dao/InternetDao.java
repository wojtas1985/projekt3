package projekt.dao;

import java.util.List;

import projekt.model.Internet;

public interface InternetDao {
	
	public void addInternet(Internet internet);

	public List<Internet> internetList();
	
	public Internet getInternet(int internetId);
	
	public void deleteInternet(Internet internet);

}
