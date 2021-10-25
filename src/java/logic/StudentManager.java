/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import ClassBdd.Promotion;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import ClassBdd.Student;
import ImiesException.AddException;
import ImiesException.SelectStudentException;
import ImiesException.UpdateException;
import Model.DaoHibernateImiesProject;
import Model.Model;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.faces.context.FacesContext;
/**
 *
 * @author lor.cdi02
 */
@ManagedBean
@ApplicationScoped

public class StudentManager implements Serializable{
   
    public StudentManager() {
        
    }
    
    public List<Student> getListStudent() {
        List<Student> listStudent ;
         try {
            return DaoHibernateImiesProject.getInstance().selectStudent(new Student());
           
        } catch (SelectStudentException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
    }
    
    public List<Student> getListStudentByPromotion(Promotion promo) {
        List<Student> listStudent ;
         try {
            return DaoHibernateImiesProject.getInstance().selectStudent(new Student());
           
        } catch (SelectStudentException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
    }
    
    public void addStudent(){
    }
    public void addStudent(Student student) {
        boolean eMailValide = true;

        boolean nomValide = true;
        boolean prenomValide = true;

        if (!(student.getStudentFirstName().isEmpty()) && !(student.getStudentLastName().isEmpty()) && !(student.getIdFormer() == null) && !(student.getIdPromotion() == null) && !(student.getStudentAge() == null) && !(student.getStudentMail().isEmpty())) {
            for (char c : student.getStudentFirstName().toCharArray()) {
                if (Character.isDigit(c)) {
                    prenomValide = false;
                }
            }
            for (char c : student.getStudentLastName().toCharArray()) {
                if (Character.isDigit(c)) {
                    nomValide = false;
                }
            }
            //vérifier email; (pas de nombre, et c'est un entier)numtel,age; etles cmbox.
            if (!(Pattern.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$", student.getStudentMail()))) {
                eMailValide = false;
            }
            if (!eMailValide) {
               // this.viewAddStudent.afficherMessageErreur(new AddStudentParamsException("L'adresse mail doit se présenter sous la forme '+____@___.__+'"));
            } else if (!nomValide) {
               // this.viewAddStudent.afficherMessageErreur(new AddStudentParamsException("Nom non valide"));
            } else if (!prenomValide) {
              //  this.viewAddStudent.afficherMessageErreur(new AddStudentParamsException("Prénom non valide"));
            } else {
                try {
                    DaoHibernateImiesProject.getInstance().addBdd(student);
                } catch (AddException ex) {
                    Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

     public void updateStudent(Student student) {
        boolean eMailValide = true;

        boolean nomValide = true;
        boolean prenomValide = true;

        if (!(student.getStudentFirstName().isEmpty()) && !(student.getStudentLastName().isEmpty()) && !(student.getIdFormer() == null) && !(student.getIdPromotion() == null) && !(student.getStudentAge() == null) && !(student.getStudentMail().isEmpty())) {
            for (char c : student.getStudentFirstName().toCharArray()) {
                if (Character.isDigit(c)) {
                    prenomValide = false;
                }
            }
            for (char c : student.getStudentLastName().toCharArray()) {
                if (Character.isDigit(c)) {
                    nomValide = false;
                }
            }
            //vérifier email; (pas de nombre, et c'est un entier)numtel,age; etles cmbox.
            if (!(Pattern.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$", student.getStudentMail()))) {
                eMailValide = false;
            }
            if (!eMailValide) {
              //  this.viewAddStudent.afficherMessageErreur(new AddStudentParamsException("L'adresse mail doit se présenter sous la forme '+____@___.__+'"));
            } else if (!nomValide) {
               // this.viewAddStudent.afficherMessageErreur(new AddStudentParamsException("Nom non valide"));
            } else if (!prenomValide) {
               // this.viewAddStudent.afficherMessageErreur(new AddStudentParamsException("Prénom non valide"));
            } else {
                try {
                    DaoHibernateImiesProject.getInstance().updateBdd(student);
                 //   this.viewAddStudent.setAjouterEtudiantNotVisible();
                 //   this.viewAddStudent.afficherMessageErreur("La modification de l'étudiant a bien été réalisé ! ");
                  //  this.view.setPromoAfterAddStudent(student.getIdPromotion());

                } catch (UpdateException ex) {
                    Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
           // this.viewAddStudent.afficherMessageErreur(new AddException("Vos entrées ne sont pas complètes"));
        }
    }
}
