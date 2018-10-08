package gr.javier.assignments.landloop.ex1;

import com.fasterxml.jackson.core.JsonFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class JsonMap {
    private static JsonFactory factory = new JsonFactory();

    public static Map<String, Object> toMap(InputStream json) throws IOException {
        var parser  = factory.createParser(json);

        var builder = new MapBuilder();
        var token = parser.nextToken();

        do {
            var currentName = parser.getCurrentName();

            switch(token) {
                case START_OBJECT:
                    builder.addObject(currentName);
                    break;
                case END_OBJECT:
                case END_ARRAY:
                    builder.back();
                    break;
                case START_ARRAY:
                    builder.addArray(currentName);
                    break;
                case VALUE_NULL:
                    builder.addValue(currentName, null);
                    break;
                case VALUE_TRUE:
                case VALUE_FALSE:
                    builder.addValue(currentName, parser.getBooleanValue());
                    break;
                case VALUE_STRING:
                    builder.addValue(currentName, parser.getText());
                    break;
                case VALUE_NUMBER_INT:
                    builder.addValue(currentName, parser.getBigIntegerValue());
                    break;
                case VALUE_NUMBER_FLOAT:
                    builder.addValue(currentName, parser.getDecimalValue());
                    break;
            }
            token = parser.nextToken();
        } while(!parser.isClosed());

        return builder.getRootMap();
    }
}
