package pageLocators;

import org.openqa.selenium.By;

public class DataTablesPageLocators {

    private final By table1HeaderRows = By.cssSelector("#table1 thead tr");
    private final By table2HeaderRows = By.cssSelector("#table2 thead tr");

    private final By table1rows = By.cssSelector("#table1 tbody tr");
    private final By table2rows = By.cssSelector("#table2 tbody tr");

    private final By table1HeaderColumns = By.cssSelector("#table1 thead tr th");
    private final By table2HeaderColumns = By.cssSelector("#table2 thead tr th");

    private final By headerTag = By.tagName("th");
    private final By rowTag = By.tagName("td");

    public By getTable1HeaderRows() {

        return table1HeaderRows;
    }

    public By getTable1rows() {

        return table1rows;
    }

    public By getTable2HeaderRows() {

        return table2HeaderRows;
    }

    public By getTable2rows() {

        return table2rows;
    }

    public By getTable1HeaderColumns() {

        return table1HeaderColumns;
    }

    public By getTable2HeaderColumns() {

        return table2HeaderColumns;
    }

    public By getHeaderTag() {
        return headerTag;
    }

    public By getRowTag() {
        return rowTag;
    }
}
