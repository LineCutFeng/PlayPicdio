PlayPicdio
-----
简书：
</br>
https://www.jianshu.com/p/a14f1ac558e1
</br>
csdn：
</br>
https://blog.csdn.net/u010308894/article/details/82689023

简介
-----
android平台下 视频转ascii码视频、图片转ascii码图片、图片转低多边形风格图片、图片emoji-masaic化
（未来功能，图片转彩色ascii码图片、图片添加新海诚风格滤镜、图片人工智能风格迁移世界名画、人脸替换融合）

![GitHub](https://img.shields.io/github/license/thirdegg/lint-rules.svg)
[![LICENSE](https://img.shields.io/badge/license-Anti%20996-blue.svg)](https://github.com/996icu/996.ICU/blob/master/LICENSE)
[![Badge](https://img.shields.io/badge/link-996.icu-red.svg)](https://996.icu/#/zh_CN)

技术概要
-----
- 像素彩色转灰度
- 二元一次方程求像素最佳解
- ndk sobel特征提取
- delaunay三角形匹配
- 泊松分布随机采样,4叉数优化
- ffmpeg图片合成视频
- 柏林噪声生成背景
- LRUcache图片缓存池匹配
- 快速傅里叶变换、快速傅里叶逆变换
- L0Smooth范式平滑
- 边缘抖动
- 颜料分散
- 纸张纹理

功能
----
ascii
- 图片转ascii码图片(彩色or黑白)
- 视频转ascii码视频或gif(彩色or黑白)

低多边形化
- 图片转低多边形

emoji-mosaic
- emoji表情替换图片像素

单一滤镜
- 底片效果
- 熔铸效果
- 冰冻效果
- 连环画效果
- 褐色效果（怀旧效果）
- 瓷砖滤镜
- 同心圆效果（待优化）
- 幻影坦克（module未集成到主app）

因为完整效果图片尺寸过大，所以实例图片经过了高度压缩，完整效果参见博客

ascii码效果图
-----
<img src="https://github.com/GodFengShen/PicOrVideoToAscii/blob/master/pic/ascii1.png" width=200 height=340/>&nbsp;&nbsp;&nbsp;
<img src="https://github.com/GodFengShen/PicOrVideoToAscii/blob/master/pic/ascii2.webp" width=200 height=340/>&nbsp;&nbsp;&nbsp;
<img src="https://github.com/GodFengShen/PicOrVideoToAscii/blob/master/pic/ascii3.webp" width=200 height=340/>&nbsp;&nbsp;&nbsp;

低多边形效果图
-----
<img src="https://github.com/GodFengShen/PicOrVideoToAscii/blob/master/pic/lowpoly3.webp" width=200 height=340/>&nbsp;&nbsp;&nbsp;
<img src="https://github.com/GodFengShen/PicOrVideoToAscii/blob/master/pic/lowpoly4.webp" width=200 height=340/>&nbsp;&nbsp;&nbsp;
<img src="https://github.com/GodFengShen/PicOrVideoToAscii/blob/master/pic/lowpoly6.webp" width=200 height=340/>&nbsp;&nbsp;&nbsp;
<img src="https://github.com/GodFengShen/PicOrVideoToAscii/blob/master/pic/lowpoly7.webp" width=200 height=340/>&nbsp;&nbsp;&nbsp;

瓷砖效果图
-----
<img src="https://github.com/GodFengShen/PicOrVideoToAscii/blob/master/pic/tilerefect1.webp" width=200 height=340/>&nbsp;&nbsp;&nbsp;

emoji-masic效果图
-----
<img src="https://github.com/GodFengShen/PicOrVideoToAscii/blob/master/pic/emoji1.webp" width=200 height=340/>&nbsp;&nbsp;&nbsp;
<img src="https://github.com/GodFengShen/PicOrVideoToAscii/blob/master/pic/emoji2.webp" width=200 height=340/>&nbsp;&nbsp;&nbsp;
<img src="https://github.com/GodFengShen/PicOrVideoToAscii/blob/master/pic/emoji5.webp" width=200 height=340/>&nbsp;&nbsp;&nbsp;
<img src="https://github.com/GodFengShen/PicOrVideoToAscii/blob/master/pic/emoji6.webp" width=200 height=340/>&nbsp;&nbsp;&nbsp;

光盘效果图
-----
<img src="https://github.com/GodFengShen/PicOrVideoToAscii/blob/master/pic/circleLine1.webp" width=200 height=340/>&nbsp;&nbsp;&nbsp;

ascii码视频
-----
<img src="https://github.com/GodFengShen/PicOrVideoToAscii/blob/master/pic/lqd.gif" width=300 height=150/>
