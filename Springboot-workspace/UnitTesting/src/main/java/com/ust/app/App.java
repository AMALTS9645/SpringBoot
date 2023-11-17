package com.ust.app;

public class App {
	AppService service;

	public boolean check(int n) {
		return service.check(n);
	}
	
	public int getLength(String str) {
		return service.getLength(str);
	}

	public AppService getService() {
		return service;
	}

	public void setService(AppService service) {
		this.service = service;
	}

}
