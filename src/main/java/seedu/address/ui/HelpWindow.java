package seedu.address.ui;

import static seedu.address.ui.CommandFormat.*;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;

/**
 * Controller for a help page
 */
public class HelpWindow extends UiPart<Stage> {
    public static final String USERGUIDE_URL =
            "https://ay2122s1-cs2103t-t12-4.github.io/tp/UserGuide.html#command-summary";
    public static final String HELP_MESSAGE = "Refer to the user guide for more information:\n";

    private static final Logger logger = LogsCenter.getLogger(HelpWindow.class);
    private static final String FXML = "HelpWindow.fxml";

    @FXML
    private Button copyButton;
    @FXML
    private Label helpMessage;

    @FXML
    private Label add;
    @FXML
    private Label addDesc;
    @FXML
    private Label addToClass;
    @FXML
    private Label addToClassDesc;
    @FXML
    private Label del;
    @FXML
    private Label delDesc;
    @FXML
    private Label delc;
    @FXML
    private Label delcDesc;
    @FXML
    private Label atc;
    @FXML
    private Label atcDesc;
    @FXML
    private Label rm;
    @FXML
    private Label rmDesc;
    @FXML
    private Label e;
    @FXML
    private Label eDesc;
    @FXML
    private Label ec;
    @FXML
    private Label ecDesc;
    @FXML
    private Label vs;
    @FXML
    private Label vsDesc;
    @FXML
    private Label vc;
    @FXML
    private Label vcDesc;
    @FXML
    private Label re;
    @FXML
    private Label reDesc;
    @FXML
    private Label rec;
    @FXML
    private Label recDesc;
    @FXML
    private Label s;
    @FXML
    private Label sDesc;
    @FXML
    private Label f;
    @FXML
    private Label fc;
    @FXML
    private Label l;
    @FXML
    private Label lc;
    @FXML
    private Label tt;
    @FXML
    private Label fDesc;
    @FXML
    private Label fcDesc;
    @FXML
    private Label lDesc;
    @FXML
    private Label lcDesc;
    @FXML
    private Label ttDesc;
    @FXML
    private Label td;
    @FXML
    private Label clear;
    @FXML
    private Label exit;
    @FXML
    private Label tdDesc;
    @FXML
    private Label clearDesc;
    @FXML
    private Label exitDesc;
    /**
     * Creates a new HelpWindow.
     *
     * @param root Stage to use as the root of the HelpWindow.
     */
    public HelpWindow(Stage root) {
        super(FXML, root);
        helpMessage.setText(HELP_MESSAGE);
        add.setText(ADD_COMMAND);
        addDesc.setText(ADD_DESC);
        addToClass.setText(ADD_CLASS_COMMAND);
        addToClassDesc.setText(ADD_CLASS_DESC);
        del.setText(DELETE_COMMAND);
        delDesc.setText(DELETE_DESC);
        delc.setText(DELETE_ClASS_COMMAND);
        delcDesc.setText(DELETE_CLASS_DESC);
        atc.setText(ADD_TO_CLASS_COMMAND);
        atcDesc.setText(ADD_TO_CLASS_DESC);
        rm.setText(REMOVE_FROM_CLASS_COMMAND);
        rmDesc.setText(REMOVE_FROM_CLASS_DESC);
        e.setText(EDIT_COMMAND);
        eDesc.setText(EDIT_DESC);
        ec.setText(EDIT_CLASS_COMMAND);
        ecDesc.setText(EDIT_CLASS_DESC);
        vs.setText(VIEW_COMMAND);
        vsDesc.setText(VIEW_DESC);
        vc.setText(VIEW_CLASS_COMMAND);
        vcDesc.setText(VIEW_CLASS_DESC);
        re.setText(REMARK_COMMAND);
        reDesc.setText(REMARK_DESC);
        rec.setText(REMARK_CLASS_COMMAND);
        recDesc.setText(REMARK_CLASS_DESC);
        s.setText(SORT_COMMAND);
        sDesc.setText(SORT_DESC);
        f.setText(FIND_COMMAND);
        fDesc.setText(FIND_DESC);
        fc.setText(FIND_CLASS_COMMAND);
        fcDesc.setText(FIND_CLASS_DESC);
        l.setText(LIST_COMMAND);
        lDesc.setText(LIST_DESC);
        lc.setText(LIST_CLASS_COMMAND);
        lcDesc.setText(LIST_CLASS_DESC);
        tt.setText(TIMETABLE_COMMAND);
        ttDesc.setText(TIMETABLE_DESC);
        td.setText(TODAY_COMMAND);
        tdDesc.setText(TODAY_DESC);
        clear.setText(CLEAR_COMMAND);
        clearDesc.setText(CLEAR_DESC);
        exit.setText(EXIT_COMMAND);
        exitDesc.setText(EXIT_DESC);
    }

    /**
     * Creates a new HelpWindow.
     */
    public HelpWindow() {
        this(new Stage());
    }

    /**
     * Shows the help window.
     * @throws IllegalStateException
     * <ul>
     *     <li>
     *         if this method is called on a thread other than the JavaFX Application Thread.
     *     </li>
     *     <li>
     *         if this method is called during animation or layout processing.
     *     </li>
     *     <li>
     *         if this method is called on the primary stage.
     *     </li>
     *     <li>
     *         if {@code dialogStage} is already showing.
     *     </li>
     * </ul>
     */
    public void show() {
        logger.fine("Showing help page about the application.");
        getRoot().show();
        getRoot().centerOnScreen();
    }

    /**
     * Returns true if the help window is currently being shown.
     */
    public boolean isShowing() {
        return getRoot().isShowing();
    }

    /**
     * Hides the help window.
     */
    public void hide() {
        getRoot().hide();
    }

    /**
     * Focuses on the help window.
     */
    public void focus() {
        getRoot().requestFocus();
    }

    /**
     * Copies the URL to the user guide to the clipboard.
     */
    @FXML
    private void copyUrl() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(USERGUIDE_URL);
        clipboard.setContent(url);
    }
}
