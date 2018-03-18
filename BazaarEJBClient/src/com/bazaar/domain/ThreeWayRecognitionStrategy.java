package com.bazaar.domain;


import java.io.Serializable;

public class ThreeWayRecognitionStrategy extends RecognitionStrategy implements Serializable {
	private static final long serialVersionUID = 1L;
	private int firstRecognitionOffset;
	private int secondRecognitionOffset;

	public ThreeWayRecognitionStrategy(int firstRecognitionOffset,
			int secondRecognitionOffset) {
		this.firstRecognitionOffset = firstRecognitionOffset;
		this.secondRecognitionOffset = secondRecognitionOffset;
	}

	void calculateRevenueRecognitions(Contract contract) {
			Money[] allocation = contract.getRevenue().allocate(3);
			contract.addRevenueRecognition(new RevenueRecognition(allocation[0],
					contract.getWhenSigned(),contract));
			contract.addRevenueRecognition(new RevenueRecognition(allocation[1],
					contract.getWhenSigned().addDays(firstRecognitionOffset),contract));
			contract.addRevenueRecognition(new RevenueRecognition(allocation[2],
					contract.getWhenSigned().addDays(secondRecognitionOffset),contract));
		
	}
}
