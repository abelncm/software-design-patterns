package creational_patterns.factory_method;

/**
 * Demo class to showcase the Factory Method pattern.
 * It demonstrates how ConcreteCreators are used to produce different types of Products.
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("--- Factory Method Demo ---");

        // Using WordDocumentCreator
        DocumentCreator wordCreator = new WordDocumentCreator();
        System.out.println("\nUsing WordDocumentCreator:");
        // The client (Demo) asks a specific creator to create a document.
        // The client does not know which concrete Document class will be instantiated.
        // It only knows it will get some form of Document.
        Document myWordDoc = wordCreator.createDocument("MyReport.docx");
        myWordDoc.open();
        myWordDoc.save();
        myWordDoc.close();

        System.out.println("---");
        // Using the method in DocumentCreator that utilizes the factory method
        wordCreator.newDocument("AnotherWordDoc.docx");


        System.out.println("\n----------------------------\n");

        // Using PdfDocumentCreator
        DocumentCreator pdfCreator = new PdfDocumentCreator();
        System.out.println("Using PdfDocumentCreator:");
        Document myPdfDoc = pdfCreator.createDocument("MyPresentation.pdf");
        myPdfDoc.open();
        myPdfDoc.save();
        myPdfDoc.close();

        System.out.println("---");
        pdfCreator.newDocument("AnotherPdfDoc.pdf");

        System.out.println("\n--- Demo Finished ---");
    }
}
