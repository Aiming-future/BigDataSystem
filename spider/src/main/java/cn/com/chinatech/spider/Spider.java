package cn.com.chinatech.spider;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.security.provider.ConfigFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Spider {

    private static Logger logger = LoggerFactory.getLogger(Spider.class);
    private static int curPage=0;
    private String REQ_URL0 = "https://www.liepin.com/zhaopin/?compkind=&dqs=&pubTime=&pageSize=40&salary=&compTag=&sortFlag=&degradeFlag=0&compIds=&subIndustry=&jobKind=&industries=&compscale=&key=%E8%BD%AF%E4%BB%B6%E5%B7%A5%E7%A8%8B&siTag=PDhmxMRUA-XhVlA-4jw3mg%7EfA9rXquZc5IkJpXC-Ycixw&d_sfrom=search_fp&d_ckId=bde4ea9558d9885975e1d8dbfbb7c3b7&d_curPage=0&d_pageSize=40&d_headId=bde4ea9558d9885975e1d8dbfbb7c3b7&curPage=";

    @Test
    public void requestData(){
        String REQ_URL= REQ_URL0+curPage;
        // 1. 创建HttpClient对象，相当于浏览器
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        // 2. 创建http请求对象，HttpGet对象，封装http请求数据
        HttpGet httpGet = new HttpGet(REQ_URL);

        // 3. 设置http请求客户端类型
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_3) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.5 Safari/605.1.15");
        httpGet.setHeader("accept-language", "zh-CN");
        // 4. 声明response变量用于封装响应数据内容
        CloseableHttpResponse response = null;

        try {
            response = httpClient.execute(httpGet);


            // 5. 获取响应状态行的信息
            StatusLine statusLine = response.getStatusLine();
            if(statusLine.getStatusCode() != 200){
                return;
            }
            // 6. 获取响应体中的数据
            HttpEntity httpEntity = response.getEntity();
            // 7. 进行响应数据的格式转换
            String content = EntityUtils.toString(httpEntity,"utf-8");
            // 8. 数据抽取

            parseHtml(content);

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(response != null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void parseHtml(String content) {
        // 1. 使用jsoup封装响应数据为Document对象
        Document document = Jsoup.parse(content);
        // 2. 使用jsoup API实现页面解析（数据抽取）
        Elements elements =  document.select("div.sojob-item-main.clearfix");
        // 3. 解析数据
        for(Element item : elements){
//            String movieName = item.select("div.hd > a > span").first().html();
//            String score = item.select("div.star > span.rating_num").html();
//            String number = item.select("div.star > span").last().html();
//            String director=item.select("div.bd > p").html();

            String jobName=item.select("div.job-info > h3 > a").html();
            String money=item.select("div.job-info >p > span.text-warning").html();
            String region=item.select("div.job-info >p > a").html();
            String degree=item.select("div.job-info >p > span.edu").html();
            String comName=item.select("div.company-info.nohover > p.company-name > a").html();
            String type=item.select("div.company-info.nohover > p.field-financing > span").html();
            String date=item.select("div.job-info > p.time-info > time").html();

            // 4. 数据简单处理
//            Pattern pattern = Pattern.compile("\\d*");
//            Matcher matcher = pattern.matcher(number);
//            number = matcher.find() ? matcher.group() : "0";
//
//            StringBuilder stringBuilder = new StringBuilder();
//            stringBuilder.append(movieName).append("\t").append(score).append("\t").append(number).append(director);
//            logger.info(stringBuilder.toString());
            jobName= jobName.substring(0,jobName.indexOf("师")+1);
            if(money.indexOf("·")>0)
            money=money.substring(0,money.indexOf("·"));
            if(region.length()>2)
            region=region.substring(0,2);
            String reg = "[^\u4e00-\u9fa5]";
            type = type.replaceAll(reg, "");

            //写入mysql的job_wanted表
            Connection conn=null;
            PreparedStatement psql = null;
            JDBC_Connection jdbc_connection=new JDBC_Connection();
            try {
                 conn=jdbc_connection.getConnection();
                //预处理添加数据

                psql = conn.prepareStatement("insert into job_wanted (jobName,money,region,degree,comName,type,date) "

                        + "values(?,?,?,?,?,?,?)");

                psql.setString(1, jobName);
                psql.setString(2, money);
                psql.setString(3, region);
                psql.setString(4, degree);
                psql.setString(5, comName);
                psql.setString(6, type);
                psql.setString(7, date);
                psql.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }finally{
                jdbc_connection.release(psql,conn);
            }




            StringBuilder job=new StringBuilder();


            job.append(jobName).append("\t").append(money).append("\t").append(region).append("\t").append(degree).append("\t").append(comName).append("\t").append(type).append("\t").append(date);
            logger.info(job.toString());
        }
    }

    public static void main(String[] args) {
        Spider spider = new Spider();
        int i=0;
        for(i=0;i<10;i++) {
            spider.curPage = i;
            spider.requestData();
        }


    }

}
