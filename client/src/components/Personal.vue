<template>
  <div class="container">
      <div class="notification">
          <p class="title">PatientVue</p>
          <div class="content" v-if="this.personalDetails">
              <div class="tile is-primary">
                <p>{{ this.personalDetails.forename }} {{ this.personalDetails.surname }}</p>
                <p>{{ this.personalDetails.dateOfBirth }}</p>
                {{ this.personalDetails.email }}
              </div>
          </div>

          <p class="title">Groups</p>
          <div class="tile" v-if="personalDetails">
              <p v-for="group in personalDetails.groupRoles"
                :key="group.id">
                {{ group.group.name }}
              </p>
          </div>
      </div>
      <div class="tile is-parent">
          <article class="tile is-child notification is-success">
              <div class="content">
                  <p class="title">
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