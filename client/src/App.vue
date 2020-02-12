<template>
    <div id="app">
        <div class="container">
            <div class="notification">
                <div class="tile">
                    <article class="tile is-child notification is-info">
                        <div class="content">
                            <p class="title">
                                PatientVue
                            </p>
                        </div>
                    </article>
                </div>
                <Personal :personalDetails="personalDetails"/>
                <div class="medications box">
                    <Medication/>
                </div>
                <div class="box">
                    <p class="title">Results</p>
                    <Observation v-if="recentObservations && recentObservations.CREATININE"
                        :observation="recentObservations.CREATININE[0]"/>

                    <Observation v-if="recentObservations && recentObservations.POTASSIUM"
                        :observation="recentObservations.POTASSIUM[0]"/>

                    <Observation v-if="recentObservations && recentObservations.UREA"
                        :observation="recentObservations.UREA[0]"/>

                    <Observation v-if="recentObservations && recentObservations.WEIGHT"
                        :observation="recentObservations.WEIGHT[0]"/>
                </div>
                <Footer/>
            </div>
        </div>
    </div>
</template>

<script>
    import axios from 'axios';
    import Personal from './components/Personal.vue';
    import Medication from './components/Medication.vue';
    import Observation from './components/Observation.vue';
    import Credentials from './config/Credentials.json';
    import Footer from './components/Footer.vue';

    export default {
        name: 'app',
        components: {
            Personal,
            Medication,
            Observation,
            Footer
        },
        data: function() {
            return {
                personalDetails: null,
                recentObservations: null,
                observations: [],
            }
        },
        created(){
            this.SERVER_URL = "http://localhost:8080";

            this.loadBasicInfo();
            this.loadObservations();
        },
        methods:{
            loadBasicInfo(){
                const instance = axios.create({
                  baseURL: this.SERVER_URL,
                  timeout: 10000
                });
                instance.get(this.SERVER_URL + `/basicuserinformation`)
                    .then(response => {
                        this.personalDetails = response.data;
                    })
                    .catch(error => {
                        window.console.log(error);
                    });
            },
            loadObservations(){
                const instance = axios.create({
                  baseURL: this.SERVER_URL,
                  timeout: 10000
                });
                instance.get(this.SERVER_URL + `/patient/${this.userId}/observations`)
                    .then(response => {
                        this.observations = response.data.data;

                        this.recentObservations = this.observations[Object.keys(this.observations)[0]];
                    })
                    .catch(error => {
                        window.console.log(error);
                    });
            }
        },
        computed: {
            userId(){
                return Credentials.userId;
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
    }
</style>
