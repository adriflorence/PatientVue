<template>
    <div class="content" v-if="personalDetails">
        <div class="box">
            <p>{{ this.personalDetails.forename }} {{ this.personalDetails.surname }}</p>
            <p>{{ this.personalDetails.dateOfBirth }}</p>
            <p>{{ this.personalDetails.email }}</p>
        </div>

        <div class="box" v-if="personalDetails">
            <span class="tag is-info" v-for="group in personalDetails.groupRoles"
                :key="group.id">
                {{ group.group.shortName }}
            </span>
        </div>
  </div>
</template>

<script>
  export default {
      name: 'Personal',
      props: ['personalDetails'],
  }
</script>

<style>
    .tag {
        margin: 0.5em;
    }
</style>