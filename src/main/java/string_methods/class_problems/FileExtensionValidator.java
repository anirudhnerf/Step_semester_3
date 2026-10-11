package string_methods.class_problems;

public class FileExtensionValidator {

    // Accepts only pdf, docx and zip files (case-insensitive).
    // \u2014 is the em dash character used in the expected output.
    static String validateFileExtension(String filename) {
        int dotIndex = filename.lastIndexOf('.');

        // No dot, or a dot at the very end, means there is no extension
        if (dotIndex == -1 || dotIndex == filename.length() - 1) {
            return "Rejected \u2014 invalid file type";
        }

        String extension = filename.substring(dotIndex + 1);

        if (extension.equalsIgnoreCase("pdf")
                || extension.equalsIgnoreCase("docx")
                || extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        }
        return "Rejected \u2014 invalid file type";
    }

    public static void main(String[] args) {
        System.out.println(validateFileExtension("Assignment1.PDF"));
        System.out.println(validateFileExtension("notes.txt"));
    }
}