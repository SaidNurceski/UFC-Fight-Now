package org.example.entity;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.repository.exceptions.FileReadException;

public class FighterJSON {
    static Fighter[] readFromJSON(){
        Path path = Paths.get(System.getProperty("user.dir"));
        Path filePath = Paths.get(path.toString(), "data","fighter.json");

        File file = new File(filePath.toString());

        Fighter[] fighters ;

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            fighters = objectMapper.readValue(file, Fighter[].class);
            System.out.println(fighters.toString());
            return fighters;


        } catch (Exception e) {
           e.printStackTrace();
        }
        return null;


    }
}
