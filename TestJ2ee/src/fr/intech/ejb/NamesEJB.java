package fr.intech.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class NamesEJB
 */
@Stateful
@LocalBean
public class NamesEJB {

    /**
     * Default constructor. 
     */
    public NamesEJB() {
        // TODO Auto-generated constructor stub
    }
    
    public String demoMethode() {
    	return "Hello";
    }
    
    public String demoMethode2() {
    	return "Hello 2";
    }

}
