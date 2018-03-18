package com.bazaar.accounts;

import com.bazaar.domain.*;
import com.bazaar.domain.User;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

@Remote
@Stateless(name = "AccountManagerEJB")
public class AccountManagerBean implements AccountManagerRemote {
    public AccountManagerBean() {
    }

    public String sayHello(String name)
    {
        return getClass().getName() + " says hello to " + name + ".";
    }

    @PersistenceContext
    private EntityManager entityManager;

    public Long createUser(User user)
    {
        entityManager.persist(user);
        entityManager.flush();
        return user.getUserId();
    }

    public User findUser(long id)
    {
        return entityManager.find(User.class, id);
    }

    public Collection<User> getUsers()
    {
        Query query = entityManager.createQuery("SELECT c FROM User AS c where c.userId > 10  ");
        @SuppressWarnings("unchecked")
        List<User> users = query.getResultList();
        return users;
    }

    public long createProduct(Product product) {
        entityManager.persist(product);
        return product.getPid();
    }


    public Product findProduct(long id) {
        Product product = entityManager.find(Product.class, id);
        return product;
    }

    public int getProductSize() {
        Query query = entityManager.createQuery("SELECT p FROM Product as p");
        List<Product> results = query.getResultList();

        return results.size();
    }

    public void deleteProduct(Product product) {

        Product product1 = entityManager.merge(product);
        entityManager.merge(product1);
        entityManager.remove(product1);
        entityManager.flush();

    }
    public long createContract(Contract contract) {

        entityManager.persist(contract);
        return contract.getCid();

    }

    public Contract findContract(long id) {
        Contract contract = entityManager.find(Contract.class, id);
        return contract;
    }

    public int getContractSize() {
        Query query = entityManager.createQuery("SELECT c FROM Contract  as c");
        List<Contract> results = query.getResultList();
        return results.size();
    }

    @Override
    public void deleteContract(Contract contract) {
        Contract contract1 = entityManager.merge(contract);
        entityManager.merge(contract1);
        entityManager.remove(contract1);
        entityManager.flush();
    }

    public int getRevenueRecognitionSize() {
        Query query = entityManager.createQuery("SELECT r FROM RevenueRecognition  as r");
        List<Contract> results = query.getResultList();
        return results.size();

    }
}