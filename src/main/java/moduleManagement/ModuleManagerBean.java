package moduleManagement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * EJB som med metoder som behandler modulobjekter
 */

@Stateless
public class ModuleManagerBean implements ModuleManagerLocal {

    @PersistenceContext
    private EntityManager em;

    public ModuleManagerBean() {

    }

    @Override
    public Module getModule(int id) {
        return em.find(Module.class, id);
    }


    /**
     * @param module
     * @return boolean
     */
    @Override
    public boolean saveModule(Module module) {
        Module existing = getModule(module.getModuleID());
        if (existing == null) {
            em.persist(module);
        } else {
            return false;
        }
        return true;
    }

    public boolean updateModule(Module module) {
        Module existing = getModule(module.getModuleID());
        if (existing != null) {
            em.remove(existing);
            em.persist(module);
            em.flush();

        } else {
            return false;
        }
        return true;
    }
}

