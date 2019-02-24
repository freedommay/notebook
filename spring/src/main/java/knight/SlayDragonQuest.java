package knight;

import java.io.PrintStream;

// SlayDragonQuest是要注入到BraveKnight的Quest实现
public class SlayDragonQuest implements Quest {

  private PrintStream stream;

  public SlayDragonQuest(PrintStream stream) {
    this.stream = stream;
  }

  public void embark() {
    stream.println("Embarking on quest to slay the dragon!");
  }

}
