package com.practise.patterns.behavioral.cor;

import lombok.Builder;

@Builder
public class DirectorSupport implements ISupportService {

	private ISupportService next;
	private ServiceRequest request;

	@Override
	public void handleRequest() throws Exception {
		if (ServiceLevel.LEVEL_FOUR.equals(request.getType())) {
			request.setConclusion("Level 4 request has been resolved by Director !!");
		} else {
			if (next != null) {
				next.handleRequest();
			} else {
				throw new IllegalArgumentException("Your problem is none of our business :: " + request.getType());
			}
		}
	}
}
