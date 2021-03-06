package guitests.guihandles;

import javafx.stage.Stage;

/**
 * Provides a handle for {@code MainWindow}.
 */
public class MainWindowHandle extends StageHandle {

    private final PersonListPanelHandle personListPanel;
    private final ResultDisplayHandle resultDisplay;
    private final CommandBoxHandle commandBox;
    private final StatusBarFooterHandle statusBarFooter;
    private final MainMenuHandle mainMenu;
    private final BrowserPanelHandle browserPanel;
    private final PersonDetailsPanelHandle personDetailsPanel;
    private final CalendarPanelHandle calendarPanel;
    private final DailySchedulerPanelHandle dailySchedulerPanel;

    public MainWindowHandle(Stage stage) {
        super(stage);

        personListPanel = new PersonListPanelHandle(getChildNode(PersonListPanelHandle.PERSON_LIST_VIEW_ID));
        resultDisplay = new ResultDisplayHandle(getChildNode(ResultDisplayHandle.RESULT_DISPLAY_ID));
        commandBox = new CommandBoxHandle(getChildNode(CommandBoxHandle.COMMAND_INPUT_FIELD_ID));
        statusBarFooter = new StatusBarFooterHandle(getChildNode(StatusBarFooterHandle.STATUS_BAR_PLACEHOLDER));
        mainMenu = new MainMenuHandle(getChildNode(MainMenuHandle.MENU_BAR_ID));
        browserPanel = new BrowserPanelHandle(getChildNode(BrowserPanelHandle.BROWSER_ID));
        personDetailsPanel =
                new PersonDetailsPanelHandle(getChildNode(PersonDetailsPanelHandle.PERSON_DETAILS_PANEL_PLACEHOLDER));
        calendarPanel = new CalendarPanelHandle(getChildNode(CalendarPanelHandle.BROWSER_ID));
        dailySchedulerPanel =
                new DailySchedulerPanelHandle(getChildNode(DailySchedulerPanelHandle.DAILY_SCHEDULER_PLACEHOLDER));
    }

    public PersonListPanelHandle getPersonListPanel() {
        return personListPanel;
    }

    public ResultDisplayHandle getResultDisplay() {
        return resultDisplay;
    }

    public CommandBoxHandle getCommandBox() {
        return commandBox;
    }

    public StatusBarFooterHandle getStatusBarFooter() {
        return statusBarFooter;
    }

    public MainMenuHandle getMainMenu() {
        return mainMenu;
    }

    public BrowserPanelHandle getBrowserPanel() {
        return browserPanel;
    }

    public PersonDetailsPanelHandle getPersonDetailsPanel() {
        return personDetailsPanel;
    }

    public CalendarPanelHandle getCalendarPanel() {
        return calendarPanel;
    }

    public DailySchedulerPanelHandle getDailySchedulerPanel() {
        return dailySchedulerPanel;
    }

}
