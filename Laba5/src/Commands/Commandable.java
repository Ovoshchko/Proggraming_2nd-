package Commands;

import java.io.IOException;

public interface Commandable {
    String execute(Object o) throws IOException;

    String getName();
}
