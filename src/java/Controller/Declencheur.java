/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author lor.cdi02
 */
public class Declencheur {

    /**
     * ATTRIBUTES
     */
    public final static byte AJOUT_SCHOOL = 1;
    public final static byte CHOIX_PROMOTION = 2;
    public final static byte AJOUT_FORMER = 4;

    public final static byte LOAD_FORMATION = 3;
    public final static byte LOAD_CITY_NAME = 5;
    public final static byte LOAD_SCHOOL = 6;

    public final static byte LOAD_BEGIN_DATE = 7;
    public final static byte LOAD_END_DATE = 8;
    public final static byte SEARCH_IDSCHOOL_WITH_NAME = 10;

    public final static byte AFFICHAGE_PROMOTION_CHOISIE = 9;

    public final static byte CHOIX_PROMOTION_TRIE = 11;
    public final static byte CHECK_LOGIN_PASSWORD = 12;
    public final static byte CORRECT_LOGIN_PASSWORD = 13;

    public final static byte UPDATE_FORMER = 14;
    public final static byte ADD_STUDENT = 15;
    public final static byte LOAD_LIST_PROMO_ADD_STUDENT = 16;
    public final static byte LOAD_LIST_FORMER_ADD_STUDENT = 17;
    public final static byte UPDATE_PROMOTION = 18;
    public final static byte RELOAD_LIST_PROMOTION = 19;
    public final static byte LOAD_LIST_PROMO_EDIT_STUDENT = 20;
    public final static byte LOAD_LIST_FORMER_EDIT_STUDENT = 21;
    public final static byte ADD_ECF = 22;
    public final static byte UPDATE_STUDENT = 24;
    public final static byte LOAD_ECF = 23;
    public final static byte ADD_NOTE = 25;
    public final static byte ADD_FORMATION = 26;
    public final static byte LOAD_NOTE_BY_STUDENT=27;
    public final static byte CHOIX_ECF_TRIE = 28;
    public final static byte UPDATE_NOTE = 29;

    private byte type;
    private Object details;
    private String dateBegin;
    private String dateEnd;
    private String schoolName;
    private String formationName;

    /*CONSTRUCTORS*/
    /**
     *
     * @param type
     * @param details
     */
    public Declencheur(byte type, Object details) {
        this.type = type;
        this.details = details;
    }

    public Declencheur(byte type, String dateBegin, String dateEnd, String schoolName, String formationName) {
        this.type = type;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.schoolName = schoolName;
        this.formationName = formationName;
    }

    /*GETTER/SETTER*/
    public String getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(String dateBegin) {
        this.dateBegin = dateBegin;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getFormationName() {
        return formationName;
    }

    public void setFormationName(String formationName) {
        this.formationName = formationName;
    }

    /**
     *
     * @return
     */
    public byte getType() {
        return type;
    }

    /**
     *
     * @return
     */
    public Object getDetails() {
        return details;
    }

}
