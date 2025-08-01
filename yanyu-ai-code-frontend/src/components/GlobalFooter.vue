<template>
  <a-layout-footer class="footer">
    <div class="footer-content">
      <p>
        2025 烟雨 <span style="margin: 0 10px"></span>
        <a href="https://beian.miit.gov.cn/" target="_blank" class="footer-link">© 蜀ICP备2025143784号-1</a>
      </p>
    </div>
  </a-layout-footer>
</template>

<script setup lang="ts">
// 无需额外的响应式数据
</script>

<style scoped>
.footer {
  background: #efefef;
  text-align: center;
  padding: 20px;
  position: fixed;
  bottom: 0;
  left: 0;
  right: 0;
}

.footer-content {
  position: relative;
  z-index: 4;
  padding: 2px 0;
}

.footer-content p {
  color: #8d8a8a;
  margin-bottom: 1px;
  font-size: 12px;
  line-height: 1.2;
}

.footer-link {
  color: #8d8a8a !important; /* 默认灰色 */
  text-decoration: none; /* 可选：去掉下划线 */
  transition: color 0.3s; /* 平滑过渡效果 */
}

.footer-link:hover {
  color: #1890ff !important; /* 悬停时变为蓝色（Ant Design 主题色） */
}

.copyright {
  margin: 0;
  color: #666;
  font-size: 14px;
}
</style>
