package gr.javier.assignments.landloop.ex1;

import java.util.HashMap;
import java.util.Map;

public class BuilderMapEntry implements BuilderEntry {
    private final Map<String, Object> entry = new HashMap<>();

    @Override
    public void link(String key, Object value) {
        entry.put(key, value);
    }

    @Override
    public Object getEntry() {
        return entry;
    }
}
