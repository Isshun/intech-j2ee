/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.intech.jsf;

import javax.inject.Named;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author thomasgros
 */
@Named(value = "linkBackingBean")
@RequestScoped
public class LinkBackingBean implements Serializable {

    private int id;

    /**
     * Creates a new instance of LinkBackingBean
     */
    public LinkBackingBean() {
    }

    /*
     * public void initId(javax.faces.event.ComponentSystemEvent cse) {
     * cse.getComponent().get }
     */
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
