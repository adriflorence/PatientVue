<template>
  <div id="app">
    <div class="personalDetails" v-if="this.personalDetails">
         <h1>PatientVue</h1>
          <section class="box">
              {{ this.personalDetails.forename }}
              {{ this.personalDetails.surname }}
              {{ this.personalDetails.dateOfBirth }}
          </section>
          <section>
            <label>Groups</label>
                <p v-for="group in personalDetails.groupRoles"
                :key="group.id">
                    {{ group.group.name }}
                </p>
          </section>
      </div>
  </div>
</template>

<script>
    import axios from 'axios';

    export default {
        name: 'app',
        data: function() {
            return {
                personalDetails: null,
            }
        },
        created(){
            this.loadBasicInfo();
        },
        methods:{
            loadBasicInfo(){
            const SERVER_URL = 'http://localhost:8080';
            const instance = axios.create({
              baseURL: SERVER_URL,
              timeout: 10000
            });
            instance.get(SERVER_URL + `/basicuserinformation`)
                .then(response => {
                    this.personalDetails = response.data;
                })
                .catch(error => {
                    window.console.log(error);
                });
            }
        }
    }

</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
