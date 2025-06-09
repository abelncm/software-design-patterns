package structural_patterns.composite;

/**
 * Demo Class: To demonstrate the use of the Composite pattern.
 * It builds a tree structure of FileSystemComponents (Files and Directories)
 * and shows how clients can treat individual objects and compositions uniformly.
 */
public class CompositeDemo {
    public static void main(String[] args) {
        System.out.println("--- Composite Pattern Demo: File System ---");

        // Create leaf objects (Files)
        File file1 = new File("Report.docx", 120); // Size in KB, let's use bytes for consistency
        File file2 = new File("Image.jpg", 2048);
        File file3 = new File("Spreadsheet.xlsx", 512);
        File file4 = new File("Archive.zip", 10240);
        File file5 = new File("Readme.txt", 10);

        // Create composite objects (Directories)
        Directory root = new Directory("Root");
        Directory documents = new Directory("Documents");
        Directory pictures = new Directory("Pictures");
        Directory workDocs = new Directory("Work");
        Directory personalDocs = new Directory("Personal");

        // Build the tree structure
        // Root
        //  |- Documents
        //  |   |- Work
        //  |   |   |- Report.docx
        //  |   |   |- Spreadsheet.xlsx
        //  |   |- Personal
        //  |   |   |- Readme.txt
        //  |   |- Archive.zip
        //  |- Pictures
        //  |   |- Image.jpg

        root.addComponent(documents);
        root.addComponent(pictures);

        documents.addComponent(workDocs);
        documents.addComponent(personalDocs);
        documents.addComponent(file4); // Archive.zip directly in Documents

        workDocs.addComponent(file1);    // Report.docx in Work
        workDocs.addComponent(file3);    // Spreadsheet.xlsx in Work

        personalDocs.addComponent(file5); // Readme.txt in Personal

        pictures.addComponent(file2);   // Image.jpg in Pictures

        // Add a deeply nested structure for testing display
        Directory veryDeepDir = new Directory("DeepFolder");
        File deepFile = new File("deep.txt", 5);
        veryDeepDir.addComponent(deepFile);
        personalDocs.addComponent(veryDeepDir);


        System.out.println("\nDisplaying details for the entire file system (from root):");
        root.displayDetails(""); // Display details starting from root with no initial indent

        System.out.println("\n--------------------------------------------------");
        System.out.println("Total size of the 'Root' directory: " + root.getSize() + " bytes");
        System.out.println("Total size of the 'Documents' directory: " + documents.getSize() + " bytes");
        System.out.println("Total size of the 'Work' directory: " + workDocs.getSize() + " bytes");
        System.out.println("Total size of 'file1' (Report.docx): " + file1.getSize() + " bytes");

        System.out.println("\n--------------------------------------------------");
        System.out.println("Displaying details for the 'Pictures' directory:");
        pictures.displayDetails("");

        System.out.println("\n--------------------------------------------------");
        System.out.println("Displaying details for the 'Personal/DeepFolder' directory:");
        // To get a specific child, you might need to iterate or have a search mechanism.
        // For demo, assuming we know the path or have direct access.
        Directory foundDeepDir = null;
        for(FileSystemComponent comp : personalDocs.getChildren()){
            if(comp.getName().equals("DeepFolder") && comp instanceof Directory){
                foundDeepDir = (Directory) comp;
                break;
            }
        }
        if(foundDeepDir != null){
            foundDeepDir.displayDetails("");
        } else {
            System.out.println("DeepFolder not found directly under Personal for this specific demo check.");
        }


        System.out.println("\n--- Composite Pattern Demo Finished ---");
    }
}
