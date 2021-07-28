package cn.vorbote.webdev;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ConfigurationInfo implements Serializable {

    /**
     * 签发人
     */
    private String issuer;

    /**
     * 密钥
     */
    private String secret;

}
