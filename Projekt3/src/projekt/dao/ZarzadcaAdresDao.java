package projekt.dao;

import java.util.List;

import projekt.model.ZarzadcaAdres;

public interface ZarzadcaAdresDao {
	
	public void addZarzadcaAdres(ZarzadcaAdres zarzadcaAdres);

	public List<ZarzadcaAdres> zarzadcaAdresList();
	
	public ZarzadcaAdres getZarzadcaAdres(int zarzadcaId);
	
	public void deleteZarzadcaAdres(ZarzadcaAdres zarzadcaAdres);

}
