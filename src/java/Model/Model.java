/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import ImiesException.SelectFormerException;
import ClassBdd.Ecf;

import ClassBdd.Formation;
import ClassBdd.Former;
import ClassBdd.Promotion;
import ClassBdd.School;
import ImiesException.AddException;
import ImiesException.SelectCityNameException;
import ImiesException.SelectDateBeginException;
import ImiesException.SelectDateEndException;
import ImiesException.SelectEcfException;
import ImiesException.SelectFormationException;
import ImiesException.SelectFormerWithValidLoginException;
import ImiesException.SelectPromoException;
import ImiesException.UpdateException;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lor.cdi02
 */
public class Model {
    
    public Model() {
    }
//FAIT 
/*    public void addSite(School site) {
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
    }*/
//FAIT
/*    public void addFormer(Former f) {
        boolean formerFirstNameEmpty = false;
        boolean formerLastNameEmpty = false;
        boolean formerLoginEmpty = false;
        boolean formerLessonEmpty = false;
        boolean formerPasswordEmpty = false;
        boolean firstNameContainInt = false;
        boolean lastNameContainInt = false;
        boolean lessonContainInt = false;
        try {
            for (char c : f.getFormerFirstName().toCharArray()) {
                if (Character.isDigit(c)) {
                    firstNameContainInt = true;
                }
            }
            for (char c : f.getFormerLastName().toCharArray()) {
                if (Character.isDigit(c)) {
                    lastNameContainInt = true;
                }
            }
            for (char c : f.getFormerLesson().toCharArray()) {
                if (Character.isDigit(c)) {
                    lessonContainInt = true;
                }
            }
            if (f.getFormerFirstName().isEmpty()) {
                formerFirstNameEmpty = true;
            }
            if (f.getFormerLastName().isEmpty()) {
                formerLastNameEmpty = true;
            }
            if (f.getFormerLogin().isEmpty()) {
                formerLoginEmpty = true;
            }
            if (f.getFormerLesson().isEmpty()) {
                formerLessonEmpty = true;
            }
            if (f.getFormerPassword().isEmpty()) {
                formerPasswordEmpty = true;
            }
            if (firstNameContainInt && !lastNameContainInt && !lessonContainInt) {
             //   this.viewAddFormer.AddFormerMessage(new AddFormerParamsException("Vous avez mis un entier dans votre prénom !"));
            }
            if (!firstNameContainInt && lastNameContainInt && !lessonContainInt) {
              //  this.viewAddFormer.AddFormerMessage(new AddFormerParamsException("Vous avez mis un entier dans votre nom !"));
            }
            if (!firstNameContainInt && !lastNameContainInt && lessonContainInt) {
              //  this.viewAddFormer.AddFormerMessage(new AddFormerParamsException("Vous avez mis un entier dans votre matière !"));
            }
            if (formerFirstNameEmpty || formerLastNameEmpty || formerLessonEmpty || formerLoginEmpty || formerPasswordEmpty) {
              //  this.viewAddFormer.AddFormerMessage(new AddFormerParamsException("Vous n'avez pas remplis tous les champs  !"));
            }
            if (!lessonContainInt && !formerFirstNameEmpty && !formerLastNameEmpty && !formerLessonEmpty && !formerLoginEmpty && !formerPasswordEmpty && !firstNameContainInt && !lastNameContainInt) {
                DaoHibernateImiesProject.getInstance().addBdd(f);
              //  this.viewAddFormer.AddFormerMessage("Formateur correctement ajouter");

            }
        } catch (AddException e) {
           // this.viewAddFormer.AddFormerMessage(e);
        }
    }*/

    

 
//FAIT
/*    public void listerLesFormations(Formation forma) {
        try {
            List<Formation> listForma = DaoHibernateImiesProject.getInstance().selectFormation(forma);
           // this.view.ChargeListFormation(listForma);
           // this.viewAddPromotion.ChargeListFormation(listForma);
        } catch (SelectFormationException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
//FAIT
/*    public void listerLesVilles() {
        try {
            List<String> listCity = DaoHibernateImiesProject.getInstance().selectCity();
          //  this.view.ChargeListCity(listCity);
        } catch (SelectCityNameException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

    public void listBeginDate() {
        try {
            List<Date> listDateBegin = DaoHibernateImiesProject.getInstance().selectDateBegin();
           // this.view.LoadDateBegin(listDateBegin);
        } catch (SelectDateBeginException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//FAIT
/*    public void listSchool() {
        List<School> listSchool = DaoHibernateImiesProject.getInstance().selectSchool(new School());
        //this.viewAddPromotion.LoadSchoolName(listSchool);Z
    }*/

    public void listEndDate() {
        try {
            List<Date> listDateEnd = DaoHibernateImiesProject.getInstance().selectDateEnd();
            //this.view.LoadDateEnd(listDateEnd);
        } catch (SelectDateEndException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

    public void checkFormerLoginPassword(Former f) {
        try {
            boolean formerLoginEmpty = false;
            boolean formerPasswordEmpty = false;
            List<Former> listFormerWhithLoginPassword = new ArrayList<>();

            if (f.getFormerLogin().isEmpty()) {
                formerLoginEmpty = true;
            }
            if (f.getFormerPassword().isEmpty()) {
                formerPasswordEmpty = true;
            }
            if (formerLoginEmpty && !formerPasswordEmpty) {
              //  this.viewConnection.ConnectFormerMessage(new LoginFormerParamsException("Loggin non renseigné"));
            }
            if (!formerLoginEmpty && formerPasswordEmpty) {
              //  this.viewConnection.ConnectFormerMessage(new LoginFormerParamsException("Mot de passe non renseigné"));
            }
            if (formerLoginEmpty && formerPasswordEmpty) {
              //  this.viewConnection.ConnectFormerMessage(new LoginFormerParamsException("Login et Mot de passe non renseigné"));
            }
            if (!formerLoginEmpty && !formerPasswordEmpty) {
                listFormerWhithLoginPassword = DaoHibernateImiesProject.getInstance().selectFormerWhithValidLogin(f);
                if (listFormerWhithLoginPassword.isEmpty()) {
                   // this.viewConnection.ConnectFormerMessage(new LoginFormerParamsException("Mauvais Login Mot de passe"));
                } else {
                  //  this.viewConnection.ValidConnexion(listFormerWhithLoginPassword.get(0));
                }
            }

        } catch (SelectFormerWithValidLoginException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateFormer(Former former) {
        try {
            DaoHibernateImiesProject.getInstance().updateBdd(former);
           // this.view.updateFormer("Vos parametres ont été mis à jour");
        } catch (UpdateException ex) {
           // this.view.updateFormer(new UpdateFormerException("Vos parametres n'ont pas été mis à jour"));
        }
    }

    public void chargeListFormateurAjouterEtudiant(Former former) {

        List<Former> listFormer;
        try {
            listFormer = DaoHibernateImiesProject.getInstance().selectFormer(former);
           // this.viewAddStudent.chargeListeFormer(listFormer);

        } catch (SelectFormerException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void chargeListFormateurModifierEtudiant(Former former) {

        List<Former> listFormer;
        try {
            listFormer = DaoHibernateImiesProject.getInstance().selectFormer(former);

        } catch (SelectFormerException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    




   

   
//FAIT
/*    public void addFormation(Formation formation) {
        boolean nameFormationIncorrect = false;
        boolean nameFormationEmpty = false;
        if (formation.getFormationName().isEmpty()) {
            nameFormationEmpty = true;
           // this.view.addFormationMessage(new AddFormationParamsException("Le nom de la formation est vide"));
        }
        for (char c : formation.getFormationName().toCharArray()) {
            if (Character.isDigit(c)) {
                nameFormationIncorrect = true;
            }
        }
        
        if (nameFormationIncorrect) {
           // this.view.addFormationMessage(new AddFormationParamsException("Le nom de la formation contient des entiers"));
        }
        if  (!nameFormationEmpty && !nameFormationIncorrect){
            formation.setFormationName(formation.getFormationName().toUpperCase());
            try {
                DaoHibernateImiesProject.getInstance().addBdd(formation);
               // this.view.addFormationMessage("L'ajout de la formation a bien été réalisé.");
            } catch (AddException ex) {
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
*/

}
