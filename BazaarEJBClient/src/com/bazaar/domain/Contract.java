package com.bazaar.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
@Table(name = "CONTRACTS")
public class Contract implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long cid;

    @ManyToOne (cascade ={ CascadeType.ALL })
    private Product product;

    @OneToOne(cascade ={ CascadeType.PERSIST})
    private Money revenue;
    @OneToOne(cascade ={ CascadeType.PERSIST})
    private MfDate whenSigned;

    @OneToMany(cascade = CascadeType.ALL)
    private List<RevenueRecognition> revenueRecognitions = new ArrayList<RevenueRecognition>();

    public Contract(Product product, Money revenue, MfDate whenSigned) {
        this.product = product;
        this.revenue = revenue;
        this.whenSigned = whenSigned;
    }
    public  static Contract create(Product product, Money revenue, MfDate whenSigned)
    {
        Contract contract=new Contract(product,revenue,whenSigned);
        return contract;
    }

    public Contract() {
        super();
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long id) {
        this.cid = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Money getRevenue() {
        return revenue;
    }

    public void setRevenue(Money revenue) {
        this.revenue = revenue;
    }

    public MfDate getWhenSigned() {
        return whenSigned;
    }

    public void setWhenSigned(MfDate whenSigned) {
        this.whenSigned = whenSigned;
    }

    public List<RevenueRecognition> getRevenueRecognitions() {
        return revenueRecognitions;
    }

    public void setRevenueRecognitions(List<RevenueRecognition> revenueRecognitions) {
        this.revenueRecognitions = revenueRecognitions;
    }


    public Money RecognizedRevenue(MfDate asOf) {
        Money result = Money.dollars(0);
        Iterator<RevenueRecognition> it = revenueRecognitions.iterator();
        while (it.hasNext()) {
            RevenueRecognition r = (RevenueRecognition) it.next();
            if (r.isRecognizableBy(asOf))
                result = result.add(r.getAmount());
        }
        return result;
    }

    public void calculateRecognitions() {
        product.calculateRevenueRecognitions(this);
    }

    public void addRevenueRecognition(RevenueRecognition revenueRecognition) {

        revenueRecognitions.add(revenueRecognition);
        // System.out.println(revenueRecognitions.size());
    }

    public List<RevenueRecognition> getRevenueRecognitionList() {
        return revenueRecognitions;
    }
}