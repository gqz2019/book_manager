package com.gqz.service;

import com.gqz.pojo.OrderBook;

import java.util.List;

/**
 * <p>图书的销售接口</p>
 *
 * @author gqz20
 * @create 2021-06-03 19:06
 **/
public interface SalesService {
    Integer addOrder(OrderBook orderBook);

    List<OrderBook> getAllOrder();
}
