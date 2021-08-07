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

    /**
     * Get Allowed Headers in String
     *
     * @return A string includes all allowed headers.
     */
    public String AllowedHeaders() {
        return toString(allowedHeaders);
    }

    /**
     * Get Exposed Headers in String
     *
     * @return A string includes all exposed headers.
     */
    public String ExposedHeaders() {
        return toString(exposedHeaders);
    }

    /**
     * Transfer lists in this instance to String.
     *
     * @return A string includes all headers.
     */
    private String toString(List<String> headers) {
        var builder = new StringBuilder();

        final var iterator = headers.iterator();
        while(iterator.hasNext()) {
            builder.append(iterator.next());
            if (iterator.hasNext()) {
                builder.append(",");
            }
        }

        return builder.toString();
    }
}
