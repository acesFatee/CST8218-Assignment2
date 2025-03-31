/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cst8218.assignment2.soha0021_bhan0075.business;

import cst8218.assignment2.soha0021_bhan0075.business.exceptions.NonexistentEntityException;
import cst8218.assignment2.soha0021_bhan0075.business.exceptions.RollbackFailureException;
import cst8218.assignment2.soha0021_bhan0075.entity.Appuser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.io.Serializable;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.UserTransaction;
import java.util.List;

/**
 * Controller class to handle CRUD operations for Appuser entity.
 */
public class AppuserJpaController implements Serializable {

    // Instance variables for managing transactions and creating EntityManager
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    // Constructor to initialize the transaction and EntityManagerFactory
    public AppuserJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }

    // Method to get the EntityManager for performing database operations
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Creates a new Appuser entity in the database.
     * @param appuser The Appuser entity to be created.
     * @throws RollbackFailureException If transaction fails during commit.
     * @throws Exception If there are any other errors.
     */
    public void create(Appuser appuser) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();  // Start transaction
            em = getEntityManager();
            em.persist(appuser);  // Save Appuser entity to database
            utx.commit();  // Commit transaction
        } catch (Exception ex) {
            // Rollback in case of error
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;  // Rethrow the exception to indicate failure
        } finally {
            if (em != null) {
                em.close();  // Close EntityManager to free resources
            }
        }
    }

    /**
     * Updates an existing Appuser entity in the database.
     * @param appuser The Appuser entity to be updated.
     * @throws NonexistentEntityException If the Appuser entity does not exist.
     * @throws RollbackFailureException If transaction fails during commit.
     * @throws Exception If there are any other errors.
     */
    public void edit(Appuser appuser) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();  // Start transaction
            em = getEntityManager();
            appuser = em.merge(appuser);  // Merge changes to Appuser entity
            utx.commit();  // Commit transaction
        } catch (Exception ex) {
            try {
                utx.rollback();  // Rollback if there’s an error
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = appuser.getId();
                if (findAppuser(id) == null) {
                    throw new NonexistentEntityException("The appuser with id " + id + " no longer exists.");
                }
            }
            throw ex;  // Rethrow the exception to indicate failure
        } finally {
            if (em != null) {
                em.close();  // Close EntityManager to free resources
            }
        }
    }

    /**
     * Deletes an Appuser entity from the database.
     * @param id The ID of the Appuser entity to be deleted.
     * @throws NonexistentEntityException If the Appuser entity does not exist.
     * @throws RollbackFailureException If transaction fails during commit.
     * @throws Exception If there are any other errors.
     */
    public void destroy(Long id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();  // Start transaction
            em = getEntityManager();
            Appuser appuser;
            try {
                // Fetch the Appuser entity by ID
                appuser = em.getReference(Appuser.class, id);
                appuser.getId();  // Ensure the entity exists
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The appuser with id " + id + " no longer exists.", enfe);
            }
            em.remove(appuser);  // Remove the Appuser entity
            utx.commit();  // Commit transaction
        } catch (Exception ex) {
            try {
                utx.rollback();  // Rollback if there’s an error
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;  // Rethrow the exception to indicate failure
        } finally {
            if (em != null) {
                em.close();  // Close EntityManager to free resources
            }
        }
    }

    /**
     * Retrieves all Appuser entities from the database.
     * @return List of all Appuser entities.
     */
    public List<Appuser> findAppuserEntities() {
        return findAppuserEntities(true, -1, -1);  // Retrieve all Appuser entities
    }

    /**
     * Retrieves a paginated list of Appuser entities.
     * @param maxResults Maximum number of results to retrieve.
     * @param firstResult The first result to retrieve.
     * @return List of Appuser entities.
     */
    public List<Appuser> findAppuserEntities(int maxResults, int firstResult) {
        return findAppuserEntities(false, maxResults, firstResult);  // Retrieve paginated results
    }

    /**
     * Retrieves Appuser entities based on pagination settings.
     * @param all Whether to retrieve all entities or not.
     * @param maxResults Maximum number of results to retrieve.
     * @param firstResult The first result to retrieve.
     * @return List of Appuser entities.
     */
    private List<Appuser> findAppuserEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            // Create a CriteriaQuery to fetch Appuser entities
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Appuser.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);  // Set the maximum results
                q.setFirstResult(firstResult);  // Set the first result for pagination
            }
            return q.getResultList();  // Execute and return the result list
        } finally {
            em.close();  // Close EntityManager to free resources
        }
    }

    /**
     * Finds an Appuser entity by its ID.
     * @param id The ID of the Appuser entity.
     * @return The Appuser entity, or null if not found.
     */
    public Appuser findAppuser(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Appuser.class, id);  // Find Appuser by ID
        } finally {
            em.close();  // Close EntityManager to free resources
        }
    }

    /**
     * Retrieves the total count of Appuser entities.
     * @return The count of Appuser entities.
     */
    public int getAppuserCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Appuser> rt = cq.from(Appuser.class);
            cq.select(em.getCriteriaBuilder().count(rt));  // Count the number of Appuser entities
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();  // Return the count as an integer
        } finally {
            em.close();  // Close EntityManager to free resources
        }
    }
}
