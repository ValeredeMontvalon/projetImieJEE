/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import ClassBdd.Formation;
import ImiesException.AddException;
import ImiesException.SelectFormationException;
import Model.DaoHibernateImiesProject;
import Model.Model;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.AjaxBehaviorEvent;

@ManagedBean
@ApplicationScoped

public class FormationManager implements Serializable{

  public FormationManager() {
        
    }
    
    public List<Formation> getListFormation() {
        
         try {
            return DaoHibernateImiesProject.getInstance().selectFormation(new Formation());
           
        } catch (SelectFormationException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
    }
    
   public void addFormation(Formation formation) {
       
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
   }