<template lang="html">
  <div class="">
    <h1>Testing api</h1>
    <h2>Fileupload</h2>
    <FileUploader />
    <h2>Posting posts</h2>
    <PostPoster />
  </div>
</template>

<script>
export default {
  name: 'About',
  components: {
    FileUploader: () => import('./../components/FileUploader.vue'),
    PostPoster: () => import('./../components/PostPoster.vue')
  }
}
</script>

<style lang="css" scoped>
</style>
