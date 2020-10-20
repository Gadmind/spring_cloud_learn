# spring_cloud_learn_note
版本要求

```
java: 8
maven: 3.5及以上
mysql：5.7及以上
spring-cloud-version: Hoxton.SR8
spring-boot-version: 2.3.3.RELEASE
spring-cloud-alibaba-version: 2.2.1.RELEASE
```

**服务注册与发现之Eureka**

什么是服务治理？

SpringCloud封装了Netflix公司开发的Eureka模块来实现服务治理

在传统RPC远程调用框架中，管理每个服务与服务之间依赖关系比较复杂，管理比较复杂，所以就需要服务治理，管理服务与服务之间的依赖关系，可以实现服务调用、负载均衡、容错等，实现服务发现与注册

什么是服务注册与发现？

Eureka采用了CS的设计架构，EurekaServer作为服务注册功能的服务器，它是服务注册中心，而系统中的其他微服务，使用Eureka的客户端连接到Eureka Server并维持心跳连接，这样系统维护人员可以通过EurekaServer来监控系统中各个微服务是否正常运行。

在服务注册与发现中，有一个注册中心。当服务其启动的时候，会把当前自己服务器的信息，比如，服务器地址通讯地址等以别名方式注册到注册中心上。另一方（消费者|服务提供者），以该别名的方式去注册中心上获取到实际的服务通讯地址，然后在实现本地RPC调用RPC远程调用框架核心设计思想：在于注册中心，因为使用注册中心管理每个服务与服务之间的一个依赖关系（服务治理概念）。在任何RPC远程框架中，都会有一个注册中心（存放服务地址相关信息（接口地址））

Eureka包含两个组件：EurekaServer和EurekaClient

- Eureka Server提供服务注册服务

  各个微服务几点通过配置启动后，会在Eureka Server中进行注册，这样EurekaServer中的服务注册表中将会存储所有可用服务节点的信息，服务节点的信息可以在界面中直观看到

- Eureka Client通过注册中心进行访问

  是一个Java客户端。用于简化EurekaServer的交互，客户端同时也具备一个内置的、使用轮询（round-robin）负载算法的负载均衡器。在应用启动后，回向EurekaServer发送心跳（默认周期30秒）。如果EurekaServer在多个心跳周期内没有接收到某个节点的心跳。EurekaServer会将这个服务从服务注册表中移除（默认90秒）

服务注册：将服务信息注册进注册中心；服务发现：从注册中心上获取服务信息；实质：存key服务名，取value调用地址

ServicePovider：先启动Eureka注册中心；启动服务提供者；服务提供者七佛那个后会把自身信息（如服务地址以别名方式注册进Eureka）；消费者服务在需要调用接口时，使用服务别名去注册中心，获取实际的RPC远程调用地址；消费者获取调用地址之后，底层使用HttpClient技术实现远程调用；消费者获得服务地址后会缓存在本地JVM内存中，默认每间隔30秒更新一次服务调用地址。

> 在`C:\Windows\System32\drivers\et`目录下修改hosts文件配置Eureka集群
>
> ```
> #######SpringCloud################
> 127.0.0.1       eureka7001.com
> 127.0.0.1       eureka7002.com
> 127.0.0.1       eureka7003.com
> ```

服务发现Discovery

Eureka自我保护

出现这样一段话**EMERGENCY! EUREKA MAY BE INCORRECTLY CLAIMING INSTANCES ARE UP WHEN THEY'RE NOT. RENEWALS ARE LESSER THAN THRESHOLD AND HENCE THE INSTANCES ARE NOT BEING EXPIRED JUST TO BE SAFE.**

某一时刻某一服务不可用了，Eureka不会立即清除，依旧会对该服务的信息进行保存，属于CAP理论中的AP分支

为什么会产生Eureka自我保护机制？

为了防止EurekaClient可以正常运行，但是与EurekaServer网络不通情况下，EurekaServer不会立刻将EurekaClient服务器剔除

什么是自我保护模式？

默认情况下，如果EurekaServer在一定时间内没有接收到某个微服务实例的心跳，EurekaServer将会注销该实例（默认90秒）。但是当网络分区故障发生时（延时、卡顿、拥挤）时，微服务与Eureka Server之间无法正常通信，以上行为可能变得非常危险了——因为微服务本身是健康的，此时不应该注销这个微服务。Eureka通过“自我保护模式”来解决这个问题——当EurekaServer节点在短时间内丢失过多客户端时（可能发生了网络分区故障）那么这个节点就会进入自我保护模式

在自我保护模式中，EurekaServer会保护服务注册表中的信息，不在注销任何服务实例，它的设计就是宁可保留错误的服务注册信息，也不盲目的注销任何可能健康的服务实例，

自我保护模式是一种应对网络异常的安全保护措施。它的架构哲学是宁可同时保留所有微服务（健康的微服务和不健康的微服务都会保留）也不盲目注销任何健康的微服务，使用自我保护模式，让Eureka集群更加健壮，稳定