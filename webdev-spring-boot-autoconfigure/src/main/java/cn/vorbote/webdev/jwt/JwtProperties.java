package cn.vorbote.webdev.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * This is the configuration info properties class.
 *
 * @author vorbote thills@vorbote.cn
 */
@Data
@ConfigurationProperties(prefix = "vorbote.web-dev.jwt")
public class JwtProperties {

    /**
     * The issuer of jwt.
     */
    private String issuer;

    /**
     * The secret to use in jwt.
     */
    private String secret;

}
