package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalAccounts.getTypicalLoginBook;
import static seedu.address.testutil.TypicalClubBudgetElements.getTypicalClubBudgetElementsBook;
import static seedu.address.testutil.TypicalFinalClubBudget.getTypicalFinalBudgetsBook;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.Test;

import seedu.address.logic.CommandHistory;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

public class ClearCommandTest {

    private CommandHistory commandHistory = new CommandHistory();

    @Test
    public void execute_emptyAddressBook_success() {
        Model model = new ModelManager();
        Model expectedModel = new ModelManager();
        expectedModel.commitAddressBook();
        expectedModel.commitClubBudgetElementsBook();
        expectedModel.commitFinalBudgetsBook();

        assertCommandSuccess(new ClearCommand(), model, commandHistory, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_nonEmptyAddressBook_success() {
        Model model = new ModelManager(getTypicalLoginBook(), getTypicalAddressBook(),
                getTypicalClubBudgetElementsBook(), getTypicalFinalBudgetsBook(), new UserPrefs());
        Model expectedModel = new ModelManager(getTypicalLoginBook(), getTypicalAddressBook(),
                getTypicalClubBudgetElementsBook(), getTypicalFinalBudgetsBook(), new UserPrefs());
        expectedModel.resetData(new AddressBook());
        expectedModel.commitAddressBook();

        assertCommandSuccess(new ClearCommand(), model, commandHistory, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

}
