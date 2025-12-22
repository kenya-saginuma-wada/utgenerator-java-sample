package com.example.legacy;

import com.example.legacy.util.StringUtil;

/**
 * Service referring to source in a separate folder (package)
 */
public class MessageService {

    public String formatMessage(String prefix, String body) {
        if (StringUtil.isEmpty(body)) {
            return "";
        }

        String cleanPrefix = StringUtil.isEmpty(prefix) ? "MSG" : StringUtil.toUpperCase(prefix);
        String truncatedBody = StringUtil.truncate(body, 100);

        return cleanPrefix + ": " + truncatedBody;
    }
}
