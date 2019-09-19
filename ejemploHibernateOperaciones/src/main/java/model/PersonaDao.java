
package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

public class PersonaDao {
   
    protected EntityManager em;
    private EntityManagerFactory emf;
    
    public PersonaDao(){
        //usamos la persistencia unit
        emf = Persistence.createEntityManagerFactory("miBD");
    }
    
    public void listar(){
        //consukta a ejecutar
        // no se necesita crear una nueva transaccion
        String hql = "SELECT p FROM Persona p";
        em = getEntityManager();
        Query q = em.createQuery(hql);
        List<Persona> list = q.getResultList();
        for(Persona p : list){
            JOptionPane.showMessageDialog(null, p.toString());
        }
    }
    
    public  Persona buscarPorId(Persona p){
        em = getEntityManager();
        return em.find(Persona.class, p.getIdPersona());
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void insertar(Persona persona){
        try {
            em = getEntityManager();
        //se inicia una transaccion
        em.getTransaction().begin();
        //se inserta la nueva persona
        em.persist(persona);
        //terminamos la transaccion
        em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar la persona "+ e.getMessage());
        }finally{
            if (em != null) {
                em.close();
            }
        }
        
    }
    
    public void actualizar(Persona persona){
        try {
            em = getEntityManager();
        //se inicia una transaccion
        em.getTransaction().begin();
        //se inserta la nueva persona
        em.merge(persona);
        //terminamos la transaccion
        em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la persona "+ e.getMessage());
            
        }finally{
            if (em != null) {
                em.close();
            }
        }
        
    }
    
    public void eliminar(Persona persona){
        try {
            em = getEntityManager();
        //se inicia una transaccion
        em.getTransaction().begin();
        //se inserta la nueva persona
        em.remove(em.merge(persona));
        //terminamos la transaccion
        em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la persona "+ e.getMessage());
       
        }finally{
            if (em != null) {
                em.close();
            }
        }
        
    }
}
