/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.intech.jsf;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author thomasgros
 */
@Named
@RequestScoped
public class RandomSignin {

    private double percent;
    private List<SelectItem> titles;
    private String title;

    /**
     * Creates a new instance of RandomSignin
     */
    public RandomSignin() {
        percent = 0.5;
        titles = new ArrayList<SelectItem>();
        titles.add(new SelectItem("Mr."));
        titles.add(new SelectItem("Mrs."));
        titles.add(new SelectItem("Ms."));
    }

    public String signup() {
        if (Math.random() < percent) {
            return ("accepted");
        } else {
            return ("rejected");
        }
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public List<SelectItem> getTitles() {
        return titles;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
