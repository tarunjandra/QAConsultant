package utils;

import Data.TableData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageLocators.DataTablesPageLocators;

import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class TableOperations implements GenericTable {

    WebDriver driver = null;
    DataTablesPageLocators dataTablesPageLocators = new DataTablesPageLocators();
    List<WebElement> headerColumnTableElements = new LinkedList<>();
    List<WebElement> dataRows = new LinkedList<>();
    List<WebElement> headerRows = new LinkedList<>();

    @Override
    public GenericTable withDriver(WebDriver driver) {
        this.driver = driver;
        return null;
    }

    @Override
    public GenericTable withExtraConfig(int table) {
        switch (table) {
            case 1:
                headerColumnTableElements = driver.findElements(dataTablesPageLocators.getTable1HeaderColumns());
                dataRows = driver.findElements(dataTablesPageLocators.getTable1rows());
                headerRows = driver.findElements(dataTablesPageLocators.getTable1HeaderRows());
                break;
            case 2:
                headerColumnTableElements = driver.findElements(dataTablesPageLocators.getTable2HeaderColumns());
                dataRows = driver.findElements(dataTablesPageLocators.getTable2rows());
                headerRows = driver.findElements(dataTablesPageLocators.getTable2HeaderRows());
                break;
        }
        return null;
    }

    @Override
    public List<TableData> getHeadersRow() {
        List<TableData> headersTableData = new LinkedList<>();
        TableData tableData = null;
        for (int row = 0; row < headerRows.size(); row++) {
            tableData = storeDataInTableDataObject(headerRows.get(row), dataTablesPageLocators.getHeaderTag());
            headersTableData.add(tableData);
        }
        return headersTableData;
    }

    @Override
    public List<String> getHeaders() {
        List<String> list = new LinkedList<>();
        for (WebElement element : headerColumnTableElements) {
            list.add(element.getText());
        }
        return list;
    }

    @Override
    public TableData getRow(int index) {
        TableData tableData = storeDataInTableDataObject(dataRows.get(index), dataTablesPageLocators.getRowTag());
        return tableData;
    }

    @Override
    public List<TableData> getRows() {
        List<TableData> rowsTableData = new LinkedList<>();
        for (int row = 0; row < dataRows.size(); row++) {
            TableData tableData = storeDataInTableDataObject(dataRows.get(row), dataTablesPageLocators.getRowTag());
            rowsTableData.add(tableData);
        }

        Collections.sort(rowsTableData, new Comparator<TableData>() {
            @Override
            public int compare(TableData o1, TableData o2) {
                return Collator.getInstance().compare(o1.getLastName(), o2.getLastName());
            }
        });

        return rowsTableData;
    }

    private TableData storeDataInTableDataObject(WebElement rowElement, By tag) {
        TableData tableData = new TableData();
        WebElement element = rowElement;
        List<WebElement> data = element.findElements(tag);
        for (int column = 0; column < data.size(); column++) {
            switch (column) {
                case 0:
                    tableData.setLastName(data.get(0).getText());
                    break;
                case 2:
                    tableData.setFirstName(data.get(1).getText());
                    break;
                case 3:
                    tableData.setEmail(data.get(2).getText());
                    break;
                case 4:
                    tableData.setDue(data.get(3).getText());
                    break;
                case 5:
                    tableData.setWebsite(data.get(4).getText());
                    break;
            }
        }
        return tableData;
    }
}