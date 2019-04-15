<template lang="html">
  <div>
    <input type="text" name="title" />
    <input type="text" name="text" />
    <button type="button" @click="createNewPost">Send</button>
  </div>
</template>

<script>
export default {
  name: 'PostPoster',
  methods: {
    async createNewPost(){
      let data = {};
      data.title = document.getElementsByName('title')[0].value;
      data.text = document.getElementsByName('text')[0].value;
      let response = await fetch('/api/post/', {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
          "Content-Type": "application/json"
        }
      });
      console.log(await response.text());
    }
  }
}
</script>

<style lang="css" scoped>
</style>
