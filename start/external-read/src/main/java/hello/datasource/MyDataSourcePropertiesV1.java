package hello.datasource;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
@ConfigurationProperties("my.datasource")   // properties 파일의 my.datasource key 를 읽어들인다 즉 외부 설정을 주입 받는 객체.
public class MyDataSourcePropertiesV1 {

    private String url;
    private String username;
    private String password;
    private Etc etc;

    // etc
    @Data
    public static class Etc {
        private int maxConnection;
        private Duration timeout;
        private List<String> options = new ArrayList<>();
    }
}
