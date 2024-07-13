package hello.external;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;

import java.util.List;

@Slf4j
public class CommandLineV2 {

    public static void main(String[] args) {
        for (String arg : args) {
            log.info("arg {}", arg);
        }

        ApplicationArguments arguments = new DefaultApplicationArguments(args);
        log.info("SourceArgs={}", List.of(arguments.getSourceArgs())); // SourceArgs=[--url=A, --username=B, mode=on]
        log.info("NonOptionsArgs = {}", arguments.getNonOptionArgs()); // NonOptionsArgs = [mode=on]
        log.info("OptionsNames = {}", arguments.getOptionNames()); // OptionsNames = [url, username]

        for (String optionName : arguments.getOptionNames()) {
            log.info("option arg {}={}", optionName, arguments.getOptionValues(optionName));
            /*
                option arg url=[A]
                option arg username=[B]
             */
        }

        List<String> url = arguments.getOptionValues("url");
        List<String> username = arguments.getOptionValues("username");
        log.info("url={}", url);
        log.info("username={}", username);
    }
}
