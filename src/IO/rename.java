package IO;

import java.io.File;

public class rename {

    private String replacedText;
    private String replaceWithText;

    public rename(String fileName, String replacedText, String replaceWithText) {
//        super(fileName);
        this.replacedText = replacedText;
        this. replaceWithText=  replaceWithText;
    }

    public void rename(File f) {
        if(replacedText == null)
            return;

        String filename = f.getName();

        String replaceWithThis = "";

        if( replaceWithText != null)
            replaceWithThis = replaceWithText;


        String newname = f.getParent() + File.separatorChar +
                filename.replaceAll( replacedText, replaceWithThis);

        f.renameTo(new File(newname));

    }
}
