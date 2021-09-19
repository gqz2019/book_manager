package com.gqz.start;

import com.gqz.pojo.Book;
import com.gqz.service.CURDBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * <p></p>
 *
 * @author gqz20
 * @create 2021-06-03 21:07
 **/
@Component
public class CURDUtils {
    @Autowired
    private CURDBookService curdBookService;

    public void a() {
        try {
            System.out.println("进入添加图书界面");
            Book book = new Book();
            System.out.println("请输入图书name");
            Scanner scanner = new Scanner(System.in);
            book.setBookName(scanner.nextLine());

            System.out.println("请输入图书出版社");
            book.setPressHome(scanner.nextLine());

            System.out.println("请输入图书的单价(单价要小数点后两位)");
            book.setBookPrice(scanner.nextDouble());

            System.out.println("请输入图书数量");
            book.setBookNum(scanner.nextInt());

            int i = curdBookService.addBook(book);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("添加失败!请重试");
        }
    }

    public void b() {
        try {
            System.out.println("进入删除图书界面");
            Scanner scanner = new Scanner(System.in);
            curdBookService.deleteBook(scanner.nextLine());
            System.out.println("删除失败");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("删除失败");
        }
    }

    public void c() {
        try {
            System.out.println("进入更改图书界面");
            System.out.println("请输入图书ID");
            Scanner scanner = new Scanner(System.in);
            Book book = new Book();

            book.setId(scanner.nextInt());

            System.out.println("请输入图书name");
            book.setBookName(scanner.nextLine());

            System.out.println("请输入图书出版社");
            book.setPressHome(scanner.nextLine());

            System.out.println("请输入图书的单价(单价要小数点后两位)");
            book.setBookPrice(scanner.nextDouble());

            System.out.println("请输入图书数量");
            book.setBookNum(scanner.nextInt());
            System.out.println("更新成功");

            curdBookService.updateBook(book);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("更新失败");

        }
    }

    public   void d() {
        try {
            System.out.println("进入查找图书界面");
            System.out.println("输入查找图书的ID");
            Scanner scanner = new Scanner(System.in);
//            Book book = new Book();
//            book.setId(scanner.nextInt());

            Book book1 = curdBookService.findBook(scanner.nextInt());
            System.out.println(book1);
            System.out.println("查找成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("查找失败");
        }
    }
}
