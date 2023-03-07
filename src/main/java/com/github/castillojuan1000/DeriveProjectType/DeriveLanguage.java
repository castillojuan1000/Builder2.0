package com.github.castillojuan1000.DeriveProjectType;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeriveLanguage {
  public static String deriveLanguage(){
    try{
      String buildRepo = System.getProperty("REPO_URL");
      //get repo userName and project name
      String regex = "github.com/(.*)/(.*)";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(buildRepo);

      String username = null;
      String repoName = null;

      if (matcher.find()) {
        username = matcher.group(1);
        repoName = matcher.group(2);
      }

      //create a GitHub API to fetch project main language
      String repoUrl = "https://api.github.com/repos/{userName}/{repo}";
      repoUrl = repoUrl.replace("{userName}", username).replace("{repo}",repoName);


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

      return mainLanguage;


    }catch (Exception e){
      System.out.println("Error: " + e.getMessage());
    }

    return null;
  }
}
