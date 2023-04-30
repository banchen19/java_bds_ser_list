package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import static org.example.File_Json.*;

public class Main {
    private static List<From> from_list;

    public static void main(String[] args) {
        System.out.println("正在初始化");
            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("正在创建配置文件：" + filePath);
                creat_file_json();
                System.out.println("初始化config.json配置文件完成");
            }else {
                System.out.println("检测配置文件，正在读取...");
                try {
                    read_file_json(filePath);
                    from_list=BDS_List.getInstance().getFromList();
                    for (From from: from_list)
                    {
                        System.out.println("检测到可使用配置端："+from.getKey());
                        String path = from.getPath(); // exe文件路径
                        //读取端口号并做验证
                        int prot=from.getPort();
                        FileInputStream fileInputStream=new FileInputStream(path+"server.properties");
                        Properties properties = new Properties();
                        properties.load(fileInputStream);
                        int serverPort = Integer.parseInt(properties.getProperty("server-port"));
                        if(prot==serverPort) {
                            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "start", from.getName());
                            builder.directory(new File(path));
                            builder.start(); // 启动exe文件
                            System.out.println(from.getKey() + ":" + path + "启动成功");
                        }else {
                            System.out.println(from.getKey() + ":" +"端口号不匹配");
                        }
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    throw new RuntimeException(e);
                }
            }
    }
}