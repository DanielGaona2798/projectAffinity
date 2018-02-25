package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import constants.ConstantsUI;
import models.entities.Person;

public class PanelTableMan extends JPanel{
	private static final long serialVersionUID = 1L;
	private DefaultTableModel model;
	private JTable tableMan;
	private JScrollPane scroll;

	public PanelTableMan() {
		setLayout(new BorderLayout());

		model = new DefaultTableModel();
		model.setColumnIdentifiers(ConstantsUI.HEADERS);

		tableMan = new JTable(model);
		tableMan.setRowHeight(25);
		tableMan.setFont(new Font("Arial", Font.BOLD, 15));
		tableMan.getColumn(ConstantsUI.HEADERS[3]).setCellRenderer(new TableCellRenderer() {
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				return (JCheckBox) value;
			}

		});
		tableMan.getColumn(ConstantsUI.HEADERS[3]).setCellEditor(new TableCellEditor() {

			@Override
			public boolean stopCellEditing() {
				return true;
			}

			@Override
			public boolean shouldSelectCell(EventObject arg0) {
				return false;
			}

			@Override
			public void removeCellEditorListener(CellEditorListener arg0) {

			}

			@Override
			public boolean isCellEditable(EventObject arg0) {
				return true;
			}

			@Override
			public Object getCellEditorValue() {
				return null;
			}

			@Override
			public void cancelCellEditing() {
			}

			@Override
			public void addCellEditorListener(CellEditorListener arg0) {

			}

			@Override
			public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
				return (JCheckBox)value;
			}
		});
		scroll = new JScrollPane(tableMan);

		JTableHeader header = tableMan.getTableHeader();
		header.setBackground(ConstantsUI.HEADER_COLOR);
		header.setForeground(Color.WHITE);
		header.setFont(new Font("Arial", Font.BOLD, 19));
		add(scroll, BorderLayout.CENTER);
	}


	public int getSelectedPersonId(){
		return (int)tableMan.getValueAt(tableMan.getSelectedRow(), 0);
	}
	private JCheckBox createCheckBox(int id) {
		JCheckBox checkBox = new JCheckBox("select",false);
		checkBox.setName(id+"");
		checkBox.setBackground(Color.WHITE);
		return checkBox;
	}

	public void refreshTable(ArrayList<Person> list) {
		model.setRowCount(0);
		for (Person person : list) {
			model.addRow(new Object[] {person.getIdPerson(), person.getNamePerson(), person.getGender(), createCheckBox(person.getIdPerson())});
			tableMan.setModel(model);
		}
	}
	public int[] getCheckSelected() {
		int o = 0;
		int [] vector = new int[2];
		for (int i = 0; i < tableMan.getRowCount(); i++) {
			JCheckBox check = ((JCheckBox)tableMan.getValueAt(i, 3));
			if(check.isSelected()) {
				vector[o] = Integer.parseInt(check.getName());
				o++;
			}
		}
		return vector;
	}

	public void quitCheck() {
		for (int i = 0; i < tableMan.getRowCount(); i++) {
			((JCheckBox)tableMan.getValueAt(i, 3)).setSelected(false);
		}
	}
}