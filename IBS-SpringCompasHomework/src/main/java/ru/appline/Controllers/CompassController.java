package ru.appline.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.appline.Logic.Compass;
import ru.appline.Logic.SideRange;
import java.util.Map;

@RestController
public class CompassController {

    private static Compass compass = null;

    @PostMapping(value = "/setup", consumes = "application/json", produces = "application/json")
    public String createPet(@RequestBody Map<String, String> sideRanges)
    {
        int counter = 0;
        SideRange[] array = new SideRange[8];
        for (Map.Entry<String, String> entry : sideRanges.entrySet()) {
            String[] numbers = entry.getValue().split("-");
            int number1 = Integer.parseInt(numbers[0]);
            int number2 = Integer.parseInt(numbers[1]);
            SideRange sideRange = new SideRange(entry.getKey(), number1, number2);
            array[counter] = sideRange;
            counter++;
        }
        compass = new Compass(array);
        return "Compass setup complete!";
    }

    @GetMapping(value = "/getSide", produces = "application/json")
    public ResponseEntity<String> getSide(@RequestBody Map<String, Integer> json)
    {
        if (compass == null) {
            return ResponseEntity.status(405).body("Compass do not setup!");
        }
        return ResponseEntity.status(200).body("Your side: "+compass.Side(json.get("side")));
    }
}
