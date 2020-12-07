package com.practise.patterns.behavioral.cor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceRequest {
	private ServiceLevel type;
	private String conclusion;
	private ISupportService supportService;
	
	public ServiceRequest() {
		this.supportService = FrontDeskSupport.builder().request(this)					// Level 1
				.next(SupervisorSupport.builder().request(this)							// Level 2
						.next(ManagerSupport.builder().request(this)					// Level 3
								.next(DirectorSupport.builder().request(this).build())	// Level 4
								.build())
						.build())
				.build();
	}
}
