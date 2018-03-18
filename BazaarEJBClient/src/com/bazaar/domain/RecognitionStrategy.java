package com.bazaar.domain;

import java.io.Serializable;

public abstract class RecognitionStrategy implements Serializable {

	private static final long serialVersionUID = 1L;
	abstract void calculateRevenueRecognitions(Contract contract);

	
}