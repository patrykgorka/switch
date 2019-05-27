package com.pgorka.typeswitch;

public class Result <R> {

	private Boolean match;
	
	private R object;
	
	private Boolean matchedBefore = false;
	
	public Result(Boolean match, R object,Boolean matchedBefore) {
		this.match = match;
		this.object = object;
		this.matchedBefore = matchedBefore;
	}
	
	public Boolean matches() {
		return match;
	}
	
	public R getObject() {
		return object;
	}
	
	public Boolean matchedBefore() {
		return matchedBefore;
	}
}
