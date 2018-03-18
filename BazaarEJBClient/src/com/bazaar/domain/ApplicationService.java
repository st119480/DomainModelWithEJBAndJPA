package com.bazaar.domain;

import java.io.Serializable;

public class ApplicationService  implements Serializable  {
	private static final long serialVersionUID = 1L;
	protected EmailGateway getEmailGateway() {
	  EmailGateway implement=new EmailGatewayImp();
	  return implement;
		}
	protected IntegrationGateway getIntegrationGateway(){
		IntegrationGateway implement = new IntegrationGateWayImp();
				return implement;
	}

}
