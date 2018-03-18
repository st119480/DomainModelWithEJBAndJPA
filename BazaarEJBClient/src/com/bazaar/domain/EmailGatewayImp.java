package com.bazaar.domain;

import java.io.Serializable;

public class EmailGatewayImp implements EmailGateway,Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void sendEmailMessage(String toAddress, String subject, String body) {
		System.out.println("\n");
		System.out.println("sendEmailMessage:\n");
		System.out.println("To Address::" + toAddress + "\n Subject" + subject + "\n Body" + body);

	}

}
