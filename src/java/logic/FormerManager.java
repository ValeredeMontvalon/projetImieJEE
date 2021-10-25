/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import ClassBdd.Former;
import ImiesException.AddException;
import ImiesException.UpdateException;
import Model.DaoHibernateImiesProject;
import ImiesException.SelectFormationException;
import ImiesException.SelectFormerException;
import ImiesException.SelectFormerWithValidLoginException;
import Model.DaoHibernateImiesProject;
import com.sun.java.swing.plaf.windows.resources.windows;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author bouessay.cdi02
 */
@SessionScoped
@ManagedBean
@ApplicationScoped
public class FormerManager implements Serializable {

    private List<Former> listFormer;
    private String firstname;
    private String lastname;
    private String lesson;
    private String login;
    private String password;

    public List<Former> getListFormer() {

        try {
            List<Former> listFormers = DaoHibernateImiesProject.getInstance().selectFormer(new Former());
            this.listFormer = listFormers;
        } catch (SelectFormerException ex) {
            Logger.getLogger(FormerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return this.listFormer;
    }

    public void setListFormer(ArrayList<Former> listFormer) {
        this.listFormer = listFormer;
    }

    public FormerManager() {
    }

    public FormerManager(ArrayList<Former> listFormer) {
        this.listFormer = listFormer;
    }

    public void addFormer() {
        Former f = new Former();
        f.setFormerFirstName(this.firstname);
        f.setFormerLastName(this.lastname);
        f.setFormerLesson(this.lesson);
        f.setFormerPassword(this.password);
        f.setFormerLogin(this.login);
        boolean formerFirstNameEmpty = false;
        boolean formerLastNameEmpty = false;
        boolean formerLoginEmpty = false;
        boolean formerLessonEmpty = false;
        boolean formerPasswordEmpty = false;
        boolean firstNameContainInt = false;
        boolean lastNameContainInt = false;
        boolean lessonContainInt = false;
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
        if (!lessonContainInt && !formerFirstNameEmpty && !formerLastNameEmpty && !formerLessonEmpty && !formerLoginEmpty && !formerPasswordEmpty && !firstNameContainInt && !lastNameContainInt) {
            try {
                DaoHibernateImiesProject.getInstance().addBdd(f);
            } catch (AddException ex) {
                Logger.getLogger(FormerManager.class.getName()).log(Level.SEVERE, null, ex);
            }

            //message d'erreurs a mettre
            //message d'erreurs a mettre
        }
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void updateFormer(Former former) {

        try {
            DaoHibernateImiesProject.getInstance().updateBdd(former);
        } catch (UpdateException ex) {
            Logger.getLogger(FormerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void connexion() {
        Former f = new Former();
        f.setFormerPassword(this.password);
        f.setFormerLogin(this.login);
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
            try {
                listFormerWhithLoginPassword = DaoHibernateImiesProject.getInstance().selectFormerWhithValidLogin(f);
                if (!listFormerWhithLoginPassword.isEmpty()) {
                    try {
                        FacesContext.getCurrentInstance().getExternalContext().redirect("addformer.xhtml");
                    } catch (IOException ex) {
                        Logger.getLogger(FormerManager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    
                }

            } catch (SelectFormerWithValidLoginException ex) {
                Logger.getLogger(FormerManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (listFormerWhithLoginPassword.isEmpty()) {
                // this.viewConnection.ConnectFormerMessage(new LoginFormerParamsException("Mauvais Login Mot de passe"));
            } else {
                //  this.viewConnection.ValidConnexion(listFormerWhithLoginPassword.get(0));
            }
        }

    }

}
