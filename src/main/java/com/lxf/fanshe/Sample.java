package com.lxf.fanshe;

public class Sample {

	@SuppressWarnings("unused")
	private Sample instance;

	public void setSample(Object instance) {
		System.out.println("����Sample��setSample������");
		this.instance = (Sample)instance;
	}

}
