package com.survival.utils;

import java.util.HashMap;
import java.util.Map;

public class CancellationSlab {
	
	   public static int chargeSlab(int noOfDays)
	    {
	    	if(noOfDays>=20)
	    		return 30;
	    	else if(noOfDays>=10)
	    		return 40;
	    	else if(noOfDays>=5)
	    		return 50;
	    	else if(noOfDays>=0)
	    		return 80;
	    	return 100;
	    }
}
