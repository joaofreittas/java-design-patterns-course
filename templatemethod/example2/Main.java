package templatemethod.example2;

public class Main {

    public static void main(String[] args) {

    }

}


//example template method with hooks
abstract class DataMiner {

    public void mine() {
        openFile();
        extractData();
        parseData();
        analyzeData();
        sendReport();
        //hook
        sendReportAdditional();
        closeFile();
    }

    private void openFile() {
        System.out.println("Opening file");
    }

    private void closeFile() {
        System.out.println("Closing file");
    }

    protected abstract void extractData();

    protected abstract void parseData();

    protected abstract void analyzeData();

    private void sendReport() {
        System.out.println("Sending report");
    }

    protected void sendReportAdditional() {

    }

}

class DataMiner1 extends DataMiner {

    @Override
    protected void extractData() {
        System.out.println("Extracting data 1");
    }

    @Override
    protected void parseData() {
        System.out.println("Parsing data 1");
    }

    @Override
    protected void analyzeData() {
        System.out.println("Analyzing data 1");
    }

    @Override
    protected void sendReportAdditional() {
        System.out.println("Sending additional report 1");
    }

}