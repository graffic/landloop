package gr.javier.assignments.landloop.ex1;

import java.util.*;

class MapBuilder {
    private final LinkedList<BuilderEntry> path;

    MapBuilder() {
        path = new LinkedList<>();
        path.push(new BuilderMapEntry());
    }

    void addObject(String key) {
        var entry = new BuilderMapEntry();
        path.getFirst().link(key, entry.getEntry());
        path.push(entry);
    }

    void addArray(String key) {
        var entry = new BuilderArrayEntry();
        path.getFirst().link(key, entry.getEntry());
        path.push(entry);
    }

    void addValue(String key, Object value) {
        path.getFirst().link(key, value);
    }

    void back() {
        path.pop();
    }

    Map<String, Object> getRootMap() {
        return (Map<String, Object>)((Map<String, Object>)path.getFirst().getEntry()).get(null);
    }
}

