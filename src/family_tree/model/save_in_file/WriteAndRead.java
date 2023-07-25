package family_tree.model.save_in_file;

import java.io.IOException;
import java.io.Serializable;

public interface WriteAndRead<E extends Serializable> {
    void write(String path, E obj) throws IOException;
    Object readTree(String path) throws IOException, ClassNotFoundException;
}
