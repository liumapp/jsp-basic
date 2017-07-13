# jsp-basic
jsp basic usage , just for beginers

### run by maven 

    mvn install
    
you'll see the result from your browser with thr url of http://localhost:8080/jspbasic

# 目录结构

    --com
        --liumapp
            --jspbasic
                --entity 实体类
                --filter 过滤器
                    --LoginFilter 控制登录和编码转换的过滤器，同时涉及到LoginServlet
                --listener 监听器
                --io
                    --Encode 编码的内容
                    --FileDemo java.io.File类的相关使用
                    --FileUtil java.io.File相关使用的一个工具类
                    --RafDemo RandomAccessFile对文件内容的读写操作
                    --IOUtil  字节流输入输出的相关细节
                --util
                    --Calculate 用于JUnit测试的类
                --socket
                    --详情请见socket目录下的README
                --thread
                    --线程章节，详情见thread下的README
               
                    
    --test
        --java
            --com.liumapp.jspbasic
                --util
                    --CalculateTest 对calculate这个类的测试
                --JunitFlowTest  对JUnit运行流程的测试
                --TestAll test suit的批量测试
                --ParameterTest 参数化测试
                 
                    

# 代码解析

* 监听器篇章：http://www.liumapp.com/articles/2017/06/01/1496304763265.html
* 过滤器篇章: http://www.liumapp.com/articles/2017/06/06/1496738689705.html
* JUnit篇章：http://www.liumapp.com/articles/2017/06/26/1498442810373.html

