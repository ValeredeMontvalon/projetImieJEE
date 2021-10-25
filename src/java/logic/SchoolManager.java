package logic;

import ClassBdd.School;
import ImiesException.AddException;
import ImiesException.SelectCityNameException;
import ImiesException.SelectSchoolException;
import Model.DaoHibernateImiesProject;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped

public class SchoolManager implements Serializable{
   
    public SchoolManager() {
        
    }
    
    public List<School> getListSchool() {
        
        try {
            return DaoHibernateImiesProject.getInstance().selectSchool(new School());
        } catch (SelectSchoolException ex) {
            Logger.getLogger(SchoolManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<String> listSchoolCity(){

        try {
            return DaoHibernateImiesProject.getInstance().selectCity();
            //  this.view.ChargeListCity(listCity);
        } catch (SelectCityNameException ex) {
            Logger.getLogger(SchoolManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void addSite(School site){
        try {
            boolean cityContainsInt = false;
            boolean SchoolNameEmpty = false;
            boolean CityNameEmpty = false;
            boolean cityNameNotGood = false;
            String cityName = site.getSchoolCity();
            for (char c : cityName.toCharArray()) {
                if (Character.isDigit(c)) {
                    cityContainsInt = true;
                }
            }
            String regExpression = "[a-zA-Z_0-9]*";
            cityNameNotGood = site.getSchoolName().matches(regExpression);
            if (!cityNameNotGood) {
               // this.viewAddSite.addSiteMessagee(new AddSiteParamsException("Nom de ville non valide!"));
            }
            if (site.getSchoolName().equals("")) {
                SchoolNameEmpty = true;
            }
            if (site.getSchoolCity().equals("")) {
                CityNameEmpty = true;
            }
            if (!cityContainsInt && !SchoolNameEmpty && CityNameEmpty) {
                //this.viewAddSite.addSiteMessagee(new AddSiteParamsException("Nom de ville vide!"));
            }
            if (!cityContainsInt && SchoolNameEmpty && !CityNameEmpty) {
               // this.viewAddSite.addSiteMessagee(new AddSiteParamsException("Nom du site vide!"));
            }
            if (cityContainsInt && !SchoolNameEmpty && !CityNameEmpty) {
               // this.viewAddSite.addSiteMessagee(new AddSiteParamsException("Nom de ville invalide car contien des entiers!"));
            }
            if (!cityContainsInt && SchoolNameEmpty && CityNameEmpty) {
               // this.viewAddSite.addSiteMessagee(new AddSiteParamsException("Nom de ville et de site vides!"));
            }
            if (cityContainsInt && SchoolNameEmpty && !CityNameEmpty) {
               // this.viewAddSite.addSiteMessagee(new AddSiteParamsException("Nom de ville invalide et nom d'école vide!"));
            }
            if (!cityContainsInt && !SchoolNameEmpty && !CityNameEmpty && cityNameNotGood) {
                System.out.println("model :" + site.getSchoolCity().toString());
                DaoHibernateImiesProject.getInstance().addBdd(site);
              //  this.viewAddSite.addSiteMessagee("Site correctement ajouter");
            }
        } catch (AddException e) {
            //this.viewAddSite.addSiteMessagee(e);
        }
        System.out.println("model 2:" + site.getSchoolCity().toString());
    }
   }