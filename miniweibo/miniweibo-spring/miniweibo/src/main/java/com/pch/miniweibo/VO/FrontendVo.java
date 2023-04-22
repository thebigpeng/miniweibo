package com.pch.miniweibo.VO;

import com.pch.miniweibo.entity.FrontendMenuTable;
import com.pch.miniweibo.entity.RoleFrontendMenuTable;
import lombok.Data;

/**
 * @className: FrontendVo
 * @description: TODO 类描述
 * @author: pengchenhui
 * @date: 2023/4/20
 */
@Data
public class FrontendVo extends FrontendMenuTable {
    String parentName;

}
