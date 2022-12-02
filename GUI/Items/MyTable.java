package GUI.Items;

import javax.swing.JTable;
import javax.swing.plaf.FontUIResource;

public class MyTable extends JTable {

    public MyTable(int Font ){
        getTableHeader().setReorderingAllowed(false);
        setRowHeight(28);
        switch (Font) {
            case 0:
                getTableHeader().setFont(new FontUIResource("Times New Roman", FontUIResource.PLAIN, 14));
                setFont(new FontUIResource("Times New Roman", FontUIResource.PLAIN, 14));
                break;
            
            case 1:
                getTableHeader().setFont(new FontUIResource("Times New Roman", FontUIResource.BOLD, 14));
                setFont(new FontUIResource("Times New Roman", FontUIResource.BOLD, 14));
                break;
            case 2:
                getTableHeader().setFont(new FontUIResource("Times New Roman", FontUIResource.ITALIC, 14));
                setFont(new FontUIResource("Times New Roman", FontUIResource.ITALIC, 14));
                break;
            default:
                getTableHeader().setFont(new FontUIResource("Times New Roman", FontUIResource.ITALIC | FontUIResource.BOLD, 14));
                setFont(new FontUIResource("Times New Roman", FontUIResource.ITALIC | FontUIResource.BOLD, 14));
                break;
        }

    }

    @Override
    public boolean editCellAt(int row, int column) {
        return false;
    };

    @Override
    public boolean editCellAt(int row, int column, java.util.EventObject e) {
        return false;
    };

    
}
