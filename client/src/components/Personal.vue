<template>
  <div class="container">
      <div class="notification">
          <div class="tile is-parent">
              <article class="tile is-child notification is-success">
                  <div class="content">
                    <p class="title">
                        PatientVue
                    </p>
                  </div>
              </article>
           </div>
          <div class="content" v-if="this.personalDetails">
              <div class="tile is-primary">
                <p>{{ this.personalDetails.forename }} {{ this.personalDetails.surname }}</p>
                <p>{{ this.personalDetails.dateOfBirth }}</p>
                {{ this.personalDetails.email }}
              </div>
          </div>

          <p class="title">Groups</p>
          <div class="tile" v-if="personalDetails">
              <span class="tag is-info" v-for="group in personalDetails.groupRoles"
                :key="group.id">
                {{ group.group.shortName }}
              </span>
          </div>
      </div>
      <div class="tile is-parent">
          <article class="tile is-child notification is-success">
              <div class="content">
                  <p>
                      <a href="https://patientviewbasic.docs.apiary.io">PatientView</a>
                  </p>
              </div>
          </article>
      </div>
    </div>
</template>

<script>
  export default {
      name: 'Personal',
      props: ['personalDetails'],
  }
</script>