package SVGIcon;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import javax.swing.JLabel;

public class svgIcon extends JLabel {

    private FlatSVGIcon svgIcon;
    private FlatSVGIcon userIcon;
    private FlatSVGIcon contactIcon;

    public void setSVGIcon(String Icon, int width, int height) {
        svgIcon = new FlatSVGIcon(Icon, width, height);
        setIcon(svgIcon);
    }

    public void setUserIcon(String Icon, int width, int height) {
        userIcon = new FlatSVGIcon(Icon, width, height);
        setIcon(userIcon);
    }

    public void setContactIcon(String Icon, int width, int height) {
        contactIcon = new FlatSVGIcon(Icon, width, height);
        setIcon(contactIcon);
    }

    public void setCursorHand() {
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }
}
