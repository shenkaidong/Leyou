# Leyou Mall Readme

[![standard-readme compliant](https://img.shields.io/badge/leyou%20springboot-microservice-brightgreen.svg?style=flat-square)](https://github.com/KaidongShen/Leyou)
[![standard-readme compliant](https://img.shields.io/badge/itheima%20官网-黑马程序员-brightgreen.svg?style=flat-square)](http://www.itheima.com/)
[![standard-readme compliant](https://img.shields.io/badge/boxuegu%20官网-博学谷-brightgreen.svg?style=flat-square)](https://www.boxuegu.com/)

Microservice Mall Project Introduction

Microservice mall project. This project comes from the free resources of bilibili Ithema Programmer Network, Leyou Mall Huge MAC version, and a virtual machine is required in the middle. For more information, please visit the official homepage of Ithema Programmer and Learn Valley. I passed the online tutorial, Learn technologies such as Springboot, SpringCloud, Redis, Elasticsearch, Nginx, etc. used in the microservice system.

This repository contains the following:

1. The whole project of leyou backend microservice-[Leyou backend](spec.md).  
2. leyou-manage-web background management front-end project-[Leyou management front-end](https://github.com/KaidongShen/Leyou/tree/master/leyou-manage-web).  
3. leyou-portal Portal - [Leyou Portal](https://github.com/KaidongShen/Leyou/tree/master/leyou-portal).  
4. es-demo-[Elasticsearch-demo](https://github.com/KaidongShen/Leyou/tree/master/es-demo).  
5. itcast-rabbitmq-[rabbitmq-demo](https://github.com/KaidongShen/Leyou/tree/master/itcast-rabbitmq).  
6. redis-demo-[redis-demo](https://github.com/KaidongShen/Leyou/tree/master/redis-demo).   
6. dysms-demo-[alibabacloud-dysms-demo](https://github.com/KaidongShen/Leyou/tree/master/dysms-demo).    

## Content list

- [Background](#Background)  
- [Install](#install)  
- [Maintainer](#Maintainer)  
- [Contributors](#Contributors)  
- [license](#License)  

## Background  

`Leyou Mall` was originally a micro-service project I saw from station B. There are a lot of online materials, so I started to learn. But I found a lot of inconvenience in learning. First of all, there are many online versions, and some versions need to be used Virtual machine, some versions only use windows system. And the notes and videos do not match. For example, when writing the product details page. I encountered a lot of unexpected problems. The front-end code of the product details page is very different from the video. There are still errors in the found version. All kinds of software need to be deployed in the Linux system. For example, when installing Redis, because CentOS6.4 has stopped maintenance, the mirror file cannot be used, and the mirror address in CentOS6.4 is required. Elasticsearch During the installation, it is necessary to update the Java version in CentOS and other issues.  

Even though there are many problems, I still benefit a lot. This is my first microservice project. I will complete my code in this directory and add comments to the project. I will add more information about this project in the future. Notes and some of my own thoughts on the project.  

# 1. Introduction of Leyou Mall  

## 1.1. Project introduction  

- Leyou Mall is a full-category e-commerce shopping website (B2C).  
- Users can buy products online, add to shopping carts, place orders, and instantly kill products  
- You can comment on purchased items  
- Administrators can manage the removal and sale of products and promotions in the background  
- Admin can monitor product sales status  
- Customer service can process refunds in the background  
- Hope to support tens of millions of users in the next 3 to 5 years  



## 1.2. System Architecture  

### 1.2.1. Architecture diagram  

DevOps

![lysc.png](assets/lysc.png)


nginx load balancing  

CDN  

### 1.2.2. Interpretation of system architecture  

The entire Leyou Mall can be divided into two parts: the background management system and the front-end portal system.  

- Backstage management:  

  - The background system mainly includes the following functions:  
    - Commodity management, including the management of commodity classification, brand, commodity specifications and other information  
    - Sales management, including order statistics, order refund processing, promotions generation, etc.  
    - User management, including user control, freezing, unlocking, etc.  
    - Authority management, authority control of the entire website, using the JWT authentication scheme to control the authority of users and APIs  
    - Statistics, statistical analysis display of various data  
  - The back-end system will be developed separately from the front-end and back-end, and the entire back-end management system will use the Vue.js framework to build a single-page application (SPA).  
  - preview:  

  ![1528098418861](assets/1528098418861.png)  

- Front desk portal  

  - The front-end portal is customer-oriented and includes all functions for interacting with customers. For example:  
    - Search for products  
    - add to Shopping Cart  
    - place an order  
    - Rate items and more  
  - For the front-end system, we will use Nuxt combined with Vue to complete page development. For SEO optimization reasons, we will not use single-page applications.  

  ![1525704277126](assets/1525704277126.png)  


Both front-end and back-end systems share the same cluster of microservices, including:  

- Commodity microservices: services for commodities and commodity classification, brands, inventory, etc.  
- Search Microservice: Implement search function  
- Order Microservice: Implement order related  
- Shopping Cart Microservice: Implement shopping cart related functions  
- User Center: User login and registration functions  
- Authentication Center: User authorization and service authorization authentication  
- Eureka registry  
- Zuul gateway service  
- Spring Cloud Config Configuration Center  
- ...

## 1.3. Technical selection  

### 1.3.1. Related technologies  

Front-end technology:  

- Basic HTML, CSS, JavaScript (based on ES6 standards)  
- Vue.js 2.0 and Vue-based UI framework: Vuetify  
- Front-end build tool: WebPack  
- Front-end installation package tool: NPM  
- Vue scaffolding: Vue-cli  
- Vue routing: vue-router  
- ajax framework: axios  
- Vue-based rich text framework: quill-editor  

Backend technology:  

- Basic SpringMVC, Spring 5.0 and MyBatis3  
- Spring Boot version 2.0.1  
- Spring Cloud latest version Finchley.RC1  
- Redis-4.0  
- RabbitMQ-3.4  
- Elasticsearch-5.6.8  
- nginx-1.10.2  
- FastDFS - 5.0.8  
-MyCat  
- Thymeleaf  
- JWT  



### 1.3.2. Technical Interpretation  

The above technology combination can solve the following typical problems in e-commerce in the project:  

- Use Node.js and Vue.js technology stack to realize front-end and back-end separation development.  

- Use SpringCloud technology stack to realize real microservice development, and it is based on SpringBoot2.0 and the latest version of SpringCloud Finchley.RC1, leading the industry.  

- Close to the real e-commerce database design to solve the SPU and SKU management problems of all categories of e-commerce.    

- Solve the problem of distributed file storage with large data volume based on FastDFS.  

- Based on the advanced aggregation function of Elasticsearch, realize intelligent filtering and searching of products.  

- Based on the advanced aggregation function of Elasticsearch, realize complex statistics and report output of sales business.  

- Implement offline client shopping cart based on LocalStorage to reduce server pressure.  

- Real stateless single sign-on based on JWT technology and RSA asymmetric encryption.  

- Combine JWT and RSA asymmetric encryption, customize Feign filter to realize automatic authentication between services, and solve the security problem of external exposure of services  

- Based on Alibaba's implementation of SMS function, solve the problem of e-commerce SMS notification  

- Realize reliable message service based on RabbitMQ to solve communication problems between services  

- Realize reliable message service based on RabbitMQ to solve distributed transaction problems  

- Use WeChat SDK to realize WeChat scan code payment, in line with mainstream payment methods  

- Build a high-availability cluster based on Redis to realize reliable cache service, that is, hotspot data storage.  

  Redis persistence, cluster, sentinel, master-slave, cache breakdown, hot key.  

- Based on Redis and Mq to deal with high-availability and high-concurrency spike scenarios  

- Based on MyCat to realize the separation of reading and writing of database and sub-database and sub-table  

  post video  

- Realize page template and static based on Thymeleaf, improve page response speed and concurrency ability  

- Implement initial request load balancing and request current limiting based on Nginx  


# 2. Related items  

## 2.1. Personal introduction  

 This is my first personal microservice project. When I was writing it, I didn't know anything about practicing git, so I learned a lot through this project. The questions and the knowledge points learned will be sorted out.  

## 1.2. What is the structure of your project?  

Our entire project adopts the front-end and back-end separation development model.  

- The front end is divided into two parts:  

  - Background management: mainly for data management personnel, using the Vue-based single-page application development method  
  - Portal system: facing customers, the portal uses Vue combined with Nuxt to achieve server-side rendering  

- rear end  

  The backend adopts the SpringCloud-based microservice architecture, and provides Rest-style interfaces to the outside world. These microservice interfaces are shared by both the background management and the portal system. In the microservice, JWT is used to identify user identities and open different interfaces.  

  Let's not talk about it here. If you continue to ask about the granularity of microservice splitting or SpringCloud details, then answer our service splitting.  
 

## 1.3. How many servers do you have in your production environment?  

The plan is more than 20 units.  

devops  

32 cores 128G memory  

The entire microservice is deployed in the docker environment.  

The plan for customers is as follows: In the initial stage, except for nginx, Eureka and Zuul, other services are basically running on a single node, with about 20 servers. If the subsequent pressure is too large, you can continue to increase the node backup of some services.  


Planned number of service nodes:  

- nginx: 1 master, 1 backup  

- Eureka cluster: 2 units  
- Zuul cluster: 2 units  
- Configuration Center (ConfigServer): 1  
- RabbitMQ: 2 units  
- Redis: 3 units  
- FastDFS: 2 trackers, 2 storage  
- mysql database: 1 master, 1 backup, 2 slaves  
- elasticsearch: 3 units  

- Merchandise service: 1 unit  
- File upload service: 1 unit  
- SMS service: 2 units  
- Search service: 2 units  
- Static page service: 1 unit  
- User Center: 1  
- Authorization Center: 2  
- Cart: 1  
- Order: 2  

A total of 36 service nodes.  
 
## 1.4. The number of teams required for real development  

Forty people.  

Back-end: less than 30 people, testing: 5 people, front-end: 5 people, operation and maintenance: 3 people, product manager 3 people, project manager: 1 person.  

The back-end team is divided into 5 groups, each of which is responsible for a part of the service.  

## Install

Check with Technical Interpretation.

## Related repositories

- [ithema Programmer](https://github.com/itheima1) — 💌 ithema Programmer github.  
- [Leyou Mall project background](https://github.com/lyj8330328/leyou) — Leyou Mall project background - a very complete version, but slightly different from this version.  
- [Leyou Mall Project Background and Technical Interpretation](https://github.com/Yirito/leyou) — Leyou Mall Project Technical Interpretation-Another very complete version, but slightly different from this version.  
- [Leyou Mall Project Notes](https://shidongxu0312.github.io/2019/11/20/%E4%B9%90%E4%BC%98%E5%95%86%E5%9F%8E% E9%A1%B9%E7%9B%AE/) - Leyou Mall project notes - a very complete version, but slightly different from this version.  

## Maintainer

[@Kaidong Shen](https://github.com/KaidongShen).  

## How to contribute

You are very welcome to join us! [raise an Issue](https://github.com/KaidongShen/Leyou/issues/new) or submit a Pull Request.  

Follow the [Contributor Covenant](http://contributor-covenant.org/version/1/3/0/) code of conduct.  

### Contributors

Thanks to the following people who participated in the project:  
[@Kaidong Shen](https://github.com/KaidongShen).  


## License

[MIT](LICENSE) © Kaidong Shen  
