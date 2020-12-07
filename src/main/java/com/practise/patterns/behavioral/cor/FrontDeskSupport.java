package com.practise.patterns.behavioral.cor;

import lombok.Builder;


@Builder
public class FrontDeskSupport implements ISupportService {

	private ISupportService next;
	private ServiceRequest request;

	@Override
	public void handleRequest() throws Exception {
		if (ServiceLevel.LEVEL_ONE.equals(request.getType())) {
			request.setConclusion("Level 1 request has been resolved by Front desk !!");
		} else {
			if (next != null) {
				next.handleRequest();
			} else {
				throw new IllegalArgumentException("No handler found for :: " + request.getType());
			}
		}
	}
}
