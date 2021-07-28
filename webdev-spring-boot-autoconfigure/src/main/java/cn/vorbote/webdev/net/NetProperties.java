package cn.vorbote.webdev.net;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * This is the configuration info properties class.
 *
 * @author vorbote thills@vorbote.cn
 */
@Data
@ConfigurationProperties(prefix = "vorbote.web-dev.net")
public class NetProperties {

    /**
     * The key of the token.
     */
    private String tokenKey;

    /**
     * Headers which are allowed to be used in request header.
     */
    private String allowedHeaders;

    /**
     * Headers which are allowed to be used in request header.
     */
    private String exposedHeaders;

}
