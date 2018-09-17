
package com.lxk.model;


import java.util.Objects;

/**
 * Column metadata.
 *
 * @author panjuan
 */
public final class ColumnMetaData {
    
    private String columnName;
    
    private String columnType;
    
    private boolean primaryKey;


    public ColumnMetaData() {
    }

    public ColumnMetaData(String columnName, String columnType, boolean primaryKey) {
        this.columnName = columnName;
        this.columnType = columnType;
        this.primaryKey = primaryKey;
    }

    public String getColumnName() {
        return columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public boolean isPrimaryKey() {
        return primaryKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ColumnMetaData that = (ColumnMetaData) o;
        return primaryKey == that.primaryKey &&
                Objects.equals(columnName, that.columnName) &&
                Objects.equals(columnType, that.columnType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(columnName, columnType, primaryKey);
    }

    @Override
    public String toString() {
        return "ColumnMetaData{" +
                "columnName='" + columnName + '\'' +
                ", columnType='" + columnType + '\'' +
                ", primaryKey=" + primaryKey +
                '}';
    }
}
