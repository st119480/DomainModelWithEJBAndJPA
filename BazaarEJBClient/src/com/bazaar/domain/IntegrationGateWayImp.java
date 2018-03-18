package com.bazaar.domain;

import java.io.Serializable;
import java.util.List;

public class IntegrationGateWayImp implements IntegrationGateway,Serializable {
	private static final long serialVersionUID = 1L;
	@Override
	public void publishRevenueRecognitionCalculation(Contract contract) {
		List<RevenueRecognition> lists = contract.getRevenueRecognitionList();
		System.out.println("\n");
		System.out.println("Revenue Recognition Calculation:\n");
		for (RevenueRecognition rr : lists)

			//System.out.println(contract.getProduct().getName() + "," + rr.getAmount().amount() + "," + rr.getDate());
			System.out.println(contract.getProduct().getName() + "\tAllocation : " + rr.getAmount().amount() +
					"\t\tDate Signed: " + rr.getDate());
	}

}
