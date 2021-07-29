package cn.vorbote.webdev.net;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

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
    private List<String> allowedHeaders;

    /**
     * Headers which are allowed to be used in request header.
     */
    private List<String> exposedHeaders;

    public String AllowedHeaders() {
        return getString(allowedHeaders);
    }

    public String ExposedHeaders() {
        return getString(exposedHeaders);
    }

    private String getString(List<String> headers) {
        var builder = new StringBuilder();

        final var iter = headers.iterator();
        for (String exposedHeader : headers) {
            iter.next();
            builder.append(exposedHeader);
            if (iter.hasNext()) {
                builder.append(",");
            }
        }

        return builder.toString();
    }
}
