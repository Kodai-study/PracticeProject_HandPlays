package console;

import java.io.IOException;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.InfoCmp;

public class JlineTerminalManager implements ITerminalManager {

    private Terminal terminal;

    private JlineTerminalManager() throws IOException {
        this.terminal = TerminalBuilder.builder().system(true).build();
    }

    @Override
    public void clearScreen() {
        terminal.puts(InfoCmp.Capability.clear_screen); // 画面をクリア
    }

    @Override
    public void printLine(String line) {
        System.out.println(line);
    }

    @Override
    public void print(String str) {
        System.out.print(str);
    }

}
