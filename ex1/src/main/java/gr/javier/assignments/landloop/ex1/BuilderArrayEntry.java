package gr.javier.assignments.landloop.ex1;

import java.util.ArrayList;

public class BuilderArrayEntry implements BuilderEntry {
    private final ArrayList entry = new ArrayList<>();

    @Override
    public void link(String key, Object value) {
        entry.add(value);
    }

    @Override
    public Object getEntry() {
        return entry;
    }
}
