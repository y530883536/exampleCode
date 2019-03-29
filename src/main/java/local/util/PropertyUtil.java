package local.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PropertyUtil {

    public static <S, T> void batchSetPropertyFor(List<S> source, List<T> target) {
        for (int i = 0; i < source.size(); i++) {
            setPropertyFor(source.get(i), target.get(i));
        }
    }

    public static <S, T> void setPropertyFor(S source, T target) {
        Class sourceClz = source.getClass();
        Class targetClz = target.getClass();

        Map<String, Field> sourceFieldMap = getPropertyFields(sourceClz);
        Map<String, Field> targetFieldMap = getPropertyFields(targetClz);

        for (String fieldName : sourceFieldMap.keySet()) {
            boolean containsKey = targetFieldMap.containsKey(fieldName);
            if (containsKey) {
                Field sourceField = sourceFieldMap.get(fieldName);
                Field targetField = targetFieldMap.get(fieldName);
                boolean assignableFrom = targetField.getType().isAssignableFrom(sourceField.getType());
                if (assignableFrom) {
                    // Field.get 会抛 IllegalAccessException（checked ex）
                    try {
                        targetField.set(target, sourceField.get(source));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(sourceClz.getName() + " 获取属性 " + sourceField.getName() + " 异常");
                    }
                }
            }
        }

    }

    public static Map<String, Field> getPropertyFields(Class<?> o1clz) {
        Map<String, Field> map = new HashMap<>();
        for (Field f : o1clz.getDeclaredFields()) {
            f.setAccessible(true);
            map.put(f.getName(), f);
        }
        return map;
    }

}
