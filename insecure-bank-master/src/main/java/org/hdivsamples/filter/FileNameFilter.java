package org.hdivsamples.filter;

public class FileNameFilter {
    
    public static boolean chkFileName(String fileName) {
        if (fileName != null) {
            String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
            if (!"gif".equals(fileExt) && !"png".equals(fileExt) && !"jpg".equals(fileExt)) {
                String message = "업로드 불가능한 파일";
                return false;
            }
        }

        return true;
    }
}
