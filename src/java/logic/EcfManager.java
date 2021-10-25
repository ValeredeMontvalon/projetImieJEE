/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import ClassBdd.Ecf;
import ImiesException.AddException;
import ImiesException.SelectEcfException;
import Model.DaoHibernateImiesProject;
import Model.Model;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author lor.cdi02
 */
@ManagedBean
@ApplicationScoped
public class EcfManager implements Serializable{
    
     public List<Ecf> chargeListEcfAddNote() {
        try {
            return DaoHibernateImiesProject.getInstance().selectEcf(new Ecf());
        } catch (SelectEcfException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
      public void addEcf(Ecf ecf) {
        Boolean ecfNameComplet = true;
        try {
            if (ecf.getEcfName().equals("")) {
                ecfNameComplet = false;
            }
            if (!ecfNameComplet) {
               // this.view.AddEcfMessage(new AddEcfParamException("Vous devez remplir le nom de l'Ecf !"));
            }
            if (ecfNameComplet) {
                DaoHibernateImiesProject.getInstance().addBdd(ecf);
               // this.view.AddEcfMessage("L'Ecf a bien été ajouté !");
            }
        } catch (AddException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
