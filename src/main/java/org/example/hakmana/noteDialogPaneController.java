package org.example.hakmana;

import javafx.fxml.FXML;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextArea;

public class noteDialogPaneController {
    @FXML
    private TextArea noteView;

    @FXML
    private DialogPane notePane;

    public void setNoteView(TextArea noteView) {
        this.noteView = noteView;
    }

    public  void setText(String txt){
        noteView.setText(txt);
    }

    public void setNotePane(DialogPane notePane) {
        this.notePane = notePane;
    }

    public DialogPane getNotePane() {
        return notePane;
    }

    public TextArea getNoteView() {
        return noteView;
    }
}
