package strategy.example1;

public class Main {

    public static void main(String[] args) {
        var file = new TextFile("anotacoes.txt");
        var converterService = new ConverterFileService();
        converterService.changeConverterStrategy(new TextToCsv());

        converterService.convertFile(file);

        converterService.changeConverterStrategy(new CsvToText());

        converterService.convertFile(file);
    }
}


// context
class ConverterFileService {

    private FileConvertibleStrategy converterStrategy;

    public void convertFile(Convertible convertible) {
        converterStrategy.convert(convertible);
    }

    public void changeConverterStrategy(FileConvertibleStrategy fileConvertibleStrategy) {
        this.converterStrategy = fileConvertibleStrategy;
    }

}



interface Convertible {
    String getFileName();
}

//strategy interface
interface FileConvertibleStrategy {
    void convert(Convertible file);
}


class TextFile implements Convertible {

    private final String name;

    @Override
    public String getFileName() {
        return name;
    }

    public TextFile(final String name) {
        this.name = name;
    }

}

class CsvFile implements Convertible {

    private final String name;

    @Override
    public String getFileName() {
        return name;
    }

    public CsvFile(final String name) {
        this.name = name;
    }

}

// strategy implementation 1
class CsvToText implements FileConvertibleStrategy {

    @Override
    public void convert(final Convertible file) {
        System.out.println("Convert csv to text: " + file.getFileName());
    }

}

// strategy implementation 2
class TextToCsv implements FileConvertibleStrategy {

    @Override
    public void convert(final Convertible file) {
        System.out.println("Convert text to csv: " + file.getFileName());
    }

}