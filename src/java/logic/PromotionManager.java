/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import ClassBdd.Formation;
import ClassBdd.Promotion;
import ImiesException.AddException;
import ImiesException.SelectDateBeginException;
import ImiesException.SelectDateEndException;
import ImiesException.SelectPromoException;
import ImiesException.UpdateException;
import Model.DaoHibernateImiesProject;
import Model.Model;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author lor.cdi02
 */
@ManagedBean
@SessionScoped
public class PromotionManager {

    private Formation formationRecherche;
    
    private int selectedFormation;

    public void setSelectedFormation(int selectedFormation) {
        this.selectedFormation = selectedFormation;
    }
    
    public int getSelectedFormation() {
        return selectedFormation;
    }

    public void changeFormation() {
        formationRecherche = new Formation();
        formationRecherche.setFormationId(selectedFormation);
    }
    /**
     * Creates a new instance of PromotionManager
     */
    public PromotionManager() {
    }
    private List<Date> listBeginDate;
    private List<Date> listEndDate;
    private List<Promotion> listPromotion;
    

    public Formation getFormationRecherche() {
        return formationRecherche;
    }
    public void setFormationRecherche(Formation formationRecherche) {
        this.formationRecherche = formationRecherche;
    }

  
    
    public List<Promotion> getListPromotions() {
      try {
          Promotion promotion = new Promotion();
          promotion.setIdFormation(formationRecherche);
          return DaoHibernateImiesProject.getInstance().selectPromo(promotion);

            //this.view.chargeListePromotion(listPromo);
           // this.view.chargePromoJTable(listPromo);
        } catch (SelectPromoException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
      return null;
    }
    
     public Promotion addPromotion(Promotion p) {

        Boolean formationSelected = true;
        Boolean schoolSelected = true;
        try {
            if (p.getPromotionDateBegin().after(p.getPromotionDateEnd())) {
             //   this.viewAddPromotion.AddPromotionMessage(new AddPromotionException("La date de fin doit être postérieur à la date de début"));

            } else {
                if (p.getIdSchool() == null) {
                    schoolSelected = false;
                }
                if (p.getIdFormation() == null) {
                    formationSelected = false;
                }
                if (schoolSelected && !formationSelected) {
                   // this.viewAddPromotion.AddPromotionMessage(new AddPromotionParametreException("Vous devez choisir une formation !"));
                }
                if (!schoolSelected && !formationSelected) {
                   // this.viewAddPromotion.AddPromotionMessage(new AddPromotionParametreException("Vous devez choisir une formation et un lieu de formation!"));
                }
                if (!schoolSelected && formationSelected) {
                   // this.viewAddPromotion.AddPromotionMessage(new AddPromotionParametreException("Vous devez choisir un lieu de formation !"));
                }
                if (schoolSelected && formationSelected) {
                    String numberOfPromotion = DaoHibernateImiesProject.getInstance().findPromotionNumber(p.getIdFormation(), p.getIdSchool());
                    p.setPromotionNumber(numberOfPromotion);
                    String promotionName = p.getIdFormation().getFormationName().toUpperCase() + "_" + p.getIdSchool().getSchoolCity().toUpperCase().charAt(0) + numberOfPromotion;
                    p.setPromotionName(promotionName);

                    DaoHibernateImiesProject.getInstance().addBdd(p);
                  //  this.viewAddPromotion.AddPromotionMessage("La promotion a bien été ajoutée !");
                }

            }

        } catch (AddException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
     
     public void updatePromotion(Promotion p) {
        Boolean formationSelected = true;
        Boolean schoolSelected = true;
        try {
            if (p.getPromotionDateBegin().after(p.getPromotionDateEnd())) {
               // this.viewAddPromotion.AddPromotionMessage(new AddPromotionException("La date de fin doit être postérieur à la date de début"));

            } else {
                if (p.getIdSchool() == null) {
                    schoolSelected = false;
                }
                if (p.getIdFormation() == null) {
                    formationSelected = false;
                }
                if (schoolSelected && !formationSelected) {
                   // this.viewAddPromotion.AddPromotionMessage(new AddPromotionParametreException("Vous devez choisir une formation !"));
                }
                if (!schoolSelected && !formationSelected) {
                   // this.viewAddPromotion.AddPromotionMessage(new AddPromotionParametreException("Vous devez choisir une formation et un lieu de formation!"));
                }
                if (!schoolSelected && formationSelected) {
                   // this.viewAddPromotion.AddPromotionMessage(new AddPromotionParametreException("Vous devez choisir un lieu de formation !"));
                }
                if (schoolSelected && formationSelected) {
                    String promotionName = p.getIdFormation().getFormationName().toUpperCase() + "_" + p.getIdSchool().getSchoolName().toUpperCase().charAt(0) + p.getPromotionNumber();
                    p.setPromotionName(promotionName);

                    DaoHibernateImiesProject.getInstance().updateBdd(p);
                   // this.viewAddPromotion.AddPromotionMessage("La promotion a bien été mise à jour !");
                }
            }
        } catch (UpdateException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
         public List<Date> getlistEndDate() {
        try {
            List<Date> listEndDate = DaoHibernateImiesProject.getInstance().selectDateEnd();
            this.listEndDate = listEndDate;
            //this.view.LoadDateEnd(listDateEnd);
        } catch (SelectDateEndException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.listEndDate;
    }
         
    public List<Date> getlistBeginDate() {
        try {
            List<Date> listBeginDate =  DaoHibernateImiesProject.getInstance().selectDateBegin();
            this.listBeginDate = listBeginDate;
           // this.view.LoadDateBegin(listDateBegin);
        } catch (SelectDateBeginException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.listBeginDate;
    }
}
