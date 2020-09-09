package com.zhangnx.tools.utils;

import com.sun.istack.internal.Nullable;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public class O {

    public static boolean isEmpty(@Nullable Object obj){
        if (obj == null) {
            return true;
        } else if (obj instanceof Optional) {
            return !((Optional)obj).isPresent();
        } else if (obj instanceof CharSequence) {
            return ((CharSequence)obj).length() == 0;
        } else if (obj.getClass().isArray()) {
            return Array.getLength(obj) == 0;
        } else if (obj instanceof Collection) {
            return ((Collection)obj).isEmpty();
        } else {
            return obj instanceof Map ? ((Map)obj).isEmpty() : false;
        }
    }

    public static boolean isNotEmpty(@Nullable Object obj){
        return !O.isEmpty(obj);
    }

    public static boolean isBlank(@Nullable final CharSequence cs) {
        return StringUtils.isBlank(cs);
    }
    public static boolean isNotBlank(@Nullable final CharSequence cs) {
        return !O.isBlank(cs);
    }


}
