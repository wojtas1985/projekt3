package projekt.dao;

import java.util.List;

import projekt.model.Zarzadca;

public interface ZarzadcaDao {
	
	public void addZarzadca(Zarzadca zarzadca);

	public List<Zarzadca> zarzadcaList();
	
	public Zarzadca getZarzadca(int zarzadcaId);
	
	public void deleteZarzadca(Zarzadca zarzadca);

}
