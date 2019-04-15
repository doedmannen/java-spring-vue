<template lang="html">
  <div>
      <input type="file" name="file" multiple required>
      <button type="button" @click="uploadEvent">Click me</button>
  </div>
</template>

<script>
export default {
  name: 'FileUploader',
  methods: {
    async uploadEvent(){
      let files = document.getElementsByName('file')[0].files;
      let response;
      let data = new FormData();
      if(files){
        for(let file of files){
          data.append('files', file);
        }
        response = await fetch('/api/media',{
          method: 'POST',
          body: data
        })
        response = await response.json();
      }
      console.log(response);
    }
  }
}
</script>

<style lang="css" scoped>
</style>
