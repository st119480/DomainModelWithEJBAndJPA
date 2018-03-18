package com.bazaar.accounts;

import com.bazaar.domain.*;
import com.bazaar.domain.User;

import java.util.Collection;

public interface AccountManagerRemote {
    public String sayHello(String name);
    public Long createUser(User user);
    public User findUser(long id);
    public Collection<User> getUsers();

    public long createProduct(Product product);
    public int getProductSize();
    public Product findProduct(long id);
    public void deleteProduct(Product product);
    public long createContract(Contract contract);
    public Contract findContract(long id);
    public int getContractSize();
    public void deleteContract(Contract contract);
    public int getRevenueRecognitionSize();

}
