<template>
    <div class="tile">
        {{ this.observation.name }}
        {{ this.observation.value }}
    </div>
</template>

<script>
  export default {
      name: 'Observation',
      props: ['observation'],
  }
</script>