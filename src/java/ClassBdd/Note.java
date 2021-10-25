/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassBdd;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lor.cdi02
 */
@Entity
@Table(name = "note")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Note.findAll", query = "SELECT n FROM Note n"),
    @NamedQuery(name = "Note.findByNoteId", query = "SELECT n FROM Note n WHERE n.noteId = :noteId"),
    @NamedQuery(name = "Note.findByNoteValue", query = "SELECT n FROM Note n WHERE n.noteValue = :noteValue"),
    @NamedQuery(name = "Note.findByNoteCommentary", query = "SELECT n FROM Note n WHERE n.noteCommentary = :noteCommentary")})
public class Note implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "note_id")
    private Integer noteId;
    @Column(name = "note_value")
    private Integer noteValue;
    @Column(name = "note_commentary")
    private String noteCommentary;
    @JoinColumn(name = "id_ecf", referencedColumnName = "ecf_id")
    @ManyToOne
    private Ecf idEcf;
    @JoinColumn(name = "id_former", referencedColumnName = "former_id")
    @ManyToOne
    private Former idFormer;
    @JoinColumn(name = "id_student", referencedColumnName = "student_id")
    @ManyToOne
    private Student idStudent;

    public Note() {
    }

    public Note(Integer noteId) {
        this.noteId = noteId;
    }


    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public Integer getNoteValue() {
        return noteValue;
    }

    public void setNoteValue(Integer noteValue) {
        this.noteValue = noteValue;
    }

    public String getNoteCommentary() {
        return noteCommentary;
    }

    public void setNoteCommentary(String noteCommentary) {
        this.noteCommentary = noteCommentary;
    }

    public Ecf getIdEcf() {
        return idEcf;
    }

    public void setIdEcf(Ecf idEcf) {
        this.idEcf = idEcf;
    }

    public Former getIdFormer() {
        return idFormer;
    }

    public void setIdFormer(Former idFormer) {
        this.idFormer = idFormer;
    }

    public Student getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Student idStudent) {
        this.idStudent = idStudent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noteId != null ? noteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Note)) {
            return false;
        }
        Note other = (Note) object;
        if ((this.noteId == null && other.noteId != null) || (this.noteId != null && !this.noteId.equals(other.noteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClassBdd.Note[ noteId=" + noteId + " ]";
    }
    
}
