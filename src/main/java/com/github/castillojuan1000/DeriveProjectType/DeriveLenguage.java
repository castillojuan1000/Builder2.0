package com.github.castillojuan1000.DeriveProjectType;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DeriveLenguage {
  public static void deriveLenguage(){
    try{
      String repoUrl = "https://api.github.com/repos/AuditDeploy/Builder";

      URL url = new URL(repoUrl);
      HttpURLConnection con = (HttpURLConnection) url.openConnection();
      con.setRequestMethod("GET");

      BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
      String inputLine;
      StringBuffer response = new StringBuffer();
      while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }
      in.close();

      ObjectMapper mapper = new ObjectMapper();
      JsonNode json = mapper.readTree(response.toString());
      String mainLanguage = json.get("language").asText();
      System.out.println("Main language of the repository is: " + mainLanguage);


    }catch (Exception e){
      System.out.println("Error: " + e.getMessage());
    }

  }
}
