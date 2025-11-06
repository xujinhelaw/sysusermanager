package com.unity.authentication.manager.filter;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * HttpPostWithoutContentType为测试类，用于模拟通过HttpURLConnection发起post请求
 * 请求体为xml格式，"Content-Type"故意不设置
 * 使用方法：直接执行当前类即可
 */
public class HttpPostWithoutContentType {

    public static void main(String[] args) {
        // 目标 URL（测试用）
        String urlString = "http://127.0.0.1:8088/xm/user";  // 可查看实际请求内容

        // 要发送的 XML 数据
        String xmlData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<order>\n" +
                "  <orderId>1001</orderId>\n" +
                "  <product>笔记本电脑</product>\n" +
                "  <amount>1</amount>\n" +
                "</order>";

        HttpURLConnection connection = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        StringBuilder response = new StringBuilder();

        try {
            // 1. 创建 URL 对象
            URL url = new URL(urlString);

            // 2. 打开连接
            connection = (HttpURLConnection) url.openConnection();

            // 3. 设置请求方法为 POST
            connection.setRequestMethod("POST");

            // 4. 允许写入请求体
            connection.setDoOutput(true);

            // 5. 允许读取响应
            connection.setDoInput(true);

            // ⚠️ 注意：这里没有设置 Content-Type！
            // connection.setRequestProperty("Content-Type", "application/xml");  // 不要这行！

            // 6. 获取输出流并写入 XML 数据
            outputStream = connection.getOutputStream();
            byte[] xmlBytes = xmlData.getBytes("UTF-8");
            outputStream.write(xmlBytes);  // 写入原始字节
            outputStream.flush();          // 确保数据写出

            // 7. 获取响应码
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // 8. 读取响应内容（成功或失败都尝试读）
            if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED) {
                inputStream = connection.getInputStream();
            } else {
                inputStream = connection.getErrorStream(); // 处理错误响应
            }

            if (inputStream != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line).append("\n");
                }
                reader.close();
            }

            System.out.println("Server Response:\n" + response.toString());

        } catch (Exception e) {
            System.err.println("Error during HTTP request: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect(); // 断开连接
            }
        }
    }
}
