package com.judy.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

/**
 * 데이터 관련
 */
public class DataUtils {

    /**
     * VO getter 호출
     * @param item VO 객체
     * @param key  getter 호출할 멤버변수명
     */
    public <T> Object getValue(T item, String key) {
        Object result = null;
        try {
            Class<?> clazz = item.getClass();
            String getter = "get" + key.substring(0, 1).toUpperCase() + key.substring(1);
            Method getterMethod = clazz.getMethod(getter);
            result = getterMethod.invoke(item);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * array data to tree
     * @param list      전체 리스트
     * @param uniqueKey PK 명
     * @param parentKey 부모PK 명
     */
    public <T> List<Map<String, Object>> arrayToTreeData(List<T> list, String uniqueKey, String parentKey) {
        List<Map<String, Object>> treeData = new ArrayList<>();

        // root인 요소의 uniqueKey값들
        Set<String> rootValue = list.stream().filter(v -> StringUtils.isEmpty((String) getValue(v, parentKey))).map(v -> (String) getValue(v, uniqueKey)).collect(Collectors.toSet());

        for (T item : list) {
            String uniqueValue = (String) getValue(item, uniqueKey);

            if (rootValue.contains(uniqueValue)) {
                Map<String, Object> rootNode = new HashMap<>();
                // VO에 정의된 전체 멤버변수 접근
                for (Field f : item.getClass().getDeclaredFields()) {
                    f.setAccessible(true);
                    try {
                        Object v = f.get(item);
                        if (v != null && !StringUtils.isEmpty((String) v)) {
                            rootNode.put(f.getName(), v);
                        }
                    } catch (Exception e) {
                        System.out.println("........... [arrayToTreeData] Fail to access field : " + f.getName());
                    }
                }   // END for

                rootNode.put("children", arrayToTreeRecursive(list, uniqueKey, parentKey, uniqueValue));
                rootNode.put(uniqueKey, uniqueValue);
                treeData.add(rootNode);
            }   // END if

        }   // END for

        return treeData;
    }   // END

    /**
     * 자식노드 찾는 재귀함수
     * @param list      전체 리스트
     * @param uniqueKey PK 명
     * @param parentKey 부모PK 명
     * @param parentVal 부모PK 값
     */
    private <T> List<Map<String, Object>> arrayToTreeRecursive(List<T> list, String uniqueKey, String parentKey, Object parentVal) {
        List<Map<String, Object>> result = new ArrayList<>();
        List<T> subList = list.stream().filter(v -> getValue(v, parentKey).equals(parentVal)).collect(Collectors.toList());

        for (T sub : subList) {
            String uniqueValue = (String) getValue(sub, uniqueKey);
            List<Map<String, Object>> children = arrayToTreeRecursive(list, uniqueKey, parentKey, uniqueValue);

            Map<String, Object> obj = new HashMap<>();
            // VO에 정의된 전체 멤버변수 접근
            for (Field f : sub.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                try {
                    Object v = f.get(sub);
                    if (v != null && !StringUtils.isEmpty((String) v)) {
                        obj.put(f.getName(), v);
                    }
                } catch (Exception e) {
                    System.out.println("........... [arrayToTreeRecursive] Fail to access field : {}" + f.getName());
                }
            }   // END for

            obj.put("children", children);

            result.add(obj);

        }   // END for

        return result;
    }


}
