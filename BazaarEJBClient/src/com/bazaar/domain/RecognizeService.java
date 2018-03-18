package com.bazaar.domain;

import com.bazaar.accounts.AccountManagerRemote;

import javax.naming.Context;
import javax.naming.InitialContext;

;

public class RecognizeService extends ApplicationService{
    private  AccountManagerRemote accountManagerRemote;
    private  Context ctx;

    public  RecognizeService() throws javax.naming.NamingException {
        ctx = new InitialContext();
        accountManagerRemote = (AccountManagerRemote)
                ctx.lookup("java:global/examPrep_ear/EJB/AccountManagerEJB");
    }

    public long createProduct(Product product) {
      //  System.out.println(accountManagerRemote);
       long id= accountManagerRemote.createProduct(product);
       return id;

    }
    public  long getCountProduct()
    {
        long n = accountManagerRemote.getProductSize();
        return n;
    }
    public Product findProductById(long id)
    {
        Product product = accountManagerRemote.findProduct(id);
        return product;
    }
    public  void deleteProduct(Product product)
    {
        accountManagerRemote.deleteProduct(product);
    }

    public long createContract(Contract contract) {
       long id= accountManagerRemote.createContract(contract);
        return  id;
    }
    public  long getCountContract()
    {
        long n = accountManagerRemote.getContractSize();
        return n;
    }
    public Contract findContractById(long id)
    {
        Contract contract = accountManagerRemote.findContract(id);
        return contract;
    }
    public  void deleteContract(Contract contract)
    {
        accountManagerRemote.deleteContract(contract);
    }
    public void calculateRevenueRecognition(Contract contract) {
          contract.calculateRecognitions();
    }
    public long getCountRevenueRecognition()
    {
        long n=accountManagerRemote.getRevenueRecognitionSize();
        return n;
    }
    public void RecognizedRevenue(Contract contract) {
        contract.calculateRecognitions();
    }
    public void publishRevenueRecognitionCalculation(Contract contract)
    {
        IntegrationGateWayImp in=new IntegrationGateWayImp();
        in.publishRevenueRecognitionCalculation(contract);
    }
    public void  sendEmailMessage(String toAddress, String subject, String body)
    {
        EmailGatewayImp emailGatewayImp=new EmailGatewayImp();
        emailGatewayImp.sendEmailMessage(toAddress,subject,body);
    }
}