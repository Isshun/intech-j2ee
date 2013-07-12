package fr.intech.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class VolumeEJB
 */
@Stateless
@LocalBean
public class VolumeEJB {

    /**
     * Default constructor. 
     */
    public VolumeEJB() {
        // TODO Auto-generated constructor stub
    }
    
    public double fromSphere(double r) {
    	return (4 * Math.PI * Math.pow(r, 3)) / 3;
    }
    
}
