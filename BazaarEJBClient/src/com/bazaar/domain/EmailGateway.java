package com.bazaar.domain;

public interface EmailGateway {
	void sendEmailMessage(String toAddress, String subject, String body);

}
