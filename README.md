# spring boot 入门及值得注意的知识点
    1、在ide(idea或eclipse)里面启动main函数和java -jar xxx.jar方式启动main函数，整体的启动流程完全不一样。
    
    2、mvnw 是 maven wrapper的简写，表示当前OS没有安装maven可以通过mvnw进行下载安装，只要执行命令
    ./mvnw clean install 即可，它会自动下载最新版本来执行，如果有了maven的安装就可以删掉这个文件
    
    3、spring boot如何进行统一版本管理，有两种方式：(1) parent、(2) dependencyManagement
        parent的方式：一般来说，在大型的公司里项目都使用自己的parent,但是又想用springboot的parent进行统一管理，
        parent只能有一个，maven不支持多个parent，所以springboot能通过dependencyManagement进行多依赖统一管理。
        
        parent：类似于java中的extends，只能实现单继承一个意思
        dependencyManagement：类似于java中的implement，可以多实现一个道理
        举个例子：现在我既要依赖spring boot的版本控制又要依赖spring cloud的版本，那只能通过dependencyManagement进行管理了
        总结：推荐使用dependencyManagement方式
        
    4、如果使用war包部署的话，application是需要继承SpringBootServletInitializer
    
    5、推荐使用yaml,因为默认的properties需要写更多的前缀  
    
    6、使用java -jar xxx.jar的方式启动项目的情况下，可以通过--sping.profiles.active=xxx来选择配不同的配置文件
    
    7、springboot提供一个插件，热更新插件，修改完成代码不需要进行重启，springboot会自动加载修改的文件
       shift+ctrl+alt+/
       
    8、数据库连接池由默认的tomcat-jdbc换成Hikaricp连接池
    
# maven的一些知识点
    1、maven的生命周期是：compile(编译)、package(打包)、install(把打好的包安装到本地仓库)、deploy(把打好的包安装到本地仓库并上传到maven的服务器)
    
    2、maven scope含义的说明
        2.1、compile （编译范围）
        compile是默认的范围；如果没有提供一个范围，那该依赖的范围就是编译范围。编译范围依赖在所有的classpath 中可用，同时它们也会被打包。
        
        2.2、provided （已提供范围）
            provided 依赖只有在当JDK 或者一个容器已提供该依赖之后才使用。例如， 如果你开发了一个web 应用，你可能在编译 classpath 中需要可用的Servlet API 来编译一个servlet，
            但是你不会想要在打包好的WAR 中包含这个Servlet API；这个Servlet API JAR 由你的应用服务器或者servlet 容器提供。已提供范围的依赖在编译classpath （不是运行时）可用。它们不是传递性的，也不会被打包。
        2.3、runtime （运行时范围）
            runtime 依赖在运行和测试系统的时候需要，但在编译的时候不需要。比如，你可能在编译的时候只需要JDBC API JAR，而只有在运行的时候才需要JDBC
            驱动实现。
        2.4、test （测试范围）
            test范围依赖 在一般的编译和运行时都不需要，它们只有在测试编译和测试运行阶段可用。
        2.5、system （系统范围）
            system范围依赖与provided 类似，但是你必须显式的提供一个对于本地系统中JAR 文件的路径。这么做是为了允许基于本地对象编译，而这些对象是系统类库的一部分。这样的构件应该是一直可用的，Maven 也不会在仓库中去寻找它。
            如果你将一个依赖范围设置成系统范围，你必须同时提供一个 systemPath 元素。注意该范围是不推荐使用的（你应该一直尽量去从公共或定制的 Maven 仓库中引用依赖）。

# idea中使用lombok插件的安装方法
    依次点击工具栏上的File ---> Settings --->Plugins 
    点击Browse repositories
    输入lombok Plugin
    然后点击 Install plugin,
    安装完后会自动提示你是否重新启动，
    重启后生效
    
# 日志管理
    1、外观组件： slf4j-api, Facade, 门面模式， 日志系统标准。
    2、具体的实现组件： log4j, logback, log4j2目前比较流行的日志框架
    3、application --> slf4j-api --> log4j/logback(springboot默认的日志框架)/log4j2
    
    appender用来把日志发送到指定的地方（console(std-out,std-err), file, rsyslog）
    layouts用来确定日志的前缀格式
        
    