package utils;

import Data.TableData;
import org.openqa.selenium.WebDriver;

import java.util.List;

public interface GenericTable {
    GenericTable withDriver(WebDriver driver);

    GenericTable withExtraConfig(int table);

    List<String> getHeaders();

    List<TableData> getHeadersRow(); //Assumption is made that there is possibility of having multiple header Rows

    List<TableData> getRows();

    TableData getRow(int index);
}
