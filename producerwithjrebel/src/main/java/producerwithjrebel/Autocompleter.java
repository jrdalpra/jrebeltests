package producerwithjrebel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.val;

@RequiredArgsConstructor
public class Autocompleter<T> {

    public static interface Finder<T> {
        List<T> list(String query);
    }

    private final List<Finder<T>> finders;

    public Autocompleter() {
        this.finders = null;
    }

    public Autocompleter(Finder<T>... finders) {
        this(Arrays.asList(finders));
    }

    public List<T> autocomplete(String query) {
        for (val finder : finders)
            return finder.list(query);
        return Collections.<T> emptyList();
    }

}
