# Java高级应用



## Log4j



- log4j日志输出格式一览：



1. %c:  输出日志信息所属的类的全名
2. %d:  输出日志时间点的日期或时间，默认格式为ISO8601，也可以在其后指定格式，比如：%d{yyy-MM-dd HH:mm:ss }，输出类似：2002-10-18- 22：10：28
3. %f:  输出日志信息所属的类的类名
4. %l:  输出日志事件的发生位置，即输出日志信息的语句处于它所在的类的第几行
5. %m:  输出代码中指定的信息，如log(message)中的message
6. %n:  输出一个回车换行符，Windows平台为“rn”，Unix平台为“n”
7. %p:  输出优先级，即DEBUG，INFO，WARN，ERROR，FATAL。如果是调用debug()输出的，则为DEBUG，依此类推
8. %r:  输出自应用启动到输出该日志信息所耗费的毫秒数
9. %t:  输出产生该日志事件的线程名



- 所以：

%5p [%t] (%F:%L) - %m%n 就表示
宽度是5的优先等级 线程名称 (文件名:行号) - 信息 回车换行

