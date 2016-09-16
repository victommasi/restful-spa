package com.victommasi.model;

import com.fasterxml.jackson.annotation.JsonFormat;

//@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Status {
	
	RECUSADO(0, "Refused"),
	ACEITO(1, "Accepted"),
	NEGOCIANDO(2, "Negociating");
	
	private Integer id;
	private String desc;
	
	Status(Integer id, String desc){
		this.id = id;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
	
	public Integer getId() {
		return id;
	}
}
