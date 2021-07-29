package cn.vorbote.webdev.net;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Iterator;
import java.util.List;

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
    private List<String> allowedHeaders;

    /**
     * Headers which are allowed to be used in request header.
     */
    private List<String> exposedHeaders;
}
