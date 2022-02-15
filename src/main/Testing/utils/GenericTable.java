package utils;

import Data.TableData;

import java.util.List;

public interface GenericTable {
    List<String> getHeaders();

    TableData getHeadersRow();

    TableData getRow(int index);

    List<TableData> getRows();
}
