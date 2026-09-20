public class FileExtensionValidator {
    
    public static String validateFileExtension(String filename) {
        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex == -1) return "Rejected — invalid file type";
        
        String ext = filename.substring(dotIndex + 1).toLowerCase();
        
        if (ext.equals("pdf") || ext.equals("docx") || ext.equals("zip")) {
            return "Accepted";
        }
        return "Rejected — invalid file type";
    }
    
    public static void main(String[] args) {
        System.out.println("Assignment1.PDF: " + validateFileExtension("Assignment1.PDF"));
        System.out.println("notes.txt: " + validateFileExtension("notes.txt"));
    }
}