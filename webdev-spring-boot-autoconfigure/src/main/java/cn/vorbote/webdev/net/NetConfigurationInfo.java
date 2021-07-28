package cn.vorbote.webdev.net;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * This is the configuration info class.
 *
 * @author vorbote thills@vorbote.cn
 */
@Data
@Builder
public class NetConfigurationInfo implements Serializable {

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
