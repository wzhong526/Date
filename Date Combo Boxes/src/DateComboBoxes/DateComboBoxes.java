package DateComboBoxes;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;


public class DateComboBoxes extends JFrame {
	public static class DateComboBoxRenderer extends DefaultListCellRenderer {

        private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        public Component getListCellRendererComponent( JList list, Object value, int index, boolean isSelected, boolean cellHasFocus ) {
            Object item = value;

            if( item instanceof Date ) {
                item = dateFormat.format( ( Date ) item );
            }
            return super.getListCellRendererComponent( list, item, index, isSelected, cellHasFocus);
        }
    }

    public static void main( String[] str ) {
        JComboBox combo = new JComboBox();

        GregorianCalendar calendar = new GregorianCalendar();
        combo.addItem( calendar.getTime() );

        calendar.roll( GregorianCalendar.DAY_OF_MONTH, 1 );
        combo.addItem( calendar.getTime() );

        combo.setRenderer( new DateComboBoxRenderer() );

        JFrame frame = new JFrame( "Date Rendere Example" );

        JPanel panel = new JPanel();
        panel.add( new JLabel( "Date: ") );
        panel.add( combo );

        frame.add( panel );
        frame.pack();
        frame.setVisible( true );
    }
}
