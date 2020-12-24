package animals;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;

public class Utils {
    //static String path = "C:\\Java_lessons\\Guess the Animal\\";
    static String path = "";

    public static void saveToJson(Node root) {
        String fileName = path + L10in.fileJ();
        ObjectMapper objectMapper = new JsonMapper();
        try {
            objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValue(new File(fileName), root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveToJson2(Node root) {
        ObjectMapper objectMapper = new JsonMapper();
        try {
            objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValue(new File("C:\\Java_lessons\\Guess the Animal\\animals2.json"), root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Node loadFromJson() {
        String fileName = path + L10in.fileJ();
        if (!new File(fileName).exists()) return null;
        ObjectMapper objectMapper = new JsonMapper();
        Node root = null;
        try {
            root = objectMapper
                    .readValue(new File(fileName), Node.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }

    public static void saveToXml(Node root) {
        String fileName = path + L10in.fileX();
        ObjectMapper objectMapper = new XmlMapper();
        try {
            objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValue(new File(fileName), root);

            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
                    .writerWithDefaultPrettyPrinter()
                    .writeValue(new File("C:\\Java_lessons\\Guess the Animal\\" + fileName), root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Node loadFromXml() {
        String fileName = path + L10in.fileX();
        if (!new File(fileName).exists()) return null;
        ObjectMapper objectMapper = new XmlMapper();
        Node root = null;
        try {
            root = objectMapper
                    .readValue(new File(fileName), Node.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }

    public static void saveToYaml(Node root) {
        String fileName = path + L10in.fileY();
        ObjectMapper objectMapper = new YAMLMapper();
        try {
            objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValue(new File(fileName), root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Node loadFromYaml() {
        String fileName = path + L10in.fileY();
        if (!new File(fileName).exists()) return null;
        ObjectMapper objectMapper = new YAMLMapper();
        Node root = null;
        try {
            root = objectMapper
                    .readValue(new File(fileName), Node.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }
}
