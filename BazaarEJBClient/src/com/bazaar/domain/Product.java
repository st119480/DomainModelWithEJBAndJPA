package com.bazaar.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "PRODUCTS")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long pid;
	private String name;
	@Transient
	private RecognitionStrategy recognitionStrategy;

	@OneToMany (cascade ={ CascadeType.ALL },fetch=FetchType.EAGER)
	private static List<Contract> contractList = new ArrayList<Contract>();

	public Product() {
		super();
	}
	public void addContract(Contract contract) {

		contractList.add(contract);
	}

	public Product(String name, RecognitionStrategy recognitionStrategy) {
		this.name=name;
		this.recognitionStrategy=recognitionStrategy;
	}

//	public Product(String name) {
//		this.name = name;
//	}

	public long getPid() {
		return pid;
	}

	public void setPid(long id) {
		this.pid = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public static List<Contract> getContractList() {
		return contractList;
	}

	public static Product newWordProcessor(String name)  {
		CompleteRecognitionStrategy n=new CompleteRecognitionStrategy();
		Product product = new Product(name, n);
		return product;
	}

	public static Product newSpreadsheet(String name) {
		Product product = new Product(name, new ThreeWayRecognitionStrategy(60, 90));
		return product;
	}

	public static Product newDatabase(String name)  {
		Product product = new Product(name, new ThreeWayRecognitionStrategy(30, 60));
		return product;
	}

	public RecognitionStrategy getRecognitionStrategy() {
		return recognitionStrategy;
	}

	public void setRecognitionStrategy(RecognitionStrategy recognitionStrategy) {
		this.recognitionStrategy = recognitionStrategy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void calculateRevenueRecognitions(Contract contract) {

		recognitionStrategy.calculateRevenueRecognitions(contract);
	}

}