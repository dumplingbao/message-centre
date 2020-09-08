package com.dumplingbao.message.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author: dumplingbao
 * @Date: 2020/9/7 18:25
 */
@Document("ApplicationInfo")
@Data
public class ApplicationInfo {

    @Id
    private String id;
    /**
     * appKey
     */
    private String appKey;
    /**
     * app名称
     */
    private String name;
    /**
     * app编号
     */
    private String code;

}
