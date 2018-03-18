package com.bazaar.domain;

import java.io.Serializable;

public interface IntegrationGateway extends Serializable {
	static final long serialVersionUID = 1L;
	void publishRevenueRecognitionCalculation(Contract contract);

}
