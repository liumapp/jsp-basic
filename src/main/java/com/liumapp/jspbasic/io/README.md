# 编码

直接运行Encode类的main方法即可查看相关示例

* gbk : 一个英文一个字节，一个中文两个字节

* utf-8 : 一个英文一个字节，一个中文三个字节

* utf-16be : 一个中文占用两个字节，一个英文占用两个字节



# File类

主要用于表示文件或者目录。如表示文件（目录）的信息（名称、大小等），不能用于文件内容的访问。

FileDemo演示了它的简单操作，FileUtil则是遍历一个目录下的所有文件及目录的示范。

FileDemo直接运行即可，FileUtil需要通过JUnit下的FileUtilTest来测试。

# RandomAccessFile

直接运行RafDemo的main方法即可查看相关示例。

对文件内容的访问类，可以对文件进行读写操作，也可以访问文件的任意位置。

对于java而言，在硬盘上的文件都是byte存储的，他们是一个数据的集合。打开文件，有两种模式：

* rw : 读写
* r : 只读

打开文件：

	RandomAccessFile raf = new RandomAccessFile(file , "rw");
	
另外因为RandomAccessFile可以访问文件的任意位置，所以在打开文件的时候，会有一个指针pointer＝0，表示默认指向开头。随着读写操作的进行，这个pointer将会进行移动。

写文件：

	raf.write(int);//只写一个字节（后8位），同时指针指向下一个位置，准备再次写入。
	
读文件：

	int b = raf.read();//读一个字节
	  
文件读写以后一定要关闭文件：

	raf.close();

# 字节流&字符流

相关代码主要在FileUtil下，它的测试运行要通过JUnit的FileUtilTest来进行。

### 字节流

* 主要继承于两个抽象类InputStream、OutputStream
		InputStream抽象了应用程序读取数据的方式
		OutputStream抽象了应用程序写出数据的方式

* EOF = End 读到－1就表示都到结尾

* 一些输入流的基本方法：
	
	int b = in.read();//读取一个字节无符号填充到int低八位，-1为EOF
	in.read(byte[] buf) //读取数据到buf数组中
	in.read(byte[] buf , int start , int size )//读取数据到字节数组buf，从buf的start位置开始存放size长度的数据

* 一些输出流的基本方法：

	out.write(int b ) //写出一个byte到流，b的低八位
	out.write(byte[] buf) //将buf字节数组都写入到流
	out.write(bute[] , int start , int size) //字节数组buf从start位置开始写size长度的字节到流
	
* FileInputStream: 具体实现了在文件上的读取数据

* FileOutputStream: 具体实现向文件中写出byte数据的方法

	FileInputStream和FileOutputStream的具体使用在jspbasic这个项目里的com.liumapp.jspbasic.io.IOUtil这个类下，相关测试请见test目录下的对应junit测试类
	
* DataOutputStream和DataInputStream

	对“流”功能的扩展，可以更加方便的读取int，long，字符等类型的数据。

	  * DataOutputStream
	  
		writeInt()/writeDouble()/writeUTF()  (装饰模式)


* 字节缓冲流 BufferedInputStream & BufferedOutputStream

	这两个流类为IO提供了带缓冲区的操作，一般打开文件进行写入或读取操作时，都会加上缓冲，这种流模式提高了IO的性能。从应用程序中把输入放入文件，相当于把一缸水倒入另一缸水中。
	
	FileOutputStream->write()方法相当于一滴一滴地把水“转移”过去。DataOutputStream->writeXxx()方法会方便一些（writeInt一下就写了四个字节，writeDouble一下就写了八个字节）,它相当于一瓢一瓢地“转移”。
	
	BufferedOutputStream->write()方法更方便，相当于一瓢一瓢先放入一个“桶”，再把“桶”里面地水导入另外一个水缸。
	 
### 字符流

* 编码问题

* 认识文本和文本文件

    java的文本（char）是16位的无符号整数，是字符的unicode编码（双字节编码）
    
    文件是byte byte byte ... 的数据序列

    文本文件是文本（char）序列按照某种编码方案（utf-8 , utf-16be , gbk）序列化为byte的存储

* 字符流 (Reader Writer)

    操作的是文本文件

    字符的处理，一次处理一个字符
    
    字符的底层依然是基本的字节序列

* 字符流的基本实现
    
    InputStreamReader 完成byte流解析为char流，按照编码解析。
    OutputStreamWriter 提供char流到byte流，按照编码处理。

* 字符流的过滤器

    BufferedReader -> readLine 一次读一行
    BufferedWriter/PrintWriter 写一行

# 对象的序列化和反序列化

直接运行ObjectSerializable来查看示例。

* 将object对象转换成byte序列，反之则叫对象的反序列化

* 序列化流（ObjectOutputStream），是过滤流－－－writeObject

    反序列化流（ObjectInputStream）--- readObject

* 序列化接口（Serializable）

    对象必须实现序列化接口，才能进行序列化，否则将出现异常。
    
    这个接口，没有任何方法，只是一个标准。

* transient关键字

    可以提升性能
    
    详情需要去了解ArrayList源码中序列化和反序列化的问题

* 序列化中子类和父类构造函数的调用

    对子类进行序列化操作时，如果其父类实现了序列化接口，那么父类的构造函数将被调用。
    
    对子类进行反序列化操作时，如果其父类没有实现序列化接口，那么父类的构造函数将被调用。
