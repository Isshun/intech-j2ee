/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.intech.jsf;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author thomasgros
 */
//@ManagedBean(name="hello")
@Named("hello")
@Dependent
public class Hello {

    final String world = "Hello World!";
    
    public String getWorld() {
        return world;
    }
}
