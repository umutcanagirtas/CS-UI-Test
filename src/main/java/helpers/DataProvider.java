package helpers;

public class DataProvider {
    @org.testng.annotations.DataProvider(name = "SearchProvider")
    public Object[][] getDataFromDataProvider() {
        return new Object[][]
                {
                        {"Vietnam", "en-vn"},
                        {"Colombia", "en-co"},
                        {"Mexico", "en-mx"},
                        {"Germany", "en-de"},
                        {"Spain", "en-es"}
                };

    }
}
