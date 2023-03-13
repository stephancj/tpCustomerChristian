/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *The CustomerManager class is an EJB stateless session bean that manages the Customer entity.
 *It provides methods for retrieving, updating and persisting Customer objects from the database.
 * @author Stépha J. Christian
 */
package mg.itu.tpCustomerChristian.ejb; // A MODIFIER suivant le paquetage de base... 

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;
import mg.itu.tpCustomerChistian.entities.Customer;

@Stateless
public class CustomerManager {
  @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    public List<Customer> getAllCustomers() {
       Query query = em.createNamedQuery("Customer.findAll");
       return query.getResultList();
    }

    public Customer update(Customer customer) {
       return em.merge(customer);
    }

    public void persist(Customer customer) {
       em.persist(customer);
    }
}
