package com.unity.authentication.manager.dao.provider;

public class UserSqlProvider {
    public String queryUsersByUserIds(String userIds) {
        String[] userIdArray = userIds.split(",");
        StringBuilder batchSelectBuilder = new StringBuilder();
        batchSelectBuilder.append("select * from user where id in (");
        for (int index = 0; index < userIdArray.length; index++) {
            batchSelectBuilder.append(userIdArray[index]);
            if (index != userIdArray.length - 1) {
                batchSelectBuilder.append(",");
            }
        }
        batchSelectBuilder.append(");");
        return batchSelectBuilder.toString();
    }
}
