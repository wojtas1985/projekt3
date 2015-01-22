package projekt.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import projekt.bean.ZarzadcaAdresBean;
import projekt.bean.ZarzadcaBean;
import projekt.model.Obiekt;
import projekt.model.Zarzadca;
import projekt.model.ZarzadcaAdres;
import projekt.service.ZarzadcaAdresService;
import projekt.service.ZarzadcaService;

@Controller
public class ZarzadcaController {

	@Autowired
	private ZarzadcaAdresService zarzadcaAdresService;
	
	@Autowired
	private ZarzadcaService zarzadcaService;
	
	@RequestMapping(value = "/saveZarzadca", method = RequestMethod.POST)
	public ModelAndView saveZarzadca(@ModelAttribute("command") Zarzadca zarzadca, ZarzadcaAdres zarzadcaAdres, 
			Obiekt obiekt, BindingResult result) {
		zarzadcaAdres.setZarzadcaMiejscowosc(zarzadcaAdres.getZarzadcaMiejscowosc());
		zarzadcaAdres.setZarzadcaKodPocztowy(zarzadcaAdres.getZarzadcaKodPocztowy());
		zarzadcaAdres.setZarzadcaUlica(zarzadcaAdres.getZarzadcaUlica());
		zarzadcaAdres.setZarzadcaNumerDomu(zarzadcaAdres.getZarzadcaNumerDomu());
		zarzadca.setZarzadcaImie(zarzadca.getZarzadcaImie());
		zarzadca.setZarzadcaNazwisko(zarzadca.getZarzadcaNazwisko());
		zarzadca.setZarzadcaDataUrodzenia(zarzadca.getZarzadcaDataUrodzenia());
		zarzadca.setZarzadcaTelefon(zarzadca.getZarzadcaTelefon());
		zarzadca.setZarzadcaEmail(zarzadca.getZarzadcaEmail());
		zarzadca.setObiektId(zarzadca.getObiektId());
		zarzadca.setZarzadcaAdres(zarzadcaAdres);
		zarzadcaAdres.setZarzadca(zarzadca);
		zarzadcaService.addZarzadca(zarzadca);
		zarzadcaAdresService.addZarzadcaAdres(zarzadcaAdres);
		return new ModelAndView("redirect:/zarzadca.html");
	}
	
	@RequestMapping(value = "/deleteZarzadca", method = RequestMethod.GET)
	public ModelAndView deleteZarzadca(@ModelAttribute("command")  ZarzadcaBean zarzadcaBean, ZarzadcaAdresBean zarzadcaAdresBean, BindingResult result) {
		zarzadcaService.deleteZarzadca(prepareModel(zarzadcaBean));
		zarzadcaAdresService.deleteZarzadcaAdres(prepareModel(zarzadcaAdresBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("zarzadca", null);
		model.put("zarzadcy",  prepareListofBeanZarzadca(zarzadcaService.zarzadcaList()));
		return new ModelAndView("addZarzadca", model);
	}
	
	@RequestMapping(value = "/zarzadca", method = RequestMethod.GET)
	public ModelAndView redirect()
	{
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("zarzadcy",  prepareListofBeanZarzadca(zarzadcaService.zarzadcaList()));
		return new ModelAndView("addZarzadca", model);
	}
	
	@RequestMapping(value = "/openZarzadca", method = RequestMethod.GET)
	public ModelAndView openZarzadca(
			@ModelAttribute("command") ZarzadcaBean zarzadcaBean,
			ZarzadcaAdresBean zarzadcaAdresBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("zarzadca", prepareZarzadcaBean(zarzadcaService.getZarzadca(zarzadcaBean.getId())));
		model.put("zarzadcaAdres", prepareZarzadcaAdresBean(zarzadcaAdresService.getZarzadcaAdres(zarzadcaAdresBean.getId())));
		return new ModelAndView("openZarzadca", model);
	}
	
	private ZarzadcaBean prepareZarzadcaBean(Zarzadca zarzadca) {
		ZarzadcaBean bean = new ZarzadcaBean();
		bean.setImie(zarzadca.getZarzadcaImie());
		bean.setNazwisko(zarzadca.getZarzadcaNazwisko());
		bean.setDataUrodzenia(zarzadca.getZarzadcaDataUrodzenia());
		bean.setTelefon(zarzadca.getZarzadcaTelefon());
		bean.setEmail(zarzadca.getZarzadcaEmail());
		bean.setObiektId(zarzadca.getObiektId());
		bean.setId(zarzadca.getZarzadcaId());
		return bean;
	}

	private ZarzadcaAdresBean prepareZarzadcaAdresBean(ZarzadcaAdres zarzadcaAdres) {
		ZarzadcaAdresBean bean = new ZarzadcaAdresBean();
		bean.setMiejscowosc(zarzadcaAdres.getZarzadcaMiejscowosc());
		bean.setKodPocztowy(zarzadcaAdres.getZarzadcaKodPocztowy());
		bean.setUlica(zarzadcaAdres.getZarzadcaUlica());
		bean.setNumerDomu(zarzadcaAdres.getZarzadcaNumerDomu());
		return bean;
	}

	private List<ZarzadcaBean> prepareListofBeanZarzadca(List<Zarzadca> zarzadcy){
		List<ZarzadcaBean> beans = null;
		if(zarzadcy != null && !zarzadcy.isEmpty()){
			beans = new ArrayList<ZarzadcaBean>();
			ZarzadcaBean bean = null;
			for(Zarzadca zarzadca : zarzadcy){
				bean = new ZarzadcaBean();
				bean.setId(zarzadca.getZarzadcaId());
				bean.setImie(zarzadca.getZarzadcaImie());
				bean.setNazwisko(zarzadca.getZarzadcaNazwisko());
				bean.setDataUrodzenia(zarzadca.getZarzadcaDataUrodzenia());
				bean.setTelefon(zarzadca.getZarzadcaTelefon());
				bean.setEmail(zarzadca.getZarzadcaEmail());
				bean.setObiektId(zarzadca.getObiektId());
				bean.setZarzadcaAdres(zarzadca.getZarzadcaAdres());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	/*private List<ZarzadcaAdresBean> prepareListofBeanZarzadcaAdres(List<ZarzadcaAdres> zarzadcyAdresy){
		List<ZarzadcaAdresBean> beans = null;
		if(zarzadcyAdresy != null && !zarzadcyAdresy.isEmpty()){
			beans = new ArrayList<ZarzadcaAdresBean>();
			ZarzadcaAdresBean bean = null;
			for(ZarzadcaAdres zarzadcaAdres : zarzadcyAdresy){
				bean = new ZarzadcaAdresBean();
				bean.setMiejscowosc(zarzadcaAdres.getZarzadcaMiejscowosc());
				bean.setKodPocztowy(zarzadcaAdres.getZarzadcaKodPocztowy());
				bean.setUlica(zarzadcaAdres.getZarzadcaUlica());
				bean.setNumerDomu(zarzadcaAdres.getZarzadcaNumerDomu());
				beans.add(bean);
			}
		}
		return beans;
	}*/
	
	private Zarzadca prepareModel(ZarzadcaBean zarzadcaBean){
		Zarzadca zarzadca = new Zarzadca();
		zarzadca.setZarzadcaImie(zarzadcaBean.getImie());
		zarzadca.setZarzadcaNazwisko(zarzadcaBean.getNazwisko());
		zarzadca.setZarzadcaDataUrodzenia(zarzadcaBean.getDataUrodzenia());
		zarzadca.setZarzadcaTelefon(zarzadcaBean.getTelefon());
		zarzadca.setZarzadcaEmail(zarzadcaBean.getEmail());
		zarzadca.setObiektId(zarzadcaBean.getObiektId());
		zarzadca.setZarzadcaId(zarzadcaBean.getId());
		zarzadca.setZarzadcaAdres(zarzadcaBean.getZarzadcaAdres());
		zarzadcaBean.setId(null);
		return zarzadca;
	}
	
	private ZarzadcaAdres prepareModel(ZarzadcaAdresBean zarzadcaAdresBean){
		ZarzadcaAdres zarzadcaAdres = new ZarzadcaAdres();
		zarzadcaAdres.setZarzadcaMiejscowosc(zarzadcaAdresBean.getMiejscowosc());
		zarzadcaAdres.setZarzadcaKodPocztowy(zarzadcaAdresBean.getKodPocztowy());
		zarzadcaAdres.setZarzadcaUlica(zarzadcaAdresBean.getUlica());
		zarzadcaAdres.setZarzadcaNumerDomu(zarzadcaAdresBean.getNumerDomu());
		zarzadcaAdres.setZarzadcaId(zarzadcaAdresBean.getId());
		zarzadcaAdresBean.setId(null);
		return zarzadcaAdres;
	}
}
