package com.gqz.start;

import com.gqz.pojo.Book;
import com.gqz.pojo.OrderBook;
import com.gqz.service.CURDBookService;
import com.gqz.service.SalesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

/**
 * <p></p>
 *
 * @author gqz20
 * @create 2021-06-03 22:35
 **/
@Slf4j
public class Sales {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");

        context.start();
        SalesService salesService = (SalesService) context.getBean("salesServiceImpl");

        CURDBookService curdBookService = (CURDBookService) context.getBean("CURDBookServiceImpl");

        Scanner scanner = new Scanner(System.in);
        System.out.println("  售货请输入  ：1  查看历史订单输入  ：2 退出系统输入  ：0");
        String op = scanner.nextLine();


        /*
          直到用户输入0结束
         */
        while (!op.equals(0)) {
            System.out.println("  售货请输入  ：1  查看历史订单输入  ：2 退出系统输入  ：0");
            switch (op) {
                case "1": {

                    System.out.println("请输入书籍id");
                    Integer id = scanner.nextInt();
                    System.out.println("请输入售货数量：");
                    int count = scanner.nextInt();

                    Book bookById = curdBookService.findBook(id);

                    if (bookById.getBookNum() >= count) {
                        OrderBook orderBook = new OrderBook(bookById.getId(), bookById.getBookName(), count, bookById.getBookPrice() * count, LocalDateTime.now());
                        orderBook.setId(null);
                        log.info(orderBook.toString());
                        salesService.addOrder(orderBook);

                        bookById.setBookNum(bookById.getBookNum()-count);
                        curdBookService.updateBook(bookById);
                    } else {
                        System.out.println("销售失败，数量不足！");
                    }

                    break;
                }
                case "2":
                    List<OrderBook> allOrderBook = salesService.getAllOrder();
                    allOrderBook.forEach(System.out::println);
                    break;
                case "0":
                    continue;
                default:
                    System.out.println("错误");
            }
//            System.out.println("进货请输入：1   售货请输入：2  查看书籍仓库输入：3  查看历史订单输入：4 退出系统输入： 0");
            op = scanner.nextLine();
        }


    }
}
