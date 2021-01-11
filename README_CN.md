# 微服务商城项目 Readme

[![standard-readme compliant](https://img.shields.io/badge/readme%20style-standard-brightgreen.svg?style=flat-square)](https://github.com/KaidongShen/Leyou)
[![standard-readme compliant](https://img.shields.io/badge/itheima%20官网-黑马程序员-brightgreen.svg?style=flat-square)](http://www.itheima.com/)
[![standard-readme compliant](https://img.shields.io/badge/boxuegu%20官网-博学谷-brightgreen.svg?style=flat-square)](https://www.boxuegu.com/)

微服务商城项目介绍

微服务商城项目. 本项目来自bilibili黑马程序员网络免费资源, 乐优商城虎哥MAC版, 中间需要使用虚拟机. 更多资料请访问黑马程序员官方主页和博学谷. 本人通过网上的教程, 学习微服务系统中, 所用到的如Springboot, SpringCloud, Redis, Elasticsearch, Nginx等技术.

本仓库包含以下内容：

1. leyou后端微服务全项目-[乐优后端](spec.md)。
2. leyou-manage-web后台管理前端项目-[乐优管理前端](https://github.com/KaidongShen/Leyou/tree/master/leyou-manage-web)。
3. leyou-portal门户网站-[乐优门户网站](https://github.com/KaidongShen/Leyou/tree/master/leyou-portal)。
4. es-demo-[Elasticsearch-demo](https://github.com/KaidongShen/Leyou/tree/master/es-demo)。
5. itcast-rabbitmq-[rabbitmq-demo](https://github.com/KaidongShen/Leyou/tree/master/itcast-rabbitmq)。
6. redis-demo-[redis-demo](https://github.com/KaidongShen/Leyou/tree/master/redis-demo)。
6. dysms-demo-[alibabacloud-dysms-demo](https://github.com/KaidongShen/Leyou/tree/master/dysms-demo)。


## 内容列表

- [背景](#背景)
- [安装](#安装)
- [使用说明](#使用说明)
	- [生成器](#生成器)
- [徽章](#徽章)
- [示例](#示例)
- [相关仓库](#相关仓库)
- [维护者](#维护者)
- [如何贡献](#如何贡献)
- [使用许可](#使用许可)

## 背景


`乐优商城` 最开始是从B站上看到的一个微服务项目. 网上资料很多, 所以开始着手学习. 但是在学习中发现非常多的不便. 首先网上版本众多, 有的版本需要用到虚拟机, 有的版本只用windows系统. 并且笔记和视频不配套. 比如在写商品详情页的时候. 碰到了很多意想不到的问题. 商品详情页的前端代码与视频中差别很大, 网上能找到的版本中还有报错. 各种软件都需要自己部署在Linux系统中, 比如在安装Redis的时候, 由于CentOS6.4已经停止维护, 镜像文件不能使用, Elasticsearch在安装中, 需要更新CentOS中的Java版本等问题.

即便有诸多问题, 但是我还是受益颇多. 这是我第一个微服务项目, 我会在这个目录下, 补充完整我的代码, 以及在项目中添加注释. 未来还会补充关于此项目的笔记以及我自己对这个项目的一些看法.

> 如果你的文档是完整的，那么使用你代码的人就不用再去看代码了。这非常的重要。它使得你可以分离接口文档与具体实现。它意味着你可修改实现的代码而保持接口与文档不变。

> 请记住：是文档而非代码，定义了一个模块的功能。

—— [Ken Williams, Perl Hackers](http://mathforum.org/ken/perl_modules.html#document)

写 README 从某种程度上来说相当不易，一直维护下去更是难能可贵。如果可以减少这个过程，则可以让写代码与修改代码更容易，使得是否在说明中指明一处需改有无必要更加清楚，你可以花费更少的时间来考虑是否你最初的文档是否需要更新，你可以分配更多的时间来写代码而非维护文档。

同时，标准化在某些别的地方也有好处。有了标准化，用户就可以花费更少的时间来搜索他们需要的信息，他们同时可以做一个工具来从描述中搜集信息，自动跑示例代码，检查授权协议等等。

这个仓库的目标是：

1. 一个定义良好的**规范**。在仓库中的位置是 [spec.md](spec.md)。它是一个一直在持续优化的文档，欢迎您提 Issue 讨论其中的变化。
2. 一个**示例 README**。这个 Readme 完全遵从 Standard-readme，而且在 `example-readmes` 文件夹里有更多的示例。
3. 一个**语法提示器**用来提示在 Readme 中的语法错误。请参考 [tracking issue](https://github.com/RichardLitt/standard-readme/issues/5)。
4. 一个**生成器**用来快速搭建新的 README 的框架。请参考 [generator-standard-readme](https://github.com/RichardLitt/generator-standard-readme)。
5. 一个**标识准守规范的徽章**。请参考[徽章](#徽章)。

## 安装

这个项目使用 [node](http://nodejs.org) 和 [npm](https://npmjs.com)。请确保你本地安装了它们。

```sh
$ npm install --global standard-readme-spec
```

## 使用说明

这只是一个文档包，你可以打印出 [spec.md](spec.md) 到输出窗口。

```sh
$ standard-readme-spec
# Prints out the standard-readme spec
```

### 生成器

想要使用生成器的话，请看 [generator-standard-readme](https://github.com/RichardLitt/generator-standard-readme)。
有一个全局的可执行文件来运行包里的生成器，生成器的别名叫 `standard-readme`。

## 徽章
如果你的项目遵循 Standard-Readme 而且项目位于 Github 上，非常希望你能把这个徽章加入你的项目。它可以更多的人访问到这个项目，而且采纳 Stand-README。 加入徽章**并非强制的**。 

[![standard-readme compliant](https://img.shields.io/badge/readme%20style-standard-brightgreen.svg?style=flat-square)](https://github.com/RichardLitt/standard-readme)

为了加入徽章到 Markdown 文本里面，可以使用以下代码：

```
[![standard-readme compliant](https://img.shields.io/badge/readme%20style-standard-brightgreen.svg?style=flat-square)](https://github.com/RichardLitt/standard-readme)
```

## 示例

想了解我们建议的规范是如何被应用的，请参考 [example-readmes](example-readmes/)。

## 相关仓库

- [黑马程序员](https://github.com/itheima1) — 💌 黑马程序员github。
- [乐优商城项目后台](https://github.com/lyj8330328/leyou) — 乐优商城项目后台-一个非常齐全的版本, 但与本版本有些许不同。
- [乐优商城项目后台与技术解读](https://github.com/Yirito/leyou) — 乐优商城项目技术解读-另一个非常齐全的版本, 但与本版本有些许不同。
- [乐优商城项目笔记](https://shidongxu0312.github.io/2019/11/20/%E4%B9%90%E4%BC%98%E5%95%86%E5%9F%8E%E9%A1%B9%E7%9B%AE/) — 乐优商城项目笔记-一个非常齐全的版本,但与本版本有些许不同。

## 维护者

[@Kaidong Shen](https://github.com/KaidongShen)。

## 如何贡献

非常欢迎你的加入！[提一个 Issue](https://github.com/KaidongShen/Leyou/issues/new) 或者提交一个 Pull Request。

遵循 [Contributor Covenant](http://contributor-covenant.org/version/1/3/0/) 行为规范。

### 贡献者

感谢以下参与项目的人：
[@Kaidong Shen](https://github.com/KaidongShen)。


## 使用许可

[KS](LICENSE) © Kaidong Shen
