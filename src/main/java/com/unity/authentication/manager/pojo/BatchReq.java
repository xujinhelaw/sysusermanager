package com.unity.authentication.manager.pojo;

import com.unity.authentication.manager.common.verification.ErrorCodeConstant;
import com.unity.authentication.manager.common.verification.annotation.UserIdsSize;
import lombok.Data;

@Data
public class BatchReq {
    @UserIdsSize(max = 2,message = ErrorCodeConstant.USER_ID_OVER_SIZE)
    private String userIds;
}
