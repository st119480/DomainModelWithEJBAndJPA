package com.bazaar.domain;


import java.io.Serializable;

public class CompleteRecognitionStrategy extends RecognitionStrategy implements Serializable{
	private static final long serialVersionUID = 1L;
	void calculateRevenueRecognitions(Contract contract) {
			contract.addRevenueRecognition(new RevenueRecognition(contract.getRevenue(),
			contract.getWhenSigned(),contract));
	
	}
}