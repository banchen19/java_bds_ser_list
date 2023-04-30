package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class File_Json {
    //首次创建初始化json文件
    static String filePath = "./config.json";

    static void creat_file_json() {
// 创建一个新的json对象，包含服务器的相关信息
        JsonObject serverObject = new JsonObject();
        serverObject.addProperty("name", "填写服务器别名");
        serverObject.addProperty("IP", "填写服务器IP地址");
        serverObject.addProperty("port", "填写服务器端口");
        serverObject.addProperty("path", "填写bds服务器端地址，绝对地址");
// 创建一个json对象来存储所有的服务器数据
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("server", serverObject);

        try (BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(jsonObject, fileWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param filePath json的文件路径
     * @return 返回JsonObject类型
     * @throws IOException
     */
    static void read_file_json(String filePath) throws IOException {
        JsonObject jsonObject = null;
        BufferedReader br = new BufferedReader(
                new InputStreamReader(Files.newInputStream(Paths.get(filePath)), StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        JsonParser parser = new JsonParser();
        jsonObject = parser.parse(sb.toString()).getAsJsonObject();
        BDS_List.getInstance().setFromList(file_to_json(jsonObject));
    }

    /**
     * @param jsonObject 解析json
     * @return List<Form>
     */
    static List<From> file_to_json(JsonObject jsonObject) {
        List<From> formList = new ArrayList<>(); // create a new list
        int id = 0;
        for (String key : jsonObject.keySet()) {
            JsonObject itemObject = jsonObject.getAsJsonObject(key);
            String name = itemObject.get("name").getAsString();
            String IP = itemObject.get("IP").getAsString();
            int port = itemObject.get("port").getAsInt();
            String path = itemObject.get("path").getAsString();
            // 处理物品数据值
            From form = new From(id, key, name, IP, port, path);
            formList.add(form);
            id++;
        }
        return formList;
    }
}
