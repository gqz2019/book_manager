package com.gqz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 
 * @author gqz20
 * @TableName books
 */
@TableName(value ="books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 书名
     */
    @TableField(value = "book_name")
    private String bookName;

    /**
     * 出版社
     */
    @TableField(value = "press_home")
    private String pressHome;

    /**
     * 单价
     */
    @TableField(value = "book_price")
    private Double bookPrice;

    /**
     * 库存数量
     */
    @TableField(value = "book_num")
    private Integer bookNum;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public Book(Integer id) {
    }

    public Book(Integer id, String bookName, String pressHome, Double bookPrice, int i) {
    }

}