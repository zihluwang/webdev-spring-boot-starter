package cn.vorbote.webdev;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "vorbote.web-dev")
public class WebdevProperties {

    private String issuer;

    private String secret;

}
