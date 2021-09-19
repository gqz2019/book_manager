package com.gqz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @author gqz20
 * @TableName order
 */
@TableName(value ="orderBook")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderBook implements Serializable {
    /**
     * 订单ID
     */
    @TableId(type = IdType.AUTO,value = "id")
    private Integer id;

    /**
     * 卖出书的名字
     */
    @TableField(value = "book_name")
    private String bookName;

    /**
     * 卖出书的数量
     */
    @TableField(value = "book_num")
    private Integer bookNum;

    /**
     * 卖出书的总价格
     */
    @TableField(value = "sum_price")
    private Double sumPrice;

    /**
     * 交易时间
     */
    @TableField(value = "time")
    private LocalDateTime time;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public OrderBook(Integer id, int count) {
    }
}