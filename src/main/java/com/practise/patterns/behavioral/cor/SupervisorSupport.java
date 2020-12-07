package com.practise.patterns.behavioral.cor;

import lombok.Builder;


@Builder
public class SupervisorSupport implements ISupportService {

	private ISupportService next;
	private ServiceRequest request;

	@Override
	public void handleRequest() throws Exception {
		if (ServiceLevel.LEVEL_TWO.equals(request.getType())) {
			request.setConclusion("Level 2 request has been resolved by Supervisor !!");
		} else {
			if (next != null) {
				next.handleRequest();
			} else {
				throw new IllegalArgumentException("No handler found for :: " + request.getType());
			}
		}
	}
}