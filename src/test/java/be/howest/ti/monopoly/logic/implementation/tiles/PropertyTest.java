package be.howest.ti.monopoly.logic.implementation.tiles;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PropertyTest {
    @Test
    void JSONContainsAllFields()
    {
        Property p = new Property("test", 0, "street", 1, 2);
        ObjectMapper json = new ObjectMapper();

        try {
            String txt = json.writeValueAsString(p);
            List<String> expectedJSONProperties = List.of(
                    "name",
                    "position",
                    "type",
                    "cost",
                    "mortgage"
            );
            for (String property: expectedJSONProperties)
            {
                assertTrue(txt.contains(property));
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }



    }
}