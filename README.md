# TikTok Clone - 抖音短视频克隆项目

一个基于Android平台开发的抖音短视频克隆应用，实现了抖音的核心功能和流畅的用户体验。

## ✨ 核心特性

### 🎬 视频播放体验
- **垂直滑动视频流** - 全屏上下滑动切换视频，流畅的过渡效果
- **智能播放控制** - 视频进入屏幕自动播放，离开自动暂停
- **高清视频播放** - 基于ExoPlayer实现高品质视频播放
- **横竖屏切换** - 一键切换横竖屏模式，横屏时自动隐藏导航栏
- **封面图优化** - 视频加载前显示封面，第一帧渲染后自动隐藏
- **播放进度显示** - 实时显示视频播放进度

### 💬 社交互动功能
- **点赞动画** - 带有爱心动画效果的点赞/取消点赞
- **评论系统** - 底部弹出评论对话框，支持查看和发表评论
- **分享功能** - 多渠道分享选项，轻松分享精彩内容
- **关注机制** - 支持关注/取关用户，关注状态实时同步
- **头像导航** - 点击头像直接进入用户个人主页
- **状态同步** - 关注状态在视频页面和个人主页间实时更新

### 🎨 精美的UI设计
- **底部导航栏** - 完整的功能导航体系
- **动态UI适配** - 根据横竖屏状态智能显示/隐藏UI元素
- **折叠个人主页** - 使用CoordinatorLayout实现优雅的折叠效果
- **流畅动画** - 采用Lottie库实现精美动画效果
- **响应式设计** - 适配不同屏幕尺寸

## 🛠️ 技术栈

- **开发语言**: Kotlin
- **基础框架**: AndroidX
- **视频播放**: ExoPlayer
- **UI组件**: RecyclerView, ViewPager2, CoordinatorLayout, AppBarLayout
- **事件总线**: RxBus
- **动画效果**: Lottie
- **依赖注入**: 手动依赖管理
- **构建工具**: Gradle

## 📱 安装与运行

### 环境要求
- Android Studio 4.0+
- Android SDK 21+
- Kotlin 1.5+

### 安装步骤
1. 克隆项目到本地
   ```bash
   git clone https://github.com/your-username/tiktok-clone.git
   ```

2. 打开Android Studio，导入项目

3. 同步Gradle依赖

4. 运行项目到模拟器或真实设备

## 📁 项目结构

```
├── app/src/main/
│   ├── java/com/bytedance/tiktok/
│   │   ├── activity/          # 主活动类
│   │   ├── adapter/           # 适配器类
│   │   ├── base/              # 基础类
│   │   ├── bean/              # 数据模型
│   │   ├── fragment/          # 碎片页面
│   │   ├── player/            # 视频播放器
│   │   ├── utils/             # 工具类
│   │   └── view/              # 自定义视图
│   ├── res/                   # 资源文件
│   │   ├── drawable/          # 图片资源
│   │   ├── layout/            # 布局文件
│   │   ├── mipmap/            # 图标资源
│   │   └── values/            # 配置文件
│   └── AndroidManifest.xml    # 应用配置
└── build.gradle               # 构建配置
```

## 🚀 核心功能实现

### 垂直滑动视频流
使用RecyclerView结合PagerSnapHelper实现全屏垂直滑动效果，每个视频占满整个屏幕，滑动时平滑切换。

### 智能播放控制
监听ViewPager2的页面变化事件，在视频进入屏幕中心时自动播放，离开时自动暂停，优化用户体验和性能。

### 横竖屏切换
通过点击全屏按钮触发横竖屏切换，横屏模式下自动隐藏导航栏和搜索图标，提供沉浸式观影体验。

### 关注状态同步
实现了跨页面的关注状态同步机制，在视频页面关注/取关用户后，个人主页的关注状态会实时更新，确保数据一致性。

### 折叠个人主页
使用CoordinatorLayout和AppBarLayout实现个人主页的折叠效果，滚动时背景图和个人信息区域平滑过渡。

## 📸 功能截图

| 视频播放页 | 个人主页 | 评论功能 |
|-----------|---------|---------|
| ![Video Playback](https://upload-images.jianshu.io/upload_images/8669504-e0830fc715f87cb2.gif) | ![Personal Home](https://upload-images.jianshu.io/upload_images/8669504-ca63d12612869f5d.gif) | ![Comments](https://upload-images.jianshu.io/upload_images/8669504-edd6777f1ba8733a.gif) |

## 🎯 项目亮点

1. **流畅的用户体验** - 优化了视频加载、播放和切换的性能，确保流畅的用户体验
2. **完整的功能体系** - 实现了抖音的核心功能，包括视频播放、社交互动、个人主页等
3. **优秀的代码架构** - 清晰的代码结构和模块化设计，便于维护和扩展
4. **精美的UI设计** - 注重细节和动画效果，提供视觉愉悦的用户体验
5. **良好的可扩展性** - 代码结构设计便于添加新功能和扩展现有功能

## 📝 数据说明

由于没有真实的后端接口，项目使用本地资源模拟视频数据。视频和图片资源存储在项目中，通过DataCreate类构造视频列表数据。

## 🤝 贡献

欢迎提交Issue和Pull Request来帮助改进这个项目！

## 📄 许可证

本项目采用MIT许可证，详情请查看[LICENSE](LICENSE)文件。

## 📧 联系方式

如有问题或建议，欢迎通过以下方式联系：
- GitHub: [your-username](https://github.com/your-username)
- Email: your-email@example.com

## 📱 体验下载

你可以通过以下链接下载APK文件体验：

[下载APK](https://example.com/tiktok-clone.apk)

---

**温馨提示**：本项目仅供学习和研究使用，请勿用于商业用途。

如果这个项目对你有帮助，请给个⭐️支持一下！