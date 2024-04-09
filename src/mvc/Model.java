package mvc;

import java.io.Serializable;

public class Model extends Publisher implements Serializable {
    protected boolean unsavedChanges;
    protected String fileName;
    public void changed() {
        notifySubscribers();
    }

    public boolean setUnsavedChanges(boolean unsavedChanges) {
        //might need to notifysubscribers
        return unsavedChanges;
    }

    public boolean getUnsavedChanges() {
        //might need to notifysubscribers
        return unsavedChanges;
    }

    public void setFileName(String fName) {
        fileName = fName;
    }

    public String getFileName() {
        return fileName;
    }
}
