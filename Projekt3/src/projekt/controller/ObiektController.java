package projekt.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import projekt.bean.ObiektAdresBean;
import projekt.bean.ObiektBean;
import projekt.bean.ObiektKontaktBean;
import projekt.model.Obiekt;
import projekt.model.ObiektAdres;
import projekt.model.ObiektKontakt;
import projekt.service.ObiektAdresService;
import projekt.service.ObiektKontaktService;
import projekt.service.ObiektService;
import projekt.service.OdczytService;

@Controller
public class ObiektController {

	@Autowired
	private ObiektService obiektService;

	@Autowired
	private ObiektAdresService obiektAdresService;

	@Autowired
	private ObiektKontaktService obiektKontaktService;

	@Autowired
	private OdczytService odczytService;

	@RequestMapping(value = "/saveObiekt", method = RequestMethod.POST)
	public ModelAndView saveObiekt(
			@ModelAttribute("command") ObiektBean obiektBean,
			ObiektAdresBean obiektAdresBean,
			ObiektKontaktBean obiektKontaktBean, BindingResult result) {
		Obiekt obiekt = prepareModel(obiektBean);
		ObiektAdres obiektAdres = prepareModel(obiektAdresBean);
		ObiektKontakt obiektKontakt = prepareModel(obiektKontaktBean);
		obiekt.setObiektAdres(obiektAdres);
		obiekt.setObiektKontakt(obiektKontakt);
		obiektAdres.setObiekt(obiekt);
		obiektKontakt.setObiekt(obiekt);
		obiektService.addObiekt(obiekt);
		obiektAdresService.addObiektAdres(obiektAdres);
		obiektKontaktService.addObiektKontakt(obiektKontakt);
		return new ModelAndView("redirect:/obiekty.html");
	}

	@RequestMapping(value = "/obiekty", method = RequestMethod.GET)
	public ModelAndView obiektList() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("obiekty", prepareListofBean(obiektService.obiektList()));
		return new ModelAndView("obiektList", model);
	}

	@RequestMapping(value = "/obiekt", method = RequestMethod.GET)
	public ModelAndView openEmployee(
			@ModelAttribute("command") ObiektBean obiektBean,
			ObiektAdresBean obiektAdresBean, BindingResult result) {
		return new ModelAndView("addObiekt");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteObiekt(
			@ModelAttribute("command") ObiektBean obiektBean,
			ObiektAdresBean obiektAdresBean,
			ObiektKontaktBean obiektKontaktBean, BindingResult result) {
		obiektService.deleteObiekt(prepareModel(obiektBean));
		obiektAdresService.deleteObiektAdres(prepareModel(obiektAdresBean));
		obiektKontaktService
				.deleteObiektKontakt(prepareModel(obiektKontaktBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("obiekt", null);
		model.put("obiektAdres", null);
		model.put("obiektKontakt", null);
		model.put("odczyt", null);
		model.put("obiekty", prepareListofBean(obiektService.obiektList()));
		return new ModelAndView("obiektList", model);
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String printMessage(ModelMap model) {

		return "login";

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {

		return "login";

	}

	@RequestMapping(value = "/failLogin", method = RequestMethod.GET)
	public String failedLogin(ModelMap model) {

		model.addAttribute("error", "true");
		return "login";

	}

	@RequestMapping(value = "/logoff", method = RequestMethod.GET)
	public String logoff(ModelMap model) {

		return "login";

	}

	@RequestMapping(value = "/403")
	public String accessDenied() {

		return "403";
	}

	@RequestMapping("/welcome")
	public String redirect() {
		return "welcome";
	}

	@RequestMapping("/checkObiekt")
	public String redirect2() {
		return "checkObiekt";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editObiekt(
			@ModelAttribute("command") ObiektBean obiektBean,
			ObiektAdresBean obiektAdresBean,
			ObiektKontaktBean obiektKontaktBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("obiekt",
				prepareObiektBean(obiektService.getObiekt(obiektBean.getId())));
		model.put("obiektAdres", prepareObiektAdresBean(obiektAdresService
				.getObiektAdres(obiektBean.getId())));
		model.put("obiektKontakt",
				prepareObiektKontaktBean(obiektKontaktService
						.getObiektKontakt(obiektBean.getId())));
		return new ModelAndView("addObiekt", model);
	}

	@RequestMapping(value = "/open", method = RequestMethod.GET)
	public ModelAndView openObiekt(
			@ModelAttribute("command") ObiektBean obiektBean,
			ObiektAdresBean obiektAdresBean,
			ObiektKontaktBean obiektKontaktBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("obiekt",
				prepareObiektBean(obiektService.getObiekt(obiektBean.getId())));
		model.put("obiektAdres", prepareObiektAdresBean(obiektAdresService
				.getObiektAdres(obiektAdresBean.getId())));
		model.put("obiektKontakt",
				prepareObiektKontaktBean(obiektKontaktService
						.getObiektKontakt(obiektKontaktBean.getId())));
		return new ModelAndView("openObiekt", model);
	}

	private Obiekt prepareModel(ObiektBean obiektBean) {
		Obiekt obiekt = new Obiekt();
		obiekt.setObiektNazwa(obiektBean.getNazwa());
		obiekt.setObiektPowierzchnia(obiektBean.getPowierzchnia());
		obiekt.setObiektKubatura(obiektBean.getKubatura());
		obiekt.setObiektLiczbaUzytkownikow(obiektBean.getLiczbaUzytkownikow());
		obiekt.setObiektCzyCalodobowy(obiektBean.getCzyCalodobowy());
		obiekt.setObiektId(obiektBean.getId());
		obiektBean.setId(null);
		return obiekt;
	}

	private ObiektAdres prepareModel(ObiektAdresBean obiektAdresBean) {
		ObiektAdres obiektAdres = new ObiektAdres();
		obiektAdres.setObiektMiejscowosc(obiektAdresBean.getMiejscowosc());
		obiektAdres.setObiektKodPocztowy(obiektAdresBean.getKodPocztowy());
		obiektAdres.setObiektUlica(obiektAdresBean.getUlica());
		obiektAdres.setObiektNumerDomu(obiektAdresBean.getNumerDomu());
		obiektAdres.setObiektId(obiektAdresBean.getId());
		obiektAdresBean.setId(null);
		return obiektAdres;
	}

	private ObiektKontakt prepareModel(ObiektKontaktBean obiektKontaktBean) {
		ObiektKontakt obiektKontakt = new ObiektKontakt();
		obiektKontakt.setObiektTelefon(obiektKontaktBean.getTelefon());
		obiektKontakt.setObiektFax(obiektKontaktBean.getFax());
		obiektKontakt.setObiektEmail(obiektKontaktBean.getEmail());
		obiektKontakt.setObiektId(obiektKontaktBean.getId());
		obiektKontaktBean.setId(null);
		return obiektKontakt;
	}

	private List<ObiektBean> prepareListofBean(List<Obiekt> obiekty) {
		List<ObiektBean> beans = null;
		if (obiekty != null && !obiekty.isEmpty()) {
			beans = new ArrayList<ObiektBean>();
			ObiektBean bean = null;
			for (Obiekt obiekt : obiekty) {
				bean = new ObiektBean();
				bean.setId(obiekt.getObiektId());
				bean.setNazwa(obiekt.getObiektNazwa());
				bean.setPowierzchnia(obiekt.getObiektPowierzchnia());
				bean.setKubatura(obiekt.getObiektKubatura());
				bean.setLiczbaUzytkownikow(obiekt.getObiektLiczbaUzytkownikow());
				bean.setCzyCalodobowy(obiekt.isObiektCzyCalodobowy());
				beans.add(bean);
			}
		}
		return beans;
	}

	private ObiektBean prepareObiektBean(Obiekt obiekt) {
		ObiektBean bean = new ObiektBean();
		bean.setNazwa(obiekt.getObiektNazwa());
		bean.setPowierzchnia(obiekt.getObiektPowierzchnia());
		bean.setKubatura(obiekt.getObiektKubatura());
		bean.setLiczbaUzytkownikow(obiekt.getObiektLiczbaUzytkownikow());
		bean.setCzyCalodobowy(obiekt.isObiektCzyCalodobowy());
		bean.setId(obiekt.getObiektId());
		return bean;
	}

	private ObiektAdresBean prepareObiektAdresBean(ObiektAdres obiektAdres) {
		ObiektAdresBean bean = new ObiektAdresBean();
		bean.setMiejscowosc(obiektAdres.getObiektMiejscowosc());
		bean.setKodPocztowy(obiektAdres.getObiektKodPocztowy());
		bean.setUlica(obiektAdres.getObiektUlica());
		bean.setNumerDomu(obiektAdres.getObiektNumerDomu());
		return bean;
	}

	private ObiektKontaktBean prepareObiektKontaktBean(
			ObiektKontakt obiektKontakt) {
		ObiektKontaktBean bean = new ObiektKontaktBean();
		bean.setTelefon(obiektKontakt.getObiektTelefon());
		bean.setFax(obiektKontakt.getObiektFax());
		bean.setEmail(obiektKontakt.getObiektEmail());
		return bean;
	}

}
