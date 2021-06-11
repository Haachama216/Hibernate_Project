package com.hibernate.gui.tablemodel;

import com.hibernate.dao.GiaovuAccountDAO;
import com.hibernate.pojo.GiaovuAccountEntity;

import javax.swing.table.AbstractTableModel;

import java.util.List;

public class GiaovuAccountModel extends AbstractTableModel {
    private List<GiaovuAccountEntity> list;

    public GiaovuAccountModel() {
        list = GiaovuAccountDAO.GetAll();
    }
    public GiaovuAccountModel(List<GiaovuAccountEntity> list) {
        this.list = list;
    }

    public List<GiaovuAccountEntity> getList() {
        return list;
    }

    public void setList(List<GiaovuAccountEntity> list) {
        this.list = list;
    }
    public void AddRow(GiaovuAccountEntity account) {
        list.add(account);
        fireTableRowsInserted(list.size()-1,list.size()-1);
    }
    public void DeleteRow(int column) {
        GiaovuAccountDAO.Delete(list.get(column));
        list.remove(column);
        fireTableRowsDeleted(column,column);
    }
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "id";
            case 1 -> "Username";
            case 2 -> "Password";
            case 3 -> "Name";
            case 4 -> "Faculty";
            case 5 -> "Gender";
            case 6 -> "Phone number";
            case 7 -> "Email";
            default -> null;
        };
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0,columnIndex).getClass();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        GiaovuAccountEntity account = list.get(rowIndex);
        switch(columnIndex) {
            case 1:
                account.setUsername(aValue.toString());
                break;
            case 2:
                account.setPassword(aValue.toString());
                break;
            case 3:
                account.setName(aValue.toString());
                break;
            case 4:
                account.setFaculty(aValue.toString());
                break;
            case 5:
                account.setGender(aValue.toString());
                break;
            case 6:
                account.setPhonenumber(aValue.toString());
                break;
            case 7:
                account.setEmail(aValue.toString());
                break;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        GiaovuAccountEntity account = list.get(rowIndex);
        Object value = null;
        value = switch(columnIndex) {
            case 0 -> account.getGiaovuid();
            case 1 -> account.getUsername();
            case 2 -> account.getPassword();
            case 3 -> account.getName();
            case 4 -> account.getFaculty();
            case 5 -> account.getGender();
            case 6 -> account.getPhonenumber();
            case 7 -> account.getEmail();
            default -> null;
        };
        return value;
    }
}
