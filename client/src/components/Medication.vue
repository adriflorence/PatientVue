<template>
    <div class="tile">
        {{ formatDate(this.medication.startDate) }}
        {{ this.medication.name }}
        {{ this.medication.dose }}
    </div>
</template>

<script>
    import moment from 'moment';
    export default {
        name: 'Medication',
        props: ['medication'],
        methods: {
            formatDate(date){
                return moment(date).format("DD-MM-YYYY");
            }
        }
    }
</script>