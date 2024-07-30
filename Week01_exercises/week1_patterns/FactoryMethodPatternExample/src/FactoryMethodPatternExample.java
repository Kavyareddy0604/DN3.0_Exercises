// Abstract Document class
abstract class Document {
    public abstract void open();
    public abstract void save();
    public abstract void close();
}

// Concrete WordDocument class
class WordDocument extends Document {
    @Override
    public void open() {
        System.out.println("Opening Word document...");
    }

    @Override
    public void save() {
        System.out.println("Saving Word document...");
    }

    @Override
    public void close() {
        System.out.println("Closing Word document...");
    }
}

// Concrete PdfDocument class
class PdfDocument extends Document {
    @Override
    public void open() {
        System.out.println("Opening PDF document...");
    }

    @Override
    public void save() {
        System.out.println("Saving PDF document...");
    }

    @Override
    public void close() {
        System.out.println("Closing PDF document...");
    }
}

// Concrete ExcelDocument class
class ExcelDocument extends Document {
    @Override
    public void open() {
        System.out.println("Opening Excel document...");
    }

    @Override
    public void save() {
        System.out.println("Saving Excel document...");
    }

    @Override
    public void close() {
        System.out.println("Closing Excel document...");
    }
}

// Abstract DocumentFactory class
abstract class DocumentFactory {
    public abstract Document createDocument();
}

// Concrete WordDocumentFactory class
class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

// Concrete PdfDocumentFactory class
class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}

// Concrete ExcelDocumentFactory class
class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}

// Test class
public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        // Create factories
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        // Create documents using the factories
        Document wordDoc = wordFactory.createDocument();
        Document pdfDoc = pdfFactory.createDocument();
        Document excelDoc = excelFactory.createDocument();

        // Use the documents
        wordDoc.open();
        wordDoc.save();
        wordDoc.close();

        pdfDoc.open();
        pdfDoc.save();
        pdfDoc.close();

        excelDoc.open();
        excelDoc.save();
        excelDoc.close();
    }
}
