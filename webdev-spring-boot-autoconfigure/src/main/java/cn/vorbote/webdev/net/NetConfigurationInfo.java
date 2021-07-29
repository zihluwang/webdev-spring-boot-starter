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

    public String AllowedHeadersToString() {
        StringBuilder builder = new StringBuilder();

        final var iter = allowedHeaders.iterator();
        for (String allowedHeader : allowedHeaders) {
            iter.next();
            builder.append(allowedHeader);
            if (iter.hasNext()) {
                builder.append(",");
            }
        }

        return builder.toString();
    }

    public String ExposedHeadersToString() {
        StringBuilder builder = new StringBuilder();

        final var iter = allowedHeaders.iterator();
        for (String allowedHeader : allowedHeaders) {
            iter.next();
            builder.append(allowedHeader);
            if (iter.hasNext()) {
                builder.append(",");
            }
        }

        return builder.toString();
    }
}
