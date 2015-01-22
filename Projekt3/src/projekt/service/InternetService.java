package projekt.service;

import java.util.List;

import projekt.model.Internet;

public interface InternetService {

	public void addInternet(Internet internet);

	public List<Internet> internetList();

	public Internet getInternet(int internetId);

	public void deleteInternet(Internet internet);

}
