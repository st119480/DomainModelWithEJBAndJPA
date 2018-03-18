package com.bazaar.test;

import com.bazaar.domain.*;
import org.junit.jupiter.api.Test;

import javax.naming.Context;
import javax.naming.NamingException;

import static org.junit.jupiter.api.Assertions.*;


public class ClientTest {

    private static Context ctx;
    private  RecognizeService recognizeService= new RecognizeService();
    public ClientTest() throws NamingException {
    }
    @Test
    public void testCreateProduct() throws Exception {
        Product product = Product.newWordProcessor("abc");
        long n = recognizeService.getCountProduct();
        recognizeService.createProduct(product);
        long n2 = recognizeService.getCountProduct();
        assertEquals(n+1, n2);
    }
    @Test
    public void testDeleteProduct() throws Exception {
        Product product = Product.newWordProcessor("abc");
        long n= recognizeService.getCountProduct();
        long id=recognizeService.createProduct(product);
        Product product1 = recognizeService.findProductById(id);
        recognizeService.deleteProduct(product1);
        long n2 = recognizeService.getCountProduct();
        assertEquals(n, n2);
    }
    @Test
    public void testCreateContract() throws Exception {
        Product product = Product.newDatabase("AAA");
        long n1 = recognizeService.getCountContract();
        Contract contact = new Contract(product, Money.dollars(500.00),new MfDate(2018, 3, 16));
        recognizeService.createContract(contact);
        long n2  = recognizeService.getCountContract();
        assertEquals(n1, n2-1);

    }
    @Test
    public void testDeleteContract() {
        Product product = Product.newDatabase("WORD");
        long n1 = recognizeService.getCountContract();
        Contract contact = new Contract(product, Money.dollars(500.00),new MfDate(2018, 3, 16));
        long id=recognizeService.createContract(contact);
        //System.out.println("1:"+cnt1);
        Contract contract1=recognizeService.findContractById(id);
        recognizeService.deleteContract(contract1);
        long n2 = recognizeService.getCountContract();
        // System.out.println("2:"+cnt2);
        assertEquals(n1, n2 );
    }
    @Test
    public void testCaculateRevenueRecognition() {
        Product product = Product.newDatabase("WORD");
        Contract contact = new Contract(product, Money.dollars(500.00),new MfDate(2018, 3, 16));
        long cnt1 = recognizeService.getCountRevenueRecognition();
        recognizeService.calculateRevenueRecognition(contact);
        long id=recognizeService.createContract(contact);
        long cnt2 = recognizeService.getCountRevenueRecognition();
        assertNotSame(cnt1, cnt2);
    }

    @Test
    public void testRecognizedRevenue() {
         Product product = Product.newDatabase("WORD");
         Contract contract = new Contract(product, Money.dollars(500.00),new MfDate(2018, 3, 16));
         recognizeService.calculateRevenueRecognition(contract);
         recognizeService.createContract(contract);
         Money money = contract.RecognizedRevenue(new MfDate(2018, 8, 16));
        //System.out.println(money.amount());
        assertNotNull(money);
    }
    @Test
    public void testpublishRevenueRecognitionCalculation() {
        Product product = Product.newDatabase("WORD");
        Contract contact = new Contract(product, Money.dollars(500.00),new MfDate(2018, 3, 16));
        recognizeService.calculateRevenueRecognition(contact);
        recognizeService.createContract(contact);
        recognizeService.publishRevenueRecognitionCalculation(contact);
        String name=contact.getProduct().getName();
        assertSame("WORD", name);
    }
    @Test
    public void testgetEmailGateway() {
        recognizeService.sendEmailMessage("test","contract", "hello");
    }
}