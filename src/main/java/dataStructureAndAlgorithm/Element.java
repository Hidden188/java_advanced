package dataStructureAndAlgorithm;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Element extends JComponent {
    private static final long serialVersionUID = 1L;
    private JPanel j;
    boolean flag = false;

    public Element() {
        this.j = new JPanel();
    }

    public JPanel getJ() {
        return j;
    }

    public void setJ(JPanel j) {
        this.j = j;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
