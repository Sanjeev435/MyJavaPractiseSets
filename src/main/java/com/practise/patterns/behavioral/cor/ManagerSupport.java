package com.practise.patterns.behavioral.cor;

import lombok.Builder;


@Builder
public class ManagerSupport implements ISupportService {

	private ISupportService next;
	private ServiceRequest request;
	
	@Override
	public void handleRequest() throws Exception {
		if (ServiceLevel.LEVEL_THREE.equals(request.getType())) {
			request.setConclusion("Level 3 reuqest has been resoved by Manager !!");
		} else {
			if (next != null) {
				next.handleRequest();
			} else {
				throw new IllegalArgumentException("No handler found for :: " + request.getType());
			}
		}
	}
}
