package pageObjects;

import Data.TableData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageLocators.DataTablesPageLocators;

import java.util.LinkedList;
import java.util.List;

public class PODataTablesPage {
    private WebDriver webDriver = null;
    DataTablesPageLocators dataTablesPageLocators = new DataTablesPageLocators();

    public PODataTablesPage(final WebDriver webDriver) {

        this.webDriver = webDriver;
    }

    public Boolean validateNumberOfHeaderRowsEqualInTables() {
        Boolean flag = false;
        int numberOfHeaderRowsTable1 = webDriver.findElements(dataTablesPageLocators.getTable1HeaderRows()).size();
        int numberOfHeaderRowsTable2 = webDriver.findElements(dataTablesPageLocators.getTable2HeaderRows()).size();
        if (numberOfHeaderRowsTable1 == numberOfHeaderRowsTable2) {
            flag = true;
        }
        return flag;
    }

    public Boolean validateHeaderOrderAndDataIsSameInTables() {
        Boolean flag = false;
        List<WebElement> headerColumnTable1 = webDriver.findElements(dataTablesPageLocators.getTable1HeaderColumns());
        List<WebElement> headerColumnTable2 = webDriver.findElements(dataTablesPageLocators.getTable2HeaderColumns());
        if (headerColumnTable1.size() == headerColumnTable2.size()) {
            for (int i = 0; i < headerColumnTable1.size(); i++) {
                if (headerColumnTable1.get(i).getText().equals(headerColumnTable2.get(i).getText())) {
                    flag = true;
                } else {
                    flag = false;
                }
            }
        }
        return flag;
    }

    public Boolean validateDataIsSameInTables() {

        Boolean flag = false;
        int numberOfDataRows = webDriver.findElements(dataTablesPageLocators.getTable1rows()).size();
        int numberOfDataColumns = webDriver.findElements(dataTablesPageLocators.getTable1HeaderColumns()).size();
        LinkedList<TableData> example1Data = new LinkedList<>();
        LinkedList<TableData> example2Data = new LinkedList<>();

        //Getting data from web and storing into LinkedList as TableData object
        for (int row = 1; row <= numberOfDataRows; row++) {
            TableData table1Data = new TableData();
            TableData table2Data = new TableData();
            for (int column = 1; column < numberOfDataColumns; column++) {
                switch (column) {
                    case 1:
                        table1Data.setLastName(webDriver.findElement(dataTablesPageLocators.getTableContent(1, row, column)).getText());
                        table2Data.setLastName(webDriver.findElement(dataTablesPageLocators.getTableContent(2, row, column)).getText());
                        break;
                    case 2:
                        table1Data.setFirstName(webDriver.findElement(dataTablesPageLocators.getTableContent(1, row, column)).getText());
                        table2Data.setFirstName(webDriver.findElement(dataTablesPageLocators.getTableContent(2, row, column)).getText());
                        break;
                    case 3:
                        table1Data.setEmail(webDriver.findElement(dataTablesPageLocators.getTableContent(1, row, column)).getText());
                        table2Data.setEmail(webDriver.findElement(dataTablesPageLocators.getTableContent(2, row, column)).getText());
                        break;
                    case 4:
                        table1Data.setDue(webDriver.findElement(dataTablesPageLocators.getTableContent(1, row, column)).getText());
                        table2Data.setDue(webDriver.findElement(dataTablesPageLocators.getTableContent(2, row, column)).getText());
                        break;
                    case 5:
                        table1Data.setWebsite(webDriver.findElement(dataTablesPageLocators.getTableContent(1, row, column)).getText());
                        table2Data.setWebsite(webDriver.findElement(dataTablesPageLocators.getTableContent(2, row, column)).getText());
                        break;
                }
            }
            example1Data.add(table1Data);
            example2Data.add(table2Data);
        }

        //Validating Data in two tables is same
        for (int rows = 1; rows < numberOfDataRows; rows++) {

            boolean lastNamesAreEqual = example1Data.get(rows).getLastName().equals(example2Data.get(rows).getLastName());
            boolean firstNamesAreEqual = example1Data.get(rows).getFirstName().equals(example2Data.get(rows).getFirstName());
            boolean emailsAreEqual = example1Data.get(rows).getEmail().equals(example2Data.get(rows).getEmail());
            boolean duesAreEqual = example1Data.get(rows).getDue().equals(example2Data.get(rows).getDue());
            boolean websitesAreEqual = example1Data.get(rows).getWebsite().equals(example2Data.get(rows).getWebsite());

            if (lastNamesAreEqual && firstNamesAreEqual && emailsAreEqual && duesAreEqual && websitesAreEqual) {
                flag = true;
            }
        }
        return flag;
    }

    public Boolean validateNumberOfDataRowsEqualInTables() {
        Boolean flag = false;
        int numberOfDataRowsTable1 = webDriver.findElements(dataTablesPageLocators.getTable1rows()).size();
        int numberOfDataRowsTable2 = webDriver.findElements(dataTablesPageLocators.getTable2rows()).size();
        if (numberOfDataRowsTable1 == numberOfDataRowsTable2) {
            flag = true;
        }
        return flag;
    }
}
