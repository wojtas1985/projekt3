package projekt.service;

import java.util.List;

import projekt.model.ZarzadcaAdres;

public interface ZarzadcaAdresService {
	
	public void addZarzadcaAdres(ZarzadcaAdres zarzadcaAdres);

	public List<ZarzadcaAdres> zarzadcaAdresList();
	
	public ZarzadcaAdres getZarzadcaAdres(int zarzadcaId);
	
	public void deleteZarzadcaAdres(ZarzadcaAdres zarzadcaAdres);

}
