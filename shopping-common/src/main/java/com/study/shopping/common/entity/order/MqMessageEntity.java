package com.study.shopping.common.entity.order;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 */
@Data
@TableName("mq_message")
public class MqMessageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String messageId;
	/**
	 * 
	 */
	private String content;
	/**
	 * 
	 */
	private String toExchane;
	/**
	 * 
	 */
	private String routingKey;
	/**
	 * 
	 */
	private String classType;
	/**
	 * 0-新建 1-已发送 2-错误抵达 3-已抵达
	 */
	private Integer messageStatus;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private Date updateTime;

}
