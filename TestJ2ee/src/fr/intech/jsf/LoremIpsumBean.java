/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.intech.jsf;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author thomasgros
 */
@Named(value = "loremIpsumBean")
@RequestScoped
public class LoremIpsumBean {
    private List<String> lipsum;
    private int numParagraphs;
    private int currentRow;

    public LoremIpsumBean() {
        this.lipsum = new ArrayList<String>();
        lipsum.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce egestas, velit vel tincidunt aliquam, purus magna auctor nisi, sed sagittis erat neque pretium eros. Vivamus consequat sem quis lectus luctus egestas. Suspendisse porttitor viverra diam in facilisis. Quisque dolor dui, mollis vel mattis vel, consequat vitae dolor. Nullam sollicitudin commodo ante in dapibus. Nullam viverra rhoncus interdum. Mauris lectus ligula, lacinia eu venenatis non, gravida elementum ipsum. Quisque turpis arcu, cursus et tempus eget, ultricies ut massa. In quis felis vitae urna iaculis convallis in et odio. Nullam tempus tincidunt dapibus. Quisque cursus, magna ac tincidunt dignissim, nulla enim facilisis orci, nec bibendum augue dolor quis dui.");
        lipsum.add("Donec tincidunt lorem sit amet nisl auctor ac semper nibh sollicitudin. Quisque non diam nec neque sagittis porta vitae a nisi. Curabitur tincidunt tincidunt orci, vitae pellentesque urna pharetra eget. In hac habitasse platea dictumst. Vestibulum neque nibh, bibendum nec auctor nec, cursus eget dolor. In ac urna vel lorem tristique scelerisque. Sed malesuada pellentesque magna. Maecenas pulvinar ultricies hendrerit. Ut hendrerit, sapien eu rhoncus porttitor, mi arcu malesuada nibh, sed euismod ipsum ipsum at ligula. Vivamus ultricies, eros eu consectetur elementum, est nibh semper eros, vel rutrum sem enim laoreet magna. Praesent venenatis urna sed ipsum vehicula tincidunt. Nullam id sapien orci. Aenean in luctus magna. Sed blandit suscipit ipsum, quis ullamcorper quam tincidunt in.");
        lipsum.add("Pellentesque nibh libero, venenatis sit amet feugiat nec, accumsan vel enim. Nunc dignissim diam et felis consequat eu scelerisque metus auctor. Pellentesque venenatis gravida sapien non mollis. Duis odio nunc, ornare vitae feugiat at, iaculis sed ligula. Donec eu arcu sed eros tempus lacinia. Sed porttitor, lectus vitae sodales volutpat, sem ante fringilla lorem, et hendrerit diam eros id elit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Curabitur non scelerisque elit. Aliquam scelerisque quam non nisl adipiscing ultrices. Aenean non tempor sapien. Cras vulputate placerat nisi, quis auctor turpis vehicula in. Phasellus pharetra nisl vel nulla congue blandit. Cras convallis auctor adipiscing. Aenean id risus sed libero molestie ultricies. Donec sagittis, libero sed pulvinar euismod, massa purus pretium velit, sit amet accumsan sem nisl id nulla. Suspendisse pharetra libero ut orci ullamcorper quis gravida leo tincidunt.");
        lipsum.add("Sed sed blandit nunc. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ornare condimentum arcu a cursus. Sed sodales, mi in tincidunt pulvinar, tellus magna rhoncus sem, et sollicitudin ligula elit et quam. Nunc pretium nibh nec odio commodo id aliquet ligula ornare. Nullam ac felis ut neque fringilla malesuada non eu diam. Suspendisse sollicitudin pretium nunc, in tincidunt sem consequat nec.");
        lipsum.add("Nulla mauris justo, tempor ut rutrum eu, iaculis eget risus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce vel mi a lectus consequat iaculis. Aliquam tristique leo vitae orci aliquet fringilla. Nunc orci urna, tincidunt nec porta at, ultricies eu augue. Aenean vel magna a tellus commodo pulvinar. Vestibulum dapibus felis vitae neque ornare eu blandit erat volutpat. Aliquam sed tortor ante, eget facilisis libero. Aliquam a tellus a erat dictum scelerisque sit amet quis risus.");
    }
    
    public int getNumParagraphs() {
        return numParagraphs;
    }

    public void setNumParagraphs(int num) {
        this.numParagraphs = num;
    }
    
    public List<String> getParagraphs() {
        currentRow = 0;
         List<String> res = new ArrayList<String>();
        int i = 0;
        for(String s:lipsum) {
            if (i >= numParagraphs) break;
            res.add(s);
            i++;
        }
        
        return res;       
    }
    
    public int nextRowIndex() {
        return ++currentRow;
    }
}
