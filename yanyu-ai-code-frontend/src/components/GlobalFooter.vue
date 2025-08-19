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
  background: rgba(255, 255, 255, 0.8);
  backdrop-filter: blur(10px);
  text-align: center;
  padding: 20px;
  margin-top: 40px;
  border-top: 1px solid rgba(102, 126, 234, 0.1);
}

.copyright {
  margin: 0;
  color: #666;
  font-size: 14px;
}
</style>
