package za.co.WeThinkCode_.swingy.model;

public interface screens {
    public abstract void StartMenu();
    public abstract void NewGame();
    public abstract void ContinueMenu();
    public abstract void SelectClass();
    public abstract void ClassName();
    public abstract void LoadGame();
    public abstract void SelectChar();
    public abstract void MoveMenu();
    public abstract void EnemyEncountered(int[] tempCor);
    public abstract void FightWon();
    public abstract void ItemDropped();
    public abstract void FightLost();
    public abstract void RanAway();
    public abstract void RunFail();
    public abstract void NewLevel();
    public abstract void QuitVerify();
    public abstract void QuitGame();
}
