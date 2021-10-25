/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import ClassBdd.Note;
import ClassBdd.Student;
import ImiesException.AddException;
import ImiesException.SelectNoteException;
import ImiesException.UpdateException;
import Model.DaoHibernateImiesProject;
import Model.Model;
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
public class NoteManager {

    /**
     * Creates a new instance of NoteManager
     */
    public NoteManager() {
    }
    
    
     public Note loadNoteByEcf(Note note) {
        try {
            return DaoHibernateImiesProject.getInstance().selectNotebyEcf(note);
            //this.viewAddNote.chargeNoteByEcf(note);
        } catch (SelectNoteException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public void updateNote(Note note) {
        Boolean commentaireNote = true;
        if(note.getNoteCommentary().equals("")){
            commentaireNote = false;
        }
       // note.setIdFormer(this.view.getCurrentFormer());
        if(!commentaireNote){
          //  this.viewAddNote.afficherMessageErreur(new AddNoteParamsException("Vous n'avez pas remplis le commentaire"));
        }else{
            try {
                DaoHibernateImiesProject.getInstance().updateBdd(note);
               // this.viewAddNote.afficherMessageErreur("La modification de la note a bien été prise en compte.");
            } catch (UpdateException ex) {
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     
    public List<Note> loadListNoteByStudent(Student student) {        
        try {
            return DaoHibernateImiesProject.getInstance().selectEcfByStudent(student);
           // this.viewAddNote.ChargeListNote(listNote);
        } catch (SelectNoteException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public void addNote(Note note) {
        Boolean commentaireNote = true;
        if (note.getNoteCommentary().equals("")) {
            commentaireNote = false;
        }
       // note.setIdFormer(this.view.getCurrentFormer());
        if (!commentaireNote) {
           // this.viewAddNote.afficherMessageErreur(new AddNoteParamsException("Vous n'avez pas remplis le commentaire"));
        } else {
            try {
                DaoHibernateImiesProject.getInstance().addBdd(note);
             //   this.viewAddNote.afficherMessageErreur("L'ajout de la note a bien été prise en compte.");
            } catch (AddException ex) {
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
