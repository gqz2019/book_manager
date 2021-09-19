package com.gqz.service.impl;

import com.gqz.mapper.OrderMapper;
import com.gqz.pojo.OrderBook;
import com.gqz.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>实现类</p>
 *
 * @author gqz20
 * @create 2021-06-03 19:09
 **/
@Service
public class SalesServiceImpl implements SalesService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Integer addOrder(OrderBook orderBook) {
        int insert = orderMapper.insert(orderBook);
//        return orderMapper.updateById(order);
        return insert;
    }

    @Override
    public List<OrderBook> getAllOrder() {
        return orderMapper.selectList(null);
    }
}

