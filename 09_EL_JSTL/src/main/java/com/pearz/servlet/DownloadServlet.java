package com.pearz.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 20:21 2021/12/15
 */
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1，获取要下载的文件名
        String downloadFileName = "a.jpg";
        //2、读取要下载的文件内容(通过ServletContent对象可以读取)
        ServletContext servletContext = getServletContext();

        //获取要下载的文件类型
        String mimeType = servletContext.getMimeType("/file/" + downloadFileName);
        System.out.println("下载的文件类型:" + mimeType);
        //4、在回传前，通过响应头告诉客户端返回的数据类型
        resp.setContentType(mimeType);
        //5，还要告诉客户端收到的数据是用于下载使用(还是使用响应头)
        //content-Disposition响应头，表示收到的数据怎么处理
        //attachment表示附件，表示下载使用
        //filename=表示指定下载的文件名
        //resp.setHeader("Content-Disposition", "attachment; filename=" + downloadFileName);

        //当filename有中文时，会乱码
        //resp.setHeader("Content-Disposition", "attachment; filename=中国.jpg");

        //url编码是把汉字转换成%xx%xx的格式
        resp.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("中国.jpg", "UTF-8"));


        //3，把下载的文件内容回传给客户端
        InputStream inputStream = servletContext.getResourceAsStream("/file/" + downloadFileName);
        //获得响应的输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        //读取输入流中全部的数据,复制给输出流,输出给客户端
        IOUtils.copy(inputStream, outputStream);
    }
}
