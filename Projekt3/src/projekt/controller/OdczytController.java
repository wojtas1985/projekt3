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

import projekt.bean.CieploBean;
import projekt.bean.EnergiaBean;
import projekt.bean.GazBean;
import projekt.bean.OdczytBean;
import projekt.bean.WodaBean;
import projekt.model.Cieplo;
import projekt.model.Energia;
import projekt.model.Gaz;
import projekt.model.Obiekt;
import projekt.model.Odczyt;
import projekt.model.Woda;
import projekt.service.CieploService;
import projekt.service.EnergiaService;
import projekt.service.GazService;
import projekt.service.OdczytService;
import projekt.service.WodaService;

@Controller
public class OdczytController{
	
	@Autowired
	private OdczytService odczytService;
	
	@Autowired
	private CieploService cieploService;
	
	@Autowired
	private EnergiaService energiaService;
	
	@Autowired
	private GazService gazService;
	
	@Autowired
	private WodaService wodaService;
	
	@RequestMapping(value = "/saveOdczyt", method = RequestMethod.POST)
	public ModelAndView saveOdczyt(@ModelAttribute("command") Cieplo cieplo, Odczyt odczyt, Energia energia, Gaz gaz,
			Woda woda, Obiekt obiekt, BindingResult result) {
		cieplo.setCieploGJ(cieplo.getCieploGJ());
		cieplo.setCieploPLN(cieplo.getCieploPLN());
		energia.setEnergiaKWH(energia.getEnergiaKWH());
		energia.setEnergiaPLN(energia.getEnergiaPLN());
		gaz.setGazNM3(gaz.getGazNM3());
		gaz.setGazPLN(gaz.getGazPLN());
		woda.setWodaM3(woda.getWodaM3());
		woda.setWodaPLN(woda.getWodaPLN());
		odczyt.setOdczytData(odczyt.getOdczytData());
		odczyt.setOdczytOkresPoczatek(odczyt.getOdczytOkresPoczatek());
		odczyt.setOdczytOkresKoniec(odczyt.getOdczytOkresKoniec());
		odczyt.setObiektId(odczyt.getObiektId());
		odczyt.setCieplo(cieplo);
		odczyt.setEnergia(energia);
		odczyt.setGaz(gaz);
		odczyt.setWoda(woda);
		cieplo.setOdczyt(odczyt);
		energia.setOdczyt(odczyt);
		gaz.setOdczyt(odczyt);
		woda.setOdczyt(odczyt);
		odczytService.addOdczyt(odczyt);
		cieploService.addCieplo(cieplo);
		energiaService.addEnergia(energia);
		gazService.addGaz(gaz);
		wodaService.addWoda(woda);
		return new ModelAndView("redirect:/odczyty.html");
	}
	
	@RequestMapping(value="/odczyty", method = RequestMethod.GET)
	public ModelAndView odczytList() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("odczyty",  prepareListofBean(odczytService.odczytList()));
		model.put("ciepla", prepareListofBeanCieplo(cieploService.cieploList()));
		model.put("energie", prepareListofBeanEnergia(energiaService.energiaList()));
		model.put("gazy", prepareListofBeanGaz(gazService.gazList()));
		model.put("wody", prepareListofBeanWoda(wodaService.wodaList()));
		return new ModelAndView("odczytList", model);
	}
	
	@RequestMapping(value="/odczytyPLN", method = RequestMethod.GET)
	public ModelAndView odczytListPLN() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("odczyty",  prepareListofBean(odczytService.odczytList()));
		model.put("ciepla", prepareListofBeanCieplo(cieploService.cieploList()));
		model.put("energie", prepareListofBeanEnergia(energiaService.energiaList()));
		model.put("gazy", prepareListofBeanGaz(gazService.gazList()));
		model.put("wody", prepareListofBeanWoda(wodaService.wodaList()));
		return new ModelAndView("odczytListPLN", model);
	}
	
	@RequestMapping(value = "/deleteOdczyt", method = RequestMethod.GET)
	public ModelAndView deleteOdczyt(@ModelAttribute("command")  OdczytBean odczytBean, CieploBean cieploBean, EnergiaBean energiaBean,
			GazBean gazBean, WodaBean wodaBean, BindingResult result) {
		odczytService.deleteOdczyt(prepareModel(odczytBean));
		cieploService.deleteCieplo(prepareModel(cieploBean));
		energiaService.deleteEnergia(prepareModel(energiaBean));
		gazService.deleteGaz(prepareModel(gazBean));
		wodaService.deleteWoda(prepareModel(wodaBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("odczyt", null);
		model.put("odczyty",  prepareListofBean(odczytService.odczytList()));
		return new ModelAndView("odczytList", model);
	}
	
	@RequestMapping("/odczyt.html")
	public String redirect()
	{
		return "addOdczyt";
	}
	
	private List<OdczytBean> prepareListofBean(List<Odczyt> odczyty){
		List<OdczytBean> beans = null;
		if(odczyty != null && !odczyty.isEmpty()){
			beans = new ArrayList<OdczytBean>();
			OdczytBean bean = null;
			for(Odczyt odczyt : odczyty){
				bean = new OdczytBean();
				bean.setId(odczyt.getOdczytId());
				bean.setData(odczyt.getOdczytData());
				bean.setOkresPoczatek(odczyt.getOdczytOkresPoczatek());
				bean.setOkresKoniec(odczyt.getOdczytOkresKoniec());
				bean.setObiektId(odczyt.getObiektId());
				bean.setCieplo(odczyt.getCieplo());
				bean.setEnergia(odczyt.getEnergia());
				bean.setGaz(odczyt.getGaz());
				bean.setWoda(odczyt.getWoda());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<CieploBean> prepareListofBeanCieplo(List<Cieplo> ciepla){
		List<CieploBean> beans = null;
		if(ciepla != null && !ciepla.isEmpty()){
			beans = new ArrayList<CieploBean>();
			CieploBean bean = null;
			for(Cieplo cieplo : ciepla){
				bean = new CieploBean();
				bean.setgJ(cieplo.getCieploGJ());
				bean.setpLN(cieplo.getCieploPLN());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<EnergiaBean> prepareListofBeanEnergia(List<Energia> energie){
		List<EnergiaBean> beans = null;
		if(energie != null && !energie.isEmpty()){
			beans = new ArrayList<EnergiaBean>();
			EnergiaBean bean = null;
			for(Energia energia : energie){
				bean = new EnergiaBean();
				bean.setkWH(energia.getEnergiaKWH());
				bean.setpLN(energia.getEnergiaPLN());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<GazBean> prepareListofBeanGaz(List<Gaz> gazy){
		List<GazBean> beans = null;
		if(gazy != null && !gazy.isEmpty()){
			beans = new ArrayList<GazBean>();
			GazBean bean = null;
			for(Gaz gaz : gazy){
				bean = new GazBean();
				bean.setNm3(gaz.getGazNM3());
				bean.setpLN(gaz.getGazPLN());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<WodaBean> prepareListofBeanWoda(List<Woda> wody){
		List<WodaBean> beans = null;
		if(wody != null && !wody.isEmpty()){
			beans = new ArrayList<WodaBean>();
			WodaBean bean = null;
			for(Woda woda : wody){
				bean = new WodaBean();
				bean.setM3(woda.getWodaM3());
				bean.setpLN(woda.getWodaPLN());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private Odczyt prepareModel(OdczytBean odczytBean){
		Odczyt odczyt = new Odczyt();
		odczyt.setOdczytData(odczytBean.getData());
		odczyt.setOdczytOkresPoczatek(odczytBean.getOkresPoczatek());
		odczyt.setOdczytOkresKoniec(odczytBean.getOkresKoniec());
		odczyt.setObiektId(odczytBean.getObiektId());
		odczyt.setCieplo(odczytBean.getCieplo());
		odczyt.setEnergia(odczytBean.getEnergia());
		odczyt.setGaz(odczytBean.getGaz());
		odczyt.setWoda(odczytBean.getWoda());
		odczyt.setOdczytId(odczytBean.getId());
		odczytBean.setId(null);
		return odczyt;
	}
	
	private Cieplo prepareModel(CieploBean cieploBean){
		Cieplo cieplo = new Cieplo();
		cieplo.setCieploGJ(cieploBean.getgJ());
		cieplo.setCieploPLN(cieploBean.getpLN());
		cieplo.setOdczytId(cieploBean.getId());
		cieploBean.setId(null);
		return cieplo;
	}
	
	private Energia prepareModel(EnergiaBean energiaBean){
		Energia energia = new Energia();
		energia.setEnergiaKWH(energiaBean.getkWH());
		energia.setEnergiaPLN(energiaBean.getpLN());
		energia.setOdczytId(energiaBean.getId());
		energiaBean.setId(0);
		return energia;
	}
	
	private Gaz prepareModel(GazBean gazBean){
		Gaz gaz = new Gaz();
		gaz.setGazNM3(gazBean.getNm3());
		gaz.setGazPLN(gazBean.getpLN());
		gaz.setOdczytId(gazBean.getId());
		gazBean.setId(null);
		return gaz;
	}
	
	private Woda prepareModel(WodaBean wodaBean){
		Woda woda = new Woda();
		woda.setWodaM3(wodaBean.getM3());
		woda.setWodaPLN(wodaBean.getpLN());
		woda.setOdczytId(wodaBean.getId());
		wodaBean.setId(null);
		return woda;
	}
}
