package com.haiberg.automation.web;

public class Locator {

	 private String position;

	    private int waitSec;

	    public enum ByType {
	    	
	        xpath, id, linkText, name, className, cssSelector, partialLinkText, tagName
	    }

	    private ByType byType;

	    public Locator() {

	    }

	    
	    public Locator(String position) {
	    	
	        this.position = position;
	        this.byType = ByType.id;
	    }
	    
	    
      public Locator(String position,ByType byType) {
	    	
	        this.position = position;
	        this.byType = byType;
	    }

	    public String getPosition() {
	        return position;
	        
	    }

	    public int getWaitSec() {
	    	
	        return waitSec;
	    }

	    public ByType getBy() {
	    	
	        return byType;
	    }

	    public void setBy(ByType byType) {
	    	
	        this.byType = byType;
	    }

	}