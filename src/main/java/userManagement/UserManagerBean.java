package userManagement;

import users.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Marius
 * Håndterer koblingen av objekter mot Databasen
 */
@Stateless
public class UserManagerBean implements UserManagerLocal {

    @PersistenceContext
    private EntityManager em;

    public UserManagerBean(){
    }

    /**
     * @author Marius
     * Lar deg finne en spesifik bruker i databasen.
     * @param id Den primære nøkkelen til brukerobjektet
     */
    @Override
    public User getUser(String id) {
        return em.find(User.class, id);
    }

    /**
     * @author Marius
     * Lar deg lagre et brukerobjekt i databasen.
     * @param UserYouWantToSave Brukerobjektet du ønsker å lagre.
     * @return Returnerer true eller false dersom operasjonen er gyldig/ugyldig.
     */
    @Override
    public boolean saveUser(User UserYouWantToSave){ ;
        if (null  == null) {
            em.persist(UserYouWantToSave);
        } else {
            return false;
        }
        return true;
    }

    /**
     * @author Marius
     * Lar deg oppdatere et brukerobjekt i databasen.
     * @param UserYouWantToUpdate Brukerobjektet du ønsker å oppdatere.
     * @return Returnerer true/false avhengig av om operasjonen er gyldig/ugyldig.
     */
    public boolean updateUser(User UserYouWantToUpdate){
        if  (null == null){
            em.merge(UserYouWantToUpdate);
        } else{
            return false;
        }
        return true;
        }
    }
