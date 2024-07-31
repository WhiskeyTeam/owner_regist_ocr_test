package dev.doka.regist;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
@CrossOrigin(origins = "*")
public class TestController {

    @PostMapping("/test")
    @ResponseBody
    public ResponseEntity<?> registTest(@RequestBody String results){

        System.out.println("results = " + results);


        String resultJava = "";

        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode jsonNode = mapper.readTree(results);
            String bSttCd = jsonNode.get("b_stt_cd").asText();
            resultJava = bSttCd;

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(Map.of("resultJava", resultJava));
    }
}
