medicine-cloud
==============

系统建立在akka 2.3.8版本基础之上。
对外提供restful访问(jboss-resteasy)，对外提供批量数据加载，和数据展示功能。
系统采用akka-cluster构建， 工作节点使用cluster-pool方式动态创建。



scale-out模式下配置的启动参数如下：
java -Xms2048m -Xmx2048m -XX:PermSize=128m -XX:MaxPermSize=256m -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps  -verbose:gc  -Xloggc:logs/gc_master.log -jar medicine-master.jar 10.1.65.104 2570 > master.log &

java -Xms2048m -Xmx2048m -XX:PermSize=128m -XX:MaxPermSize=256m -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps  -verbose:gc  -Xloggc:logs/gc_seed.log  -jar medicine-seed.jar 10.1.65.106 2551 > seed.log &

java -Xms2048m -Xmx2048m -XX:PermSize=128m -XX:MaxPermSize=256m -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps  -verbose:gc  -Xloggc:logs/gc_seed.log  -jar medicine-seed.jar 10.1.65.107 2551 > seed.log &

java -Xms2048m -Xmx2048m -XX:PermSize=128m -XX:MaxPermSize=256m -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps  -verbose:gc  -Xloggc:logs/gc_worker.log  -jar medicine-worker.jar 10.1.65.106 2580 > worker.log &

java -Xms2048m -Xmx2048m -XX:PermSize=128m -XX:MaxPermSize=256m -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps  -verbose:gc  -Xloggc:logs/gc_worker.log  -jar medicine-worker.jar 10.1.65.107 2580 > worker.log &
