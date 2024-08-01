package dev.doka.regist;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.UUID;


@RestController
@CrossOrigin(origins = "*")
public class TestController {


    @PostMapping("/test")
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






    // 저는 포기합니다. 일단 오늘은 못함 (2024-07-31)

//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
//
//        String apiURL = "https://clovaocr-api-kr.ncloud.com/external/v1/32965/ae43fa0909815a39a619576aff03b94bee51207695cf6066e9bf13e609f28081";
//        String secretKey = "aWlwY2NUcklodXFOb0FjUXF6bm1UYWJEV2xnU0FoSWg=";
//
//        try {
//            URL url = new URL(apiURL);
//            HttpURLConnection con = (HttpURLConnection) url.openConnection();
//            con.setUseCaches(false);
//            con.setDoInput(true);
//            con.setDoOutput(true);
//            con.setReadTimeout(30000);
//            con.setRequestMethod("POST");
//            String boundary = "----" + UUID.randomUUID().toString().replaceAll("-", "");
//            con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
//            con.setRequestProperty("X-OCR-SECRET", secretKey);
//
//            // Prepare JSON data
//            String jsonMessage = "{\"version\":\"V2\",\"requestId\":\"" + UUID.randomUUID().toString() + "\",\"timestamp\":" + System.currentTimeMillis() + ",\"images\":[{\"format\":\"jpg\",\"name\":\"demo\"}]}";
//
//            con.connect();
//            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
//                writeMultiPart(wr, jsonMessage, file, boundary);
//            }
//
//            int responseCode = con.getResponseCode();
//            BufferedReader br;
//            if (responseCode == 200) {
//                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
//            } else {
//                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
//            }
//            StringBuilder response = new StringBuilder();
//            String inputLine;
//            while ((inputLine = br.readLine()) != null) {
//                response.append(inputLine);
//            }
//            br.close();
//
//            return new ResponseEntity<>(response.toString(), HttpStatus.valueOf(responseCode));
//        } catch (Exception e) {
//            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }



//    private void writeMultiPart(OutputStream out, String jsonMessage, MultipartFile file, String boundary) throws IOException {
//        StringBuilder sb = new StringBuilder();
//        sb.append("--").append(boundary).append("\r\n");
//        sb.append("Content-Disposition:form-data; name=\"message\"\r\n\r\n");
//        sb.append(jsonMessage);
//        sb.append("\r\n");
//
//        out.write(sb.toString().getBytes("UTF-8"));
//        out.flush();
//
//        if (file != null && !file.isEmpty()) {
//            out.write(("--" + boundary + "\r\n").getBytes("UTF-8"));
//            StringBuilder fileString = new StringBuilder();
//            fileString.append("Content-Disposition:form-data; name=\"file\"; filename=\"")
//                    .append(file.getOriginalFilename())
//                    .append("\"\r\n");
//            fileString.append("Content-Type: ").append(file.getContentType()).append("\r\n\r\n");
//            out.write(fileString.toString().getBytes("UTF-8"));
//            out.flush();
//
//            try (InputStream fis = file.getInputStream()) {
//                byte[] buffer = new byte[8192];
//                int count;
//                while ((count = fis.read(buffer)) != -1) {
//                    out.write(buffer, 0, count);
//                }
//                out.write("\r\n".getBytes());
//            }
//
//            out.write(("--" + boundary + "--\r\n").getBytes("UTF-8"));
//        }
//        out.flush();
//    }

}
