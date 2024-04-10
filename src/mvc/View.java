package mvc;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class View extends JPanel implements Subscriber {
    protected Model model;

    public View(Model model){
        this.model = model;
        model.subscribe(this);
        Border blackLine = BorderFactory.createLineBorder(Color.black);
        setBorder(blackLine);
        setBackground(Color.LIGHT_GRAY);
    }

    public void setModel(Model newModel){
        this.model.unsubscribe(this);
        this.model = newModel;
        this.model.subscribe(this);
//        repaint();
    }

    public void update(){
        repaint();
    }


}
