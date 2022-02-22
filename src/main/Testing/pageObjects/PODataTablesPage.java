package pageObjects;

import Data.TableData;
import org.openqa.selenium.WebDriver;
import utils.TableOperations;
import utils.GenericTable;

import java.util.List;

public class PODataTablesPage {

    private WebDriver webDriver = null;
    GenericTable exampleOne = new TableOperations();
    GenericTable exampleTwo = new TableOperations();

    public PODataTablesPage(final WebDriver webDriver) {

        this.webDriver = webDriver;
    }

    private void initializer() {
        exampleOne.withDriver(webDriver);
        exampleTwo.withDriver(webDriver);
        exampleOne.withExtraConfig(1);
        exampleTwo.withExtraConfig(2);
    }

    public Boolean validateNumberOfHeaderRowsEqualInTables() {
        Boolean flag = false;
        initializer();
        if (exampleOne.getHeadersRow().size() == exampleTwo.getHeadersRow().size()) {
            flag = true;
        }
        return flag;
    }

    public Boolean validateHeaderOrderAndDataIsSameInTables() {
        Boolean flag = false;
        initializer();
        List<String> headersCountTable1 = exampleOne.getHeaders();
        List<String> headersCountTable2 = exampleTwo.getHeaders();

        if (headersCountTable1.size() == headersCountTable2.size()) {
            for (int i = 0; i < headersCountTable1.size(); i++) {
                if (!(headersCountTable1.get(i).equals(headersCountTable2.get(i)))) {
                    flag = false;
                    break;
                } else {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public Boolean validateNumberOfDataRowsEqualInTables() {
        Boolean flag = false;
        initializer();
        if (exampleOne.getRows().size() == exampleTwo.getRows().size()) {
            flag = true;
        }
        return flag;
    }

    public Boolean validateDataIsSameInTables() {
        Boolean flag = false;
        initializer();
        List<TableData> example1Data = exampleOne.getRows();
        List<TableData> example2Data = exampleTwo.getRows();

        for (int rows = 0; rows < exampleOne.getRows().size(); rows++) {
            boolean lastNamesAreEqual = example1Data.get(rows).getLastName().equals(example2Data.get(rows).getLastName());
            boolean firstNamesAreEqual = example1Data.get(rows).getFirstName().equals(example2Data.get(rows).getFirstName());
            boolean emailsAreEqual = example1Data.get(rows).getEmail().equals(example2Data.get(rows).getEmail());
            boolean duesAreEqual = example1Data.get(rows).getDue().equals(example2Data.get(rows).getDue());
            boolean websitesAreEqual = example1Data.get(rows).getWebsite().equals(example2Data.get(rows).getWebsite());

            if (!(lastNamesAreEqual && firstNamesAreEqual && emailsAreEqual && duesAreEqual && websitesAreEqual)) {
                flag = false;
                break;
            } else {
                flag = true;
            }
        }
        return flag;
    }
}
