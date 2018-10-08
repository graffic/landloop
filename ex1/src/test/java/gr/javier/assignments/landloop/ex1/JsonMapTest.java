package gr.javier.assignments.landloop.ex1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class JsonMapTest {
    InputStream json;

    @Before
    public void setUp() {
        json = this.getClass()
                .getClassLoader()
                .getResourceAsStream("fixture1.json");
    }

    @Test
    public void toMap() throws IOException {
        var res = JsonMap.toMap(json);

        var coordinates = Map.of("lat", BigInteger.valueOf(51), "lon", BigInteger.ZERO);
        var address = Map.of("country", "UK",
                "postcode", "W1 5AX",
                "coordinates", coordinates,
                "first", "12 Watergarden",
                "second", "Kings Cross");
        var payments = List.of(
                Map.of("amount", BigDecimal.valueOf(100.59), "timestamp", "ISO_DATE"),
                Map.of("amount", BigDecimal.valueOf(12.99), "timestamp", "ISO_DATE"));
        var expected = new HashMap<>(Map.of(
                "address", address,
                "payments", payments,
                "name", "Alex Smith",
                "id", BigInteger.valueOf(10001)));
        expected.put("potato", null);

        assertEquals(expected, res);
    }
}