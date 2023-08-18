<template>
  <div id="app">
      <BlogHeader />
      <div id="content" class="content">
          <router-view></router-view>
      </div>
  </div>
</template>

<script>
import BlogHeader from './components/layout/BlogHeader.vue';

export default {
  name: 'App',
  components: {
    BlogHeader,
  }
}
</script>

<style>

</style>
