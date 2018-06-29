package v;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ColorTableRow {

	public static JTable getNewRenderedTable(JTable table) {
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table,
                    Object value, boolean isSelected, boolean hasFocus, int row, int col) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
                String status = (String)table.getModel().getValueAt(row,9);
                if ("Yes".equals(status)) {
                    setBackground(Color.GREEN);
                    setForeground(Color.black);
                } else {
                    setBackground(Color.YELLOW);
                    setForeground(table.getForeground());
                }       
                return this;
            }   
        });
        return table;
    }
	public static JTable getNewerRenderedTable(JTable table) {
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table,
                    Object value, boolean isSelected, boolean hasFocus, int row, int col) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
                String status = (String)table.getModel().getValueAt(row,3);
                if ("No".equals(status)) {
                    setBackground(Color.RED);
                    setForeground(Color.black);
                } else {
                    setBackground(Color.green);
                    setForeground(Color.black);
                }       
                return this;
            }   
        });
        return table;
    }

}
