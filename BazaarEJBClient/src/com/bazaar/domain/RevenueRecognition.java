package com.bazaar.domain;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "RevenueRecognition")
public class RevenueRecognition implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int rid;
	@ManyToOne(cascade = CascadeType.ALL)
	private Contract contract;
	@OneToOne(cascade ={ CascadeType.ALL})
	private Money amount;
	@OneToOne(cascade ={ CascadeType.ALL})
	private MfDate date;


	public RevenueRecognition(Money amount, MfDate date, Contract contract) {
		this.contract = contract;
		this.amount = amount;
		this.date = date;
	}
	public RevenueRecognition() {
		super();
	}
	public int getRid()
	{
		return rid;
	}
	public void setRid(int id)
	{
		this.rid = id;
	}
	public Money getAmount()
	{
		return amount;
	}
	public void setAmount(Money amount)
	{
		this.amount = amount;
	}
	public MfDate getDate()
	{
		return date;
	}
	public void setDate(MfDate date)
	{
		this.date = date;
	}
	public Contract getContract()
	{
		return contract;
	}
	public void setContract(Contract contract)
	{
		this.contract = contract;
	}
	boolean isRecognizableBy(MfDate asOf)  {
		return asOf.after(date) || asOf.equals(date);
	}
}
