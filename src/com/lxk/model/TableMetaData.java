/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

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
