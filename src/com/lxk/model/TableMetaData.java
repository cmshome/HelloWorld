package com.lxk.model;


import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Table metadata.
 *
 * @author panjuan
 */
public class TableMetaData {
    
    private Collection<ColumnMetaData> columnMetaData;
    
    /**
     * Get all column names.
     *
     * @return column names
     */
    public Collection<String> getAllColumnNames() {
        Collection<String> result = new LinkedList<>();
        for (ColumnMetaData each : columnMetaData) {
            result.add(each.getColumnName().toLowerCase());
        }
        return result;
    }

    public TableMetaData(Collection<ColumnMetaData> columnMetaData) {
        this.columnMetaData = columnMetaData;
    }

    public Collection<ColumnMetaData> getColumnMetaData() {
        return columnMetaData;
    }

    public void setColumnMetaData(Collection<ColumnMetaData> columnMetaData) {
        this.columnMetaData = columnMetaData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TableMetaData that = (TableMetaData) o;
        if (columnMetaData.size() != that.getColumnMetaData().size()) {
            return false;
        }
        return columnMetaData.containsAll(that.getColumnMetaData());
    }

    @Override
    public int hashCode() {

        return Objects.hash(columnMetaData);
    }
}
