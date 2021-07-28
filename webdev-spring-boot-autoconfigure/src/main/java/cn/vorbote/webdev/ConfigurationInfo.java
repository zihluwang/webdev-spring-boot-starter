package cn.vorbote.webdev;

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
public class ConfigurationInfo implements Serializable {

    /**
     * The issuer of jwt.
     */
    private String issuer;

    /**
     * The secret to use in jwt.
     */
    private String secret;

}
