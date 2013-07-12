package org.intech.ejb;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class StatsEJB
 */
@Singleton
@LocalBean
public class StatsEJB {

    private Map<Integer, Integer> mData;
    
    @PostConstruct
    public void Init() {
    	mData = new HashMap<Integer, Integer>();
    }

	public void add(int id) {
		mData.put(id, mData.containsKey(id) ? mData.get(id) + 1 : 1);
	}
	
	public Map<Integer, Integer> getAll() {
		return mData;
	}

}
