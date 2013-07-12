package fr.intech.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class SingletonEJB
 */
@Singleton
@LocalBean
public class SingletonEJB {

    private int mHit;
    
    @PostConstruct
    private void Init() {
    	mHit = 42;
    }
    
    @Lock(LockType.WRITE)
    public void hit() {
    	mHit++;
    }
    
    @Lock(LockType.READ)
    public int getHits() {
    	return mHit;
    }

}
