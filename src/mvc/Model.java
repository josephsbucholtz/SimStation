package mvc;


import java.io.Serializable;

public abstract class Model extends Publisher implements Serializable {
    private boolean unsavedChanges;
    private String fileName;

    public Model(){
        unsavedChanges = false;
        fileName = null;
    }
    public void setUnsavedChanges(boolean unsavedChanges) {
        this.unsavedChanges = unsavedChanges;
    }
    public boolean getUnsavedChanges() {
        return unsavedChanges;
    }
    public void setFileName(String fileName){
        this.fileName = fileName;
    }
    public String getFileName(){
        return fileName;
    }


    public void changed(){
        setUnsavedChanges(true);
        notifySubscribers();
    }


}